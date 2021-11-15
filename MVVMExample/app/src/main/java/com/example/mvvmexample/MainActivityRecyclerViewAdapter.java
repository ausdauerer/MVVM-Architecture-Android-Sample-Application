package com.example.mvvmexample;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivityRecyclerViewAdapter extends RecyclerView.Adapter<MainActivityRecyclerViewAdapter.ViewHolder>{

    ArrayList<String> dataList;
    Context context;

    public MainActivityRecyclerViewAdapter(Context context,ArrayList<String> dataList){
        this.context=context;
        this.dataList=dataList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public ViewHolder(View view){
            super(view);
            textView=view.findViewById(R.id.recycler_text_view);
        }

        public TextView getTextView(){
            return(textView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_activity_recycler_view_layout, parent, false);
        return (new ViewHolder(view));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        String data = dataList.get(position);
        TextView txtView = viewHolder.getTextView();
        txtView.setText(data);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void dataClear() {
        dataList.clear();
        notifyDataSetChanged();
    }

    public void dataAdd(ArrayList<String> list) {
        dataList.addAll(list);
        notifyDataSetChanged();
    }
}
