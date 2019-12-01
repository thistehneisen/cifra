package io.intercom.android.sdk.blocks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.core.app.d;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.lightbox.LightBoxActivity;
import io.intercom.android.sdk.utilities.LinkOpener;

public class LightboxOpeningImageClickListener implements ImageClickListener {
    private final Api api;

    public LightboxOpeningImageClickListener(Api api2) {
        this.api = api2;
    }

    public void onImageClicked(String str, String str2, ImageView imageView, int i2, int i3) {
        Context context = imageView.getContext();
        if (!TextUtils.isEmpty(str2)) {
            LinkOpener.handleUrl(str2, context, this.api);
            return;
        }
        boolean z = false;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if ((activity.getWindow().getAttributes().flags & 1024) != 0) {
                z = true;
            }
            Intent imageIntent = LightBoxActivity.imageIntent(activity, str, z);
            if (VERSION.SDK_INT >= 16) {
                activity.startActivity(imageIntent, d.a(activity, (View) imageView, LightBoxActivity.TRANSITION_KEY).a());
            } else {
                activity.startActivity(imageIntent);
            }
        } else {
            context.startActivity(LightBoxActivity.imageIntent(context, str, false));
        }
    }
}
