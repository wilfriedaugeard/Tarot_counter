package com.example.tarot.Model;

public class Contrat {
    private String name;
    private Double coeff;

    /* Constructor */

    public Contrat(String name, Double coeff) {
        this.name = name;
        this.coeff = coeff;
    }

    public String getName() {
        return name;
    }

    public Double getCoeff() {
        return coeff;
    }
}
