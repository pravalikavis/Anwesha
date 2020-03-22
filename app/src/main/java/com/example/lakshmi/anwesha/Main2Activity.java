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
import java.util.Random;
import android.os.CountDownTimer;
import android.widget.ProgressBar;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class Main2Activity extends Activity {

    int min_num = 1;
    TextView textview;
    Button button2;
    int randomNumber;
    Random rand = new Random();
    ProgressBar progressBar;
    MyCountDownTimer myCountDownTimer;
    private DatabaseReference mDatabase;
    EditText edittext2;
    Button button3;
    int marks;
    String hint;
    String r_ans;
    int vedio_toggle;

    int r;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textview = (TextView) findViewById(R.id.textView3);
        edittext2=(EditText) findViewById(R.id.editText2);
        button2 = (Button) findViewById(R.id.button2);
       // button3=(Button) findViewById(R.id.button3);

        rand = new Random();
        randomNumber = min_num+rand.nextInt(241);
        progressBar = (ProgressBar) findViewById(R.id.determinateBar);
        textview.setText(Integer.toString(randomNumber));
        mDatabase=FirebaseDatabase.getInstance().getReference().child(Integer.toString(randomNumber));

        progressBar.setProgress(100);
        myCountDownTimer = new MyCountDownTimer(600000, 1000);
        myCountDownTimer.start();
        marks=0;
        vedio_toggle=0;

        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                 hint= (String) dataSnapshot.child("h").getValue().toString();
                 r_ans= (String) dataSnapshot.child("a").getValue().toString();




            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


      /*  button3.setOnClickListener(new View.OnClickListener(){


            public void onClick(View v)
            {





                        Toast.makeText(Main2Activity.this,hint,Toast.LENGTH_LONG).show();
                        marks=marks-5;


            }
        });*/

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                randomNumber =min_num+ rand.nextInt(241);
                mDatabase=FirebaseDatabase.getInstance().getReference().child(Integer.toString(randomNumber));

                textview.setText(Integer.toString(randomNumber));

               //mDatabase=FirebaseDatabase.getInstance().getReference().child("1");

                //Toast.makeText(MainActivity.this,mDatabase.child("Name").getKey(),Toast.LENGTH_SHORT).show();
                //assign value to child
                mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        hint= (String) dataSnapshot.child("h").getValue().toString();
                        r_ans= (String) dataSnapshot.child("a").getValue().toString().trim().toLowerCase();




                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                final String ans=edittext2.getText().toString().trim().toLowerCase();
                vedio_toggle=vedio_toggle+1;
                if(vedio_toggle==3)
                {
                    Intent intent = new Intent(Main2Activity.this, Main6Activity.class);

                    startActivity(intent);
                }
                        if (ans.equals(r_ans)){
                            //do something
                            vedio_toggle=vedio_toggle+1;
                           // Toast.makeText(Main2Activity.this,"correct answer",Toast.LENGTH_SHORT).show();
                            marks=marks+10;


                        }else {
                            //do something

                        }
                        edittext2.setText("");

            }
        });
    }

    public void next() {

        final Context context = this;


        Intent intent = new Intent(context, Main4Activity.class);
        intent.putExtra("marks",Integer.toString(marks));

        startActivity(intent);


    }




    public class MyCountDownTimer extends CountDownTimer {
        EditText ed;
        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {

            int progress = (int) (millisUntilFinished / 6000);
            progressBar.setProgress(progress);
            if(progress==10)
            {
                Toast.makeText(Main2Activity.this,"HURRY UP! You Have Less time",Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        public void onFinish() {
            ed=(EditText) findViewById(R.id.editText2);
            ed.setText("Task completed");
            progressBar.setProgress(0);


            next();
        }
    }

}