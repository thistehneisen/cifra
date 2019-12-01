package io.intercom.android.sdk.conversation.composer.galleryinput;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.appcompat.widget.Toolbar;
import com.intercom.composer.ImageLoader;
import com.intercom.input.gallery.GalleryInputDataSource;
import com.intercom.input.gallery.GalleryInputFragment;
import com.intercom.input.gallery.GalleryInputFragment.Injector;
import com.intercom.input.gallery.GalleryLightBoxFragment;
import com.intercom.input.gallery.LocalImagesDataSource;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.com.bumptech.glide.load.engine.q;
import io.intercom.com.bumptech.glide.n;

class LocalGalleryInputInjector implements Injector {
    private final n requestManager;

    public LocalGalleryInputInjector(n nVar) {
        this.requestManager = nVar;
    }

    public GalleryInputDataSource getDataSource(GalleryInputFragment galleryInputFragment) {
        return LocalImagesDataSource.create(galleryInputFragment);
    }

    public String getEmptyViewSubtitle(Resources resources) {
        return resources.getString(R.string.intercom_no_photos_on_device);
    }

    public String getEmptyViewTitle(Resources resources) {
        return resources.getString(R.string.intercom_no_photos);
    }

    public String getErrorViewSubtitle(Resources resources) {
        return null;
    }

    public String getErrorViewTitle(Resources resources) {
        return null;
    }

    public View getExpanderButton(ViewGroup viewGroup) {
        ImageButton imageButton = (ImageButton) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.intercom_expander_button, viewGroup, false);
        imageButton.setColorFilter(getThemeColor(imageButton.getContext()));
        return imageButton;
    }

    public ImageLoader getImageLoader(GalleryInputFragment galleryInputFragment) {
        return GalleryImageLoader.create(q.f9933b, DownscaleOnlyCenterCrop.INSTANCE, this.requestManager);
    }

    public Class<? extends GalleryLightBoxFragment> getLightBoxFragmentClass(GalleryInputFragment galleryInputFragment) {
        return LocalGalleryLightBoxFragment.class;
    }

    public View getSearchView(ViewGroup viewGroup) {
        return null;
    }

    public int getThemeColor(Context context) {
        return ColorUtils.primaryOrDarkColor(context, (AppConfig) io.intercom.android.sdk.Injector.get().getAppConfigProvider().get());
    }

    public Toolbar getToolbar(ViewGroup viewGroup) {
        return (Toolbar) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.intercom_gallery_input_toolbar, viewGroup, false);
    }
}
