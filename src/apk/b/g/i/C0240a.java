package b.g.i;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import b.g.c;
import b.g.i.a.d;
import b.g.i.a.d.a;
import b.g.i.a.e;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* renamed from: b.g.i.a reason: case insensitive filesystem */
/* compiled from: AccessibilityDelegateCompat */
public class C0240a {

    /* renamed from: a reason: collision with root package name */
    private static final AccessibilityDelegate f2662a = new AccessibilityDelegate();

    /* renamed from: b reason: collision with root package name */
    private final AccessibilityDelegate f2663b;

    /* renamed from: c reason: collision with root package name */
    private final AccessibilityDelegate f2664c;

    /* renamed from: b.g.i.a$a reason: collision with other inner class name */
    /* compiled from: AccessibilityDelegateCompat */
    static final class C0027a extends AccessibilityDelegate {

        /* renamed from: a reason: collision with root package name */
        final C0240a f2665a;

        C0027a(C0240a aVar) {
            this.f2665a = aVar;
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f2665a.a(view, accessibilityEvent);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            e a2 = this.f2665a.a(view);
            if (a2 != null) {
                return (AccessibilityNodeProvider) a2.a();
            }
            return null;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f2665a.b(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            d a2 = d.a(accessibilityNodeInfo);
            a2.i(B.F(view));
            a2.h(B.A(view));
            a2.e(B.c(view));
            this.f2665a.a(view, a2);
            a2.a(accessibilityNodeInfo.getText(), view);
            List b2 = C0240a.b(view);
            for (int i2 = 0; i2 < b2.size(); i2++) {
                a2.a((a) b2.get(i2));
            }
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f2665a.c(view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f2665a.a(viewGroup, view, accessibilityEvent);
        }

        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            return this.f2665a.a(view, i2, bundle);
        }

        public void sendAccessibilityEvent(View view, int i2) {
            this.f2665a.a(view, i2);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f2665a.d(view, accessibilityEvent);
        }
    }

    public C0240a() {
        this(f2662a);
    }

    /* access modifiers changed from: 0000 */
    public AccessibilityDelegate a() {
        return this.f2664c;
    }

    public void b(View view, AccessibilityEvent accessibilityEvent) {
        this.f2663b.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.f2663b.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        this.f2663b.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public C0240a(AccessibilityDelegate accessibilityDelegate) {
        this.f2663b = accessibilityDelegate;
        this.f2664c = new C0027a(this);
    }

    static List<a> b(View view) {
        List<a> list = (List) view.getTag(c.tag_accessibility_actions);
        return list == null ? Collections.emptyList() : list;
    }

    public void a(View view, int i2) {
        this.f2663b.sendAccessibilityEvent(view, i2);
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f2663b.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void a(View view, d dVar) {
        this.f2663b.onInitializeAccessibilityNodeInfo(view, dVar.u());
    }

    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f2663b.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public e a(View view) {
        if (VERSION.SDK_INT >= 16) {
            AccessibilityNodeProvider accessibilityNodeProvider = this.f2663b.getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return new e(accessibilityNodeProvider);
            }
        }
        return null;
    }

    public boolean a(View view, int i2, Bundle bundle) {
        List b2 = b(view);
        boolean z = false;
        int i3 = 0;
        while (true) {
            if (i3 >= b2.size()) {
                break;
            }
            a aVar = (a) b2.get(i3);
            if (aVar.a() == i2) {
                z = aVar.a(view, bundle);
                break;
            }
            i3++;
        }
        if (!z && VERSION.SDK_INT >= 16) {
            z = this.f2663b.performAccessibilityAction(view, i2, bundle);
        }
        return (z || i2 != c.accessibility_action_clickable_span) ? z : a(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    private boolean a(int i2, View view) {
        SparseArray sparseArray = (SparseArray) view.getTag(c.tag_accessibility_clickable_spans);
        if (sparseArray != null) {
            WeakReference weakReference = (WeakReference) sparseArray.get(i2);
            if (weakReference != null) {
                ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
                if (a(clickableSpan, view)) {
                    clickableSpan.onClick(view);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean a(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] a2 = d.a(view.createAccessibilityNodeInfo().getText());
            int i2 = 0;
            while (a2 != null && i2 < a2.length) {
                if (clickableSpan.equals(a2[i2])) {
                    return true;
                }
                i2++;
            }
        }
        return false;
    }
}
