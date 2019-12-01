package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.C0232s.b;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: androidx.recyclerview.widget.f reason: case insensitive filesystem */
/* compiled from: AsyncListDiffer */
public class C0220f<T> {

    /* renamed from: a reason: collision with root package name */
    private static final Executor f1910a = new a();

    /* renamed from: b reason: collision with root package name */
    private final E f1911b;

    /* renamed from: c reason: collision with root package name */
    final C0216b<T> f1912c;

    /* renamed from: d reason: collision with root package name */
    final Executor f1913d;

    /* renamed from: e reason: collision with root package name */
    private List<T> f1914e;

    /* renamed from: f reason: collision with root package name */
    private List<T> f1915f = Collections.emptyList();

    /* renamed from: g reason: collision with root package name */
    int f1916g;

    /* renamed from: androidx.recyclerview.widget.f$a */
    /* compiled from: AsyncListDiffer */
    private static class a implements Executor {

        /* renamed from: a reason: collision with root package name */
        final Handler f1917a = new Handler(Looper.getMainLooper());

        a() {
        }

        public void execute(Runnable runnable) {
            this.f1917a.post(runnable);
        }
    }

    public C0220f(E e2, C0216b<T> bVar) {
        this.f1911b = e2;
        this.f1912c = bVar;
        if (bVar.c() != null) {
            this.f1913d = bVar.c();
        } else {
            this.f1913d = f1910a;
        }
    }

    public List<T> a() {
        return this.f1915f;
    }

    public void a(List<T> list) {
        int i2 = this.f1916g + 1;
        this.f1916g = i2;
        List<T> list2 = this.f1914e;
        if (list != list2) {
            if (list == null) {
                int size = list2.size();
                this.f1914e = null;
                this.f1915f = Collections.emptyList();
                this.f1911b.c(0, size);
            } else if (list2 == null) {
                this.f1914e = list;
                this.f1915f = Collections.unmodifiableList(list);
                this.f1911b.b(0, list.size());
            } else {
                this.f1912c.a().execute(new C0219e(this, list2, list, i2));
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(List<T> list, b bVar) {
        this.f1914e = list;
        this.f1915f = Collections.unmodifiableList(list);
        bVar.a(this.f1911b);
    }
}
