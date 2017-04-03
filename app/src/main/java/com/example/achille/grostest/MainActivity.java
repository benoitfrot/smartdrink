package com.example.achille.grostest;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.example.achille.grostest.Fragments.MesInfosFragment;
import com.example.achille.grostest.Fragments.ParametreAppliFragment;
import com.example.achille.grostest.Fragments.SelectVerreFragment;
import com.example.achille.grostest.PPE_BENOIT.DatabaseHandler;
import com.example.achille.grostest.PPE_BENOIT.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    DatabaseHandler db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Databse Initialization

        db = new DatabaseHandler(this.getApplicationContext());
        if (this.getApplicationContext().getDatabasePath("UsersDB").exists())
        {
            String DB_PATH=this.getApplicationContext().getDatabasePath("UsersDB").getPath();
            db.setDb(SQLiteDatabase.openDatabase(DB_PATH, null,SQLiteDatabase.OPEN_READWRITE));
            // db.getDb().close();
        }
        else{
            db.onCreate(db.getDb());
        }

        ArrayList<User.Historic> list = new ArrayList<>();
        User.Historic hist = new User.Historic("1/1/1 1:1:1-23");
        User.Historic hist2 = new User.Historic("1/1/1 1:1:1-30");
        list.add(hist);
        list.add(hist2);
        User u1 = new User("test@test.com","user1","Michel","Jeannot","1/3/4",12,12,"African","Male","url",list,2.0,"passwd");
      //  db.addUser(u1);

        Log.e("CONTENT_DB", db.toString());

        // ID USER
        String ID_USER=u1.getEmail();
        SharedPreferences sharedpef = this.getSharedPreferences(getString(R.string.preference_file_key ), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpef.edit();
        editor.putString("ID_USER",ID_USER);
        editor.commit();


        /**
         *Setup the DrawerLayout and NavigationView
         */

             mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
             mNavigationView = (NavigationView) findViewById(R.id.shitstuff) ;

        /**
         * Lets inflate the very first fragment
         * Here , we are inflating the TabFragment as the first Fragment
         */




             mFragmentManager = getSupportFragmentManager();
             mFragmentTransaction = mFragmentManager.beginTransaction();
             mFragmentTransaction.replace(R.id.containerView,new TabFragment()).commit();
        /**
         * Setup click events on the Navigation View Items.
         */
        mNavigationView.setItemIconTintList(null);

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();

                 if (menuItem.getItemId() == R.id.nav_item_accueil) {

                     FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                     xfragmentTransaction.replace(R.id.containerView,new TabFragment()).commit();
                 }

                 if (menuItem.getItemId() == R.id.nav_item_verre) {
                     FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                     xfragmentTransaction.replace(R.id.containerView,new SelectVerreFragment()).commit();
                 }

                 if (menuItem.getItemId() == R.id.nav_item_info) {
                     FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                     fragmentTransaction.replace(R.id.containerView,new MesInfosFragment()).commit();
                 }

                 if (menuItem.getItemId() == R.id.nav_item_appli) {
                     FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                     xfragmentTransaction.replace(R.id.containerView,new ParametreAppliFragment()).commit();
                 }

                 return false;
            }

        });

        /**
         * Setup Drawer Toggle of the Toolbar
         */

                android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
                ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout, toolbar,R.string.app_name,
                R.string.app_name);

                mDrawerLayout.setDrawerListener(mDrawerToggle);

                mDrawerToggle.syncState();

    }
}