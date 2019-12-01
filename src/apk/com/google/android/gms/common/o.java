package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.I;
import com.google.android.gms.common.internal.J;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.b;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class o extends J {

    /* renamed from: a reason: collision with root package name */
    private int f4784a;

    protected o(byte[] bArr) {
        q.a(bArr.length == 25);
        this.f4784a = Arrays.hashCode(bArr);
    }

    protected static byte[] a(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public final int d() {
        return hashCode();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof I)) {
            try {
                I i2 = (I) obj;
                if (i2.d() != hashCode()) {
                    return false;
                }
                a f2 = i2.f();
                if (f2 == null) {
                    return false;
                }
                return Arrays.equals(h(), (byte[]) b.a(f2));
            } catch (RemoteException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            }
        }
        return false;
    }

    public final a f() {
        return b.a(h());
    }

    /* access modifiers changed from: 0000 */
    public abstract byte[] h();

    public int hashCode() {
        return this.f4784a;
    }
}
