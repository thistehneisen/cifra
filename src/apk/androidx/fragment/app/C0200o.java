package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* renamed from: androidx.fragment.app.o reason: case insensitive filesystem */
/* compiled from: FragmentManager */
public abstract class C0200o {

    /* renamed from: a reason: collision with root package name */
    static final C0198m f1544a = new C0198m();

    /* renamed from: b reason: collision with root package name */
    private C0198m f1545b = null;

    /* renamed from: androidx.fragment.app.o$a */
    /* compiled from: FragmentManager */
    public interface a {
        String getName();
    }

    /* renamed from: androidx.fragment.app.o$b */
    /* compiled from: FragmentManager */
    public static abstract class b {
        public void a(C0200o oVar, Fragment fragment) {
        }

        public void a(C0200o oVar, Fragment fragment, Context context) {
        }

        public void a(C0200o oVar, Fragment fragment, Bundle bundle) {
        }

        public abstract void a(C0200o oVar, Fragment fragment, View view, Bundle bundle);

        public void b(C0200o oVar, Fragment fragment) {
        }

        public void b(C0200o oVar, Fragment fragment, Context context) {
        }

        public void b(C0200o oVar, Fragment fragment, Bundle bundle) {
        }

        public void c(C0200o oVar, Fragment fragment) {
        }

        public void c(C0200o oVar, Fragment fragment, Bundle bundle) {
        }

        public void d(C0200o oVar, Fragment fragment) {
        }

        public void d(C0200o oVar, Fragment fragment, Bundle bundle) {
        }

        public void e(C0200o oVar, Fragment fragment) {
        }

        public void f(C0200o oVar, Fragment fragment) {
        }

        public void g(C0200o oVar, Fragment fragment) {
        }
    }

    /* renamed from: androidx.fragment.app.o$c */
    /* compiled from: FragmentManager */
    public interface c {
        void onBackStackChanged();
    }

    public abstract F a();

    public abstract androidx.fragment.app.Fragment.c a(Fragment fragment);

    public abstract Fragment a(int i2);

    public abstract Fragment a(Bundle bundle, String str);

    public abstract Fragment a(String str);

    public abstract void a(int i2, int i3);

    public abstract void a(Bundle bundle, String str, Fragment fragment);

    public void a(C0198m mVar) {
        this.f1545b = mVar;
    }

    public abstract void a(b bVar);

    public abstract void a(b bVar, boolean z);

    public abstract void a(String str, int i2);

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract int b();

    public abstract a b(int i2);

    public C0198m c() {
        if (this.f1545b == null) {
            this.f1545b = f1544a;
        }
        return this.f1545b;
    }

    public abstract List<Fragment> d();

    public abstract Fragment e();

    public abstract boolean f();

    public abstract void g();

    public abstract boolean h();
}
