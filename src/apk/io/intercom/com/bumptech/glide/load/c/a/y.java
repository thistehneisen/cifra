package io.intercom.com.bumptech.glide.load.c.a;

import io.intercom.com.bumptech.glide.load.i.a;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: VideoBitmapDecoder */
class y implements a<Integer> {

    /* renamed from: a reason: collision with root package name */
    private final ByteBuffer f9644a = ByteBuffer.allocate(4);

    y() {
    }

    public void a(byte[] bArr, Integer num, MessageDigest messageDigest) {
        if (num != null) {
            messageDigest.update(bArr);
            synchronized (this.f9644a) {
                this.f9644a.position(0);
                messageDigest.update(this.f9644a.putInt(num.intValue()).array());
            }
        }
    }
}
