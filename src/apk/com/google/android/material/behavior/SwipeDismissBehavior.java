package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.g.i.B;
import b.i.b.g;

public class SwipeDismissBehavior<V extends View> extends androidx.coordinatorlayout.widget.CoordinatorLayout.b<V> {

    /* renamed from: a reason: collision with root package name */
    g f6303a;

    /* renamed from: b reason: collision with root package name */
    a f6304b;

    /* renamed from: c reason: collision with root package name */
    private boolean f6305c;

    /* renamed from: d reason: collision with root package name */
    private float f6306d = 0.0f;

    /* renamed from: e reason: collision with root package name */
    private boolean f6307e;

    /* renamed from: f reason: collision with root package name */
    int f6308f = 2;

    /* renamed from: g reason: collision with root package name */
    float f6309g = 0.5f;

    /* renamed from: h reason: collision with root package name */
    float f6310h = 0.0f;

    /* renamed from: i reason: collision with root package name */
    float f6311i = 0.5f;

    /* renamed from: j reason: collision with root package name */
    private final b.i.b.g.a f6312j = new b(this);

    public interface a {
        void a(int i2);

        void a(View view);
    }

    private class b implements Runnable {

        /* renamed from: a reason: collision with root package name */
        private final View f6313a;

        /* renamed from: b reason: collision with root package name */
        private final boolean f6314b;

        b(View view, boolean z) {
            this.f6313a = view;
            this.f6314b = z;
        }

        public void run() {
            g gVar = SwipeDismissBehavior.this.f6303a;
            if (gVar != null && gVar.a(true)) {
                B.a(this.f6313a, (Runnable) this);
            } else if (this.f6314b) {
                a aVar = SwipeDismissBehavior.this.f6304b;
                if (aVar != null) {
                    aVar.a(this.f6313a);
                }
            }
        }
    }

    static float b(float f2, float f3, float f4) {
        return (f4 - f2) / (f3 - f2);
    }

    public void a(a aVar) {
        this.f6304b = aVar;
    }

    public boolean a(View view) {
        return true;
    }

    public void b(float f2) {
        this.f6310h = a(0.0f, f2, 1.0f);
    }

    public void a(int i2) {
        this.f6308f = i2;
    }

    public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        g gVar = this.f6303a;
        if (gVar == null) {
            return false;
        }
        gVar.a(motionEvent);
        return true;
    }

    public void a(float f2) {
        this.f6311i = a(0.0f, f2, 1.0f);
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.f6305c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f6305c = coordinatorLayout.a((View) v, (int) motionEvent.getX(), (int) motionEvent.getY());
            z = this.f6305c;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f6305c = false;
        }
        if (!z) {
            return false;
        }
        a((ViewGroup) coordinatorLayout);
        return this.f6303a.b(motionEvent);
    }

    private void a(ViewGroup viewGroup) {
        g gVar;
        if (this.f6303a == null) {
            if (this.f6307e) {
                gVar = g.a(viewGroup, this.f6306d, this.f6312j);
            } else {
                gVar = g.a(viewGroup, this.f6312j);
            }
            this.f6303a = gVar;
        }
    }

    static float a(float f2, float f3, float f4) {
        return Math.min(Math.max(f2, f3), f4);
    }

    static int a(int i2, int i3, int i4) {
        return Math.min(Math.max(i2, i3), i4);
    }
}
