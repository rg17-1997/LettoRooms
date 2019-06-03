package com.example.lenovo.navigationex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NEEDS extends AppCompatActivity {
private EditText ename,eemail,eneeds;
private String nname,nemail,nneeds;
private Button button1;
DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_needs);


        databaseReference = FirebaseDatabase.getInstance().getReference("needs");

        ename=(EditText) findViewById(R.id.name1);
        eemail=(EditText)findViewById(R.id.email1);
        eneeds=(EditText)findViewById(R.id.needs1);
        button1=(Button)findViewById(R.id.btnSubmit1);
        nname=ename.getText().toString();
        nemail=eemail.getText().toString();
        nneeds=eneeds.getText().toString();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nname=ename.getText().toString();
                nemail=eemail.getText().toString();
                nneeds=eneeds.getText().toString();
                if(nname.isEmpty()||nemail.isEmpty()||nneeds.isEmpty())
                {
                    Toast.makeText(com.example.lenovo.navigationex.NEEDS.this, "FILL ALL DETAILS", Toast.LENGTH_SHORT).show();
                }
                else {
                    String id = databaseReference.push().getKey();
                    com.example.lenovo.navigationex.NeedsDetail needsDetail = new com.example.lenovo.navigationex.NeedsDetail(id,nname,nemail,nneeds);
                    databaseReference.child(id).setValue(needsDetail);
                    ename.setText("");
                    eemail.setText("");
                    eneeds.setText("");
                    Toast.makeText(com.example.lenovo.navigationex.NEEDS.this, "NEEDS FILED", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(com.example.lenovo.navigationex.NEEDS.this,DASHBOARD.class);
                    startActivity(intent);
                }
            }
        });
    }


}
