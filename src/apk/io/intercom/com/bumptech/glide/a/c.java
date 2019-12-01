package io.intercom.com.bumptech.glide.a;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: StrictLineReader */
class c extends ByteArrayOutputStream {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ d f9162a;

    c(d dVar, int i2) {
        this.f9162a = dVar;
        super(i2);
    }

    public String toString() {
        int i2 = this.count;
        try {
            return new String(this.buf, 0, (i2 <= 0 || this.buf[i2 + -1] != 13) ? this.count : i2 - 1, this.f9162a.f9164b.name());
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }
}
