package com.bumptech.glide.load.c.e;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.engine.G;
import com.bumptech.glide.load.engine.a.b;
import com.bumptech.glide.load.i;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: StreamGifDecoder */
public class j implements com.bumptech.glide.load.j<InputStream, c> {

    /* renamed from: a reason: collision with root package name */
    private final List<ImageHeaderParser> f3835a;

    /* renamed from: b reason: collision with root package name */
    private final com.bumptech.glide.load.j<ByteBuffer, c> f3836b;

    /* renamed from: c reason: collision with root package name */
    private final b f3837c;

    public j(List<ImageHeaderParser> list, com.bumptech.glide.load.j<ByteBuffer, c> jVar, b bVar) {
        this.f3835a = list;
        this.f3836b = jVar;
        this.f3837c = bVar;
    }

    public boolean a(InputStream inputStream, i iVar) throws IOException {
        return !((Boolean) iVar.a(i.f3834b)).booleanValue() && e.b(this.f3835a, inputStream, this.f3837c) == ImageType.GIF;
    }

    public G<c> a(InputStream inputStream, int i2, int i3, i iVar) throws IOException {
        byte[] a2 = a(inputStream);
        if (a2 == null) {
            return null;
        }
        return this.f3836b.a(ByteBuffer.wrap(a2), i2, i3, iVar);
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
