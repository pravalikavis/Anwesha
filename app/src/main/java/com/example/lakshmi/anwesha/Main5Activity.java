package com.example.lakshmi.anwesha;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;


public class Main5Activity extends AppCompatActivity {

    EditText editText;
    EditText editText5;
    EditText editText6;
    EditText editText7;
    Button button5;
    String ques_no;
    String ques;
    String ans;
    String hint;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        editText=(EditText) findViewById(R.id.editText);
        editText5=(EditText) findViewById(R.id.editText5);
        editText6=(EditText) findViewById(R.id.editText6);
        editText7=(EditText) findViewById(R.id.editText7);
        button5=(Button) findViewById(R.id.button5);
        button5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //create child

                  ques_no=editText.getText().toString();
                 ques=editText5.getText().toString();
                 ans=editText6.getText().toString();
                 hint=editText7.getText().toString();
                 if(ques_no.isEmpty()||ques.isEmpty()||ans.isEmpty())
                 {
                     Toast.makeText(Main5Activity.this,"Please enter all feilds",Toast.LENGTH_SHORT).show();
                 }else{

               mDatabase.child(ques_no).child("q").setValue(ques);

                mDatabase.child(ques_no).child("a").setValue(ans);

                mDatabase.child(ques_no).child("h").setValue(hint);
                Toast.makeText(Main5Activity.this,"added successfully!!",Toast.LENGTH_SHORT).show();

                editText.setText("");
                editText5.setText("");
                editText6.setText("");
                editText7.setText("");}

            }
        });



    }
}
