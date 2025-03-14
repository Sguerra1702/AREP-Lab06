package edu.eci.arep.simplesecureapi.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.eci.arep.simplesecureapi.Security.JwtUtil;
import java.time.LocalTime;

@RestController
@RequestMapping("/api")
public class SecureController {

    @GetMapping("/greeting")
    public ResponseEntity<String> getGreeting(@RequestHeader("Authorization") String token) {
        System.out.println("Token recibido: " + token);
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        if (!JwtUtil.validateToken(token)) {
            return ResponseEntity.status(401).body("Token inválido o expirado");
        }

        return ResponseEntity.ok("Hola, bienvenido a la API segura.");
    }

    @GetMapping("/time")
    public ResponseEntity<String> getServerTime(@RequestHeader("Authorization") String token) {
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        if (!JwtUtil.validateToken(token)) {
            return ResponseEntity.status(401).body("Token inválido o expirado");
        }

        return ResponseEntity.ok("Hora del servidor: " + LocalTime.now());
    }
}
