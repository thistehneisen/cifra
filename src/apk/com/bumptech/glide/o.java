package com.bumptech.glide;

import com.bumptech.glide.f.b.a;
import com.bumptech.glide.f.b.c;
import com.bumptech.glide.o;

/* compiled from: TransitionOptions */
public abstract class o<CHILD extends o<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: a reason: collision with root package name */
    private c<? super TranscodeType> f4152a = a.a();

    /* access modifiers changed from: 0000 */
    public final c<? super TranscodeType> a() {
        return this.f4152a;
    }

    public final CHILD clone() {
        try {
            return (o) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }
}
