package com.villgro.dikshakushwaha.learningmanagement;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class PicOptions extends AppCompatActivity implements View.OnClickListener{

    TextView tv_question;
    ImageButton opt1,opt2,opt3,opt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picoptions);
        tv_question=(TextView)findViewById(R.id.tv_question);
        opt1 = (ImageButton)findViewById(R.id.iv_o1);
        opt2 = (ImageButton)findViewById(R.id.iv_o2);
        opt3 = (ImageButton)findViewById(R.id.iv_o3);
        opt4 = (ImageButton)findViewById(R.id.iv_o4);

        opt1.setOnClickListener(this);
        opt2.setOnClickListener(this);
        opt3.setOnClickListener(this);
        opt4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id){
            case R.id.iv_o1:
                Toast.makeText(this,"Correct",Toast.LENGTH_SHORT);

                break;
            case R.id.iv_o2:
                Toast.makeText(this,"Wrong",Toast.LENGTH_SHORT);
                break;
            case R.id.iv_o3:
                Toast.makeText(this,"Wrong",Toast.LENGTH_SHORT);
                break;
            case R.id.iv_o4:
                Toast.makeText(this,"Wrong",Toast.LENGTH_SHORT);
                break;
        }
    }
}
