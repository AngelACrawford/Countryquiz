package edu.uga.cs.countryquiz;

import static org.apache.commons.lang3.ArrayUtils.contains;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

public class QuizQuestions extends AppCompatActivity {

    static int[] scores = {0,0,0,0,0,0};

    public static int[] getScore() {
        return scores;
    }

    public static void setScore( int position, int score ) {
        scores[position] = score;
        return;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_quest); //Just using this to test. I think you know the correct layout ?

        CountriesData countriesData = CountriesData.getInstance(this);
        SQLiteDatabase db = countriesData.getReadableDatabase();

        Country[] allCountries = countriesData.getCountries(db);
        Country[] quizCountries = new Country[6];
        String[] allContinents = countriesData.getContinents(db);
        Random random = new Random();
        int[] selectedIndices = new int[6];
        int numSelected = 0;

        // We want to use a while loop instead of a for loop so that if the index is already in the
        // Array it tries again instead of skipping that index
        while (numSelected < 6) {
            int randomIndex = random.nextInt(allCountries.length);
            if (!contains(selectedIndices, randomIndex)) {
                quizCountries[numSelected] = allCountries[randomIndex];
                selectedIndices[numSelected] = randomIndex;
                numSelected++;
            } // if
        } // while

        //Finds and sets views
        ViewPager2 pager = findViewById( R.id.pager );
        Button submitButton = findViewById( R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the click event for the "Submit Quiz" button
                Intent intent = new Intent(QuizQuestions.this, ScorePage.class);
                startActivity(intent);
            } // onClick
        });



        QuestionPagerAdapter questionAdapter = new QuestionPagerAdapter(getSupportFragmentManager(), getLifecycle(), quizCountries, submitButton);
        pager.setOrientation( ViewPager2.ORIENTATION_HORIZONTAL );
        pager.setAdapter( questionAdapter );
        pager.setOffscreenPageLimit(4);



    }

    // Helper method to check if an array contains a value
    private static boolean contains(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }




}



