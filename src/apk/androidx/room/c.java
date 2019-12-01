package androidx.room;

import android.database.Cursor;
import b.o.a.a;
import b.o.a.b;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: RoomDatabase */
public abstract class c {

    /* renamed from: a reason: collision with root package name */
    protected volatile b f2049a;

    /* renamed from: b reason: collision with root package name */
    private b.o.a.c f2050b;

    /* renamed from: c reason: collision with root package name */
    private final b f2051c = a();

    /* renamed from: d reason: collision with root package name */
    boolean f2052d;

    /* renamed from: e reason: collision with root package name */
    private final ReentrantLock f2053e = new ReentrantLock();

    public Cursor a(String str, Object[] objArr) {
        return this.f2050b.a().a(new a(str, objArr));
    }

    /* access modifiers changed from: protected */
    public abstract b a();

    /* access modifiers changed from: 0000 */
    public Lock b() {
        return this.f2053e;
    }

    public b.o.a.c c() {
        return this.f2050b;
    }

    public boolean d() {
        return this.f2050b.a().C();
    }

    public boolean e() {
        b bVar = this.f2049a;
        return bVar != null && bVar.isOpen();
    }
}
