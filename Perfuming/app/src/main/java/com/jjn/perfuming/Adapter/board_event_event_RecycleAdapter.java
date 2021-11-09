package com.jjn.perfuming.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jjn.perfuming.R;

import java.util.ArrayList;


public class board_event_event_RecycleAdapter extends RecyclerView.Adapter<board_event_event_RecycleAdapter.MemberHolder>{
    ArrayList<Integer> eventList = new ArrayList<Integer>();
    Context mContext;
    int[] eventBackground = {R.drawable.event1_intro, R.drawable.event2_intro, R.drawable.event3_intro,
            R.drawable.event4_intro, R.drawable.event5_intro, R.drawable.event6_intro, R.drawable.event7_intro};


    public static class MemberHolder extends RecyclerView.ViewHolder {
        /* 선언 */
        ImageButton imgbtnEvent;
        public MemberHolder(@NonNull View itemView) {
            super(itemView);
            /* 연결 */
            imgbtnEvent = itemView.findViewById(R.id.imgbtnEvent);
        }
    }

    public board_event_event_RecycleAdapter(Context mContext){this.mContext = mContext;}

    @NonNull
    @Override
    public board_event_event_RecycleAdapter.MemberHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fragment_board_event_item, parent, false);
        MemberHolder holder = new MemberHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull board_event_event_RecycleAdapter.MemberHolder holder, int position) {
        //이미지 클릭시 큰화면으로 띄우기
        holder.imgbtnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.imgbtnEvent.setBackgroundResource(eventBackground[position]);
    }

    @Override
    public int getItemCount() {return eventList.size();}

    public void addIEventtem(int layout){
        eventList.add(layout);
        notifyDataSetChanged();
    }


}
