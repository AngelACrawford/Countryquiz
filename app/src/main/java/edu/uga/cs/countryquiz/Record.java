package edu.uga.cs.countryquiz;

public class Record {
    private String date;
    private float result;

    /**
     * This constructor creates a new instance of a quiz record
     * @param date the date that the quiz was finished on
     * @param result the resulting score of the quiz, stored as a numerical value
     */
    public Record(String date, float result) {
        this.date = date;
        this.result = result;
    } // QuizRecord constructor

    /**
     * Returns the date that the quiz was finished on
     * @return the date that the quiz was finished on
     */
    public String getDate() {
        return date;
    } // getDate()

    /**
     * Returns the results of the quiz as a numerical score
     * @return the results of the quiz as a numerical score
     */
    public String getResult() {
        int intResult = (int) result;
        return Integer.toString(intResult);
    } // getResult()
}
