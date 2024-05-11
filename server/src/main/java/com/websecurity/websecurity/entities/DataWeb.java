package com.websecurity.websecurity.entities;

public class DataWeb {
    private String cve;
    private int vulnerability;

    public DataWeb() {

    }

    public String getCve() {
        return cve;
    }

    public void setCve(String cve) {
        this.cve = cve;
    }

    public int getVulnerability() {
        return vulnerability;
    }

    public void setVulnerability(int vulnerability) {
        this.vulnerability = vulnerability;
    }
}
