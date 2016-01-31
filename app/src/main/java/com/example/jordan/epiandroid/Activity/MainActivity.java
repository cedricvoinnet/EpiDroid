package com.example.jordan.epiandroid.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.example.jordan.epiandroid.Fragment.DashboardFragment;
import com.example.jordan.epiandroid.Fragment.ModuleFragment;
import com.example.jordan.epiandroid.Fragment.PlanningFragment;
import com.example.jordan.epiandroid.Fragment.ProfileFragment;
import com.example.jordan.epiandroid.Models.DashBoard.Infos;
import com.example.jordan.epiandroid.R;

public class MainActivity extends AppCompatActivity implements
        ModuleFragment.OnFragmentInteractionListener,
        PlanningFragment.OnFragmentInteractionListener,
        ProfileFragment.OnFragmentInteractionListener,
        DashboardFragment.OnFragmentInteractionListener {

    public static String API_URL = "http://epitech-api.herokuapp.com";
    public static String PICTURES_URL = "https://cdn.local.epitech.eu/userprofil/profilview/";

    public static String sessionToken = null;
    public static String login = null;

    private DrawerLayout mDrawer;
    private NavigationView nvDrawer;
    private Toolbar toolbar;
    private int currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set a Toolbar to replace the ActionBar.
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Find our drawer view
        nvDrawer = (NavigationView) findViewById(R.id.nav_view);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        setupDrawerContent(nvDrawer);

        Class FragmentClass = DashboardFragment.class;
        Fragment fragment = null;
        try {
            fragment = (Fragment) FragmentClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_layout, fragment).commit();
        setTitle("Dashboard");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Make sure this is the method with just `Bundle` as the signature
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the planet to show based on
        // position
        Fragment fragment = null;
        int newFragmentId;
        Class fragmentClass;

        newFragmentId = menuItem.getItemId();
        if (newFragmentId != currentFragment) {
            switch (menuItem.getItemId()) {
                case R.id.nav_dashboard:
                    Log.v("DashBoard", "dashboard selected fragment");
                    fragmentClass = DashboardFragment.class;
                    break;
                case R.id.nav_modules:
                    fragmentClass = ModuleFragment.class;
                    break;
                case R.id.nav_planning:
                    fragmentClass = PlanningFragment.class;
                    break;
                case R.id.nav_profile:
                    fragmentClass = ProfileFragment.class;
                    break;
                default:
                    fragmentClass = DashboardFragment.class;
            }
            currentFragment = menuItem.getItemId();

            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment_layout, fragment).commit();

            // Highlight the selected item, update the title, and close the drawer
            menuItem.setChecked(true);
            setTitle(menuItem.getTitle());
            mDrawer.closeDrawers();
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("êtes vous sûr de vouloir quitter ?")
                .setCancelable(false)
                .setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.v("onFragmentInteraction", "mainactivity");
    }
}
