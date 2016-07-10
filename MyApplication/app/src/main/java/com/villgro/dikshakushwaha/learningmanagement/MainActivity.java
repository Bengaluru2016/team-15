package com.villgro.dikshakushwaha.learningmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
CardView cv_mentor,cv_staff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.app_bar);
        Toolbar toolbar = (Toolbar) relativeLayout.findViewById(R.id.kushwhahah);
        TextView score = (TextView)relativeLayout.findViewById(R.id.score);
        score.setVisibility(View.GONE);
        toolbar.setTitle("Villgro");
        setSupportActionBar(toolbar);
/*
        cv_mentor=(CardView)findViewById(R.id.cv_mentor);
        cv_staff=(CardView)findViewById(R.id.cv_staff);
        cv_mentor.setOnClickListener(this);*/
        Button btmentor = (Button)findViewById(R.id.btmentor);
        Button btstaff = (Button)findViewById(R.id.bt_staff);

        btmentor.setOnClickListener(this);
        btstaff.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.btmentor)
        {
            Intent in = new Intent(MainActivity.this, CourseList.class);
           startActivity(in);
        }else if(v.getId()==R.id.bt_staff){
            Intent in = new Intent(MainActivity.this, CourseList.class);
            startActivity(in);
        }
    }
}
