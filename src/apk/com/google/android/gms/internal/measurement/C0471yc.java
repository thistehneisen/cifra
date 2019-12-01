package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.Eb.d;

/* renamed from: com.google.android.gms.internal.measurement.yc reason: case insensitive filesystem */
final class C0471yc implements C0388kc {

    /* renamed from: a reason: collision with root package name */
    private final C0400mc f5427a;

    /* renamed from: b reason: collision with root package name */
    private final String f5428b;

    /* renamed from: c reason: collision with root package name */
    private final Object[] f5429c;

    /* renamed from: d reason: collision with root package name */
    private final int f5430d;

    C0471yc(C0400mc mcVar, String str, Object[] objArr) {
        this.f5427a = mcVar;
        this.f5428b = str;
        this.f5429c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f5430d = charAt;
            return;
        }
        char c2 = charAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char charAt2 = str.charAt(i3);
            if (charAt2 >= 55296) {
                c2 |= (charAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            } else {
                this.f5430d = c2 | (charAt2 << i2);
                return;
            }
        }
    }

    public final C0400mc a() {
        return this.f5427a;
    }

    public final boolean b() {
        return (this.f5430d & 2) == 2;
    }

    public final int c() {
        return (this.f5430d & 1) == 1 ? d.f4923i : d.f4924j;
    }

    /* access modifiers changed from: 0000 */
    public final String d() {
        return this.f5428b;
    }

    /* access modifiers changed from: 0000 */
    public final Object[] e() {
        return this.f5429c;
    }
}
