package com.example.achille.grostest.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
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
public class MesInfosFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        SharedPreferences sharedpref = getActivity().getSharedPreferences(getString(R.string.preference_file_key ), Context.MODE_PRIVATE);
        Log.e("ID_USER", sharedpref.getString("ID_USER","user"));
        String idcurrentuser = sharedpref.getString("ID_USER","user");

        DatabaseHandler db = new DatabaseHandler(getActivity());

        TextView poids;
        TextView taille;

        View v = inflater.inflate(R.layout.mesinfos_layout,null);
        poids = (TextView) v.findViewById(R.id.poids);

        User u1 = db.getUser(idcurrentuser);

        poids.setText(String.valueOf(u1.getWeight()), TextView.BufferType.EDITABLE);

        poids.setText("8",TextView.BufferType.EDITABLE);

        taille = (TextView) v.findViewById(R.id.taille);
        taille.setText(String.valueOf(u1.getHeight()), TextView.BufferType.EDITABLE);





        return inflater.inflate(R.layout.mesinfos_layout,null);
    }
}
