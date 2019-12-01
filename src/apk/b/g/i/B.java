package b.g.i;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ViewCompat */
public class B {

    /* renamed from: a reason: collision with root package name */
    private static final AtomicInteger f2624a = new AtomicInteger(1);

    /* renamed from: b reason: collision with root package name */
    private static Field f2625b;

    /* renamed from: c reason: collision with root package name */
    private static boolean f2626c;

    /* renamed from: d reason: collision with root package name */
    private static Field f2627d;

    /* renamed from: e reason: collision with root package name */
    private static boolean f2628e;

    /* renamed from: f reason: collision with root package name */
    private static WeakHashMap<View, String> f2629f;

    /* renamed from: g reason: collision with root package name */
    private static WeakHashMap<View, K> f2630g = null;

    /* renamed from: h reason: collision with root package name */
    private static Field f2631h;

    /* renamed from: i reason: collision with root package name */
    private static boolean f2632i = false;

    /* renamed from: j reason: collision with root package name */
    private static ThreadLocal<Rect> f2633j;

    /* renamed from: k reason: collision with root package name */
    private static final int[] f2634k = {b.g.c.accessibility_custom_action_0, b.g.c.accessibility_custom_action_1, b.g.c.accessibility_custom_action_2, b.g.c.accessibility_custom_action_3, b.g.c.accessibility_custom_action_4, b.g.c.accessibility_custom_action_5, b.g.c.accessibility_custom_action_6, b.g.c.accessibility_custom_action_7, b.g.c.accessibility_custom_action_8, b.g.c.accessibility_custom_action_9, b.g.c.accessibility_custom_action_10, b.g.c.accessibility_custom_action_11, b.g.c.accessibility_custom_action_12, b.g.c.accessibility_custom_action_13, b.g.c.accessibility_custom_action_14, b.g.c.accessibility_custom_action_15, b.g.c.accessibility_custom_action_16, b.g.c.accessibility_custom_action_17, b.g.c.accessibility_custom_action_18, b.g.c.accessibility_custom_action_19, b.g.c.accessibility_custom_action_20, b.g.c.accessibility_custom_action_21, b.g.c.accessibility_custom_action_22, b.g.c.accessibility_custom_action_23, b.g.c.accessibility_custom_action_24, b.g.c.accessibility_custom_action_25, b.g.c.accessibility_custom_action_26, b.g.c.accessibility_custom_action_27, b.g.c.accessibility_custom_action_28, b.g.c.accessibility_custom_action_29, b.g.c.accessibility_custom_action_30, b.g.c.accessibility_custom_action_31};

    /* renamed from: l reason: collision with root package name */
    private static a f2635l = new a();

    /* compiled from: ViewCompat */
    static class a implements OnGlobalLayoutListener, OnAttachStateChangeListener {

        /* renamed from: a reason: collision with root package name */
        private WeakHashMap<View, Boolean> f2636a = new WeakHashMap<>();

        a() {
        }

        private void a(View view, boolean z) {
            boolean z2 = view.getVisibility() == 0;
            if (z != z2) {
                if (z2) {
                    B.a(view, 16);
                }
                this.f2636a.put(view, Boolean.valueOf(z2));
            }
        }

        public void onGlobalLayout() {
            for (Entry entry : this.f2636a.entrySet()) {
                a((View) entry.getKey(), ((Boolean) entry.getValue()).booleanValue());
            }
        }

        public void onViewAttachedToWindow(View view) {
            a(view);
        }

        public void onViewDetachedFromWindow(View view) {
        }

        private void a(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }
    }

    /* compiled from: ViewCompat */
    static abstract class b<T> {

        /* renamed from: a reason: collision with root package name */
        private final int f2637a;

        /* renamed from: b reason: collision with root package name */
        private final Class<T> f2638b;

        /* renamed from: c reason: collision with root package name */
        private final int f2639c;

        /* renamed from: d reason: collision with root package name */
        private final int f2640d;

        b(int i2, Class<T> cls, int i3) {
            this(i2, cls, 0, i3);
        }

        private boolean a() {
            return VERSION.SDK_INT >= 19;
        }

        /* access modifiers changed from: 0000 */
        public abstract T a(View view);

        /* access modifiers changed from: 0000 */
        public T b(View view) {
            if (b()) {
                return a(view);
            }
            if (a()) {
                T tag = view.getTag(this.f2637a);
                if (this.f2638b.isInstance(tag)) {
                    return tag;
                }
            }
            return null;
        }

        b(int i2, Class<T> cls, int i3, int i4) {
            this.f2637a = i2;
            this.f2638b = cls;
            this.f2640d = i3;
            this.f2639c = i4;
        }

        private boolean b() {
            return VERSION.SDK_INT >= this.f2639c;
        }
    }

    /* compiled from: ViewCompat */
    public interface c {
        boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent);
    }

    /* compiled from: ViewCompat */
    static class d {

        /* renamed from: a reason: collision with root package name */
        private static final ArrayList<WeakReference<View>> f2641a = new ArrayList<>();

        /* renamed from: b reason: collision with root package name */
        private WeakHashMap<View, Boolean> f2642b = null;

        /* renamed from: c reason: collision with root package name */
        private SparseArray<WeakReference<View>> f2643c = null;

        /* renamed from: d reason: collision with root package name */
        private WeakReference<KeyEvent> f2644d = null;

        d() {
        }

        private SparseArray<WeakReference<View>> a() {
            if (this.f2643c == null) {
                this.f2643c = new SparseArray<>();
            }
            return this.f2643c;
        }

        private View b(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f2642b;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View b2 = b(viewGroup.getChildAt(childCount), keyEvent);
                        if (b2 != null) {
                            return b2;
                        }
                    }
                }
                if (c(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private boolean c(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(b.g.c.tag_unhandled_key_listeners);
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (((c) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                        return true;
                    }
                }
            }
            return false;
        }

        static d a(View view) {
            d dVar = (d) view.getTag(b.g.c.tag_unhandled_key_event_manager);
            if (dVar != null) {
                return dVar;
            }
            d dVar2 = new d();
            view.setTag(b.g.c.tag_unhandled_key_event_manager, dVar2);
            return dVar2;
        }

        private void b() {
            WeakHashMap<View, Boolean> weakHashMap = this.f2642b;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            if (!f2641a.isEmpty()) {
                synchronized (f2641a) {
                    if (this.f2642b == null) {
                        this.f2642b = new WeakHashMap<>();
                    }
                    for (int size = f2641a.size() - 1; size >= 0; size--) {
                        View view = (View) ((WeakReference) f2641a.get(size)).get();
                        if (view == null) {
                            f2641a.remove(size);
                        } else {
                            this.f2642b.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.f2642b.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean a(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                b();
            }
            View b2 = b(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (b2 != null && !KeyEvent.isModifierKey(keyCode)) {
                    a().put(keyCode, new WeakReference(b2));
                }
            }
            return b2 != null;
        }

        /* access modifiers changed from: 0000 */
        public boolean a(KeyEvent keyEvent) {
            WeakReference<KeyEvent> weakReference = this.f2644d;
            if (weakReference != null && weakReference.get() == keyEvent) {
                return false;
            }
            this.f2644d = new WeakReference<>(keyEvent);
            WeakReference weakReference2 = null;
            SparseArray a2 = a();
            if (keyEvent.getAction() == 1) {
                int indexOfKey = a2.indexOfKey(keyEvent.getKeyCode());
                if (indexOfKey >= 0) {
                    weakReference2 = (WeakReference) a2.valueAt(indexOfKey);
                    a2.removeAt(indexOfKey);
                }
            }
            if (weakReference2 == null) {
                weakReference2 = (WeakReference) a2.get(keyEvent.getKeyCode());
            }
            if (weakReference2 == null) {
                return false;
            }
            View view = (View) weakReference2.get();
            if (view != null && B.B(view)) {
                c(view, keyEvent);
            }
            return true;
        }
    }

    public static boolean A(View view) {
        Boolean bool = (Boolean) b().b(view);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static boolean B(View view) {
        if (VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    public static boolean C(View view) {
        if (VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    public static boolean D(View view) {
        if (VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof C0251l) {
            return ((C0251l) view).isNestedScrollingEnabled();
        }
        return false;
    }

    public static boolean E(View view) {
        if (VERSION.SDK_INT >= 17) {
            return view.isPaddingRelative();
        }
        return false;
    }

    public static boolean F(View view) {
        Boolean bool = (Boolean) e().b(view);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static void G(View view) {
        if (VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    public static void H(View view) {
        int i2 = VERSION.SDK_INT;
        if (i2 >= 20) {
            view.requestApplyInsets();
        } else if (i2 >= 16) {
            view.requestFitSystemWindows();
        }
    }

    public static void I(View view) {
        if (VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof C0251l) {
            ((C0251l) view).stopNestedScroll();
        }
    }

    private static AccessibilityDelegate J(View view) {
        if (f2632i) {
            return null;
        }
        if (f2631h == null) {
            try {
                f2631h = View.class.getDeclaredField("mAccessibilityDelegate");
                f2631h.setAccessible(true);
            } catch (Throwable unused) {
                f2632i = true;
                return null;
            }
        }
        try {
            Object obj = f2631h.get(view);
            if (obj instanceof AccessibilityDelegate) {
                return (AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f2632i = true;
            return null;
        }
    }

    private static void K(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static void a(View view, b.g.i.a.d dVar) {
        view.onInitializeAccessibilityNodeInfo(dVar.u());
    }

    public static void b(View view, boolean z) {
        if (VERSION.SDK_INT >= 16) {
            view.setHasTransientState(z);
        }
    }

    private static Rect c() {
        if (f2633j == null) {
            f2633j = new ThreadLocal<>();
        }
        Rect rect = (Rect) f2633j.get();
        if (rect == null) {
            rect = new Rect();
            f2633j.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    @Deprecated
    public static float d(View view) {
        return view.getAlpha();
    }

    public static void e(View view, int i2) {
        int i3 = VERSION.SDK_INT;
        if (i3 >= 19) {
            view.setImportantForAccessibility(i2);
        } else if (i3 >= 16) {
            if (i2 == 4) {
                i2 = 2;
            }
            view.setImportantForAccessibility(i2);
        }
    }

    public static void f(View view, int i2) {
        if (VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i2);
        }
    }

    @Deprecated
    public static void g(View view, float f2) {
        view.setRotationY(f2);
    }

    @Deprecated
    public static void h(View view, float f2) {
        view.setScaleX(f2);
    }

    @Deprecated
    public static void i(View view, float f2) {
        view.setScaleY(f2);
    }

    @Deprecated
    public static void j(View view, float f2) {
        view.setTranslationX(f2);
    }

    public static int k(View view) {
        if (VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    @SuppressLint({"InlinedApi"})
    public static int l(View view) {
        if (VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static int m(View view) {
        if (VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    public static int n(View view) {
        if (VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!f2628e) {
            try {
                f2627d = View.class.getDeclaredField("mMinHeight");
                f2627d.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f2628e = true;
        }
        Field field = f2627d;
        if (field != null) {
            try {
                return ((Integer) field.get(view)).intValue();
            } catch (Exception unused2) {
            }
        }
        return 0;
    }

    public static int o(View view) {
        if (VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!f2626c) {
            try {
                f2625b = View.class.getDeclaredField("mMinWidth");
                f2625b.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f2626c = true;
        }
        Field field = f2625b;
        if (field != null) {
            try {
                return ((Integer) field.get(view)).intValue();
            } catch (Exception unused2) {
            }
        }
        return 0;
    }

    public static int p(View view) {
        if (VERSION.SDK_INT >= 17) {
            return view.getPaddingEnd();
        }
        return view.getPaddingRight();
    }

    public static int q(View view) {
        if (VERSION.SDK_INT >= 17) {
            return view.getPaddingStart();
        }
        return view.getPaddingLeft();
    }

    public static String r(View view) {
        if (VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = f2629f;
        if (weakHashMap == null) {
            return null;
        }
        return (String) weakHashMap.get(view);
    }

    @Deprecated
    public static float s(View view) {
        return view.getTranslationX();
    }

    @Deprecated
    public static float t(View view) {
        return view.getTranslationY();
    }

    public static int u(View view) {
        if (VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    public static float v(View view) {
        if (VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    public static boolean w(View view) {
        return J(view) != null;
    }

    public static boolean x(View view) {
        if (VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    public static boolean y(View view) {
        if (VERSION.SDK_INT >= 16) {
            return view.hasOverlappingRendering();
        }
        return true;
    }

    public static boolean z(View view) {
        if (VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    public static void a(View view, C0240a aVar) {
        AccessibilityDelegate accessibilityDelegate;
        if (aVar == null && (J(view) instanceof C0027a)) {
            aVar = new C0240a();
        }
        if (aVar == null) {
            accessibilityDelegate = null;
        } else {
            accessibilityDelegate = aVar.a();
        }
        view.setAccessibilityDelegate(accessibilityDelegate);
    }

    public static void d(View view, int i2) {
        if (VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(i2);
        }
    }

    public static void g(View view, int i2) {
        if (view instanceof C0249j) {
            ((C0249j) view).a(i2);
        } else if (i2 == 0) {
            I(view);
        }
    }

    private static void h(View view, int i2) {
        view.offsetLeftAndRight(i2);
        if (view.getVisibility() == 0) {
            K(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                K((View) parent);
            }
        }
    }

    public static float i(View view) {
        if (VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    public static boolean j(View view) {
        if (VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    public static int b(View view) {
        if (VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    @Deprecated
    public static void f(View view, float f2) {
        view.setRotationX(f2);
    }

    @Deprecated
    public static void k(View view, float f2) {
        view.setTranslationY(f2);
    }

    @Deprecated
    public static void d(View view, float f2) {
        view.setPivotY(f2);
    }

    @Deprecated
    public static void e(View view, float f2) {
        view.setRotation(f2);
    }

    public static Mode f(View view) {
        if (VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        return view instanceof v ? ((v) view).getSupportBackgroundTintMode() : null;
    }

    private static void i(View view, int i2) {
        view.offsetTopAndBottom(i2);
        if (view.getVisibility() == 0) {
            K(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                K((View) parent);
            }
        }
    }

    public static void a(View view, Runnable runnable) {
        if (VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    public static void b(View view, float f2) {
        if (VERSION.SDK_INT >= 21) {
            view.setElevation(f2);
        }
    }

    private static b<CharSequence> d() {
        return new z(b.g.c.tag_accessibility_pane_title, CharSequence.class, 8, 28);
    }

    public static ColorStateList e(View view) {
        if (VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        return view instanceof v ? ((v) view).getSupportBackgroundTintList() : null;
    }

    public static Rect g(View view) {
        if (VERSION.SDK_INT >= 18) {
            return view.getClipBounds();
        }
        return null;
    }

    public static O b(View view, O o) {
        if (VERSION.SDK_INT < 21) {
            return o;
        }
        WindowInsets windowInsets = (WindowInsets) O.a(o);
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
        if (!onApplyWindowInsets.equals(windowInsets)) {
            windowInsets = new WindowInsets(onApplyWindowInsets);
        }
        return O.a((Object) windowInsets);
    }

    @Deprecated
    public static void c(View view, float f2) {
        view.setPivotX(f2);
    }

    public static void a(View view, Runnable runnable, long j2) {
        if (VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j2);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j2);
        }
    }

    public static void c(View view, int i2) {
        int i3 = VERSION.SDK_INT;
        if (i3 >= 23) {
            view.offsetTopAndBottom(i2);
        } else if (i3 >= 21) {
            Rect c2 = c();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                c2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !c2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            i(view, i2);
            if (z && c2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(c2);
            }
        } else {
            i(view, i2);
        }
    }

    public static Display h(View view) {
        if (VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (B(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    private static b<Boolean> e() {
        return new y(b.g.c.tag_screen_reader_focusable, Boolean.class, 28);
    }

    public static boolean a(View view, int i2, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            return view.performAccessibilityAction(i2, bundle);
        }
        return false;
    }

    public static void a(View view, int i2, int i3, int i4, int i5) {
        if (VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i2, i3, i4, i5);
        } else {
            view.setPadding(i2, i3, i4, i5);
        }
    }

    public static void b(View view, int i2) {
        int i3 = VERSION.SDK_INT;
        if (i3 >= 23) {
            view.offsetLeftAndRight(i2);
        } else if (i3 >= 21) {
            Rect c2 = c();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                c2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !c2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            h(view, i2);
            if (z && c2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(c2);
            }
        } else {
            h(view, i2);
        }
    }

    public static K a(View view) {
        if (f2630g == null) {
            f2630g = new WeakHashMap<>();
        }
        K k2 = (K) f2630g.get(view);
        if (k2 != null) {
            return k2;
        }
        K k3 = new K(view);
        f2630g.put(view, k3);
        return k3;
    }

    @Deprecated
    public static void a(View view, float f2) {
        view.setAlpha(f2);
    }

    public static void a(View view, String str) {
        if (VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (f2629f == null) {
            f2629f = new WeakHashMap<>();
        }
        f2629f.put(view, str);
    }

    public static CharSequence c(View view) {
        return (CharSequence) d().b(view);
    }

    @Deprecated
    public static void a(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static void a(View view, r rVar) {
        if (VERSION.SDK_INT >= 21) {
            if (rVar == null) {
                view.setOnApplyWindowInsetsListener(null);
                return;
            }
            view.setOnApplyWindowInsetsListener(new x(rVar));
        }
    }

    static boolean b(View view, KeyEvent keyEvent) {
        if (VERSION.SDK_INT >= 28) {
            return false;
        }
        return d.a(view).a(keyEvent);
    }

    public static O a(View view, O o) {
        if (VERSION.SDK_INT < 21) {
            return o;
        }
        WindowInsets windowInsets = (WindowInsets) O.a(o);
        WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
        if (!dispatchApplyWindowInsets.equals(windowInsets)) {
            windowInsets = new WindowInsets(dispatchApplyWindowInsets);
        }
        return O.a((Object) windowInsets);
    }

    private static b<Boolean> b() {
        return new A(b.g.c.tag_accessibility_heading, Boolean.class, 28);
    }

    public static void a(View view, Drawable drawable) {
        if (VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static void a(View view, ColorStateList colorStateList) {
        if (VERSION.SDK_INT >= 21) {
            view.setBackgroundTintList(colorStateList);
            if (VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && z) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        } else if (view instanceof v) {
            ((v) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    public static void a(View view, Mode mode) {
        if (VERSION.SDK_INT >= 21) {
            view.setBackgroundTintMode(mode);
            if (VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && z) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        } else if (view instanceof v) {
            ((v) view).setSupportBackgroundTintMode(mode);
        }
    }

    public static void a(View view, Rect rect) {
        if (VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    public static void a(View view, int i2, int i3) {
        if (VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i2, i3);
        }
    }

    public static void a(View view, t tVar) {
        if (VERSION.SDK_INT >= 24) {
            view.setPointerIcon((PointerIcon) (tVar != null ? tVar.a() : null));
        }
    }

    public static int a() {
        int i2;
        int i3;
        if (VERSION.SDK_INT >= 17) {
            return View.generateViewId();
        }
        do {
            i2 = f2624a.get();
            i3 = i2 + 1;
            if (i3 > 16777215) {
                i3 = 1;
            }
        } while (!f2624a.compareAndSet(i2, i3));
        return i2;
    }

    static boolean a(View view, KeyEvent keyEvent) {
        if (VERSION.SDK_INT >= 28) {
            return false;
        }
        return d.a(view).a(view, keyEvent);
    }

    static void a(View view, int i2) {
        if (((AccessibilityManager) view.getContext().getSystemService("accessibility")).isEnabled()) {
            boolean z = c(view) != null;
            if (b(view) != 0 || (z && view.getVisibility() == 0)) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(z ? 32 : 2048);
                obtain.setContentChangeTypes(i2);
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i2);
                } catch (AbstractMethodError e2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(view.getParent().getClass().getSimpleName());
                    sb.append(" does not fully implement ViewParent");
                    Log.e("ViewCompat", sb.toString(), e2);
                }
            }
        }
    }
}
