package com.example.myquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myquest.Modul.Questions;

public class QusestionAlgebraActivity extends AppCompatActivity {
    private TextView txSavol1, txRaqam2;
    private RadioButton rb1, rb2, rb3, rb4, rbTanlangan;
    private Button btn4;
    private RadioGroup rg;
    private int questionId = 0;
    private Questions questions = new Questions();
    private int ball = 0;
    private int error = 0;
    private int correct = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qusestion_algebra);
        btn4 = (Button) findViewById(R.id.buttonAlgebra5);
        txSavol1 = (TextView) findViewById(R.id.textViewAlgebra5);
        txRaqam2 = (TextView) findViewById(R.id.textViewAlgebra4);
        rg = (RadioGroup) findViewById(R.id.radioGroupAlgebra2);
        rb1 = (RadioButton) findViewById(R.id.radioButtonAlgebra);
        rb2 = (RadioButton) findViewById(R.id.radioButtonAlgebra2);
        rb3 = (RadioButton) findViewById(R.id.radioButtonAlgebra3);
        rb4 = (RadioButton) findViewById(R.id.radioButtonAlgebra4);

        setTextQuest();

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = rg.getCheckedRadioButtonId();
                if (id > 0) {

                    rbTanlangan = (RadioButton) findViewById(id);
                    if (rbTanlangan.getText().toString().endsWith(questions.trueMathematic[questionId])) {
                        ball += 20;
                        correct += 1;
                        questionId += 1;
                        rg.clearCheck();
                    } else {
                        error += 1;
                        ball -= 10;
                        questionId += 1;
                        rg.clearCheck();
                    }

                    if (questionId == questions.questionMathematic.length) {
                        Intent i = new Intent(QusestionAlgebraActivity.this, FinishActivity.class);
                        i.putExtra("ball", String.valueOf(ball));
                        i.putExtra("correct", String.valueOf(correct));
                        i.putExtra("error", String.valueOf(error));
                        startActivity(i);
                    } else {
                        setTextQuest();
                    }
                } else {
                    Toast.makeText(QusestionAlgebraActivity.this, "Tanlang", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    void setTextQuest() {
        int savolRaqami = questionId;
        txRaqam2.setText(String.format("%s", savolRaqami += 1));
        String a = questions.questionMathematic[questionId];
        txSavol1.setText(a);
        rb1.setText(questions.answersMathematic[questionId][0]);
        rb2.setText(questions.answersMathematic[questionId][1]);
        rb3.setText(questions.answersMathematic[questionId][2]);
        rb4.setText(questions.answersMathematic[questionId][3]);
    }

}

