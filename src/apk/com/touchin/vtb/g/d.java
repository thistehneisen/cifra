package com.touchin.vtb.g;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.touchin.vtb.R;
import kotlin.e.b.h;

/* compiled from: EnterPinState.kt */
public final class d implements Parcelable {
    public static final Creator CREATOR = new a();

    /* renamed from: a reason: collision with root package name */
    private String f7429a;

    /* renamed from: b reason: collision with root package name */
    private final boolean f7430b;

    /* renamed from: c reason: collision with root package name */
    private int f7431c;

    /* renamed from: d reason: collision with root package name */
    private final boolean f7432d;

    /* renamed from: e reason: collision with root package name */
    private final boolean f7433e;

    /* renamed from: f reason: collision with root package name */
    private final String f7434f;

    /* renamed from: g reason: collision with root package name */
    private final Boolean f7435g;

    /* renamed from: h reason: collision with root package name */
    private final int f7436h;

    /* renamed from: i reason: collision with root package name */
    private final Integer f7437i;

    /* renamed from: j reason: collision with root package name */
    private final Integer f7438j;

    /* renamed from: k reason: collision with root package name */
    private final int f7439k;

    /* renamed from: l reason: collision with root package name */
    private final int f7440l;

    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            Boolean bool;
            h.b(parcel, "in");
            String readString = parcel.readString();
            boolean z = true;
            boolean z2 = parcel.readInt() != 0;
            int readInt = parcel.readInt();
            boolean z3 = parcel.readInt() != 0;
            boolean z4 = parcel.readInt() != 0;
            String readString2 = parcel.readString();
            Integer num = null;
            if (parcel.readInt() != 0) {
                if (parcel.readInt() == 0) {
                    z = false;
                }
                bool = Boolean.valueOf(z);
            } else {
                bool = null;
            }
            int readInt2 = parcel.readInt();
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            if (parcel.readInt() != 0) {
                num = Integer.valueOf(parcel.readInt());
            }
            d dVar = new d(readString, z2, readInt, z3, z4, readString2, bool, readInt2, valueOf, num, parcel.readInt(), parcel.readInt());
            return dVar;
        }

        public final Object[] newArray(int i2) {
            return new d[i2];
        }
    }

    public d(String str, boolean z, int i2, boolean z2, boolean z3, String str2, Boolean bool, int i3, Integer num, Integer num2, int i4, int i5) {
        h.b(str, "pin");
        this.f7429a = str;
        this.f7430b = z;
        this.f7431c = i2;
        this.f7432d = z2;
        this.f7433e = z3;
        this.f7434f = str2;
        this.f7435g = bool;
        this.f7436h = i3;
        this.f7437i = num;
        this.f7438j = num2;
        this.f7439k = i4;
        this.f7440l = i5;
    }

    public final void a(int i2) {
        this.f7431c = i2;
    }

    public int describeContents() {
        return 0;
    }

    public final int n() {
        return this.f7431c;
    }

    public final Integer o() {
        return this.f7438j;
    }

    public final int p() {
        return this.f7436h;
    }

    public final String q() {
        return this.f7429a;
    }

    public final String r() {
        return this.f7434f;
    }

    public final int s() {
        return this.f7439k;
    }

    public final Integer t() {
        return this.f7437i;
    }

    public final Boolean u() {
        return this.f7435g;
    }

    public final boolean v() {
        return this.f7430b;
    }

    public final boolean w() {
        return this.f7433e;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        h.b(parcel, "parcel");
        parcel.writeString(this.f7429a);
        parcel.writeInt(this.f7430b ? 1 : 0);
        parcel.writeInt(this.f7431c);
        parcel.writeInt(this.f7432d ? 1 : 0);
        parcel.writeInt(this.f7433e ? 1 : 0);
        parcel.writeString(this.f7434f);
        Boolean bool = this.f7435g;
        if (bool != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.f7436h);
        Integer num = this.f7437i;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
        Integer num2 = this.f7438j;
        if (num2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.f7439k);
        parcel.writeInt(this.f7440l);
    }

    public final boolean x() {
        return this.f7432d;
    }

    public /* synthetic */ d(String str, boolean z, int i2, boolean z2, boolean z3, String str2, Boolean bool, int i3, Integer num, Integer num2, int i4, int i5, int i6, e eVar) {
        int i7 = i6;
        this((i7 & 1) != 0 ? "" : str, z, (i7 & 4) != 0 ? 5 : i2, (i7 & 8) != 0 ? false : z2, (i7 & 16) != 0 ? false : z3, (i7 & 32) != 0 ? null : str2, (i7 & 64) != 0 ? null : bool, (i7 & 128) != 0 ? R.id.main_navigation_tasks : i3, (i7 & 256) != 0 ? Integer.valueOf(R.string.common_more_login_settings_change_entry_code) : num, (i7 & 512) != 0 ? null : num2, (i7 & 1024) != 0 ? R.string.common_pin_code_enter_pin : i4, (i7 & 2048) != 0 ? R.string.common_global_enter : i5);
    }
}
