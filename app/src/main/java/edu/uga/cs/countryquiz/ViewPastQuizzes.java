package edu.uga.cs.countryquiz;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewPastQuizzes extends AppCompatActivity{
    private Record[] quizRecords;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_past);

        CountriesData countriesData = CountriesData.getInstance(this);
        SQLiteDatabase db = countriesData.getReadableDatabase();

        quizRecords = countriesData.getAllQuizRecords(db);

        ListView listViewResults = findViewById(R.id.viewPreviousQuizzesListView);
        if (quizRecords != null) {
            Results adapter = new Results(this, quizRecords);
            listViewResults.setAdapter(adapter);
        } // if

        // Up Button
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        } // if

    } // onCreate()
}
