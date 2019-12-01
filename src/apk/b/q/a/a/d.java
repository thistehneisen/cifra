package b.q.a.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import b.g.a.a.j;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: AnimatedVectorDrawableCompat */
public class d extends i implements b {

    /* renamed from: b reason: collision with root package name */
    private a f2957b;

    /* renamed from: c reason: collision with root package name */
    private Context f2958c;

    /* renamed from: d reason: collision with root package name */
    private ArgbEvaluator f2959d;

    /* renamed from: e reason: collision with root package name */
    private AnimatorListener f2960e;

    /* renamed from: f reason: collision with root package name */
    ArrayList<b.q.a.a.b.a> f2961f;

    /* renamed from: g reason: collision with root package name */
    final Callback f2962g;

    /* compiled from: AnimatedVectorDrawableCompat */
    private static class a extends ConstantState {

        /* renamed from: a reason: collision with root package name */
        int f2963a;

        /* renamed from: b reason: collision with root package name */
        k f2964b;

        /* renamed from: c reason: collision with root package name */
        AnimatorSet f2965c;

        /* renamed from: d reason: collision with root package name */
        ArrayList<Animator> f2966d;

        /* renamed from: e reason: collision with root package name */
        b.d.b<Animator, String> f2967e;

        public a(Context context, a aVar, Callback callback, Resources resources) {
            if (aVar != null) {
                this.f2963a = aVar.f2963a;
                k kVar = aVar.f2964b;
                if (kVar != null) {
                    ConstantState constantState = kVar.getConstantState();
                    if (resources != null) {
                        this.f2964b = (k) constantState.newDrawable(resources);
                    } else {
                        this.f2964b = (k) constantState.newDrawable();
                    }
                    k kVar2 = this.f2964b;
                    kVar2.mutate();
                    this.f2964b = kVar2;
                    this.f2964b.setCallback(callback);
                    this.f2964b.setBounds(aVar.f2964b.getBounds());
                    this.f2964b.a(false);
                }
                ArrayList<Animator> arrayList = aVar.f2966d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f2966d = new ArrayList<>(size);
                    this.f2967e = new b.d.b<>(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        Animator animator = (Animator) aVar.f2966d.get(i2);
                        Animator clone = animator.clone();
                        String str = (String) aVar.f2967e.get(animator);
                        clone.setTarget(this.f2964b.a(str));
                        this.f2966d.add(clone);
                        this.f2967e.put(clone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f2965c == null) {
                this.f2965c = new AnimatorSet();
            }
            this.f2965c.playTogether(this.f2966d);
        }

        public int getChangingConfigurations() {
            return this.f2963a;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    /* compiled from: AnimatedVectorDrawableCompat */
    private static class b extends ConstantState {

        /* renamed from: a reason: collision with root package name */
        private final ConstantState f2968a;

        public b(ConstantState constantState) {
            this.f2968a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f2968a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f2968a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            d dVar = new d();
            dVar.f2973a = this.f2968a.newDrawable();
            dVar.f2973a.setCallback(dVar.f2962g);
            return dVar;
        }

        public Drawable newDrawable(Resources resources) {
            d dVar = new d();
            dVar.f2973a = this.f2968a.newDrawable(resources);
            dVar.f2973a.setCallback(dVar.f2962g);
            return dVar;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            d dVar = new d();
            dVar.f2973a = this.f2968a.newDrawable(resources, theme);
            dVar.f2973a.setCallback(dVar.f2962g);
            return dVar;
        }
    }

    d() {
        this(null, null, null);
    }

    public static d a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        d dVar = new d(context);
        dVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return dVar;
    }

    public void applyTheme(Theme theme) {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, theme);
        }
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.a(drawable);
        }
        return false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f2957b.f2964b.draw(canvas);
        if (this.f2957b.f2965c.isStarted()) {
            invalidateSelf();
        }
    }

    public int getAlpha() {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.c(drawable);
        }
        return this.f2957b.f2964b.getAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f2957b.f2963a;
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public ConstantState getConstantState() {
        Drawable drawable = this.f2973a;
        if (drawable == null || VERSION.SDK_INT < 24) {
            return null;
        }
        return new b(drawable.getConstantState());
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.f2957b.f2964b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.f2957b.f2964b.getIntrinsicWidth();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return this.f2957b.f2964b.getOpacity();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray a2 = j.a(resources, theme, attributeSet, a.f2948e);
                    int resourceId = a2.getResourceId(0, 0);
                    if (resourceId != 0) {
                        k a3 = k.a(resources, resourceId, theme);
                        a3.a(false);
                        a3.setCallback(this.f2962g);
                        k kVar = this.f2957b.f2964b;
                        if (kVar != null) {
                            kVar.setCallback(null);
                        }
                        this.f2957b.f2964b = a3;
                    }
                    a2.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, a.f2949f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f2958c;
                        if (context != null) {
                            a(string, f.a(context, resourceId2));
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f2957b.a();
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.f(drawable);
        }
        return this.f2957b.f2964b.isAutoMirrored();
    }

    public boolean isRunning() {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.f2957b.f2965c.isRunning();
    }

    public boolean isStateful() {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.f2957b.f2964b.isStateful();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f2957b.f2964b.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            return drawable.setLevel(i2);
        }
        return this.f2957b.f2964b.setLevel(i2);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return this.f2957b.f2964b.setState(iArr);
    }

    public void setAlpha(int i2) {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else {
            this.f2957b.f2964b.setAlpha(i2);
        }
    }

    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, z);
        } else {
            this.f2957b.f2964b.setAutoMirrored(z);
        }
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i2) {
        super.setChangingConfigurations(i2);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i2, Mode mode) {
        super.setColorFilter(i2, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i2, int i3, int i4, int i5) {
        super.setHotspotBounds(i2, i3, i4, i5);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i2) {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.b(drawable, i2);
        } else {
            this.f2957b.f2964b.setTint(i2);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, colorStateList);
        } else {
            this.f2957b.f2964b.setTintList(colorStateList);
        }
    }

    public void setTintMode(Mode mode) {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, mode);
        } else {
            this.f2957b.f2964b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.f2957b.f2964b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public void start() {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (!this.f2957b.f2965c.isStarted()) {
            this.f2957b.f2965c.start();
            invalidateSelf();
        }
    }

    public void stop() {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f2957b.f2965c.end();
        }
    }

    private d(Context context) {
        this(context, null, null);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f2957b.f2964b.setColorFilter(colorFilter);
        }
    }

    private d(Context context, a aVar, Resources resources) {
        this.f2959d = null;
        this.f2960e = null;
        this.f2961f = null;
        this.f2962g = new c(this);
        this.f2958c = context;
        if (aVar != null) {
            this.f2957b = aVar;
        } else {
            this.f2957b = new a(context, aVar, this.f2962g, resources);
        }
    }

    private void a(Animator animator) {
        if (animator instanceof AnimatorSet) {
            ArrayList childAnimations = ((AnimatorSet) animator).getChildAnimations();
            if (childAnimations != null) {
                for (int i2 = 0; i2 < childAnimations.size(); i2++) {
                    a((Animator) childAnimations.get(i2));
                }
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f2959d == null) {
                    this.f2959d = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f2959d);
            }
        }
    }

    private void a(String str, Animator animator) {
        animator.setTarget(this.f2957b.f2964b.a(str));
        if (VERSION.SDK_INT < 21) {
            a(animator);
        }
        a aVar = this.f2957b;
        if (aVar.f2966d == null) {
            aVar.f2966d = new ArrayList<>();
            this.f2957b.f2967e = new b.d.b<>();
        }
        this.f2957b.f2966d.add(animator);
        this.f2957b.f2967e.put(animator, str);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
