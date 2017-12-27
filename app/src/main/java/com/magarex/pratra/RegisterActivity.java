package com.magarex.pratra;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    private EditText txtusername,txtpassword;
    private Button btnRegister;
    private ProgressDialog progressdialog;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Register");

        txtusername = (EditText)findViewById(R.id.txtRegisterUsername);
        txtpassword = (EditText)findViewById(R.id.txtRegisterPassword);
        btnRegister = (Button)findViewById(R.id.btnRegister);
        progressdialog = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterUser();
            }
        });
    }

    private void RegisterUser() {
        String username = txtusername.getText().toString().trim();
        String password = txtpassword.getText().toString().trim();

        progressdialog.setMessage("Registering User");
        progressdialog.show();

        mAuth.createUserWithEmailAndPassword(username,password).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(!task.isSuccessful()){
                    progressdialog.dismiss();
                    Toast.makeText(getBaseContext(),"Check Your Internet Connection",Toast.LENGTH_LONG).show();
                }
                else {
                    progressdialog.dismiss();
                    Toast.makeText(getBaseContext(),"Welcome",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
