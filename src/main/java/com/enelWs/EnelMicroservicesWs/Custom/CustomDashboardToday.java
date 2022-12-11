package com.enelWs.EnelMicroservicesWs.Custom;

public class CustomDashboardToday {

    private Long numarTotal;
    private Long numarTotalOK;
    private Long numarTotalKO;
    private Long numarUniqueRequesturi;

    private String procentKO;
    private String procentOK;
    private String procentUnique;

    public Long getNumarTotal() {
        return numarTotal;
    }

    public void setNumarTotal(Long numarTotal) {
        this.numarTotal = numarTotal;
    }

    public Long getNumarTotalOK() {
        return numarTotalOK;
    }

    public void setNumarTotalOK(Long numarTotalOK) {
        this.numarTotalOK = numarTotalOK;
    }

    public Long getNumarTotalKO() {
        return numarTotalKO;
    }

    public void setNumarTotalKO(Long numarTotalKO) {
        this.numarTotalKO = numarTotalKO;
    }

    public Long getNumarUniqueRequesturi() {
        return numarUniqueRequesturi;
    }

    public void setNumarUniqueRequesturi(Long numarUniqueRequesturi) {
        this.numarUniqueRequesturi = numarUniqueRequesturi;
    }

    public String getProcentKO() {
        return procentKO;
    }

    public void setProcentKO(String procentKO) {
        this.procentKO = procentKO;
    }

    public String getProcentOK() {
        return procentOK;
    }

    public void setProcentOK(String procentOK) {
        this.procentOK = procentOK;
    }

    public String getProcentUnique() {
        return procentUnique;
    }

    public void setProcentUnique(String procentUnique) {
        this.procentUnique = procentUnique;
    }
}
