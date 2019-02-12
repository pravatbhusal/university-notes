package com.mad.shadowsych.maddice;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView diceImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // access the diceImage Image from the activity_main.xml to Java
        diceImage = findViewById(R.id.diceImage);

        // access the rollDiceBTN from the activity_main.xml to Java and setup the onClickListener
        Button rollDiceBTN = findViewById(R.id.rollDiceBTN);
        rollDiceBTN.setOnClickListener(new View.OnClickListener() {
            // whenever we click the rollDiceBTN, we execute this method
            @Override
            public void onClick(View view) {
                onClickRollDice(view);
            }
        });
    }

    /*
        Pre-condition: Connect the rollDiceBTN to this method
        Post-condition: Randomly change the diceImage whenever clicking the Roll Dice! button
     */
    public void onClickRollDice(View view) {
        // get a random value from 0 to 5 (0, 1, 2, 3, 4, 5)
        final int DICE_SIDES = 6;
        int diceFace = (int) (Math.random() * DICE_SIDES);

        // access the dice images into an Array
        final int[] DICE_IMAGES = new int[] {
             R.drawable.dice_one, R.drawable.dice_two, R.drawable.dice_three,
             R.drawable.dice_four, R.drawable.dice_five, R.drawable.dice_six
        };

        // set the diceImage to a random dice picture
        int diceDrawable = DICE_IMAGES[diceFace];
        diceImage.setImageResource(diceDrawable);

        // The Toast message will say "You rolled a X" where X is the diceFace plus one
        // Toast.makeText(this, "You rolled a " + (diceFace + 1), Toast.LENGTH_LONG).show();
        Snackbar.make(view, "You rolled a " + (diceFace + 1), Snackbar.LENGTH_LONG).show();
    }
}
