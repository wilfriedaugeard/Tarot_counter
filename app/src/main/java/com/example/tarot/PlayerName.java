package com.example.tarot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;


public class PlayerName extends AppCompatActivity {
    private LinearLayout myLayout;
    private Button nextButton;
    private EditText ed[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_name);
        final Mymodel model = Mymodel.getInstance();

        myLayout = findViewById(R.id.myLayout);

        // CREATE NAMES FIELD
        ed = new EditText[model.getNbPlayer()];
        if(model.getNbPlayer() < model.getPlayerList().size()){
            model.getPlayerList().clear();
        }
        for(int i=0; i<model.getNbPlayer(); i++){
            String text = "Nom du joueur "+String.valueOf(i+1);
            ed[i] = new EditText(this);
            ed[i].setHint(text);
            ed[i].setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

            if(model.getPlayerList().size()>i){
                ed[i].setText(model.getPlayerList().get(i).getName());
            }
            ed[i].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            myLayout.addView(ed[i]);

        }

        for(int i=0; i<model.getPlayerList().size(); i++){
            ed[i].setText(model.getPlayerList().get(i).getName());
            // Reset score
            model.getPlayerList().get(i).addScore(-model.getPlayerList().get(i).getScore());
        }


        // NEXT BUTTON
        this.nextButton = findViewById(R.id.next_button_player_name);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0; i<model.getNbPlayer(); i++) {
                    if(i >= model.getPlayerList().size()){
                        if(ed[i].getText().length()!=0){
                            System.out.println("Name: "+i);
                            model.addPlayer(ed[i].getText().toString());
                        }else{
                            int j = i+1;
                            System.out.println("Joueur: "+i);
                            model.addPlayer("Joueur "+j);
                        }
                    }
                }

                Intent nextActivity = new Intent(getApplicationContext(), ChooseTeam.class);
                startActivity(nextActivity);
                finish();
            }
        });

    }

}
