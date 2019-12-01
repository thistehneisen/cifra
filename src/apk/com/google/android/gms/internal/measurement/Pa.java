package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.Na;
import com.google.android.gms.internal.measurement.Pa;

public abstract class Pa<MessageType extends Na<MessageType, BuilderType>, BuilderType extends Pa<MessageType, BuilderType>> implements C0394lc {
    /* access modifiers changed from: protected */
    public abstract BuilderType a(MessageType messagetype);

    public abstract BuilderType a(byte[] bArr, int i2, int i3, C0428rb rbVar) throws zzfi;

    public final BuilderType a(byte[] bArr, C0428rb rbVar) throws zzfi {
        a(bArr, 0, bArr.length, rbVar);
        return this;
    }

    public final /* synthetic */ C0394lc a(C0400mc mcVar) {
        if (a().getClass().isInstance(mcVar)) {
            a((MessageType) (Na) mcVar);
            return this;
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
