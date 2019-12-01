package b.g.i;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import java.lang.reflect.Field;

/* renamed from: b.g.i.f reason: case insensitive filesystem */
/* compiled from: LayoutInflaterCompat */
public final class C0245f {

    /* renamed from: a reason: collision with root package name */
    private static Field f2714a;

    /* renamed from: b reason: collision with root package name */
    private static boolean f2715b;

    public static void a(LayoutInflater layoutInflater, Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
        if (VERSION.SDK_INT < 21) {
            Factory factory = layoutInflater.getFactory();
            if (factory instanceof Factory2) {
                b(layoutInflater, (Factory2) factory);
            } else {
                b(layoutInflater, factory2);
            }
        }
    }

    private static void b(LayoutInflater layoutInflater, Factory2 factory2) {
        String str = "; inflation may have unexpected results.";
        String str2 = "LayoutInflaterCompatHC";
        if (!f2715b) {
            try {
                f2714a = LayoutInflater.class.getDeclaredField("mFactory2");
                f2714a.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("forceSetFactory2 Could not find field 'mFactory2' on class ");
                sb.append(LayoutInflater.class.getName());
                sb.append(str);
                Log.e(str2, sb.toString(), e2);
            }
            f2715b = true;
        }
        Field field = f2714a;
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (IllegalAccessException e3) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("forceSetFactory2 could not set the Factory2 on LayoutInflater ");
                sb2.append(layoutInflater);
                sb2.append(str);
                Log.e(str2, sb2.toString(), e3);
            }
        }
    }
}
