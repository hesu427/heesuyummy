package com.example.heesu.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by heesu on 2017-12-06.
 */

public class DBActivity extends AppCompatActivity {

    final static String TAG = "AndroidNodeJS";
    final static String defaultUrl = "http://54.250.245.186:3000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        EditText server = (EditText) findViewById(R.id.server);
        server.setText(defaultUrl);

        Button insertBtn = (Button) findViewById(R.id.insertBtn);
        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edit_name = (EditText) findViewById(R.id.name);
                EditText edit_address = (EditText) findViewById(R.id.address);
                EditText edit_phone = (EditText) findViewById(R.id.phone);

                JSONObject postDataParam = new JSONObject();
                try {
                    postDataParam.put("name", edit_name.getText().toString());
                    postDataParam.put("address", edit_address.getText().toString());
                    postDataParam.put("phone", edit_phone.getText().toString());
                } catch (JSONException e) {
                    Log.e(TAG, "JSONEXception");
                }
                new InsertData(DBActivity.this).execute(postDataParam);
                new GetData(DBActivity.this).execute();
            }
        });

       /* Button getBtn = (Button) findViewById(R.id.getBtn);
        getBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new GetData(DBActivity.this).execute();

            }
        });

        ListView txtList = (ListView) findViewById(R.id.txtList);
        txtList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Adapter adapter = adapterView.getAdapter();
                JSONObject postDataParam = new JSONObject();
                try {
                    postDataParam.put("_id", ((Book)adapter.getItem(i))._id);
                } catch (JSONException e) {
                    Log.e(TAG, "JSONEXception");
                }
                new DeleteData(DBActivity.this).execute(postDataParam);
                new GetData(DBActivity.this).execute();
            }
        });*/
    }
}

