package com.jjn.perfuming.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jjn.perfuming.R;

import java.util.ArrayList;

public class board_notice_RecycleAdapter extends RecyclerView.Adapter<board_notice_RecycleAdapter.MemberHolder> {

    ArrayList<Integer> noticeList = new ArrayList<Integer>();
    Context mContext;

    public class MemberHolder extends RecyclerView.ViewHolder {
        /* 선언 */
        TextView mi_tv_notice_g, mi_tv_notice_j, mi_tv_notice_u, mi_notice_text;

        public MemberHolder(@NonNull View itemView) {
            super(itemView);
            /* 연결 */
            mi_tv_notice_g = itemView.findViewById(R.id.mi_tv_notice_g);
            mi_tv_notice_j = itemView.findViewById(R.id.mi_tv_notice_j);
            mi_tv_notice_u = itemView.findViewById(R.id.mi_tv_notice_u);
            mi_notice_text = itemView.findViewById(R.id.mi_notice_text);
        }
    }

    public board_notice_RecycleAdapter(Context mContext){this.mContext = mContext;}

    @NonNull
    @Override
    public MemberHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fragment_board_notice_item, parent, false);
        board_notice_RecycleAdapter.MemberHolder holder = new board_notice_RecycleAdapter.MemberHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MemberHolder holder, int position) {

    }

    @Override
    public int getItemCount() {return noticeList.size();}

    public void addINoticeitem(int layout){
        noticeList.add(layout);
        notifyDataSetChanged();
    }
}
