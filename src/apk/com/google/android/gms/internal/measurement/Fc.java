package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

final class Fc extends Gc<FieldDescriptorType, Object> {
    Fc(int i2) {
        super(i2, null);
    }

    public final void b() {
        if (!a()) {
            for (int i2 = 0; i2 < c(); i2++) {
                Entry b2 = b(i2);
                if (((C0458wb) b2.getKey()).q()) {
                    b2.setValue(Collections.unmodifiableList((List) b2.getValue()));
                }
            }
            for (Entry entry : d()) {
                if (((C0458wb) entry.getKey()).q()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.b();
    }
}
