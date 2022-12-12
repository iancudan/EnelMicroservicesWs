package com.enelWs.EnelMicroservicesWs.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Dictionar {

    @Id
    private Long id;
    private String mesajEroare;
    private String cuvantCheie;
    private String hint;
    private String valid;
    private String status;
    private String username;

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMesajEroare() {
        return mesajEroare;
    }

    public void setMesajEroare(String mesajEroare) {
        this.mesajEroare = mesajEroare;
    }

    public String getCuvantCheie() {
        return cuvantCheie;
    }

    public void setCuvantCheie(String cuvantCheie) {
        this.cuvantCheie = cuvantCheie;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
}
