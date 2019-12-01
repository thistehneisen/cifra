package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Iterator;

/* renamed from: com.google.android.gms.measurement.internal.i reason: case insensitive filesystem */
public final class C0520i extends a implements Iterable<String> {
    public static final Creator<C0520i> CREATOR = new C0530k();
    /* access modifiers changed from: private */

    /* renamed from: a reason: collision with root package name */
    public final Bundle f5944a;

    C0520i(Bundle bundle) {
        this.f5944a = bundle;
    }

    /* access modifiers changed from: 0000 */
    public final Object a(String str) {
        return this.f5944a.get(str);
    }

    /* access modifiers changed from: 0000 */
    public final Long b(String str) {
        return Long.valueOf(this.f5944a.getLong(str));
    }

    /* access modifiers changed from: 0000 */
    public final String c(String str) {
        return this.f5944a.getString(str);
    }

    /* access modifiers changed from: 0000 */
    public final Double d(String str) {
        return Double.valueOf(this.f5944a.getDouble(str));
    }

    public final Bundle f() {
        return new Bundle(this.f5944a);
    }

    public final Iterator<String> iterator() {
        return new C0515h(this);
    }

    public final int size() {
        return this.f5944a.size();
    }

    public final String toString() {
        return this.f5944a.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 2, f(), false);
        b.a(parcel, a2);
    }
}
