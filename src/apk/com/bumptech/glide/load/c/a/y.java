package com.bumptech.glide.load.c.a;

import com.bumptech.glide.load.h.a;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: VideoDecoder */
class y implements a<Long> {

    /* renamed from: a reason: collision with root package name */
    private final ByteBuffer f3784a = ByteBuffer.allocate(8);

    y() {
    }

    public void a(byte[] bArr, Long l2, MessageDigest messageDigest) {
        messageDigest.update(bArr);
        synchronized (this.f3784a) {
            this.f3784a.position(0);
            messageDigest.update(this.f3784a.putLong(l2.longValue()).array());
        }
    }
}
