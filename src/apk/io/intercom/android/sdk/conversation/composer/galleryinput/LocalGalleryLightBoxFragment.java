package io.intercom.android.sdk.conversation.composer.galleryinput;

import androidx.fragment.app.Fragment;
import com.intercom.composer.ImageLoader;
import com.intercom.input.gallery.GalleryLightBoxFragment;
import com.intercom.input.gallery.GalleryLightBoxFragment.Injector;
import io.intercom.com.bumptech.glide.c;
import io.intercom.com.bumptech.glide.load.engine.q;

public class LocalGalleryLightBoxFragment extends GalleryLightBoxFragment {
    /* access modifiers changed from: protected */
    public Injector getInjector(GalleryLightBoxFragment galleryLightBoxFragment) {
        return new Injector() {
            public ImageLoader getImageLoader(GalleryLightBoxFragment galleryLightBoxFragment) {
                return GalleryImageLoader.create(q.f9933b, null, c.a((Fragment) galleryLightBoxFragment));
            }
        };
    }
}
