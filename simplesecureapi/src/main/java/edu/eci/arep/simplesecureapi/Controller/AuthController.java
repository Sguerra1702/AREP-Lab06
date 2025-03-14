package edu.eci.arep.simplesecureapi.Controller;

import edu.eci.arep.simplesecureapi.Model.User;
import edu.eci.arep.simplesecureapi.Security.JwtUtil;
import edu.eci.arep.simplesecureapi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserService userService;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/register")
    public ResponseEntity<Map<String,String>> register(@RequestBody User user) {
        // Llamamos al servicio para registrar el usuario
        userService.registerUser(user.getUsername(), user.getPassword());
        Map<String, String> response = new HashMap<>();
        response.put("message", "Registro exitoso");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User existingUser = userService.findByUsername(user.getUsername());

        if (existingUser != null && passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            // Generar token JWT si la autenticación es correcta
            String token = JwtUtil.createToken(user.getUsername(), user.getEmail());
            return ResponseEntity.ok(Collections.singletonMap("token", token));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
    }
}

