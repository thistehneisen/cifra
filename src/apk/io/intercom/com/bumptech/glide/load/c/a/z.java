package io.intercom.com.bumptech.glide.load.c.a;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import io.intercom.com.bumptech.glide.load.engine.E;
import io.intercom.com.bumptech.glide.load.engine.a.e;
import io.intercom.com.bumptech.glide.load.i;
import io.intercom.com.bumptech.glide.load.j;
import io.intercom.com.bumptech.glide.load.k;
import java.io.IOException;

/* compiled from: VideoBitmapDecoder */
public class z implements k<ParcelFileDescriptor, Bitmap> {

    /* renamed from: a reason: collision with root package name */
    public static final i<Long> f9645a = i.a("io.intercom.com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", Long.valueOf(-1), new x());

    /* renamed from: b reason: collision with root package name */
    public static final i<Integer> f9646b = i.a("io.intercom.com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", null, new y());

    /* renamed from: c reason: collision with root package name */
    private static final a f9647c = new a();

    /* renamed from: d reason: collision with root package name */
    private final e f9648d;

    /* renamed from: e reason: collision with root package name */
    private final a f9649e;

    /* compiled from: VideoBitmapDecoder */
    static class a {
        a() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    public z(e eVar) {
        this(eVar, f9647c);
    }

    public boolean a(ParcelFileDescriptor parcelFileDescriptor, j jVar) {
        return true;
    }

    z(e eVar, a aVar) {
        this.f9648d = eVar;
        this.f9649e = aVar;
    }

    public E<Bitmap> a(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, j jVar) throws IOException {
        Bitmap bitmap;
        long longValue = ((Long) jVar.a(f9645a)).longValue();
        if (longValue >= 0 || longValue == -1) {
            Integer num = (Integer) jVar.a(f9646b);
            MediaMetadataRetriever a2 = this.f9649e.a();
            try {
                a2.setDataSource(parcelFileDescriptor.getFileDescriptor());
                if (longValue == -1) {
                    bitmap = a2.getFrameAtTime();
                } else if (num == null) {
                    bitmap = a2.getFrameAtTime(longValue);
                } else {
                    bitmap = a2.getFrameAtTime(longValue, num.intValue());
                }
                a2.release();
                parcelFileDescriptor.close();
                return d.a(bitmap, this.f9648d);
            } catch (RuntimeException e2) {
                throw new IOException(e2);
            } catch (Throwable th) {
                a2.release();
                throw th;
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested frame must be non-negative, or DEFAULT_FRAME, given: ");
            sb.append(longValue);
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
