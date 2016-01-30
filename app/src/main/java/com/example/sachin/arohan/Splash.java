package com.example.sachin.arohan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by sachin on 15/12/15.
 */
public class Splash extends AppCompatActivity {
    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Thread  timer=new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent abc = new Intent(getApplicationContext(), MainActivityActivity.class);
                    startActivity(abc);
                    /*prefs = getSharedPreferences(MainActivityActivity.file,0);
                    boolean stat;
                    stat = prefs.getBoolean("login status",false);
                    if(!stat) {
                        Intent abc = new Intent(getApplicationContext(), MainActivityActivity.class);
                        startActivity(abc);
                    }
                    else
                    {
                        Intent abc = new Intent(getApplicationContext(),SecondActivity.class);
                        startActivity(abc);
                    }*/
                }
            }
        };
        timer.start();
    }
    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }
}
