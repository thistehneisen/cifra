package com.intercom.input.gallery.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView.x;
import com.intercom.input.gallery.R;

class ImageViewHolder extends x {
    private final ImageView imageView;

    ImageViewHolder(View view, final OnImageClickListener onImageClickListener) {
        super(view);
        this.imageView = (ImageView) view.findViewById(R.id.thumbnail);
        view.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                onImageClickListener.onImageClicked(ImageViewHolder.this);
            }
        });
    }

    public ImageView getImageView() {
        return this.imageView;
    }
}
