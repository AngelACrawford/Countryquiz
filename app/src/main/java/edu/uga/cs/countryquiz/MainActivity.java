package edu.uga.cs.countryquiz;



import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;

import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;



public class MainActivity extends AppCompatActivity {

    public Button newQuiz;
    public Button viewPastQuizzes;
    final String TAG = "CSVReading" ;


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

                //Array to store the countries ... index 0 = 1, Afghanistan, Asia ... Index 194 = 195, Zimbabwe, Africa ...
                Country[] countries = new Country[195];
                try {
                    // Open the CSV data file in the assets folder
                    InputStream in_s = getAssets().open("countries.csv");

                    //Read CSV file
                    CSVReader reader = new CSVReader(new InputStreamReader(in_s));

                    //Used for navigating the CSV file ...
                    String[] nextRow;

                    int index = 0;

                    while ((nextRow = reader.readNext()) != null) {
                        //Create the country object
                        Country country = new Country(nextRow[0], nextRow[1], nextRow[2]);

                        countries[index] = country;
                        index++;
                    }
                    Log.d(TAG, "CSV File has been read and added to array, error will show up if it has already been read ^ ") ;
                } catch (Exception e) {
                    Log.e(TAG, e.toString());
                }


                Intent quizQuestions = new Intent(MainActivity.this, QuizQuestions.class);
                quizQuestions.putExtra("countries", countries);
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