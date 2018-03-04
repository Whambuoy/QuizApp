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
    Button submitButton = (Button) findViewById(R.id.submit);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitButton.setOnClickListener(this);

    }

    /**
     * This method is called when the submit button is clicked.
     */
    public void submitScore(View view) {

        CheckBox oneA = (CheckBox) findViewById(R.id.one_a);
        boolean first = oneA.isChecked();

        CheckBox oneB = (CheckBox) findViewById(R.id.one_b);
        boolean second = oneB.isChecked();
        int score = calculateScore(first, second);
        displayPrice(score);

    }

    /**
     * This method calculates the scores
     */

    private int calculateScore(boolean oneA, boolean oneB) {
        int score = 5;
        if (oneA) {
            score = score + 1;
        }
        if (oneB) {
            score = score;
        }
        return score;
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int score) {
        TextView priceTextView = (TextView) findViewById(R.id.order_score_text_view);
        priceTextView.setText(score);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.submit:
                submitScore(view);

        }

    }
}
