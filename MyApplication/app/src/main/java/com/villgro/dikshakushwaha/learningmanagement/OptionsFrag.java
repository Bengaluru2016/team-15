package com.villgro.dikshakushwaha.learningmanagement;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class OptionsFrag extends Fragment implements View.OnClickListener{


TextView tv_question;
    ImageButton opt1,opt2,opt3,opt4;
    Context context;

    View layout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        layout = inflater.inflate(R.layout.options_frag, container, false);
        tv_question=(TextView)layout.findViewById(R.id.tv_question);
        opt1 = (ImageButton)layout.findViewById(R.id.iv_o1);
        opt2 = (ImageButton)layout.findViewById(R.id.iv_o2);
        opt3 = (ImageButton)layout.findViewById(R.id.iv_o3);
        opt4 = (ImageButton)layout.findViewById(R.id.iv_o4);

        opt1.setOnClickListener(this);
        opt2.setOnClickListener(this);
        opt3.setOnClickListener(this);
        opt4.setOnClickListener(this);

        return layout;

    }




    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id){
            case R.id.iv_o1:
                Toast.makeText(getActivity(),"Correct",Toast.LENGTH_SHORT);

                break;
            case R.id.iv_o2:
                Toast.makeText(getActivity(),"Wrong",Toast.LENGTH_SHORT);
                break;
            case R.id.iv_o3:
                Toast.makeText(getActivity(),"Wrong",Toast.LENGTH_SHORT);
                break;
            case R.id.iv_o4:
                Toast.makeText(getActivity(),"Wrong",Toast.LENGTH_SHORT);
                break;
        }
    }


}
