package io.github.randatic.collegeapp.Presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;

import io.github.randatic.collegeapp.Model.FamilyMember;
import io.github.randatic.collegeapp.Model.Guardian;
import io.github.randatic.collegeapp.Model.Sibling;

/**
 * Created by Randy Bruner on 12/13/16.
 */

public class FamilyListFragment extends ListFragment {

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

    private void populateList() {
        family.add(new Guardian("Berry", "Benson", "Nature Activist"));
        family.add(new Guardian("Issac", "Newton", "Scientist"));
        family.add(new Sibling("Fox", "Mulder", 35));
        family.add(new Sibling("Bruce", "Wayne", 40));
        family.add(new Sibling("Santa", "Clause", 100));
    }
}
