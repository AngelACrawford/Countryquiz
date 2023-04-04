package edu.uga.cs.countryquiz;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ViewPastQuizzes extends Activity {
    private RecyclerView toDisplayQuizSummary;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter recyclerAdapter;
    private ImageButton backImageButtonToHomePage;

    private static final String DEBUG_TAG = "ViewPastQuizzes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d( DEBUG_TAG, "ViewPastQuizzes.onCreate()" );
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_past);

        toDisplayQuizSummary = findViewById(R.id.toDisplayQuizSummary);
        backImageButtonToHomePage = findViewById(R.id.backImageHome);

        // use a linear layout manager for the recycler view
        layoutManager = new LinearLayoutManager(this );
        toDisplayQuizSummary.setLayoutManager( layoutManager );

        // Create a JobLeadsData instance, since we will need to save a new JobLead to the dn.
        // Note that even though more activities may create their own instances of the JobLeadsData
        // class, we will be using a single instance of the JobLeadsDBHelper object, since
        // that class is a singleton class.


        // Execute the retrieval of the job leads in an asynchronous way,
        // without blocking the UI thread.


        /* on click listener for image button */
        backImageButtonToHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backImageButtonToHomePage.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                ViewPastQuizzes.super.onBackPressed();
            }
        });

        /* write code to display quiz summary here  - RECYCLER */
    }
    // This is an AsyncTask class (it extends AsyncTask) to perform DB reading of job leads, asynchronously.


}
