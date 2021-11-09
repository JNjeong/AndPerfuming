package com.jjn.perfuming.MainFragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.jjn.perfuming.Adapter.board_PagerAdapter;
import com.jjn.perfuming.BoardFragmentFragment.BoardEventFragment;
import com.jjn.perfuming.BoardFragmentFragment.BoardNoticeFragment;
import com.jjn.perfuming.R;

/*
* tab메뉴로 2개 페이지로 구성됨
* > 1. 공지사항 페이지 (notice로 명명, 붙은 fragment = fragment_board_notice.xml)
        > fragment_board_notice.xml 엔 RecyclerView로 공지사항리스트를 생성
        > board_notice_RecycleAdapter사용
        > fragment_bard_notice에는 fragment_board_notice_item.xml을 하나하나 붙여가는 형식

* > 2. 이벤트 페이지 (event로 명명, 붙은 fragment = fragment_board_event.xml)
*       > 위는 가격이벤트(price 붙은 xml관련). RecyclerView활용(어댑터 : board_notice_RecycleAdapter), fragment_board_price_item을 붙일 예정
*       > 아래는 기타 이벤트들(event붙은 xml관련). RecyclerView활용(어댑터 : board_event_event_RecycleAdapter), fragment_board_event_item 붙어있음
*
*
* 하단 약관버튼 - gone되있는 layout visible로 변경
*
* */

public class BoardFragment extends Fragment {

    /* 선언 */
    Button btnLaw, btnCloseLaw;
    ImageButton btnPhone, btnCopyright;
    LinearLayout LawLayout, serviceInfoLayout;
    ViewPager2 rv_board;
    board_PagerAdapter board_pagerAdapter;
    TabLayout tabLayout;

    /* fragment 선언 */
    BoardNoticeFragment noticefragment = new BoardNoticeFragment();
    BoardEventFragment eventfragment = new BoardEventFragment();

    Context mContext;

    public BoardFragment(Context context) {

        this.mContext = context;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_board, container, false);

        /* 연결 */
        btnLaw = view.findViewById(R.id.btnLaw);
        btnPhone = view.findViewById(R.id.btnPhone);
        btnCopyright = view.findViewById(R.id.btnCopyright);
        btnCloseLaw = view.findViewById(R.id.btnCloseLaw);
        serviceInfoLayout = view.findViewById(R.id.serviceInfoLayout);
        LawLayout = view.findViewById(R.id.LawLayout);
        rv_board = view.findViewById(R.id.vp_board);
        tabLayout = view.findViewById(R.id.tabLayout);




        /* 약관열기 구현 */
        btnLaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                serviceInfoLayout.setVisibility(View.GONE);
                LawLayout.setVisibility(View.VISIBLE);
            }
        });

        /* 약관닫기 구현 */
        btnCloseLaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LawLayout.setVisibility(View.GONE);
                serviceInfoLayout.setVisibility(View.VISIBLE);
            }
        });

        /* 약관 내, 전화번호 버튼 구현 */
        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "010-8279-9892", Toast.LENGTH_SHORT).show();
            }
        });

        /* 약관 내, 저작권 버튼 구현 */
        btnCopyright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "All Logos and Pictures are copied without Permission. They are FREEEE!", Toast.LENGTH_SHORT).show();
            }
        });

        /* tab구현 */
        board_pagerAdapter = new board_PagerAdapter((FragmentActivity) mContext);
        board_pagerAdapter.addFragment(noticefragment);
        board_pagerAdapter.addFragment(eventfragment);
        rv_board.setAdapter(board_pagerAdapter);

        /* 탭메뉴랑 연동 */
        String[] boardTab = {"NOTICE" , "EVENT"};
        new TabLayoutMediator(tabLayout, rv_board, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(boardTab[position]);
            }
        }).attach();





        return view;
    }
}