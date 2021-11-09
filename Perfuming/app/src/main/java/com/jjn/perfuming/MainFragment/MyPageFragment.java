package com.jjn.perfuming.MainFragment;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jjn.perfuming.R;
import com.jjn.perfuming.userinfo.infodata;


public class MyPageFragment extends Fragment {

    /* 선언 */
    infodata info;
    TextView tvPageName, tvPageId, tvPagePhone, tvPageEmail, tvPageAddr;
    Button btnInfoSet, btnPageCommit, btnPageCancel;
    LinearLayout editinfoLayout;
    EditText etPageName, etPagePhone, etPageEmail, etPageAddr_1, etPageAddr_2;
    RecyclerView rv_myPage;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_page, container, false);
        
        /* 연결 */
        tvPageName = view.findViewById(R.id.tvPageName);
        tvPageId = view.findViewById(R.id.tvPageId);
        tvPagePhone = view.findViewById(R.id.tvPagePhone);
        tvPageEmail=  view.findViewById(R.id.tvPageEmail);
        tvPageAddr= view.findViewById(R.id.tvPageAddr);
        btnInfoSet = view.findViewById(R.id.btnInfoSet);
        editinfoLayout = view.findViewById(R.id.editinfoLayout);
        etPageName = view.findViewById(R.id.etPageName);
        etPagePhone = view.findViewById(R.id.etPagePhone);
        etPageEmail = view.findViewById(R.id.etPageEmail);
        etPageAddr_1 = view.findViewById(R.id.etPageAddr_1);
        etPageAddr_2 = view.findViewById(R.id.etPageAddr_2);
        btnPageCommit = view.findViewById(R.id.btnPageCommit);
        btnPageCancel = view.findViewById(R.id.btnPageCancel);
        rv_myPage = view.findViewById(R.id.rv_myPage);

        /* 회원정보 연동 */
        info = new infodata();
        tvPageName.setText(info.getUsername());
        tvPageId.setText(info.getUserid());
        tvPagePhone.setText("0" + String.valueOf(info.getUserphone()));
        tvPageEmail.setText(info.getUseremail());
        tvPageAddr.setText(info.getUseraddr1());
        tvPageAddr.append(" "+info.getUseraddr2());
        tvPageAddr.append(" "+info.getUserarrd3());

        /* 정보수정 버튼 구현 */
        btnInfoSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editinfoLayout.setVisibility(view.VISIBLE);
            }
        });

        /* 정보수정 확인버튼 구현 */
        btnPageCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etPageName.getText().toString().equals("") || etPagePhone.getText().toString().equals("") || etPageEmail.getText().toString().equals("") || etPageAddr_1.getText().toString().equals("") || etPageAddr_2.getText().toString().equals("")){
                    Toast.makeText(getContext(), "미입력란이 있습니다.", Toast.LENGTH_SHORT).show();
                }
                else{
                    tvPageName.setText(etPageName.getText().toString());
                    tvPagePhone.setText(etPagePhone.getText().toString());
                    tvPageEmail.setText(etPageEmail.getText().toString());
                    tvPageAddr.setText(etPageAddr_1.getText().toString());
                    tvPageAddr.append(etPageAddr_2.getText().toString());
                    info.setUsername(etPageName.getText().toString());
                    info.setUserphone(Integer.parseInt(etPagePhone.getText().toString()));
                    info.setUseraddr2(etPageAddr_1.getText().toString());
                    info.setUserarrd3(etPageAddr_2.getText().toString());
                    editinfoLayout.setVisibility(view.GONE);
                }

            }
        });

        /* 정보수정 취소버튼 구현 */
        btnPageCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                alert.setTitle("취소 재확인");
                alert.setMessage("모든 작성이 사라집니다. 정말 취소하시겠습니까?");
                alert.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        editinfoLayout.setVisibility(view.GONE);
                    }
                });
                alert.show();
            }
        });

        /* RecyclerView 연결 */













        return view;
    }
}