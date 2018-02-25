package com.example.android.finalexam.views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.android.finalexam.R;
import com.example.android.finalexam.activities.DogsActivity;
import com.example.android.finalexam.activities.PhotoActivity;
import com.example.android.finalexam.model.Message;
import com.squareup.picasso.Picasso;

/**
 * Created by TatianaM on 2/25/18.
 */

public class PuppyViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    Context context;


    public PuppyViewHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image_view_puppies);
        context = imageView.getContext();
    }

    public void onBind(final String message) {

        Picasso.with(itemView.getContext()).load(message).fit().into(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PhotoActivity.class);
                intent.putExtra("url", message);
                context.startActivity(intent);

            }
        });



    }
}
