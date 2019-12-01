package com.intercom.input.gallery.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.a;
import com.intercom.composer.ImageLoader;
import com.intercom.input.gallery.GalleryImage;
import com.intercom.input.gallery.R;
import java.util.List;

public class GalleryRecyclerViewAdapter extends a<ImageViewHolder> {
    private final boolean expanded;
    private final List<GalleryImage> galleryImages;
    private final ImageLoader imageLoader;
    private final LayoutInflater layoutInflater;
    private final OnImageClickListener onImageClickListener;

    public GalleryRecyclerViewAdapter(LayoutInflater layoutInflater2, List<GalleryImage> list, boolean z, OnImageClickListener onImageClickListener2, ImageLoader imageLoader2) {
        this.layoutInflater = layoutInflater2;
        this.galleryImages = list;
        this.expanded = z;
        this.onImageClickListener = onImageClickListener2;
        this.imageLoader = imageLoader2;
    }

    public GalleryImage getItem(int i2) {
        return (GalleryImage) this.galleryImages.get(i2);
    }

    public int getItemCount() {
        return this.galleryImages.size();
    }

    public void onBindViewHolder(ImageViewHolder imageViewHolder, int i2) {
        this.imageLoader.loadImageIntoView((GalleryImage) this.galleryImages.get(i2), imageViewHolder.getImageView());
    }

    public ImageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ImageViewHolder(this.layoutInflater.inflate(this.expanded ? R.layout.intercom_composer_expanded_image_list_item : R.layout.intercom_composer_image_list_item, viewGroup, false), this.onImageClickListener);
    }

    public void onViewRecycled(ImageViewHolder imageViewHolder) {
        super.onViewRecycled(imageViewHolder);
        this.imageLoader.clear(imageViewHolder.getImageView());
    }
}
