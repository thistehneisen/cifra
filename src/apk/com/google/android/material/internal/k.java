package com.google.android.material.internal;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

/* compiled from: StateListAnimator */
public final class k {

    /* renamed from: a reason: collision with root package name */
    private final ArrayList<a> f6486a = new ArrayList<>();

    /* renamed from: b reason: collision with root package name */
    private a f6487b = null;

    /* renamed from: c reason: collision with root package name */
    ValueAnimator f6488c = null;

    /* renamed from: d reason: collision with root package name */
    private final AnimatorListener f6489d = new j(this);

    /* compiled from: StateListAnimator */
    static class a {

        /* renamed from: a reason: collision with root package name */
        final int[] f6490a;

        /* renamed from: b reason: collision with root package name */
        final ValueAnimator f6491b;

        a(int[] iArr, ValueAnimator valueAnimator) {
            this.f6490a = iArr;
            this.f6491b = valueAnimator;
        }
    }

    private void b() {
        ValueAnimator valueAnimator = this.f6488c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f6488c = null;
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        a aVar = new a(iArr, valueAnimator);
        valueAnimator.addListener(this.f6489d);
        this.f6486a.add(aVar);
    }

    public void a(int[] iArr) {
        a aVar;
        int size = this.f6486a.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                aVar = null;
                break;
            }
            aVar = (a) this.f6486a.get(i2);
            if (StateSet.stateSetMatches(aVar.f6490a, iArr)) {
                break;
            }
            i2++;
        }
        a aVar2 = this.f6487b;
        if (aVar != aVar2) {
            if (aVar2 != null) {
                b();
            }
            this.f6487b = aVar;
            if (aVar != null) {
                a(aVar);
            }
        }
    }

    private void a(a aVar) {
        this.f6488c = aVar.f6491b;
        this.f6488c.start();
    }

    public void a() {
        ValueAnimator valueAnimator = this.f6488c;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f6488c = null;
        }
    }
}
