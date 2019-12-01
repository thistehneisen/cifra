package androidx.room;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import b.o.a.b;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.locks.Lock;

/* compiled from: InvalidationTracker */
class a implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ b f2028a;

    a(b bVar) {
        this.f2028a = bVar;
    }

    private boolean a() {
        b bVar = this.f2028a;
        Cursor a2 = bVar.f2035g.a("SELECT * FROM room_table_modification_log WHERE version  > ? ORDER BY version ASC;", bVar.f2033e);
        boolean z = false;
        while (a2.moveToNext()) {
            try {
                long j2 = a2.getLong(0);
                this.f2028a.f2032d[a2.getInt(1)] = j2;
                this.f2028a.f2034f = j2;
                z = true;
            } finally {
                a2.close();
            }
        }
        return z;
    }

    public void run() {
        b a2;
        Lock b2 = this.f2028a.f2035g.b();
        boolean z = false;
        try {
            b2.lock();
            if (!this.f2028a.a()) {
                b2.unlock();
            } else if (!this.f2028a.f2036h.compareAndSet(true, false)) {
                b2.unlock();
            } else if (this.f2028a.f2035g.d()) {
                b2.unlock();
            } else {
                this.f2028a.f2038j.y();
                this.f2028a.f2033e[0] = Long.valueOf(this.f2028a.f2034f);
                if (this.f2028a.f2035g.f2052d) {
                    a2 = this.f2028a.f2035g.c().a();
                    a2.z();
                    z = a();
                    a2.A();
                    a2.B();
                } else {
                    z = a();
                }
                b2.unlock();
                if (z) {
                    synchronized (this.f2028a.f2040l) {
                        Iterator it = this.f2028a.f2040l.iterator();
                        while (it.hasNext()) {
                            ((c) ((Entry) it.next()).getValue()).a(this.f2028a.f2032d);
                        }
                    }
                }
            }
        } catch (SQLiteException | IllegalStateException e2) {
            try {
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e2);
            } catch (Throwable th) {
                b2.unlock();
                throw th;
            }
        } catch (Throwable th2) {
            a2.B();
            throw th2;
        }
    }
}
