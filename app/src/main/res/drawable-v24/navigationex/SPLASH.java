package com.example.lenovo.navigationex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SPLASH extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
     /*   new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(3000);
                    startActivity(new Intent(SPLASH.this,Main2Activity.class));
                }catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }.start();
    }*/
}}
