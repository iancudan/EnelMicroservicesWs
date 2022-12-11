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
