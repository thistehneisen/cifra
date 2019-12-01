package io.intercom.android.sdk.utilities;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import b.g.a.a;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;

public class ColorUtils {
    private static int darkColorRes() {
        return R.color.intercom_black_50;
    }

    public static int darkenColor(int i2) {
        float[] fArr = new float[3];
        Color.colorToHSV(i2, fArr);
        fArr[2] = fArr[2] * 0.79f;
        return Color.HSVToColor(fArr);
    }

    public static int lightenColor(int i2) {
        return Color.argb(Color.alpha(i2), (Color.red(i2) + 255) / 2, (Color.green(i2) + 255) / 2, (Color.blue(i2) + 255) / 2);
    }

    public static ColorFilter newGreyscaleFilter() {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        return new ColorMatrixColorFilter(colorMatrix);
    }

    private static int primaryOrBlackColor(Context context, AppConfig appConfig) {
        if (appConfig.primaryColorRenderDarkText()) {
            return a.a(context, R.color.intercom_black);
        }
        return appConfig.getPrimaryColor();
    }

    public static int primaryOrDarkColor(Context context, AppConfig appConfig) {
        if (appConfig.primaryColorRenderDarkText()) {
            return a.a(context, darkColorRes());
        }
        return appConfig.getPrimaryColor();
    }

    public static void setImageColorWhiteOrBlack(ImageView imageView, boolean z) {
        imageView.setColorFilter(whiteOrBlackColor(imageView.getContext(), z));
    }

    public static void setImageSrcColorWhiteOrDark(ImageView imageView, boolean z) {
        imageView.getDrawable().setColorFilter(a.a(imageView.getContext(), z ? darkColorRes() : R.color.intercom_white), Mode.SRC_IN);
    }

    public static void setTextColorPrimaryOrBlack(TextView textView, AppConfig appConfig) {
        int primaryOrBlackColor = primaryOrBlackColor(textView.getContext(), appConfig);
        textView.setTextColor(primaryOrBlackColor);
        textView.setLinkTextColor(primaryOrBlackColor);
    }

    public static void setTextColorPrimaryOrDark(TextView textView, AppConfig appConfig) {
        int primaryOrDarkColor = primaryOrDarkColor(textView.getContext(), appConfig);
        textView.setTextColor(primaryOrDarkColor);
        textView.setLinkTextColor(primaryOrDarkColor);
    }

    public static void setTextColorWhiteOrBlack(TextView textView, boolean z) {
        int whiteOrBlackColor = whiteOrBlackColor(textView.getContext(), z);
        textView.setTextColor(whiteOrBlackColor);
        textView.setLinkTextColor(whiteOrBlackColor);
    }

    public static void setTextColorWhiteOrDark(TextView textView, boolean z) {
        int whiteOrDarkColor = whiteOrDarkColor(textView.getContext(), z);
        textView.setTextColor(whiteOrDarkColor);
        textView.setLinkTextColor(whiteOrDarkColor);
    }

    public static void updateInnerBorderColor(AppConfig appConfig, View view) {
        int primaryColor = appConfig.getPrimaryColor();
        LayerDrawable layerDrawable = (LayerDrawable) a.c(view.getContext(), R.drawable.intercom_conversation_card_with_top_border);
        Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.top_border);
        findDrawableByLayerId.setAlpha(127);
        findDrawableByLayerId.setColorFilter(primaryColor, Mode.SRC_IN);
        BackgroundUtils.setBackground(view, layerDrawable);
    }

    public static int whiteOrBlackColor(Context context, boolean z) {
        return a.a(context, z ? R.color.intercom_black : R.color.intercom_white);
    }

    public static int whiteOrDarkColor(Context context, boolean z) {
        if (z) {
            return a.a(context, darkColorRes());
        }
        return a.a(context, R.color.intercom_white);
    }
}
