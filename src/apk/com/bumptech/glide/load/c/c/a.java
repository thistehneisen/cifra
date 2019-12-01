package com.bumptech.glide.load.c.c;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import b.a.d.d;
import b.g.a.a.h;

/* compiled from: DrawableDecoderCompat */
public final class a {

    /* renamed from: a reason: collision with root package name */
    private static volatile boolean f3789a = true;

    public static Drawable a(Context context, Context context2, int i2) {
        return a(context, context2, i2, null);
    }

    private static Drawable b(Context context, int i2, Theme theme) {
        return h.a(context.getResources(), i2, theme);
    }

    private static Drawable c(Context context, int i2, Theme theme) {
        if (theme != null) {
            context = new d(context, theme);
        }
        return b.a.a.a.a.b(context, i2);
    }

    public static Drawable a(Context context, int i2, Theme theme) {
        return a(context, context, i2, theme);
    }

    private static Drawable a(Context context, Context context2, int i2, Theme theme) {
        try {
            if (f3789a) {
                return c(context2, i2, theme);
            }
        } catch (NoClassDefFoundError unused) {
            f3789a = false;
        } catch (IllegalStateException e2) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                return b.g.a.a.c(context2, i2);
            }
            throw e2;
        } catch (NotFoundException unused2) {
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return b(context2, i2, theme);
    }
}
