package com.example.myelementary;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Maths extends AppCompatActivity implements View.OnClickListener, MediaPlayer.OnCompletionListener {
    private TextView screen_text;
    private RadioGroup radioG;
    private RadioButton radio1;
    private RadioButton radio2;
    private RadioButton radio3;
    private RadioButton radio4;
    private Button submit_b;
    private Button try_b;
    private int number1;
    private int number2;
    private int result;
    private MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths);
        screen_text = findViewById(R.id.screen_text);
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
    }

    //make a gaaame
    public void makeGame() {
        try_b.setEnabled(false);
        submit_b.setEnabled(true);
        Random rand = new Random();
        number1 = rand.nextInt(100);
        number2 = rand.nextInt(100);
        result = number1 + number2;
        int answer_index = rand.nextInt(4);
        RadioButton[] radios = {radio1, radio2, radio3, radio4};
        screen_text.setText(String.valueOf(number1) + "+" + String.valueOf(number2));
        radios[answer_index].setText(String.valueOf(result));
        int option1 = rand.nextInt(10) - 5;
        int option2 = rand.nextInt(10) - 5;
        int option3 = rand.nextInt(10) - 5;
        int numbers[] = {result + option1, result + option2, result + option3};
        for (int i = 0, j = 0; i < 4; i++) {
            if (i == answer_index)
                continue;
            radios[i].setText(String.valueOf(numbers[j]));
            j++;
        }
    } //

    //check result
    public void check_result() {
        submit_b.setEnabled(false);
        try_b.setEnabled(true);
        int selected_id = radioG.getCheckedRadioButtonId();
        RadioButton target = findViewById(selected_id);
        String answer = target.getText().toString();
        Log.d("check_result: ", answer);
        if (answer.compareTo(String.valueOf(result))==0 ){
            Toast.makeText(this, "you got it", Toast.LENGTH_SHORT).show();
            player = MediaPlayer.create(this, Animal.getRight(1));
            player.setOnCompletionListener(this);
            player.start();
            screen_text.setText("correct!");
        } else {
            Toast.makeText(this, "wrong answer", Toast.LENGTH_SHORT).show();
            player = MediaPlayer.create(this, Animal.getWrong(1));
            player.setOnCompletionListener(this);
            player.start();
            screen_text.setText("incorrect!");
        }
    }

    //on media completed
    public void onCompletion(MediaPlayer mp) {
        player.release();
    }

    //onclick listner
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.submit_b:
                check_result();
                break;
            case R.id.try_b:
                makeGame();
        }
    }
}