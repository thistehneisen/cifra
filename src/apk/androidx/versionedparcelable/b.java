package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;

/* compiled from: VersionedParcelParcel */
class b extends VersionedParcel {

    /* renamed from: d reason: collision with root package name */
    private final SparseIntArray f2118d;

    /* renamed from: e reason: collision with root package name */
    private final Parcel f2119e;

    /* renamed from: f reason: collision with root package name */
    private final int f2120f;

    /* renamed from: g reason: collision with root package name */
    private final int f2121g;

    /* renamed from: h reason: collision with root package name */
    private final String f2122h;

    /* renamed from: i reason: collision with root package name */
    private int f2123i;

    /* renamed from: j reason: collision with root package name */
    private int f2124j;

    /* renamed from: k reason: collision with root package name */
    private int f2125k;

    b(Parcel parcel) {
        Parcel parcel2 = parcel;
        this(parcel2, parcel.dataPosition(), parcel.dataSize(), "", new b.d.b(), new b.d.b(), new b.d.b());
    }

    public boolean a(int i2) {
        while (true) {
            boolean z = true;
            if (this.f2124j < this.f2121g) {
                int i3 = this.f2125k;
                if (i3 == i2) {
                    return true;
                }
                if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                    return false;
                }
                this.f2119e.setDataPosition(this.f2124j);
                int readInt = this.f2119e.readInt();
                this.f2125k = this.f2119e.readInt();
                this.f2124j += readInt;
            } else {
                if (this.f2125k != i2) {
                    z = false;
                }
                return z;
            }
        }
    }

    public void b(int i2) {
        a();
        this.f2123i = i2;
        this.f2118d.put(i2, this.f2119e.dataPosition());
        c(0);
        c(i2);
    }

    public void c(int i2) {
        this.f2119e.writeInt(i2);
    }

    public boolean d() {
        return this.f2119e.readInt() != 0;
    }

    public byte[] e() {
        int readInt = this.f2119e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f2119e.readByteArray(bArr);
        return bArr;
    }

    /* access modifiers changed from: protected */
    public CharSequence f() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f2119e);
    }

    public int g() {
        return this.f2119e.readInt();
    }

    public <T extends Parcelable> T h() {
        return this.f2119e.readParcelable(b.class.getClassLoader());
    }

    public String i() {
        return this.f2119e.readString();
    }

    private b(Parcel parcel, int i2, int i3, String str, b.d.b<String, Method> bVar, b.d.b<String, Method> bVar2, b.d.b<String, Class> bVar3) {
        super(bVar, bVar2, bVar3);
        this.f2118d = new SparseIntArray();
        this.f2123i = -1;
        this.f2124j = 0;
        this.f2125k = -1;
        this.f2119e = parcel;
        this.f2120f = i2;
        this.f2121g = i3;
        this.f2124j = this.f2120f;
        this.f2122h = str;
    }

    /* access modifiers changed from: protected */
    public VersionedParcel b() {
        Parcel parcel = this.f2119e;
        int dataPosition = parcel.dataPosition();
        int i2 = this.f2124j;
        if (i2 == this.f2120f) {
            i2 = this.f2121g;
        }
        int i3 = i2;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2122h);
        sb.append("  ");
        b bVar = new b(parcel, dataPosition, i3, sb.toString(), this.f2115a, this.f2116b, this.f2117c);
        return bVar;
    }

    public void a() {
        int i2 = this.f2123i;
        if (i2 >= 0) {
            int i3 = this.f2118d.get(i2);
            int dataPosition = this.f2119e.dataPosition();
            int i4 = dataPosition - i3;
            this.f2119e.setDataPosition(i3);
            this.f2119e.writeInt(i4);
            this.f2119e.setDataPosition(dataPosition);
        }
    }

    public void a(byte[] bArr) {
        if (bArr != null) {
            this.f2119e.writeInt(bArr.length);
            this.f2119e.writeByteArray(bArr);
            return;
        }
        this.f2119e.writeInt(-1);
    }

    public void a(String str) {
        this.f2119e.writeString(str);
    }

    public void a(Parcelable parcelable) {
        this.f2119e.writeParcelable(parcelable, 0);
    }

    public void a(boolean z) {
        this.f2119e.writeInt(z ? 1 : 0);
    }

    /* access modifiers changed from: protected */
    public void a(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f2119e, 0);
    }
}
