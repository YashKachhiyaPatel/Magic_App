package com.example.magic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class second extends AppCompatActivity {
    ArrayList<String> numbers = new ArrayList<String>();
    TextView listNumber,pageNumber;
    Button yes,no;
    int count=0,sum=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        numbers.add(0, "1 3 5 7 9 11 13 15\n\t17 19 21 23 25 27 29 31\n33 35 37 39 41 43 45 47\n\t49 51 53 55 57 59 61 63");
        numbers.add(1,"2 3 6 7 10 11 14 15\n\t18 19 22 23 26 27 30 31\n34 35 38 39 42 43 46 47\n\t50 51 54 55 58 59 62 63");
        numbers.add(2,"4 5 6 7 12 13 14 15\n\t20 21 22 23 28 29 30 31\n36 37 38 39 44 45 46 47\n\t52 53 54 55 60 61 62 63");
        numbers.add(3,"8 9 10 11 12 13 14 15\n\t24 25 26 27 28 29 30 31\n40 41 42 43 44 45 46 47\n\t56 57 58 59 60 61 62 63");
        numbers.add(4,"16 17 18 19 20 21 22 23\n\t24 25 26 27 28 29 30 31\n48 49 50 51 52 53 54 55\n\t56 57 58 59 60 61 62 63");
        numbers.add(5,"32 33 34 35 36 37 38 39\n\t40 41 42 43 44 45 46 47\n48 49 50 51 52 53 54 55\n\t56 57 58 59 60 61 62 63");

        listNumber = findViewById(R.id.arrayNumbers);
        listNumber.setText(numbers.get(count).toString());
        pageNumber = findViewById(R.id.pages);
        yes = findViewById(R.id.btnYes);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if (count == 0) {
                        sum += 1;
                    } else if (count == 1) {
                        sum += 2;
                    } else if (count == 2) {
                        sum += 4;
                    } else if (count == 3) {
                        sum += 8;
                    } else if (count == 4) {
                        sum += 16;
                    } else if (count == 5) {
                        sum += 32;
                        callThirdPage();
                    }
                if (count < 5) {
                   nextPage();
                }

            }
        });

        no = findViewById(R.id.btnNo);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count < 5) {
                    nextPage();
                }else{
                    callThirdPage();
                }
            }
        });
    }

    private void nextPage() {
        count++;
        listNumber.setText(numbers.get(count).toString());
        pageNumber.setText("("+(count+1)+"/6)");
    }

    private void callThirdPage() {
        Intent intent = new Intent(getApplicationContext(),third.class);
        intent.putExtra("answer",sum);
        startActivity(intent);
    }
}