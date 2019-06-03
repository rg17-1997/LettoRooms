package com.example.lenovo.navigationex;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SIGNIN extends AppCompatActivity {
    private TextView textView;
    private EditText useremail,userpassword;
    private Button button;
    private String semail,spassword;
    FirebaseAuth firebaseAuth;
    TextView forgot;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        textView=(TextView)findViewById(R.id.create);
        useremail=(EditText)findViewById(R.id.email);
        userpassword=(EditText)findViewById(R.id.password);
        forgot=(TextView)findViewById(R.id.forgotpass);
        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);

        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if(firebaseUser!=null) {
            Intent intent = new Intent(com.example.lenovo.navigationex.SIGNIN.this, DASHBOARD.class);
            startActivity(intent);
        }else {
            Toast.makeText(this,"Please Log In", Toast.LENGTH_SHORT).show();
        }




        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(com.example.lenovo.navigationex.SIGNIN.this,SIGNUP.class);
                startActivity(intent);
            }
        });
        button=(Button)findViewById(R.id.signin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(useremail.getText().toString(),userpassword.getText().toString());
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(com.example.lenovo.navigationex.SIGNIN.this, com.example.lenovo.navigationex.ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });

    }

    public void validate(String useremail, String password)
    {

        progressDialog.setMessage("Authenticating");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(useremail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    progressDialog.dismiss();
                    Toast.makeText(com.example.lenovo.navigationex.SIGNIN.this, "LOGIN SUCCESFUL", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(com.example.lenovo.navigationex.SIGNIN.this,DASHBOARD.class);
                    startActivity(intent);
                }
                else
                {
                    progressDialog.dismiss();
                    Toast.makeText(com.example.lenovo.navigationex.SIGNIN.this, "LOGIN NOT SUCCESFUL", Toast.LENGTH_SHORT).show();
                }}
        });

    }
}