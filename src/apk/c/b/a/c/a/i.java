package c.b.a.c.a;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* compiled from: MotionTiming */
public class i {

    /* renamed from: a reason: collision with root package name */
    private long f3105a = 0;

    /* renamed from: b reason: collision with root package name */
    private long f3106b = 300;

    /* renamed from: c reason: collision with root package name */
    private TimeInterpolator f3107c = null;

    /* renamed from: d reason: collision with root package name */
    private int f3108d = 0;

    /* renamed from: e reason: collision with root package name */
    private int f3109e = 1;

    public i(long j2, long j3) {
        this.f3105a = j2;
        this.f3106b = j3;
    }

    public void a(Animator animator) {
        animator.setStartDelay(a());
        animator.setDuration(b());
        animator.setInterpolator(c());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(d());
            valueAnimator.setRepeatMode(e());
        }
    }

    public long b() {
        return this.f3106b;
    }

    public TimeInterpolator c() {
        TimeInterpolator timeInterpolator = this.f3107c;
        return timeInterpolator != null ? timeInterpolator : a.f3092b;
    }

    public int d() {
        return this.f3108d;
    }

    public int e() {
        return this.f3109e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (a() == iVar.a() && b() == iVar.b() && d() == iVar.d() && e() == iVar.e()) {
            return c().getClass().equals(iVar.c().getClass());
        }
        return false;
    }

    public int hashCode() {
        return (((((((((int) (a() ^ (a() >>> 32))) * 31) + ((int) (b() ^ (b() >>> 32)))) * 31) + c().getClass().hashCode()) * 31) + d()) * 31) + e();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(10);
        sb.append(i.class.getName());
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" delay: ");
        sb.append(a());
        sb.append(" duration: ");
        sb.append(b());
        sb.append(" interpolator: ");
        sb.append(c().getClass());
        sb.append(" repeatCount: ");
        sb.append(d());
        sb.append(" repeatMode: ");
        sb.append(e());
        sb.append("}\n");
        return sb.toString();
    }

    private static TimeInterpolator b(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
            return a.f3092b;
        }
        if (interpolator instanceof AccelerateInterpolator) {
            return a.f3093c;
        }
        if (interpolator instanceof DecelerateInterpolator) {
            interpolator = a.f3094d;
        }
        return interpolator;
    }

    public long a() {
        return this.f3105a;
    }

    static i a(ValueAnimator valueAnimator) {
        i iVar = new i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), b(valueAnimator));
        iVar.f3108d = valueAnimator.getRepeatCount();
        iVar.f3109e = valueAnimator.getRepeatMode();
        return iVar;
    }

    public i(long j2, long j3, TimeInterpolator timeInterpolator) {
        this.f3105a = j2;
        this.f3106b = j3;
        this.f3107c = timeInterpolator;
    }
}
