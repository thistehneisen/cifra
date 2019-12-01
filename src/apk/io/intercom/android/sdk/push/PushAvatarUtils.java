package io.intercom.android.sdk.push;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.utilities.AvatarUtils;
import io.intercom.android.sdk.utilities.NameUtils;

class PushAvatarUtils {
    private static final int LARGE_ICON_SIZE_DP = 48;

    PushAvatarUtils() {
    }

    private static Bitmap drawableToBitmap(Context context, Drawable drawable) {
        Bitmap bitmap;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            int dpToPx = ScreenUtils.dpToPx(48.0f, context);
            bitmap = Bitmap.createBitmap(dpToPx, dpToPx, Config.ARGB_8888);
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    public static Bitmap getNotificationDefaultBitmap(Context context, AppConfig appConfig) {
        return drawableToBitmap(context, AvatarUtils.getDefaultDrawable(context, appConfig));
    }

    public static Bitmap getNotificationInitialsBitmap(Context context, String str, AppConfig appConfig) {
        return drawableToBitmap(context, AvatarUtils.getInitialsDrawable(NameUtils.getInitial(str), appConfig));
    }
}
