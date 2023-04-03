package edu.uga.cs.countryquiz;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button newQuiz;
    public Button viewPastQuizzes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* find views by ids */
        newQuiz = findViewById(R.id.newQuiz);
        viewPastQuizzes = findViewById(R.id.viewPastQuizzes);


        /* on-click listeners for newQuiz and viewPastQuizzes */
        newQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                Intent quizQuestions = new Intent(MainActivity.this,QuizQuestions.class);
                startActivity(quizQuestions);
            }
        });

        viewPastQuizzes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //viewPastQuizzes.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                Intent quizQuestions = new Intent(MainActivity.this,ViewPastQuizzes.class);
                startActivity(quizQuestions);
            }
        });
    }
}