package io.intercom.android.sdk.blocks.views;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.blocks.StyleType;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.utilities.BackgroundUtils;
import io.intercom.android.sdk.utilities.BlockUtils;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.com.bumptech.glide.f.a.h;
import io.intercom.com.bumptech.glide.f.f;
import io.intercom.com.bumptech.glide.f.g;
import io.intercom.com.bumptech.glide.k;
import io.intercom.com.bumptech.glide.load.a;
import io.intercom.com.bumptech.glide.load.c.c.c;
import io.intercom.com.bumptech.glide.load.engine.GlideException;
import io.intercom.com.bumptech.glide.n;
import io.intercom.com.bumptech.glide.o;

public class VideoPreviewView extends RelativeLayout {
    private static final int PLAY_ARROW_OFFSET_DP = 3;
    private static final int PLAY_BUTTON_DIAMETER_DP = 48;
    /* access modifiers changed from: private */
    public final ProgressBar loadingSpinner = getLoadingSpinner();
    /* access modifiers changed from: private */
    public final ImageView playButton;
    /* access modifiers changed from: private */
    public final ImageView thumbnailImageView;

    public VideoPreviewView(Context context, Provider<AppConfig> provider, StyleType styleType) {
        super(context);
        BlockUtils.createLayoutParams(this, -2, -2);
        BlockUtils.setDefaultMarginBottom(this);
        this.thumbnailImageView = getVideoImageView(context);
        this.playButton = getPlayButtonView(context);
        addView(this.thumbnailImageView);
        addView(this.playButton);
        addView(this.loadingSpinner);
        int primaryColor = ((AppConfig) provider.get()).getPrimaryColor();
        if (styleType == StyleType.POST) {
            primaryColor = ColorUtils.lightenColor(primaryColor);
        }
        this.playButton.setColorFilter(primaryColor, Mode.SRC_ATOP);
    }

    private ProgressBar getLoadingSpinner() {
        return (ProgressBar) RelativeLayout.inflate(getContext(), R.layout.intercom_progress_bar, null).findViewById(R.id.progressBar);
    }

    private ImageView getPlayButtonView(Context context) {
        int dpToPx = ScreenUtils.dpToPx(48.0f, context);
        LayoutParams layoutParams = new LayoutParams(dpToPx, dpToPx);
        layoutParams.addRule(13);
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ScaleType.CENTER);
        imageView.setImageResource(R.drawable.intercom_play_arrow);
        imageView.setPadding(ScreenUtils.dpToPx(3.0f, context), 0, 0, 0);
        imageView.setBackgroundResource(R.drawable.intercom_solid_circle);
        imageView.setVisibility(8);
        imageView.setId(R.id.intercom_video_thumbnail_play_button);
        return imageView;
    }

    private ImageView getVideoImageView(Context context) {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams);
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ScaleType.CENTER_CROP);
        imageView.setId(R.id.intercom_video_thumbnail);
        return imageView;
    }

    /* access modifiers changed from: private */
    public void updateThumbnailAspectRatio() {
        this.thumbnailImageView.getLayoutParams().height = (this.thumbnailImageView.getWidth() * 3) / 4;
    }

    public void displayThumbnail(String str, n nVar) {
        this.loadingSpinner.setVisibility(0);
        this.thumbnailImageView.setVisibility(4);
        k a2 = nVar.a(str);
        a2.a(new g().b(R.drawable.intercom_video_thumbnail_fallback).a(R.drawable.intercom_video_thumbnail_fallback));
        a2.a((o<?, ? super TranscodeType>) c.c());
        a2.a((f<TranscodeType>) new f<Drawable>() {
            public boolean onLoadFailed(GlideException glideException, Object obj, h<Drawable> hVar, boolean z) {
                VideoPreviewView.this.loadingSpinner.setVisibility(8);
                VideoPreviewView.this.thumbnailImageView.setVisibility(0);
                VideoPreviewView.this.updateThumbnailAspectRatio();
                VideoPreviewView.this.playButton.setVisibility(8);
                return false;
            }

            public boolean onResourceReady(Drawable drawable, Object obj, h<Drawable> hVar, a aVar, boolean z) {
                VideoPreviewView.this.loadingSpinner.setVisibility(8);
                VideoPreviewView.this.thumbnailImageView.setVisibility(0);
                VideoPreviewView.this.updateThumbnailAspectRatio();
                VideoPreviewView.this.thumbnailImageView.setColorFilter(b.g.a.a.a(VideoPreviewView.this.thumbnailImageView.getContext(), R.color.intercom_semi_transparent), Mode.DARKEN);
                VideoPreviewView.this.playButton.setVisibility(0);
                return false;
            }
        });
        a2.a(this.thumbnailImageView);
    }

    public ImageView getThumbnailImageView() {
        return this.thumbnailImageView;
    }

    public void showFailedImage() {
        this.thumbnailImageView.post(new Runnable() {
            public void run() {
                BackgroundUtils.setBackground(VideoPreviewView.this.thumbnailImageView, b.g.a.a.c(VideoPreviewView.this.getContext(), R.drawable.intercom_video_thumbnail_fallback));
            }
        });
    }
}
