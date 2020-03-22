package com.example.lakshmi.anwesha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;



public class Main4Activity extends AppCompatActivity {

    TextView textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        textView3=(TextView) findViewById(R.id.textView3);
        String passedArg = getIntent().getExtras().getString("marks");
        textView3.setText(passedArg);




    }
    @Override
    public void onBackPressed()
    {

        //Toast.makeText(getApplicationContext(),"Back button clicked", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Main4Activity.this, MainActivity.class);

        startActivity(intent);
        return;
    }



}
