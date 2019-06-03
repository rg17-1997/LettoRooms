package com.example.lenovo.navigationex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PROFILE extends AppCompatActivity {

    private EditText name,email,noofcomplaints;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name=findViewById(R.id.pname);
        email=findViewById(R.id.pemail);
        noofcomplaints=findViewById(R.id.pnoofcomplaints);
        button=findViewById(R.id.button3);
        name.setText("SAURABH GUPTA");
        email.setText("sg@gmail.com");
        noofcomplaints.setText("No.Of Complaints:1");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(com.example.lenovo.navigationex.PROFILE.this,DASHBOARD.class);
                startActivity(intent);
            }
        });


}

}
