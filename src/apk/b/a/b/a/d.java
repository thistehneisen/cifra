package b.a.b.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.SparseArray;

/* compiled from: DrawableContainer */
class d extends Drawable implements Callback {

    /* renamed from: a reason: collision with root package name */
    private b f2158a;

    /* renamed from: b reason: collision with root package name */
    private Rect f2159b;

    /* renamed from: c reason: collision with root package name */
    private Drawable f2160c;

    /* renamed from: d reason: collision with root package name */
    private Drawable f2161d;

    /* renamed from: e reason: collision with root package name */
    private int f2162e = 255;

    /* renamed from: f reason: collision with root package name */
    private boolean f2163f;

    /* renamed from: g reason: collision with root package name */
    private int f2164g = -1;

    /* renamed from: h reason: collision with root package name */
    private int f2165h = -1;

    /* renamed from: i reason: collision with root package name */
    private boolean f2166i;

    /* renamed from: j reason: collision with root package name */
    private Runnable f2167j;

    /* renamed from: k reason: collision with root package name */
    private long f2168k;

    /* renamed from: l reason: collision with root package name */
    private long f2169l;
    private a m;

    /* compiled from: DrawableContainer */
    static class a implements Callback {

        /* renamed from: a reason: collision with root package name */
        private Callback f2170a;

        a() {
        }

        public a a(Callback callback) {
            this.f2170a = callback;
            return this;
        }

        public void invalidateDrawable(Drawable drawable) {
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
            Callback callback = this.f2170a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j2);
            }
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Callback callback = this.f2170a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }

        public Callback a() {
            Callback callback = this.f2170a;
            this.f2170a = null;
            return callback;
        }
    }

    /* compiled from: DrawableContainer */
    static abstract class b extends ConstantState {
        int A;
        int B;
        boolean C;
        ColorFilter D;
        boolean E;
        ColorStateList F;
        Mode G;
        boolean H;
        boolean I;

        /* renamed from: a reason: collision with root package name */
        final d f2171a;

        /* renamed from: b reason: collision with root package name */
        Resources f2172b;

        /* renamed from: c reason: collision with root package name */
        int f2173c = 160;

        /* renamed from: d reason: collision with root package name */
        int f2174d;

        /* renamed from: e reason: collision with root package name */
        int f2175e;

        /* renamed from: f reason: collision with root package name */
        SparseArray<ConstantState> f2176f;

        /* renamed from: g reason: collision with root package name */
        Drawable[] f2177g;

        /* renamed from: h reason: collision with root package name */
        int f2178h;

        /* renamed from: i reason: collision with root package name */
        boolean f2179i;

        /* renamed from: j reason: collision with root package name */
        boolean f2180j;

        /* renamed from: k reason: collision with root package name */
        Rect f2181k;

        /* renamed from: l reason: collision with root package name */
        boolean f2182l;
        boolean m;
        int n;
        int o;
        int p;
        int q;
        boolean r;
        int s;
        boolean t;
        boolean u;
        boolean v;
        boolean w;
        boolean x;
        boolean y;
        int z;

        b(b bVar, d dVar, Resources resources) {
            this.f2179i = false;
            this.f2182l = false;
            this.x = true;
            this.A = 0;
            this.B = 0;
            this.f2171a = dVar;
            Resources resources2 = resources != null ? resources : bVar != null ? bVar.f2172b : null;
            this.f2172b = resources2;
            this.f2173c = d.a(resources, bVar != null ? bVar.f2173c : 0);
            if (bVar != null) {
                this.f2174d = bVar.f2174d;
                this.f2175e = bVar.f2175e;
                this.v = true;
                this.w = true;
                this.f2179i = bVar.f2179i;
                this.f2182l = bVar.f2182l;
                this.x = bVar.x;
                this.y = bVar.y;
                this.z = bVar.z;
                this.A = bVar.A;
                this.B = bVar.B;
                this.C = bVar.C;
                this.D = bVar.D;
                this.E = bVar.E;
                this.F = bVar.F;
                this.G = bVar.G;
                this.H = bVar.H;
                this.I = bVar.I;
                if (bVar.f2173c == this.f2173c) {
                    if (bVar.f2180j) {
                        this.f2181k = new Rect(bVar.f2181k);
                        this.f2180j = true;
                    }
                    if (bVar.m) {
                        this.n = bVar.n;
                        this.o = bVar.o;
                        this.p = bVar.p;
                        this.q = bVar.q;
                        this.m = true;
                    }
                }
                if (bVar.r) {
                    this.s = bVar.s;
                    this.r = true;
                }
                if (bVar.t) {
                    this.u = bVar.u;
                    this.t = true;
                }
                Drawable[] drawableArr = bVar.f2177g;
                this.f2177g = new Drawable[drawableArr.length];
                this.f2178h = bVar.f2178h;
                SparseArray<ConstantState> sparseArray = bVar.f2176f;
                if (sparseArray != null) {
                    this.f2176f = sparseArray.clone();
                } else {
                    this.f2176f = new SparseArray<>(this.f2178h);
                }
                int i2 = this.f2178h;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (drawableArr[i3] != null) {
                        ConstantState constantState = drawableArr[i3].getConstantState();
                        if (constantState != null) {
                            this.f2176f.put(i3, constantState);
                        } else {
                            this.f2177g[i3] = drawableArr[i3];
                        }
                    }
                }
                return;
            }
            this.f2177g = new Drawable[10];
            this.f2178h = 0;
        }

        private Drawable b(Drawable drawable) {
            if (VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(this.z);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.f2171a);
            return mutate;
        }

        private void n() {
            SparseArray<ConstantState> sparseArray = this.f2176f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f2177g[this.f2176f.keyAt(i2)] = b(((ConstantState) this.f2176f.valueAt(i2)).newDrawable(this.f2172b));
                }
                this.f2176f = null;
            }
        }

        public final int a(Drawable drawable) {
            int i2 = this.f2178h;
            if (i2 >= this.f2177g.length) {
                a(i2, i2 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f2171a);
            this.f2177g[i2] = drawable;
            this.f2178h++;
            this.f2175e = drawable.getChangingConfigurations() | this.f2175e;
            k();
            this.f2181k = null;
            this.f2180j = false;
            this.m = false;
            this.v = false;
            return i2;
        }

        /* access modifiers changed from: 0000 */
        public final int c() {
            return this.f2177g.length;
        }

        public boolean canApplyTheme() {
            int i2 = this.f2178h;
            Drawable[] drawableArr = this.f2177g;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                if (drawable == null) {
                    ConstantState constantState = (ConstantState) this.f2176f.get(i3);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                } else if (drawable.canApplyTheme()) {
                    return true;
                }
            }
            return false;
        }

        public final int d() {
            return this.f2178h;
        }

        public final int e() {
            if (!this.m) {
                b();
            }
            return this.o;
        }

        public final int f() {
            if (!this.m) {
                b();
            }
            return this.q;
        }

        public final int g() {
            if (!this.m) {
                b();
            }
            return this.p;
        }

        public int getChangingConfigurations() {
            return this.f2174d | this.f2175e;
        }

        public final Rect h() {
            if (this.f2179i) {
                return null;
            }
            if (this.f2181k != null || this.f2180j) {
                return this.f2181k;
            }
            n();
            Rect rect = new Rect();
            int i2 = this.f2178h;
            Drawable[] drawableArr = this.f2177g;
            Rect rect2 = null;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3].getPadding(rect)) {
                    if (rect2 == null) {
                        rect2 = new Rect(0, 0, 0, 0);
                    }
                    int i4 = rect.left;
                    if (i4 > rect2.left) {
                        rect2.left = i4;
                    }
                    int i5 = rect.top;
                    if (i5 > rect2.top) {
                        rect2.top = i5;
                    }
                    int i6 = rect.right;
                    if (i6 > rect2.right) {
                        rect2.right = i6;
                    }
                    int i7 = rect.bottom;
                    if (i7 > rect2.bottom) {
                        rect2.bottom = i7;
                    }
                }
            }
            this.f2180j = true;
            this.f2181k = rect2;
            return rect2;
        }

        public final int i() {
            if (!this.m) {
                b();
            }
            return this.n;
        }

        public final int j() {
            if (this.r) {
                return this.s;
            }
            n();
            int i2 = this.f2178h;
            Drawable[] drawableArr = this.f2177g;
            int opacity = i2 > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i3 = 1; i3 < i2; i3++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i3].getOpacity());
            }
            this.s = opacity;
            this.r = true;
            return opacity;
        }

        /* access modifiers changed from: 0000 */
        public void k() {
            this.r = false;
            this.t = false;
        }

        public final boolean l() {
            return this.f2182l;
        }

        /* access modifiers changed from: 0000 */
        public abstract void m();

        public final void c(int i2) {
            this.B = i2;
        }

        /* access modifiers changed from: 0000 */
        public final boolean b(int i2, int i3) {
            int i4 = this.f2178h;
            Drawable[] drawableArr = this.f2177g;
            boolean z2 = false;
            for (int i5 = 0; i5 < i4; i5++) {
                if (drawableArr[i5] != null) {
                    boolean layoutDirection = VERSION.SDK_INT >= 23 ? drawableArr[i5].setLayoutDirection(i2) : false;
                    if (i5 == i3) {
                        z2 = layoutDirection;
                    }
                }
            }
            this.z = i2;
            return z2;
        }

        public final void b(boolean z2) {
            this.f2179i = z2;
        }

        /* access modifiers changed from: protected */
        public void b() {
            this.m = true;
            n();
            int i2 = this.f2178h;
            Drawable[] drawableArr = this.f2177g;
            this.o = -1;
            this.n = -1;
            this.q = 0;
            this.p = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.n) {
                    this.n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.o) {
                    this.o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.p) {
                    this.p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.q) {
                    this.q = minimumHeight;
                }
            }
        }

        public final Drawable a(int i2) {
            Drawable drawable = this.f2177g[i2];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<ConstantState> sparseArray = this.f2176f;
            if (sparseArray != null) {
                int indexOfKey = sparseArray.indexOfKey(i2);
                if (indexOfKey >= 0) {
                    Drawable b2 = b(((ConstantState) this.f2176f.valueAt(indexOfKey)).newDrawable(this.f2172b));
                    this.f2177g[i2] = b2;
                    this.f2176f.removeAt(indexOfKey);
                    if (this.f2176f.size() == 0) {
                        this.f2176f = null;
                    }
                    return b2;
                }
            }
            return null;
        }

        /* access modifiers changed from: 0000 */
        public final void a(Resources resources) {
            if (resources != null) {
                this.f2172b = resources;
                int a2 = d.a(resources, this.f2173c);
                int i2 = this.f2173c;
                this.f2173c = a2;
                if (i2 != a2) {
                    this.m = false;
                    this.f2180j = false;
                }
            }
        }

        public final void b(int i2) {
            this.A = i2;
        }

        /* access modifiers changed from: 0000 */
        public final void a(Theme theme) {
            if (theme != null) {
                n();
                int i2 = this.f2178h;
                Drawable[] drawableArr = this.f2177g;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (drawableArr[i3] != null && drawableArr[i3].canApplyTheme()) {
                        drawableArr[i3].applyTheme(theme);
                        this.f2175e |= drawableArr[i3].getChangingConfigurations();
                    }
                }
                a(theme.getResources());
            }
        }

        public final void a(boolean z2) {
            this.f2182l = z2;
        }

        public void a(int i2, int i3) {
            Drawable[] drawableArr = new Drawable[i3];
            System.arraycopy(this.f2177g, 0, drawableArr, 0, i2);
            this.f2177g = drawableArr;
        }

        public synchronized boolean a() {
            if (this.v) {
                return this.w;
            }
            n();
            this.v = true;
            int i2 = this.f2178h;
            Drawable[] drawableArr = this.f2177g;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3].getConstantState() == null) {
                    this.w = false;
                    return false;
                }
            }
            this.w = true;
            return true;
        }
    }

    d() {
    }

    @SuppressLint({"WrongConstant"})
    @TargetApi(23)
    private boolean c() {
        return isAutoMirrored() && getLayoutDirection() == 1;
    }

    /* access modifiers changed from: 0000 */
    public b a() {
        throw null;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0079  */
    public boolean a(int i2) {
        Runnable runnable;
        if (i2 == this.f2164g) {
            return false;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f2158a.B > 0) {
            Drawable drawable = this.f2161d;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            Drawable drawable2 = this.f2160c;
            if (drawable2 != null) {
                this.f2161d = drawable2;
                this.f2165h = this.f2164g;
                this.f2169l = ((long) this.f2158a.B) + uptimeMillis;
            } else {
                this.f2161d = null;
                this.f2165h = -1;
                this.f2169l = 0;
            }
        } else {
            Drawable drawable3 = this.f2160c;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (i2 >= 0) {
            b bVar = this.f2158a;
            if (i2 < bVar.f2178h) {
                Drawable a2 = bVar.a(i2);
                this.f2160c = a2;
                this.f2164g = i2;
                if (a2 != null) {
                    int i3 = this.f2158a.A;
                    if (i3 > 0) {
                        this.f2168k = uptimeMillis + ((long) i3);
                    }
                    a(a2);
                }
                if (!(this.f2168k == 0 && this.f2169l == 0)) {
                    runnable = this.f2167j;
                    if (runnable != null) {
                        this.f2167j = new c(this);
                    } else {
                        unscheduleSelf(runnable);
                    }
                    a(true);
                }
                invalidateSelf();
                return true;
            }
        }
        this.f2160c = null;
        this.f2164g = -1;
        runnable = this.f2167j;
        if (runnable != null) {
        }
        a(true);
        invalidateSelf();
        return true;
    }

    public void applyTheme(Theme theme) {
        this.f2158a.a(theme);
    }

    /* access modifiers changed from: 0000 */
    public int b() {
        return this.f2164g;
    }

    public boolean canApplyTheme() {
        return this.f2158a.canApplyTheme();
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f2160c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f2161d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    public int getAlpha() {
        return this.f2162e;
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f2158a.getChangingConfigurations();
    }

    public final ConstantState getConstantState() {
        if (!this.f2158a.a()) {
            return null;
        }
        this.f2158a.f2174d = getChangingConfigurations();
        return this.f2158a;
    }

    public Drawable getCurrent() {
        return this.f2160c;
    }

    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f2159b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    public int getIntrinsicHeight() {
        if (this.f2158a.l()) {
            return this.f2158a.e();
        }
        Drawable drawable = this.f2160c;
        return drawable != null ? drawable.getIntrinsicHeight() : -1;
    }

    public int getIntrinsicWidth() {
        if (this.f2158a.l()) {
            return this.f2158a.i();
        }
        Drawable drawable = this.f2160c;
        return drawable != null ? drawable.getIntrinsicWidth() : -1;
    }

    public int getMinimumHeight() {
        if (this.f2158a.l()) {
            return this.f2158a.f();
        }
        Drawable drawable = this.f2160c;
        return drawable != null ? drawable.getMinimumHeight() : 0;
    }

    public int getMinimumWidth() {
        if (this.f2158a.l()) {
            return this.f2158a.g();
        }
        Drawable drawable = this.f2160c;
        return drawable != null ? drawable.getMinimumWidth() : 0;
    }

    public int getOpacity() {
        Drawable drawable = this.f2160c;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f2158a.j();
    }

    public void getOutline(Outline outline) {
        Drawable drawable = this.f2160c;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    public boolean getPadding(Rect rect) {
        boolean z;
        Rect h2 = this.f2158a.h();
        if (h2 != null) {
            rect.set(h2);
            z = (h2.right | ((h2.left | h2.top) | h2.bottom)) != 0;
        } else {
            Drawable drawable = this.f2160c;
            z = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (c()) {
            int i2 = rect.left;
            rect.left = rect.right;
            rect.right = i2;
        }
        return z;
    }

    public void invalidateDrawable(Drawable drawable) {
        b bVar = this.f2158a;
        if (bVar != null) {
            bVar.k();
        }
        if (drawable == this.f2160c && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    public boolean isAutoMirrored() {
        return this.f2158a.C;
    }

    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.f2161d;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f2161d = null;
            this.f2165h = -1;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.f2160c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f2163f) {
                this.f2160c.setAlpha(this.f2162e);
            }
        }
        if (this.f2169l != 0) {
            this.f2169l = 0;
            z = true;
        }
        if (this.f2168k != 0) {
            this.f2168k = 0;
            z = true;
        }
        if (z) {
            invalidateSelf();
        }
    }

    public Drawable mutate() {
        if (!this.f2166i && super.mutate() == this) {
            b a2 = a();
            a2.m();
            a(a2);
            this.f2166i = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2161d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f2160c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int i2) {
        return this.f2158a.b(i2, b());
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        Drawable drawable = this.f2161d;
        if (drawable != null) {
            return drawable.setLevel(i2);
        }
        Drawable drawable2 = this.f2160c;
        if (drawable2 != null) {
            return drawable2.setLevel(i2);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f2161d;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f2160c;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        if (drawable == this.f2160c && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j2);
        }
    }

    public void setAlpha(int i2) {
        if (!this.f2163f || this.f2162e != i2) {
            this.f2163f = true;
            this.f2162e = i2;
            Drawable drawable = this.f2160c;
            if (drawable == null) {
                return;
            }
            if (this.f2168k == 0) {
                drawable.setAlpha(i2);
            } else {
                a(false);
            }
        }
    }

    public void setAutoMirrored(boolean z) {
        b bVar = this.f2158a;
        if (bVar.C != z) {
            bVar.C = z;
            Drawable drawable = this.f2160c;
            if (drawable != null) {
                androidx.core.graphics.drawable.a.a(drawable, bVar.C);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        b bVar = this.f2158a;
        bVar.E = true;
        if (bVar.D != colorFilter) {
            bVar.D = colorFilter;
            Drawable drawable = this.f2160c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    public void setDither(boolean z) {
        b bVar = this.f2158a;
        if (bVar.x != z) {
            bVar.x = z;
            Drawable drawable = this.f2160c;
            if (drawable != null) {
                drawable.setDither(bVar.x);
            }
        }
    }

    public void setHotspot(float f2, float f3) {
        Drawable drawable = this.f2160c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, f2, f3);
        }
    }

    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        Rect rect = this.f2159b;
        if (rect == null) {
            this.f2159b = new Rect(i2, i3, i4, i5);
        } else {
            rect.set(i2, i3, i4, i5);
        }
        Drawable drawable = this.f2160c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, i2, i3, i4, i5);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        b bVar = this.f2158a;
        bVar.H = true;
        if (bVar.F != colorStateList) {
            bVar.F = colorStateList;
            androidx.core.graphics.drawable.a.a(this.f2160c, colorStateList);
        }
    }

    public void setTintMode(Mode mode) {
        b bVar = this.f2158a;
        bVar.I = true;
        if (bVar.G != mode) {
            bVar.G = mode;
            androidx.core.graphics.drawable.a.a(this.f2160c, mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.f2161d;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.f2160c;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable == this.f2160c && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }

    private void a(Drawable drawable) {
        if (this.m == null) {
            this.m = new a();
        }
        a aVar = this.m;
        aVar.a(drawable.getCallback());
        drawable.setCallback(aVar);
        try {
            if (this.f2158a.A <= 0 && this.f2163f) {
                drawable.setAlpha(this.f2162e);
            }
            if (this.f2158a.E) {
                drawable.setColorFilter(this.f2158a.D);
            } else {
                if (this.f2158a.H) {
                    androidx.core.graphics.drawable.a.a(drawable, this.f2158a.F);
                }
                if (this.f2158a.I) {
                    androidx.core.graphics.drawable.a.a(drawable, this.f2158a.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f2158a.x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            if (VERSION.SDK_INT >= 19) {
                drawable.setAutoMirrored(this.f2158a.C);
            }
            Rect rect = this.f2159b;
            if (VERSION.SDK_INT >= 21 && rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.m.a());
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    public void a(boolean z) {
        boolean z2;
        Drawable drawable;
        boolean z3 = true;
        this.f2163f = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        Drawable drawable2 = this.f2160c;
        if (drawable2 != null) {
            long j2 = this.f2168k;
            if (j2 != 0) {
                if (j2 <= uptimeMillis) {
                    drawable2.setAlpha(this.f2162e);
                    this.f2168k = 0;
                } else {
                    drawable2.setAlpha(((255 - (((int) ((j2 - uptimeMillis) * 255)) / this.f2158a.A)) * this.f2162e) / 255);
                    z2 = true;
                    drawable = this.f2161d;
                    if (drawable == null) {
                        long j3 = this.f2169l;
                        if (j3 != 0) {
                            if (j3 <= uptimeMillis) {
                                drawable.setVisible(false, false);
                                this.f2161d = null;
                                this.f2165h = -1;
                                this.f2169l = 0;
                            } else {
                                drawable.setAlpha(((((int) ((j3 - uptimeMillis) * 255)) / this.f2158a.B) * this.f2162e) / 255);
                                if (!z && z3) {
                                    scheduleSelf(this.f2167j, uptimeMillis + 16);
                                    return;
                                }
                                return;
                            }
                        }
                    } else {
                        this.f2169l = 0;
                    }
                    z3 = z2;
                    if (!z) {
                        return;
                    }
                    return;
                }
            }
        } else {
            this.f2168k = 0;
        }
        z2 = false;
        drawable = this.f2161d;
        if (drawable == null) {
        }
        z3 = z2;
        if (!z) {
        }
    }

    /* access modifiers changed from: 0000 */
    public final void a(Resources resources) {
        this.f2158a.a(resources);
    }

    /* access modifiers changed from: protected */
    public void a(b bVar) {
        this.f2158a = bVar;
        int i2 = this.f2164g;
        if (i2 >= 0) {
            this.f2160c = bVar.a(i2);
            Drawable drawable = this.f2160c;
            if (drawable != null) {
                a(drawable);
            }
        }
        this.f2165h = -1;
        this.f2161d = null;
    }

    static int a(Resources resources, int i2) {
        if (resources != null) {
            i2 = resources.getDisplayMetrics().densityDpi;
        }
        if (i2 == 0) {
            return 160;
        }
        return i2;
    }
}
