package com.example.prawojazdy1;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class pytd extends AppCompatActivity {
int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pytd);
    }
    public void tak(View o){
        a=a+1;


        if (a == 1 ) {

            String my = getResources().getString(R.string.pya1);
            display(my);
            ImageView image = (ImageView) findViewById(R.id.image);
            image.setImageDrawable(getDrawable(R.drawable.pyta1));
        }
        else
        if (a == 2 ) {
            String my = getResources().getString(R.string.pyd1);
            display(my);
            ImageView image = (ImageView) findViewById(R.id.image);
            image.setImageDrawable(getDrawable(R.drawable.pytd1));
        }
        else
        if (a == 3 ) {
            String my = getResources().getString(R.string.pyc2);
            display(my);
            ImageView image = (ImageView) findViewById(R.id.image);
            image.setImageDrawable(getDrawable(R.drawable.pytc2));
        }
        else
        if (a == 4 ) {
            String my = getResources().getString(R.string.pya1);
            display(my);
            ImageView image = (ImageView) findViewById(R.id.image);
            image.setImageDrawable(getDrawable(R.drawable.pyta1));

        }
        if (a == 5 ) {
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
            Button b = findViewById(R.id.button);
            b.setVisibility(View.VISIBLE);
            b.setEnabled(true);
        }
    }

    private void display (String number){
        TextView quantityTextView = (TextView) findViewById(R.id.textView);
        quantityTextView.setText("" + number);

    }

}
