package kotlinx.coroutines.android;

import android.os.Handler;
import kotlin.e.b.h;
import kotlinx.coroutines.d;

/* compiled from: HandlerDispatcher.kt */
public final class b extends c implements d {
    private volatile b _immediate;

    /* renamed from: a reason: collision with root package name */
    private final b f10350a;

    /* renamed from: b reason: collision with root package name */
    private final Handler f10351b;

    /* renamed from: c reason: collision with root package name */
    private final String f10352c;

    /* renamed from: d reason: collision with root package name */
    private final boolean f10353d;

    private b(Handler handler, String str, boolean z) {
        b bVar = null;
        super(null);
        this.f10351b = handler;
        this.f10352c = str;
        this.f10353d = z;
        if (this.f10353d) {
            bVar = this;
        }
        this._immediate = bVar;
        b bVar2 = this._immediate;
        if (bVar2 == null) {
            bVar2 = new b(this.f10351b, this.f10352c, true);
            this._immediate = bVar2;
        }
        this.f10350a = bVar2;
    }

    public boolean equals(Object obj) {
        return (obj instanceof b) && ((b) obj).f10351b == this.f10351b;
    }

    public int hashCode() {
        return System.identityHashCode(this.f10351b);
    }

    public String toString() {
        String str = this.f10352c;
        if (str == null) {
            String handler = this.f10351b.toString();
            h.a((Object) handler, "handler.toString()");
            return handler;
        } else if (!this.f10353d) {
            return str;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f10352c);
            sb.append(" [immediate]");
            return sb.toString();
        }
    }

    public b(Handler handler, String str) {
        h.b(handler, "handler");
        this(handler, str, false);
    }
}
