package com.flora.myalertdialog3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Robertson on 05/10/2017.
 */

public class CustomDialog extends DialogFragment {

    LayoutInflater inflater;
    View view;
    EditText etUser, etPwd;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.login_dialog, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        builder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                etUser = (EditText) view.findViewById(R.id.et_username);
                etPwd = (EditText) view.findViewById(R.id.et_password);
                String user = etUser.getText().toString();
                String password= etPwd.getText().toString();
                String msg = "Username is " + user + ", Password is " + password ;
                Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();


            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        builder.setTitle("Login");
        Dialog dialog = builder.create();

        return dialog;
    }


}
