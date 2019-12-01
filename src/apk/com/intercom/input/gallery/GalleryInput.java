package com.intercom.input.gallery;

import com.intercom.composer.Creator;
import com.intercom.composer.input.IconProvider;
import com.intercom.composer.input.Input;

public class GalleryInput extends Input<GalleryInputFragment> {
    private final Creator<GalleryInputFragment> fragmentCreator;
    private final GalleryInputExpandedListener galleryInputExpandedListener;
    private final GalleryOutputListener galleryOutputListener;

    public GalleryInput(String str, IconProvider iconProvider, GalleryOutputListener galleryOutputListener2, GalleryInputExpandedListener galleryInputExpandedListener2, Creator<GalleryInputFragment> creator) {
        super(str, iconProvider);
        this.galleryOutputListener = galleryOutputListener2;
        this.galleryInputExpandedListener = galleryInputExpandedListener2;
        this.fragmentCreator = creator;
    }

    public GalleryInputFragment createFragment() {
        GalleryInputFragment galleryInputFragment = (GalleryInputFragment) this.fragmentCreator.create();
        galleryInputFragment.setArguments(GalleryInputFragment.createArguments(false));
        galleryInputFragment.setGalleryListener(this.galleryOutputListener);
        galleryInputFragment.setGalleryExpandedListener(this.galleryInputExpandedListener);
        return galleryInputFragment;
    }
}
