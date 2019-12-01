package b.g.i.a;

import android.os.Build.VERSION;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;

/* compiled from: AccessibilityRecordCompat */
public class f {
    public static void a(AccessibilityRecord accessibilityRecord, View view, int i2) {
        if (VERSION.SDK_INT >= 16) {
            accessibilityRecord.setSource(view, i2);
        }
    }

    public static void b(AccessibilityRecord accessibilityRecord, int i2) {
        if (VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollY(i2);
        }
    }

    public static void a(AccessibilityRecord accessibilityRecord, int i2) {
        if (VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollX(i2);
        }
    }
}
