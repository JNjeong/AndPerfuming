package com.jjn.perfuming.BoardFragmentFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjn.perfuming.Adapter.board_notice_RecycleAdapter;
import com.jjn.perfuming.R;


public class BoardNoticeFragment extends Fragment {

    /* 선언 */
    RecyclerView rv_notice;
    board_notice_RecycleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_board_notice, container, false);

        /* 연결 */
        rv_notice = view.findViewById(R.id.rv_notice);
        adapter = new board_notice_RecycleAdapter(getContext());
        rv_notice.setAdapter(adapter);


        adapter.addINoticeitem(R.layout.fragment_board_notice_item);
        adapter.addINoticeitem(R.layout.fragment_board_notice_item);
        adapter.addINoticeitem(R.layout.fragment_board_notice_item);
        adapter.addINoticeitem(R.layout.fragment_board_notice_item);


        LinearLayoutManager linearManager = new LinearLayoutManager(getContext());
        linearManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_notice.setLayoutManager(linearManager);

        return view;
    }
}