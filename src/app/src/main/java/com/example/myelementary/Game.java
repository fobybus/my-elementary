//@msf@dbu
package com.example.myelementary;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Random;

public class Game extends AppCompatActivity implements View.OnClickListener, MediaPlayer.OnCompletionListener {
    //
    private ImageView screen_image;
    private RadioGroup radioG;
    private RadioButton radio1;
    private RadioButton radio2;
    private RadioButton radio3;
    private RadioButton radio4;
    private Button submit_b;
    private Button try_b;
    private int question = 0;
    private MediaPlayer player;
    private MediaPlayer player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        screen_image = findViewById(R.id.screen_image);
        radioG = findViewById(R.id.radioG);
        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        radio3 = findViewById(R.id.radio3);
        radio4 = findViewById(R.id.radio4);
        submit_b = findViewById(R.id.submit_b);
        try_b = findViewById(R.id.try_b);
        submit_b.setOnClickListener(this);
        try_b.setOnClickListener(this);
        makeGame();
    }//

    //make a gaaame
    public void makeGame() {
        try_b.setEnabled(false);
        submit_b.setEnabled(true);
        int len = Animal.animals.length;
        Random rand = new Random();
        question = rand.nextInt(len);
        int answer = rand.nextInt(4);
        RadioButton[] radios = {radio1, radio2, radio3, radio4};
        //
        Log.d("que", String.valueOf(question));
        //set que
        screen_image.setImageResource(Animal.animals[question].getImage());
        radios[answer].setText(Animal.animals[question].getName());
        //// prepare choice
        for (int i = 0; i < 4; i++) {
            if (i == answer)
                continue;
            //avoid redudant cho
            boolean flag_same = false;
            do {
                flag_same = false;
                int randq = rand.nextInt(len);
                String name = Animal.animals[randq].getName();
                radios[i].setText(name);
                for (int j = 0; j < 4; j++) {
                    if (i == j)
                        continue;
                    if (radios[j].getText().toString() == name)
                        flag_same = true;
                }
            } while (flag_same);
        }
    } //

    //on listner
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.submit_b:
                check_result();
                break;
            case R.id.try_b:
                makeGame();
                break;
        }
    } //

    //check result
    public void check_result() {
        //ans
        submit_b.setEnabled(false);
        try_b.setEnabled(true);
        String answer = "";
        int selected_id = radioG.getCheckedRadioButtonId();
        RadioButton target = findViewById(selected_id);
        answer = target.getText().toString();
        //compair
        if (Animal.animals[question].getName() == answer) {
            Toast.makeText(this, "great job", Toast.LENGTH_SHORT).show();
            screen_image.setImageResource(Animal.getRight(0));
            player2 = MediaPlayer.create(this, Animal.getRight(1));
            player2.setOnCompletionListener(this);
            player2.start();
            player = MediaPlayer.create(this, Animal.animals[question].get_sound());
            player.setOnCompletionListener(this);
            player.start();
        } else {
            Toast.makeText(this, "wrong answer", Toast.LENGTH_SHORT).show();
            screen_image.setImageResource(Animal.getWrong(0));
            player = MediaPlayer.create(this, Animal.getWrong(1));
            player.setOnCompletionListener(this);
            player.start();
        }

    }//

    //release media resource
    public void onCompletion(MediaPlayer mp) {
        player.release();
    }
}