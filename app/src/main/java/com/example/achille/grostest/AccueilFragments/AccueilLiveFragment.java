package com.example.achille.grostest.AccueilFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.achille.grostest.Fragments.SelectVerreFragment;
import com.example.achille.grostest.R;

import static com.example.achille.grostest.R.layout.accueillive_layout;

/**
 * Created by Ratan on 7/29/2015.
 */
public class AccueilLiveFragment extends Fragment {

    private Button selectverre = null;
    private FragmentManager mFragmentManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



      View view=inflater.inflate(accueillive_layout, container, false);
        selectverre = (Button) view.findViewById(R.id.selectverre);



        selectverre.setOnClickListener(new View.OnClickListener() {



            public void onClick(View view) {

              //  Intent intent= new Intent(this,SelectVerreFragment.Fragment);


                FragmentManager FM = getFragmentManager();
                FragmentTransaction FT = FM.beginTransaction();

                SelectVerreFragment PF = new SelectVerreFragment();
                FT.replace(R.id.selectverre, PF);
                FT.commit();



                /*FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                //xfragmentTransaction.replace(R.id.containerView,new SelectVerreFragment()).commit();
                SelectVerreFragment llf = new SelectVerreFragment();
                xfragmentTransaction.replace(R.id.containerView, llf);
                xfragmentTransaction.commit();*/

               // new SelectVerreFragment();
            }
        });

        return view;


    }

}
