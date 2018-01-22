package com.example.asha.guesssit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Random r;
    int tries = 0, i ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = new Random();
        i = r.nextInt(1000) + 1;
    }

    public void click(View view) {

        et = findViewById(R.id.et);
        if (et.length() != 0) {
            int a = Integer.parseInt(et.getText().toString());

            if (tries < 9) {
                if (a > i) {
                    Toast.makeText(getApplicationContext(), a + " is greater than the Random Number", Toast.LENGTH_LONG).show();
                } else if (a < i) {
                    Toast.makeText(getApplicationContext(), a + " is smaller than the Random Number", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Correct!!! The random number was " + a, Toast.LENGTH_LONG).show();
                    tries = 0;
                    i = r.nextInt(1000) + 1;
                }
                tries++;
            }
            else if (tries == 9) {
                if (a == i) {
                    Toast.makeText(getApplicationContext(), "Correct!!! The random number was " + a, Toast.LENGTH_LONG).show();
                    tries = 0;
                    i = r.nextInt(1000) + 1;
                }
                else {
                    Toast.makeText(getApplicationContext(), "YOU LOSE! The number was " + i + ". Try Again...", Toast.LENGTH_SHORT).show();
                    tries = 0;
                    i = r.nextInt(1000) + 1;
                }
            }
        }
        else
            Toast.makeText(getApplicationContext(), "Enter a number first", Toast.LENGTH_SHORT).show();
    }

    public void reset(View view) {
        tries = 0;
        i = r.nextInt(1000) + 1;
        Toast.makeText(getApplicationContext(), "RESET DONE!", Toast.LENGTH_SHORT).show();
    }


}
