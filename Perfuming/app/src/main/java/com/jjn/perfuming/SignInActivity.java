package com.jjn.perfuming;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.jjn.perfuming.userinfo.infodata;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignInActivity extends AppCompatActivity {

    /* 선언 */
    EditText etId, etPw, etName, etPhone, etEmail, etAddr1, etAddr2, etAddr3, etZipcode;
    Button btnCommit, btnBack, btnCheckId;
    RadioButton rbtnMan, rbtnWoman;
    RadioGroup rbtnGroup;
    static int gender;
    infodata info;
    SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        /* 연결 */
        {
            rbtnGroup = findViewById(R.id.rbtnGroup);
            etId = findViewById(R.id.etId);
            btnCheckId = findViewById(R.id.btnCheckId);
            etPw = findViewById(R.id.etPw);
            etName = findViewById(R.id.etName);
            etPhone = findViewById(R.id.etPhone);
            etEmail = findViewById(R.id.etEmail);
            etAddr1 = findViewById(R.id.etAddr1);
            etAddr2 = findViewById(R.id.etAddr2);
            etAddr3 = findViewById(R.id.etAddr3);
            etZipcode = findViewById(R.id.etZipcode);
            btnCommit = findViewById(R.id.btnCommit);
            btnBack = findViewById(R.id.btnBack);
            sPref = getSharedPreferences("LoginInfo", MODE_PRIVATE);
        }

        /* 가입완료 버튼구현 */
        btnCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //정보 유효성 검사용 flag
                boolean flag = true;

                //아이디 확인
                if(etId.getText().toString().length() < 6){
                    Toast.makeText(SignInActivity.this, "아이디는 6글자 이상이어야 합니다.", Toast.LENGTH_SHORT).show();
                    flag = false;
                    etId.setText("");
                }

                //비밀번호 검사
                if(etPw.getText().toString().length() < 8 || etPw.getText().toString().length() > 16){
                    Toast.makeText(SignInActivity.this, "비밀번호는 8글자 이상, 16글자 이하여야 합니다.", Toast.LENGTH_SHORT).show();
                    flag = false;
                    etPw.setText("");
                }
                Pattern patternPw = Pattern.compile("^[a-zA-Z0-9]*$");
                Matcher matcherPw = patternPw.matcher(etPw.getText().toString());
                if(!matcherPw.find()){
                    Toast.makeText(SignInActivity.this, "비밀번호는 영문, 숫자만 가능합니다.", Toast.LENGTH_SHORT).show();
                    flag = false;
                    etPw.setText("");
                }

                //휴대폰 번호 검사
                Pattern patternPhone = Pattern.compile("^\\d{2,3}\\d{3,4}\\d{4}$");
                Matcher matcherPhone = patternPhone.matcher(etPhone.getText().toString());
                if(!matcherPhone.find()){
                    Toast.makeText(SignInActivity.this, "잘못된 전화번호 형식입니다.", Toast.LENGTH_SHORT).show();
                    flag = false;
                    etPhone.setText("");
                }

                //이메일 검사
                Pattern patternEmail = Pattern.compile("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$");
                Matcher matcherEmail = patternEmail.matcher(etEmail.getText().toString());
                if(!matcherEmail.find()){
                    Toast.makeText(SignInActivity.this, "잘못된 이메일 형식입니다.", Toast.LENGTH_SHORT).show();
                    flag = false;
                    etEmail.setText("");
                }

                //성별검사
                rbtnGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        if( i == R.id.rbtnMan) gender = 0;
                        else if (i == R.id.rbtnWoman) gender = 1;
                    }
                });

                //주소 검사
                if(etZipcode.getText().toString().length() != 5){
                    Toast.makeText(SignInActivity.this, "잘못된 우편번호 형식입니다.", Toast.LENGTH_SHORT).show();
                    flag = false;
                    etZipcode.setText("");
                }

                //검사 모두 통과했을 시
                else if(flag){
                    //java 파일에 정보 넘기기
                    info = new infodata(etId.getText().toString(), etPw.getText().toString(), etName.getText().toString(), Integer.parseInt(etPhone.getText().toString()), etEmail.getText().toString(),
                            gender, etAddr1.getText().toString(), etAddr2.getText().toString(), etAddr3.getText().toString(), Integer.parseInt(etZipcode.getText().toString()));

                    //id와 pw 정보를 넘기면서 Login 페이지로 넘어가기
                    Intent intent = new Intent(SignInActivity.this, LoginActivity.class);
                    SharedPreferences.Editor editor = sPref.edit();
                    editor.putString("id", etId.getText().toString());
                    editor.putString("pw",etPw.getText().toString());
                    editor.commit();
                    startActivity(intent);
                    finish();

                }

            }
        });

        /* 돌아가기 버튼구현 */
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //정말로 넘어갈건지 확인하기
                AlertDialog.Builder alert = new AlertDialog.Builder(SignInActivity.this);
                alert.setTitle("돌아가기 주의!");
                alert.setMessage("취소시 모든 정보는 초기화 됩니다. 정말 실행하시겠습니까?");

                //동의시 넘어가기
                alert.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(SignInActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
                alert.show();
            }
        });

        /* 아이디 중복확인 버튼 구현 */
        btnCheckId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etId.getText().toString().length() < 6)
                    Toast.makeText(SignInActivity.this, "아이디는 6자 이상 입력해주세요", Toast.LENGTH_SHORT).show();
                if(sPref.getString("id", "null") == "null")
                    Toast.makeText(SignInActivity.this, "사용가능한 아이디입니다.", Toast.LENGTH_SHORT).show();
                else if(sPref.getString("id", "") == etId.getText().toString())
                    Toast.makeText(SignInActivity.this, "중복된 아이디입니다.", Toast.LENGTH_SHORT).show();
                else Toast.makeText(SignInActivity.this, "사용가능한 아이디입니다.", Toast.LENGTH_SHORT).show();
            }
        });


    }
}