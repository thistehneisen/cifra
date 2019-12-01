package androidx.recyclerview.widget;

import java.util.Comparator;

/* renamed from: androidx.recyclerview.widget.x reason: case insensitive filesystem */
/* compiled from: GapWorker */
class C0237x implements Comparator<b> {
    C0237x() {
    }

    /* renamed from: a */
    public int compare(b bVar, b bVar2) {
        int i2 = 1;
        if ((bVar.f2026d == null) != (bVar2.f2026d == null)) {
            if (bVar.f2026d != null) {
                i2 = -1;
            }
            return i2;
        }
        boolean z = bVar.f2023a;
        if (z != bVar2.f2023a) {
            if (z) {
                i2 = -1;
            }
            return i2;
        }
        int i3 = bVar2.f2024b - bVar.f2024b;
        if (i3 != 0) {
            return i3;
        }
        int i4 = bVar.f2025c - bVar2.f2025c;
        if (i4 != 0) {
            return i4;
        }
        return 0;
    }
}
