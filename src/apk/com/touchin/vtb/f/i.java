package com.touchin.vtb.f;

import com.touchin.vtb.api.UserProfile;
import kotlin.e.b.h;
import ru.touchin.roboswag.core.utils.b;

/* compiled from: StartupInfo.kt */
public final class i {

    /* renamed from: a reason: collision with root package name */
    private final b<UserProfile> f7411a;

    /* renamed from: b reason: collision with root package name */
    private final String f7412b;

    /* renamed from: c reason: collision with root package name */
    private final boolean f7413c;

    /* renamed from: d reason: collision with root package name */
    private final boolean f7414d;

    public i(b<UserProfile> bVar, String str, boolean z, boolean z2) {
        h.b(bVar, "userProfile");
        h.b(str, "pin");
        this.f7411a = bVar;
        this.f7412b = str;
        this.f7413c = z;
        this.f7414d = z2;
    }

    public final String a() {
        return this.f7412b;
    }

    public final b<UserProfile> b() {
        return this.f7411a;
    }

    public final boolean c() {
        return this.f7413c;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof i) {
                i iVar = (i) obj;
                if (h.a((Object) this.f7411a, (Object) iVar.f7411a) && h.a((Object) this.f7412b, (Object) iVar.f7412b)) {
                    if (this.f7413c == iVar.f7413c) {
                        if (this.f7414d == iVar.f7414d) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        b<UserProfile> bVar = this.f7411a;
        int i2 = 0;
        int hashCode = (bVar != null ? bVar.hashCode() : 0) * 31;
        String str = this.f7412b;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = (hashCode + i2) * 31;
        boolean z = this.f7413c;
        if (z) {
            z = true;
        }
        int i4 = (i3 + (z ? 1 : 0)) * 31;
        boolean z2 = this.f7414d;
        if (z2) {
            z2 = true;
        }
        return i4 + (z2 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StartupInfo(userProfile=");
        sb.append(this.f7411a);
        sb.append(", pin=");
        sb.append(this.f7412b);
        sb.append(", isFingerprintEnabled=");
        sb.append(this.f7413c);
        sb.append(", isPushTokenAdded=");
        sb.append(this.f7414d);
        sb.append(")");
        return sb.toString();
    }
}
