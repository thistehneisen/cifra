package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class q extends o {

    /* renamed from: b reason: collision with root package name */
    private static final WeakReference<byte[]> f4786b = new WeakReference<>(null);

    /* renamed from: c reason: collision with root package name */
    private WeakReference<byte[]> f4787c = f4786b;

    q(byte[] bArr) {
        super(bArr);
    }

    /* access modifiers changed from: 0000 */
    public final byte[] h() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.f4787c.get();
            if (bArr == null) {
                bArr = i();
                this.f4787c = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }

    /* access modifiers changed from: protected */
    public abstract byte[] i();
}
