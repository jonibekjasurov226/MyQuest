package com.example.myquest;

import static java.lang.String.format;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FinishActivity extends AppCompatActivity {

    private String ball, correct, error;
    private TextView tvBall, tvCorrect, tvError, textView;
    private Button btnTamom;
    private ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        ball = getIntent().getExtras().getString("ball");
        correct = getIntent().getExtras().getString("correct");
        error = getIntent().getExtras().getString("error");

        tvBall = findViewById(R.id.FinishTvBall);
        tvCorrect = findViewById(R.id.FinishTvCorrect);
        tvError = findViewById(R.id.FinishTvError);
        img = (ImageView) findViewById(R.id.imageView7);
        btnTamom = (Button) findViewById(R.id.button3);
        textView = (TextView) findViewById(R.id.textView7);

        setResult();


        btnTamom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FinishActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    void setResult() {
        tvBall.setText(ball);
        tvCorrect.setText(correct);
        tvError.setText(error);
        int a = Integer.parseInt(ball);
        if (a >= 90) {
            img.setImageResource(R.drawable.medal_1);
            textView.setText("You Winnwr");
        } else if (a >= 70) {
                img.setImageResource(R.drawable.second_prize_2);
                textView.setText("You Winner 2");
            } else if (a >= 50){
                img.setImageResource(R.drawable.third_prize);
            textView.setText("You Winner 3");
            }else {
                img.setImageResource(R.drawable.ic_launcher_foreground);
                textView.setText("YouLoser");
            }


        }
    }