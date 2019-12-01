package androidx.fragment.app;

import androidx.lifecycle.h.b;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* compiled from: FragmentTransaction */
public abstract class F {

    /* renamed from: a reason: collision with root package name */
    ArrayList<a> f1411a = new ArrayList<>();

    /* renamed from: b reason: collision with root package name */
    int f1412b;

    /* renamed from: c reason: collision with root package name */
    int f1413c;

    /* renamed from: d reason: collision with root package name */
    int f1414d;

    /* renamed from: e reason: collision with root package name */
    int f1415e;

    /* renamed from: f reason: collision with root package name */
    int f1416f;

    /* renamed from: g reason: collision with root package name */
    int f1417g;

    /* renamed from: h reason: collision with root package name */
    boolean f1418h;

    /* renamed from: i reason: collision with root package name */
    boolean f1419i = true;

    /* renamed from: j reason: collision with root package name */
    String f1420j;

    /* renamed from: k reason: collision with root package name */
    int f1421k;

    /* renamed from: l reason: collision with root package name */
    CharSequence f1422l;
    int m;
    CharSequence n;
    ArrayList<String> o;
    ArrayList<String> p;
    boolean q = false;
    ArrayList<Runnable> r;

    /* compiled from: FragmentTransaction */
    static final class a {

        /* renamed from: a reason: collision with root package name */
        int f1423a;

        /* renamed from: b reason: collision with root package name */
        Fragment f1424b;

        /* renamed from: c reason: collision with root package name */
        int f1425c;

        /* renamed from: d reason: collision with root package name */
        int f1426d;

        /* renamed from: e reason: collision with root package name */
        int f1427e;

        /* renamed from: f reason: collision with root package name */
        int f1428f;

        /* renamed from: g reason: collision with root package name */
        b f1429g;

        /* renamed from: h reason: collision with root package name */
        b f1430h;

        a() {
        }

        a(int i2, Fragment fragment) {
            this.f1423a = i2;
            this.f1424b = fragment;
            b bVar = b.RESUMED;
            this.f1429g = bVar;
            this.f1430h = bVar;
        }

        a(int i2, Fragment fragment, b bVar) {
            this.f1423a = i2;
            this.f1424b = fragment;
            this.f1429g = fragment.mMaxState;
            this.f1430h = bVar;
        }
    }

    public abstract int a();

    /* access modifiers changed from: 0000 */
    public void a(a aVar) {
        this.f1411a.add(aVar);
        aVar.f1425c = this.f1412b;
        aVar.f1426d = this.f1413c;
        aVar.f1427e = this.f1414d;
        aVar.f1428f = this.f1415e;
    }

    public abstract int b();

    public F b(int i2, Fragment fragment) {
        b(i2, fragment, null);
        return this;
    }

    public F c(Fragment fragment) {
        a(new a(3, fragment));
        return this;
    }

    public abstract void c();

    public F d(Fragment fragment) {
        a(new a(8, fragment));
        return this;
    }

    public F b(int i2, Fragment fragment, String str) {
        if (i2 != 0) {
            a(i2, fragment, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    public F d() {
        if (!this.f1418h) {
            this.f1419i = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    public F b(Fragment fragment) {
        a(new a(6, fragment));
        return this;
    }

    public F a(Fragment fragment, String str) {
        a(0, fragment, str, 1);
        return this;
    }

    public F a(int i2, Fragment fragment) {
        a(i2, fragment, null, 1);
        return this;
    }

    public F a(int i2, Fragment fragment, String str) {
        a(i2, fragment, str, 1);
        return this;
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2, Fragment fragment, String str, int i3) {
        Class cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            StringBuilder sb = new StringBuilder();
            sb.append("Fragment ");
            sb.append(cls.getCanonicalName());
            sb.append(" must be a public static class to be  properly recreated from instance state.");
            throw new IllegalStateException(sb.toString());
        }
        String str2 = " now ";
        String str3 = ": was ";
        if (str != null) {
            String str4 = fragment.mTag;
            if (str4 == null || str.equals(str4)) {
                fragment.mTag = str;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Can't change tag of fragment ");
                sb2.append(fragment);
                sb2.append(str3);
                sb2.append(fragment.mTag);
                sb2.append(str2);
                sb2.append(str);
                throw new IllegalStateException(sb2.toString());
            }
        }
        if (i2 != 0) {
            if (i2 != -1) {
                int i4 = fragment.mFragmentId;
                if (i4 == 0 || i4 == i2) {
                    fragment.mFragmentId = i2;
                    fragment.mContainerId = i2;
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Can't change container ID of fragment ");
                    sb3.append(fragment);
                    sb3.append(str3);
                    sb3.append(fragment.mFragmentId);
                    sb3.append(str2);
                    sb3.append(i2);
                    throw new IllegalStateException(sb3.toString());
                }
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Can't add fragment ");
                sb4.append(fragment);
                sb4.append(" with tag ");
                sb4.append(str);
                sb4.append(" to container view with no id");
                throw new IllegalArgumentException(sb4.toString());
            }
        }
        a(new a(i3, fragment));
    }

    public F a(Fragment fragment) {
        a(new a(7, fragment));
        return this;
    }

    public F a(Fragment fragment, b bVar) {
        a(new a(10, fragment, bVar));
        return this;
    }

    public F a(int i2) {
        this.f1416f = i2;
        return this;
    }

    public F a(String str) {
        if (this.f1419i) {
            this.f1418h = true;
            this.f1420j = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    public F a(boolean z) {
        this.q = z;
        return this;
    }
}
