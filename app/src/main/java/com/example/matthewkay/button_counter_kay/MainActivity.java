package com.example.matthewkay.button_counter_kay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Button ResetButton, IncrementButton, DecrementButton;
    public TextView CountText;
    public int count, color;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ResetButton = (Button) findViewById(R.id.ResetButton);
        IncrementButton = (Button) findViewById(R.id.IncrementButton);
        DecrementButton = (Button) findViewById(R.id.DecrementButton);
        CountText = (TextView) findViewById(R.id.CountText);
        CountText.setText(String.valueOf(count));


        ResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color = 0;
                CountText.setText(String.valueOf(0));
                CheckValue();
                Checkcolor();

            }
        });
        IncrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String countValue = CountText.getText().toString();
                count = Integer.parseInt(countValue);
                count++;
                CountText.setText(String.valueOf(count));
                color = 1;
                CheckValue();
                Checkcolor();

            }
        });
        DecrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String countValue = CountText.getText().toString();
                count = Integer.parseInt(countValue);
                count--;
                color = 2;
                CountText.setText(String.valueOf(count));
                CheckValue();
                Checkcolor();
            }
        });

        if(savedInstanceState != null){
            CountText.setText(String.valueOf(savedInstanceState.getInt("COUNTKEY")));
            color = savedInstanceState.getInt("COLORKEY");
            Checkcolor();
            CheckValue();

        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("COUNTKEY", count);
        outState.putInt("COLORKEY", color);

    }

    public void CheckValue(){
        if(Integer.parseInt(CountText.getText().toString()) < 0){
            CountText.setTextColor(getResources().getColor(R.color.Red));
        }
        else if(Integer.parseInt(CountText.getText().toString()) > 0){
            CountText.setTextColor(getResources().getColor(R.color.Green));
        }
        else if(Integer.parseInt(CountText.getText().toString()) == 0){
            CountText.setTextColor(getResources().getColor(R.color.White));
        }

    }


    public void Checkcolor(){
        if(color == 0){
            IncrementButton.setBackgroundColor(getResources().getColor(R.color.Black));
            DecrementButton.setBackgroundColor(getResources().getColor(R.color.Black));
            IncrementButton.setTextColor(getResources().getColor(R.color.White));
            DecrementButton.setTextColor(getResources().getColor(R.color.White));


        }
        else if (color == 1){
            IncrementButton.setBackgroundColor(getResources().getColor(R.color.Yellow));
            DecrementButton.setBackgroundColor(getResources().getColor(R.color.Black));
            IncrementButton.setTextColor(getResources().getColor(R.color.Black));
            DecrementButton.setTextColor(getResources().getColor(R.color.White));


        }
        else if(color == 2){
            IncrementButton.setBackgroundColor(getResources().getColor(R.color.Black));
            DecrementButton.setBackgroundColor(getResources().getColor(R.color.Yellow));
            DecrementButton.setTextColor(getResources().getColor(R.color.Black));
            IncrementButton.setTextColor(getResources().getColor(R.color.White));

        }


    }


}

