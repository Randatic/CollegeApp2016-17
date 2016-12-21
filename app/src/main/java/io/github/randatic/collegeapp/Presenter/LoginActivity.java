package io.github.randatic.collegeapp.Presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.github.randatic.collegeapp.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextEmail, editTextPassword;

    private Button buttonLogIn, buttonForgotPassword, buttonCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        wireWidgets();
    }

    @Override
    public void onClick(View view) {
        Intent i = null;
        int id = view.getId();
        switch (id) {
            case R.id.login_button_login: login(); break;
            case R.id.login_button_forgot_password:
                i = new Intent(this,  ForgotAccountActivity.class); break;
            case R.id.login_button_create_account:
                i = new Intent(this, CreateAccountActivity.class); break;
        }

        if(i != null)
            startActivity(i);
    }

    private void wireWidgets() {
        editTextEmail = (EditText) findViewById(R.id.login_editText_email);
        editTextPassword = (EditText) findViewById(R.id.login_editText_password);

        buttonLogIn = (Button) findViewById(R.id.login_button_login);
        buttonForgotPassword = (Button) findViewById(R.id.login_button_forgot_password);
        buttonCreateAccount = (Button) findViewById(R.id.login_button_create_account);

        buttonLogIn.setOnClickListener(this);
        buttonForgotPassword.setOnClickListener(this);
        buttonCreateAccount.setOnClickListener(this);
    }

    private void login() {
        //TODO edit login() when we implement the database
        if(!(editTextEmail.getText().toString().trim().equals("") || editTextPassword.getText().toString().trim().equals(""))) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();
        } else {
            Toast.makeText(LoginActivity.this, R.string.fill_all_fields, Toast.LENGTH_SHORT).show();
        }
    }
}
