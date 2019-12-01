package b.g.i.a;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* compiled from: AccessibilityClickableSpanCompat */
public final class a extends ClickableSpan {

    /* renamed from: a reason: collision with root package name */
    private final int f2666a;

    /* renamed from: b reason: collision with root package name */
    private final d f2667b;

    /* renamed from: c reason: collision with root package name */
    private final int f2668c;

    public a(int i2, d dVar, int i3) {
        this.f2666a = i2;
        this.f2667b = dVar;
        this.f2668c = i3;
    }

    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f2666a);
        this.f2667b.a(this.f2668c, bundle);
    }
}
