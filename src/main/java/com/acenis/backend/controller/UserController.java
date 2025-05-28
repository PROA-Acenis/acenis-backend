package com.acenis.backend.controller;

import com.acenis.backend.model.User;
import com.acenis.backend.model.Professional;
import com.acenis.backend.repository.UserRepository;
import com.acenis.backend.repository.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfessionalRepository professionalRepository;

    @PostMapping("/register")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email_user");
        String password = loginData.get("password_user");

        // 1. Tenta encontrar usuário comum
        Optional<User> userOpt = userRepository.findByEmailUserAndPasswordUser(email, password);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            return ResponseEntity.ok(Map.of(
                "id", user.getIdUser(),
                "name", user.getNameUser(),
                "email", user.getEmailUser(),
                "type", "normal"
            ));
        }

        // 2. Tenta encontrar profissional
        Optional<Professional> profOpt = professionalRepository.findByEmailProfAndPasswordProf(email, password);
        if (profOpt.isPresent()) {
            Professional prof = profOpt.get();
            return ResponseEntity.ok(Map.of(
                "id", prof.getIdProf(),
                "name", prof.getNameProf(),
                "email", prof.getEmailProf(),
                "type", "profissional"
            ));
        }

        // 3. Nenhum encontrado
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
    }
}
