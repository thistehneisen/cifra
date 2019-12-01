package b.g.i.a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;
import b.g.i.a.g.C0028g;
import b.g.i.a.g.e;
import b.g.i.a.g.f;
import b.g.i.a.g.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AccessibilityNodeInfoCompat */
public class d {

    /* renamed from: a reason: collision with root package name */
    private static int f2670a;

    /* renamed from: b reason: collision with root package name */
    private final AccessibilityNodeInfo f2671b;

    /* renamed from: c reason: collision with root package name */
    public int f2672c = -1;

    /* renamed from: d reason: collision with root package name */
    private int f2673d = -1;

    /* compiled from: AccessibilityNodeInfoCompat */
    public static class a {
        public static final a A;
        public static final a B;
        public static final a C;
        public static final a D;
        public static final a E;
        public static final a F;
        public static final a G;

        /* renamed from: a reason: collision with root package name */
        public static final a f2674a = new a(1, null);

        /* renamed from: b reason: collision with root package name */
        public static final a f2675b = new a(2, null);

        /* renamed from: c reason: collision with root package name */
        public static final a f2676c = new a(4, null);

        /* renamed from: d reason: collision with root package name */
        public static final a f2677d = new a(8, null);

        /* renamed from: e reason: collision with root package name */
        public static final a f2678e = new a(16, null);

        /* renamed from: f reason: collision with root package name */
        public static final a f2679f = new a(32, null);

        /* renamed from: g reason: collision with root package name */
        public static final a f2680g = new a(64, null);

        /* renamed from: h reason: collision with root package name */
        public static final a f2681h = new a(128, null);

        /* renamed from: i reason: collision with root package name */
        public static final a f2682i = new a(256, null, b.g.i.a.g.b.class);

        /* renamed from: j reason: collision with root package name */
        public static final a f2683j = new a(512, null, b.g.i.a.g.b.class);

        /* renamed from: k reason: collision with root package name */
        public static final a f2684k = new a(1024, null, b.g.i.a.g.c.class);

        /* renamed from: l reason: collision with root package name */
        public static final a f2685l = new a(2048, null, b.g.i.a.g.c.class);
        public static final a m = new a(CodedOutputStream.DEFAULT_BUFFER_SIZE, null);
        public static final a n = new a(8192, null);
        public static final a o = new a(16384, null);
        public static final a p = new a(32768, null);
        public static final a q = new a(65536, null);
        public static final a r = new a(131072, null, C0028g.class);
        public static final a s = new a(262144, null);
        public static final a t = new a(524288, null);
        public static final a u = new a(1048576, null);
        public static final a v = new a(2097152, null, h.class);
        public static final a w;
        public static final a x;
        public static final a y;
        public static final a z;
        final Object H;
        private final int I;
        private final CharSequence J;
        private final Class<? extends b.g.i.a.g.a> K;
        protected final g L;

        static {
            AccessibilityAction accessibilityAction = null;
            a aVar = new a(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, 16908342, null, null, null);
            w = aVar;
            a aVar2 = new a(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, 16908343, null, null, e.class);
            x = aVar2;
            a aVar3 = new a(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_SCROLL_UP : null, 16908344, null, null, null);
            y = aVar3;
            a aVar4 = new a(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_SCROLL_LEFT : null, 16908345, null, null, null);
            z = aVar4;
            a aVar5 = new a(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_SCROLL_DOWN : null, 16908346, null, null, null);
            A = aVar5;
            a aVar6 = new a(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_SCROLL_RIGHT : null, 16908347, null, null, null);
            B = aVar6;
            a aVar7 = new a(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_CONTEXT_CLICK : null, 16908348, null, null, null);
            C = aVar7;
            a aVar8 = new a(VERSION.SDK_INT >= 24 ? AccessibilityAction.ACTION_SET_PROGRESS : null, 16908349, null, null, f.class);
            D = aVar8;
            a aVar9 = new a(VERSION.SDK_INT >= 26 ? AccessibilityAction.ACTION_MOVE_WINDOW : null, 16908354, null, null, b.g.i.a.g.d.class);
            E = aVar9;
            a aVar10 = new a(VERSION.SDK_INT >= 28 ? AccessibilityAction.ACTION_SHOW_TOOLTIP : null, 16908356, null, null, null);
            F = aVar10;
            if (VERSION.SDK_INT >= 28) {
                accessibilityAction = AccessibilityAction.ACTION_HIDE_TOOLTIP;
            }
            a aVar11 = new a(accessibilityAction, 16908357, null, null, null);
            G = aVar11;
        }

        public a(int i2, CharSequence charSequence) {
            this(null, i2, charSequence, null, null);
        }

        public int a() {
            if (VERSION.SDK_INT >= 21) {
                return ((AccessibilityAction) this.H).getId();
            }
            return 0;
        }

        private a(int i2, CharSequence charSequence, Class<? extends b.g.i.a.g.a> cls) {
            this(null, i2, charSequence, null, cls);
        }

        a(Object obj, int i2, CharSequence charSequence, g gVar, Class<? extends b.g.i.a.g.a> cls) {
            this.I = i2;
            this.J = charSequence;
            this.L = gVar;
            if (VERSION.SDK_INT < 21 || obj != null) {
                this.H = obj;
            } else {
                this.H = new AccessibilityAction(i2, charSequence);
            }
            this.K = cls;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0025  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0028  */
        public boolean a(View view, Bundle bundle) {
            Class<? extends b.g.i.a.g.a> cls;
            String str;
            if (this.L == null) {
                return false;
            }
            b.g.i.a.g.a aVar = null;
            Class<? extends b.g.i.a.g.a> cls2 = this.K;
            if (cls2 != null) {
                try {
                    b.g.i.a.g.a aVar2 = (b.g.i.a.g.a) cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    try {
                        aVar2.a(bundle);
                        aVar = aVar2;
                    } catch (Exception e2) {
                        e = e2;
                        aVar = aVar2;
                        cls = this.K;
                        if (cls != null) {
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("Failed to execute command with argument class ViewCommandArgument: ");
                        sb.append(str);
                        Log.e("A11yActionCompat", sb.toString(), e);
                        return this.L.a(view, aVar);
                    }
                } catch (Exception e3) {
                    e = e3;
                    cls = this.K;
                    if (cls != null) {
                        str = "null";
                    } else {
                        str = cls.getName();
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to execute command with argument class ViewCommandArgument: ");
                    sb2.append(str);
                    Log.e("A11yActionCompat", sb2.toString(), e);
                    return this.L.a(view, aVar);
                }
            }
            return this.L.a(view, aVar);
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat */
    public static class b {

        /* renamed from: a reason: collision with root package name */
        final Object f2686a;

        b(Object obj) {
            this.f2686a = obj;
        }

        public static b a(int i2, int i3, boolean z, int i4) {
            int i5 = VERSION.SDK_INT;
            if (i5 >= 21) {
                return new b(CollectionInfo.obtain(i2, i3, z, i4));
            }
            if (i5 >= 19) {
                return new b(CollectionInfo.obtain(i2, i3, z));
            }
            return new b(null);
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat */
    public static class c {

        /* renamed from: a reason: collision with root package name */
        final Object f2687a;

        c(Object obj) {
            this.f2687a = obj;
        }

        public static c a(int i2, int i3, int i4, int i5, boolean z, boolean z2) {
            int i6 = VERSION.SDK_INT;
            if (i6 >= 21) {
                return new c(CollectionItemInfo.obtain(i2, i3, i4, i5, z, z2));
            }
            if (i6 >= 19) {
                return new c(CollectionItemInfo.obtain(i2, i3, i4, i5, z));
            }
            return new c(null);
        }
    }

    private d(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f2671b = accessibilityNodeInfo;
    }

    public static d a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new d(accessibilityNodeInfo);
    }

    private static String b(int i2) {
        if (i2 == 1) {
            return "ACTION_FOCUS";
        }
        if (i2 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i2) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case CodedOutputStream.DEFAULT_BUFFER_SIZE /*4096*/:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }

    public static d s() {
        return a(AccessibilityNodeInfo.obtain());
    }

    private void v() {
        if (VERSION.SDK_INT >= 19) {
            this.f2671b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            this.f2671b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            this.f2671b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            this.f2671b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        }
    }

    private boolean w() {
        return !a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    public int b() {
        return this.f2671b.getChildCount();
    }

    public void c(View view, int i2) {
        this.f2673d = i2;
        if (VERSION.SDK_INT >= 16) {
            this.f2671b.setSource(view, i2);
        }
    }

    public void d(Rect rect) {
        this.f2671b.setBoundsInScreen(rect);
    }

    public void e(boolean z) {
        this.f2671b.setEnabled(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f2671b;
        if (accessibilityNodeInfo == null) {
            if (dVar.f2671b != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(dVar.f2671b)) {
            return false;
        }
        return this.f2673d == dVar.f2673d && this.f2672c == dVar.f2672c;
    }

    public void f(boolean z) {
        this.f2671b.setFocusable(z);
    }

    public void g(boolean z) {
        this.f2671b.setFocused(z);
    }

    public String h() {
        if (VERSION.SDK_INT >= 18) {
            return this.f2671b.getViewIdResourceName();
        }
        return null;
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f2671b;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public boolean i() {
        return this.f2671b.isCheckable();
    }

    public boolean j() {
        return this.f2671b.isChecked();
    }

    public void k(boolean z) {
        if (VERSION.SDK_INT >= 16) {
            this.f2671b.setVisibleToUser(z);
        }
    }

    public boolean l() {
        return this.f2671b.isEnabled();
    }

    public boolean m() {
        return this.f2671b.isFocusable();
    }

    public boolean n() {
        return this.f2671b.isFocused();
    }

    public boolean o() {
        return this.f2671b.isLongClickable();
    }

    public boolean p() {
        return this.f2671b.isPassword();
    }

    public boolean q() {
        return this.f2671b.isScrollable();
    }

    public boolean r() {
        return this.f2671b.isSelected();
    }

    public void t() {
        this.f2671b.recycle();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        a(rect);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("; boundsInParent: ");
        sb2.append(rect);
        sb.append(sb2.toString());
        b(rect);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("; boundsInScreen: ");
        sb3.append(rect);
        sb.append(sb3.toString());
        sb.append("; packageName: ");
        sb.append(f());
        sb.append("; className: ");
        sb.append(c());
        sb.append("; text: ");
        sb.append(g());
        sb.append("; contentDescription: ");
        sb.append(d());
        sb.append("; viewId: ");
        sb.append(h());
        sb.append("; checkable: ");
        sb.append(i());
        sb.append("; checked: ");
        sb.append(j());
        sb.append("; focusable: ");
        sb.append(m());
        sb.append("; focused: ");
        sb.append(n());
        sb.append("; selected: ");
        sb.append(r());
        sb.append("; clickable: ");
        sb.append(k());
        sb.append("; longClickable: ");
        sb.append(o());
        sb.append("; enabled: ");
        sb.append(l());
        sb.append("; password: ");
        sb.append(p());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("; scrollable: ");
        sb4.append(q());
        sb.append(sb4.toString());
        sb.append("; [");
        int a2 = a();
        while (a2 != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(a2);
            a2 &= ~numberOfTrailingZeros;
            sb.append(b(numberOfTrailingZeros));
            if (a2 != 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public AccessibilityNodeInfo u() {
        return this.f2671b;
    }

    public static d a(View view) {
        return a(AccessibilityNodeInfo.obtain(view));
    }

    private void e(View view) {
        SparseArray d2 = d(view);
        if (d2 != null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < d2.size(); i2++) {
                if (((WeakReference) d2.valueAt(i2)).get() == null) {
                    arrayList.add(Integer.valueOf(i2));
                }
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                d2.remove(((Integer) arrayList.get(i3)).intValue());
            }
        }
    }

    public void b(View view) {
        this.f2672c = -1;
        this.f2671b.setParent(view);
    }

    public void d(CharSequence charSequence) {
        this.f2671b.setPackageName(charSequence);
    }

    public CharSequence f() {
        return this.f2671b.getPackageName();
    }

    public CharSequence g() {
        if (!w()) {
            return this.f2671b.getText();
        }
        List a2 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List a3 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List a4 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List a5 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f2671b.getText(), 0, this.f2671b.getText().length()));
        for (int i2 = 0; i2 < a2.size(); i2++) {
            spannableString.setSpan(new a(((Integer) a5.get(i2)).intValue(), this, e().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) a2.get(i2)).intValue(), ((Integer) a3.get(i2)).intValue(), ((Integer) a4.get(i2)).intValue());
        }
        return spannableString;
    }

    public void i(boolean z) {
        if (VERSION.SDK_INT >= 28) {
            this.f2671b.setScreenReaderFocusable(z);
        } else {
            a(1, z);
        }
    }

    public void j(boolean z) {
        this.f2671b.setScrollable(z);
    }

    public static d a(d dVar) {
        return a(AccessibilityNodeInfo.obtain(dVar.f2671b));
    }

    private SparseArray<WeakReference<ClickableSpan>> d(View view) {
        return (SparseArray) view.getTag(b.g.c.tag_accessibility_clickable_spans);
    }

    public void f(CharSequence charSequence) {
        this.f2671b.setText(charSequence);
    }

    public void h(boolean z) {
        if (VERSION.SDK_INT >= 28) {
            this.f2671b.setHeading(z);
        } else {
            a(2, z);
        }
    }

    public boolean k() {
        return this.f2671b.isClickable();
    }

    public void a(View view, int i2) {
        if (VERSION.SDK_INT >= 16) {
            this.f2671b.addChild(view, i2);
        }
    }

    public void b(View view, int i2) {
        this.f2672c = i2;
        if (VERSION.SDK_INT >= 16) {
            this.f2671b.setParent(view, i2);
        }
    }

    public void c(Rect rect) {
        this.f2671b.setBoundsInParent(rect);
    }

    public CharSequence d() {
        return this.f2671b.getContentDescription();
    }

    public void c(boolean z) {
        this.f2671b.setChecked(z);
    }

    public void d(boolean z) {
        if (VERSION.SDK_INT >= 19) {
            this.f2671b.setDismissable(z);
        }
    }

    public int a() {
        return this.f2671b.getActions();
    }

    public CharSequence c() {
        return this.f2671b.getClassName();
    }

    private SparseArray<WeakReference<ClickableSpan>> c(View view) {
        SparseArray<WeakReference<ClickableSpan>> d2 = d(view);
        if (d2 != null) {
            return d2;
        }
        SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
        view.setTag(b.g.c.tag_accessibility_clickable_spans, sparseArray);
        return sparseArray;
    }

    public void a(int i2) {
        this.f2671b.addAction(i2);
    }

    public void b(Rect rect) {
        this.f2671b.getBoundsInScreen(rect);
    }

    private List<Integer> a(String str) {
        if (VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        ArrayList integerArrayList = this.f2671b.getExtras().getIntegerArrayList(str);
        if (integerArrayList == null) {
            integerArrayList = new ArrayList();
            this.f2671b.getExtras().putIntegerArrayList(str, integerArrayList);
        }
        return integerArrayList;
    }

    public void b(boolean z) {
        this.f2671b.setCheckable(z);
    }

    public void b(CharSequence charSequence) {
        this.f2671b.setClassName(charSequence);
    }

    public Bundle e() {
        if (VERSION.SDK_INT >= 19) {
            return this.f2671b.getExtras();
        }
        return new Bundle();
    }

    public void b(Object obj) {
        if (VERSION.SDK_INT >= 19) {
            this.f2671b.setCollectionItemInfo(obj == null ? null : (CollectionItemInfo) ((c) obj).f2687a);
        }
    }

    public void c(CharSequence charSequence) {
        this.f2671b.setContentDescription(charSequence);
    }

    public void e(CharSequence charSequence) {
        int i2 = VERSION.SDK_INT;
        if (i2 >= 28) {
            this.f2671b.setPaneTitle(charSequence);
        } else if (i2 >= 19) {
            this.f2671b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public void a(a aVar) {
        if (VERSION.SDK_INT >= 21) {
            this.f2671b.addAction((AccessibilityAction) aVar.H);
        }
    }

    public boolean a(int i2, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            return this.f2671b.performAction(i2, bundle);
        }
        return false;
    }

    public void a(Rect rect) {
        this.f2671b.getBoundsInParent(rect);
    }

    public void a(boolean z) {
        if (VERSION.SDK_INT >= 16) {
            this.f2671b.setAccessibilityFocused(z);
        }
    }

    public void a(CharSequence charSequence, View view) {
        int i2 = VERSION.SDK_INT;
        if (i2 >= 19 && i2 < 26) {
            v();
            e(view);
            ClickableSpan[] a2 = a(charSequence);
            if (a2 != null && a2.length > 0) {
                e().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", b.g.c.accessibility_action_clickable_span);
                SparseArray c2 = c(view);
                int i3 = 0;
                while (a2 != null && i3 < a2.length) {
                    int a3 = a(a2[i3], c2);
                    c2.put(a3, new WeakReference(a2[i3]));
                    a(a2[i3], (Spanned) charSequence, a3);
                    i3++;
                }
            }
        }
    }

    public static ClickableSpan[] a(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private int a(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                if (clickableSpan.equals((ClickableSpan) ((WeakReference) sparseArray.valueAt(i2)).get())) {
                    return sparseArray.keyAt(i2);
                }
            }
        }
        int i3 = f2670a;
        f2670a = i3 + 1;
        return i3;
    }

    private void a(ClickableSpan clickableSpan, Spanned spanned, int i2) {
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i2));
    }

    public void a(Object obj) {
        if (VERSION.SDK_INT >= 19) {
            this.f2671b.setCollectionInfo(obj == null ? null : (CollectionInfo) ((b) obj).f2686a);
        }
    }

    private void a(int i2, boolean z) {
        Bundle e2 = e();
        if (e2 != null) {
            String str = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY";
            int i3 = e2.getInt(str, 0) & (~i2);
            if (!z) {
                i2 = 0;
            }
            e2.putInt(str, i2 | i3);
        }
    }
}
