package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.h.b;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* renamed from: androidx.fragment.app.c reason: case insensitive filesystem */
/* compiled from: BackStackState */
final class C0188c implements Parcelable {
    public static final Creator<C0188c> CREATOR = new C0187b();

    /* renamed from: a reason: collision with root package name */
    final int[] f1509a;

    /* renamed from: b reason: collision with root package name */
    final ArrayList<String> f1510b;

    /* renamed from: c reason: collision with root package name */
    final int[] f1511c;

    /* renamed from: d reason: collision with root package name */
    final int[] f1512d;

    /* renamed from: e reason: collision with root package name */
    final int f1513e;

    /* renamed from: f reason: collision with root package name */
    final int f1514f;

    /* renamed from: g reason: collision with root package name */
    final String f1515g;

    /* renamed from: h reason: collision with root package name */
    final int f1516h;

    /* renamed from: i reason: collision with root package name */
    final int f1517i;

    /* renamed from: j reason: collision with root package name */
    final CharSequence f1518j;

    /* renamed from: k reason: collision with root package name */
    final int f1519k;

    /* renamed from: l reason: collision with root package name */
    final CharSequence f1520l;
    final ArrayList<String> m;
    final ArrayList<String> n;
    final boolean o;

    public C0188c(C0186a aVar) {
        int size = aVar.f1411a.size();
        this.f1509a = new int[(size * 5)];
        if (aVar.f1418h) {
            this.f1510b = new ArrayList<>(size);
            this.f1511c = new int[size];
            this.f1512d = new int[size];
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                a aVar2 = (a) aVar.f1411a.get(i2);
                int i4 = i3 + 1;
                this.f1509a[i3] = aVar2.f1423a;
                ArrayList<String> arrayList = this.f1510b;
                Fragment fragment = aVar2.f1424b;
                arrayList.add(fragment != null ? fragment.mWho : null);
                int[] iArr = this.f1509a;
                int i5 = i4 + 1;
                iArr[i4] = aVar2.f1425c;
                int i6 = i5 + 1;
                iArr[i5] = aVar2.f1426d;
                int i7 = i6 + 1;
                iArr[i6] = aVar2.f1427e;
                int i8 = i7 + 1;
                iArr[i7] = aVar2.f1428f;
                this.f1511c[i2] = aVar2.f1429g.ordinal();
                this.f1512d[i2] = aVar2.f1430h.ordinal();
                i2++;
                i3 = i8;
            }
            this.f1513e = aVar.f1416f;
            this.f1514f = aVar.f1417g;
            this.f1515g = aVar.f1420j;
            this.f1516h = aVar.u;
            this.f1517i = aVar.f1421k;
            this.f1518j = aVar.f1422l;
            this.f1519k = aVar.m;
            this.f1520l = aVar.n;
            this.m = aVar.o;
            this.n = aVar.p;
            this.o = aVar.q;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public C0186a a(C0207w wVar) {
        C0186a aVar = new C0186a(wVar);
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f1509a.length) {
            a aVar2 = new a();
            int i4 = i2 + 1;
            aVar2.f1423a = this.f1509a[i2];
            if (C0207w.f1561c) {
                StringBuilder sb = new StringBuilder();
                sb.append("Instantiate ");
                sb.append(aVar);
                sb.append(" op #");
                sb.append(i3);
                sb.append(" base fragment #");
                sb.append(this.f1509a[i4]);
                Log.v("FragmentManager", sb.toString());
            }
            String str = (String) this.f1510b.get(i3);
            if (str != null) {
                aVar2.f1424b = (Fragment) wVar.f1568j.get(str);
            } else {
                aVar2.f1424b = null;
            }
            aVar2.f1429g = b.values()[this.f1511c[i3]];
            aVar2.f1430h = b.values()[this.f1512d[i3]];
            int[] iArr = this.f1509a;
            int i5 = i4 + 1;
            aVar2.f1425c = iArr[i4];
            int i6 = i5 + 1;
            aVar2.f1426d = iArr[i5];
            int i7 = i6 + 1;
            aVar2.f1427e = iArr[i6];
            int i8 = i7 + 1;
            aVar2.f1428f = iArr[i7];
            aVar.f1412b = aVar2.f1425c;
            aVar.f1413c = aVar2.f1426d;
            aVar.f1414d = aVar2.f1427e;
            aVar.f1415e = aVar2.f1428f;
            aVar.a(aVar2);
            i3++;
            i2 = i8;
        }
        aVar.f1416f = this.f1513e;
        aVar.f1417g = this.f1514f;
        aVar.f1420j = this.f1515g;
        aVar.u = this.f1516h;
        aVar.f1418h = true;
        aVar.f1421k = this.f1517i;
        aVar.f1422l = this.f1518j;
        aVar.m = this.f1519k;
        aVar.n = this.f1520l;
        aVar.o = this.m;
        aVar.p = this.n;
        aVar.q = this.o;
        aVar.b(1);
        return aVar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeIntArray(this.f1509a);
        parcel.writeStringList(this.f1510b);
        parcel.writeIntArray(this.f1511c);
        parcel.writeIntArray(this.f1512d);
        parcel.writeInt(this.f1513e);
        parcel.writeInt(this.f1514f);
        parcel.writeString(this.f1515g);
        parcel.writeInt(this.f1516h);
        parcel.writeInt(this.f1517i);
        TextUtils.writeToParcel(this.f1518j, parcel, 0);
        parcel.writeInt(this.f1519k);
        TextUtils.writeToParcel(this.f1520l, parcel, 0);
        parcel.writeStringList(this.m);
        parcel.writeStringList(this.n);
        parcel.writeInt(this.o ? 1 : 0);
    }

    public C0188c(Parcel parcel) {
        this.f1509a = parcel.createIntArray();
        this.f1510b = parcel.createStringArrayList();
        this.f1511c = parcel.createIntArray();
        this.f1512d = parcel.createIntArray();
        this.f1513e = parcel.readInt();
        this.f1514f = parcel.readInt();
        this.f1515g = parcel.readString();
        this.f1516h = parcel.readInt();
        this.f1517i = parcel.readInt();
        this.f1518j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1519k = parcel.readInt();
        this.f1520l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.m = parcel.createStringArrayList();
        this.n = parcel.createStringArrayList();
        this.o = parcel.readInt() != 0;
    }
}
