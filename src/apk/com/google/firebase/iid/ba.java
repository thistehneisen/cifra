package com.google.firebase.iid;

import android.util.Base64;
import com.google.android.gms.common.internal.C0321p;
import java.security.KeyPair;

final class ba {

    /* renamed from: a reason: collision with root package name */
    private final KeyPair f6805a;
    /* access modifiers changed from: private */

    /* renamed from: b reason: collision with root package name */
    public final long f6806b;

    ba(KeyPair keyPair, long j2) {
        this.f6805a = keyPair;
        this.f6806b = j2;
    }

    /* access modifiers changed from: private */
    public final String b() {
        return Base64.encodeToString(this.f6805a.getPublic().getEncoded(), 11);
    }

    /* access modifiers changed from: private */
    public final String c() {
        return Base64.encodeToString(this.f6805a.getPrivate().getEncoded(), 11);
    }

    /* access modifiers changed from: 0000 */
    public final KeyPair a() {
        return this.f6805a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ba)) {
            return false;
        }
        ba baVar = (ba) obj;
        if (this.f6806b != baVar.f6806b || !this.f6805a.getPublic().equals(baVar.f6805a.getPublic()) || !this.f6805a.getPrivate().equals(baVar.f6805a.getPrivate())) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return C0321p.a(this.f6805a.getPublic(), this.f6805a.getPrivate(), Long.valueOf(this.f6806b));
    }
}
