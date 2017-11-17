package com.example.heesu.myapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import android.widget.Button;
import com.nhn.android.naverlogin.OAuthLogin;
import com.nhn.android.naverlogin.OAuthLoginDefine;
import com.nhn.android.naverlogin.OAuthLoginHandler;
import com.nhn.android.naverlogin.ui.view.OAuthLoginButton;

public class MainActivity extends AppCompatActivity {

    //네이버 로그인 API에 필요한 값과 구성요소들을 선언
    private static String OAUTH_CLIENT_ID = "y102OB1eCQjsIHVCcjFI";
    private static String OAUTH_CLIENT_SECRET = "8N5QhdEyp0";
    private static String OAUTH_CLIENT_NAME = "네이버 아이디로 로그인";
    private OAuthLoginButton btOAuthLoginButton;
    private OAuthLogin mOAuthLoginModule;
    Context mContext = MainActivity.this;

    private OAuthLoginHandler mOAuthLoginHandler = new OAuthLoginHandler() {
        @Override
        public void run(boolean b) {
            if (b) {
                String accessToken = mOAuthLoginModule.getAccessToken(mContext);
                Toast.makeText(MainActivity.this, accessToken, Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
            } else {
                String errorCode = mOAuthLoginModule.getLastErrorCode(mContext).getCode();
                String errorDesc = mOAuthLoginModule.getLastErrorDesc(mContext);
                Toast.makeText(MainActivity.this, "errorcode: " + errorCode + ", errordecs:"
                        + errorDesc, Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        //네이버 로그인 인스턴스 초기화
        mOAuthLoginModule = OAuthLogin.getInstance();
        mOAuthLoginModule.init(
                MainActivity.this,
                OAUTH_CLIENT_ID,
                OAUTH_CLIENT_SECRET,
                OAUTH_CLIENT_NAME
        );

        //로그인 버튼을 생성하고 동작을 지정
        btOAuthLoginButton = (OAuthLoginButton) findViewById(R.id.btOAuthLoginImg);
        btOAuthLoginButton.setOAuthLoginHandler(mOAuthLoginHandler);
        btOAuthLoginButton.setBgResourceId(R.drawable.login);

        Button btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        //FirstPageActivity로 가는 인텐트를 생성
                        Intent intent = new Intent(MainActivity.this, FirstPageActivity.class);
                        //액티비티 시작!
                        startActivity(intent);
                    }
                }
        );







    }



}









