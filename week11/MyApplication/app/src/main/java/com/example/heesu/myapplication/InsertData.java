package com.example.heesu.myapplication;

import android.app.Activity;
import android.widget.EditText;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by heesu on 2017-12-06.
 */
public class InsertData extends PostRequest {
    public InsertData(Activity activity) {
        super(activity);
    }

    @Override
    protected void onPreExecute() {
        EditText server = (EditText) activity.findViewById(R.id.server);
        String serverURLStr = server.getText().toString();
        try {
            url = new URL(serverURLStr + "/registration");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


}