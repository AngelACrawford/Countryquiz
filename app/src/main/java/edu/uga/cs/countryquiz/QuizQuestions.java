package edu.uga.cs.countryquiz;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;

public class QuizQuestions extends AppCompatActivity {
    Country [] countries ; //gets data from onCreate
    ArrayList<String> countriesAlreadyUsed = new ArrayList<String>(); // This keeps track of which countries have already been used so that there is no repeats in the quiz.
    IndividualQuizQuestion question1 ;
    IndividualQuizQuestion question2 ;
    IndividualQuizQuestion question3 ;
    IndividualQuizQuestion question4 ;
    IndividualQuizQuestion question5 ;
    IndividualQuizQuestion question6 ;
    final String TAG = "Creating Questions" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_file); //Just using this to test. I think you know the correct layout ?

        // Retrieve the countries array from the Intent extras
        this.countries = (Country[]) getIntent().getSerializableExtra("countries");
        question1 = new IndividualQuizQuestion() ;
        countriesAlreadyUsed.add(question1.getCountryName()) ;

        question2 = this.createUniqueQuestion();
        countriesAlreadyUsed.add(question2.getCountryName()) ;

        question3 = this.createUniqueQuestion() ;
        countriesAlreadyUsed.add(question3.getCountryName()) ;

        question4 = this.createUniqueQuestion() ;
        countriesAlreadyUsed.add(question4.getCountryName()) ;

        question5 = this.createUniqueQuestion() ;
        countriesAlreadyUsed.add(question5.getCountryName()) ;

        question6 = this.createUniqueQuestion() ;
        countriesAlreadyUsed.add(question6.getCountryName()) ;

        Log.d(TAG, "QUESTION LIST = " + countriesAlreadyUsed.toString()) ;



    }

    public IndividualQuizQuestion createUniqueQuestion() {
        boolean unique = false;
        IndividualQuizQuestion q = new IndividualQuizQuestion();
        while (unique ==false ) {
            if (countriesAlreadyUsed.contains(q)) {
                q = new IndividualQuizQuestion() ; //Recreate the question as it has already been used.
            }
            else {
                unique = true;
                return q;
            }
        }
        return q;
    }

    //This method is just for sending the Array of countries received from the intent to the IndiviudalQuizQuestion class.
    public  Country[] getCountries() {
        return this.countries;
    }

    public class IndividualQuizQuestion{

        String countryName ;
        String correctAnswer ;
        String falseAnswer1 ;
        String falseAnswer2 ;
        Country[] countries = QuizQuestions.this.getCountries();
        String[] listOfContinents = {"Africa", "Antarctica", "Asia", "Australia", "Europe", "North America", "South America"};

        final String TAG = "Creating Questions" ;

        public IndividualQuizQuestion() {
            this.createQuestion();
        }

        public String getCountryName(){
            return this.countryName ;
        }

        public String getCorrectAnswer(){
            return this.correctAnswer;
        }

        public String getFalseAnswer1(){
            return this.falseAnswer1;
        }

        public String getFalseAnswer2(){
            return this.falseAnswer2;
        }
        public void createQuestion(){
            Random rand = new Random() ;
            int randomNumber = rand.nextInt(195) ; //Generates random int from 0 - 194
            Country countryAnswer = countries[randomNumber] ;  // Finds a random country
            this.countryName = countryAnswer.getCountry() ;
            this.correctAnswer = countryAnswer.getContinent() ;

            boolean falseAnswer1Generated = false ;
            while (falseAnswer1Generated == false ) {
                int randomNumber2 = rand.nextInt(7); //Generates random int from 0 - 6
                String potentialFalseAnswer1 = listOfContinents[randomNumber2];

                if(!potentialFalseAnswer1.equals(this.correctAnswer)) {
                     this.falseAnswer1 = potentialFalseAnswer1 ; // Assign falseanswer1
                    falseAnswer1Generated = true; //Turn loop off, as false answer 1 is unique ...
                }

            }

            boolean falseAnswer2Generated = false ;
            while (falseAnswer2Generated == false ) {
                int randomNumber2 = rand.nextInt(7); //Generates random int from 0 - 6
                String potentialFalseAnswer2 = listOfContinents[randomNumber2];
                if(!potentialFalseAnswer2.equals(this.correctAnswer) && !potentialFalseAnswer2.equals(falseAnswer1)) {
                    this.falseAnswer2 = potentialFalseAnswer2 ; // Assign falseanswer1
                    falseAnswer2Generated = true; //Turn loop off, as false answer 1 is unique ...
                }
            }

        }

        public void printQuestionInfo() {
        Log.d(TAG,"== Question Info == " ) ;
        Log.d(TAG, "Country Name = " + this.countryName + " | Correct Answer = " + this.correctAnswer) ;
        Log.d(TAG, "False Answer 1 = " + falseAnswer1 + "|  False Answer 2 = " + falseAnswer2 ) ;


        }

    }





}



