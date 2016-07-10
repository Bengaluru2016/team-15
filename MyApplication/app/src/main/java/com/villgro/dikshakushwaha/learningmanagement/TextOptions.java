package com.villgro.dikshakushwaha.learningmanagement;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TextOptions extends Fragment implements View.OnClickListener{


    TextView tv_question;
    RadioButton opt1,opt2,opt3,opt4;
    Context context;
    //RadioButton o1,o2,o3,o4;
    Button submit;
    RadioGroup rg;

    View layout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        layout = inflater.inflate(R.layout.fragment_text_option, container, false);



        tv_question=(TextView)layout.findViewById(R.id.tv_question);
        opt1 = (RadioButton) layout.findViewById(R.id.radioButton);
        opt2 = (RadioButton) layout.findViewById(R.id.radioButton2);
        opt3 = (RadioButton) layout.findViewById(R.id.radioButton3);
        opt4 = (RadioButton) layout.findViewById(R.id.radioButton4);
    rg=(RadioGroup)layout.findViewById(R.id.radiogroup);
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
            case R.id.bt_submit:
                int selectedId = rg.getCheckedRadioButtonId();

                if(selectedId== R.id.radioButton2)
                    Toast.makeText(getActivity(),"Correct",Toast.LENGTH_SHORT).show();
                else

                    Toast.makeText(getActivity(),"Wrong",Toast.LENGTH_SHORT).show();

                break;
       /*     case R.id.o2:
                Toast.makeText(getActivity(),"Wrong",Toast.LENGTH_SHORT);
                break;
            case R.id.o3:
                Toast.makeText(getActivity(),"Wrong",Toast.LENGTH_SHORT);
                break;
            case R.id.o4:
                Toast.makeText(getActivity(),"Wrong",Toast.LENGTH_SHORT);
                break;*/
        }

    }


}
