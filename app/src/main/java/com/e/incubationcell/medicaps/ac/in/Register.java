package com.e.incubationcell.medicaps.ac.in;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Register extends AppCompatActivity {

    EditText name , email , branch , password;
    String branchname , emails , passwords , named;
    Button signup;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = (EditText)findViewById(R.id.editTextTextName);
        email = (EditText)findViewById(R.id.editTextTextEmailAddressReg);
        password = (EditText)findViewById(R.id.editTextTextPassword2Reg);
        branch = (EditText)findViewById(R.id.editTextTextBranch);
        signup = (Button)findViewById(R.id.signupreg);
        firebaseAuth = FirebaseAuth.getInstance();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                emails = email.getText().toString();
                passwords = password.getText().toString();
                named = name.getText().toString();
                branchname = branch.getText().toString();
                registerUser(emails,passwords);
                startActivity(new Intent(Register.this,HomeLogin.class));
            }
        });
    }
    private void registerUser(String email , String password){
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                    Toast.makeText(Register.this,"Done!",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Register.this , "Failed!",Toast.LENGTH_LONG).show();
            }
        });
    }
}