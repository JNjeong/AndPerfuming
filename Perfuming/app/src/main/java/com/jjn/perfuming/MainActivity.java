package com.jjn.perfuming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.jjn.perfuming.MainFragment.BoardFragment;
import com.jjn.perfuming.MainFragment.HomeFragment;
import com.jjn.perfuming.MainFragment.MyPageFragment;
import com.jjn.perfuming.MainFragment.ReviewFragment;
import com.jjn.perfuming.MainFragment.SearchFragment;

/*
* 컨텐츠 전반을 담는 MainActivity
* 상단 : 툴바
* >상단 메뉴구성 :
* > 좌측 = 로그아웃 (LoginActivty로 이동)
* > 우측에서 2번째 : wishList (구현예정인 샹품페이지에서 wishlist에 추가시, wishlist페이지(recyclerView)로 이동
* > 가장 우측 : 장바구니 (구현예정인 상품페이지에서 장바구니에 추가시, 장바구니(recyclerView)로 이동
*
* 중간 : 각 컨텐츠별 Fragment 담아둠
*
* 하단 : BottomNavi로 컨텐츠 별로 구현
* >하단 메뉴구성 :
* 1. search (구현예정, fragment_search.xml) : drawer를 사용. drawer에 drawer_search.xml를 붙이긴 하였으나, drawer에서 제공하는 header는 제공칸이 작아서 drawer_search.xml에서 직접 크기를 고정시켜서 붙임.
*                   단말이 크기에 따라 화면의 크기가 조절되지 않는다는 단점
* 2. review (구현예정, fragment_review.xml)
*
* 3. home (구현예정, fragment_home.xml)
*
* 4. board (에러발생 두번클릭시 앱중단. fragment_board.xml)
*
* 5. mypage (개인정보 및 기타 페이지, 구현예정, fragment_my_page.xml)
* */
public class MainActivity extends AppCompatActivity {

    /* 선언 */
    BottomNavigationView btmnvMenu;
    FrameLayout flMain;
    Toolbar mainToolbar;
    NavigationView nvSearch;
    DrawerLayout Login;

    //fragment 관리자 선언
    FragmentManager fgmanager;
    FragmentTransaction fgTransaction;
    int selectedFragment = 0;

    //fragment 선언
    SearchFragment searchfg;
    ReviewFragment reviewfg;
    HomeFragment homefg;
    BoardFragment boardfg;
    MyPageFragment mypagefg;

    LinearLayout drawerLayout;
    ImageButton imgbtnTagList;
    LinearLayout tagListLayout;
    Button btnCloseTag;

    /* 툴바 오버라이드 옵션 */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /* toolbar 기능 구현 */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //장바구니 선택시 장바구니로 이동
        if(item.getItemId() == R.id.mi_cart){
            Intent intent = new Intent(MainActivity.this, CartActivity.class);
            startActivity(intent);
            finish();
        }
        //위시리스트 선택시 위시리스트 이동
        if(item.getItemId() == R.id.mi_wish){
            Intent intent = new Intent(MainActivity.this, WishActivity.class);
            startActivity(intent);
            finish();
        }
        //로그아웃 선택시 로그인페이지로 이동
        if(item.getItemId() == android.R.id.home){
            AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
            alert.setTitle("로그아웃");
            alert.setMessage("정말로 로그아웃 하시겠습니까?");
            alert.setPositiveButton("예", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
            alert.show();
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* 연결 */
        {
            flMain = findViewById(R.id.flMain);
            btmnvMenu = findViewById(R.id.btmnvMenu);
            mainToolbar = findViewById(R.id.mainToolbar);
//            nvSearch = findViewById(R.id.nvSearch);
            drawerLayout = findViewById(R.id.drawerLayout);
            Login = findViewById(R.id.Login);

            //fragment객체화
            searchfg = new SearchFragment();
            reviewfg = new ReviewFragment();
            homefg = new HomeFragment();
            boardfg = new BoardFragment(this);
            mypagefg = new MyPageFragment();

            //툴바연결
            setSupportActionBar(mainToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); //로그아웃버튼 활성화
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.logout); //로그아웃버튼 로고변경
            getSupportActionBar().setDisplayShowTitleEnabled(false); //기본타이틀 비활성화

            imgbtnTagList = findViewById(R.id.imgbtnTagList);
            tagListLayout = findViewById(R.id.tagListLayout);
            btnCloseTag = findViewById(R.id.btnCloseTag);
        }


        /* BottomNavigationView, MainMenu 구현 */
        fgmanager = getSupportFragmentManager();
        fgTransaction = fgmanager.beginTransaction();

        //시작시 선택되는 화면을 homeFragment로 설정
        fgTransaction.add(R.id.flMain, homefg);
        fgTransaction.commit();

        //시작시 선택되는 memu를 home버튼로 설정
        btmnvMenu.setSelectedItemId(R.id.miHome);
        btmnvMenu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //메뉴에서 search가 선택되었을때
                if(item.getItemId() == R.id.miSearch){
                    //drawer를 꺼내기
//                    Login.openDrawer(GravityCompat.START);
                    Login.openDrawer(drawerLayout);



                    /*drawer 기능, 태그 열기 구현*/
                    imgbtnTagList.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            tagListLayout.setVisibility(view.VISIBLE);
                            Toast.makeText(MainActivity.this, "Tag Open!" , Toast.LENGTH_SHORT).show();
                        }
                    });

                    /* drawer 기능, 태그 닫기 구현 */
                    btnCloseTag.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            tagListLayout.setVisibility(view.GONE);
                            Toast.makeText(MainActivity.this, "Tag Close!" , Toast.LENGTH_SHORT).show();
                        }
                    });
                    
                    
                    
                    
                    
                    
                    
                    
                }
                //메뉴에서 review가 선택되었을때
                else if(item.getItemId() == R.id.miReview){
                    if(selectedFragment != 2){
                        fgTransaction = fgmanager.beginTransaction();
                        fgTransaction.replace(R.id.flMain, reviewfg);
                        fgTransaction.commit();
                        selectedFragment = 2;
                        return true;
                    }
                }
                //메뉴에서 home이 선택되었을때
                else if(item.getItemId() == R.id.miHome){
                    if(selectedFragment != 3){
                        fgTransaction = fgmanager.beginTransaction();
                        fgTransaction.replace(R.id.flMain, homefg);
                        fgTransaction.commit();
                        selectedFragment = 3;
                        return true;
                    }
                }
                //메뉴에서 board가 선택되었을때
                else if(item.getItemId() == R.id.miBoard){
                    if(selectedFragment != 4){
                        fgTransaction = fgmanager.beginTransaction();
                        fgTransaction.replace(R.id.flMain, boardfg);
                        fgTransaction.commit();
                        selectedFragment = 4;
                        return true;
                    }
                }
                //메뉴에서 mypage가 선택되었을때
                else if(item.getItemId() == R.id.miMyPage){
                    if(selectedFragment != 5){
                        fgTransaction = fgmanager.beginTransaction();
                        fgTransaction.replace(R.id.flMain, mypagefg);
                        fgTransaction.commit();
                        selectedFragment = 5;
                        return true;
                    }
                }
                return false;
            }
        });




    }

}