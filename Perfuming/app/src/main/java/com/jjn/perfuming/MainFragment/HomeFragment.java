package com.jjn.perfuming.MainFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.jjn.perfuming.R;

import java.util.Timer;
import java.util.TimerTask;


public class HomeFragment extends Fragment {

    /* 선언 */
    ImageView imgHome;
    int[] slideshowImgList = {R.drawable.slideshow1, R.drawable.slideshow2, R.drawable.slideshow3, R.drawable.slideshow4, R.drawable.slideshow5, R.drawable.slideshow6, R.drawable.slideshow7};
    int count = 0;
    ImageButton imgbtnHot, imgbtnSunny, imgbtnWindy, imgbtnRainy, imgbtnSnowy, imgbtnMeeting, imgbtnDating, imgbtnFriends, imgbtnWork, imgbtnGood, imgbtnSoso, imgbtnBad;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        /* 연결 */
        {
            imgHome = view.findViewById(R.id.imgHome);
            imgbtnHot = view.findViewById(R.id.imgbtnHot);
            imgbtnSunny = view.findViewById(R.id.imgbtnSunny);
            imgbtnWindy = view.findViewById(R.id.imgbtnWindy);
            imgbtnRainy = view.findViewById(R.id.imgbtnRainy);
            imgbtnSnowy = view.findViewById(R.id.imgbtnSnowy);
            imgbtnMeeting = view.findViewById(R.id.imgbtnMeeting);
            imgbtnDating = view.findViewById(R.id.imgbtnDating);
            imgbtnFriends = view.findViewById(R.id.imgbtnFriends);
            imgbtnWork = view.findViewById(R.id.imgbtnWork);
            imgbtnGood = view.findViewById(R.id.imgbtnGood);
            imgbtnSoso = view.findViewById(R.id.imgbtnSoso);
            imgbtnBad = view.findViewById(R.id.imgbtnBad);
        }

        /* 슬라이드쇼 구현 */
        setTimer();


        /* 오늘의 향수 버튼 구현 */



















        return view;
    }

    void setTimer(){
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                imgHome.post(new Runnable() {
                    @Override
                    public void run() {
                        imgHome.setImageResource(slideshowImgList[(count)]);
                        count++;
                        if(count==6) count=0;
                    }
                });
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 0, 7000);
    }


}

