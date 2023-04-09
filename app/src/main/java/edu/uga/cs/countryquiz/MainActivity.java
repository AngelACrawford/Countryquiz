package edu.uga.cs.countryquiz;



import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;



public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an instance of the CountryData class, which manages the database and provides
        // Methods to query it
        CountriesData countriesData = CountriesData.getInstance(this);

        //TODO: Write AsyncTask to get an instance of CountriesData.

        //These are the Views from the layout
        TextView start = findViewById(R.id.textView5);
        ImageView image1 = findViewById(R.id.imageView3);
        ImageView image2 = findViewById(R.id.imageView4);



        //These are the buttons from the layout
        Button viewPreviousQuizzesButton = findViewById(R.id.viewPastQuizzes);
        Button startQuizButton = findViewById(R.id.newQuiz);

        //The next chunk of code is our button listeners.

        viewPreviousQuizzesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the click event for the "View Previous Quizzes" button
                Intent intent = new Intent(MainActivity.this, ViewPastQuizzes.class);
                startActivity(intent);
            } // onClick
        }); // viewPreviousQuizzesButton.setOnClickListener


        startQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the click event for the "Start Quiz" button
                Intent intent = new Intent(MainActivity.this, QuizQuestions.class);
                startActivity(intent);
            } // onClick
        }); // startQuizButton.setOnClickListener


    }
}