package com.example.heesu.myapplication;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Toast;
import com.google.android.gms.common.api.Response;

import java.util.HashMap;
import java.util.Map;




public class TotalReviewActivity extends AppCompatActivity implements View.OnClickListener {

    RatingBar ratingBar;
    Button gobtn;
    Button button2;
    EditText editText1,editText3;

    String url="http://54.250.245.186:3000/process/listreview";
    String storename,reviewtitle,reviewcontent;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_totalreview);
       /* getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent =getIntent();
        storename=intent.getStringExtra("storename");

        editText1=(EditText)findViewById(R.id.editText1); // 제목
        editText3=(EditText)findViewById(R.id.editText3); // 내용
*/
        ratingBar=(RatingBar)findViewById(R.id.ratingBar);
        gobtn = (Button) findViewById(R.id.gobtn);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(TotalReviewActivity.this, ReviewActivity.class);
                        //액티비티 시작!
                        startActivity(intent);
                    }
                }
        );

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(TotalReviewActivity.this, "평점:"+ (int)v,Toast.LENGTH_SHORT).show();
            }
        });

        gobtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(TotalReviewActivity.this, "평점:"+(int)ratingBar.getRating(),Toast.LENGTH_SHORT).show();
            }

        });

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                reviewtitle=editText1.getText().toString();
                reviewcontent=editText3.getText().toString();
              //  addReview();
                break;
        }

    }


    /*private void addReview() {

        StringRequest request = new StringRequest(VoiceInteractor.Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Toast.makeText(getApplicationContext(),response,Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()  throws com.android.volley.AuthFailureError {
                Map<String, String>  params = new HashMap<>();
                Log.e("test",getStorename()+getReviewtitle()+getReviewcontent());
                params.put("reviewstore", getStorename());
                params.put("reviewtitle", getReviewtitle());
                params.put("reviewcontent", getReviewcontent());


                return params;
            }
        };

        request.setShouldCache(false);
        Volley.newRequestQueue(this).add(request);
    }

    public String getStorename() {
        return storename;
    }

    public String getReviewtitle() {
        return reviewtitle;
    }

    public String getReviewcontent() {
        return reviewcontent;
    }*/

}
