package com.ift.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText id,pw;
    Button button;
    static String regi= "16BCI0117";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id=findViewById(R.id.loginid);
        pw=findViewById(R.id.loginpw);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mid=id.getText().toString().toUpperCase();
                String mpw= pw.getText().toString();

                if(!mid.equals("") && !mpw.equals("")){
                    Intent intent = new Intent(LoginActivity.this, Landing.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText (LoginActivity.this, "Hi You are an successffully", Toast.LENGTH_SHORT).show ();
                }
                else{
                    Toast.makeText(LoginActivity.this, "Please fill id and password", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }


}
