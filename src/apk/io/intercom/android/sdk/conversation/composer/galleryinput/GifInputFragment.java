package io.intercom.android.sdk.conversation.composer.galleryinput;

import androidx.fragment.app.Fragment;
import com.intercom.input.gallery.GalleryInputFragment;
import com.intercom.input.gallery.GalleryInputFragment.Injector;
import io.intercom.com.bumptech.glide.c;

public class GifInputFragment extends GalleryInputFragment {
    /* access modifiers changed from: protected */
    public Injector getInjector(GalleryInputFragment galleryInputFragment) {
        return new GifInputInjector(c.a((Fragment) this));
    }
}
