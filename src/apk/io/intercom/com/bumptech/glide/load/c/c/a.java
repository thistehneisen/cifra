package io.intercom.com.bumptech.glide.load.c.c;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import b.g.a.a.h;

/* compiled from: DrawableDecoderCompat */
public final class a {

    /* renamed from: a reason: collision with root package name */
    private static volatile boolean f9653a = true;

    public static Drawable a(Context context, int i2) {
        return a(context, i2, null);
    }

    private static Drawable b(Context context, int i2) {
        return b.a.a.a.a.b(context, i2);
    }

    public static Drawable a(Context context, int i2, Theme theme) {
        try {
            if (f9653a) {
                return b(context, i2);
            }
        } catch (NoClassDefFoundError unused) {
            f9653a = false;
        } catch (NotFoundException unused2) {
        }
        if (theme == null) {
            theme = context.getTheme();
        }
        return b(context, i2, theme);
    }

    private static Drawable b(Context context, int i2, Theme theme) {
        return h.a(context.getResources(), i2, theme);
    }
}
