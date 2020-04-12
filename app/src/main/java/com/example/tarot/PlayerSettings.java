package com.example.tarot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class PlayerSettings extends AppCompatActivity {

    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_settings);
        final Mymodel model = Mymodel.getInstance();

        this.nextButton = findViewById(R.id.nextPlayerButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup b = findViewById(R.id.radioGroup);
                int selectedId = b.getCheckedRadioButtonId();
                RadioButton rb = findViewById(selectedId);
                char rb_char = rb.getText().charAt(0);
                int rb_value = Character.getNumericValue(rb_char);
                System.out.println(rb_value);
                model.setNbPlayer(rb_value);
                Intent nextActivity = new Intent(getApplicationContext(), PlayerName.class);
                startActivity(nextActivity);
                finish();
            }
        });

    }


}
