package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.appcompat.widget.Fa;
import androidx.appcompat.widget.Toolbar;
import b.a.d.b;
import b.a.d.b.a;

/* compiled from: AppCompatDelegate */
public abstract class p {

    /* renamed from: a reason: collision with root package name */
    private static int f498a = -1;

    p() {
    }

    public static p a(Activity activity, o oVar) {
        return new y(activity, activity.getWindow(), oVar);
    }

    public static int b() {
        return f498a;
    }

    public abstract <T extends View> T a(int i2);

    public abstract b a(a aVar);

    public abstract void a(Configuration configuration);

    public abstract void a(Bundle bundle);

    public abstract void a(View view);

    public abstract void a(View view, LayoutParams layoutParams);

    public abstract void a(Toolbar toolbar);

    public abstract void a(CharSequence charSequence);

    public abstract boolean a();

    public abstract void b(Bundle bundle);

    public abstract void b(View view, LayoutParams layoutParams);

    public abstract boolean b(int i2);

    public abstract C0135b c();

    public abstract void c(int i2);

    public abstract void c(Bundle bundle);

    public abstract MenuInflater d();

    public abstract C0134a e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract void i();

    public abstract void j();

    public abstract void k();

    public static p a(Dialog dialog, o oVar) {
        return new y(dialog.getContext(), dialog.getWindow(), oVar);
    }

    public static void a(boolean z) {
        Fa.a(z);
    }
}
