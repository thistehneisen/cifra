package com.google.firebase.iid;

import android.util.Log;
import android.util.Pair;
import b.d.b;
import com.google.android.gms.tasks.g;
import java.util.Map;
import java.util.concurrent.Executor;

/* renamed from: com.google.firebase.iid.s reason: case insensitive filesystem */
final class C0629s {

    /* renamed from: a reason: collision with root package name */
    private final Executor f6836a;

    /* renamed from: b reason: collision with root package name */
    private final Map<Pair<String, String>, g<C0612a>> f6837b = new b();

    C0629s(Executor executor) {
        this.f6836a = executor;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003e, code lost:
        return r4;
     */
    public final synchronized g<C0612a> a(String str, String str2, C0630t tVar) {
        Pair pair = new Pair(str, str2);
        g<C0612a> gVar = (g) this.f6837b.get(pair);
        if (gVar == null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(pair);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 24);
                sb.append("Making new request for: ");
                sb.append(valueOf);
                Log.d("FirebaseInstanceId", sb.toString());
            }
            g<C0612a> b2 = tVar.a().b(this.f6836a, new C0631u(this, pair));
            this.f6837b.put(pair, b2);
            return b2;
        } else if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf2 = String.valueOf(pair);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 29);
            sb2.append("Joining ongoing request for: ");
            sb2.append(valueOf2);
            Log.d("FirebaseInstanceId", sb2.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ g a(Pair pair, g gVar) throws Exception {
        synchronized (this) {
            this.f6837b.remove(pair);
        }
        return gVar;
    }
}
