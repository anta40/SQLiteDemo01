package com.anta40.app.sqlitedemo01;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DBAccess dbAccess;
    private List<String> keyList, valueList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbAccess = DBAccess.getInstance(this);
        dbAccess.open();

        keyList = dbAccess.getKeys();
        valueList = dbAccess.getValues();

        dbAccess.close();

        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Hello!");
        alertDialog.setMessage("Keys: "+convertArrayListToString(keyList)+"\n"+"Values: "+convertArrayListToString(valueList));
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    private String convertArrayListToString(List<String> sss){
        StringBuffer sb = new StringBuffer();
        sb.append("[");

        for (String s:sss){
            sb.append(s+" ");
        }
        sb.append("]");
        return sb.toString();
    }
}
