package io.github.randatic.collegeapp.Presenter;

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

public class CreateAccountActivity extends AppCompatActivity{

    private EditText editTextEmail, editTextPassword,
            editTextPasswordConfirm, editTextFirstName, editTextLastName;

    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        editTextEmail = (EditText) findViewById(R.id.create_account_editText_email);
        editTextPassword = (EditText) findViewById(R.id.create_account_editText_password);
        editTextPasswordConfirm = (EditText) findViewById(R.id.create_account_editText_password_confirm);
        editTextFirstName = (EditText) findViewById(R.id.create_account_editText_name_first);
        editTextLastName = (EditText) findViewById(R.id.create_account_editText_name_last);

        buttonSubmit = (Button) findViewById(R.id.create_account_button_submit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO Validate Data

                //Create Backendless User
                BackendlessUser user = new BackendlessUser();
                user.setEmail(editTextEmail.getText().toString());
                user.setPassword(editTextPassword.getText().toString());
                user.setProperty("first_name", editTextFirstName.getText().toString());
                user.setProperty("last_name", editTextLastName.getText().toString());

                Backendless.UserService.register(user, createUserRegCallBack());
            }
        });

        //Backendless Registration
        Backendless.initApp(this, "A9859B20-C416-976B-FF6B-05FD0247B700", "3813DDD7-9C53-3E90-FFDE-98850AB61600", "v1" );

    }

    private AsyncCallback<BackendlessUser> createUserRegCallBack() {

        return new AsyncCallback<BackendlessUser>() {
            @Override
            public void handleResponse(BackendlessUser response) {
                Toast.makeText(CreateAccountActivity.this, "Registration Success!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Toast.makeText(CreateAccountActivity.this, ""+fault.getMessage(), Toast.LENGTH_SHORT).show();
            }
        };
    }

    private void validate() {
        //TODO edit submit() when we implement the database
        if(
                (editTextEmail.getText().toString().trim().equals("")||
                        editTextFirstName.getText().toString().trim().equals("")||
                        editTextLastName.getText().toString().trim().equals("")||
                        editTextPassword.getText().toString().trim().equals("")||
                        editTextPasswordConfirm.getText().toString().trim().equals(""))

                ) {
            Toast.makeText(CreateAccountActivity.this, R.string.fill_all_fields, Toast.LENGTH_SHORT).show();
        } else if(!editTextPassword.getText().toString().trim().equals(editTextPasswordConfirm.getText().toString().trim())
                ) {
            Toast.makeText(CreateAccountActivity.this, R.string.not_matching, Toast.LENGTH_SHORT).show();
        } else {
            finish();
        }

    }
}
