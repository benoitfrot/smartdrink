package com.example.achille.grostest.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.achille.grostest.PPE_BENOIT.DatabaseHandler;
import com.example.achille.grostest.PPE_BENOIT.User;
import com.example.achille.grostest.R;

/**
 * Created by Ratan on 7/29/2015.
 */
public class ParametreAppliFragment extends Fragment {

    String email;
    String user;
    String fname;
    String lastname;
    private Object retrievedFromDatabase;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        SharedPreferences sharedpref = getActivity().getSharedPreferences(getString(R.string.preference_file_key ),Context.MODE_PRIVATE);
        String idcurrentuser = sharedpref.getString("ID_USER","user");


        DatabaseHandler db = new DatabaseHandler(getActivity());

        TextView email;
        TextView username;
        TextView fname;
        TextView lname;

        View v = inflater.inflate(R.layout.parametreappli_layout,null);
        email = (TextView) v.findViewById(R.id.etEmail);
        User u1 = db.getUser(idcurrentuser);
        email.setText(u1.getEmail());
        fname = (TextView) v.findViewById(R.id.etFirstName);
        fname.setText(u1.getFirstName());
        lname = (TextView) v.findViewById(R.id.etLastName);
        lname.setText(u1.getLastName());



        return v;
    }



}
