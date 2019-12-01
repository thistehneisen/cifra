package com.bumptech.glide.load.c.a;

import com.bumptech.glide.load.h.a;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: VideoDecoder */
class z implements a<Integer> {

    /* renamed from: a reason: collision with root package name */
    private final ByteBuffer f3785a = ByteBuffer.allocate(4);

    z() {
    }

    public void a(byte[] bArr, Integer num, MessageDigest messageDigest) {
        if (num != null) {
            messageDigest.update(bArr);
            synchronized (this.f3785a) {
                this.f3785a.position(0);
                messageDigest.update(this.f3785a.putInt(num.intValue()).array());
            }
        }
    }
}
