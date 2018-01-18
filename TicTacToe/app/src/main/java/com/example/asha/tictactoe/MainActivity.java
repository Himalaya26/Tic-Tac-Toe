package com.example.asha.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv1,tv2,tv3;
    ImageView iv1,iv2,b;
    int x=2,w=0;
    String y;
    int count =0;
    int[] values = {2,2,2,2,2,2,2,2,2};



    public void O (View view) {
        if (w== 0) {
            tv1 = findViewById(R.id.tv1);
            tv2 = findViewById(R.id.tv2);
            iv1 = findViewById(R.id.iv1);
            iv2 = findViewById(R.id.iv2);
            tv1.setAlpha(0f);
            tv2.setAlpha(0f);
            iv1.setAlpha(0f);
            iv2.setAlpha(0f);
            x = 0;
        }
    }

    public void X (View view) {
        if (w==0) {
            tv1 = findViewById(R.id.tv1);
            tv2 = findViewById(R.id.tv2);
            iv1 = findViewById(R.id.iv1);
            iv2 = findViewById(R.id.iv2);
            tv1.setAlpha(0f);
            tv2.setAlpha(0f);
            iv1.setAlpha(0f);
            iv2.setAlpha(0f);
            x = 1;
        }
    }
    public void reset (View view) {

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        iv1 = findViewById(R.id.iv1);
        iv2 = findViewById(R.id.iv2);
        tv3 = findViewById(R.id.tv3);
        ImageView b1 = findViewById(R.id.b1);
        ImageView b2 = findViewById(R.id.b2);
        ImageView b3 = findViewById(R.id.b3);
        ImageView b4 = findViewById(R.id.b4);
        ImageView b5 = findViewById(R.id.b5);
        ImageView b6 = findViewById(R.id.b6);
        ImageView b7 = findViewById(R.id.b7);
        ImageView b8 = findViewById(R.id.b8);
        ImageView b9 = findViewById(R.id.b9);
        tv1.setAlpha(1f);
        tv2.setAlpha(1f);
        tv3.setAlpha(0f);
        iv1.setAlpha(1f);
        iv2.setAlpha(1f);
        x=2;
        w=0;
        count = 0;
        b1.setAlpha(0f);
        b2.setAlpha(0f);
        b3.setAlpha(0f);
        b4.setAlpha(0f);
        b5.setAlpha(0f);
        b6.setAlpha(0f);
        b7.setAlpha(0f);
        b8.setAlpha(0f);
        b9.setAlpha(0f);
        iv1.setImageResource(R.drawable.zero);
        for (int i =0 ; i<9 ; i++) {
            values [i] = 2 ;
        }
    }

    public void won (int a) {
        tv3 = findViewById(R.id.tv3);
        iv1 = findViewById(R.id.iv1);
        if ( a == 1 ) {
            iv1.setImageResource(R.drawable.x);
        }
        iv1.animate().alpha(1f).setDuration(1000);
        tv3.animate().alpha(1f).setDuration(1000);
        w=1;
    }

    public void b (View view) {
        if (w==0) {
            if (x == 2)
                O(view);
            b = (ImageView) view;
            y = b.getTag().toString();
            if (values[Integer.parseInt(y)] == 2) {
                if (x == 0) {
                    b.setImageResource(R.drawable.zero);
                    values[Integer.parseInt(y)] = 0;
                } else {
                    b.setImageResource(R.drawable.x);
                    values[Integer.parseInt(y)] = 1;
                }
                b.animate().alpha(1f).setDuration(500);
                count++;

                //Checking if anyone has won

                if (values[0] == x) {
                    if (values[1] == x) {
                        if (values[2] == x)
                            won(x);
                    }
                    if (values[3] == x) {
                        if (values[6] == x)
                            won(x);
                    }
                    if (values[4] == x) {
                        if (values[8] == x)
                            won(x);
                    }
                }
                if (values[3] == x) {
                    if (values[4] == x)
                        if (values[5] == x)
                            won(x);
                }
                if (values[6] == x) {
                    if (values[4] == x) {
                        if (values[2] == x)
                            won(x);
                    }
                    if (values[7] == x) {
                        if (values[8] == x)
                            won(x);
                    }
                }
                if (values[1] == x) {
                    if (values[4] == x)
                        if (values[7] == x)
                            won(x);
                }
                if (values[2] == x) {
                    if (values[5] == x)
                        if (values[8] == x)
                            won(x);
                }
                if (count == 9)
                    Toast.makeText(getApplicationContext(), "Draw", Toast.LENGTH_SHORT).show();
                if (x == 0)
                    x = 1;
                else
                    x = 0;
            } else
                Toast.makeText(getApplicationContext(), "Already filled!!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
