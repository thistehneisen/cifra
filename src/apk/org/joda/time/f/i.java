package org.joda.time.f;

import com.appsflyer.share.Constants;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.security.AccessController;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.g;

/* compiled from: ZoneInfoProvider */
public class i implements f {

    /* renamed from: a reason: collision with root package name */
    private final File f10933a;

    /* renamed from: b reason: collision with root package name */
    private final String f10934b;
    /* access modifiers changed from: private */

    /* renamed from: c reason: collision with root package name */
    public final ClassLoader f10935c;

    /* renamed from: d reason: collision with root package name */
    private final Map<String, Object> f10936d;

    /* renamed from: e reason: collision with root package name */
    private final Set<String> f10937e;

    public i(File file) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("No file directory provided");
        } else if (!file.exists()) {
            StringBuilder sb = new StringBuilder();
            sb.append("File directory doesn't exist: ");
            sb.append(file);
            throw new IOException(sb.toString());
        } else if (file.isDirectory()) {
            this.f10933a = file;
            this.f10934b = null;
            this.f10935c = null;
            this.f10936d = a(c("ZoneInfoMap"));
            this.f10937e = Collections.unmodifiableSortedSet(new TreeSet(this.f10936d.keySet()));
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("File doesn't refer to a directory: ");
            sb2.append(file);
            throw new IOException(sb2.toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x002c A[SYNTHETIC, Splitter:B:19:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0032 A[SYNTHETIC, Splitter:B:24:0x0032] */
    private g b(String str) {
        InputStream inputStream;
        try {
            inputStream = c(str);
            try {
                g a2 = b.a(inputStream, str);
                this.f10936d.put(str, new SoftReference(a2));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return a2;
            } catch (IOException e2) {
                e = e2;
                try {
                    a((Exception) e);
                    this.f10936d.remove(str);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
            a((Exception) e);
            this.f10936d.remove(str);
            if (inputStream != null) {
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            if (inputStream != null) {
            }
            throw th;
        }
    }

    private InputStream c(String str) throws IOException {
        File file = this.f10933a;
        if (file != null) {
            return new FileInputStream(new File(file, str));
        }
        String concat = this.f10934b.concat(str);
        InputStream inputStream = (InputStream) AccessController.doPrivileged(new h(this, concat));
        if (inputStream != null) {
            return inputStream;
        }
        StringBuilder sb = new StringBuilder(40);
        sb.append("Resource not found: \"");
        sb.append(concat);
        sb.append("\" ClassLoader: ");
        ClassLoader classLoader = this.f10935c;
        sb.append(classLoader != null ? classLoader.toString() : "system");
        throw new IOException(sb.toString());
    }

    public g a(String str) {
        if (str == null) {
            return null;
        }
        Object obj = this.f10936d.get(str);
        if (obj == null) {
            return null;
        }
        if (obj instanceof SoftReference) {
            g gVar = (g) ((SoftReference) obj).get();
            if (gVar != null) {
                return gVar;
            }
            return b(str);
        } else if (str.equals(obj)) {
            return b(str);
        } else {
            return a((String) obj);
        }
    }

    public Set<String> a() {
        return this.f10937e;
    }

    /* access modifiers changed from: protected */
    public void a(Exception exc) {
        exc.printStackTrace();
    }

    public i(String str) throws IOException {
        this(str, null, false);
    }

    private static Map<String, Object> a(InputStream inputStream) throws IOException {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        try {
            a(dataInputStream, concurrentHashMap);
            concurrentHashMap.put("UTC", new SoftReference(g.f10938a));
            return concurrentHashMap;
        } finally {
            try {
                dataInputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    private i(String str, ClassLoader classLoader, boolean z) throws IOException {
        if (str != null) {
            if (!str.endsWith(Constants.URL_PATH_DELIMITER)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append('/');
                str = sb.toString();
            }
            this.f10933a = null;
            this.f10934b = str;
            if (classLoader == null && !z) {
                classLoader = i.class.getClassLoader();
            }
            this.f10935c = classLoader;
            this.f10936d = a(c("ZoneInfoMap"));
            this.f10937e = Collections.unmodifiableSortedSet(new TreeSet(this.f10936d.keySet()));
            return;
        }
        throw new IllegalArgumentException("No resource path provided");
    }

    private static void a(DataInputStream dataInputStream, Map<String, Object> map) throws IOException {
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        String[] strArr = new String[readUnsignedShort];
        int i2 = 0;
        for (int i3 = 0; i3 < readUnsignedShort; i3++) {
            strArr[i3] = dataInputStream.readUTF().intern();
        }
        int readUnsignedShort2 = dataInputStream.readUnsignedShort();
        while (i2 < readUnsignedShort2) {
            try {
                map.put(strArr[dataInputStream.readUnsignedShort()], strArr[dataInputStream.readUnsignedShort()]);
                i2++;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new IOException("Corrupt zone info map");
            }
        }
    }
}
