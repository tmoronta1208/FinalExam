package com.example.android.finalexam.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.android.finalexam.R;
import com.example.android.finalexam.model.Message;
import com.squareup.picasso.Picasso;

/**
 * Created by TatianaM on 2/25/18.
 */

public class PuppyViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;


    public PuppyViewHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image_view_puppies);
    }

    public void onBind(Message message) {

        String images = message.getUrl();
        Picasso.with(itemView.getContext()).load(images).fit().into(imageView);


    }
}
