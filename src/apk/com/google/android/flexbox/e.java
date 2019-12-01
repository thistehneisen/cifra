package com.google.android.flexbox;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import b.g.i.C0246g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: FlexboxHelper */
class e {

    /* renamed from: a reason: collision with root package name */
    private final a f4476a;

    /* renamed from: b reason: collision with root package name */
    private boolean[] f4477b;

    /* renamed from: c reason: collision with root package name */
    int[] f4478c;

    /* renamed from: d reason: collision with root package name */
    long[] f4479d;

    /* renamed from: e reason: collision with root package name */
    private long[] f4480e;

    /* compiled from: FlexboxHelper */
    static class a {

        /* renamed from: a reason: collision with root package name */
        List<c> f4481a;

        /* renamed from: b reason: collision with root package name */
        int f4482b;

        a() {
        }

        /* access modifiers changed from: 0000 */
        public void a() {
            this.f4481a = null;
            this.f4482b = 0;
        }
    }

    /* compiled from: FlexboxHelper */
    private static class b implements Comparable<b> {

        /* renamed from: a reason: collision with root package name */
        int f4483a;

        /* renamed from: b reason: collision with root package name */
        int f4484b;

        private b() {
        }

        /* renamed from: a */
        public int compareTo(b bVar) {
            int i2 = this.f4484b;
            int i3 = bVar.f4484b;
            if (i2 != i3) {
                return i2 - i3;
            }
            return this.f4483a - bVar.f4483a;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Order{order=");
            sb.append(this.f4484b);
            sb.append(", index=");
            sb.append(this.f4483a);
            sb.append('}');
            return sb.toString();
        }
    }

    e(a aVar) {
        this.f4476a = aVar;
    }

    private List<b> e(int i2) {
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            b bVar = (b) this.f4476a.b(i3).getLayoutParams();
            b bVar2 = new b();
            bVar2.f4484b = bVar.getOrder();
            bVar2.f4483a = i3;
            arrayList.add(bVar2);
        }
        return arrayList;
    }

    private int f(b bVar, boolean z) {
        if (z) {
            return bVar.getWidth();
        }
        return bVar.getHeight();
    }

    /* access modifiers changed from: 0000 */
    public int a(long j2) {
        return (int) (j2 >> 32);
    }

    /* access modifiers changed from: 0000 */
    public int[] a(View view, int i2, LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.f4476a.getFlexItemCount();
        List e2 = e(flexItemCount);
        b bVar = new b();
        if (view == null || !(layoutParams instanceof b)) {
            bVar.f4484b = 1;
        } else {
            bVar.f4484b = ((b) layoutParams).getOrder();
        }
        if (i2 == -1 || i2 == flexItemCount) {
            bVar.f4483a = flexItemCount;
        } else if (i2 < this.f4476a.getFlexItemCount()) {
            bVar.f4483a = i2;
            while (i2 < flexItemCount) {
                b bVar2 = (b) e2.get(i2);
                bVar2.f4483a++;
                i2++;
            }
        } else {
            bVar.f4483a = flexItemCount;
        }
        e2.add(bVar);
        return a(flexItemCount + 1, e2, sparseIntArray);
    }

    /* access modifiers changed from: 0000 */
    public int b(long j2) {
        return (int) j2;
    }

    /* access modifiers changed from: 0000 */
    public long b(int i2, int i3) {
        return (((long) i2) & 4294967295L) | (((long) i3) << 32);
    }

    /* access modifiers changed from: 0000 */
    public boolean b(SparseIntArray sparseIntArray) {
        int flexItemCount = this.f4476a.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i2 = 0; i2 < flexItemCount; i2++) {
            View b2 = this.f4476a.b(i2);
            if (b2 != null && ((b) b2.getLayoutParams()).getOrder() != sparseIntArray.get(i2)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public void c(a aVar, int i2, int i3, int i4, int i5, List<c> list) {
        a(aVar, i3, i2, i4, i5, -1, list);
    }

    /* access modifiers changed from: 0000 */
    public void d(a aVar, int i2, int i3, int i4, int i5, List<c> list) {
        a(aVar, i3, i2, i4, 0, i5, list);
    }

    private int c(boolean z) {
        if (z) {
            return this.f4476a.getPaddingTop();
        }
        return this.f4476a.getPaddingStart();
    }

    private int d(boolean z) {
        if (z) {
            return this.f4476a.getPaddingStart();
        }
        return this.f4476a.getPaddingTop();
    }

    private void f(int i2) {
        boolean[] zArr = this.f4477b;
        if (zArr == null) {
            if (i2 < 10) {
                i2 = 10;
            }
            this.f4477b = new boolean[i2];
        } else if (zArr.length < i2) {
            int length = zArr.length * 2;
            if (length >= i2) {
                i2 = length;
            }
            this.f4477b = new boolean[i2];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    private int c(b bVar, boolean z) {
        if (z) {
            return bVar.f();
        }
        return bVar.e();
    }

    private int d(b bVar, boolean z) {
        if (z) {
            return bVar.e();
        }
        return bVar.f();
    }

    /* access modifiers changed from: 0000 */
    public void b(a aVar, int i2, int i3, int i4, int i5, List<c> list) {
        a(aVar, i2, i3, i4, 0, i5, list);
    }

    /* access modifiers changed from: 0000 */
    public void c(int i2) {
        long[] jArr = this.f4480e;
        if (jArr == null) {
            if (i2 < 10) {
                i2 = 10;
            }
            this.f4480e = new long[i2];
        } else if (jArr.length < i2) {
            int length = jArr.length * 2;
            if (length >= i2) {
                i2 = length;
            }
            this.f4480e = Arrays.copyOf(this.f4480e, i2);
        }
    }

    /* access modifiers changed from: 0000 */
    public void d(int i2) {
        int i3 = i2;
        if (i3 < this.f4476a.getFlexItemCount()) {
            int flexDirection = this.f4476a.getFlexDirection();
            String str = "Invalid flex direction: ";
            if (this.f4476a.getAlignItems() == 4) {
                int[] iArr = this.f4478c;
                List flexLinesInternal = this.f4476a.getFlexLinesInternal();
                int size = flexLinesInternal.size();
                for (int i4 = iArr != null ? iArr[i3] : 0; i4 < size; i4++) {
                    c cVar = (c) flexLinesInternal.get(i4);
                    int i5 = cVar.f4471h;
                    for (int i6 = 0; i6 < i5; i6++) {
                        int i7 = cVar.o + i6;
                        if (i6 < this.f4476a.getFlexItemCount()) {
                            View a2 = this.f4476a.a(i7);
                            if (!(a2 == null || a2.getVisibility() == 8)) {
                                b bVar = (b) a2.getLayoutParams();
                                if (bVar.a() == -1 || bVar.a() == 4) {
                                    if (flexDirection == 0 || flexDirection == 1) {
                                        b(a2, cVar.f4470g, i7);
                                    } else if (flexDirection == 2 || flexDirection == 3) {
                                        a(a2, cVar.f4470g, i7);
                                    } else {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(str);
                                        sb.append(flexDirection);
                                        throw new IllegalArgumentException(sb.toString());
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                for (c cVar2 : this.f4476a.getFlexLinesInternal()) {
                    Iterator it = cVar2.n.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Integer num = (Integer) it.next();
                            View a3 = this.f4476a.a(num.intValue());
                            if (flexDirection == 0 || flexDirection == 1) {
                                b(a3, cVar2.f4470g, num.intValue());
                            } else {
                                if (flexDirection != 2) {
                                    if (flexDirection != 3) {
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append(str);
                                        sb2.append(flexDirection);
                                        throw new IllegalArgumentException(sb2.toString());
                                    }
                                }
                                a(a3, cVar2.f4470g, num.intValue());
                            }
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void b(a aVar, int i2, int i3) {
        a(aVar, i3, i2, Integer.MAX_VALUE, 0, -1, null);
    }

    private int b(boolean z) {
        if (z) {
            return this.f4476a.getPaddingEnd();
        }
        return this.f4476a.getPaddingBottom();
    }

    private int e(b bVar, boolean z) {
        if (z) {
            return bVar.getHeight();
        }
        return bVar.getWidth();
    }

    private int b(View view, boolean z) {
        if (z) {
            return view.getMeasuredWidth();
        }
        return view.getMeasuredHeight();
    }

    private int b(b bVar, boolean z) {
        if (z) {
            return bVar.i();
        }
        return bVar.d();
    }

    /* access modifiers changed from: 0000 */
    public void b(int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        f(this.f4476a.getFlexItemCount());
        if (i4 < this.f4476a.getFlexItemCount()) {
            int flexDirection = this.f4476a.getFlexDirection();
            int flexDirection2 = this.f4476a.getFlexDirection();
            if (flexDirection2 == 0 || flexDirection2 == 1) {
                int mode = MeasureSpec.getMode(i2);
                int size = MeasureSpec.getSize(i2);
                if (mode != 1073741824) {
                    size = this.f4476a.getLargestMainSize();
                }
                i7 = this.f4476a.getPaddingLeft();
                i5 = this.f4476a.getPaddingRight();
            } else if (flexDirection2 == 2 || flexDirection2 == 3) {
                int mode2 = MeasureSpec.getMode(i3);
                i6 = MeasureSpec.getSize(i3);
                if (mode2 != 1073741824) {
                    i6 = this.f4476a.getLargestMainSize();
                }
                i7 = this.f4476a.getPaddingTop();
                i5 = this.f4476a.getPaddingBottom();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid flex direction: ");
                sb.append(flexDirection);
                throw new IllegalArgumentException(sb.toString());
            }
            int i8 = i7 + i5;
            int i9 = 0;
            int[] iArr = this.f4478c;
            if (iArr != null) {
                i9 = iArr[i4];
            }
            List flexLinesInternal = this.f4476a.getFlexLinesInternal();
            int size2 = flexLinesInternal.size();
            for (int i10 = i9; i10 < size2; i10++) {
                c cVar = (c) flexLinesInternal.get(i10);
                if (cVar.f4468e < i6) {
                    a(i2, i3, cVar, i6, i8, false);
                } else {
                    b(i2, i3, cVar, i6, i8, false);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public int[] a(SparseIntArray sparseIntArray) {
        int flexItemCount = this.f4476a.getFlexItemCount();
        return a(flexItemCount, e(flexItemCount), sparseIntArray);
    }

    private int[] a(int i2, List<b> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i2];
        int i3 = 0;
        for (b bVar : list) {
            int i4 = bVar.f4483a;
            iArr[i3] = i4;
            sparseIntArray.append(i4, bVar.f4484b);
            i3++;
        }
        return iArr;
    }

    /* access modifiers changed from: 0000 */
    public void a(a aVar, int i2, int i3) {
        a(aVar, i2, i3, Integer.MAX_VALUE, 0, -1, null);
    }

    /* access modifiers changed from: 0000 */
    public void a(a aVar, int i2, int i3, int i4, int i5, List<c> list) {
        a(aVar, i2, i3, i4, i5, -1, list);
    }

    /* access modifiers changed from: 0000 */
    public void a(a aVar, int i2, int i3, int i4, int i5, int i6, List<c> list) {
        int i7;
        int i8;
        a aVar2;
        int i9;
        int i10;
        List<c> list2;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        View view;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        c cVar;
        a aVar3 = aVar;
        int i21 = i2;
        int i22 = i3;
        int i23 = i6;
        boolean a2 = this.f4476a.a();
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        List<c> arrayList = list == null ? new ArrayList<>() : list;
        aVar3.f4481a = arrayList;
        boolean z = i23 == -1;
        int d2 = d(a2);
        int b2 = b(a2);
        int c2 = c(a2);
        int a3 = a(a2);
        c cVar2 = new c();
        int i24 = i5;
        cVar2.o = i24;
        int i25 = b2 + d2;
        cVar2.f4468e = i25;
        int flexItemCount = this.f4476a.getFlexItemCount();
        boolean z2 = z;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = Integer.MIN_VALUE;
        while (true) {
            if (i7 >= flexItemCount) {
                i8 = i27;
                aVar2 = aVar;
                break;
            }
            View a4 = this.f4476a.a(i7);
            if (a4 == null) {
                if (a(i7, flexItemCount, cVar2)) {
                    a(arrayList, cVar2, i7, i26);
                }
            } else if (a4.getVisibility() == 8) {
                cVar2.f4472i++;
                cVar2.f4471h++;
                if (a(i7, flexItemCount, cVar2)) {
                    a(arrayList, cVar2, i7, i26);
                }
            } else {
                b bVar = (b) a4.getLayoutParams();
                int i30 = flexItemCount;
                if (bVar.a() == 4) {
                    cVar2.n.add(Integer.valueOf(i7));
                }
                int f2 = f(bVar, a2);
                if (bVar.h() != -1.0f && mode == 1073741824) {
                    f2 = Math.round(((float) size) * bVar.h());
                }
                if (a2) {
                    int a5 = this.f4476a.a(i21, i25 + d(bVar, true) + b(bVar, true), f2);
                    i10 = size;
                    i9 = mode;
                    int b3 = this.f4476a.b(i22, c2 + a3 + c(bVar, true) + a(bVar, true) + i26, e(bVar, true));
                    a4.measure(a5, b3);
                    a(i7, a5, b3, a4);
                    i15 = a5;
                } else {
                    i10 = size;
                    i9 = mode;
                    int a6 = this.f4476a.a(i22, c2 + a3 + c(bVar, false) + a(bVar, false) + i26, e(bVar, false));
                    int b4 = this.f4476a.b(i21, d(bVar, false) + i25 + b(bVar, false), f2);
                    a4.measure(a6, b4);
                    a(i7, a6, b4, a4);
                    i15 = b4;
                }
                this.f4476a.a(i7, a4);
                a(a4, i7);
                i27 = View.combineMeasuredStates(i27, a4.getMeasuredState());
                int i31 = i26;
                int i32 = i30;
                c cVar3 = cVar2;
                int i33 = i25;
                int i34 = i7;
                View view2 = a4;
                list2 = arrayList;
                int i35 = i34;
                int i36 = i15;
                if (a(a4, i9, i10, cVar2.f4468e, b(bVar, a2) + b(a4, a2) + d(bVar, a2), bVar, i34, i28, arrayList.size())) {
                    if (cVar3.c() > 0) {
                        if (i35 > 0) {
                            i20 = i35 - 1;
                            cVar = cVar3;
                        } else {
                            cVar = cVar3;
                            i20 = 0;
                        }
                        a(list2, cVar, i20, i31);
                        i19 = cVar.f4470g + i31;
                    } else {
                        i19 = i31;
                    }
                    if (!a2) {
                        i13 = i3;
                        view = view2;
                        i7 = i35;
                        int i37 = i36;
                        if (bVar.getWidth() == -1) {
                            a aVar4 = this.f4476a;
                            view.measure(aVar4.a(i13, aVar4.getPaddingLeft() + this.f4476a.getPaddingRight() + bVar.e() + bVar.i() + i19, bVar.getWidth()), i37);
                            a(view, i7);
                        }
                    } else if (bVar.getHeight() == -1) {
                        a aVar5 = this.f4476a;
                        i13 = i3;
                        i7 = i35;
                        view = view2;
                        view.measure(i36, aVar5.b(i13, aVar5.getPaddingTop() + this.f4476a.getPaddingBottom() + bVar.f() + bVar.d() + i19, bVar.getHeight()));
                        a(view, i7);
                    } else {
                        i13 = i3;
                        view = view2;
                        i7 = i35;
                    }
                    cVar2 = new c();
                    cVar2.f4471h = 1;
                    i12 = i33;
                    cVar2.f4468e = i12;
                    cVar2.o = i7;
                    i31 = i19;
                    i17 = 0;
                    i16 = Integer.MIN_VALUE;
                } else {
                    i13 = i3;
                    view = view2;
                    i7 = i35;
                    cVar2 = cVar3;
                    i12 = i33;
                    cVar2.f4471h++;
                    i17 = i28 + 1;
                    i16 = i29;
                }
                int[] iArr = this.f4478c;
                if (iArr != null) {
                    iArr[i7] = list2.size();
                }
                cVar2.f4468e += b(view, a2) + d(bVar, a2) + b(bVar, a2);
                cVar2.f4473j += bVar.g();
                cVar2.f4474k += bVar.b();
                this.f4476a.a(view, i7, i17, cVar2);
                int max = Math.max(i16, a(view, a2) + c(bVar, a2) + a(bVar, a2) + this.f4476a.a(view));
                cVar2.f4470g = Math.max(cVar2.f4470g, max);
                if (a2) {
                    if (this.f4476a.getFlexWrap() != 2) {
                        cVar2.f4475l = Math.max(cVar2.f4475l, view.getBaseline() + bVar.f());
                    } else {
                        cVar2.f4475l = Math.max(cVar2.f4475l, (view.getMeasuredHeight() - view.getBaseline()) + bVar.d());
                    }
                }
                i14 = i30;
                if (a(i7, i14, cVar2)) {
                    a(list2, cVar2, i7, i31);
                    i31 += cVar2.f4470g;
                }
                i11 = i6;
                if (i11 != -1 && list2.size() > 0) {
                    if (((c) list2.get(list2.size() - 1)).p >= i11 && i7 >= i11 && !z2) {
                        i18 = -cVar2.a();
                        z2 = true;
                        if (i18 <= i4 && z2) {
                            aVar2 = aVar;
                            i8 = i27;
                            break;
                        }
                        i28 = i17;
                        i29 = max;
                        i26 = i18;
                        i24 = i7 + 1;
                        a aVar6 = aVar;
                        i21 = i2;
                        flexItemCount = i14;
                        i22 = i13;
                        i25 = i12;
                        arrayList = list2;
                        mode = i9;
                        i23 = i11;
                        size = i10;
                    }
                }
                i18 = i31;
                if (i18 <= i4) {
                }
                i28 = i17;
                i29 = max;
                i26 = i18;
                i24 = i7 + 1;
                a aVar62 = aVar;
                i21 = i2;
                flexItemCount = i14;
                i22 = i13;
                i25 = i12;
                arrayList = list2;
                mode = i9;
                i23 = i11;
                size = i10;
            }
            int i38 = i4;
            i10 = size;
            i9 = mode;
            i13 = i22;
            i11 = i23;
            list2 = arrayList;
            i12 = i25;
            i14 = flexItemCount;
            i24 = i7 + 1;
            a aVar622 = aVar;
            i21 = i2;
            flexItemCount = i14;
            i22 = i13;
            i25 = i12;
            arrayList = list2;
            mode = i9;
            i23 = i11;
            size = i10;
        }
        aVar2.f4482b = i8;
    }

    private void b(int i2, int i3, c cVar, int i4, int i5, boolean z) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        c cVar2 = cVar;
        int i13 = i4;
        int i14 = cVar2.f4468e;
        float f2 = cVar2.f4474k;
        float f3 = 0.0f;
        if (f2 > 0.0f && i13 <= i14) {
            float f4 = ((float) (i14 - i13)) / f2;
            cVar2.f4468e = i5 + cVar2.f4469f;
            if (!z) {
                cVar2.f4470g = Integer.MIN_VALUE;
            }
            int i15 = 0;
            boolean z2 = false;
            float f5 = 0.0f;
            int i16 = 0;
            while (i15 < cVar2.f4471h) {
                int i17 = cVar2.o + i15;
                View a2 = this.f4476a.a(i17);
                if (a2 == null || a2.getVisibility() == 8) {
                    int i18 = i3;
                    i7 = i14;
                    i6 = i15;
                } else {
                    b bVar = (b) a2.getLayoutParams();
                    int flexDirection = this.f4476a.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        i7 = i14;
                        int i19 = i15;
                        int i20 = i2;
                        int measuredWidth = a2.getMeasuredWidth();
                        long[] jArr = this.f4480e;
                        if (jArr != null) {
                            measuredWidth = b(jArr[i17]);
                        }
                        int measuredHeight = a2.getMeasuredHeight();
                        long[] jArr2 = this.f4480e;
                        if (jArr2 != null) {
                            i9 = i19;
                            measuredHeight = a(jArr2[i17]);
                        } else {
                            i9 = i19;
                        }
                        if (this.f4477b[i17] || bVar.b() <= 0.0f) {
                            int i21 = i3;
                            i12 = i9;
                            i11 = measuredWidth;
                            i10 = measuredHeight;
                        } else {
                            float b2 = ((float) measuredWidth) - (bVar.b() * f4);
                            i12 = i9;
                            if (i12 == cVar2.f4471h - 1) {
                                b2 += f5;
                                f5 = 0.0f;
                            }
                            int round = Math.round(b2);
                            if (round < bVar.c()) {
                                round = bVar.c();
                                this.f4477b[i17] = true;
                                cVar2.f4474k -= bVar.b();
                                z2 = true;
                            } else {
                                f5 += b2 - ((float) round);
                                double d2 = (double) f5;
                                if (d2 > 1.0d) {
                                    round++;
                                    f5 -= 1.0f;
                                } else if (d2 < -1.0d) {
                                    round--;
                                    f5 += 1.0f;
                                }
                            }
                            int a3 = a(i3, bVar, cVar2.m);
                            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(round, 1073741824);
                            a2.measure(makeMeasureSpec, a3);
                            i11 = a2.getMeasuredWidth();
                            i10 = a2.getMeasuredHeight();
                            a(i17, makeMeasureSpec, a3, a2);
                            this.f4476a.a(i17, a2);
                        }
                        i8 = Math.max(i16, i10 + bVar.f() + bVar.d() + this.f4476a.a(a2));
                        cVar2.f4468e += i11 + bVar.e() + bVar.i();
                    } else {
                        int measuredHeight2 = a2.getMeasuredHeight();
                        long[] jArr3 = this.f4480e;
                        if (jArr3 != null) {
                            measuredHeight2 = a(jArr3[i17]);
                        }
                        int measuredWidth2 = a2.getMeasuredWidth();
                        long[] jArr4 = this.f4480e;
                        if (jArr4 != null) {
                            measuredWidth2 = b(jArr4[i17]);
                        }
                        if (this.f4477b[i17] || bVar.b() <= f3) {
                            i7 = i14;
                            i6 = i15;
                            int i22 = i2;
                        } else {
                            float b3 = ((float) measuredHeight2) - (bVar.b() * f4);
                            if (i15 == cVar2.f4471h - 1) {
                                b3 += f5;
                                f5 = 0.0f;
                            }
                            int round2 = Math.round(b3);
                            if (round2 < bVar.j()) {
                                round2 = bVar.j();
                                this.f4477b[i17] = true;
                                cVar2.f4474k -= bVar.b();
                                i7 = i14;
                                i6 = i15;
                                z2 = true;
                            } else {
                                f5 += b3 - ((float) round2);
                                i7 = i14;
                                i6 = i15;
                                double d3 = (double) f5;
                                if (d3 > 1.0d) {
                                    round2++;
                                    f5 -= 1.0f;
                                } else if (d3 < -1.0d) {
                                    round2--;
                                    f5 += 1.0f;
                                }
                            }
                            int b4 = b(i2, bVar, cVar2.m);
                            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(round2, 1073741824);
                            a2.measure(b4, makeMeasureSpec2);
                            measuredWidth2 = a2.getMeasuredWidth();
                            int measuredHeight3 = a2.getMeasuredHeight();
                            a(i17, b4, makeMeasureSpec2, a2);
                            this.f4476a.a(i17, a2);
                            measuredHeight2 = measuredHeight3;
                        }
                        i8 = Math.max(i16, measuredWidth2 + bVar.e() + bVar.i() + this.f4476a.a(a2));
                        cVar2.f4468e += measuredHeight2 + bVar.f() + bVar.d();
                        int i23 = i3;
                    }
                    cVar2.f4470g = Math.max(cVar2.f4470g, i8);
                    i16 = i8;
                }
                i15 = i6 + 1;
                i14 = i7;
                f3 = 0.0f;
            }
            int i24 = i3;
            int i25 = i14;
            if (z2 && i25 != cVar2.f4468e) {
                b(i2, i3, cVar, i4, i5, true);
            }
        }
    }

    private int b(int i2, b bVar, int i3) {
        a aVar = this.f4476a;
        int a2 = aVar.a(i2, aVar.getPaddingLeft() + this.f4476a.getPaddingRight() + bVar.e() + bVar.i() + i3, bVar.getWidth());
        int size = MeasureSpec.getSize(a2);
        if (size > bVar.m()) {
            return MeasureSpec.makeMeasureSpec(bVar.m(), MeasureSpec.getMode(a2));
        }
        return size < bVar.c() ? MeasureSpec.makeMeasureSpec(bVar.c(), MeasureSpec.getMode(a2)) : a2;
    }

    private void b(View view, int i2, int i3) {
        int i4;
        b bVar = (b) view.getLayoutParams();
        int min = Math.min(Math.max(((i2 - bVar.f()) - bVar.d()) - this.f4476a.a(view), bVar.j()), bVar.l());
        long[] jArr = this.f4480e;
        if (jArr != null) {
            i4 = b(jArr[i3]);
        } else {
            i4 = view.getMeasuredWidth();
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i4, 1073741824);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        a(i3, makeMeasureSpec, makeMeasureSpec2, view);
        this.f4476a.a(i3, view);
    }

    /* access modifiers changed from: 0000 */
    public void b(int i2) {
        long[] jArr = this.f4479d;
        if (jArr == null) {
            if (i2 < 10) {
                i2 = 10;
            }
            this.f4479d = new long[i2];
        } else if (jArr.length < i2) {
            int length = jArr.length * 2;
            if (length >= i2) {
                i2 = length;
            }
            this.f4479d = Arrays.copyOf(this.f4479d, i2);
        }
    }

    private int a(boolean z) {
        if (z) {
            return this.f4476a.getPaddingBottom();
        }
        return this.f4476a.getPaddingEnd();
    }

    private int a(View view, boolean z) {
        if (z) {
            return view.getMeasuredHeight();
        }
        return view.getMeasuredWidth();
    }

    private int a(b bVar, boolean z) {
        if (z) {
            return bVar.d();
        }
        return bVar.i();
    }

    private boolean a(View view, int i2, int i3, int i4, int i5, b bVar, int i6, int i7, int i8) {
        if (this.f4476a.getFlexWrap() == 0) {
            return false;
        }
        boolean z = true;
        if (bVar.k()) {
            return true;
        }
        if (i2 == 0) {
            return false;
        }
        int maxLine = this.f4476a.getMaxLine();
        if (maxLine != -1 && maxLine <= i8 + 1) {
            return false;
        }
        int a2 = this.f4476a.a(view, i6, i7);
        if (a2 > 0) {
            i5 += a2;
        }
        if (i3 >= i4 + i5) {
            z = false;
        }
        return z;
    }

    private boolean a(int i2, int i3, c cVar) {
        return i2 == i3 - 1 && cVar.c() != 0;
    }

    private void a(List<c> list, c cVar, int i2, int i3) {
        cVar.m = i3;
        this.f4476a.a(cVar);
        cVar.p = i2;
        list.add(cVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    private void a(View view, int i2) {
        boolean z;
        b bVar = (b) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        boolean z2 = true;
        if (measuredWidth < bVar.c()) {
            measuredWidth = bVar.c();
        } else if (measuredWidth > bVar.m()) {
            measuredWidth = bVar.m();
        } else {
            z = false;
            if (measuredHeight >= bVar.j()) {
                measuredHeight = bVar.j();
            } else if (measuredHeight > bVar.l()) {
                measuredHeight = bVar.l();
            } else {
                z2 = z;
            }
            if (!z2) {
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                a(i2, makeMeasureSpec, makeMeasureSpec2, view);
                this.f4476a.a(i2, view);
                return;
            }
            return;
        }
        z = true;
        if (measuredHeight >= bVar.j()) {
        }
        if (!z2) {
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2, int i3) {
        b(i2, i3, 0);
    }

    private void a(int i2, int i3, c cVar, int i4, int i5, boolean z) {
        int i6;
        int i7;
        int i8;
        int i9;
        double d2;
        int i10;
        double d3;
        c cVar2 = cVar;
        int i11 = i4;
        float f2 = cVar2.f4473j;
        float f3 = 0.0f;
        if (f2 > 0.0f) {
            int i12 = cVar2.f4468e;
            if (i11 >= i12) {
                float f4 = ((float) (i11 - i12)) / f2;
                cVar2.f4468e = i5 + cVar2.f4469f;
                if (!z) {
                    cVar2.f4470g = Integer.MIN_VALUE;
                }
                int i13 = 0;
                boolean z2 = false;
                float f5 = 0.0f;
                int i14 = 0;
                while (i13 < cVar2.f4471h) {
                    int i15 = cVar2.o + i13;
                    View a2 = this.f4476a.a(i15);
                    if (a2 == null || a2.getVisibility() == 8) {
                        int i16 = i3;
                        i6 = i12;
                    } else {
                        b bVar = (b) a2.getLayoutParams();
                        int flexDirection = this.f4476a.getFlexDirection();
                        if (flexDirection == 0 || flexDirection == 1) {
                            int i17 = i12;
                            int i18 = i2;
                            int measuredWidth = a2.getMeasuredWidth();
                            long[] jArr = this.f4480e;
                            if (jArr != null) {
                                measuredWidth = b(jArr[i15]);
                            }
                            int measuredHeight = a2.getMeasuredHeight();
                            long[] jArr2 = this.f4480e;
                            if (jArr2 != null) {
                                i6 = i17;
                                measuredHeight = a(jArr2[i15]);
                            } else {
                                i6 = i17;
                            }
                            if (this.f4477b[i15] || bVar.g() <= 0.0f) {
                                int i19 = i3;
                                i9 = measuredWidth;
                                i8 = measuredHeight;
                            } else {
                                float g2 = ((float) measuredWidth) + (bVar.g() * f4);
                                if (i13 == cVar2.f4471h - 1) {
                                    g2 += f5;
                                    f5 = 0.0f;
                                }
                                int round = Math.round(g2);
                                if (round > bVar.m()) {
                                    round = bVar.m();
                                    this.f4477b[i15] = true;
                                    cVar2.f4473j -= bVar.g();
                                    z2 = true;
                                } else {
                                    f5 += g2 - ((float) round);
                                    double d4 = (double) f5;
                                    if (d4 > 1.0d) {
                                        round++;
                                        d2 = d4 - 1.0d;
                                    } else if (d4 < -1.0d) {
                                        round--;
                                        d2 = d4 + 1.0d;
                                    }
                                    f5 = (float) d2;
                                }
                                int a3 = a(i3, bVar, cVar2.m);
                                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(round, 1073741824);
                                a2.measure(makeMeasureSpec, a3);
                                i9 = a2.getMeasuredWidth();
                                i8 = a2.getMeasuredHeight();
                                a(i15, makeMeasureSpec, a3, a2);
                                this.f4476a.a(i15, a2);
                            }
                            i7 = Math.max(i14, i8 + bVar.f() + bVar.d() + this.f4476a.a(a2));
                            cVar2.f4468e += i9 + bVar.e() + bVar.i();
                        } else {
                            int measuredHeight2 = a2.getMeasuredHeight();
                            long[] jArr3 = this.f4480e;
                            if (jArr3 != null) {
                                measuredHeight2 = a(jArr3[i15]);
                            }
                            int measuredWidth2 = a2.getMeasuredWidth();
                            long[] jArr4 = this.f4480e;
                            if (jArr4 != null) {
                                measuredWidth2 = b(jArr4[i15]);
                            }
                            if (this.f4477b[i15] || bVar.g() <= f3) {
                                i10 = i12;
                                int i20 = i2;
                            } else {
                                float g3 = ((float) measuredHeight2) + (bVar.g() * f4);
                                if (i13 == cVar2.f4471h - 1) {
                                    g3 += f5;
                                    f5 = 0.0f;
                                }
                                int round2 = Math.round(g3);
                                if (round2 > bVar.l()) {
                                    round2 = bVar.l();
                                    this.f4477b[i15] = true;
                                    cVar2.f4473j -= bVar.g();
                                    i10 = i12;
                                    z2 = true;
                                } else {
                                    f5 += g3 - ((float) round2);
                                    i10 = i12;
                                    double d5 = (double) f5;
                                    if (d5 > 1.0d) {
                                        round2++;
                                        d3 = d5 - 1.0d;
                                    } else if (d5 < -1.0d) {
                                        round2--;
                                        d3 = d5 + 1.0d;
                                    }
                                    f5 = (float) d3;
                                }
                                int b2 = b(i2, bVar, cVar2.m);
                                int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(round2, 1073741824);
                                a2.measure(b2, makeMeasureSpec2);
                                measuredWidth2 = a2.getMeasuredWidth();
                                int measuredHeight3 = a2.getMeasuredHeight();
                                a(i15, b2, makeMeasureSpec2, a2);
                                this.f4476a.a(i15, a2);
                                measuredHeight2 = measuredHeight3;
                            }
                            i7 = Math.max(i14, measuredWidth2 + bVar.e() + bVar.i() + this.f4476a.a(a2));
                            cVar2.f4468e += measuredHeight2 + bVar.f() + bVar.d();
                            int i21 = i3;
                            i6 = i10;
                        }
                        cVar2.f4470g = Math.max(cVar2.f4470g, i7);
                        i14 = i7;
                    }
                    i13++;
                    i12 = i6;
                    f3 = 0.0f;
                }
                int i22 = i3;
                int i23 = i12;
                if (z2 && i23 != cVar2.f4468e) {
                    a(i2, i3, cVar, i4, i5, true);
                }
            }
        }
    }

    private int a(int i2, b bVar, int i3) {
        a aVar = this.f4476a;
        int b2 = aVar.b(i2, aVar.getPaddingTop() + this.f4476a.getPaddingBottom() + bVar.f() + bVar.d() + i3, bVar.getHeight());
        int size = MeasureSpec.getSize(b2);
        if (size > bVar.l()) {
            return MeasureSpec.makeMeasureSpec(bVar.l(), MeasureSpec.getMode(b2));
        }
        return size < bVar.j() ? MeasureSpec.makeMeasureSpec(bVar.j(), MeasureSpec.getMode(b2)) : b2;
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2, int i3, int i4) {
        int i5;
        int i6;
        int flexDirection = this.f4476a.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            i6 = MeasureSpec.getMode(i3);
            i5 = MeasureSpec.getSize(i3);
        } else if (flexDirection == 2 || flexDirection == 3) {
            int mode = MeasureSpec.getMode(i2);
            i5 = MeasureSpec.getSize(i2);
            i6 = mode;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid flex direction: ");
            sb.append(flexDirection);
            throw new IllegalArgumentException(sb.toString());
        }
        List<c> flexLinesInternal = this.f4476a.getFlexLinesInternal();
        if (i6 == 1073741824) {
            int sumOfCrossSize = this.f4476a.getSumOfCrossSize() + i4;
            int i7 = 0;
            if (flexLinesInternal.size() == 1) {
                ((c) flexLinesInternal.get(0)).f4470g = i5 - i4;
            } else if (flexLinesInternal.size() >= 2) {
                int alignContent = this.f4476a.getAlignContent();
                if (alignContent == 1) {
                    int i8 = i5 - sumOfCrossSize;
                    c cVar = new c();
                    cVar.f4470g = i8;
                    flexLinesInternal.add(0, cVar);
                } else if (alignContent == 2) {
                    this.f4476a.setFlexLines(a(flexLinesInternal, i5, sumOfCrossSize));
                } else if (alignContent != 3) {
                    if (alignContent != 4) {
                        if (alignContent == 5 && sumOfCrossSize < i5) {
                            float size = ((float) (i5 - sumOfCrossSize)) / ((float) flexLinesInternal.size());
                            int size2 = flexLinesInternal.size();
                            float f2 = 0.0f;
                            while (i7 < size2) {
                                c cVar2 = (c) flexLinesInternal.get(i7);
                                float f3 = ((float) cVar2.f4470g) + size;
                                if (i7 == flexLinesInternal.size() - 1) {
                                    f3 += f2;
                                    f2 = 0.0f;
                                }
                                int round = Math.round(f3);
                                f2 += f3 - ((float) round);
                                if (f2 > 1.0f) {
                                    round++;
                                    f2 -= 1.0f;
                                } else if (f2 < -1.0f) {
                                    round--;
                                    f2 += 1.0f;
                                }
                                cVar2.f4470g = round;
                                i7++;
                            }
                        }
                    } else if (sumOfCrossSize >= i5) {
                        this.f4476a.setFlexLines(a(flexLinesInternal, i5, sumOfCrossSize));
                    } else {
                        int size3 = (i5 - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                        ArrayList arrayList = new ArrayList();
                        c cVar3 = new c();
                        cVar3.f4470g = size3;
                        for (c cVar4 : flexLinesInternal) {
                            arrayList.add(cVar3);
                            arrayList.add(cVar4);
                            arrayList.add(cVar3);
                        }
                        this.f4476a.setFlexLines(arrayList);
                    }
                } else if (sumOfCrossSize < i5) {
                    float size4 = ((float) (i5 - sumOfCrossSize)) / ((float) (flexLinesInternal.size() - 1));
                    ArrayList arrayList2 = new ArrayList();
                    int size5 = flexLinesInternal.size();
                    float f4 = 0.0f;
                    while (i7 < size5) {
                        arrayList2.add((c) flexLinesInternal.get(i7));
                        if (i7 != flexLinesInternal.size() - 1) {
                            c cVar5 = new c();
                            if (i7 == flexLinesInternal.size() - 2) {
                                cVar5.f4470g = Math.round(f4 + size4);
                                f4 = 0.0f;
                            } else {
                                cVar5.f4470g = Math.round(size4);
                            }
                            int i9 = cVar5.f4470g;
                            f4 += size4 - ((float) i9);
                            if (f4 > 1.0f) {
                                cVar5.f4470g = i9 + 1;
                                f4 -= 1.0f;
                            } else if (f4 < -1.0f) {
                                cVar5.f4470g = i9 - 1;
                                f4 += 1.0f;
                            }
                            arrayList2.add(cVar5);
                        }
                        i7++;
                    }
                    this.f4476a.setFlexLines(arrayList2);
                }
            }
        }
    }

    private List<c> a(List<c> list, int i2, int i3) {
        int i4 = (i2 - i3) / 2;
        ArrayList arrayList = new ArrayList();
        c cVar = new c();
        cVar.f4470g = i4;
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (i5 == 0) {
                arrayList.add(cVar);
            }
            arrayList.add((c) list.get(i5));
            if (i5 == list.size() - 1) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        d(0);
    }

    private void a(View view, int i2, int i3) {
        int i4;
        b bVar = (b) view.getLayoutParams();
        int min = Math.min(Math.max(((i2 - bVar.e()) - bVar.i()) - this.f4476a.a(view), bVar.c()), bVar.m());
        long[] jArr = this.f4480e;
        if (jArr != null) {
            i4 = a(jArr[i3]);
        } else {
            i4 = view.getMeasuredHeight();
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i4, 1073741824);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        a(i3, makeMeasureSpec2, makeMeasureSpec, view);
        this.f4476a.a(i3, view);
    }

    /* access modifiers changed from: 0000 */
    public void a(View view, c cVar, int i2, int i3, int i4, int i5) {
        b bVar = (b) view.getLayoutParams();
        int alignItems = this.f4476a.getAlignItems();
        if (bVar.a() != -1) {
            alignItems = bVar.a();
        }
        int i6 = cVar.f4470g;
        if (alignItems != 0) {
            if (alignItems != 1) {
                if (alignItems == 2) {
                    int measuredHeight = (((i6 - view.getMeasuredHeight()) + bVar.f()) - bVar.d()) / 2;
                    if (this.f4476a.getFlexWrap() != 2) {
                        int i7 = i3 + measuredHeight;
                        view.layout(i2, i7, i4, view.getMeasuredHeight() + i7);
                        return;
                    }
                    int i8 = i3 - measuredHeight;
                    view.layout(i2, i8, i4, view.getMeasuredHeight() + i8);
                    return;
                } else if (alignItems != 3) {
                    if (alignItems != 4) {
                        return;
                    }
                } else if (this.f4476a.getFlexWrap() != 2) {
                    int max = Math.max(cVar.f4475l - view.getBaseline(), bVar.f());
                    view.layout(i2, i3 + max, i4, i5 + max);
                    return;
                } else {
                    int max2 = Math.max((cVar.f4475l - view.getMeasuredHeight()) + view.getBaseline(), bVar.d());
                    view.layout(i2, i3 - max2, i4, i5 - max2);
                    return;
                }
            } else if (this.f4476a.getFlexWrap() != 2) {
                int i9 = i3 + i6;
                view.layout(i2, (i9 - view.getMeasuredHeight()) - bVar.d(), i4, i9 - bVar.d());
                return;
            } else {
                view.layout(i2, (i3 - i6) + view.getMeasuredHeight() + bVar.f(), i4, (i5 - i6) + view.getMeasuredHeight() + bVar.f());
                return;
            }
        }
        if (this.f4476a.getFlexWrap() != 2) {
            view.layout(i2, i3 + bVar.f(), i4, i5 + bVar.f());
        } else {
            view.layout(i2, i3 - bVar.d(), i4, i5 - bVar.d());
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(View view, c cVar, boolean z, int i2, int i3, int i4, int i5) {
        b bVar = (b) view.getLayoutParams();
        int alignItems = this.f4476a.getAlignItems();
        if (bVar.a() != -1) {
            alignItems = bVar.a();
        }
        int i6 = cVar.f4470g;
        if (alignItems != 0) {
            if (alignItems != 1) {
                if (alignItems == 2) {
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
                    int measuredWidth = (((i6 - view.getMeasuredWidth()) + C0246g.b(marginLayoutParams)) - C0246g.a(marginLayoutParams)) / 2;
                    if (!z) {
                        view.layout(i2 + measuredWidth, i3, i4 + measuredWidth, i5);
                        return;
                    } else {
                        view.layout(i2 - measuredWidth, i3, i4 - measuredWidth, i5);
                        return;
                    }
                } else if (!(alignItems == 3 || alignItems == 4)) {
                    return;
                }
            } else if (!z) {
                view.layout(((i2 + i6) - view.getMeasuredWidth()) - bVar.i(), i3, ((i4 + i6) - view.getMeasuredWidth()) - bVar.i(), i5);
                return;
            } else {
                view.layout((i2 - i6) + view.getMeasuredWidth() + bVar.e(), i3, (i4 - i6) + view.getMeasuredWidth() + bVar.e(), i5);
                return;
            }
        }
        if (!z) {
            view.layout(i2 + bVar.e(), i3, i4 + bVar.e(), i5);
        } else {
            view.layout(i2 - bVar.i(), i3, i4 - bVar.i(), i5);
        }
    }

    private void a(int i2, int i3, int i4, View view) {
        long[] jArr = this.f4479d;
        if (jArr != null) {
            jArr[i2] = b(i3, i4);
        }
        long[] jArr2 = this.f4480e;
        if (jArr2 != null) {
            jArr2[i2] = b(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2) {
        int[] iArr = this.f4478c;
        if (iArr == null) {
            if (i2 < 10) {
                i2 = 10;
            }
            this.f4478c = new int[i2];
        } else if (iArr.length < i2) {
            int length = iArr.length * 2;
            if (length >= i2) {
                i2 = length;
            }
            this.f4478c = Arrays.copyOf(this.f4478c, i2);
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(List<c> list, int i2) {
        int i3 = this.f4478c[i2];
        if (i3 == -1) {
            i3 = 0;
        }
        for (int size = list.size() - 1; size >= i3; size--) {
            list.remove(size);
        }
        int[] iArr = this.f4478c;
        int length = iArr.length - 1;
        if (i2 > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, i2, length, -1);
        }
        long[] jArr = this.f4479d;
        int length2 = jArr.length - 1;
        if (i2 > length2) {
            Arrays.fill(jArr, 0);
        } else {
            Arrays.fill(jArr, i2, length2, 0);
        }
    }
}
