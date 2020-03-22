package com.example.lakshmi.anwesha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


public class MainActivity extends Activity {

    Button button;
    EditText txtname;
    Button but4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = (Button) findViewById(R.id.button);
       // but4=(Button) findViewById(R.id.button4);
        button.setOnClickListener(new OnClickListener() {


            @Override
            public void onClick(View arg0) {

                txtname = (EditText)findViewById(R.id.editText3);
                String name      =  txtname.getText().toString();
                if(name.toLowerCase().trim().equals("ahps75"))
                {Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    txtname.setText("");
                    startActivity(intent);}
                else{
                    Toast.makeText(MainActivity.this,"key incorrect",Toast.LENGTH_SHORT).show();
                }

            }

        });
       /* but4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main5Activity.class);

                startActivity(intent);
            }
        });*/
    }


}