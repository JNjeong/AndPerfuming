package com.jjn.perfuming.BoardFragmentFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjn.perfuming.Adapter.board_event_event_RecycleAdapter;
import com.jjn.perfuming.R;


public class BoardEventFragment extends Fragment {

    /* 선언 */
    RecyclerView rv_event_price, rv_event_event;
    board_event_event_RecycleAdapter eventadapter;
    int[] eventBackground = {R.drawable.event1_intro, R.drawable.event2_intro, R.drawable.event2_intro, R.drawable.event3_intro,
            R.drawable.event4_intro, R.drawable.event5_intro, R.drawable.event6_intro, R.drawable.event7_intro};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_board_event, container, false);

        /* 연결 */
        rv_event_price = view.findViewById(R.id.rv_event_price);
        rv_event_event = view.findViewById(R.id.rv_event_event);

        /* 가격이벤트 연결 */



        /* 기타이벤트 연결 */
        eventadapter = new board_event_event_RecycleAdapter(getContext());
        rv_event_event.setAdapter(eventadapter);



        for(int i = 0 ;  i <7; i++ ){
            eventadapter.addIEventtem(R.layout.fragment_board_event_item);
        }

        LinearLayoutManager linearManager = new LinearLayoutManager(getContext());
        linearManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_event_event.setLayoutManager(linearManager);

        return view;
    }


}