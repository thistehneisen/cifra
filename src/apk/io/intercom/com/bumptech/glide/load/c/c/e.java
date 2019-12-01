package io.intercom.com.bumptech.glide.load.c.c;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import io.intercom.com.bumptech.glide.load.engine.E;
import io.intercom.com.bumptech.glide.load.j;
import io.intercom.com.bumptech.glide.load.k;
import java.io.IOException;
import java.util.List;

/* compiled from: ResourceDrawableDecoder */
public class e implements k<Uri, Drawable> {

    /* renamed from: a reason: collision with root package name */
    private final Context f9655a;

    public e(Context context) {
        this.f9655a = context.getApplicationContext();
    }

    public boolean a(Uri uri, j jVar) throws IOException {
        return uri.getScheme().equals("android.resource");
    }

    public E<Drawable> a(Uri uri, int i2, int i3, j jVar) throws IOException {
        Context context;
        int a2 = a(uri);
        String authority = uri.getAuthority();
        if (authority.equals(this.f9655a.getPackageName())) {
            context = this.f9655a;
        } else {
            context = a(uri, authority);
        }
        return d.a(a.a(context, a2));
    }

    private Context a(Uri uri, String str) {
        try {
            return this.f9655a.createPackageContext(str, 0);
        } catch (NameNotFoundException e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to obtain context or unrecognized Uri format for: ");
            sb.append(uri);
            throw new IllegalArgumentException(sb.toString(), e2);
        }
    }

    private int a(Uri uri) {
        Integer num;
        List pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            String str = (String) pathSegments.get(0);
            String str2 = (String) pathSegments.get(1);
            num = Integer.valueOf(this.f9655a.getResources().getIdentifier(str2, str, uri.getAuthority()));
        } else {
            if (pathSegments.size() == 1) {
                try {
                    num = Integer.valueOf((String) pathSegments.get(0));
                } catch (NumberFormatException unused) {
                }
            }
            num = null;
        }
        if (num == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unrecognized Uri format: ");
            sb.append(uri);
            throw new IllegalArgumentException(sb.toString());
        } else if (num.intValue() != 0) {
            return num.intValue();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to obtain resource id for: ");
            sb2.append(uri);
            throw new IllegalArgumentException(sb2.toString());
        }
    }
}
