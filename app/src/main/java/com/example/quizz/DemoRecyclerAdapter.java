package com.example.quizz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DemoRecyclerAdapter extends RecyclerView.Adapter<DemoRecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<DemoContactModel> arrContacts;

    DemoRecyclerAdapter(Context context, ArrayList<DemoContactModel>arrContacts){
        this.context = context;
        this.arrContacts = arrContacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.demo_row, parent, false);
        ViewHolder viewholder = new ViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.I1.setImageResource(arrContacts.get(position).image);
        holder.t1.setText(arrContacts.get(position).name);
    }

    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView t1;
        ImageView I1;
        public ViewHolder(@NonNull View itemview){
            super(itemview);
            t1 = itemview.findViewById(R.id.textView8);
            I1 = itemview.findViewById(R.id.imageView3);
        }
    }
}
