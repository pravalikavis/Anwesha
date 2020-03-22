package com.example.lakshmi.anwesha;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.Uri;
import android.widget.MediaController;
import android.widget.VideoView;


public class Main6Activity extends AppCompatActivity {
    VideoView vidView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);


        vidView = (VideoView)findViewById(R.id.myVideo);
        String vidAddress = "android.resource://" + getPackageName() + "/" + R.raw.s_vedio;
        Uri vidUri = Uri.parse(vidAddress);

        vidView.setVideoURI(vidUri);
        vidView.start();
        vidView.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
            @Override
            public void onCompletion(MediaPlayer mp)
            {
                //start Previous Activity here

                Main6Activity.this.finish();
            }
        });
    }
}
