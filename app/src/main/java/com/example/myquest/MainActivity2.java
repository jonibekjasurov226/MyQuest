package com.example.myquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private LinearLayout btnP,btnE,btnM;
    private Button btn;
    private int intentNumber = 0;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn = (Button) findViewById(R.id.button2);
        btnP = (LinearLayout) findViewById(R.id.mainProgrammQuis);
        btnE = (LinearLayout) findViewById(R.id.mainEnglishQuis);
        btnM = (LinearLayout) findViewById(R.id.mainMathQuis);

        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLayoutBackgroundOnClick(btnP,R.id.imgProgramming,R.id.textProgramming,
                        R.drawable.web_programming_white);
                setLayoutBackgroundOnBack(btnM,R.id.imgMath,R.id.textMath,
                        R.drawable.ic_math);
                setLayoutBackgroundOnBack(btnE,R.id.imgEnglish,R.id.textEnglish,
                        R.drawable.ic_eng);
                btn.setEnabled(true);
                intentNumber = 1;
            }
        });

        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLayoutBackgroundOnBack(btnP,R.id.imgProgramming,R.id.textProgramming,
                        R.drawable.ic_programming);
                setLayoutBackgroundOnBack(btnM,R.id.imgMath,R.id.textMath,
                        R.drawable.ic_math);
                setLayoutBackgroundOnClick(btnE,R.id.imgEnglish,R.id.textEnglish,
                        R.drawable.understanding_white);
                btn.setEnabled(true);
                intentNumber = 2;
            }
        });

        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLayoutBackgroundOnBack(btnP,R.id.imgProgramming,R.id.textProgramming,
                        R.drawable.ic_programming);
                setLayoutBackgroundOnClick(btnM,R.id.imgMath,R.id.textMath,
                        R.drawable.math_white);
                setLayoutBackgroundOnBack(btnE,R.id.imgEnglish,R.id.textEnglish,
                        R.drawable.ic_eng);
                btn.setEnabled(true);
                intentNumber = 3;
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (intentNumber == 1){
                    i = new Intent(MainActivity2.this,
                            QuestionProgramActivity.class);
                } else if (intentNumber == 2){
                    i = new Intent(MainActivity2.this,
                            QuestionEnglishActivity.class);
                } else if (intentNumber == 3){
                    i = new Intent(MainActivity2.this,
                            QusestionAlgebraActivity.class);
                } else {
                    Toast.makeText(MainActivity2.this,
                            "Testlardan birini tanlang", Toast.LENGTH_SHORT).show();
                }
                startActivity(i);
                finish();
            }
        });


    }

    void setLayoutBackgroundOnClick(View view, int img, int text, int newImg){
        ImageView image = (ImageView) findViewById(img);
        TextView textView = (TextView) findViewById(text);
        view.setBackgroundColor(Color.parseColor("#A257EB"));
        image.setImageResource(newImg);
        textView.setTextColor(Color.WHITE);

    }
    void setLayoutBackgroundOnBack(View view, int img, int text, int newImg){
        ImageView image = (ImageView) findViewById(img);
        TextView textView = (TextView) findViewById(text);
        view.setBackgroundColor(Color.WHITE);
        image.setImageResource(newImg);
        textView.setTextColor(Color.parseColor("#A257EB"));
    }

}