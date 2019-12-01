package com.bumptech.glide.load.c.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Log;
import com.bumptech.glide.h.a.e;
import com.bumptech.glide.h.n;
import com.bumptech.glide.load.engine.G;
import com.bumptech.glide.load.engine.a.b;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.k;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: BitmapEncoder */
public class c implements k<Bitmap> {

    /* renamed from: a reason: collision with root package name */
    public static final h<Integer> f3720a = h.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", Integer.valueOf(90));

    /* renamed from: b reason: collision with root package name */
    public static final h<CompressFormat> f3721b = h.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    /* renamed from: c reason: collision with root package name */
    private final b f3722c;

    public c(b bVar) {
        this.f3722c = bVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:21|(2:38|39)|40|41) */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0066, code lost:
        if (r6 == null) goto L_0x0069;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x00bf */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0061 A[Catch:{ all -> 0x0057 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bc A[SYNTHETIC, Splitter:B:38:0x00bc] */
    public boolean a(G<Bitmap> g2, File file, i iVar) {
        String str = "BitmapEncoder";
        Bitmap bitmap = (Bitmap) g2.get();
        CompressFormat a2 = a(bitmap, iVar);
        e.a("encode: [%dx%d] %s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), a2);
        try {
            long a3 = com.bumptech.glide.h.h.a();
            int intValue = ((Integer) iVar.a(f3720a)).intValue();
            boolean z = false;
            OutputStream outputStream = null;
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    outputStream = this.f3722c != null ? new com.bumptech.glide.load.a.c(fileOutputStream, this.f3722c) : fileOutputStream;
                    bitmap.compress(a2, intValue, outputStream);
                    outputStream.close();
                    z = true;
                } catch (IOException e2) {
                    e = e2;
                    outputStream = fileOutputStream;
                    try {
                        if (Log.isLoggable(str, 3)) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = fileOutputStream;
                    if (outputStream != null) {
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Failed to encode Bitmap", e);
                }
            }
            try {
                outputStream.close();
            } catch (IOException unused) {
            }
            if (Log.isLoggable(str, 2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Compressed with type: ");
                sb.append(a2);
                sb.append(" of size ");
                sb.append(n.a(bitmap));
                sb.append(" in ");
                sb.append(com.bumptech.glide.h.h.a(a3));
                sb.append(", options format: ");
                sb.append(iVar.a(f3721b));
                sb.append(", hasAlpha: ");
                sb.append(bitmap.hasAlpha());
                Log.v(str, sb.toString());
            }
            return z;
        } finally {
            e.a();
        }
    }

    private CompressFormat a(Bitmap bitmap, i iVar) {
        CompressFormat compressFormat = (CompressFormat) iVar.a(f3721b);
        if (compressFormat != null) {
            return compressFormat;
        }
        if (bitmap.hasAlpha()) {
            return CompressFormat.PNG;
        }
        return CompressFormat.JPEG;
    }

    public com.bumptech.glide.load.c a(i iVar) {
        return com.bumptech.glide.load.c.TRANSFORMED;
    }
}
