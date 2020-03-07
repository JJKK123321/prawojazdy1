package com.example.prawojazdy1;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class pytb extends AppCompatActivity {
    int a;
    int b=0;
    int c;

    Button buttont;
    Button buttonn;
    Boolean isclicked=false;
    Boolean clicked=false;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference ww = mRootRef.child("wartosc");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pyt);

        buttont= (Button) findViewById(R.id.tak);
        buttont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                takk(a);
                clicked=true;


            }
        });
        buttonn= (Button) findViewById(R.id.nie);
        buttonn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                takk(a);
                isclicked=true;
                ww.setValue(1);

            }
        });

    }

    protected void start(){
        super.onStart();
        ww.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String number = dataSnapshot.getValue(String.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
    private void suma(){
        b=b+1;
    }





    private void takk(int o){
        a=a+1;


        if (a == 1 ) {

            String my = getResources().getString(R.string.pya1);
            display(my);
            ImageView image = (ImageView) findViewById(R.id.image);
            image.setImageDrawable(getDrawable(R.drawable.pyta1));

            if(isclicked==true){
                suma();
            }


        }
        else
        if (a ==2  ) {
            String my = getResources().getString(R.string.pya4);
            display(my);
            ImageView image = (ImageView) findViewById(R.id.image);
            image.setImageDrawable(getDrawable(R.drawable.pyta4));
            if(isclicked==true){
                suma();
            }

        }
        else
        if (a == 3  ) {
            String my = getResources().getString(R.string.pya3);
            display(my);
            ImageView image = (ImageView) findViewById(R.id.image);
            image.setImageDrawable(getDrawable(R.drawable.pyta3));
            if(clicked==true){
                suma();
            }

        }
        else
        if (a == 4 ) {
            String my = getResources().getString(R.string.pyb1);
            display(my);
            ImageView image = (ImageView) findViewById(R.id.image);
            image.setImageDrawable(getDrawable(R.drawable.pytb1));
            if(clicked==true){
                suma();
            }



        }
        if (a == 5  ) {
            String my = getResources().getString(R.string.s);
            display(my);
            ImageView image = (ImageView) findViewById(R.id.image);
            image.setImageDrawable(getDrawable(R.drawable.koniec));
            Button t = findViewById(R.id.tak);
            t.setVisibility(View.GONE);
            t.setEnabled(false);
            Button n = findViewById(R.id.nie);
            n.setVisibility(View.GONE);
            n.setEnabled(false);
            Button g = findViewById(R.id.button);
            g.setVisibility(View.VISIBLE);
            g.setEnabled(true);

        }

    }

    private void display (String number) {
        TextView quantityTextView = (TextView) findViewById(R.id.textView);
        quantityTextView.setText("" + number);

    }

    public void ap(View c){

        String my = getResources().getString(R.string.s);
        display(my);
        ImageView image = (ImageView) findViewById(R.id.image);
        image.setImageDrawable(getDrawable(R.drawable.koniec));
        TextView qTextView = (TextView) findViewById(R.id.k);
        qTextView.setText(getResources().getString(R.string.kk) + b);
    }


}




