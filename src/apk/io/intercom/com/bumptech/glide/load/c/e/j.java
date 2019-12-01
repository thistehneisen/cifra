package io.intercom.com.bumptech.glide.load.c.e;

import android.util.Log;
import io.intercom.com.bumptech.glide.load.e;
import io.intercom.com.bumptech.glide.load.e.a;
import io.intercom.com.bumptech.glide.load.engine.E;
import io.intercom.com.bumptech.glide.load.engine.a.b;
import io.intercom.com.bumptech.glide.load.f;
import io.intercom.com.bumptech.glide.load.k;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: StreamGifDecoder */
public class j implements k<InputStream, c> {

    /* renamed from: a reason: collision with root package name */
    private final List<e> f9698a;

    /* renamed from: b reason: collision with root package name */
    private final k<ByteBuffer, c> f9699b;

    /* renamed from: c reason: collision with root package name */
    private final b f9700c;

    public j(List<e> list, k<ByteBuffer, c> kVar, b bVar) {
        this.f9698a = list;
        this.f9699b = kVar;
        this.f9700c = bVar;
    }

    public boolean a(InputStream inputStream, io.intercom.com.bumptech.glide.load.j jVar) throws IOException {
        return !((Boolean) jVar.a(i.f9697b)).booleanValue() && f.b(this.f9698a, inputStream, this.f9700c) == a.GIF;
    }

    public E<c> a(InputStream inputStream, int i2, int i3, io.intercom.com.bumptech.glide.load.j jVar) throws IOException {
        byte[] a2 = a(inputStream);
        if (a2 == null) {
            return null;
        }
        return this.f9699b.a(ByteBuffer.wrap(a2), i2, i3, jVar);
    }

    private static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e2) {
            String str = "StreamGifDecoder";
            if (Log.isLoggable(str, 5)) {
                Log.w(str, "Error reading data from stream", e2);
            }
            return null;
        }
    }
}
