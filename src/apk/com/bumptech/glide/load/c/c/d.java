package com.bumptech.glide.load.c.c;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.engine.G;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;
import io.fabric.sdk.android.a.b.C0730a;
import java.util.List;

/* compiled from: ResourceDrawableDecoder */
public class d implements j<Uri, Drawable> {

    /* renamed from: a reason: collision with root package name */
    private final Context f3791a;

    public d(Context context) {
        this.f3791a = context.getApplicationContext();
    }

    private int b(Context context, Uri uri) {
        List pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return a(context, uri);
        }
        if (pathSegments.size() == 1) {
            return a(uri);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unrecognized Uri format: ");
        sb.append(uri);
        throw new IllegalArgumentException(sb.toString());
    }

    public boolean a(Uri uri, i iVar) {
        return uri.getScheme().equals("android.resource");
    }

    public G<Drawable> a(Uri uri, int i2, int i3, i iVar) {
        Context a2 = a(uri, uri.getAuthority());
        return c.a(a.a(this.f3791a, a2, b(a2, uri)));
    }

    private Context a(Uri uri, String str) {
        if (str.equals(this.f3791a.getPackageName())) {
            return this.f3791a;
        }
        try {
            return this.f3791a.createPackageContext(str, 0);
        } catch (NameNotFoundException e2) {
            if (str.contains(this.f3791a.getPackageName())) {
                return this.f3791a;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to obtain context or unrecognized Uri format for: ");
            sb.append(uri);
            throw new IllegalArgumentException(sb.toString(), e2);
        }
    }

    private int a(Context context, Uri uri) {
        List pathSegments = uri.getPathSegments();
        String str = (String) pathSegments.get(0);
        String str2 = (String) pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, uri.getAuthority());
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, C0730a.ANDROID_CLIENT_TYPE);
        }
        if (identifier != 0) {
            return identifier;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to find resource id for: ");
        sb.append(uri);
        throw new IllegalArgumentException(sb.toString());
    }

    private int a(Uri uri) {
        try {
            return Integer.parseInt((String) uri.getPathSegments().get(0));
        } catch (NumberFormatException e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unrecognized Uri format: ");
            sb.append(uri);
            throw new IllegalArgumentException(sb.toString(), e2);
        }
    }
}
