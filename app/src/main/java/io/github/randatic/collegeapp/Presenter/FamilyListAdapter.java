package io.github.randatic.collegeapp.Presenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import io.github.randatic.collegeapp.Model.FamilyMember;
import io.github.randatic.collegeapp.Model.Guardian;
import io.github.randatic.collegeapp.Model.Sibling;
import io.github.randatic.collegeapp.R;

/**
 * Created by Randy Bruner on 1/31/17.
 */
public class FamilyListAdapter extends ArrayAdapter<FamilyMember>{

    public FamilyListAdapter(Context context, List<FamilyMember> family) {
        super(context, 0, family);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_family_member, null);
        }
        FamilyMember member = getItem(position);

        TextView nameTextView = (TextView) convertView.findViewById(R.id.itemFam_textView_name);
        TextView traitTextView = (TextView) convertView.findViewById(R.id.itemFam_textView_trait);
        TextView memberTextView = (TextView) convertView.findViewById(R.id.itemFam_textView_member);

        nameTextView.setText(member.getFirstName() + " " + member.getLastName());
        if(member instanceof Guardian) {
            traitTextView.setText("Occupation: " + ((Guardian) member).getOccupation());
            memberTextView.setText(R.string.guardian);
        } else {
            traitTextView.setText("Age: " + ((Sibling) member).getAge());
            memberTextView.setText(R.string.sibling);
        }
        return convertView;
    }
}
