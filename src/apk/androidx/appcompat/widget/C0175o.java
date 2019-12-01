package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import b.d.f;
import b.d.g;
import b.d.j;
import b.q.a.a.k;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: androidx.appcompat.widget.o reason: case insensitive filesystem */
/* compiled from: AppCompatDrawableManager */
public final class C0175o {

    /* renamed from: a reason: collision with root package name */
    private static final Mode f1012a = Mode.SRC_IN;

    /* renamed from: b reason: collision with root package name */
    private static C0175o f1013b;

    /* renamed from: c reason: collision with root package name */
    private static final c f1014c = new c(6);

    /* renamed from: d reason: collision with root package name */
    private static final int[] f1015d = {b.a.e.abc_textfield_search_default_mtrl_alpha, b.a.e.abc_textfield_default_mtrl_alpha, b.a.e.abc_ab_share_pack_mtrl_alpha};

    /* renamed from: e reason: collision with root package name */
    private static final int[] f1016e = {b.a.e.abc_ic_commit_search_api_mtrl_alpha, b.a.e.abc_seekbar_tick_mark_material, b.a.e.abc_ic_menu_share_mtrl_alpha, b.a.e.abc_ic_menu_copy_mtrl_am_alpha, b.a.e.abc_ic_menu_cut_mtrl_alpha, b.a.e.abc_ic_menu_selectall_mtrl_alpha, b.a.e.abc_ic_menu_paste_mtrl_am_alpha};

    /* renamed from: f reason: collision with root package name */
    private static final int[] f1017f = {b.a.e.abc_textfield_activated_mtrl_alpha, b.a.e.abc_textfield_search_activated_mtrl_alpha, b.a.e.abc_cab_background_top_mtrl_alpha, b.a.e.abc_text_cursor_material, b.a.e.abc_text_select_handle_left_mtrl_dark, b.a.e.abc_text_select_handle_middle_mtrl_dark, b.a.e.abc_text_select_handle_right_mtrl_dark, b.a.e.abc_text_select_handle_left_mtrl_light, b.a.e.abc_text_select_handle_middle_mtrl_light, b.a.e.abc_text_select_handle_right_mtrl_light};

    /* renamed from: g reason: collision with root package name */
    private static final int[] f1018g = {b.a.e.abc_popup_background_mtrl_mult, b.a.e.abc_cab_background_internal_bg, b.a.e.abc_menu_hardkey_panel_mtrl_mult};

    /* renamed from: h reason: collision with root package name */
    private static final int[] f1019h = {b.a.e.abc_tab_indicator_material, b.a.e.abc_textfield_search_material};

    /* renamed from: i reason: collision with root package name */
    private static final int[] f1020i = {b.a.e.abc_btn_check_material, b.a.e.abc_btn_radio_material};

    /* renamed from: j reason: collision with root package name */
    private WeakHashMap<Context, j<ColorStateList>> f1021j;

    /* renamed from: k reason: collision with root package name */
    private b.d.b<String, d> f1022k;

    /* renamed from: l reason: collision with root package name */
    private j<String> f1023l;
    private final WeakHashMap<Context, f<WeakReference<ConstantState>>> m = new WeakHashMap<>(0);
    private TypedValue n;
    private boolean o;

    /* renamed from: androidx.appcompat.widget.o$a */
    /* compiled from: AppCompatDrawableManager */
    static class a implements d {
        a() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return b.a.b.a.b.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e2);
                return null;
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.o$b */
    /* compiled from: AppCompatDrawableManager */
    private static class b implements d {
        b() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return b.q.a.a.d.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e2);
                return null;
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.o$c */
    /* compiled from: AppCompatDrawableManager */
    private static class c extends g<Integer, PorterDuffColorFilter> {
        public c(int i2) {
            super(i2);
        }

        private static int b(int i2, Mode mode) {
            return ((i2 + 31) * 31) + mode.hashCode();
        }

        /* access modifiers changed from: 0000 */
        public PorterDuffColorFilter a(int i2, Mode mode) {
            return (PorterDuffColorFilter) b(Integer.valueOf(b(i2, mode)));
        }

        /* access modifiers changed from: 0000 */
        public PorterDuffColorFilter a(int i2, Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) a(Integer.valueOf(b(i2, mode)), porterDuffColorFilter);
        }
    }

    /* renamed from: androidx.appcompat.widget.o$d */
    /* compiled from: AppCompatDrawableManager */
    private interface d {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme);
    }

    /* renamed from: androidx.appcompat.widget.o$e */
    /* compiled from: AppCompatDrawableManager */
    private static class e implements d {
        e() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return k.createFromXmlInner(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e2);
                return null;
            }
        }
    }

    public static synchronized C0175o a() {
        C0175o oVar;
        synchronized (C0175o.class) {
            if (f1013b == null) {
                f1013b = new C0175o();
                a(f1013b);
            }
            oVar = f1013b;
        }
        return oVar;
    }

    private ColorStateList c(Context context) {
        return c(context, 0);
    }

    private Drawable d(Context context, int i2) {
        if (this.n == null) {
            this.n = new TypedValue();
        }
        TypedValue typedValue = this.n;
        context.getResources().getValue(i2, typedValue, true);
        long a2 = a(typedValue);
        Drawable a3 = a(context, a2);
        if (a3 != null) {
            return a3;
        }
        if (i2 == b.a.e.abc_cab_background_top_material) {
            a3 = new LayerDrawable(new Drawable[]{a(context, b.a.e.abc_cab_background_internal_bg), a(context, b.a.e.abc_cab_background_top_mtrl_alpha)});
        }
        if (a3 != null) {
            a3.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, a2, a3);
        }
        return a3;
    }

    private ColorStateList e(Context context, int i2) {
        WeakHashMap<Context, j<ColorStateList>> weakHashMap = this.f1021j;
        if (weakHashMap == null) {
            return null;
        }
        j jVar = (j) weakHashMap.get(context);
        if (jVar != null) {
            return (ColorStateList) jVar.a(i2);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0073 A[Catch:{ Exception -> 0x00a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009a A[Catch:{ Exception -> 0x00a2 }] */
    private Drawable f(Context context, int i2) {
        int next;
        b.d.b<String, d> bVar = this.f1022k;
        if (bVar == null || bVar.isEmpty()) {
            return null;
        }
        j<String> jVar = this.f1023l;
        String str = "appcompat_skip_skip";
        if (jVar != null) {
            String str2 = (String) jVar.a(i2);
            if (str.equals(str2) || (str2 != null && this.f1022k.get(str2) == null)) {
                return null;
            }
        } else {
            this.f1023l = new j<>();
        }
        if (this.n == null) {
            this.n = new TypedValue();
        }
        TypedValue typedValue = this.n;
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        long a2 = a(typedValue);
        Drawable a3 = a(context, a2);
        if (a3 != null) {
            return a3;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i2);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                while (true) {
                    next = xml.next();
                    if (next == 2 || next == 1) {
                        if (next != 2) {
                            String name = xml.getName();
                            this.f1023l.a(i2, name);
                            d dVar = (d) this.f1022k.get(name);
                            if (dVar != null) {
                                a3 = dVar.a(context, xml, asAttributeSet, context.getTheme());
                            }
                            if (a3 != null) {
                                a3.setChangingConfigurations(typedValue.changingConfigurations);
                                a(context, a2, a3);
                            }
                        } else {
                            throw new XmlPullParserException("No start tag found");
                        }
                    }
                }
                if (next != 2) {
                }
            } catch (Exception e2) {
                Log.e("AppCompatDrawableManag", "Exception while inflating drawable", e2);
            }
        }
        if (a3 == null) {
            this.f1023l.a(i2, str);
        }
        return a3;
    }

    /* access modifiers changed from: 0000 */
    public synchronized ColorStateList b(Context context, int i2) {
        ColorStateList e2;
        e2 = e(context, i2);
        if (e2 == null) {
            if (i2 == b.a.e.abc_edit_text_material) {
                e2 = b.a.a.a.a.a(context, b.a.c.abc_tint_edittext);
            } else if (i2 == b.a.e.abc_switch_track_mtrl_alpha) {
                e2 = b.a.a.a.a.a(context, b.a.c.abc_tint_switch_track);
            } else if (i2 == b.a.e.abc_switch_thumb_material) {
                e2 = f(context);
            } else if (i2 == b.a.e.abc_btn_default_mtrl_shape) {
                e2 = e(context);
            } else if (i2 == b.a.e.abc_btn_borderless_material) {
                e2 = c(context);
            } else if (i2 == b.a.e.abc_btn_colored_material) {
                e2 = d(context);
            } else {
                if (i2 != b.a.e.abc_spinner_mtrl_am_alpha) {
                    if (i2 != b.a.e.abc_spinner_textfield_background_material) {
                        if (a(f1016e, i2)) {
                            e2 = na.c(context, b.a.a.colorControlNormal);
                        } else if (a(f1019h, i2)) {
                            e2 = b.a.a.a.a.a(context, b.a.c.abc_tint_default);
                        } else if (a(f1020i, i2)) {
                            e2 = b.a.a.a.a.a(context, b.a.c.abc_tint_btn_checkable);
                        } else if (i2 == b.a.e.abc_seekbar_thumb_material) {
                            e2 = b.a.a.a.a.a(context, b.a.c.abc_tint_seek_thumb);
                        }
                    }
                }
                e2 = b.a.a.a.a.a(context, b.a.c.abc_tint_spinner);
            }
            if (e2 != null) {
                a(context, i2, e2);
            }
        }
        return e2;
    }

    private ColorStateList c(Context context, int i2) {
        int b2 = na.b(context, b.a.a.colorControlHighlight);
        return new ColorStateList(new int[][]{na.f1003b, na.f1006e, na.f1004c, na.f1010i}, new int[]{na.a(context, b.a.a.colorButtonNormal), b.g.b.a.a(b2, i2), b.g.b.a.a(b2, i2), i2});
    }

    private ColorStateList e(Context context) {
        return c(context, na.b(context, b.a.a.colorButtonNormal));
    }

    private static void a(C0175o oVar) {
        if (VERSION.SDK_INT < 24) {
            oVar.a("vector", (d) new e());
            oVar.a("animated-vector", (d) new b());
            oVar.a("animated-selector", (d) new a());
        }
    }

    public synchronized Drawable a(Context context, int i2) {
        return a(context, i2, false);
    }

    /* access modifiers changed from: 0000 */
    public synchronized Drawable a(Context context, int i2, boolean z) {
        Drawable f2;
        b(context);
        f2 = f(context, i2);
        if (f2 == null) {
            f2 = d(context, i2);
        }
        if (f2 == null) {
            f2 = b.g.a.a.c(context, i2);
        }
        if (f2 != null) {
            f2 = a(context, i2, z, f2);
        }
        if (f2 != null) {
            K.b(f2);
        }
        return f2;
    }

    private ColorStateList d(Context context) {
        return c(context, na.b(context, b.a.a.colorAccent));
    }

    public synchronized void a(Context context) {
        f fVar = (f) this.m.get(context);
        if (fVar != null) {
            fVar.a();
        }
    }

    private static long a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private Drawable a(Context context, int i2, boolean z, Drawable drawable) {
        ColorStateList b2 = b(context, i2);
        if (b2 != null) {
            if (K.a(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable i3 = androidx.core.graphics.drawable.a.i(drawable);
            androidx.core.graphics.drawable.a.a(i3, b2);
            Mode a2 = a(i2);
            if (a2 == null) {
                return i3;
            }
            androidx.core.graphics.drawable.a.a(i3, a2);
            return i3;
        } else if (i2 == b.a.e.abc_seekbar_track_material) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            a(layerDrawable.findDrawableByLayerId(16908288), na.b(context, b.a.a.colorControlNormal), f1012a);
            a(layerDrawable.findDrawableByLayerId(16908303), na.b(context, b.a.a.colorControlNormal), f1012a);
            a(layerDrawable.findDrawableByLayerId(16908301), na.b(context, b.a.a.colorControlActivated), f1012a);
            return drawable;
        } else if (i2 == b.a.e.abc_ratingbar_material || i2 == b.a.e.abc_ratingbar_indicator_material || i2 == b.a.e.abc_ratingbar_small_material) {
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            a(layerDrawable2.findDrawableByLayerId(16908288), na.a(context, b.a.a.colorControlNormal), f1012a);
            a(layerDrawable2.findDrawableByLayerId(16908303), na.b(context, b.a.a.colorControlActivated), f1012a);
            a(layerDrawable2.findDrawableByLayerId(16908301), na.b(context, b.a.a.colorControlActivated), f1012a);
            return drawable;
        } else if (a(context, i2, drawable) || !z) {
            return drawable;
        } else {
            return null;
        }
    }

    private void b(Context context) {
        if (!this.o) {
            this.o = true;
            Drawable a2 = a(context, b.a.e.abc_vector_test);
            if (a2 == null || !a(a2)) {
                this.o = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    private ColorStateList f(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList c2 = na.c(context, b.a.a.colorSwitchThumbNormal);
        if (c2 == null || !c2.isStateful()) {
            iArr[0] = na.f1003b;
            iArr2[0] = na.a(context, b.a.a.colorSwitchThumbNormal);
            iArr[1] = na.f1007f;
            iArr2[1] = na.b(context, b.a.a.colorControlActivated);
            iArr[2] = na.f1010i;
            iArr2[2] = na.b(context, b.a.a.colorSwitchThumbNormal);
        } else {
            iArr[0] = na.f1003b;
            iArr2[0] = c2.getColorForState(iArr[0], 0);
            iArr[1] = na.f1007f;
            iArr2[1] = na.b(context, b.a.a.colorControlActivated);
            iArr[2] = na.f1010i;
            iArr2[2] = c2.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        return null;
     */
    private synchronized Drawable a(Context context, long j2) {
        f fVar = (f) this.m.get(context);
        if (fVar == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) fVar.b(j2);
        if (weakReference != null) {
            ConstantState constantState = (ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            fVar.a(j2);
        }
    }

    private synchronized boolean a(Context context, long j2, Drawable drawable) {
        ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        f fVar = (f) this.m.get(context);
        if (fVar == null) {
            fVar = new f();
            this.m.put(context, fVar);
        }
        fVar.c(j2, new WeakReference(constantState));
        return true;
    }

    /* access modifiers changed from: 0000 */
    public synchronized Drawable a(Context context, Fa fa, int i2) {
        Drawable f2 = f(context, i2);
        if (f2 == null) {
            f2 = fa.a(i2);
        }
        if (f2 == null) {
            return null;
        }
        return a(context, i2, false, f2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0061 A[RETURN] */
    static boolean a(Context context, int i2, Drawable drawable) {
        boolean z;
        int i3;
        Mode mode = f1012a;
        int i4 = 16842801;
        if (a(f1015d, i2)) {
            i4 = b.a.a.colorControlNormal;
        } else if (a(f1017f, i2)) {
            i4 = b.a.a.colorControlActivated;
        } else if (a(f1018g, i2)) {
            mode = Mode.MULTIPLY;
        } else {
            if (i2 == b.a.e.abc_list_divider_mtrl_alpha) {
                i4 = 16842800;
                i3 = Math.round(40.8f);
                z = true;
            } else if (i2 != b.a.e.abc_dialog_material_background) {
                z = false;
                i3 = -1;
                i4 = 0;
            }
            if (z) {
                return false;
            }
            if (K.a(drawable)) {
                drawable = drawable.mutate();
            }
            drawable.setColorFilter(a(na.b(context, i4), mode));
            if (i3 != -1) {
                drawable.setAlpha(i3);
            }
            return true;
        }
        z = true;
        i3 = -1;
        if (z) {
        }
    }

    private void a(String str, d dVar) {
        if (this.f1022k == null) {
            this.f1022k = new b.d.b<>();
        }
        this.f1022k.put(str, dVar);
    }

    private static boolean a(int[] iArr, int i2) {
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    static Mode a(int i2) {
        if (i2 == b.a.e.abc_switch_thumb_material) {
            return Mode.MULTIPLY;
        }
        return null;
    }

    private void a(Context context, int i2, ColorStateList colorStateList) {
        if (this.f1021j == null) {
            this.f1021j = new WeakHashMap<>();
        }
        j jVar = (j) this.f1021j.get(context);
        if (jVar == null) {
            jVar = new j();
            this.f1021j.put(context, jVar);
        }
        jVar.a(i2, colorStateList);
    }

    static void a(Drawable drawable, qa qaVar, int[] iArr) {
        if (!K.a(drawable) || drawable.mutate() == drawable) {
            if (qaVar.f1033d || qaVar.f1032c) {
                drawable.setColorFilter(a(qaVar.f1033d ? qaVar.f1030a : null, qaVar.f1032c ? qaVar.f1031b : f1012a, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
            }
            return;
        }
        Log.d("AppCompatDrawableManag", "Mutated drawable is not the same instance as the input.");
    }

    private static PorterDuffColorFilter a(ColorStateList colorStateList, Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return a(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized PorterDuffColorFilter a(int i2, Mode mode) {
        PorterDuffColorFilter a2;
        synchronized (C0175o.class) {
            a2 = f1014c.a(i2, mode);
            if (a2 == null) {
                a2 = new PorterDuffColorFilter(i2, mode);
                f1014c.a(i2, mode, a2);
            }
        }
        return a2;
    }

    private static void a(Drawable drawable, int i2, Mode mode) {
        if (K.a(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = f1012a;
        }
        drawable.setColorFilter(a(i2, mode));
    }

    private static boolean a(Drawable drawable) {
        if (!(drawable instanceof k)) {
            if (!"android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
                return false;
            }
        }
        return true;
    }
}
