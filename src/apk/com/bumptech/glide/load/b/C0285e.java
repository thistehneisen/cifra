package com.bumptech.glide.load.b;

import android.util.Log;
import com.bumptech.glide.h.a;
import com.bumptech.glide.load.d;
import com.bumptech.glide.load.i;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.load.b.e reason: case insensitive filesystem */
/* compiled from: ByteBufferEncoder */
public class C0285e implements d<ByteBuffer> {
    public boolean a(ByteBuffer byteBuffer, File file, i iVar) {
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
