package b.a.b.a;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.StateSet;
import b.d.j;
import b.q.a.a.k;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: AnimatedStateListDrawableCompat */
public class b extends f {
    private C0019b p;
    private f q;
    private int r;
    private int s;
    private boolean t;

    /* compiled from: AnimatedStateListDrawableCompat */
    private static class a extends f {

        /* renamed from: a reason: collision with root package name */
        private final Animatable f2150a;

        a(Animatable animatable) {
            super();
            this.f2150a = animatable;
        }

        public void c() {
            this.f2150a.start();
        }

        public void d() {
            this.f2150a.stop();
        }
    }

    /* renamed from: b.a.b.a.b$b reason: collision with other inner class name */
    /* compiled from: AnimatedStateListDrawableCompat */
    static class C0019b extends a {
        b.d.f<Long> K;
        j<Integer> L;

        C0019b(C0019b bVar, b bVar2, Resources resources) {
            super(bVar, bVar2, resources);
            if (bVar != null) {
                this.K = bVar.K;
                this.L = bVar.L;
                return;
            }
            this.K = new b.d.f<>();
            this.L = new j<>();
        }

        private static long f(int i2, int i3) {
            return ((long) i3) | (((long) i2) << 32);
        }

        /* access modifiers changed from: 0000 */
        public int a(int i2, int i3, Drawable drawable, boolean z) {
            int a2 = super.a(drawable);
            long f2 = f(i2, i3);
            long j2 = z ? 8589934592L : 0;
            long j3 = (long) a2;
            this.K.a(f2, Long.valueOf(j3 | j2));
            if (z) {
                this.K.a(f(i3, i2), Long.valueOf(4294967296L | j3 | j2));
            }
            return a2;
        }

        /* access modifiers changed from: 0000 */
        public int b(int[] iArr) {
            int a2 = super.a(iArr);
            if (a2 >= 0) {
                return a2;
            }
            return super.a(StateSet.WILD_CARD);
        }

        /* access modifiers changed from: 0000 */
        public int c(int i2, int i3) {
            return (int) ((Long) this.K.b(f(i2, i3), Long.valueOf(-1))).longValue();
        }

        /* access modifiers changed from: 0000 */
        public int d(int i2) {
            if (i2 < 0) {
                return 0;
            }
            return ((Integer) this.L.b(i2, Integer.valueOf(0))).intValue();
        }

        /* access modifiers changed from: 0000 */
        public boolean e(int i2, int i3) {
            return (((Long) this.K.b(f(i2, i3), Long.valueOf(-1))).longValue() & 8589934592L) != 0;
        }

        /* access modifiers changed from: 0000 */
        public void m() {
            this.K = this.K.clone();
            this.L = this.L.clone();
        }

        public Drawable newDrawable() {
            return new b(this, null);
        }

        /* access modifiers changed from: 0000 */
        public boolean d(int i2, int i3) {
            return (((Long) this.K.b(f(i2, i3), Long.valueOf(-1))).longValue() & 4294967296L) != 0;
        }

        public Drawable newDrawable(Resources resources) {
            return new b(this, resources);
        }

        /* access modifiers changed from: 0000 */
        public int a(int[] iArr, Drawable drawable, int i2) {
            int a2 = super.a(iArr, drawable);
            this.L.c(a2, Integer.valueOf(i2));
            return a2;
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat */
    private static class c extends f {

        /* renamed from: a reason: collision with root package name */
        private final b.q.a.a.d f2151a;

        c(b.q.a.a.d dVar) {
            super();
            this.f2151a = dVar;
        }

        public void c() {
            this.f2151a.start();
        }

        public void d() {
            this.f2151a.stop();
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat */
    private static class d extends f {

        /* renamed from: a reason: collision with root package name */
        private final ObjectAnimator f2152a;

        /* renamed from: b reason: collision with root package name */
        private final boolean f2153b;

        d(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i2 = z ? numberOfFrames - 1 : 0;
            int i3 = z ? 0 : numberOfFrames - 1;
            e eVar = new e(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", new int[]{i2, i3});
            if (VERSION.SDK_INT >= 18) {
                ofInt.setAutoCancel(true);
            }
            ofInt.setDuration((long) eVar.a());
            ofInt.setInterpolator(eVar);
            this.f2153b = z2;
            this.f2152a = ofInt;
        }

        public boolean a() {
            return this.f2153b;
        }

        public void b() {
            this.f2152a.reverse();
        }

        public void c() {
            this.f2152a.start();
        }

        public void d() {
            this.f2152a.cancel();
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat */
    private static class e implements TimeInterpolator {

        /* renamed from: a reason: collision with root package name */
        private int[] f2154a;

        /* renamed from: b reason: collision with root package name */
        private int f2155b;

        /* renamed from: c reason: collision with root package name */
        private int f2156c;

        e(AnimationDrawable animationDrawable, boolean z) {
            a(animationDrawable, z);
        }

        /* access modifiers changed from: 0000 */
        public int a(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f2155b = numberOfFrames;
            int[] iArr = this.f2154a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f2154a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f2154a;
            int i2 = 0;
            for (int i3 = 0; i3 < numberOfFrames; i3++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i3) - 1 : i3);
                iArr2[i3] = duration;
                i2 += duration;
            }
            this.f2156c = i2;
            return i2;
        }

        public float getInterpolation(float f2) {
            int i2 = (int) ((f2 * ((float) this.f2156c)) + 0.5f);
            int i3 = this.f2155b;
            int[] iArr = this.f2154a;
            int i4 = 0;
            while (i4 < i3 && i2 >= iArr[i4]) {
                i2 -= iArr[i4];
                i4++;
            }
            return (((float) i4) / ((float) i3)) + (i4 < i3 ? ((float) i2) / ((float) this.f2156c) : 0.0f);
        }

        /* access modifiers changed from: 0000 */
        public int a() {
            return this.f2156c;
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat */
    private static abstract class f {
        private f() {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    public b() {
        this(null, null);
    }

    private void c(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next == 3) {
                    return;
                }
                if (next == 2 && depth2 <= depth) {
                    if (xmlPullParser.getName().equals("item")) {
                        d(context, resources, xmlPullParser, attributeSet, theme);
                    } else if (xmlPullParser.getName().equals("transition")) {
                        e(context, resources, xmlPullParser, attributeSet, theme);
                    }
                }
            } else {
                return;
            }
        }
    }

    private void d() {
        onStateChange(getState());
    }

    private int e(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray a2 = b.g.a.a.j.a(resources, theme, attributeSet, b.a.j.AnimatedStateListDrawableTransition);
        int resourceId = a2.getResourceId(b.a.j.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = a2.getResourceId(b.a.j.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = a2.getResourceId(b.a.j.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable b2 = resourceId3 > 0 ? b.a.a.a.a.b(context, resourceId3) : null;
        boolean z = a2.getBoolean(b.a.j.AnimatedStateListDrawableTransition_android_reversible, false);
        a2.recycle();
        String str = ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable";
        if (b2 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                StringBuilder sb = new StringBuilder();
                sb.append(xmlPullParser.getPositionDescription());
                sb.append(str);
                throw new XmlPullParserException(sb.toString());
            } else if (xmlPullParser.getName().equals("animated-vector")) {
                b2 = b.q.a.a.d.a(context, resources, xmlPullParser, attributeSet, theme);
            } else if (VERSION.SDK_INT >= 21) {
                b2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                b2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (b2 == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(xmlPullParser.getPositionDescription());
            sb2.append(str);
            throw new XmlPullParserException(sb2.toString());
        } else if (resourceId != -1 && resourceId2 != -1) {
            return this.p.a(resourceId, resourceId2, b2, z);
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(xmlPullParser.getPositionDescription());
            sb3.append(": <transition> tag requires 'fromId' & 'toId' attributes");
            throw new XmlPullParserException(sb3.toString());
        }
    }

    public /* bridge */ /* synthetic */ void applyTheme(Theme theme) {
        super.applyTheme(theme);
    }

    public void b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        TypedArray a2 = b.g.a.a.j.a(resources, theme, attributeSet, b.a.j.AnimatedStateListDrawableCompat);
        setVisible(a2.getBoolean(b.a.j.AnimatedStateListDrawableCompat_android_visible, true), true);
        a(a2);
        a(resources);
        a2.recycle();
        c(context, resources, xmlPullParser, attributeSet, theme);
        d();
    }

    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ void getHotspotBounds(Rect rect) {
        super.getHotspotBounds(rect);
    }

    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    public /* bridge */ /* synthetic */ void getOutline(Outline outline) {
        super.getOutline(outline);
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public boolean isStateful() {
        return true;
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        f fVar = this.q;
        if (fVar != null) {
            fVar.d();
            this.q = null;
            a(this.r);
            this.r = -1;
            this.s = -1;
        }
    }

    public Drawable mutate() {
        if (!this.t) {
            super.mutate();
            if (this == this) {
                this.p.m();
                this.t = true;
            }
        }
        return this;
    }

    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i2) {
        return super.onLayoutDirectionChanged(i2);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        int b2 = this.p.b(iArr);
        boolean z = b2 != b() && (b(b2) || a(b2));
        Drawable current = getCurrent();
        return current != null ? z | current.setState(iArr) : z;
    }

    public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        super.scheduleDrawable(drawable, runnable, j2);
    }

    public /* bridge */ /* synthetic */ void setAlpha(int i2) {
        super.setAlpha(i2);
    }

    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    public /* bridge */ /* synthetic */ void setDither(boolean z) {
        super.setDither(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i2, int i3, int i4, int i5) {
        super.setHotspotBounds(i2, i3, i4, i5);
    }

    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTintMode(Mode mode) {
        super.setTintMode(mode);
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.q != null && (visible || z2)) {
            if (z) {
                this.q.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }

    b(C0019b bVar, Resources resources) {
        super(null);
        this.r = -1;
        this.s = -1;
        a((b) new C0019b(bVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    private int d(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray a2 = b.g.a.a.j.a(resources, theme, attributeSet, b.a.j.AnimatedStateListDrawableItem);
        int resourceId = a2.getResourceId(b.a.j.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = a2.getResourceId(b.a.j.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable b2 = resourceId2 > 0 ? b.a.a.a.a.b(context, resourceId2) : null;
        a2.recycle();
        int[] a3 = a(attributeSet);
        String str = ": <item> tag requires a 'drawable' attribute or child tag defining a drawable";
        if (b2 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                StringBuilder sb = new StringBuilder();
                sb.append(xmlPullParser.getPositionDescription());
                sb.append(str);
                throw new XmlPullParserException(sb.toString());
            } else if (xmlPullParser.getName().equals("vector")) {
                b2 = k.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else if (VERSION.SDK_INT >= 21) {
                b2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                b2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (b2 != null) {
            return this.p.a(a3, b2, resourceId);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(xmlPullParser.getPositionDescription());
        sb2.append(str);
        throw new XmlPullParserException(sb2.toString());
    }

    public static b a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            b bVar = new b();
            bVar.b(context, resources, xmlPullParser, attributeSet, theme);
            return bVar;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(xmlPullParser.getPositionDescription());
        sb.append(": invalid animated-selector tag ");
        sb.append(name);
        throw new XmlPullParserException(sb.toString());
    }

    private boolean b(int i2) {
        int i3;
        f fVar;
        f fVar2 = this.q;
        if (fVar2 == null) {
            i3 = b();
        } else if (i2 == this.r) {
            return true;
        } else {
            if (i2 != this.s || !fVar2.a()) {
                i3 = this.r;
                fVar2.d();
            } else {
                fVar2.b();
                this.r = this.s;
                this.s = i2;
                return true;
            }
        }
        this.q = null;
        this.s = -1;
        this.r = -1;
        C0019b bVar = this.p;
        int d2 = bVar.d(i3);
        int d3 = bVar.d(i2);
        if (!(d3 == 0 || d2 == 0)) {
            int c2 = bVar.c(d2, d3);
            if (c2 < 0) {
                return false;
            }
            boolean e2 = bVar.e(d2, d3);
            a(c2);
            Drawable current = getCurrent();
            if (current instanceof AnimationDrawable) {
                fVar = new d((AnimationDrawable) current, bVar.d(d2, d3), e2);
            } else if (current instanceof b.q.a.a.d) {
                fVar = new c((b.q.a.a.d) current);
            } else if (current instanceof Animatable) {
                fVar = new a((Animatable) current);
            }
            fVar.c();
            this.q = fVar;
            this.s = i3;
            this.r = i2;
            return true;
        }
        return false;
    }

    private void a(TypedArray typedArray) {
        C0019b bVar = this.p;
        if (VERSION.SDK_INT >= 21) {
            bVar.f2174d |= typedArray.getChangingConfigurations();
        }
        bVar.b(typedArray.getBoolean(b.a.j.AnimatedStateListDrawableCompat_android_variablePadding, bVar.f2179i));
        bVar.a(typedArray.getBoolean(b.a.j.AnimatedStateListDrawableCompat_android_constantSize, bVar.f2182l));
        bVar.b(typedArray.getInt(b.a.j.AnimatedStateListDrawableCompat_android_enterFadeDuration, bVar.A));
        bVar.c(typedArray.getInt(b.a.j.AnimatedStateListDrawableCompat_android_exitFadeDuration, bVar.B));
        setDither(typedArray.getBoolean(b.a.j.AnimatedStateListDrawableCompat_android_dither, bVar.x));
    }

    /* access modifiers changed from: 0000 */
    public C0019b a() {
        return new C0019b(this.p, this, null);
    }

    /* access modifiers changed from: protected */
    public void a(b bVar) {
        super.a(bVar);
        if (bVar instanceof C0019b) {
            this.p = (C0019b) bVar;
        }
    }
}
