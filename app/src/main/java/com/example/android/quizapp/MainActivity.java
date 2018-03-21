package com.example.android.quizapp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Build;
import android.widget.Button;
import android.view.ViewGroup;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int score = 0;
    Button submitButton, resetButton;
    TextView scoreTextView;
    CheckBox oneA, oneB, twoA, twoB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitButton = (Button) findViewById(R.id.submit);
        resetButton = (Button) findViewById(R.id.reset);
        scoreTextView = (TextView) findViewById(R.id.score_text_view);
        oneA = (CheckBox) findViewById(R.id.one_a);
        oneB = (CheckBox) findViewById(R.id.one_b);
        twoA = (CheckBox) findViewById(R.id.two_a);
        twoB = (CheckBox) findViewById(R.id.two_b);
        submitButton.setOnClickListener(this);
        resetButton.setOnClickListener(this);

    }

    /**
     * This method is called when the submit button is clicked.
     */
    public void submitScore(View view) {

        boolean first = oneA.isChecked();
        boolean second = oneB.isChecked();
        boolean first2 = twoA.isChecked();
        boolean second2 = twoB.isChecked();
        int score = calculateScore(first, second, first2, second2);
        displayScore(score);

    }

    /**
     * This method calculates the scores
     */

    private int calculateScore(boolean oneA, boolean oneB, boolean twoA, boolean twoB) {
        int score = 0;
        if ((oneA) && (!oneB)) {
            score = score + 1;
        }
        else{
            score = 0;
        }
        if ((twoA) && (!twoB)) {
            score = score + 1;
        }
        else{
            score = score + 0;
        }
        return score;
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayScore(int score) {
        scoreTextView.setText("" + score);
    }
    /**
     * This method resets the score.
     */
    public void resetScore(View view) {
        score = 0;
        scoreTextView.setText(String.valueOf(score));
    }

    /**
     * This method resets the score to zero.
     */

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.submit:
                submitScore(view);
                break;
            case R.id.reset:
                resetScore(view);
                break;
        }

    }
}
