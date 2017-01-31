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
import io.github.randatic.collegeapp.R;

/**
 * Created by Randy Bruner on 12/13/16.
 */

public class FamilyFragment extends ListFragment {

    private ArrayList<FamilyMember> family;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_family, container, false);

        family = new ArrayList<>();
        populateList();
        Collections.sort(family);

        FamilyMemberAdapter adapter = new FamilyMemberAdapter(getActivity(), family);
        setListAdapter(adapter);

        return rootView;
    }

    private void populateList() {
        family.add(new Guardian("Berry", "Benson", "Bee"));
        family.add(new Guardian("John", "Cena", "John Cena"));
        family.add(new Sibling("Donkey", "Kong", 35));
        family.add(new Sibling("Bruce", "Wayne", 40));
        family.add(new Sibling("Dead", "Pool", 0));
    }
}
