package com.example.easy;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class EzDialogFragment extends DialogFragment {
    @Nullable

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
       LayoutInflater layoutInflater=getActivity().getLayoutInflater();
       View view=layoutInflater.inflate(R.layout.dialog_item,null);
        final EditText name=view.findViewById(R.id.id_txt_username);
        final EditText password=view.findViewById(R.id.id_txt_password);
       builder.setView(view)
               .setNegativeButton("false", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       Toast.makeText(getContext(), "false", Toast.LENGTH_SHORT).show();
                   }
               })
                .setPositiveButton("true", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "true", Toast.LENGTH_SHORT).show();
                        LoginInterface loginInterface= (LoginInterface) getActivity();
                        loginInterface.onLoginInputComplete(name.getText().toString(),password.getText().toString());
                    }
                });
        return builder.create();
    }

}
