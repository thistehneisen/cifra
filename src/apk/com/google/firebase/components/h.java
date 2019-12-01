package com.google.firebase.components;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-common@@17.0.0 */
public final class h<T> {

    /* renamed from: a reason: collision with root package name */
    private final T f6696a;

    /* renamed from: b reason: collision with root package name */
    private final b<T> f6697b;

    /* compiled from: com.google.firebase:firebase-common@@17.0.0 */
    private static class a implements b<Context> {
        private a() {
        }

        private static Bundle b(Context context) {
            String str = "ComponentDiscovery";
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w(str, "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, ComponentDiscoveryService.class), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w(str, "ComponentDiscoveryService has no service info.");
                return null;
            } catch (NameNotFoundException unused) {
                Log.w(str, "Application info not found.");
                return null;
            }
        }

        public List<String> a(Context context) {
            Bundle b2 = b(context);
            if (b2 == null) {
                Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String str : b2.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(b2.get(str)) && str.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str.substring(31));
                }
            }
            return arrayList;
        }
    }

    /* compiled from: com.google.firebase:firebase-common@@17.0.0 */
    interface b<T> {
        List<String> a(T t);
    }

    h(T t, b<T> bVar) {
        this.f6696a = t;
        this.f6697b = bVar;
    }

    public static h<Context> a(Context context) {
        return new h<>(context, new a());
    }

    public List<j> a() {
        return a(this.f6697b.a(this.f6696a));
    }

    private static List<j> a(List<String> list) {
        String str = "Could not instantiate %s";
        String str2 = "Could not instantiate %s.";
        String str3 = "ComponentDiscovery";
        ArrayList arrayList = new ArrayList();
        for (String str4 : list) {
            try {
                Class cls = Class.forName(str4);
                if (!j.class.isAssignableFrom(cls)) {
                    Log.w(str3, String.format("Class %s is not an instance of %s", new Object[]{str4, "com.google.firebase.components.ComponentRegistrar"}));
                } else {
                    arrayList.add((j) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                }
            } catch (ClassNotFoundException e2) {
                Log.w(str3, String.format("Class %s is not an found.", new Object[]{str4}), e2);
            } catch (IllegalAccessException e3) {
                Log.w(str3, String.format(str2, new Object[]{str4}), e3);
            } catch (InstantiationException e4) {
                Log.w(str3, String.format(str2, new Object[]{str4}), e4);
            } catch (NoSuchMethodException e5) {
                Log.w(str3, String.format(str, new Object[]{str4}), e5);
            } catch (InvocationTargetException e6) {
                Log.w(str3, String.format(str, new Object[]{str4}), e6);
            }
        }
        return arrayList;
    }
}
