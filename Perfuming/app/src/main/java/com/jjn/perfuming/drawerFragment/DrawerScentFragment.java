package com.jjn.perfuming.drawerFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.jjn.perfuming.R;

public class DrawerScentFragment extends Fragment {

    /* 선언 */
    ImageButton imgbtnAldehyde, imgbtnAqua, imgbtnCitrus, imgbtnCypre, imgbtnFloralBouquet, imgbtnFougere, imgbtnFruity, imgbtnMusk, imgbtnOriental, imgbtnPowder, imgbtnSingleFloral, imgbtnSpicy, imgbtnTabacLeisure, imgbtnWoody;
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
        View view = inflater.inflate(R.layout.fragment_drawer_scent, container, false);

        /* 연결 */
        imgbtnAldehyde = view.findViewById(R.id.imgbtnAldehyde);
        imgbtnAqua = view.findViewById(R.id.imgbtnAqua);
        imgbtnCitrus = view.findViewById(R.id.imgbtnCitrus);
        imgbtnCypre = view.findViewById(R.id.imgbtnCypre);
        imgbtnFloralBouquet = view.findViewById(R.id.imgbtnFloralBouquet);
        imgbtnFougere = view.findViewById(R.id.imgbtnFougere);
        imgbtnFruity = view.findViewById(R.id.imgbtnFruity);
        imgbtnMusk = view.findViewById(R.id.imgbtnMusk);
        imgbtnOriental = view.findViewById(R.id.imgbtnOriental);
        imgbtnPowder = view.findViewById(R.id.imgbtnPowder);
        imgbtnSingleFloral = view.findViewById(R.id.imgbtnSingleFloral);
        imgbtnSpicy = view.findViewById(R.id.imgbtnSpicy);
        imgbtnTabacLeisure = view.findViewById(R.id.imgbtnTabacLeisure);
        imgbtnWoody = view.findViewById(R.id.imgbtnWoody);

        /* 구현 */
        imgbtnAldehyde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changelistener.onChanged("#aldehyde");
            }
        });
        imgbtnAqua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changelistener.onChanged("#aqua");
            }
        });
        imgbtnCitrus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changelistener.onChanged("#citrus");
            }
        });
        imgbtnCypre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changelistener.onChanged("#cypre");
            }
        });
        imgbtnFloralBouquet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changelistener.onChanged("#floralbouquet");
            }
        });
        imgbtnFougere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changelistener.onChanged("#fougere");
            }
        });
        imgbtnFruity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changelistener.onChanged("#fruity");
            }
        });
        imgbtnMusk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changelistener.onChanged("#musk");
            }
        });
        imgbtnOriental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changelistener.onChanged("#oriental");
            }
        });
        imgbtnPowder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changelistener.onChanged("#powder");
            }
        });
        imgbtnSingleFloral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changelistener.onChanged("#singlefloral");
            }
        });
        imgbtnSpicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changelistener.onChanged("#spicy");
            }
        });
        imgbtnTabacLeisure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changelistener.onChanged("#tabacleisure");
            }
        });
        imgbtnWoody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changelistener.onChanged("#woody");
            }
        });

        return view;
    }
}