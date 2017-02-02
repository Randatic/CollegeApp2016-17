package io.github.randatic.collegeapp.Presenter;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import io.github.randatic.collegeapp.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    static final int USER_RECENTLY_REGISTERED_REQUEST = 1;
    static final String USER_RECENTLY_REGISTERED = "User was recently registered.";

    private EditText editTextEmail, editTextPassword;
    private Button buttonLogIn, buttonForgotPassword, buttonCreateAccount;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        wireWidgets();
        Backendless.initApp(this, "A9859B20-C416-976B-FF6B-05FD0247B700", "3813DDD7-9C53-3E90-FFDE-98850AB61600", "v1");
    }

    @Override
    public void onClick(View view) {
        Intent i = null;
        int id = view.getId();
        switch (id) {
            case R.id.login_button_login: login(); break;
            case R.id.login_button_forgot_password:
                i = new Intent(this,  ForgotAccountActivity.class); startActivity(i); break;
            case R.id.login_button_create_account:
                i = new Intent(this, CreateAccountActivity.class);
                i.putExtra(USER_RECENTLY_REGISTERED, false);
                startActivityForResult(i, USER_RECENTLY_REGISTERED_REQUEST);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == USER_RECENTLY_REGISTERED_REQUEST) {
            if(resultCode == RESULT_OK) {
                editTextEmail.setText(data.getStringExtra(USER_RECENTLY_REGISTERED));
            }
        }
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

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Logging in, please wait. . .");
    }

    private void login() {
        progressDialog.show();
        if(!(editTextEmail.getText().toString().trim().equals("") || editTextPassword.getText().toString().trim().equals(""))) {

            Backendless.UserService.login(editTextEmail.getText().toString().trim(), editTextPassword.getText().toString().trim(), new AsyncCallback<BackendlessUser>() {
                @Override
                public void handleResponse(BackendlessUser response) {
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    System.out.println(response.toString());
                    progressDialog.dismiss();
                    startMainActivity();
                }

                @Override
                public void handleFault(BackendlessFault fault) {
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this, ""+fault.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        } else {
            progressDialog.dismiss();
            Toast.makeText(LoginActivity.this, R.string.fill_all_fields, Toast.LENGTH_SHORT).show();
        }



    }
    private void startMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
