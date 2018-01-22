package com.example.matthewkay.button_counter_kay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Button ResetButton, IncrementButton, DecrementButton;
    public TextView CountText;
    public int count;



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
                IncrementButton.setBackgroundColor(getResources().getColor(R.color.Black));
                DecrementButton.setBackgroundColor(getResources().getColor(R.color.Black));
                IncrementButton.setTextColor(getResources().getColor(R.color.White));
                DecrementButton.setTextColor(getResources().getColor(R.color.White));

                CountText.setText(String.valueOf(0));
                CheckValue();

            }
        });
        IncrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String countValue = CountText.getText().toString();
                count = Integer.parseInt(countValue);
                count++;
                CountText.setText(String.valueOf(count));
                IncrementButton.setBackgroundColor(getResources().getColor(R.color.Yellow));
                DecrementButton.setBackgroundColor(getResources().getColor(R.color.Black));
                IncrementButton.setTextColor(getResources().getColor(R.color.Black));
                DecrementButton.setTextColor(getResources().getColor(R.color.White));
                CheckValue();

            }
        });
        DecrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String countValue = CountText.getText().toString();
                count = Integer.parseInt(countValue);
                count--;
                CountText.setText(String.valueOf(count));
                IncrementButton.setBackgroundColor(getResources().getColor(R.color.Black));
                DecrementButton.setBackgroundColor(getResources().getColor(R.color.Yellow));
                DecrementButton.setTextColor(getResources().getColor(R.color.Black));
                IncrementButton.setTextColor(getResources().getColor(R.color.White));

                CheckValue();
            }
        });

        if(savedInstanceState != null){
            CountText.setText(String.valueOf(savedInstanceState.getInt("COUNTKEY")));
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("COUNTKEY", count);

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


}

