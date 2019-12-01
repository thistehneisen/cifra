package androidx.appcompat.widget;

import android.util.Property;

/* compiled from: SwitchCompat */
class ma extends Property<SwitchCompat, Float> {
    ma(Class cls, String str) {
        super(cls, str);
    }

    /* renamed from: a */
    public Float get(SwitchCompat switchCompat) {
        return Float.valueOf(switchCompat.z);
    }

    /* renamed from: a */
    public void set(SwitchCompat switchCompat, Float f2) {
        switchCompat.setThumbPosition(f2.floatValue());
    }
}
