package com.example.android.finalexam.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.finalexam.R;
import com.example.android.finalexam.model.Images;
import com.example.android.finalexam.model.Message;
import com.example.android.finalexam.views.PuppyViewHolder;

import java.util.List;

import static com.example.android.finalexam.R.id.item_view_layout;

/**
 * Created by TatianaM on 2/25/18.
 */

public class PuppyAdapter extends RecyclerView.Adapter<PuppyViewHolder> {
    List<Images> imagesList;

    public PuppyAdapter(List<Images> imagesList) {
        this.imagesList = imagesList;
    }

    @Override
    public PuppyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new PuppyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(PuppyViewHolder holder, int position) {
        Images message = imagesList.get(position);


        holder.onBind(message.getMessage().toString());
    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }
}
