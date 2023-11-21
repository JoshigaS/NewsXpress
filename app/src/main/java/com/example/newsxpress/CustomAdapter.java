package com.example.newsxpress;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsxpress.Models.NewsHeadllines;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private final Context context;
    private final List<NewsHeadllines> headllines;
    private final SelectListener listener;

    public CustomAdapter(Context context, List<NewsHeadllines> headllines,SelectListener listener) {
        this.context = context;
        this.headllines = headllines;
        this.listener=listener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.headline_list_items,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.text_title.setText(headllines.get(position).getTitle());
        holder.text_source.setText(headllines.get(position).getSource().getName());
        if (headllines.get(position).getUrlToImage()!=null){
            Picasso.get().load(headllines.get(position).getUrlToImage()).into(holder.img_headline);
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnNewsClicked(headllines.get(position));
            }
        });


    }

    @Override
    public int getItemCount() {
        return headllines.size();
    }
}
