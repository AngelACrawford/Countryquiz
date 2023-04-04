Hey Angel ,

Soooo basically, if you run the app right now, and click start new quiz, it will take you to a blank layout ( I was just using for testing purposes) .
If you open up the Run tab at the bottom of Android Studios, you will see the names of the countries for each question. 

I have created an Country object that stores the information of each Country, and each country is placed into an array called "countries", this array is the pushed to QuizQuestions using an intent. 

In QuizQuestions.java, it has a subclass nested inside called "IndividualQuizQuestions", the QuizQuestions then creates 6 unique quiz questions (As in each question has a unique Country, a correct answer,  and 2 false answers )
The IndividualQuizQuestion object has getters to return all the information you would need for each question in order to place it onto the layout.

I'm not sure if I did it exactly as you wanted, but I think that you should be able to use this to correctly fill in the layouts. 

I will begin working on the quiz results and saving that info once you have finished adding them to the layouts and a quiz is able to be completed. 
