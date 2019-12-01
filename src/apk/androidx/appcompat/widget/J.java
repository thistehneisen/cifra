package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window.Callback;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.v.a;
import b.g.i.K;

/* compiled from: DecorToolbar */
public interface J {
    Context a();

    K a(int i2, long j2);

    void a(int i2);

    void a(Menu menu, a aVar);

    void a(a aVar, l.a aVar2);

    void a(Y y);

    void a(CharSequence charSequence);

    void a(boolean z);

    void b(int i2);

    void b(boolean z);

    boolean b();

    void c();

    void c(int i2);

    void collapseActionView();

    void d(int i2);

    boolean d();

    boolean e();

    boolean f();

    boolean g();

    CharSequence getTitle();

    void h();

    boolean i();

    Menu j();

    int k();

    ViewGroup l();

    int m();

    void n();

    void o();

    void setIcon(int i2);

    void setIcon(Drawable drawable);

    void setTitle(CharSequence charSequence);

    void setWindowCallback(Callback callback);

    void setWindowTitle(CharSequence charSequence);
}
