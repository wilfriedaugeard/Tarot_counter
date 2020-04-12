package com.example.tarot.Model;

public class Player {
    private String name;
    private Double score;

    /* Constructor */
    public Player(String name) {
        this.name = name;
        this.score = 0.0;
    }

    /* Methods */
    public void addScore(Double pts){
        this.score+=pts;
    }

    /* Getters */
    public String getName() {
        return name;
    }

    public Double getScore() {
        return score;
    }

}
