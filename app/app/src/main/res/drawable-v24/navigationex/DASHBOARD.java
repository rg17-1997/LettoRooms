package com.example.lenovo.navigationex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import static com.example.lenovo.navigationex.R.id.complainbox;

public class DASHBOARD extends AppCompatActivity {
   private ImageView complainimageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


         complainimageButton = (ImageView) findViewById(R.id.complainbox);
complainimageButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(com.example.lenovo.navigationex.DASHBOARD.this, com.example.lenovo.navigationex.COMPLAIN.class);
        startActivity(intent);
    }
});
        ImageView feedbackimageButton;

        feedbackimageButton = (ImageView) findViewById(R.id.feedbackbox);
        feedbackimageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(com.example.lenovo.navigationex.DASHBOARD.this, com.example.lenovo.navigationex.FEEDBACK.class);
                startActivity(intent);
            }
        });


        ImageView needsimageButton;

        needsimageButton = (ImageView) findViewById(R.id.needsbox);
        needsimageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(com.example.lenovo.navigationex.DASHBOARD.this, com.example.lenovo.navigationex.NEEDS.class);
                startActivity(intent);
            }
        });

        ImageView aboutusimageButton;
        aboutusimageButton = (ImageView) findViewById(R.id.aboutus);
        aboutusimageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(com.example.lenovo.navigationex.DASHBOARD.this, com.example.lenovo.navigationex.ABOUTUS.class);
                startActivity(intent);
            }
        });

        ImageView profileimageButton;
        profileimageButton = (ImageView) findViewById(R.id.profile);
        profileimageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(com.example.lenovo.navigationex.DASHBOARD.this, com.example.lenovo.navigationex.PROFILE.class);
                startActivity(intent);
            }
        });

    }
}
