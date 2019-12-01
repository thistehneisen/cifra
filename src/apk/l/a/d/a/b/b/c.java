package l.a.d.a.b.b;

import android.content.SharedPreferences;
import e.b.c.a;
import e.b.o;
import java.lang.reflect.Type;
import java.util.concurrent.Callable;
import ru.touchin.roboswag.core.observables.storable.l;
import ru.touchin.roboswag.core.utils.b;

/* compiled from: PreferenceStore */
public class c<T> implements l<String, T> {

    /* renamed from: a reason: collision with root package name */
    private final SharedPreferences f10420a;

    public c(SharedPreferences sharedPreferences) {
        this.f10420a = sharedPreferences;
    }

    private static boolean b(Type type) {
        return type.equals(Float.class) || type.equals(Float.TYPE);
    }

    private static boolean c(Type type) {
        return type.equals(Integer.class) || type.equals(Integer.TYPE);
    }

    private static boolean d(Type type) {
        return type.equals(Long.class) || type.equals(Long.TYPE);
    }

    /* renamed from: b */
    public o<b<T>> a(Type type, String str) {
        return o.b((Callable<? extends T>) new a<Object>(this, str, type));
    }

    /* renamed from: c */
    public e.b.b a(Type type, String str, T t) {
        return e.b.b.a((a) new b(this, type, str, t));
    }

    private static boolean a(Type type) {
        return type.equals(Boolean.class) || type.equals(Boolean.TYPE);
    }

    /* renamed from: b */
    public void a(Type type, String str, T t) {
        if (t == null) {
            this.f10420a.edit().remove(str).apply();
            return;
        }
        if (a(type)) {
            this.f10420a.edit().putBoolean(str, ((Boolean) t).booleanValue()).apply();
        } else if (type.equals(String.class)) {
            this.f10420a.edit().putString(str, (String) t).apply();
        } else if (c(type)) {
            this.f10420a.edit().putInt(str, ((Integer) t).intValue()).apply();
        } else if (d(type)) {
            this.f10420a.edit().putLong(str, ((Long) t).longValue()).apply();
        } else if (b(type)) {
            this.f10420a.edit().putFloat(str, ((Float) t).floatValue()).apply();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unsupported type of object ");
            sb.append(type);
            l.a.d.b.a.c.a(sb.toString());
        }
    }

    public /* synthetic */ b a(String str, Type type) throws Exception {
        return new b(!this.f10420a.contains(str) ? null : a(type, str));
    }

    public T a(Type type, String str) {
        if (a(type)) {
            return Boolean.valueOf(this.f10420a.getBoolean(str, false));
        }
        if (type.equals(String.class)) {
            return this.f10420a.getString(str, null);
        }
        if (c(type)) {
            return Integer.valueOf(this.f10420a.getInt(str, 0));
        }
        if (d(type)) {
            return Long.valueOf(this.f10420a.getLong(str, 0));
        }
        if (b(type)) {
            return Float.valueOf(this.f10420a.getFloat(str, 0.0f));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unsupported type of object ");
        sb.append(type);
        l.a.d.b.a.c.a(sb.toString());
        return null;
    }
}
