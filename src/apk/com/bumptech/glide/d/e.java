package com.bumptech.glide.d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* compiled from: ManifestParser */
public final class e {

    /* renamed from: a reason: collision with root package name */
    private final Context f3388a;

    public e(Context context) {
        this.f3388a = context;
    }

    public List<c> a() {
        String str = "ManifestParser";
        if (Log.isLoggable(str, 3)) {
            Log.d(str, "Loading Glide modules");
        }
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.f3388a.getPackageManager().getApplicationInfo(this.f3388a.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Got null app info metadata");
                }
                return arrayList;
            }
            if (Log.isLoggable(str, 2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Got app info metadata: ");
                sb.append(applicationInfo.metaData);
                Log.v(str, sb.toString());
            }
            for (String str2 : applicationInfo.metaData.keySet()) {
                if ("GlideModule".equals(applicationInfo.metaData.get(str2))) {
                    arrayList.add(a(str2));
                    if (Log.isLoggable(str, 3)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Loaded Glide module: ");
                        sb2.append(str2);
                        Log.d(str, sb2.toString());
                    }
                }
            }
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Finished loading Glide modules");
            }
            return arrayList;
        } catch (NameNotFoundException e2) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e2);
        }
    }

    private static c a(String str) {
        try {
            Class cls = Class.forName(str);
            try {
                Object newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (newInstance instanceof c) {
                    return (c) newInstance;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Expected instanceof GlideModule, but found: ");
                sb.append(newInstance);
                throw new RuntimeException(sb.toString());
            } catch (InstantiationException e2) {
                a(cls, e2);
                throw null;
            } catch (IllegalAccessException e3) {
                a(cls, e3);
                throw null;
            } catch (NoSuchMethodException e4) {
                a(cls, e4);
                throw null;
            } catch (InvocationTargetException e5) {
                a(cls, e5);
                throw null;
            }
        } catch (ClassNotFoundException e6) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e6);
        }
    }

    private static void a(Class<?> cls, Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to instantiate GlideModule implementation for ");
        sb.append(cls);
        throw new RuntimeException(sb.toString(), exc);
    }
}
