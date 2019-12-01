package b.q.a.a;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

/* compiled from: AnimatedVectorDrawableCompat */
class c implements Callback {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ d f2956a;

    c(d dVar) {
        this.f2956a = dVar;
    }

    public void invalidateDrawable(Drawable drawable) {
        this.f2956a.invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        this.f2956a.scheduleSelf(runnable, j2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.f2956a.unscheduleSelf(runnable);
    }
}
