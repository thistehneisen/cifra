package b.g.i;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

/* compiled from: OneShotPreDrawListener */
public final class s implements OnPreDrawListener, OnAttachStateChangeListener {

    /* renamed from: a reason: collision with root package name */
    private final View f2723a;

    /* renamed from: b reason: collision with root package name */
    private ViewTreeObserver f2724b;

    /* renamed from: c reason: collision with root package name */
    private final Runnable f2725c;

    private s(View view, Runnable runnable) {
        this.f2723a = view;
        this.f2724b = view.getViewTreeObserver();
        this.f2725c = runnable;
    }

    public static s a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        } else if (runnable != null) {
            s sVar = new s(view, runnable);
            view.getViewTreeObserver().addOnPreDrawListener(sVar);
            view.addOnAttachStateChangeListener(sVar);
            return sVar;
        } else {
            throw new NullPointerException("runnable == null");
        }
    }

    public boolean onPreDraw() {
        a();
        this.f2725c.run();
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        this.f2724b = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        a();
    }

    public void a() {
        if (this.f2724b.isAlive()) {
            this.f2724b.removeOnPreDrawListener(this);
        } else {
            this.f2723a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f2723a.removeOnAttachStateChangeListener(this);
    }
}
