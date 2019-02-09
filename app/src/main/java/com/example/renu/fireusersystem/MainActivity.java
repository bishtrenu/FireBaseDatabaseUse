package com.example.renu.fireusersystem;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

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
            String userid=uname.getText().toString().trim();
            String username=name.getText().toString().trim();
            String useremail=email.getText().toString().trim();
                HashMap<String,String> usermap=new HashMap<String, String>();
                usermap.put("id",userid);
                usermap.put("name",username);
                usermap.put("email",useremail);
                userRef.push().setValue(usermap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
}
