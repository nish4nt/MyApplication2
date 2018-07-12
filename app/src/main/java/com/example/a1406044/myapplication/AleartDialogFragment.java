package com.example.a1406044.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by 1406044 on 09-04-2017.
 */

public class AleartDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Error !").
                setMessage("network not available please try again").setPositiveButton("OK",null);

        AlertDialog dialog = builder.create();
        return dialog;
    }
}
