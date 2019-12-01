package androidx.core.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;

/* compiled from: ActivityOptionsCompat */
public class d {

    /* compiled from: ActivityOptionsCompat */
    private static class a extends d {

        /* renamed from: a reason: collision with root package name */
        private final ActivityOptions f1255a;

        a(ActivityOptions activityOptions) {
            this.f1255a = activityOptions;
        }

        public Bundle a() {
            return this.f1255a.toBundle();
        }
    }

    protected d() {
    }

    public static d a(Context context, int i2, int i3) {
        if (VERSION.SDK_INT >= 16) {
            return new a(ActivityOptions.makeCustomAnimation(context, i2, i3));
        }
        return new d();
    }

    public Bundle a() {
        return null;
    }

    public static d a(Activity activity, View view, String str) {
        if (VERSION.SDK_INT >= 21) {
            return new a(ActivityOptions.makeSceneTransitionAnimation(activity, view, str));
        }
        return new d();
    }
}
