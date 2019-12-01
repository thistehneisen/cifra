package androidx.appcompat.widget;

import android.view.View;
import b.g.i.M;

/* compiled from: ToolbarWidgetWrapper */
class ya extends M {

    /* renamed from: a reason: collision with root package name */
    private boolean f1061a = false;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ int f1062b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ za f1063c;

    ya(za zaVar, int i2) {
        this.f1063c = zaVar;
        this.f1062b = i2;
    }

    public void a(View view) {
        this.f1061a = true;
    }

    public void b(View view) {
        if (!this.f1061a) {
            this.f1063c.f1070a.setVisibility(this.f1062b);
        }
    }

    public void c(View view) {
        this.f1063c.f1070a.setVisibility(0);
    }
}
