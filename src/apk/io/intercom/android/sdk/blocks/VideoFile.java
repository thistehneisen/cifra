package io.intercom.android.sdk.blocks;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.activities.IntercomVideoActivity;
import io.intercom.android.sdk.blocks.blockInterfaces.VideoFileBlock;
import io.intercom.android.sdk.blocks.views.ParagraphView;
import io.intercom.android.sdk.blocks.views.VideoPreviewView;
import io.intercom.android.sdk.commons.utilities.HtmlCompat;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.com.bumptech.glide.n;

public class VideoFile implements VideoFileBlock {
    private final Provider<AppConfig> appConfigProvider;
    /* access modifiers changed from: private */
    public final MetricTracker metricTracker;
    private final n requestManager;
    private final StyleType style;

    VideoFile(StyleType styleType, Provider<AppConfig> provider, n nVar, MetricTracker metricTracker2) {
        this.style = styleType;
        this.appConfigProvider = provider;
        this.requestManager = nVar;
        this.metricTracker = metricTracker2;
    }

    private void addClickListenerOnThumbnailView(final ImageView imageView, final String str) {
        if (this.style != StyleType.CHAT_FULL) {
            imageView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    VideoFile.this.metricTracker.startedToPlayVideo();
                    Context context = imageView.getContext();
                    if (VERSION.SDK_INT >= 19) {
                        context.startActivity(IntercomVideoActivity.buildIntent(context, str));
                        return;
                    }
                    context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                }
            });
        }
    }

    private View textFallback(String str, ViewGroup viewGroup) {
        ParagraphView paragraphView = new ParagraphView(viewGroup.getContext(), StyleType.ADMIN, BlockAlignment.LEFT, (AppConfig) this.appConfigProvider.get());
        paragraphView.setText(HtmlCompat.fromHtml(str));
        return paragraphView;
    }

    public View addVideoFile(String str, String str2, String str3, boolean z, boolean z2, ViewGroup viewGroup) {
        if (TextUtils.isEmpty(str2)) {
            return textFallback(str, viewGroup);
        }
        VideoPreviewView videoPreviewView = new VideoPreviewView(viewGroup.getContext(), this.appConfigProvider, this.style);
        ImageView thumbnailImageView = videoPreviewView.getThumbnailImageView();
        videoPreviewView.displayThumbnail(str3, this.requestManager);
        addClickListenerOnThumbnailView(thumbnailImageView, str2);
        return videoPreviewView;
    }
}
