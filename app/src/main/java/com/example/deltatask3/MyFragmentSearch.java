package com.example.deltatask3;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class MyFragmentSearch extends Fragment {

    @Override
    public void onCreate( Bundle savedInstanceState) {
        datafragment obj;
        obj = new datafragment();

        super.onCreate(savedInstanceState);
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
         getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.maincontainer,obj).commit();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search, container, false);

        datafragment obj;
        EditText v = (EditText) view.findViewById(R.id.search);
        obj = new datafragment();


        //Log.d("Cools",obj.dataList.toString());
        v.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.v("jsonparse","beforeTextChangedResponse");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.v("jsonparse","onTextChangedResponse");
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.v("jsonparse","afterTextChangedResponse");
                filter(s.toString());
            }
        });
        return view;
    }
    private void filter(String text)
    {
        Log.v("jsonparse","filter");
        datafragment obj;
        obj = new datafragment();
        ArrayList<DataModel> datas=new ArrayList<>();
        for(DataModel item: obj.dataList){
            Log.v("jsonparse","datalist1");
            if((item.getContent().toLowerCase().contains(text.toLowerCase()))||(item.getAuthor().toLowerCase().contains(text.toLowerCase())))
            {
                Log.v("jsonparse","datalist");
                datas.add(item);
            }
        }
        obj.adaptery.filterlist(datas);
    }
    
    }


