package io.intercom.com.bumptech.glide.load.b;

import android.util.Log;
import io.intercom.com.bumptech.glide.h.a;
import io.intercom.com.bumptech.glide.load.d;
import io.intercom.com.bumptech.glide.load.j;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: io.intercom.com.bumptech.glide.load.b.e reason: case insensitive filesystem */
/* compiled from: ByteBufferEncoder */
public class C0741e implements d<ByteBuffer> {
    public boolean a(ByteBuffer byteBuffer, File file, j jVar) {
        try {
            a.a(byteBuffer, file);
            return true;
        } catch (IOException e2) {
            String str = "ByteBufferEncoder";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Failed to write data", e2);
            }
            return false;
        }
    }
}
