package c.b.a.c.a;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import b.j.a.a.b;
import b.j.a.a.c;

/* compiled from: AnimationUtils */
public class a {

    /* renamed from: a reason: collision with root package name */
    public static final TimeInterpolator f3091a = new LinearInterpolator();

    /* renamed from: b reason: collision with root package name */
    public static final TimeInterpolator f3092b = new b();

    /* renamed from: c reason: collision with root package name */
    public static final TimeInterpolator f3093c = new b.j.a.a.a();

    /* renamed from: d reason: collision with root package name */
    public static final TimeInterpolator f3094d = new c();

    /* renamed from: e reason: collision with root package name */
    public static final TimeInterpolator f3095e = new DecelerateInterpolator();

    public static float a(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    public static int a(int i2, int i3, float f2) {
        return i2 + Math.round(f2 * ((float) (i3 - i2)));
    }
}
