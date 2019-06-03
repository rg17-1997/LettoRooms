package com.example.lenovo.navigationex;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {

    Button btnResetPassword;
    EditText etResetPassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        btnResetPassword = (Button) findViewById(R.id.btnResetbutton);
        etResetPassword = (EditText) findViewById(R.id.etResetEmail);

        mAuth = FirebaseAuth.getInstance();

        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = etResetPassword.getText().toString().trim();

                if(email.equals("")){
                    Toast.makeText(com.example.lenovo.navigationex.ForgotPasswordActivity.this,"Please Enter Valid Email Id", Toast.LENGTH_SHORT).show();
                }else {
                    /*mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(ForgotPasswordActivity.this,"Reset Password link send on your Email Id",Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(ForgotPasswordActivity.this,"Enter valid Email Id which is already registered",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });*/
                    FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(com.example.lenovo.navigationex.ForgotPasswordActivity.this,"Reset Password link send on your Email Id", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
    }
}