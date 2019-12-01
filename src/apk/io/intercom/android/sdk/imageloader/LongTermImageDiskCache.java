package io.intercom.android.sdk.imageloader;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.com.bumptech.glide.a.b;
import io.intercom.com.bumptech.glide.a.b.C0099b;
import io.intercom.com.bumptech.glide.a.b.d;
import io.intercom.com.bumptech.glide.h.e;
import io.intercom.com.bumptech.glide.h.j;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class LongTermImageDiskCache implements Closeable {
    private static final int APP_VERSION = 1;
    private static final int VALUE_COUNT = 1;
    private final File directory;
    private b diskLruCache;
    private final int maxSize;
    private final SafeKeyGenerator safeKeyGenerator;
    private final Twig twig = LumberMill.getLogger();
    private final DiskCacheWriteLocker writeLocker = new DiskCacheWriteLocker();

    private static class DiskCacheWriteLocker {
        private final Map<String, WriteLock> locks = new HashMap();
        private final WriteLockPool writeLockPool = new WriteLockPool();

        private class WriteLock {
            int interestedThreads;
            final Lock lock = new ReentrantLock();

            WriteLock() {
            }
        }

        private class WriteLockPool {
            private static final int MAX_POOL_SIZE = 10;
            private final Queue<WriteLock> pool = new ArrayDeque();

            WriteLockPool() {
            }

            /* access modifiers changed from: 0000 */
            public WriteLock obtain() {
                WriteLock writeLock;
                synchronized (this.pool) {
                    writeLock = (WriteLock) this.pool.poll();
                }
                return writeLock == null ? new WriteLock() : writeLock;
            }

            /* access modifiers changed from: 0000 */
            public void offer(WriteLock writeLock) {
                synchronized (this.pool) {
                    if (this.pool.size() < 10) {
                        this.pool.offer(writeLock);
                    }
                }
            }
        }

        DiskCacheWriteLocker() {
        }

        /* access modifiers changed from: 0000 */
        public void acquire(String str) {
            WriteLock writeLock;
            synchronized (this) {
                writeLock = (WriteLock) this.locks.get(str);
                if (writeLock == null) {
                    writeLock = this.writeLockPool.obtain();
                    this.locks.put(str, writeLock);
                }
                writeLock.interestedThreads++;
            }
            writeLock.lock.lock();
        }

        /* access modifiers changed from: 0000 */
        public void release(String str) {
            WriteLock writeLock;
            synchronized (this) {
                writeLock = (WriteLock) this.locks.get(str);
                if (writeLock != null) {
                    if (writeLock.interestedThreads > 0) {
                        int i2 = writeLock.interestedThreads - 1;
                        writeLock.interestedThreads = i2;
                        if (i2 == 0) {
                            WriteLock writeLock2 = (WriteLock) this.locks.remove(str);
                            if (writeLock2.equals(writeLock)) {
                                this.writeLockPool.offer(writeLock2);
                            } else {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Removed the wrong lock, expected to remove: ");
                                sb.append(writeLock);
                                sb.append(", but actually removed: ");
                                sb.append(writeLock2);
                                sb.append(", key: ");
                                sb.append(str);
                                throw new IllegalStateException(sb.toString());
                            }
                        }
                    }
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Cannot release a lock that is not held, key: ");
                sb2.append(str);
                sb2.append(", interestedThreads: ");
                sb2.append(writeLock == null ? 0 : writeLock.interestedThreads);
                throw new IllegalArgumentException(sb2.toString());
            }
            writeLock.lock.unlock();
        }
    }

    private static class SafeKeyGenerator {
        private final e<String, String> loadIdToSafeHash = new e<>(1000);

        SafeKeyGenerator() {
        }

        public String getSafeKey(String str) {
            String str2;
            synchronized (this.loadIdToSafeHash) {
                str2 = (String) this.loadIdToSafeHash.a(str);
            }
            if (str2 == null) {
                try {
                    MessageDigest instance = MessageDigest.getInstance("SHA-256");
                    instance.update(str.getBytes("UTF-8"));
                    str2 = j.a(instance.digest());
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                } catch (NoSuchAlgorithmException e3) {
                    e3.printStackTrace();
                }
                synchronized (this.loadIdToSafeHash) {
                    this.loadIdToSafeHash.b(str, str2);
                }
            }
            return str2;
        }
    }

    public LongTermImageDiskCache(File file, int i2) {
        this.directory = file;
        this.maxSize = i2;
        this.safeKeyGenerator = new SafeKeyGenerator();
    }

    private synchronized b getDiskCache() throws IOException {
        if (this.diskLruCache == null) {
            this.diskLruCache = b.a(this.directory, 1, 1, (long) this.maxSize);
        }
        return this.diskLruCache;
    }

    private synchronized void resetDiskCache() {
        this.diskLruCache = null;
    }

    public synchronized void clear() {
        try {
            getDiskCache().a();
            resetDiskCache();
        } catch (IOException e2) {
            this.twig.e(e2.getMessage(), new Object[0]);
        }
        return;
    }

    public void close() throws IOException {
        b bVar = this.diskLruCache;
        if (bVar != null) {
            bVar.close();
        }
    }

    public void delete(String str) {
        try {
            getDiskCache().d(this.safeKeyGenerator.getSafeKey(str));
        } catch (IOException e2) {
            this.twig.e(e2.getMessage(), new Object[0]);
        }
    }

    public File get(String str) {
        try {
            d c2 = getDiskCache().c(this.safeKeyGenerator.getSafeKey(str));
            if (c2 != null) {
                return c2.a(0);
            }
            return null;
        } catch (IOException e2) {
            this.twig.e(e2.getMessage(), new Object[0]);
            return null;
        }
    }

    public boolean isClosed() {
        b bVar = this.diskLruCache;
        return bVar == null || bVar.isClosed();
    }

    public void put(String str, Bitmap bitmap) {
        C0099b b2;
        this.writeLocker.acquire(str);
        try {
            String safeKey = this.safeKeyGenerator.getSafeKey(str);
            try {
                b diskCache = getDiskCache();
                if (diskCache.c(safeKey) == null) {
                    b2 = diskCache.b(safeKey);
                    if (b2 != null) {
                        write(b2.a(0), bitmap);
                        b2.c();
                        b2.b();
                        this.writeLocker.release(str);
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Had two simultaneous puts for: ");
                    sb.append(safeKey);
                    throw new IllegalStateException(sb.toString());
                }
            } catch (IOException e2) {
                this.twig.e(e2.getMessage(), new Object[0]);
            } catch (Throwable th) {
                b2.b();
                throw th;
            }
        } finally {
            this.writeLocker.release(str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0036 A[SYNTHETIC, Splitter:B:20:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003c A[SYNTHETIC, Splitter:B:24:0x003c] */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    public void write(File file, Bitmap bitmap) {
        FilterOutputStream filterOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            try {
                bitmap.compress(bitmap.hasAlpha() ? CompressFormat.PNG : CompressFormat.JPEG, 100, bufferedOutputStream);
            } catch (FileNotFoundException e2) {
                e = e2;
                filterOutputStream = bufferedOutputStream;
                try {
                    this.twig.e(e.getMessage(), new Object[0]);
                    if (filterOutputStream == null) {
                    }
                } catch (Throwable th) {
                    th = th;
                    if (filterOutputStream != null) {
                        try {
                            filterOutputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                filterOutputStream = bufferedOutputStream;
                if (filterOutputStream != null) {
                }
                throw th;
            }
            try {
                bufferedOutputStream.close();
            } catch (IOException unused2) {
            }
        } catch (FileNotFoundException e3) {
            e = e3;
            this.twig.e(e.getMessage(), new Object[0]);
            if (filterOutputStream == null) {
                filterOutputStream.close();
            }
        }
    }
}
