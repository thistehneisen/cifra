package androidx.recyclerview.widget;

import java.util.List;

/* compiled from: OpReorderer */
class F {

    /* renamed from: a reason: collision with root package name */
    final a f1694a;

    /* compiled from: OpReorderer */
    interface a {
        b a(int i2, int i3, int i4, Object obj);

        void a(b bVar);
    }

    F(a aVar) {
        this.f1694a = aVar;
    }

    private void c(List<b> list, int i2, b bVar, int i3, b bVar2) {
        int i4 = bVar.f1880d < bVar2.f1878b ? -1 : 0;
        if (bVar.f1878b < bVar2.f1878b) {
            i4++;
        }
        int i5 = bVar2.f1878b;
        int i6 = bVar.f1878b;
        if (i5 <= i6) {
            bVar.f1878b = i6 + bVar2.f1880d;
        }
        int i7 = bVar2.f1878b;
        int i8 = bVar.f1880d;
        if (i7 <= i8) {
            bVar.f1880d = i8 + bVar2.f1880d;
        }
        bVar2.f1878b += i4;
        list.set(i2, bVar2);
        list.set(i3, bVar);
    }

    /* access modifiers changed from: 0000 */
    public void a(List<b> list) {
        while (true) {
            int b2 = b(list);
            if (b2 != -1) {
                a(list, b2, b2 + 1);
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0027  */
    public void b(List<b> list, int i2, b bVar, int i3, b bVar2) {
        Object obj;
        int i4;
        int i5;
        int i6 = bVar.f1880d;
        int i7 = bVar2.f1878b;
        b bVar3 = null;
        if (i6 < i7) {
            bVar2.f1878b = i7 - 1;
        } else {
            int i8 = bVar2.f1880d;
            if (i6 < i7 + i8) {
                bVar2.f1880d = i8 - 1;
                obj = this.f1694a.a(4, bVar.f1878b, 1, bVar2.f1879c);
                i4 = bVar.f1878b;
                i5 = bVar2.f1878b;
                if (i4 > i5) {
                    bVar2.f1878b = i5 + 1;
                } else {
                    int i9 = bVar2.f1880d;
                    if (i4 < i5 + i9) {
                        int i10 = (i5 + i9) - i4;
                        bVar3 = this.f1694a.a(4, i4 + 1, i10, bVar2.f1879c);
                        bVar2.f1880d -= i10;
                    }
                }
                list.set(i3, bVar);
                if (bVar2.f1880d <= 0) {
                    list.set(i2, bVar2);
                } else {
                    list.remove(i2);
                    this.f1694a.a(bVar2);
                }
                if (obj != null) {
                    list.add(i2, obj);
                }
                if (bVar3 == null) {
                    list.add(i2, bVar3);
                    return;
                }
                return;
            }
        }
        obj = null;
        i4 = bVar.f1878b;
        i5 = bVar2.f1878b;
        if (i4 > i5) {
        }
        list.set(i3, bVar);
        if (bVar2.f1880d <= 0) {
        }
        if (obj != null) {
        }
        if (bVar3 == null) {
        }
    }

    private void a(List<b> list, int i2, int i3) {
        b bVar = (b) list.get(i2);
        b bVar2 = (b) list.get(i3);
        int i4 = bVar2.f1877a;
        if (i4 == 1) {
            c(list, i2, bVar, i3, bVar2);
        } else if (i4 == 2) {
            a(list, i2, bVar, i3, bVar2);
        } else if (i4 == 4) {
            b(list, i2, bVar, i3, bVar2);
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0077  */
    public void a(List<b> list, int i2, b bVar, int i3, b bVar2) {
        boolean z;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = bVar.f1878b;
        int i9 = bVar.f1880d;
        boolean z2 = false;
        if (i8 < i9) {
            if (bVar2.f1878b == i8 && bVar2.f1880d == i9 - i8) {
                z = false;
            } else {
                z = false;
                i4 = bVar.f1880d;
                i5 = bVar2.f1878b;
                if (i4 < i5) {
                    bVar2.f1878b = i5 - 1;
                } else {
                    int i10 = bVar2.f1880d;
                    if (i4 < i5 + i10) {
                        bVar2.f1880d = i10 - 1;
                        bVar.f1877a = 2;
                        bVar.f1880d = 1;
                        if (bVar2.f1880d == 0) {
                            list.remove(i3);
                            this.f1694a.a(bVar2);
                        }
                        return;
                    }
                }
                i6 = bVar.f1878b;
                i7 = bVar2.f1878b;
                b bVar3 = null;
                if (i6 <= i7) {
                    bVar2.f1878b = i7 + 1;
                } else {
                    int i11 = bVar2.f1880d;
                    if (i6 < i7 + i11) {
                        bVar3 = this.f1694a.a(2, i6 + 1, (i7 + i11) - i6, null);
                        bVar2.f1880d = bVar.f1878b - bVar2.f1878b;
                    }
                }
                if (z2) {
                    list.set(i2, bVar2);
                    list.remove(i3);
                    this.f1694a.a(bVar);
                    return;
                }
                if (z) {
                    if (bVar3 != null) {
                        int i12 = bVar.f1878b;
                        if (i12 > bVar3.f1878b) {
                            bVar.f1878b = i12 - bVar3.f1880d;
                        }
                        int i13 = bVar.f1880d;
                        if (i13 > bVar3.f1878b) {
                            bVar.f1880d = i13 - bVar3.f1880d;
                        }
                    }
                    int i14 = bVar.f1878b;
                    if (i14 > bVar2.f1878b) {
                        bVar.f1878b = i14 - bVar2.f1880d;
                    }
                    int i15 = bVar.f1880d;
                    if (i15 > bVar2.f1878b) {
                        bVar.f1880d = i15 - bVar2.f1880d;
                    }
                } else {
                    if (bVar3 != null) {
                        int i16 = bVar.f1878b;
                        if (i16 >= bVar3.f1878b) {
                            bVar.f1878b = i16 - bVar3.f1880d;
                        }
                        int i17 = bVar.f1880d;
                        if (i17 >= bVar3.f1878b) {
                            bVar.f1880d = i17 - bVar3.f1880d;
                        }
                    }
                    int i18 = bVar.f1878b;
                    if (i18 >= bVar2.f1878b) {
                        bVar.f1878b = i18 - bVar2.f1880d;
                    }
                    int i19 = bVar.f1880d;
                    if (i19 >= bVar2.f1878b) {
                        bVar.f1880d = i19 - bVar2.f1880d;
                    }
                }
                list.set(i2, bVar2);
                if (bVar.f1878b != bVar.f1880d) {
                    list.set(i3, bVar);
                } else {
                    list.remove(i3);
                }
                if (bVar3 != null) {
                    list.add(i2, bVar3);
                }
                return;
            }
        } else if (bVar2.f1878b == i9 + 1 && bVar2.f1880d == i8 - i9) {
            z = true;
        } else {
            z = true;
            i4 = bVar.f1880d;
            i5 = bVar2.f1878b;
            if (i4 < i5) {
            }
            i6 = bVar.f1878b;
            i7 = bVar2.f1878b;
            b bVar32 = null;
            if (i6 <= i7) {
            }
            if (z2) {
            }
        }
        z2 = true;
        i4 = bVar.f1880d;
        i5 = bVar2.f1878b;
        if (i4 < i5) {
        }
        i6 = bVar.f1878b;
        i7 = bVar2.f1878b;
        b bVar322 = null;
        if (i6 <= i7) {
        }
        if (z2) {
        }
    }

    private int b(List<b> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (((b) list.get(size)).f1877a != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }
}
