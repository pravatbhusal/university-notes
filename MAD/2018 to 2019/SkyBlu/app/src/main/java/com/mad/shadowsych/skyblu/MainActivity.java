package com.mad.shadowsych.skyblu;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView registerText;

    // a life-cycle method called when the app starts
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize the instance variables for the components
        handleRegisterText();
    }

    // handles the register text component
    private void handleRegisterText() {
        registerText = findViewById(R.id.registerText);

        // handle an on click listener
        registerText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // initiate the sign up activity intent
                Intent signUp = new Intent(MainActivity.this, SignUpActivity.class);

                // start the sign up activity with a smooth transition animation
                startActivity(signUp, ActivityOptions.makeSceneTransitionAnimation(
                                MainActivity.this).toBundle());
            }
        });
    }
}
