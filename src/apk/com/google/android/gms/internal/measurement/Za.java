package com.google.android.gms.internal.measurement;

import java.util.Comparator;

final class Za implements Comparator<Xa> {
    Za() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        Xa xa = (Xa) obj;
        Xa xa2 = (Xa) obj2;
        C0331bb bbVar = (C0331bb) xa.iterator();
        C0331bb bbVar2 = (C0331bb) xa2.iterator();
        while (bbVar.hasNext() && bbVar2.hasNext()) {
            int compare = Integer.compare(Xa.b(bbVar.nextByte()), Xa.b(bbVar2.nextByte()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(xa.size(), xa2.size());
    }
}
