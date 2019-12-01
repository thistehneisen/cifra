package com.touchin.vtb.f;

import com.touchin.vtb.api.NotificationType;
import kotlin.e.b.h;

/* compiled from: NotificationModel.kt */
public final class f {

    /* renamed from: a reason: collision with root package name */
    private final String f7396a;

    /* renamed from: b reason: collision with root package name */
    private final String f7397b;

    /* renamed from: c reason: collision with root package name */
    private final NotificationType f7398c;

    /* renamed from: d reason: collision with root package name */
    private String f7399d;

    public f(String str, String str2, NotificationType notificationType, String str3) {
        h.b(str, "title");
        h.b(str2, "body");
        h.b(notificationType, "type");
        this.f7396a = str;
        this.f7397b = str2;
        this.f7398c = notificationType;
        this.f7399d = str3;
    }

    public final String a() {
        return this.f7397b;
    }

    public final String b() {
        return this.f7399d;
    }

    public final String c() {
        return this.f7396a;
    }

    public final NotificationType d() {
        return this.f7398c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        if (kotlin.e.b.h.a((java.lang.Object) r2.f7399d, (java.lang.Object) r3.f7399d) != false) goto L_0x0033;
     */
    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (h.a((Object) this.f7396a, (Object) fVar.f7396a)) {
                    if (h.a((Object) this.f7397b, (Object) fVar.f7397b)) {
                        if (h.a((Object) this.f7398c, (Object) fVar.f7398c)) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f7396a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f7397b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        NotificationType notificationType = this.f7398c;
        int hashCode3 = (hashCode2 + (notificationType != null ? notificationType.hashCode() : 0)) * 31;
        String str3 = this.f7399d;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode3 + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NotificationModel(title=");
        sb.append(this.f7396a);
        sb.append(", body=");
        sb.append(this.f7397b);
        sb.append(", type=");
        sb.append(this.f7398c);
        sb.append(", notificationTaskId=");
        sb.append(this.f7399d);
        sb.append(")");
        return sb.toString();
    }

    public /* synthetic */ f(String str, String str2, NotificationType notificationType, String str3, int i2, e eVar) {
        if ((i2 & 8) != 0) {
            str3 = null;
        }
        this(str, str2, notificationType, str3);
    }

    public final void a(String str) {
        this.f7399d = str;
    }
}
