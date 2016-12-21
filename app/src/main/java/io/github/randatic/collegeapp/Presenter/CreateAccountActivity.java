package io.github.randatic.collegeapp.Presenter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.github.randatic.collegeapp.R;

public class CreateAccountActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextEmail, editTextEmailConfirm, editTextPassword,
            editTextPasswordConfirm, editTextFirstName, editTextLastName;

    private Button buttonSubmit;

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.create_account_button_submit: submit(); break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        wireWidgets();
    }

    private void wireWidgets() {
        editTextEmail = (EditText) findViewById(R.id.create_account_editText_email);
        editTextEmailConfirm = (EditText) findViewById(R.id.create_account_editText_email_confirm);
        editTextPassword = (EditText) findViewById(R.id.create_account_editText_password);
        editTextPasswordConfirm = (EditText) findViewById(R.id.create_account_editText_password_confirm);
        editTextFirstName = (EditText) findViewById(R.id.create_account_editText_name_first);
        editTextLastName = (EditText) findViewById(R.id.create_account_editText_name_last);

        buttonSubmit = (Button) findViewById(R.id.create_account_button_submit);
        buttonSubmit.setOnClickListener(this);
    }

    private void submit() {
        //TODO edit submit() when we implement the database
        if(
                (editTextEmail.getText().toString().trim().equals("")||
                        editTextEmailConfirm.getText().toString().trim().equals("")||
                        editTextFirstName.getText().toString().trim().equals("")||
                        editTextLastName.getText().toString().trim().equals("")||
                        editTextPassword.getText().toString().trim().equals("")||
                        editTextPasswordConfirm.getText().toString().trim().equals(""))

                ) {
            Toast.makeText(CreateAccountActivity.this, R.string.fill_all_fields, Toast.LENGTH_SHORT).show();
        } else if(!(editTextEmail.getText().toString().trim().equals(editTextEmailConfirm.getText().toString().trim())&&
                editTextPassword.getText().toString().trim().equals(editTextPasswordConfirm.getText().toString().trim()))
                ) {
            Toast.makeText(CreateAccountActivity.this, R.string.not_matching, Toast.LENGTH_SHORT).show();
        } else {
            finish();
        }

    }
}
