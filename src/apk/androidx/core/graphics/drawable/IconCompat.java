package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: a reason: collision with root package name */
    static final Mode f1302a = Mode.SRC_IN;

    /* renamed from: b reason: collision with root package name */
    public int f1303b = -1;

    /* renamed from: c reason: collision with root package name */
    Object f1304c;

    /* renamed from: d reason: collision with root package name */
    public byte[] f1305d = null;

    /* renamed from: e reason: collision with root package name */
    public Parcelable f1306e = null;

    /* renamed from: f reason: collision with root package name */
    public int f1307f = 0;

    /* renamed from: g reason: collision with root package name */
    public int f1308g = 0;

    /* renamed from: h reason: collision with root package name */
    public ColorStateList f1309h = null;

    /* renamed from: i reason: collision with root package name */
    Mode f1310i = f1302a;

    /* renamed from: j reason: collision with root package name */
    public String f1311j = null;

    private static String a(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "UNKNOWN" : "BITMAP_MASKABLE" : "URI" : "DATA" : "RESOURCE" : "BITMAP";
    }

    public int a() {
        if (this.f1303b == -1 && VERSION.SDK_INT >= 23) {
            return a((Icon) this.f1304c);
        }
        if (this.f1303b == 2) {
            return this.f1307f;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("called getResId() on ");
        sb.append(this);
        throw new IllegalStateException(sb.toString());
    }

    public String b() {
        if (this.f1303b == -1 && VERSION.SDK_INT >= 23) {
            return b((Icon) this.f1304c);
        }
        if (this.f1303b == 2) {
            return ((String) this.f1304c).split(":", -1)[0];
        }
        StringBuilder sb = new StringBuilder();
        sb.append("called getResPackage() on ");
        sb.append(this);
        throw new IllegalStateException(sb.toString());
    }

    public void c() {
        this.f1310i = Mode.valueOf(this.f1311j);
        int i2 = this.f1303b;
        if (i2 != -1) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        this.f1304c = this.f1305d;
                        return;
                    } else if (i2 != 4) {
                        if (i2 != 5) {
                            return;
                        }
                    }
                }
                this.f1304c = new String(this.f1305d, Charset.forName("UTF-16"));
                return;
            }
            Parcelable parcelable = this.f1306e;
            if (parcelable != null) {
                this.f1304c = parcelable;
                return;
            }
            byte[] bArr = this.f1305d;
            this.f1304c = bArr;
            this.f1303b = 3;
            this.f1307f = 0;
            this.f1308g = bArr.length;
            return;
        }
        Parcelable parcelable2 = this.f1306e;
        if (parcelable2 != null) {
            this.f1304c = parcelable2;
            return;
        }
        throw new IllegalArgumentException("Invalid icon");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        if (r1 != 5) goto L_0x009a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ae  */
    public String toString() {
        if (this.f1303b == -1) {
            return String.valueOf(this.f1304c);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(a(this.f1303b));
        int i2 = this.f1303b;
        if (i2 != 1) {
            if (i2 == 2) {
                sb.append(" pkg=");
                sb.append(b());
                sb.append(" id=");
                sb.append(String.format("0x%08x", new Object[]{Integer.valueOf(a())}));
            } else if (i2 == 3) {
                sb.append(" len=");
                sb.append(this.f1307f);
                if (this.f1308g != 0) {
                    sb.append(" off=");
                    sb.append(this.f1308g);
                }
            } else if (i2 == 4) {
                sb.append(" uri=");
                sb.append(this.f1304c);
            }
            if (this.f1309h != null) {
                sb.append(" tint=");
                sb.append(this.f1309h);
            }
            if (this.f1310i != f1302a) {
                sb.append(" mode=");
                sb.append(this.f1310i);
            }
            sb.append(")");
            return sb.toString();
        }
        sb.append(" size=");
        sb.append(((Bitmap) this.f1304c).getWidth());
        sb.append("x");
        sb.append(((Bitmap) this.f1304c).getHeight());
        if (this.f1309h != null) {
        }
        if (this.f1310i != f1302a) {
        }
        sb.append(")");
        return sb.toString();
    }

    private static String b(Icon icon) {
        String str = "Unable to get icon package";
        String str2 = "IconCompat";
        if (VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e2) {
            Log.e(str2, str, e2);
            return null;
        } catch (InvocationTargetException e3) {
            Log.e(str2, str, e3);
            return null;
        } catch (NoSuchMethodException e4) {
            Log.e(str2, str, e4);
            return null;
        }
    }

    public void a(boolean z) {
        this.f1311j = this.f1310i.name();
        int i2 = this.f1303b;
        if (i2 != -1) {
            if (i2 != 1) {
                String str = "UTF-16";
                if (i2 == 2) {
                    this.f1305d = ((String) this.f1304c).getBytes(Charset.forName(str));
                    return;
                } else if (i2 == 3) {
                    this.f1305d = (byte[]) this.f1304c;
                    return;
                } else if (i2 == 4) {
                    this.f1305d = this.f1304c.toString().getBytes(Charset.forName(str));
                    return;
                } else if (i2 != 5) {
                    return;
                }
            }
            if (z) {
                Bitmap bitmap = (Bitmap) this.f1304c;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(CompressFormat.PNG, 90, byteArrayOutputStream);
                this.f1305d = byteArrayOutputStream.toByteArray();
                return;
            }
            this.f1306e = (Parcelable) this.f1304c;
        } else if (!z) {
            this.f1306e = (Parcelable) this.f1304c;
        } else {
            throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
        }
    }

    private static int a(Icon icon) {
        String str = "Unable to get icon resource";
        String str2 = "IconCompat";
        if (VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e2) {
            Log.e(str2, str, e2);
            return 0;
        } catch (InvocationTargetException e3) {
            Log.e(str2, str, e3);
            return 0;
        } catch (NoSuchMethodException e4) {
            Log.e(str2, str, e4);
            return 0;
        }
    }
}
