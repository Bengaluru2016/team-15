package com.villgro.dikshakushwaha.learningmanagement;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class CourseList extends AppCompatActivity  implements View.OnClickListener{

    private RecyclerView rv_courseList;
    public CourseListAdapter adapter;
   // public String categoryName;
    public StaggeredGridLayoutManager layoutManager;
  //  DBEventDetails get;
    List<Course> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        data.add(new Course("Course 1", R.drawable.assessment));
        data.add(new Course("Course 2", R.drawable.assessment));
        data.add(new Course("Course 3", R.drawable.assessment));
        data.add(new Course("Course 4", R.drawable.assessment));

        rv_courseList = (RecyclerView) findViewById(R.id.rv_courses);
        adapter = new CourseListAdapter(this, data);
        rv_courseList.setAdapter(adapter);
        layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rv_courseList.setLayoutManager(layoutManager);
        rv_courseList.addOnItemTouchListener(new RecyclerTouchListener(this, rv_courseList, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(CourseList.this,Course_Content.class);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));
    }

    @Override
    public void onClick(View v) {

    }

    public static interface ClickListener {
        public void onClick(View view, int position);

        public void onLongClick(View view, int position);
    }

    static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}
