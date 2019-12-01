package io.intercom.com.bumptech.glide.load.c.a;

import io.intercom.com.bumptech.glide.load.i.a;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: VideoBitmapDecoder */
class x implements a<Long> {

    /* renamed from: a reason: collision with root package name */
    private final ByteBuffer f9643a = ByteBuffer.allocate(8);

    x() {
    }

    public void a(byte[] bArr, Long l2, MessageDigest messageDigest) {
        messageDigest.update(bArr);
        synchronized (this.f9643a) {
            this.f9643a.position(0);
            messageDigest.update(this.f9643a.putLong(l2.longValue()).array());
        }
    }
}
