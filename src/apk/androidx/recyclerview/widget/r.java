package androidx.recyclerview.widget;

import java.util.Comparator;

/* compiled from: DiffUtil */
class r implements Comparator<f> {
    r() {
    }

    /* renamed from: a */
    public int compare(f fVar, f fVar2) {
        int i2 = fVar.f1987a - fVar2.f1987a;
        return i2 == 0 ? fVar.f1988b - fVar2.f1988b : i2;
    }
}
