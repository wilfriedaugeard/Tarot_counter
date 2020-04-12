package com.example.tarot;

import com.example.tarot.Model.Contrat;
import com.example.tarot.Model.Game;
import com.example.tarot.Model.Player;
import com.example.tarot.Model.Team;

import java.util.ArrayList;

class Mymodel {

    private Game game;
    private int nbPlayer;
    private ArrayList<Player> playerList;
    private ArrayList<Player> attaquants;
    private ArrayList<Player> defenseurs;


    private static final Mymodel ourInstance = new Mymodel();
    static Mymodel getInstance() {
        return ourInstance;
    }

    private Mymodel() {
        playerList = new ArrayList<>();
        attaquants = new ArrayList<>();
        defenseurs = new ArrayList<>();
    }

    public Game getGame(){
        return this.game;
    }
    public void setGame(Game game) {
        this.game = game;
    }

    /* PLAYERS */
    public int getNbPlayer() {
        return nbPlayer;
    }
    public void setNbPlayer(int nbPlayer) {
        this.nbPlayer = nbPlayer;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }
    public void addPlayer(String name){
        playerList.add(new Player(name));
    }
    public void removePlayer(Player player){
        playerList.remove(player);
    }


    /* TEAM */
    public ArrayList<Player> getAttaquants() {
        return attaquants;
    }
    public ArrayList<Player> getDefenseurs() {
        return defenseurs;
    }

    public void addAttaquant(String name){
        for(Player player : playerList) {
            if (player.getName().equalsIgnoreCase(name) && !attaquants.contains(player)) {
                attaquants.add(player);
            }
        }
    }
    public void addDefenseurs(String name){
        for(Player player : playerList) {
            if (player.getName().equalsIgnoreCase(name) && !defenseurs.contains(player)) {
                defenseurs.add(player);
            }
        }
    }

}
