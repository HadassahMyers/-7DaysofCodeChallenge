package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.Toast;


/**
 * This app displays a quiz about Type 1 Diabetes
 */


public class MainActivity extends AppCompatActivity {

    //initiate the score
    int score = 0;
    int score1 = 0;
    int score2 = 0;
    int score3 = 0;
    int score4 = 0;
    int score5 = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * Checks if Question 1 is answered correctly
     */

//radio Button clicked
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.wrong_radio_button:
                if (checked)
                    // Yes
                    score1 = 0;
                Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show();

                break;
            case R.id.right_radio_button:
                if (checked)
                    // No
                    score = score + 1;
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                score1 = 1;
                break;

        }
    }

    // When done button is clicked
    public void CalcScore1Show(View view) {
        Toast.makeText(this, "Points scored for Q1 are: " + score1 + ", Your score so far is: " + score, Toast.LENGTH_LONG).show();
    }   //closes off the done click button

    //this private method will keep track of the points scored in question 1, and return the points
    private int CalcScore1(int score1st) {
        return score1;
    }

    /**
     * Checks if Question 2 is answered correctly
     */

    // if the correct button is clicked (This could be done with an on click listener if I had more time to experiment)
    public void rangeYes(View view) {

        if (view.getId() == R.id.in_range) {
            score = score + 1;
            score2 = 1;
            Toast.makeText(this, "That is correct!", Toast.LENGTH_SHORT).show();

        }

    }

    public void rangeNo(View view) {

        if (view.getId() == R.id.outOf_range) {
            score2 = 0;
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();

        }
    }

    // When done button is clicked
    public void CalcScore2Show(View view) {
        Toast.makeText(this, "Points scored for Q2 are: " + score2 + ", Your score so far is: " + score, Toast.LENGTH_LONG).show();
    }
    //end done button method

    //this private method will keep track of the points scored in question 2, and return the points
    private int CalcScore2(int score2nd) {
        return score2;
    }

    /**
     * Checks if Question 3 is answered correctly
     */

// Question 3- Done Button Clicked to submit
    public void CalcScore3Show(View view) {
        // Get user's input
        EditText insulinField = (EditText) findViewById(R.id.insulin_field);
        Editable insulinEditable = insulinField.getText();
        String insulinAnswer = insulinEditable.toString();


        // Checks if Input for question 3 is correct (insulin)
        if ((insulinAnswer.equalsIgnoreCase("insulin") || (insulinAnswer.equals("Insulin")))) {
            Toast.makeText(this, "You got it right!", Toast.LENGTH_SHORT).show();
            score = score + 1;
            score3 = 1;
        }

        //if the answer is incorrect they will get a toast message
        if (!insulinAnswer.equalsIgnoreCase("insulin")) {
            Toast.makeText(this, "You got it wrong this time, you wrote: " +insulinAnswer + ", but the correct answer is: Insulin", Toast.LENGTH_LONG).show();
            score3 = 0;
        }

        Toast.makeText(this, "Your score for question 3 is: " + score3 +", Your score so far is: " + score, Toast.LENGTH_LONG).show();

    }

    //this private method will keep track of the points scored in question 3, and return the points
    private int CalcScore3(int score3rd) {
        return score3;
    }

    /**
     * Checks if Question 4 is answered correctly
     */


    public void chickenClick(View view) {
        score4 = 0;
        Toast.makeText(this, "Incorrect!" , Toast.LENGTH_SHORT).show();
    }

    public void pizzaClick(View view) {
        score = score + 1;
        score4 = 1;
        Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
    }

    public void saladClick(View view) {
        score4 = 0;
        Toast.makeText(this, "Incorrect!" + score4, Toast.LENGTH_SHORT).show();
    }

    //this private method will keep track of the points scored in question 4, and return the points
    private int CalcScore4(int score4th) {
        return score4;
    }

    // when user clicks done
    public void CalcScore4Show(View view) {
        Toast.makeText(this, "Your score is for question 4 is: " + score4 + ", Your score so far is: " + score , Toast.LENGTH_LONG).show();
    }

    /**
     * Checks if Question 5 is answered correctly and calculates points scored
     */

// This method wraps up question 5- evoked when done button is clicked
    public void CalcScore5Show(View view) {

        // These lines of code keep track of Question 5
        // Figure out if the user checked the 1st answer to question 5
        CheckBox Q5_fo_CheckBox = (CheckBox) findViewById(R.id.question5_one_checkbox);
        boolean Q5_food1 = Q5_fo_CheckBox.isChecked();

        // Figure out if the user checked the 2nd answer to question 5
        CheckBox Q5_ex_CheckBox = (CheckBox) findViewById(R.id.question5_two_checkbox);
        boolean Q5_Excercise2 = Q5_ex_CheckBox.isChecked();

        // Figure out if the user checked the 3rd answer to question 5
        CheckBox Q5_re_CheckBox = (CheckBox) findViewById(R.id.question5_three_checkbox);
        boolean Q5_Reading3 = Q5_re_CheckBox.isChecked();

        // 1st and 2nd must be checked, 3rd must not

        //If user checks food checkbox they get a point
        if (Q5_food1) {
            score = score + 1;
            score5 = score5 + 1;
            Toast.makeText(this, "Correct you get 1 point", Toast.LENGTH_SHORT).show();
        }

        // If user checks excercise checkbox they get a point
        if (Q5_Excercise2) {
            score = score + 1;
            score5 = score5 + 1;
            Toast.makeText(this, "Correct you get 1 point", Toast.LENGTH_SHORT).show();
        }

        //If user checks reading checkbox they do not get a point, and don't lose one either
        if (Q5_Reading3) {
            score5 = score5 + 0;
            Toast.makeText(this, "Sorry, that isn't correct, no points", Toast.LENGTH_SHORT).show();
        }

        // user feedback for question 5
        Toast.makeText(this, "Your score is for question 5 is: " + score5 + ", Your score so far is: " + score , Toast.LENGTH_LONG).show();
    }

    //this private method will keep track of the points scored in question 5, and return the points
    private int CalcScore5(int score5th) {
        return score5;
    }


    /**
     * This method is called when player selects FINISH.
     */


    public void CalcScore(View view) {

        CalcScore1(score1);
        //Log.v("activity_main", "Your final score for Question 1 is: " + CalcScore1(score1));
        CalcScore2(score2);
        //Log.v("activity_main", "Your final score for Question 2 is: " + CalcScore2(score2));
        CalcScore3(score3);
        //Log.v("activity_main", "Your final score for Question 3 is: " + CalcScore3(score3));
        CalcScore4(score4);
        //Log.v("activity_main", "Your final score for Question 4 is: " + CalcScore4(score4));
        CalcScore5(score5);
        //Log.v("activity_main", "Your final score for Question 5 is: " + CalcScore5(score5));

        // Total score for the game out of 6
        //Log.v("activity_main", "Your final score is: " + score);
        Toast.makeText(this, "Well done! Your final score is: " + score, Toast.LENGTH_LONG).show();
    }

}