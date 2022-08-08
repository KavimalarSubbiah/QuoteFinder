package com.example.deltatask3;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MyFragment extends Fragment {

    public RequestQueue mQueue;




    //@BindView(R.id.quote) TextView fetchquote;

   // @BindView(R.id.new_quote) Button newquote;
   // @BindView(R.id.author) TextView fetchauthor;





    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mQueue= Volley.newRequestQueue(getActivity().getApplicationContext());

    }

   @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
         ButterKnife.bind(this, view);
      final LoadingDialog loadingDialog = new LoadingDialog(MyFragment.this);
        Button newquote = (Button) view.findViewById(R.id.new_quote);
        newquote.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onClick(View v)
            {
                loadingDialog.startLoadingDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable(){

                                        @Override
                                        public void run() {
                                            loadingDialog.dismissDialog();
                                        }
                                    },5000);
                jsonParse();
            }
        });
        return view;



    }


    public void jsonParse(){
        View view= getView();
        Log.v("jsonparse","jsonparseresponse");

        TextView fetchquote = (TextView) view.findViewById(R.id.quote);
        TextView fetchauthor = (TextView) view.findViewById(R.id.author);


        String URL="https://api.quotable.io/random";
        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.v("json","jsonresponse");
                        try {

                            Log.v("tryjson","tryjsonresponse");

                            String quote = response.getString("content");
                            String author = response.getString("author");

                            fetchquote.setText(quote);
                            fetchauthor.setText(author);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("hey you", "london");
                error.printStackTrace();

            }
        });

        mQueue.add(objectRequest);

    }


}
