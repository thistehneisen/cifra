package com.intercom.input.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.intercom.composer.ImageLoader;

public abstract class GalleryLightBoxFragment extends Fragment implements OnClickListener {
    GalleryImage galleryImage;
    private ImageLoader imageLoader;

    public interface Injector {
        ImageLoader getImageLoader(GalleryLightBoxFragment galleryLightBoxFragment);
    }

    public static Bundle createArgs(GalleryImage galleryImage2) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(GalleryInputFullScreenActivity.GALLERY_IMAGE, galleryImage2);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public abstract Injector getInjector(GalleryLightBoxFragment galleryLightBoxFragment);

    public void onClick(View view) {
        if (view.getId() == R.id.lightbox_send_button) {
            Intent intent = new Intent();
            intent.putExtra(GalleryInputFullScreenActivity.GALLERY_IMAGE, this.galleryImage);
            getActivity().setResult(-1, intent);
        }
        getActivity().onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.galleryImage = (GalleryImage) getArguments().getParcelable(GalleryInputFullScreenActivity.GALLERY_IMAGE);
        this.imageLoader = getInjector(this).getImageLoader(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.intercom_composer_gallery_lightbox_fragment, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.imageLoader.loadImageIntoView(this.galleryImage, (ImageView) view.findViewById(R.id.lightbox_image));
        view.findViewById(R.id.lightbox_send_button).setOnClickListener(this);
        view.findViewById(R.id.lightbox_close_button).setOnClickListener(this);
    }
}
