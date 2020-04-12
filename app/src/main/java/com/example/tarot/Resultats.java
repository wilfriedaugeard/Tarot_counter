package com.example.tarot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Resultats extends AppCompatActivity {
    private Button nextButton;
    private LinearLayout myLayout;
    private TextView txt[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultats);

        final Mymodel model = Mymodel.getInstance();
        myLayout = findViewById(R.id.myLayout);
        txt = new TextView[model.getNbPlayer()];
        for(int i=0; i<model.getNbPlayer(); i++){
            txt[i] = new TextView(this);
            NumberFormat formatter = new DecimalFormat("#0.00");
            txt[i].setText(model.getPlayerList().get(i).getName()+"  :  "+formatter.format(model.getPlayerList().get(i).getScore())+" pts");
            txt[i].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            myLayout.addView(txt[i]);
        }

        this.nextButton = findViewById(R.id.next_button_resultats);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextActivity = new Intent(getApplicationContext(), ChooseTeam.class);
                startActivity(nextActivity);
                finish();
            }
        });


    }
}
