package com.villgro.dikshakushwaha.learningmanagement;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dikshakushwaha on 10/07/16.
 */

public class CourseListAdapter  extends RecyclerView.Adapter<CourseListAdapter.MyViewHolder> {


    private LayoutInflater inflater;
    List<Course> data = new ArrayList<>();
    Context c;

    public CourseListAdapter(Context context, List<Course> data) {
        c = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.course_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Course current = data.get(position);
        int resId = 0;
        try {
            holder.image.setImageResource(R.drawable.assessment);
        } catch (Exception e) {
            Log.d("No resource ID found:", "" + resId + " / " + e);
            holder.image.setImageResource(R.drawable.assessment);
        }
        holder.name.setText(current.name);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }





    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name;

        public MyViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.event_image);
            name = (TextView) itemView.findViewById(R.id.event_name);

        }
    }
}
