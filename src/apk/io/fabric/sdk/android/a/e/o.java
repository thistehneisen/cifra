package io.fabric.sdk.android.a.e;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import io.fabric.sdk.android.a.b.l;
import io.fabric.sdk.android.f;

/* compiled from: IconRequest */
public class o {

    /* renamed from: a reason: collision with root package name */
    public final String f8944a;

    /* renamed from: b reason: collision with root package name */
    public final int f8945b;

    /* renamed from: c reason: collision with root package name */
    public final int f8946c;

    /* renamed from: d reason: collision with root package name */
    public final int f8947d;

    public o(String str, int i2, int i3, int i4) {
        this.f8944a = str;
        this.f8945b = i2;
        this.f8946c = i3;
        this.f8947d = i4;
    }

    public static o a(Context context, String str) {
        String str2 = "Fabric";
        if (str != null) {
            try {
                int d2 = l.d(context);
                io.fabric.sdk.android.o e2 = f.e();
                StringBuilder sb = new StringBuilder();
                sb.append("App icon resource ID is ");
                sb.append(d2);
                e2.d(str2, sb.toString());
                Options options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeResource(context.getResources(), d2, options);
                return new o(str, d2, options.outWidth, options.outHeight);
            } catch (Exception e3) {
                f.e().b(str2, "Failed to load icon", e3);
            }
        }
        return null;
    }
}
