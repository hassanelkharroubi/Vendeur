package com.tacheyourself.vendeur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tacheyourself.vendeur.httpRequest.Request;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    private EditText mEmail,mPassword;
    private Button mSignIn,mSignUp;
    private Request mRequest;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmail=findViewById(R.id.email);
        mPassword=findViewById(R.id.password);
        //for buttons
        mSignIn=findViewById(R.id.signIn);
        mSignUp=findViewById(R.id.signUp);

        mSignIn.setOnClickListener(this);
        mSignUp.setOnClickListener(this);

        mRequest=new Request(this);

    }

   private void readUserInfo(){
        String email=mEmail.getText().toString();
        String password=mPassword.getText().toString();

        //! we must verfiy if our data is not empty

       if("".equals(email) || "".equals(password)){
           Toast.makeText(this, "Veuillez remplir les champs ", Toast.LENGTH_SHORT).show();
           return;
       }

       mRequest.signIn(email,password);





       //send data to db for verfication







   }

    @Override
    public void onClick(View v) {

        if(mSignIn.getId()==v.getId()){

            readUserInfo();
            return;

            //sign in
        }

        if(mSignUp.getId()==v.getId()){

            Intent intent=new Intent(this,SignUpActivity.class);
            startActivity(intent);
            //sign up
        }


    }
}