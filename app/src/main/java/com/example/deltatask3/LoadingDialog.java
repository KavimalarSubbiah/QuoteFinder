package com.example.deltatask3;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import androidx.fragment.app.Fragment;

public class LoadingDialog {

    private Fragment activity;
    private AlertDialog dialog;

    LoadingDialog(MyFragment myActivity )
    {
        activity = myActivity;
    }

    void startLoadingDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity.getActivity());

        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.customdialogbox, null));

        dialog= builder.create();
        dialog.show();
    }


     void dismissDialog(){
        dialog.dismiss();

    }

}
