package com.villgro.dikshakushwaha.learningmanagement;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class Course_Content extends AppCompatActivity {
    MyPageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
*/
        setContentView(R.layout.activity_course__content);
        pageAdapter = new MyPageAdapter(getSupportFragmentManager());
        ViewPager pager=(ViewPager)findViewById(R.id.pager);
        pager.setAdapter(pageAdapter);

    }
    /**
     * Custom Page adapter
     */
    private class MyPageAdapter extends FragmentPagerAdapter
    {
        public MyPageAdapter(FragmentManager fm)
        {
            super(fm);
        }
        @Override
        public int getCount()
        {
            return 5;
        }
        @Override
        public Fragment getItem(int position)
        {
            switch(position)
            {
                case 0: return new OptionsFrag();
                case 1: return new OptionsFrag();
                default : return new OptionsFrag();
            }
        }
    }
}


