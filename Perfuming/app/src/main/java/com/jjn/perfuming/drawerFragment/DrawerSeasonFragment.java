package com.jjn.perfuming.drawerFragment;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.jjn.perfuming.R;


public class DrawerSeasonFragment extends Fragment {

    /* 선언 */
    ImageButton imgbtnSpring, imgbtnSummer, imgbtnFall, imgbtnWinter, imgbtnRain;
    onChangeListener changelistener;

    /* 값을 넘기는 함수 구현 */
    public interface onChangeListener{
        void onChanged(String text);
    }

    public void setOnChangeListener(onChangeListener listener){
        this.changelistener = listener;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drawer_season, container, false);

        /* 연결 */
        imgbtnSpring = view.findViewById(R.id.imgbtnSpring);
        imgbtnSummer = view.findViewById(R.id.imgbtnSummer);
        imgbtnFall = view.findViewById(R.id.imgbtnFall);
        imgbtnWinter = view.findViewById(R.id.imgbtnWinter);
        imgbtnRain = view.findViewById(R.id.imgbtnRain);

        /* 구현 */
        imgbtnSpring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changelistener.onChanged("#spring");
            }
        });

        imgbtnSummer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changelistener.onChanged("#summer");
            }
        });

        imgbtnFall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changelistener.onChanged("#fall");
            }
        });

        imgbtnWinter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changelistener.onChanged("#winter");
            }
        });

        imgbtnRain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changelistener.onChanged("#rain");
            }
        });


        return view;
    }
}