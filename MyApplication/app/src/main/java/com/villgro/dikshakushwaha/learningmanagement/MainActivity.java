package com.villgro.dikshakushwaha.learningmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
CardView cv_mentor,cv_staff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cv_mentor=(CardView)findViewById(R.id.cv_mentor);
        cv_staff=(CardView)findViewById(R.id.cv_staff);
        cv_mentor.setOnClickListener(this);
        cv_staff.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.cv_mentor)
        {
            Intent in = new Intent(MainActivity.this, CourseList.class);
           startActivity(in);
        }else if(v.getId()==R.id.cv_staff){
            Intent in = new Intent(MainActivity.this, CourseList.class);
            startActivity(in);
        }
    }
}
