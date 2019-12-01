package h.a.a.a;

import android.content.Context;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.f.b;
import org.joda.time.f.f;
import org.joda.time.g;

/* compiled from: ResourceZoneInfoProvider */
public class d implements f {

    /* renamed from: a reason: collision with root package name */
    private Context f8418a;

    /* renamed from: b reason: collision with root package name */
    private final Map<String, Object> f8419b;

    public d(Context context) throws IOException {
        if (context != null) {
            this.f8418a = context.getApplicationContext();
            this.f8419b = a(c("ZoneInfoMap"));
            return;
        }
        throw new IllegalArgumentException("Context must not be null");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x002c A[SYNTHETIC, Splitter:B:19:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0032 A[SYNTHETIC, Splitter:B:24:0x0032] */
    private g b(String str) {
        InputStream inputStream;
        try {
            inputStream = c(str);
            try {
                g a2 = b.a(inputStream, str);
                this.f8419b.put(str, new SoftReference(a2));
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
                    this.f8419b.remove(str);
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
            this.f8419b.remove(str);
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
        if (this.f8418a != null) {
            String a2 = c.a(str);
            int a3 = c.a(b.class, a2);
            if (a3 != 0) {
                return this.f8418a.getResources().openRawResource(a3);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Resource not found: \"");
            sb.append(str);
            sb.append("\" (resName: \"");
            sb.append(a2);
            sb.append("\")");
            throw new IOException(sb.toString());
        }
        throw new RuntimeException("Need to call JodaTimeAndroid.init() before using joda-time-android");
    }

    public g a(String str) {
        if (str == null) {
            return null;
        }
        Object obj = this.f8419b.get(str);
        if (obj == null) {
            return null;
        }
        if (str.equals(obj)) {
            return b(str);
        }
        if (!(obj instanceof SoftReference)) {
            return a((String) obj);
        }
        g gVar = (g) ((SoftReference) obj).get();
        if (gVar != null) {
            return gVar;
        }
        return b(str);
    }

    public Set<String> a() {
        return new TreeSet(this.f8419b.keySet());
    }

    /* access modifiers changed from: protected */
    public void a(Exception exc) {
        exc.printStackTrace();
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
