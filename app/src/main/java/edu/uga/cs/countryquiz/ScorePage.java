package edu.uga.cs.countryquiz;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScorePage extends AppCompatActivity {
    private static final String TAG = "Grade Page";

    int[] score = QuizQuestions.getScore();
    String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());


    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.score );

        int gradeTotal = 0;

        //Finds views
        TextView text = findViewById( R.id.pageText);
        TextView gradeDisplay = findViewById( R.id.gradeView);
        Button homeButton = findViewById( R.id.homeButton);

        //Counts up total grade from individual question grades
        for (int i = 0; i < score.length; i++) {
            gradeTotal += score[i];
        }

        //Displays grade
        text.setText("Quiz Score");
        gradeDisplay.setText(Integer.toString((gradeTotal/score.length) * 100));

        //Store date and grade into database
        CountriesData countriesData = CountriesData.getInstance(this);
        SQLiteDatabase db = countriesData.getWritableDatabase();


        //Sets the
        countriesData.putRecord(date, (float)((gradeTotal/score.length)*100));

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the click event for the "Submit Quiz" button
                Intent intent = new Intent(ScorePage.this, MainActivity.class);
                startActivity(intent);
            } // onClick
        });




    }
}
