package com.dypatil.dypatilregistration;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    private static final String TAG = "Register";

    private EditText officeRegNo;
    private EditText mobileNo;
    private EditText password;
    private Button signUp;
    private CheckBox check;
    protected ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: inside onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Refrencing the IDs
        officeRegNo = findViewById(R.id.officeRegNo);
        mobileNo = findViewById(R.id.mobileNo);
        password = findViewById(R.id.password);
        signUp = findViewById(R.id.signUp);
        check = findViewById(R.id.check);
    }

    //This method is called when user clicks register
    public void onRegister(View view) {
        Log.d(TAG, "onLogin: button is clicked");
        progressDialog = ProgressDialog.show(Register.this, "Login in", "Wait a moment please", true, false);
        String office = officeRegNo.getText().toString();
        String mob = mobileNo.getText().toString();
        String pass = password.getText().toString();
        String type = "register";
        Log.d(TAG, "onLogin: calling the background class");
        Background background = new Background(this);
        background.execute(type, office, mob, pass);
        progressDialog.dismiss();
        //The succes is simple activity it is called when the registration is done
        Intent intent = new Intent(this, Success.class);
        startActivity(intent);
    }
}
