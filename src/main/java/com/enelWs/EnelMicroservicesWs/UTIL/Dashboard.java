package com.enelWs.EnelMicroservicesWs.UTIL;

import com.enelWs.EnelMicroservicesWs.Entity.AnreSummary;

import java.util.List;

public class Dashboard {

    private String curentTotalCereri;
    private String curentTotalCereriUnice;
    private String curentTotalErori;
    private String curentProcentErori;
    private String curentProcentOk;

    private String oldTotalCereri;
    private String oldTotalCereriUnice;
    private String oldTotalErori;
    private String oldProcentErori;
    private String oldProcentOk;

    private String totalCereri;
    private String totalCereriUnice;
    private String totalErori;
    private String procentErori;
    private String procentOk;

    private List<AnreSummary> lastAnreSummary;


    public List<AnreSummary> getLastAnreSummary() {
        return lastAnreSummary;
    }

    public void setLastAnreSummary(List<AnreSummary> lastAnreSummary) {
        this.lastAnreSummary = lastAnreSummary;
    }

    public String getOldTotalCereri() {
        return oldTotalCereri;
    }

    public void setOldTotalCereri(String oldTotalCereri) {
        this.oldTotalCereri = oldTotalCereri;
    }

    public String getOldTotalCereriUnice() {
        return oldTotalCereriUnice;
    }

    public void setOldTotalCereriUnice(String oldTotalCereriUnice) {
        this.oldTotalCereriUnice = oldTotalCereriUnice;
    }

    public String getOldTotalErori() {
        return oldTotalErori;
    }

    public void setOldTotalErori(String oldTotalErori) {
        this.oldTotalErori = oldTotalErori;
    }

    public String getOldProcentErori() {
        return oldProcentErori;
    }

    public void setOldProcentErori(String oldProcentErori) {
        this.oldProcentErori = oldProcentErori;
    }

    public String getOldProcentOk() {
        return oldProcentOk;
    }

    public void setOldProcentOk(String oldProcentOk) {
        this.oldProcentOk = oldProcentOk;
    }

    public String getCurentTotalCereri() {
        return curentTotalCereri;
    }

    public void setCurentTotalCereri(String curentTotalCereri) {
        this.curentTotalCereri = curentTotalCereri;
    }

    public String getCurentTotalCereriUnice() {
        return curentTotalCereriUnice;
    }

    public void setCurentTotalCereriUnice(String curentTotalCereriUnice) {
        this.curentTotalCereriUnice = curentTotalCereriUnice;
    }

    public String getCurentTotalErori() {
        return curentTotalErori;
    }

    public void setCurentTotalErori(String curentTotalErori) {
        this.curentTotalErori = curentTotalErori;
    }

    public String getCurentProcentErori() {
        return curentProcentErori;
    }

    public void setCurentProcentErori(String curentProcentErori) {
        this.curentProcentErori = curentProcentErori;
    }

    public String getCurentProcentOk() {
        return curentProcentOk;
    }

    public void setCurentProcentOk(String curentProcentOk) {
        this.curentProcentOk = curentProcentOk;
    }

    public String getTotalCereri() {
        return totalCereri;
    }

    public void setTotalCereri(String totalCereri) {
        this.totalCereri = totalCereri;
    }

    public String getTotalCereriUnice() {
        return totalCereriUnice;
    }

    public void setTotalCereriUnice(String totalCereriUnice) {
        this.totalCereriUnice = totalCereriUnice;
    }

    public String getTotalErori() {
        return totalErori;
    }

    public void setTotalErori(String totalErori) {
        this.totalErori = totalErori;
    }

    public String getProcentErori() {
        return procentErori;
    }

    public void setProcentErori(String procentErori) {
        this.procentErori = procentErori;
    }

    public String getProcentOk() {
        return procentOk;
    }

    public void setProcentOk(String procentOk) {
        this.procentOk = procentOk;
    }
}
