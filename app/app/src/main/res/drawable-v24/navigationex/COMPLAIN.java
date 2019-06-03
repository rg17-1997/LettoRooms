package com.example.lenovo.navigationex;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.IOException;

public class COMPLAIN extends AppCompatActivity {
private FirebaseStorage firebaseStorage;
private ImageView imagecomplaint;
private Button submit,eimageiupload;
private EditText name,address,city,state,pincode,complaint;
private String consname,consaddress,consstate,conscity,conspincode,conscomplaint;
private  static int pick_image=1;
private FirebaseAuth mAuth;
private FirebaseDatabase firebaseDatabase;
private StorageReference storageReference;
private  FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
 private ProgressDialog pd;
 DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain);

        databaseReference = FirebaseDatabase.getInstance().getReference("complaints");

          mAuth = FirebaseAuth.getInstance();
        name=(EditText)findViewById(R.id.ename);
        address=(EditText)findViewById(R.id.eaddress);
        city=(EditText)findViewById(R.id.ecity);
        state=(EditText)findViewById(R.id.estate);
        pincode=(EditText)findViewById(R.id.epincode);
        complaint=(EditText)findViewById(R.id.ecompalint);
         submit=(Button)findViewById(R.id.btnSubmit);
         eimageiupload=(Button)findViewById(R.id.imageupload);

eimageiupload.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(com.example.lenovo.navigationex.COMPLAIN.this, com.example.lenovo.navigationex.UPLOADIMAGE.class);
        startActivity(intent);
    }
});

        //StorageReference storageReference=firebaseStorage.getReference();
        //imagecomplaint=(ImageView)findViewById(R.id.complaintimage);
       /*imagecomplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"SELECT IMAGE"),pick_image);
            }
        });
       */
        Log.e("tag","inside check1");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                consname=name.getText().toString();
                consaddress=address.getText().toString();
                conscity=city.getText().toString();
                consstate=state.getText().toString();
                conspincode=pincode.getText().toString();
                conscomplaint=complaint.getText().toString();


               if(consname.isEmpty()||conscomplaint.isEmpty()||conspincode.isEmpty()||consaddress.isEmpty()||consstate.isEmpty()||conscity.isEmpty())
              {
                  Log.e("tag","inside check2");
                  Toast.makeText(com.example.lenovo.navigationex.COMPLAIN.this, "FILL ALL DETAILS", Toast.LENGTH_SHORT).show();
               }
                else
                {
                    String id = databaseReference.push().getKey();
                    Log.e("tag","inside check3");
                    //sendUserData();
                    com.example.lenovo.navigationex.ComplainDetail complainDetail = new com.example.lenovo.navigationex.ComplainDetail(id,consname,consaddress,conscity,consstate,conspincode,conscomplaint);
                    databaseReference.child(id).setValue(complainDetail);
                    name.setText("");
                    address.setText("");
                    city.setText("");
                    state.setText("");
                    pincode.setText("");
                    complaint.setText("");
                    Log.e("tag","inside check4");
                    Toast.makeText(com.example.lenovo.navigationex.COMPLAIN.this, "Complaint sent", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(com.example.lenovo.navigationex.COMPLAIN.this,DASHBOARD.class);
                    startActivity(intent);
                }


            }
        });


    }
Uri imagepath;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==pick_image && resultCode==RESULT_OK &&data.getData()!=null)
        {
            imagepath=data.getData();
            try {
                Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),imagepath);
                imagecomplaint.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
   /* private void sendUserData()
    {
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference myRef =firebaseDatabase.getReference(mAuth.getUid());

        ComplainDetail complainDetail = new ComplainDetail(consname,consaddress,conscity,consstate,conspincode,conscomplaint);

        myRef.setValue(complainDetail);
    }*/

}
