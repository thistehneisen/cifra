package io.fabric.sdk.android.a.b;

import android.content.Context;
import io.fabric.sdk.android.f;
import io.fabric.sdk.android.o;
import java.lang.reflect.Method;

/* compiled from: FirebaseAppImpl */
final class w implements v {

    /* renamed from: a reason: collision with root package name */
    private final Method f8856a;

    /* renamed from: b reason: collision with root package name */
    private final Object f8857b;

    private w(Class cls, Object obj) throws NoSuchMethodException {
        this.f8857b = obj;
        this.f8856a = cls.getDeclaredMethod("isDataCollectionDefaultEnabled", new Class[0]);
    }

    public static v a(Context context) {
        String str = "Fabric";
        try {
            Class loadClass = context.getClassLoader().loadClass("com.google.firebase.FirebaseApp");
            return new w(loadClass, loadClass.getDeclaredMethod("getInstance", new Class[0]).invoke(loadClass, new Object[0]));
        } catch (ClassNotFoundException unused) {
            f.e().d(str, "Could not find class: com.google.firebase.FirebaseApp");
            return null;
        } catch (NoSuchMethodException e2) {
            o e3 = f.e();
            StringBuilder sb = new StringBuilder();
            sb.append("Could not find method: ");
            sb.append(e2.getMessage());
            e3.d(str, sb.toString());
            return null;
        } catch (Exception e4) {
            f.e().c(str, "Unexpected error loading FirebaseApp instance.", e4);
            return null;
        }
    }

    public boolean a() {
        try {
            return ((Boolean) this.f8856a.invoke(this.f8857b, new Object[0])).booleanValue();
        } catch (Exception e2) {
            f.e().c("Fabric", "Cannot check isDataCollectionDefaultEnabled on FirebaseApp.", e2);
            return false;
        }
    }
}
