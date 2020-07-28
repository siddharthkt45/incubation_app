package com.e.incubationcell.medicaps.ac.in;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class HomeLogin extends AppCompatActivity {

    EditText editTextTextEmailAddress , editTextTextPassword2;
    Button button2 , button3;
    TextView textView;
    private static String emailLogin , password;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_login);
        editTextTextEmailAddress = (EditText)findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword2 = (EditText)findViewById(R.id.editTextTextPassword2);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        textView = (TextView)findViewById(R.id.textView);
        firebaseAuth = FirebaseAuth.getInstance();

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailLogin = editTextTextEmailAddress.getText().toString();
                password = editTextTextPassword2.getText().toString();
                firebaseAuth.signInWithEmailAndPassword(emailLogin,password).addOnSuccessListener(HomeLogin.this,new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(HomeLogin.this,"Welcome!",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(HomeLogin.this,Home.class));
                        finish();
                    }
                });
                //Toast.makeText(HomeLogin.this , editTextTextEmailAddress.getText().toString() +"\n" + editTextTextPassword2.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeLogin.this, Register.class);
                emailLogin = editTextTextEmailAddress.getText().toString();
                intent.putExtra(emailLogin,emailLogin);
                startActivity(intent);
                finish();
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeLogin.this,Home.class));
                finish();
            }
        });
    }
}
