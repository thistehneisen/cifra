package b.l.a;

import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.C;
import androidx.lifecycle.D;
import androidx.lifecycle.F;
import androidx.lifecycle.l;
import androidx.lifecycle.u;
import androidx.lifecycle.v;
import b.d.j;
import b.l.b.a.C0033a;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: LoaderManagerImpl */
class b extends a {

    /* renamed from: a reason: collision with root package name */
    static boolean f2778a = false;

    /* renamed from: b reason: collision with root package name */
    private final l f2779b;

    /* renamed from: c reason: collision with root package name */
    private final c f2780c;

    /* compiled from: LoaderManagerImpl */
    public static class a<D> extends u<D> implements C0033a<D> {

        /* renamed from: k reason: collision with root package name */
        private final int f2781k;

        /* renamed from: l reason: collision with root package name */
        private final Bundle f2782l;
        private final b.l.b.a<D> m;
        private l n;
        private C0032b<D> o;
        private b.l.b.a<D> p;

        /* access modifiers changed from: 0000 */
        public b.l.b.a<D> a(boolean z) {
            if (b.f2778a) {
                StringBuilder sb = new StringBuilder();
                sb.append("  Destroying: ");
                sb.append(this);
                Log.v("LoaderManager", sb.toString());
            }
            this.m.a();
            throw null;
        }

        /* access modifiers changed from: protected */
        public void b() {
            if (b.f2778a) {
                StringBuilder sb = new StringBuilder();
                sb.append("  Starting: ");
                sb.append(this);
                Log.v("LoaderManager", sb.toString());
            }
            this.m.c();
            throw null;
        }

        /* access modifiers changed from: protected */
        public void c() {
            if (b.f2778a) {
                StringBuilder sb = new StringBuilder();
                sb.append("  Stopping: ");
                sb.append(this);
                Log.v("LoaderManager", sb.toString());
            }
            this.m.d();
            throw null;
        }

        /* access modifiers changed from: 0000 */
        public void d() {
            l lVar = this.n;
            C0032b<D> bVar = this.o;
            if (lVar != null && bVar != null) {
                super.b((v<? super T>) bVar);
                a(lVar, bVar);
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f2781k);
            sb.append(" : ");
            b.g.h.a.a(this.m, sb);
            sb.append("}}");
            return sb.toString();
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f2781k);
            printWriter.print(" mArgs=");
            printWriter.println(this.f2782l);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.m);
            b.l.b.a<D> aVar = this.m;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("  ");
            aVar.a(sb.toString(), fileDescriptor, printWriter, strArr);
            throw null;
        }

        public void b(v<? super D> vVar) {
            super.b(vVar);
            this.n = null;
            this.o = null;
        }

        public void b(D d2) {
            super.b(d2);
            b.l.b.a<D> aVar = this.p;
            if (aVar != null) {
                aVar.b();
                throw null;
            }
        }
    }

    /* renamed from: b.l.a.b$b reason: collision with other inner class name */
    /* compiled from: LoaderManagerImpl */
    static class C0032b<D> implements v<D> {
    }

    /* compiled from: LoaderManagerImpl */
    static class c extends C {

        /* renamed from: c reason: collision with root package name */
        private static final androidx.lifecycle.D.b f2783c = new c();

        /* renamed from: d reason: collision with root package name */
        private j<a> f2784d = new j<>();

        /* renamed from: e reason: collision with root package name */
        private boolean f2785e = false;

        c() {
        }

        static c a(F f2) {
            return (c) new D(f2, f2783c).a(c.class);
        }

        /* access modifiers changed from: protected */
        public void b() {
            super.b();
            if (this.f2784d.b() <= 0) {
                this.f2784d.a();
            } else {
                ((a) this.f2784d.e(0)).a(true);
                throw null;
            }
        }

        /* access modifiers changed from: 0000 */
        public void c() {
            int b2 = this.f2784d.b();
            for (int i2 = 0; i2 < b2; i2++) {
                ((a) this.f2784d.e(i2)).d();
            }
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f2784d.b() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("    ");
                String sb2 = sb.toString();
                if (this.f2784d.b() > 0) {
                    a aVar = (a) this.f2784d.e(0);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f2784d.c(0));
                    printWriter.print(": ");
                    printWriter.println(aVar.toString());
                    aVar.a(sb2, fileDescriptor, printWriter, strArr);
                    throw null;
                }
            }
        }
    }

    b(l lVar, F f2) {
        this.f2779b = lVar;
        this.f2780c = c.a(f2);
    }

    public void a() {
        this.f2780c.c();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        b.g.h.a.a(this.f2779b, sb);
        sb.append("}}");
        return sb.toString();
    }

    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f2780c.a(str, fileDescriptor, printWriter, strArr);
    }
}
