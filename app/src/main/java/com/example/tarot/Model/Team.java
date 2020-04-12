package com.example.tarot.Model;

import java.util.ArrayList;

public class Team {
    private ArrayList<Player> team;

    /* Constructor */
    public Team(ArrayList<Player> team) {
        this.team = team;
    }

    /* Getters */
    public ArrayList<Player> getTeam() {
        return team;
    }
}
