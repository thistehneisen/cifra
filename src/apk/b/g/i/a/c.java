package b.g.i.a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener;

/* compiled from: AccessibilityManagerCompat */
public final class c {

    /* compiled from: AccessibilityManagerCompat */
    public interface a {
        void onTouchExplorationStateChanged(boolean z);
    }

    /* compiled from: AccessibilityManagerCompat */
    private static class b implements TouchExplorationStateChangeListener {

        /* renamed from: a reason: collision with root package name */
        final a f2669a;

        b(a aVar) {
            this.f2669a = aVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            return this.f2669a.equals(((b) obj).f2669a);
        }

        public int hashCode() {
            return this.f2669a.hashCode();
        }

        public void onTouchExplorationStateChanged(boolean z) {
            this.f2669a.onTouchExplorationStateChanged(z);
        }
    }

    public static boolean a(AccessibilityManager accessibilityManager, a aVar) {
        if (VERSION.SDK_INT < 19 || aVar == null) {
            return false;
        }
        return accessibilityManager.addTouchExplorationStateChangeListener(new b(aVar));
    }

    public static boolean b(AccessibilityManager accessibilityManager, a aVar) {
        if (VERSION.SDK_INT < 19 || aVar == null) {
            return false;
        }
        return accessibilityManager.removeTouchExplorationStateChangeListener(new b(aVar));
    }
}
