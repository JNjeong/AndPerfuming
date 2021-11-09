package com.jjn.perfuming;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.jjn.perfuming.userinfo.infodata;

/*
* GM용 로그인 구현 : ID-000000, pw-asdf0000
* 회원가입 정보를 확인하여 로그인구현
* > 회원가입 정보가 있다면 AutoLogin 구현
*
* 회원가입페이지(SignInActivity로 이동)
* 로그인 성공시 MainActivity로 이동
* */

public class LoginActivity extends AppCompatActivity {

    /* 선언 */
    EditText etId, etPw;
    Button btnGoogle, btnNaver, btnDaum, btnLogin, btnSignin;
    ImageButton btnGoogleImg, btnNaverImg, btnDaumImg;
    infodata info = new infodata();
    CheckBox cbAutologin;
    SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        /* 연결 */
        {
            etId = findViewById(R.id.etId);
            etPw = findViewById(R.id.etPw);
            btnLogin = findViewById(R.id.btnLogin);
            btnSignin = findViewById(R.id.btnSignin);
            btnGoogleImg = findViewById(R.id.btnGoogleImg);
            btnNaverImg = findViewById(R.id.btnNaverImg);
            btnDaumImg = findViewById(R.id.btnDaumImg);
            btnGoogle = findViewById(R.id.btnGoogle);
            btnNaver = findViewById(R.id.btnNaver);
            btnDaum = findViewById(R.id.btnDaum);
            cbAutologin = findViewById(R.id.cbAutologin);
            sPref = getSharedPreferences("LoginInfo", MODE_PRIVATE);
        }


        /* 로그인 버튼 구현 */
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* GM용 로그인 */
                if(etId.getText().toString().equals("000000") && etPw.getText().toString().equals("asdf0000")){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                }

                boolean flag = true;
                //autoLogin을 통한 로그인
                if(sPref.getString("id","") == etId.getText().toString() && sPref.getString("pw","") == etPw.getText().toString()){
                    Toast.makeText(LoginActivity.this, "돌아오셨군요! 감사합니다❤", Toast.LENGTH_SHORT).show();
                }


                //회원정보가 없을 경우
                else if(info.getUserid() == (null) || info.getUserpw() == (null)){
                    AlertDialog.Builder alert = new AlertDialog.Builder(LoginActivity.this);
                    alert.setTitle("비회원 사용 불가능");
                    alert.setMessage("회원가입을 먼저 진행해주세요. 감사합니다❤");
                    alert.show();
                    flag = false;
                    return;
                }

                //아이디, 비밀번호 불일치
                else if( (!etId.getText().toString().equals(info.getUserid())) || (!etPw.getText().toString().equals(info.getUserpw()) )){
                    Toast.makeText(LoginActivity.this, "아이디 혹은 비밀번호 불일치", Toast.LENGTH_LONG).show();
                    etId.setText("");
                    etPw.setText("");
                    flag = false;
                    return;
                }

                //아이디, 비밀번호 일치 - 로그인 성공
                if(flag){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        /* 자동로그인 버튼 구현 */
        cbAutologin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    //회원가입 성공시에만 아이디, 비밀번호 자동 등록 확인
                    if(sPref.getString("id","") != "" && sPref.getString("pw", "")!= "") {
                        AlertDialog.Builder alert = new AlertDialog.Builder(LoginActivity.this);
                        alert.setTitle("회원가입 이력이 있습니다.");
                        alert.setMessage("회원의 아이디와 비밀번호를 바로 입력하시겠습니까?");

                        //아이디, 비번 자동등록 허용
                        alert.setPositiveButton("예", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                etId.setText(sPref.getString("id",""));
                                etPw.setText(sPref.getString("pw",""));
                            }
                        });

                        //아이디, 비번 자동등록 불허
                        alert.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(LoginActivity.this, "새로 오신 사용자이시라면, 회원가입을 해주시기 바랍니다. 감사합니다❤", Toast.LENGTH_LONG).show();
                            }
                        });
                        alert.show();

                    }
                }
                else {
                    etId.setText("");
                    etPw.setText("");
                }
            }
        });




        /* 회원가입 버튼 구현 */
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignInActivity.class);
                startActivity(intent);
                finish();
            }
        });

        /* 이메일 로그인 옵션 구현 */
        {
            btnGoogle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    etId.append("@google.com");
                }
            });
            btnGoogleImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    etId.append("@google.com");
                }
            });
            btnNaver.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    etId.append("@naver.com");
                }
            });
            btnNaverImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    etId.append("@naver.com");
                }
            });
            btnDaum.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    etId.append("@daum.net");
                }
            });
            btnDaumImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    etId.append("@daum.net");
                }
            });
        }
    }



    //    @Override
//    protected void onResume() {
//        super.onResume();
//
//        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//        startActivity(intent);
//        finish();
//
//
//    }
}