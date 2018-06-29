package com.androidmidtermtest.electricitybillapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.androidmidtermtest.electricitybillapplication.R;

public class LoginScreenActivity extends AppCompatActivity {


    EditText edtUserId;
    EditText edtPassword;
    Button btnSignIn;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        edtUserId = (EditText) findViewById(R.id.edtUserName);
        edtPassword = (EditText) findViewById(R.id.edtPassword);

        btnSignIn = (Button)findViewById(R.id.btnSignIn);

        btnSignIn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(TextUtils.isEmpty(edtUserId.getText()) || edtUserId.getText().toString().length() == 0)
                {
                    edtUserId.setError("Please Enter User Name");
                }
                else {

                    if (edtUserId.getText().toString().equals("abc1@gmail.com") && edtPassword.getText().toString().equals("s3cr3t")) {
                        Toast.makeText(LoginScreenActivity.this, "User Successfully logged In ", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginScreenActivity.this, ElectricityBillActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginScreenActivity.this, "UserID/Passwords Invalid", Toast.LENGTH_LONG).show();

                    }
                }
            }
        });
    }
}

