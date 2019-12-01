package io.intercom.android.sdk.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.com.bumptech.glide.f.a.f;
import io.intercom.com.bumptech.glide.f.b.d;
import io.intercom.com.bumptech.glide.f.g;
import io.intercom.com.bumptech.glide.k;
import io.intercom.com.bumptech.glide.load.engine.q;
import io.intercom.com.bumptech.glide.n;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

public class LongTermImageLoader implements Closeable {
    private static final int CACHE_SIZE = 26214400;
    private static final Twig twig = LumberMill.getLogger();
    private final LongTermImageDiskCache diskCache;
    private final Fetcher imageFetcher;

    static class Fetcher {
        final LongTermImageDiskCache diskCache;

        Fetcher(LongTermImageDiskCache longTermImageDiskCache) {
            this.diskCache = longTermImageDiskCache;
        }

        /* access modifiers changed from: 0000 */
        public void fetchImageFromWeb(String str, OnImageReadyListener onImageReadyListener, n nVar) {
            k a2 = nVar.a();
            a2.a(str);
            a2.a(new g().a(q.f9933b));
            final OnImageReadyListener onImageReadyListener2 = onImageReadyListener;
            final String str2 = str;
            AnonymousClass2 r1 = new f<Bitmap>(Integer.MIN_VALUE, Integer.MIN_VALUE) {
                public void onResourceReady(Bitmap bitmap, d<? super Bitmap> dVar) {
                    onImageReadyListener2.onImageReady(bitmap);
                    if (!Fetcher.this.diskCache.isClosed()) {
                        Fetcher.this.diskCache.put(str2, bitmap);
                    }
                }
            };
            a2.a(r1);
        }

        /* access modifiers changed from: 0000 */
        public void loadImageFromFile(String str, File file, OnImageReadyListener onImageReadyListener, n nVar) {
            k a2 = nVar.a();
            a2.a(file);
            a2.a(new g().a(q.f9933b));
            final String str2 = str;
            final OnImageReadyListener onImageReadyListener2 = onImageReadyListener;
            final n nVar2 = nVar;
            AnonymousClass1 r1 = new f<Bitmap>(Integer.MIN_VALUE, Integer.MIN_VALUE) {
                public void onLoadFailed(Drawable drawable) {
                    Fetcher.this.fetchImageFromWeb(str2, onImageReadyListener2, nVar2);
                }

                public void onResourceReady(Bitmap bitmap, d<? super Bitmap> dVar) {
                    onImageReadyListener2.onImageReady(bitmap);
                }
            };
            a2.a(r1);
        }
    }

    public interface OnImageReadyListener {
        public static final OnImageReadyListener NULL = new OnImageReadyListener() {
            public void onImageReady(Bitmap bitmap) {
            }
        };

        void onImageReady(Bitmap bitmap);
    }

    LongTermImageLoader(LongTermImageDiskCache longTermImageDiskCache, Fetcher fetcher) {
        this.diskCache = longTermImageDiskCache;
        this.imageFetcher = fetcher;
    }

    public static LongTermImageLoader newInstance(Context context) {
        File file = new File(context.getCacheDir(), "intercom-glide");
        if (!file.exists() && !file.mkdir()) {
            Twig twig2 = twig;
            StringBuilder sb = new StringBuilder();
            sb.append("Could not create directory: ");
            sb.append(file.getAbsolutePath());
            twig2.e(sb.toString(), new Object[0]);
        }
        LongTermImageDiskCache longTermImageDiskCache = new LongTermImageDiskCache(file, CACHE_SIZE);
        return new LongTermImageLoader(longTermImageDiskCache, new Fetcher(longTermImageDiskCache));
    }

    public void close() throws IOException {
        this.diskCache.close();
    }

    public void loadImage(String str, OnImageReadyListener onImageReadyListener, n nVar) {
        File file = this.diskCache.get(str);
        if (onImageReadyListener == null) {
            onImageReadyListener = OnImageReadyListener.NULL;
        }
        if (file == null || !file.exists()) {
            this.imageFetcher.fetchImageFromWeb(str, onImageReadyListener, nVar);
        } else {
            this.imageFetcher.loadImageFromFile(str, file, onImageReadyListener, nVar);
        }
    }
}
