package com.example.heesu.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import java.io.File;

/**
 * Created by heesu on 2017-11-10.
 */

public class FirstPageActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_firstpage);

        Button mapbtn = (Button) findViewById(R.id.mapbtn);
        Button reservationbtn = (Button) findViewById(R.id.reservationbtn);
        Button reviewbtn = (Button) findViewById(R.id.reviewbtn);
        Button regbtn = (Button)findViewById(R.id.regbtn);
        Button getget = (Button)findViewById(R.id.getget);
              regbtn.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(FirstPageActivity.this, DBActivity.class);
                        //액티비티 시작!
                        startActivity(intent);
                    }
                }
        );
        reviewbtn.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(FirstPageActivity.this, TotalReviewActivity.class);
                        //액티비티 시작!
                        startActivity(intent);
                    }
                }
        );
        reservationbtn.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(FirstPageActivity.this, ReservationActivity.class);
                        //액티비티 시작!
                        startActivity(intent);
                    }
                }
        );
        mapbtn.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        //FirstPageActivity로 가는 인텐트를 생성
                        Intent intent = new Intent(FirstPageActivity.this, GooglleMapActivity.class);
                        //액티비티 시작!
                        startActivity(intent);
                    }

                }
        );
        Button sharebtn = (Button) findViewById(R.id.sharebtn);
        sharebtn.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        shareImage(); //공유 이미지 함수를 호출 합니다.
                    }

                });
    }

    public void shareImage() { //공유 이미지 함수
        File dirName = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) + "/Download");  //디렉토리를 지정합니다.
        String file = "abc.jpg"; //공유할 이미지 파일 명
        File yummmy = new File(dirName, file); //image 파일의 경로를 설정합니다.
        Uri mSaveImageUri = Uri.fromFile(yummmy); //file의 경로를 uri로 변경합니다.
        Intent intent = new Intent(Intent.ACTION_SEND); //전송 메소드를 호출합니다. Intent.ACTION_SEND
        intent.setType("image/jpg"); //jpg 이미지를 공유 하기 위해 Type을 정의합니다.
        intent.putExtra(Intent.EXTRA_STREAM, mSaveImageUri); //사진의 Uri를 가지고 옵니다.
        startActivity(Intent.createChooser(intent, "Choose")); //Activity를 이용하여 호출 합니다.
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                System.out.println(s);
                return false;
            }

        });

        return true;
    }
}

