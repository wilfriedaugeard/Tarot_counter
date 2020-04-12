package com.example.tarot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.tarot.Model.Game;
import com.example.tarot.Model.Player;

public class GetData extends AppCompatActivity {

    private RadioGroup contrat;
    private RadioGroup team;
    private EditText nbBouts;
    private EditText nbRois;
    private EditText nbDames;
    private EditText nbCavalier;
    private EditText nbValets;
    private EditText nbReste;

    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);

        final Mymodel model = Mymodel.getInstance();



        this.nextButton = findViewById(R.id.next_button_get_data);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contrat = findViewById(R.id.radioGroup2);
                int selectedId = contrat.getCheckedRadioButtonId();
                RadioButton rb_contrat = findViewById(selectedId);
                rb_contrat.getText();

                team = findViewById(R.id.radioGroup3);
                selectedId = team.getCheckedRadioButtonId();
                RadioButton rb_team = findViewById(selectedId);
                rb_team.getText();

                nbBouts = findViewById(R.id.editText3);
                int nbB = 0;
                int nbR = 0;
                int nbD = 0;
                int nbC = 0;
                int nbV = 0;
                int nbRes = 0;
                if(!nbBouts.getText().toString().isEmpty())
                    nbB = Integer.parseInt(nbBouts.getText().toString());

                nbRois = findViewById(R.id.editText6);
                if(!nbRois.getText().toString().isEmpty())
                    nbR = Integer.parseInt(nbRois.getText().toString());

                nbDames = findViewById(R.id.editText7);
                if(!nbDames.getText().toString().isEmpty())
                    nbD = Integer.parseInt(nbDames.getText().toString());

                nbCavalier = findViewById(R.id.editText8);
                if(!nbCavalier.getText().toString().isEmpty())
                    nbC = Integer.parseInt(nbCavalier.getText().toString());

                nbValets = findViewById(R.id.editText9);
                if(!nbValets.getText().toString().isEmpty())
                    nbV = Integer.parseInt(nbValets.getText().toString());

                nbReste = findViewById(R.id.editText10);
                if(!nbReste.getText().toString().isEmpty())
                    nbRes = Integer.parseInt(nbReste.getText().toString());

                CheckBox cb = findViewById(R.id.checkBox);
                model.setGame(
                        new Game(model.getAttaquants(),
                                model.getDefenseurs(),
                                rb_contrat.getText().toString(),
                                nbB, nbR, nbD, nbC, nbV, nbRes, cb.isChecked())
                );
                if(rb_contrat.getText().toString().equalsIgnoreCase("Attaquants")){
                    System.out.println("Attaquants");
                    model.getGame().computeAttaquant();
                }
                else{
                    model.getGame().computeDefenseurs();
                }

                for(Player player : model.getPlayerList()){
                    System.out.println(player.getScore());
                }
                Intent nextActivity = new Intent(getApplicationContext(), Resultats.class);
                startActivity(nextActivity);
                finish();



            }
        });

    }
}
