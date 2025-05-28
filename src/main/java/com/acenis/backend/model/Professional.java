package com.acenis.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_professional")
public class Professional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProf;

    private String nameProf;
    private String emailProf;
    private String passwordProf;
    private String phoneProf;

    // Getters e Setters
    public Long getIdProf() {
        return idProf;
    }

    public void setIdProf(Long idProf) {
        this.idProf = idProf;
    }

    public String getNameProf() {
        return nameProf;
    }

    public void setNameProf(String nameProf) {
        this.nameProf = nameProf;
    }

    public String getEmailProf() {
        return emailProf;
    }

    public void setEmailProf(String emailProf) {
        this.emailProf = emailProf;
    }

    public String getPasswordProf() {
        return passwordProf;
    }

    public void setPasswordProf(String passwordProf) {
        this.passwordProf = passwordProf;
    }

    public void setPhoneProf(String phoneProf) {
        this.phoneProf = phoneProf;
    }

    public String getPhoneProf() {
        return phoneProf;
    }
}
