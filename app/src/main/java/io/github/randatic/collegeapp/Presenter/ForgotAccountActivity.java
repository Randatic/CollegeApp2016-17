package io.github.randatic.collegeapp.Presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.github.randatic.collegeapp.R;

/**
 * Created by Randy Bruner on 12/19/16.
 */
public class ForgotAccountActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextNameFirst, editTextNameLast, editTextEmail;

    private Button buttonSubmit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_account);

        //provide for "up" navigation
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editTextNameFirst = (EditText) findViewById(R.id.forgot_account_editText_first_name);
        editTextNameLast = (EditText) findViewById(R.id.forgot_account_editText_last_name);
        editTextEmail = (EditText) findViewById(R.id.forgot_account_editText_email);

        buttonSubmit = (Button) findViewById(R.id.forgot_account_button_submit);
        buttonSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch(id) {
            case R.id.forgot_account_button_submit: submit(); break;
        }
    }

    private void submit() {
        //TODO finish submit when we implement database
        if(!(editTextNameFirst.getText().toString().trim().equals("")||
                editTextNameLast.getText().toString().trim().equals("")||
                editTextEmail.getText().toString().trim().equals(""))) {
            finish();
        } else {
            Toast.makeText(ForgotAccountActivity.this, R.string.fill_all_fields, Toast.LENGTH_SHORT).show();
        }
    }
}
