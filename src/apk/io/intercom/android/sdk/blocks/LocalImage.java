package io.intercom.android.sdk.blocks;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.blocks.blockInterfaces.LocalImageBlock;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.transforms.RoundedCornersTransform;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.android.sdk.utilities.BlockUtils;
import io.intercom.android.sdk.utilities.ImageUtils;
import io.intercom.android.sdk.views.ProgressFrameLayout;
import io.intercom.android.sdk.views.ResizableImageView;
import io.intercom.android.sdk.views.UploadProgressBar;
import io.intercom.com.bumptech.glide.f.a.h;
import io.intercom.com.bumptech.glide.f.f;
import io.intercom.com.bumptech.glide.f.g;
import io.intercom.com.bumptech.glide.k;
import io.intercom.com.bumptech.glide.load.a;
import io.intercom.com.bumptech.glide.load.c.c.c;
import io.intercom.com.bumptech.glide.load.engine.GlideException;
import io.intercom.com.bumptech.glide.load.m;
import io.intercom.com.bumptech.glide.n;
import io.intercom.com.bumptech.glide.o;

class LocalImage extends Image implements LocalImageBlock {
    private final n requestManager;
    /* access modifiers changed from: private */
    public final Twig twig = LumberMill.getLogger();

    LocalImage(StyleType styleType, n nVar) {
        super(styleType);
        this.requestManager = nVar;
    }

    public View addImage(String str, int i2, int i3, BlockAlignment blockAlignment, boolean z, boolean z2, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        int dpToPx = ScreenUtils.dpToPx((float) i2, context);
        int dpToPx2 = ScreenUtils.dpToPx((float) i3, context);
        ProgressFrameLayout progressFrameLayout = new ProgressFrameLayout(context);
        BlockUtils.createLayoutParams(progressFrameLayout, -2, -2);
        BlockUtils.setDefaultMarginBottom(progressFrameLayout);
        final ResizableImageView resizableImageView = new ResizableImageView(context);
        BlockUtils.createLayoutParams(resizableImageView, -2, -2);
        resizableImageView.setAdjustViewBounds(true);
        resizableImageView.setScaleType(ScaleType.FIT_START);
        progressFrameLayout.addView(resizableImageView);
        k a2 = this.requestManager.a(str);
        setImageViewBounds(dpToPx, dpToPx2, resizableImageView, a2);
        View childAt = progressFrameLayout.getChildAt(0);
        Resources resources = context.getResources();
        if (childAt instanceof UploadProgressBar) {
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.intercom_local_image_upload_size);
            childAt.setLayoutParams(new LayoutParams(dimensionPixelSize, dimensionPixelSize, 17));
            childAt.bringToFront();
            progressFrameLayout.uploadStarted();
        }
        setBackground(resizableImageView);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        resizableImageView.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        a2.a(new g().a((m<Bitmap>) new RoundedCornersTransform<Bitmap>(resources.getDimensionPixelSize(R.dimen.intercom_image_rounded_corners))).a(ImageUtils.getDiskCacheStrategy(str)));
        a2.a((o<?, ? super TranscodeType>) c.c());
        a2.a((f<TranscodeType>) new f<Drawable>() {
            public boolean onLoadFailed(GlideException glideException, Object obj, h<Drawable> hVar, boolean z) {
                LocalImage.this.twig.internal("images", "FAILURE");
                return false;
            }

            public boolean onResourceReady(Drawable drawable, Object obj, h<Drawable> hVar, a aVar, boolean z) {
                LocalImage.this.twig.internal("images", "SUCCESS");
                resizableImageView.setBackgroundResource(17170445);
                return false;
            }
        });
        a2.a((ImageView) resizableImageView);
        BlockUtils.setLayoutMarginsAndGravity(progressFrameLayout, blockAlignment.getGravity(), z2);
        return progressFrameLayout;
    }
}
