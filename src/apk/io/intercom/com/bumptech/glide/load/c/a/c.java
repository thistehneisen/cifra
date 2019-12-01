package io.intercom.com.bumptech.glide.load.c.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Log;
import androidx.core.os.b;
import io.intercom.com.bumptech.glide.h.d;
import io.intercom.com.bumptech.glide.load.engine.E;
import io.intercom.com.bumptech.glide.load.i;
import io.intercom.com.bumptech.glide.load.j;
import io.intercom.com.bumptech.glide.load.l;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: BitmapEncoder */
public class c implements l<Bitmap> {

    /* renamed from: a reason: collision with root package name */
    public static final i<Integer> f9582a = i.a("io.intercom.com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", Integer.valueOf(90));

    /* renamed from: b reason: collision with root package name */
    public static final i<CompressFormat> f9583b = i.a("io.intercom.com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    /* JADX WARNING: Can't wrap try/catch for region: R(4:15|(2:34|35)|36|37) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x00ca */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006a A[Catch:{ all -> 0x0060 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0071 A[SYNTHETIC, Splitter:B:23:0x0071] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007b A[Catch:{ all -> 0x00cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c7 A[SYNTHETIC, Splitter:B:34:0x00c7] */
    public boolean a(E<Bitmap> e2, File file, j jVar) {
        String str = "BitmapEncoder";
        Bitmap bitmap = (Bitmap) e2.get();
        CompressFormat a2 = a(bitmap, jVar);
        StringBuilder sb = new StringBuilder();
        sb.append("encode: [");
        sb.append(bitmap.getWidth());
        sb.append("x");
        sb.append(bitmap.getHeight());
        sb.append("] ");
        sb.append(a2);
        b.a(sb.toString());
        try {
            long a3 = d.a();
            int intValue = ((Integer) jVar.a(f9582a)).intValue();
            boolean z = false;
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    bitmap.compress(a2, intValue, fileOutputStream2);
                    fileOutputStream2.close();
                    z = true;
                } catch (IOException e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    try {
                        if (Log.isLoggable(str, 3)) {
                        }
                        if (fileOutputStream != null) {
                        }
                        if (Log.isLoggable(str, 2)) {
                        }
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
                try {
                    fileOutputStream2.close();
                } catch (IOException unused) {
                }
            } catch (IOException e4) {
                e = e4;
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Failed to encode Bitmap", e);
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (Log.isLoggable(str, 2)) {
                }
                return z;
            }
            if (Log.isLoggable(str, 2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Compressed with type: ");
                sb2.append(a2);
                sb2.append(" of size ");
                sb2.append(io.intercom.com.bumptech.glide.h.j.a(bitmap));
                sb2.append(" in ");
                sb2.append(d.a(a3));
                sb2.append(", options format: ");
                sb2.append(jVar.a(f9583b));
                sb2.append(", hasAlpha: ");
                sb2.append(bitmap.hasAlpha());
                Log.v(str, sb2.toString());
            }
            return z;
        } finally {
            b.a();
        }
    }

    private CompressFormat a(Bitmap bitmap, j jVar) {
        CompressFormat compressFormat = (CompressFormat) jVar.a(f9583b);
        if (compressFormat != null) {
            return compressFormat;
        }
        if (bitmap.hasAlpha()) {
            return CompressFormat.PNG;
        }
        return CompressFormat.JPEG;
    }

    public io.intercom.com.bumptech.glide.load.c a(j jVar) {
        return io.intercom.com.bumptech.glide.load.c.TRANSFORMED;
    }
}
