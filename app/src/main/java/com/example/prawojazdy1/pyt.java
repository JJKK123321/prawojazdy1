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


public class pyt extends AppCompatActivity {
int a;
int b=0;
int c;


Button buttont;
Button buttonn;
Button buttons;
Boolean isclicked=false;
Boolean clicked=false;


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


            }
        });

                buttons= (Button) findViewById(R.id.buttons);
                buttons.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openpyt();



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
    Button gs = findViewById(R.id.buttons);
    gs.setVisibility(View.VISIBLE);
    gs.setEnabled(true);

}
    public void app(View c){

        String my = getResources().getString(R.string.s);
        display(my);
        ImageView image = (ImageView) findViewById(R.id.image);
        image.setImageDrawable(getDrawable(R.drawable.koniec));
        TextView qTextView = (TextView) findViewById(R.id.k);
        qTextView.setText(getResources().getString(R.string.kk) + b);

    }

    public void openpyt(){


        Intent intent= new Intent(this, wyniki.class);
        startActivity(intent);
        Bundle koszyk = new Bundle();
        koszyk.putInt("bb", b);
    Intent i = new Intent(this, wyniki.class);
        i.putExtras(koszyk);
    startActivity(i);

}

    }




