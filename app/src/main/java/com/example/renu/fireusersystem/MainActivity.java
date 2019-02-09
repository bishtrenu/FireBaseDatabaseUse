package com.example.renu.fireusersystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
FirebaseDatabase db=FirebaseDatabase.getInstance();
DatabaseReference rootref=db.getReference();
EditText uname,name,email;
Button submit;
DatabaseReference userRef=rootref.child("Users");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname=findViewById(R.id.username);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
}
