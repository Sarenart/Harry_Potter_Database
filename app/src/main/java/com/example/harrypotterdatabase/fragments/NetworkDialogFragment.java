package com.example.harrypotterdatabase.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.example.harrypotterdatabase.R;
import com.example.harrypotterdatabase.model.Constants;

public class NetworkDialogFragment extends DialogFragment {

    public static final String  TAG = "NetworkIssue";

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.NetworkIssue)
                .setPositiveButton("Ok",
                        (DialogInterface dialog, int id) -> {

                        });
        return builder.create();
    }

}
