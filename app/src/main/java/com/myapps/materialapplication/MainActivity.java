package com.myapps.materialapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private Toolbar mToolbar;
    private boolean isMatched = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.fragment_drawer);

        // Set up the drawer.
        mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar);
        // populate the navigation drawer
//        mNavigationDrawerFragment.setUserData("John Doe", "johndoe@doe.com", BitmapFactory.decodeResource(getResources(), R.drawable.avatar));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        Fragment fragment;
        switch (position) {
            case 0: //search//todo
                if (isMatched) {
                    fragment = getFragmentManager().findFragmentByTag(MatchedFragment.TAG);
                    if (fragment == null) {
                        fragment = new MatchedFragment();
                    }
                    getFragmentManager().beginTransaction().replace(R.id.container, fragment, MatchedFragment.TAG).commit();
                } else {
                    fragment = getFragmentManager().findFragmentByTag(UnmatchedFragment.TAG);
                    if (fragment == null) {
                        fragment = new UnmatchedFragment();
                    }
                    getFragmentManager().beginTransaction().replace(R.id.container, fragment, UnmatchedFragment.TAG).commit();
                }

                break;
            case 1: //stats
                fragment = getFragmentManager().findFragmentByTag(RecentsFragment.TAG);
                if (fragment == null) {
                    fragment = new RecentsFragment();
                }
                getFragmentManager().beginTransaction().replace(R.id.container, fragment, RecentsFragment.TAG).commit();
                break;
            case 2: //my account //todo
                break;
            case 3: //settings //todo
                fragment = getFragmentManager().findFragmentByTag(SettingsFragment.TAG);
                if (fragment == null) {
                    fragment = new SettingsFragment();
                }
                getFragmentManager().beginTransaction().replace(R.id.container, fragment, SettingsFragment.TAG).commit();
                break;
        }
    }


    @Override
    public void onBackPressed() {
        if (mNavigationDrawerFragment.isDrawerOpen())
            mNavigationDrawerFragment.closeDrawer();
        else
            super.onBackPressed();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }

}
