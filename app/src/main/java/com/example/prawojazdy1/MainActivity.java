package com.example.prawojazdy1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    private  Button buttonA;
    private  Button buttonB;
    private  Button buttonC;
    private  Button buttonD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonA= (Button) findViewById(R.id.buttonA);
        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openpyt();

            }
        });
        buttonB= (Button) findViewById(R.id.buttonB);
        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openpyt();
            }
        });
        buttonC= (Button) findViewById(R.id.buttonC);
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openpyt();
            }
        });
        buttonD= (Button) findViewById(R.id.buttonD);
        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openpyt();
            }
        });
    }

    public void openpyt(){

        Intent intent= new Intent(this, pyt.class);
        startActivity(intent);
    }



}
