package com.dypatil.dypatilregistration;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity {
    private static final String TAG = "login";
    private EditText officeRegNo;
    private EditText password;
    private Button login;
    private EditText mobileNo;
    protected ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Refrencing the IDs
        officeRegNo = findViewById(R.id.officeRegNo);
        password = findViewById(R.id.password);
        mobileNo = findViewById(R.id.mobileNo);
        login = findViewById(R.id.login);

    }

    //This method is called when user want to register
    public void onLogin(View view) {
        Log.d(TAG, "onLogin: button is clicked");
        progressDialog = ProgressDialog.show(login.this, "Login in", "Wait a moment please", true, false);
        String office = officeRegNo.getText().toString();
        String pass = password.getText().toString();
        String type = "login";
        Log.d(TAG, "onLogin: calling the background class");
        Background background = new Background(this);
        background.execute(type, office, pass);
        progressDialog.dismiss();
        //The success is the activity called when user sucessed login
        Intent intent = new Intent(login.this, Success.class);
        startActivity(intent);
    }
    //This method is called when user is new & try to register him/herself
    public void onSignup(View view){
        startActivity(new Intent(this, Register.class));
    }
}
