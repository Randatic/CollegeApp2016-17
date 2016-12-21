package io.github.randatic.collegeapp.Presenter;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import io.github.randatic.collegeapp.Model.Profile;
import io.github.randatic.collegeapp.R;

/**
 * Created by Randy Bruner on 12/13/16.
 */
public class ProfileFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //call superclass stuffs
        super.onCreateView(inflater, container, savedInstanceState);

        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        //wire widgets
        EditText etFirstName = (EditText) rootView.findViewById(R.id.profile_edit_first_name);
        EditText etLastName = (EditText) rootView.findViewById(R.id.profile_edit_last_name);

        //get info from model layer
        Profile p = new Profile("Jerry", "Smith");

        //put info in view layer
        etFirstName.setText(p.getFirstName());
        etLastName.setText(p.getLastName());

        return rootView;
    }
}
