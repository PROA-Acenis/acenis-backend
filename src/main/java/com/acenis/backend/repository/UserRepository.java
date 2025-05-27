package com.acenis.backend.repository;

import com.acenis.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail_userAndPassword_user(String email_user, String password_user);
}
// O repositório UserRepository estende JpaRepository, o que fornece métodos CRUD básicos
// e permite a criação de consultas personalizadas, como a busca por email e senha.