package okhttp3.internal.http2;

import i.a.e;
import j.i;

/* compiled from: Header */
public final class b {

    /* renamed from: a reason: collision with root package name */
    public static final i f10540a = i.c(":");

    /* renamed from: b reason: collision with root package name */
    public static final i f10541b = i.c(":status");

    /* renamed from: c reason: collision with root package name */
    public static final i f10542c = i.c(":method");

    /* renamed from: d reason: collision with root package name */
    public static final i f10543d = i.c(":path");

    /* renamed from: e reason: collision with root package name */
    public static final i f10544e = i.c(":scheme");

    /* renamed from: f reason: collision with root package name */
    public static final i f10545f = i.c(":authority");

    /* renamed from: g reason: collision with root package name */
    public final i f10546g;

    /* renamed from: h reason: collision with root package name */
    public final i f10547h;

    /* renamed from: i reason: collision with root package name */
    final int f10548i;

    public b(String str, String str2) {
        this(i.c(str), i.c(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!this.f10546g.equals(bVar.f10546g) || !this.f10547h.equals(bVar.f10547h)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((527 + this.f10546g.hashCode()) * 31) + this.f10547h.hashCode();
    }

    public String toString() {
        return e.a("%s: %s", this.f10546g.g(), this.f10547h.g());
    }

    public b(i iVar, String str) {
        this(iVar, i.c(str));
    }

    public b(i iVar, i iVar2) {
        this.f10546g = iVar;
        this.f10547h = iVar2;
        this.f10548i = iVar.size() + 32 + iVar2.size();
    }
}
