package com.example.lenovo.navigationex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ABOUTUS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        Thread thread=new Thread()
        {
            @Override
            public void run() {
                try{
                    sleep(8000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally {
                    Intent intent=new Intent(com.example.lenovo.navigationex.ABOUTUS.this, com.example.lenovo.navigationex.Main2Activity.class);
                    startActivity(intent);
                }

            }
        };
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }






}
