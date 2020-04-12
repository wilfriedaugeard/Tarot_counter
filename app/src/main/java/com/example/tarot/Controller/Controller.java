package com.example.tarot.Controller;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.tarot.Model.Game;
import com.example.tarot.Model.Player;

import java.util.ArrayList;

public class Controller implements Parcelable {
    private Game game;
    private int nbPlayer;
    private ArrayList<Player> playerList;

    /* Constructor */
    public Controller(){

    }

    /* Getters */
    public Game getGame() {
        return game;
    }
    public int getNbPlayer() {
        return nbPlayer;
    }
    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setNbPlayer(int nbPlayer) {
        this.nbPlayer = nbPlayer;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    /* Parcelable */
    protected Controller(Parcel in) {
        nbPlayer = in.readInt();
    }

    public static final Creator<Controller> CREATOR = new Creator<Controller>() {
        @Override
        public Controller createFromParcel(Parcel in) {
            return new Controller(in);
        }

        @Override
        public Controller[] newArray(int size) {
            return new Controller[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(game);
        parcel.writeInt(nbPlayer);
        parcel.writeValue(playerList);

    }
}
