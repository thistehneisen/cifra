package androidx.versionedparcelable;

import android.os.Parcelable;
import b.d.b;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class VersionedParcel {

    /* renamed from: a reason: collision with root package name */
    protected final b<String, Method> f2115a;

    /* renamed from: b reason: collision with root package name */
    protected final b<String, Method> f2116b;

    /* renamed from: c reason: collision with root package name */
    protected final b<String, Class> f2117c;

    public static class ParcelException extends RuntimeException {
    }

    public VersionedParcel(b<String, Method> bVar, b<String, Method> bVar2, b<String, Class> bVar3) {
        this.f2115a = bVar;
        this.f2116b = bVar2;
        this.f2117c = bVar3;
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: protected */
    public abstract void a(Parcelable parcelable);

    /* access modifiers changed from: protected */
    public abstract void a(CharSequence charSequence);

    /* access modifiers changed from: protected */
    public abstract void a(String str);

    /* access modifiers changed from: protected */
    public abstract void a(boolean z);

    public void a(boolean z, boolean z2) {
    }

    /* access modifiers changed from: protected */
    public abstract void a(byte[] bArr);

    /* access modifiers changed from: protected */
    public abstract boolean a(int i2);

    public boolean a(boolean z, int i2) {
        if (!a(i2)) {
            return z;
        }
        return d();
    }

    /* access modifiers changed from: protected */
    public abstract VersionedParcel b();

    /* access modifiers changed from: protected */
    public abstract void b(int i2);

    public void b(boolean z, int i2) {
        b(i2);
        a(z);
    }

    /* access modifiers changed from: protected */
    public abstract void c(int i2);

    public boolean c() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract boolean d();

    /* access modifiers changed from: protected */
    public abstract byte[] e();

    /* access modifiers changed from: protected */
    public abstract CharSequence f();

    /* access modifiers changed from: protected */
    public abstract int g();

    /* access modifiers changed from: protected */
    public abstract <T extends Parcelable> T h();

    /* access modifiers changed from: protected */
    public abstract String i();

    /* access modifiers changed from: protected */
    public <T extends c> T j() {
        String i2 = i();
        if (i2 == null) {
            return null;
        }
        return a(i2, b());
    }

    public int a(int i2, int i3) {
        if (!a(i3)) {
            return i2;
        }
        return g();
    }

    public void b(byte[] bArr, int i2) {
        b(i2);
        a(bArr);
    }

    public String a(String str, int i2) {
        if (!a(i2)) {
            return str;
        }
        return i();
    }

    public void b(CharSequence charSequence, int i2) {
        b(i2);
        a(charSequence);
    }

    public byte[] a(byte[] bArr, int i2) {
        if (!a(i2)) {
            return bArr;
        }
        return e();
    }

    public void b(int i2, int i3) {
        b(i3);
        c(i2);
    }

    public <T extends Parcelable> T a(T t, int i2) {
        if (!a(i2)) {
            return t;
        }
        return h();
    }

    public void b(String str, int i2) {
        b(i2);
        a(str);
    }

    public CharSequence a(CharSequence charSequence, int i2) {
        if (!a(i2)) {
            return charSequence;
        }
        return f();
    }

    public void b(Parcelable parcelable, int i2) {
        b(i2);
        a(parcelable);
    }

    /* access modifiers changed from: protected */
    public void a(c cVar) {
        if (cVar == null) {
            a((String) null);
            return;
        }
        b(cVar);
        VersionedParcel b2 = b();
        a((T) cVar, b2);
        b2.a();
    }

    public void b(c cVar, int i2) {
        b(i2);
        a(cVar);
    }

    private void b(c cVar) {
        try {
            a(a(cVar.getClass()).getName());
        } catch (ClassNotFoundException e2) {
            StringBuilder sb = new StringBuilder();
            sb.append(cVar.getClass().getSimpleName());
            sb.append(" does not have a Parcelizer");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    private Method b(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = (Method) this.f2115a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", new Class[]{VersionedParcel.class});
        this.f2115a.put(str, declaredMethod);
        return declaredMethod;
    }

    public <T extends c> T a(T t, int i2) {
        if (!a(i2)) {
            return t;
        }
        return j();
    }

    /* access modifiers changed from: protected */
    public <T extends c> T a(String str, VersionedParcel versionedParcel) {
        try {
            return (c) b(str).invoke(null, new Object[]{versionedParcel});
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e3.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
        }
    }

    private Method b(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = (Method) this.f2116b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class a2 = a(cls);
        System.currentTimeMillis();
        Method declaredMethod = a2.getDeclaredMethod("write", new Class[]{cls, VersionedParcel.class});
        this.f2116b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    /* access modifiers changed from: protected */
    public <T extends c> void a(T t, VersionedParcel versionedParcel) {
        try {
            b(t.getClass()).invoke(null, new Object[]{t, versionedParcel});
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e3.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
        }
    }

    private Class a(Class<? extends c> cls) throws ClassNotFoundException {
        Class cls2 = (Class) this.f2117c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class cls3 = Class.forName(String.format("%s.%sParcelizer", new Object[]{cls.getPackage().getName(), cls.getSimpleName()}), false, cls.getClassLoader());
        this.f2117c.put(cls.getName(), cls3);
        return cls3;
    }
}
