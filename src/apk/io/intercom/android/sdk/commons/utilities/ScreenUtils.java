package io.intercom.android.sdk.commons.utilities;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;

public class ScreenUtils {
    @Deprecated
    public static int convertDpToPixel(float f2, Context context) {
        return dpToPx(f2, context);
    }

    @Deprecated
    public static int convertPixelsToDp(float f2, Context context) {
        return pxToDp(f2, context);
    }

    public static int dpToPx(float f2, Context context) {
        return (int) (f2 * context.getResources().getDisplayMetrics().density);
    }

    public static Point getScreenDimensions(Context context) {
        Point point = new Point();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getSize(point);
        return point;
    }

    public static int pxToDp(float f2, Context context) {
        return (int) (f2 / context.getResources().getDisplayMetrics().density);
    }
}
