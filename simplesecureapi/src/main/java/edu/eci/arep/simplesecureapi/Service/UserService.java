package edu.eci.arep.simplesecureapi.Service;

import edu.eci.arep.simplesecureapi.Model.User;
import edu.eci.arep.simplesecureapi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User registerUser(String username, String password) {
        String encodedPassword = passwordEncoder.encode(password);  // Encriptamos la contraseña
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(encodedPassword);
        return userRepository.save(newUser);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

