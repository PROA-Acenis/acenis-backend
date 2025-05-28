package com.acenis.backend.controller;

import com.acenis.backend.model.Professional;
import com.acenis.backend.repository.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/professionals")
@CrossOrigin(origins = "http://localhost:3000")
public class ProfessionalController {

    @Autowired
    private ProfessionalRepository professionalRepository;

    @PostMapping("/register")
    public Professional createProfessional(@RequestBody Professional professional) {
        return professionalRepository.save(professional);
    }

    @GetMapping
    public List<Professional> listProfessionals() {
        return professionalRepository.findAll();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email_prof");
        String password = loginData.get("password_prof");

        Optional<Professional> profOpt = professionalRepository.findByEmailProfAndPasswordProf(email, password);
        if (profOpt.isPresent()) {
            Professional prof = profOpt.get();
            return ResponseEntity.ok(Map.of(
                "id", prof.getIdProf(),
                "name", prof.getNameProf(),
                "email", prof.getEmailProf(),
                "phone", prof.getPhoneProf()

            ));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
    }
}
