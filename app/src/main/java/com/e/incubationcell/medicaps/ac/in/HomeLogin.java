package com.e.incubationcell.medicaps.ac.in;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeLogin extends AppCompatActivity {

    EditText editTextTextEmailAddress , editTextTextPassword2;
    Button button2 , button3;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_login);
        editTextTextEmailAddress = (EditText)findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword2 = (EditText)findViewById(R.id.editTextTextPassword2);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        textView = (TextView)findViewById(R.id.textView);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeLogin.this , editTextTextEmailAddress.getText().toString() +"\n" + editTextTextPassword2.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeLogin.this , editTextTextEmailAddress.getText().toString() +"\n" + editTextTextPassword2.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeLogin.this , editTextTextEmailAddress.getText().toString() +"\n" + editTextTextPassword2.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}