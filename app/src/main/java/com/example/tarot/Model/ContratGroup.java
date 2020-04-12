package com.example.tarot.Model;

import java.util.ArrayList;

public class ContratGroup {
    private ArrayList<Contrat> contratList;

    /* Constructor */
    public ContratGroup(ArrayList<Contrat> contratList) {
        this.contratList = contratList;
    }

    /* Methods */
    public void addContrat(Contrat contrat){
        this.contratList.add(contrat);
    }

    /* Getters */
    public ArrayList<Contrat> getContratList() {
        return contratList;
    }


}
