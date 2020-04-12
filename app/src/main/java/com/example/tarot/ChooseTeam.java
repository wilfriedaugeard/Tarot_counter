package com.example.tarot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.example.tarot.Model.Player;

public class ChooseTeam extends AppCompatActivity {
    private Button nextButton;
    private Button nbPlayer;
    private LinearLayout myLayout;
    private Switch sw[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_team);
        final Mymodel model = Mymodel.getInstance();
        myLayout = findViewById(R.id.myLayout);

        /* CREATE SWITCH */
        sw = new Switch[model.getNbPlayer()];
        for(int i=0; i<model.getPlayerList().size(); i++){
            System.out.println(model.getPlayerList().get(i).getName());
        }


        for(int i=0; i<model.getNbPlayer(); i++){
            sw[i] = new Switch(this);
            sw[i].setText(model.getPlayerList().get(i).getName());
            //sw[i].setChecked(false);
            sw[i].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            myLayout.addView(sw[i]);
        }
        if(model.getNbPlayer()<5){
            sw[0].setChecked(true);
        }else{
            sw[0].setChecked(true);
            sw[1].setChecked(true);
        }

        this.nextButton = findViewById(R.id.next_button_choose_team);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(Switch s : sw){
                    if(s.isChecked()) {
                        model.addAttaquant(s.getText().toString());
                    }
                    else{
                        model.addDefenseurs(s.getText().toString());
                    }
                }
                if(model.getAttaquants().size() != 0 && model.getDefenseurs().size() != 0){
                    Intent nextActivity = new Intent(getApplicationContext(), GetData.class);
                    startActivity(nextActivity);
                    finish();
                }else{
                    model.getDefenseurs().clear();
                    model.getAttaquants().clear();
                }
            }
        });

        this.nbPlayer = findViewById(R.id.nb_player_button);
        nbPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextActivity = new Intent(getApplicationContext(), PlayerSettings.class);
                startActivity(nextActivity);
                finish();
            }
        });
    }
}
