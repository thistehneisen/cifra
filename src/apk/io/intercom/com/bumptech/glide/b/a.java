package io.intercom.com.bumptech.glide.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import java.nio.ByteBuffer;

/* compiled from: GifDecoder */
public interface a {

    /* renamed from: io.intercom.com.bumptech.glide.b.a$a reason: collision with other inner class name */
    /* compiled from: GifDecoder */
    public interface C0100a {
        Bitmap a(int i2, int i3, Config config);

        void a(Bitmap bitmap);

        void a(byte[] bArr);

        void a(int[] iArr);

        int[] a(int i2);

        byte[] b(int i2);
    }

    Bitmap a();

    void a(Config config);

    void advance();

    int b();

    int c();

    void clear();

    void d();

    int e();

    int f();

    ByteBuffer getData();
}
