package com.szymonkaczmarek.palapala;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

class AlertDialogHelper {
    private Context context;

    AlertDialogHelper(Context c){
        this.context = c;
    }

    void showDialog(String title, String text, String close){
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(text);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, close,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

}
