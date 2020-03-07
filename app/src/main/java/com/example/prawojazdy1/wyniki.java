package com.example.prawojazdy1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.content.Intent;


import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;

public class wyniki extends AppCompatActivity {
    Button button;
    Button rejestracja;
    EditText editText;
    Spinner spinner;
    TextView text;
    DatabaseReference databaseuser;
    ListView listViewuser;
    List<user> useerList;
    private DatabaseReference mMessagesRef;
    private Query mMessagesQuery;

    private ValueEventListener mMessagesListener;
    private ChildEventListener mMessagesQueryListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wyniki);

        databaseuser= FirebaseDatabase.getInstance().getReference("user");
        editText = (EditText) findViewById(R.id.editname);
        text = (TextView) findViewById(R.id.textView3);
        button = (Button) findViewById(R.id.button2);
        rejestracja = (Button) findViewById(R.id.buttonrejestracja);

        spinner = (Spinner) findViewById(R.id.spinner);

        listViewuser = (ListView)  findViewById(R.id.Listviewuser);
        useerList = new ArrayList<>();

       // Query query5 = FirebaseDatabase.getInstance().getReference("user").orderByChild("wynik");
        //query5.addListenerForSingleValueEvent();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();

            }

        });
        rejestracja.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open();
            }
        }));
        Bundle odebrane = getIntent().getExtras();
        int odebranedane= odebrane.getInt("bb");
        Bundle koszyk = new Bundle();
        koszyk.putInt("bb", odebranedane);
        text.setText(getResources().getString(R.string.kk) + odebranedane);


    }
    public String getUid(){
        return "42";
    }
    @Override
    public void onBackPressed(){
     super.onBackPressed();
     Intent i = new Intent(this, MainActivity.class);
     startActivity(i);

    }
    @Override
    protected void onStart() {
        super.onStart();
        basicListen();
        basicQuery();
        basicQueryValueListener();
        ValueEventListener  value = new ValueEventListener() {


            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {

                useerList.clear();
                if (dataSnapshot.exists()){
                for(DataSnapshot userSnapshot: dataSnapshot.getChildren()){
                    user useer = userSnapshot.getValue(user.class);

                    useerList.add(useer);

                }

                listuser adapter = new listuser(wyniki.this, useerList);
                listViewuser.setAdapter(adapter);


            }}

            @Override
            public void onCancelled( DatabaseError databaseError) {

            }
        };

    }

    private void add(){
        String name = editText.getText().toString().trim();
        String kat = spinner.getSelectedItem().toString();
        Bundle odebrane = getIntent().getExtras();
        int odebranedane= odebrane.getInt("bb");
        Bundle koszyk = new Bundle();
        koszyk.putInt("bb", odebranedane);

        if(name.isEmpty()){

            String id= databaseuser.push().getKey();
            user userbase = new user(id, name, kat, odebranedane );
            databaseuser.child(id).setValue(userbase);
            Toast.makeText(this,getString(R.string.mml),Toast.LENGTH_LONG).show();
            button.setEnabled(false);
            rejestracja.setVisibility(View.VISIBLE);
            rejestracja.setEnabled(true);
        }else {

            Toast.makeText(this,getString(R.string.mm),Toast.LENGTH_LONG).show();
        }
    }
    public void open(){

        Intent intent= new Intent(this, P.class);
        startActivity(intent);
    }
    public void basicListen() {
        // [START basic_listen]
        // Get a reference to Messages and attach a listener
        mMessagesRef = databaseuser.child("messages");
        mMessagesListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // New data at this path. This method will be called after every change in the
                // data at this path or a subpath.

                // Get the data as Message objects
              //  Log.d(TAG, "Number of messages: " + dataSnapshot.getChildrenCount());
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    // Extract a Message object from the DataSnapshot
                    Message message = child.getValue(Message.class);

                    // Use the Message
                    // [START_EXCLUDE]
                   // Log.d(TAG, "message text:" + message.get());
                    //Log.d(TAG, "message sender name:" + message.getName());
                    // [END_EXCLUDE]
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Could not successfully listen for data, log the error

            }
        };
        mMessagesRef.addValueEventListener(mMessagesListener);
        // [END basic_listen]
    }
    public void basicQuery() {
        // [START basic_query]
        // My top posts by number of stars
        String myUserId = getUid();
        Query myTopPostsQuery = databaseuser.child("user-posts").child(myUserId)
                .orderByChild("starCount");
        myTopPostsQuery.addChildEventListener(new ChildEventListener() {
            // TODO: implement the ChildEventListener methods as documented above
            // [START_EXCLUDE]
            public void onChildAdded(DataSnapshot dataSnapshot, String s) { }
            public void onChildChanged(DataSnapshot dataSnapshot, String s) { }
            public void onChildRemoved(DataSnapshot dataSnapshot) { }
            public void onChildMoved(DataSnapshot dataSnapshot, String s) { }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

            // [END_EXCLUDE]
        });
        // [END basic_query]
    }
    public void basicQueryValueListener() {
        String myUserId = getUid();
        Query myTopPostsQuery = databaseuser.child("user-posts").child(myUserId)
                .orderByChild("starCount");

        // [START basic_query_value_listener]
        // My top posts by number of stars
        myTopPostsQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    // TODO: handle the post
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message

                // ...
            }
        });
        // [END basic_query_value_listener]
    }
    public void cleanBasicListener() {
        // Clean up value listener
        // [START clean_basic_listen]
        mMessagesRef.removeEventListener(mMessagesListener);
        // [END clean_basic_listen]
    }

    public void cleanBasicQuery() {
        // Clean up query listener
        // [START clean_basic_query]
        mMessagesQuery.removeEventListener(mMessagesQueryListener);
        // [END clean_basic_query]
    }

    public void orderByNested() {
        // [START rtdb_order_by_nested]
        // Most viewed posts
        Query myMostViewedPostsQuery = databaseuser.child("posts")
                .orderByChild("metrics/views");
        myMostViewedPostsQuery.addChildEventListener(new ChildEventListener() {
            // TODO: implement the ChildEventListener methods as documented above
            // [START_EXCLUDE]
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot,  String s) {}

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {}

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
            // [END_EXCLUDE]
        });
        // [END rtdb_order_by_nested]
    }


    @Override
    public void onStop() {
        super.onStop();
        cleanBasicListener();
        cleanBasicQuery();
    }
}


