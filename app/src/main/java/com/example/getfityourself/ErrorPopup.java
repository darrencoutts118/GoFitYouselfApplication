package com.example.getfityourself;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class ErrorPopup extends DialogFragment {

    AlertDialog.Builder builder;
    CharSequence error = "An unexpected error has occured.";
    CharSequence title = "Error";

    public void error(CharSequence e){
        error = e;
    }

    public void title(CharSequence t){
        title = t;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(error).setTitle(title)
                .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ;
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}