package b.g.i.a;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompat */
public class e {

    /* renamed from: a reason: collision with root package name */
    private final Object f2688a;

    /* compiled from: AccessibilityNodeProviderCompat */
    static class a extends AccessibilityNodeProvider {

        /* renamed from: a reason: collision with root package name */
        final e f2689a;

        a(e eVar) {
            this.f2689a = eVar;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i2) {
            d a2 = this.f2689a.a(i2);
            if (a2 == null) {
                return null;
            }
            return a2.u();
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i2) {
            List a2 = this.f2689a.a(str, i2);
            if (a2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = a2.size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(((d) a2.get(i3)).u());
            }
            return arrayList;
        }

        public boolean performAction(int i2, int i3, Bundle bundle) {
            return this.f2689a.a(i2, i3, bundle);
        }
    }

    /* compiled from: AccessibilityNodeProviderCompat */
    static class b extends a {
        b(e eVar) {
            super(eVar);
        }

        public AccessibilityNodeInfo findFocus(int i2) {
            d b2 = this.f2689a.b(i2);
            if (b2 == null) {
                return null;
            }
            return b2.u();
        }
    }

    public e() {
        int i2 = VERSION.SDK_INT;
        if (i2 >= 19) {
            this.f2688a = new b(this);
        } else if (i2 >= 16) {
            this.f2688a = new a(this);
        } else {
            this.f2688a = null;
        }
    }

    public d a(int i2) {
        return null;
    }

    public Object a() {
        return this.f2688a;
    }

    public List<d> a(String str, int i2) {
        return null;
    }

    public boolean a(int i2, int i3, Bundle bundle) {
        return false;
    }

    public d b(int i2) {
        return null;
    }

    public e(Object obj) {
        this.f2688a = obj;
    }
}
