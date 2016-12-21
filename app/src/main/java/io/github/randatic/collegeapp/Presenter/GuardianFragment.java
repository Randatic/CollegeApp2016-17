package io.github.randatic.collegeapp.Presenter;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import io.github.randatic.collegeapp.R;

/**
 * Created by Randy Bruner on 12/13/16.
 */
public class GuardianFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_guardian, container, false);

        EditText etFirstName = (EditText) rootView.findViewById(R.id.guardian_edit_first_name);


        return rootView;
    }
}
