package io.intercom.android.sdk.conversation.composer.galleryinput;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import b.g.a.a;
import com.intercom.composer.ImageLoader;
import com.intercom.input.gallery.GalleryImage;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.android.sdk.utilities.ImageUtils;
import io.intercom.com.bumptech.glide.f.a.h;
import io.intercom.com.bumptech.glide.f.f;
import io.intercom.com.bumptech.glide.f.g;
import io.intercom.com.bumptech.glide.k;
import io.intercom.com.bumptech.glide.load.b;
import io.intercom.com.bumptech.glide.load.c.a.e;
import io.intercom.com.bumptech.glide.load.c.c.c;
import io.intercom.com.bumptech.glide.load.engine.GlideException;
import io.intercom.com.bumptech.glide.load.engine.q;
import io.intercom.com.bumptech.glide.load.m;
import io.intercom.com.bumptech.glide.n;
import io.intercom.com.bumptech.glide.o;

class GalleryImageLoader implements ImageLoader {
    private static final float GIF_SIZE_MULTIPLIER = 0.5f;
    private final q diskCacheStrategy;
    private final n requestManager;
    private final e transformation;

    GalleryImageLoader(q qVar, e eVar, n nVar) {
        this.diskCacheStrategy = qVar;
        this.transformation = eVar;
        this.requestManager = nVar;
    }

    static GalleryImageLoader create(q qVar, e eVar, n nVar) {
        return new GalleryImageLoader(qVar, eVar, nVar);
    }

    private Bitmap getBitmapFromDrawable(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void logErrorMessageForUrl(Exception exc, String str) {
        Twig logger = LumberMill.getLogger();
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to load image for URL: ");
        sb.append(str);
        sb.append(" - ");
        String sb2 = sb.toString();
        if (exc == null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append("no error message, data probably failed to decode");
            logger.e(sb3.toString(), new Object[0]);
            return;
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(sb2);
        sb4.append(exc.getMessage());
        logger.e(sb4.toString(), new Object[0]);
    }

    public void clear(ImageView imageView) {
        this.requestManager.a((View) imageView);
    }

    public Bitmap getBitmapFromView(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        if (!(drawable instanceof TransitionDrawable)) {
            return getBitmapFromDrawable(drawable);
        }
        TransitionDrawable transitionDrawable = (TransitionDrawable) drawable;
        for (int numberOfLayers = transitionDrawable.getNumberOfLayers() - 1; numberOfLayers >= 0; numberOfLayers--) {
            Bitmap bitmapFromDrawable = getBitmapFromDrawable(transitionDrawable.getDrawable(numberOfLayers));
            if (bitmapFromDrawable != null) {
                return bitmapFromDrawable;
            }
        }
        return null;
    }

    public void loadImageIntoView(GalleryImage galleryImage, ImageView imageView) {
        final String path = TextUtils.isEmpty(galleryImage.getPreviewPath()) ? galleryImage.getPath() : galleryImage.getPreviewPath();
        g b2 = new g().a(this.diskCacheStrategy).b((Drawable) new ColorDrawable(a.a(imageView.getContext(), R.color.intercom_search_bg_grey)));
        e eVar = this.transformation;
        if (eVar != null) {
            b2 = b2.a((m<Bitmap>) eVar);
        }
        k a2 = this.requestManager.a(path);
        if (ImageUtils.isGif(path)) {
            b2 = b2.a((float) GIF_SIZE_MULTIPLIER).a(b.PREFER_RGB_565);
        }
        a2.a(b2);
        a2.a((o<?, ? super TranscodeType>) c.c());
        a2.a((f<TranscodeType>) new f<Drawable>() {
            public boolean onLoadFailed(GlideException glideException, Object obj, h<Drawable> hVar, boolean z) {
                GalleryImageLoader.this.logErrorMessageForUrl(glideException, path);
                return false;
            }

            public boolean onResourceReady(Drawable drawable, Object obj, h<Drawable> hVar, io.intercom.com.bumptech.glide.load.a aVar, boolean z) {
                return false;
            }
        });
        a2.a(imageView);
    }
}
