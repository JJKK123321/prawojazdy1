package com.example.prawojazdy1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class P extends AppCompatActivity {
    EditText email;
    EditText haslo;
    Button signup;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p);
        email = (EditText)findViewById(R.id.editEmail);
        haslo = (EditText)findViewById(R.id.editPassword);
        signup = (Button) findViewById(R.id.buttonsign);

        auth = FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                signUp();

            }
        });

    }

    private void signUp() {
        String eemail, haaslo;
        eemail = email.getText().toString();
        haaslo = haslo.getText().toString();

        auth.createUserWithEmailAndPassword(eemail, haaslo).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    Toast.makeText(P.this, "GGGG", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(P.this, "Błąd", Toast.LENGTH_SHORT).show();

                }
            }
        });



    }


}
