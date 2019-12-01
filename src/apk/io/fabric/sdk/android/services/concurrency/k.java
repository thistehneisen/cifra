package io.fabric.sdk.android.services.concurrency;

/* compiled from: Priority */
public enum k {
    LOW,
    NORMAL,
    HIGH,
    IMMEDIATE;

    static <Y> int a(p pVar, Y y) {
        k kVar;
        if (y instanceof p) {
            kVar = ((p) y).getPriority();
        } else {
            kVar = NORMAL;
        }
        return kVar.ordinal() - pVar.getPriority().ordinal();
    }
}
