package com.bumptech.glide.load.c.a;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.engine.G;
import com.bumptech.glide.load.engine.a.e;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;
import java.io.IOException;

/* compiled from: VideoDecoder */
public class A<T> implements j<T, Bitmap> {

    /* renamed from: a reason: collision with root package name */
    public static final h<Long> f3710a = h.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", Long.valueOf(-1), new y());

    /* renamed from: b reason: collision with root package name */
    public static final h<Integer> f3711b = h.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", Integer.valueOf(2), new z());

    /* renamed from: c reason: collision with root package name */
    private static final b f3712c = new b();

    /* renamed from: d reason: collision with root package name */
    private final c<T> f3713d;

    /* renamed from: e reason: collision with root package name */
    private final e f3714e;

    /* renamed from: f reason: collision with root package name */
    private final b f3715f;

    /* compiled from: VideoDecoder */
    private static final class a implements c<AssetFileDescriptor> {
        private a() {
        }

        /* synthetic */ a(y yVar) {
            this();
        }

        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    /* compiled from: VideoDecoder */
    static class b {
        b() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    /* compiled from: VideoDecoder */
    interface c<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    /* compiled from: VideoDecoder */
    static final class d implements c<ParcelFileDescriptor> {
        d() {
        }

        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    A(e eVar, c<T> cVar) {
        this(eVar, cVar, f3712c);
    }

    public static j<AssetFileDescriptor, Bitmap> a(e eVar) {
        return new A(eVar, new a(null));
    }

    public static j<ParcelFileDescriptor, Bitmap> b(e eVar) {
        return new A(eVar, new d());
    }

    public boolean a(T t, i iVar) {
        return true;
    }

    A(e eVar, c<T> cVar, b bVar) {
        this.f3714e = eVar;
        this.f3713d = cVar;
        this.f3715f = bVar;
    }

    @TargetApi(27)
    private static Bitmap b(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2, int i3, int i4, j jVar) {
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                int i5 = parseInt2;
                parseInt2 = parseInt;
                parseInt = i5;
            }
            float b2 = jVar.b(parseInt, parseInt2, i3, i4);
            return mediaMetadataRetriever.getScaledFrameAtTime(j2, i2, Math.round(((float) parseInt) * b2), Math.round(b2 * ((float) parseInt2)));
        } catch (Throwable th) {
            String str = "VideoDecoder";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Exception trying to decode frame on oreo+", th);
            }
            return null;
        }
    }

    public G<Bitmap> a(T t, int i2, int i3, i iVar) throws IOException {
        long longValue = ((Long) iVar.a(f3710a)).longValue();
        if (longValue >= 0 || longValue == -1) {
            Integer num = (Integer) iVar.a(f3711b);
            if (num == null) {
                num = Integer.valueOf(2);
            }
            j jVar = (j) iVar.a(j.f3740h);
            if (jVar == null) {
                jVar = j.f3739g;
            }
            j jVar2 = jVar;
            MediaMetadataRetriever a2 = this.f3715f.a();
            try {
                this.f3713d.a(a2, t);
                Bitmap a3 = a(a2, longValue, num.intValue(), i2, i3, jVar2);
                a2.release();
                return d.a(a3, this.f3714e);
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

    private static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2, int i3, int i4, j jVar) {
        Bitmap b2 = (VERSION.SDK_INT < 27 || i3 == Integer.MIN_VALUE || i4 == Integer.MIN_VALUE || jVar == j.f3738f) ? null : b(mediaMetadataRetriever, j2, i2, i3, i4, jVar);
        return b2 == null ? a(mediaMetadataRetriever, j2, i2) : b2;
    }

    private static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2) {
        return mediaMetadataRetriever.getFrameAtTime(j2, i2);
    }
}
