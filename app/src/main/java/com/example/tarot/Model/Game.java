package com.example.tarot.Model;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> attaquants;
    private ArrayList<Player> defenseurs;
    private Contrat contrat;
    private int nbBouts;
    private int nbRois;
    private int nbDames;
    private int nbCavaliers;
    private int nbValets;
    private int nbReste;
    private double score;
    private boolean petitAuBout;


    public Game(ArrayList<Player> attaquants, ArrayList<Player> defenseurs, String contrat, int nbBouts, int nbRois, int nbDames, int nbCavaliers, int nbValets, int nbReste, boolean petitAuBout) {
        this.attaquants = attaquants;
        this.defenseurs = defenseurs;
        ArrayList<Contrat> liste = new ArrayList<>();
        liste.add(new Contrat("Petite",1.0));
        liste.add(new Contrat("Garde",2.0));
        liste.add(new Contrat("Garde sans",4.0));
        liste.add(new Contrat("Garde contre",6.0));
        this.contrat = liste.get(0);
        for(Contrat c : liste){
            if(c.getName().equalsIgnoreCase(contrat)){
                this.contrat = c;
            }
        }
        this.petitAuBout = petitAuBout;

        this.nbBouts = nbBouts;
        this.nbRois = nbRois;
        this.nbDames = nbDames;
        this.nbCavaliers = nbCavaliers;
        this.nbValets = nbValets;
        this.nbReste = nbReste;
    }

    public int computeScore(){
        int score = nbBouts*5;
        score += nbRois*5;
        score += nbDames*4;
        score += nbCavaliers*3;
        score += nbValets*2;
        score += nbReste*0.5;
        return score;
    }

    public void scoreContrat(){
        if (nbBouts == 0)
            score -=56;
        if (nbBouts == 1)
            score -=51;
        if (nbBouts == 2)
            score -= 41;
        if (nbBouts == 3)
            score -= 36;
    }


    public boolean validatedContrat(){
        scoreContrat();
        return score >= 0;
    }

    public void distributPoints(){
        if(validatedContrat()){
            score +=25;
            if(petitAuBout)
                score += 10;
        }else{
            score -=25;
        }
        score *= contrat.getCoeff();
        System.out.println("SCORE: "+score);
        for(Player player : attaquants){
            player.addScore(score*defenseurs.size()/attaquants.size());
        }
        for(Player player : defenseurs){
            player.addScore(-score);
        }
    }

    public void computeAttaquant(){
        score = computeScore();
        distributPoints();
    }

    public void computeDefenseurs(){
        score = computeScore();
        score = 91-score;
        distributPoints();
    }


}
