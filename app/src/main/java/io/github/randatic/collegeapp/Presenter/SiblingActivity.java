package io.github.randatic.collegeapp.Presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

import io.github.randatic.collegeapp.R;

/**
 * Created by Randy Bruner on 2/6/17.
 */
public class SiblingActivity extends AppCompatActivity {
    private EditText nameFirstEditText, nameLastEditText;
    private NumberPicker ageNumberPicker;
    private Button saveButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sibling);

        Intent i = getIntent();
        String nameFirst = i.getStringExtra(FamilyListFragment.EXTRA_NAME_FIRST);
        String nameLast = i.getStringExtra(FamilyListFragment.EXTRA_NAME_LAST);

        saveButton = (Button) findViewById(R.id.familyMember_button_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        nameFirstEditText = (EditText) findViewById(R.id.familyMember_editText_nameFirst);
        nameLastEditText = (EditText) findViewById(R.id.sibling_editText_nameLast);

        nameFirstEditText.setText(i.getStringExtra(FamilyListFragment.EXTRA_NAME_FIRST));
        nameLastEditText.setText(i.getStringExtra(FamilyListFragment.EXTRA_NAME_LAST));

        ageNumberPicker = (NumberPicker) findViewById(R.id.familyMember_numberPicker_age);
        ageNumberPicker.setMinValue(1);
        ageNumberPicker.setMaxValue(99);

        }


    }
