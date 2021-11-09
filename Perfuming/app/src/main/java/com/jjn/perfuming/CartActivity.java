package com.jjn.perfuming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class CartActivity extends AppCompatActivity {

    /* 선언 */
    Toolbar cartToolbar;
    CheckBox cbCheckAll;
    Button btnCheckNone, btnBuy;
    TextView tvPriceShow;

    /* 툴바 기능 구현 */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            Intent intent = new Intent(CartActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        /* 연결 */
        cartToolbar = findViewById(R.id.cartToolbar);
        cbCheckAll = findViewById(R.id.cbCheckAll);
        btnCheckNone = findViewById(R.id.btnCheckNone);
        tvPriceShow = findViewById(R.id.tvPriceShow);
        btnBuy = findViewById(R.id.btnBuy);


        /* 툴바 구현*/
        setSupportActionBar(cartToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.logout);
        getSupportActionBar().setDisplayShowTitleEnabled(false);




    }
}