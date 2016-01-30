package com.example.sachin.arohan;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by sachin on 2/11/15.
 */
public class SecondActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"Home","Events","Online Games","Workshops"};
    int Numboftabs =4;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        toolbar = (Toolbar) findViewById(R.id.toolbar);//android.support.v7.widget.Toolbar
        setSupportActionBar(toolbar);
        prefs=getSharedPreferences(MainActivityActivity.file,0);


        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles of the Tabs and Number Of Tabs.
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), Titles, Numboftabs);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        // Assigning the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
                                       public int getIndicatorColor(int position) {
                                           return getResources().getColor(R.color.tabsScrollColor);
                                       }
            public int getDividerColor(int position) {
                return getResources().getColor(R.color.colorAccent);
            }
                                   });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(), "Settings!", Toast.LENGTH_SHORT).show();

            return true;
        }
        if (id == R.id.contact_us) {
            Toast.makeText(getApplicationContext(), "Contact Us!", Toast.LENGTH_SHORT).show();

            return true;
        }
        if(id==R.id.log_out){
            editor=prefs.edit();
            editor.putBoolean("login status",false);
            Toast.makeText(getApplicationContext(), "Successfully logged out!", Toast.LENGTH_SHORT).show();
            Intent abc = new Intent(getApplicationContext(), MainActivityActivity.class);
            startActivity(abc);
            return true;

        }
        return super.onOptionsItemSelected(item);
    }
}

