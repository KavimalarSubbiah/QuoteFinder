package com.example.deltatask3;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.logging.Handler;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    Button Fragment1, Fragment2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);





        Fragment1= findViewById(R.id.Fragment1);
        Fragment2= findViewById(R.id.Fragment2);


        Fragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new MyFragment());
            }
        });

        Fragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new MyFragmentSearch());
            }
        });



        ButterKnife.bind(this);

//        FragmentManager fragmentManager = getSupportFragmentManager();
//        Fragment fragment = fragmentManager.findFragmentById(R.id.mycontainer);
//
//        if(fragment==null){
//            fragment = new MyFragment();
//            fragmentManager.beginTransaction()
//                    .add(R.id.mycontainer, fragment)
//                    .commit();
        }


    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mycontainer, fragment);
        fragmentTransaction.commit();



        }
    }


