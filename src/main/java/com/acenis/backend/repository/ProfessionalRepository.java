package com.acenis.backend.repository;

import com.acenis.backend.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
    Optional<Professional> findByEmailProfAndPasswordProf(String email, String password);
}
