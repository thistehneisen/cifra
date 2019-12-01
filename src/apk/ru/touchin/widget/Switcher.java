package ru.touchin.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import b.g.i.B;
import java.util.NoSuchElementException;
import ru.touchin.roboswag.components.views.c;
import ru.touchin.roboswag.components.views.d;

public class Switcher extends FrameLayout {

    /* renamed from: a reason: collision with root package name */
    private final int f11190a;

    /* renamed from: b reason: collision with root package name */
    private Animation f11191b;

    /* renamed from: c reason: collision with root package name */
    private Animation f11192c;

    public Switcher(Context context) {
        this(context, null);
    }

    public void a(int i2) {
        boolean z = false;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getId() == i2) {
                a(childAt, 0);
                z = true;
            } else {
                a(childAt, 8);
            }
        }
        if (!z) {
            throw new NoSuchElementException();
        }
    }

    public void addView(View view, int i2, LayoutParams layoutParams) {
        int id = view.getId();
        int i3 = this.f11190a;
        if (id == i3 || (i3 == -1 && getChildCount() == 0)) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
        super.addView(view, i2, layoutParams);
    }

    public Switcher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.Switcher, 0, c.Switcher);
        this.f11190a = obtainStyledAttributes.getResourceId(d.Switcher_defaultChild, -1);
        this.f11191b = AnimationUtils.loadAnimation(context, obtainStyledAttributes.getResourceId(d.Switcher_android_inAnimation, 17432576));
        this.f11192c = AnimationUtils.loadAnimation(context, obtainStyledAttributes.getResourceId(d.Switcher_android_outAnimation, 17432577));
        obtainStyledAttributes.recycle();
    }

    private void a(View view, int i2) {
        Animation animation = i2 == 0 ? this.f11191b : this.f11192c;
        if (view.getVisibility() != i2) {
            if (B.C(this) && animation != null) {
                view.startAnimation(animation);
            }
            view.setVisibility(i2);
        }
    }
}
