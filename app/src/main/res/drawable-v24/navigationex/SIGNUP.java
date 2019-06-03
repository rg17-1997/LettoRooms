package com.example.lenovo.navigationex;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SIGNUP extends AppCompatActivity {

    private EditText useremail, userpassword, userconfirmpassword;
    private Button usersignup;
    String email,password,confirmpassword;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        useremail = (EditText) findViewById(R.id.email);
        userpassword = (EditText) findViewById(R.id.password);
        userconfirmpassword = (EditText) findViewById(R.id.confirmpassword);
        usersignup = (Button) findViewById(R.id.signup);
        firebaseAuth = FirebaseAuth.getInstance();

        usersignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( validate())
                {
                    //upload to database
                    Log.e("error ","inside on click");


                    firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(com.example.lenovo.navigationex.SIGNUP.this, "Registration Complete", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(com.example.lenovo.navigationex.SIGNUP.this,DASHBOARD.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(com.example.lenovo.navigationex.SIGNUP.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });
    }
    public boolean validate()
    {
        boolean b=false;
        email=useremail.getText().toString();password=userpassword.getText().toString();
        confirmpassword=userconfirmpassword.getText().toString();

        if(email.isEmpty()||password.isEmpty()||confirmpassword.isEmpty())
        {
            Toast.makeText(this, "PLEASE ENTER ALL THE DETAILS", Toast.LENGTH_LONG).show();
        }
        else
        {
            b=true;
        }
        return b;
    }

}
