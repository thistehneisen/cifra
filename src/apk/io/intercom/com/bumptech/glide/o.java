package io.intercom.com.bumptech.glide;

import io.intercom.com.bumptech.glide.f.b.c;
import io.intercom.com.bumptech.glide.f.b.e;
import io.intercom.com.bumptech.glide.h.h;
import io.intercom.com.bumptech.glide.o;

/* compiled from: TransitionOptions */
public abstract class o<CHILD extends o<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: a reason: collision with root package name */
    private e<? super TranscodeType> f10010a = c.b();

    private CHILD b() {
        return this;
    }

    public final CHILD a(e<? super TranscodeType> eVar) {
        h.a(eVar);
        this.f10010a = eVar;
        b();
        return this;
    }

    /* access modifiers changed from: protected */
    public final CHILD clone() {
        try {
            return (o) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* access modifiers changed from: 0000 */
    public final e<? super TranscodeType> a() {
        return this.f10010a;
    }
}
