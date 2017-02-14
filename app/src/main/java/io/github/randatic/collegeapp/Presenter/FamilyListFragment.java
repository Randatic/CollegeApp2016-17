package io.github.randatic.collegeapp.Presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

import io.github.randatic.collegeapp.Model.FamilyMember;
import io.github.randatic.collegeapp.Model.Guardian;
import io.github.randatic.collegeapp.Model.Sibling;

/**
 * Created by Randy Bruner on 12/13/16.
 */

public class FamilyListFragment extends ListFragment {
    static final int REQUEST_CODE_FAMILYMEMBER = 2;
    static final String EXTRA_OCCUPATION  = "guardian_occupation";
    static final String EXTRA_NAME_FIRST = "familyMember_nameFirst";
    static final String EXTRA_NAME_LAST = "familyMember_nameLast";
    static final String EXTRA_AGE = "sibling_age";

    private ArrayList<FamilyMember> family;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);

        family = new ArrayList<>();
        populateList();
        Collections.sort(family);

        FamilyListAdapter adapter = new FamilyListAdapter(getActivity(), family);
        setListAdapter(adapter);

        return rootView;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        FamilyMember familyMember = (FamilyMember) l.getItemAtPosition(position);

        String nameFirst = familyMember.getFirstName();
        String nameLast = familyMember.getLastName();
        String occupation = null;
        Integer age = null;
        if(familyMember instanceof Guardian) {
            occupation = ((Guardian) familyMember).getOccupation();
        } else {
            age = ((Sibling) familyMember).getAge();
        }
        Intent i = new Intent(getActivity(), FamilyMemberActivity.class);
        i.putExtra(EXTRA_NAME_FIRST, nameFirst);
        i.putExtra(EXTRA_NAME_LAST, nameLast);
        i.putExtra(EXTRA_AGE, age);
        i.putExtra(EXTRA_OCCUPATION, occupation);

        startActivityForResult(i, REQUEST_CODE_FAMILYMEMBER);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE_FAMILYMEMBER) {
            if(resultCode == getActivity().RESULT_OK) {

            }
        }
    }

    private void populateList() {

    }
}
