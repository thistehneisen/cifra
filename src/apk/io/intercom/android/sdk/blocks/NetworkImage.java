package io.intercom.android.sdk.blocks;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.blocks.blockInterfaces.ImageBlock;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.lightbox.LightBoxActivity;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.transforms.RoundedCornersTransform;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.android.sdk.utilities.BlockUtils;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.android.sdk.utilities.ImageUtils;
import io.intercom.android.sdk.views.ResizableImageView;
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

class NetworkImage extends Image implements ImageBlock {
    private static final int PROGRESSBAR_DIAMETER_DP = 40;
    /* access modifiers changed from: private */
    public final ImageClickListener listener;
    private final n requestManager;
    /* access modifiers changed from: private */
    public final Twig twig = LumberMill.getLogger();
    private final UploadingImageCache uploadingImageCache;

    NetworkImage(StyleType styleType, UploadingImageCache uploadingImageCache2, ImageClickListener imageClickListener, n nVar) {
        super(styleType);
        this.uploadingImageCache = uploadingImageCache2;
        this.listener = imageClickListener;
        this.requestManager = nVar;
    }

    private void loadImageFromUrl(String str, String str2, Context context, int i2, int i3, ResizableImageView resizableImageView, ProgressBar progressBar) {
        String str3 = str;
        int i4 = i2;
        int i5 = i3;
        ResizableImageView resizableImageView2 = resizableImageView;
        if (TextUtils.isEmpty(str)) {
            hideLoadingState(progressBar, resizableImageView2);
            resizableImageView2.setImageResource(R.drawable.intercom_error);
            return;
        }
        ProgressBar progressBar2 = progressBar;
        k a2 = this.requestManager.a(str);
        setImageViewBounds(i4, i5, resizableImageView2, a2);
        String localImagePathForRemoteUrl = this.uploadingImageCache.getLocalImagePathForRemoteUrl(str);
        Resources resources = context.getResources();
        g a3 = new g().a((m<Bitmap>) new RoundedCornersTransform<Bitmap>(resources.getDimensionPixelSize(R.dimen.intercom_image_rounded_corners))).a(R.drawable.intercom_error).a(ImageUtils.getDiskCacheStrategy(str));
        if (!TextUtils.isEmpty(localImagePathForRemoteUrl)) {
            Options options = new Options();
            options.inSampleSize = getSampleSize(i4, i5, resources.getDisplayMetrics());
            BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, BitmapFactory.decodeFile(localImagePathForRemoteUrl, options));
            bitmapDrawable.setColorFilter(ColorUtils.newGreyscaleFilter());
            a3 = a3.b((Drawable) bitmapDrawable).b();
        }
        a2.a(a3);
        a2.a((o<?, ? super TranscodeType>) c.c());
        final ProgressBar progressBar3 = progressBar;
        final ResizableImageView resizableImageView3 = resizableImageView;
        final Context context2 = context;
        final String str4 = str;
        final String str5 = str2;
        final int i6 = i2;
        final int i7 = i3;
        AnonymousClass1 r0 = new f<Drawable>() {
            public boolean onLoadFailed(GlideException glideException, Object obj, h<Drawable> hVar, boolean z) {
                NetworkImage.this.hideLoadingState(progressBar3, resizableImageView3);
                NetworkImage.this.twig.internal("images", "FAILURE");
                return false;
            }

            public boolean onResourceReady(Drawable drawable, Object obj, h<Drawable> hVar, a aVar, boolean z) {
                NetworkImage.this.twig.internal("images", "SUCCESS");
                NetworkImage.this.hideLoadingState(progressBar3, resizableImageView3);
                if (NetworkImage.this.getStyle() != StyleType.CHAT_FULL) {
                    resizableImageView3.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            ((InputMethodManager) context2.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                            ImageClickListener access$100 = NetworkImage.this.listener;
                            AnonymousClass1 r7 = AnonymousClass1.this;
                            access$100.onImageClicked(str4, str5, resizableImageView3, i6, i7);
                        }
                    });
                }
                return false;
            }
        };
        a2.a((f<TranscodeType>) r0);
        a2.a((ImageView) resizableImageView2);
    }

    public View addImage(String str, String str2, int i2, int i3, BlockAlignment blockAlignment, boolean z, boolean z2, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        int dpToPx = ScreenUtils.dpToPx((float) i2, context);
        int dpToPx2 = ScreenUtils.dpToPx((float) i3, context);
        FrameLayout frameLayout = new FrameLayout(context);
        BlockUtils.createLayoutParams(frameLayout, -2, -2);
        BlockUtils.setDefaultMarginBottom(frameLayout);
        ResizableImageView resizableImageView = new ResizableImageView(context);
        if (VERSION.SDK_INT >= 21) {
            resizableImageView.setTransitionName(LightBoxActivity.TRANSITION_KEY);
        }
        resizableImageView.setLayoutParams(new LayoutParams(-2, -2));
        resizableImageView.setAdjustViewBounds(true);
        resizableImageView.setScaleType(ScaleType.FIT_START);
        setBackground(resizableImageView);
        ProgressBar progressBar = new ProgressBar(context);
        int dpToPx3 = ScreenUtils.dpToPx(40.0f, context);
        progressBar.setLayoutParams(new LayoutParams(dpToPx3, dpToPx3, 17));
        progressBar.setIndeterminateDrawable(b.g.a.a.c(context, R.drawable.intercom_progress_wheel));
        progressBar.setIndeterminate(true);
        frameLayout.addView(resizableImageView);
        frameLayout.addView(progressBar);
        loadImageFromUrl(str, str2, context, dpToPx, dpToPx2, resizableImageView, progressBar);
        BlockUtils.setLayoutMarginsAndGravity(frameLayout, blockAlignment.getGravity(), z2);
        return frameLayout;
    }

    /* access modifiers changed from: 0000 */
    public int getSampleSize(int i2, int i3, DisplayMetrics displayMetrics) {
        if (i2 > displayMetrics.widthPixels || i3 > displayMetrics.heightPixels) {
            return (int) Math.pow(2.0d, (double) ((int) Math.ceil(Math.log(((double) displayMetrics.widthPixels) / ((double) Math.max(i3, i2))) / Math.log(0.5d))));
        }
        return 1;
    }

    /* access modifiers changed from: 0000 */
    public void hideLoadingState(ProgressBar progressBar, ImageView imageView) {
        if (progressBar != null) {
            progressBar.setVisibility(8);
            imageView.setBackgroundResource(17170445);
        }
    }
}
