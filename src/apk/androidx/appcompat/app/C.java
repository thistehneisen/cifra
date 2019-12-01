package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import b.a.d.b;
import b.g.i.C0244e;
import b.g.i.C0244e.a;

/* compiled from: AppCompatDialog */
public class C extends Dialog implements o {

    /* renamed from: a reason: collision with root package name */
    private p f413a;

    /* renamed from: b reason: collision with root package name */
    private final a f414b = new B(this);

    public C(Context context, int i2) {
        super(context, a(context, i2));
        a().a((Bundle) null);
        a().a();
    }

    public boolean a(int i2) {
        return a().b(i2);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        a().a(view, layoutParams);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return C0244e.a(this.f414b, getWindow().getDecorView(), this, keyEvent);
    }

    public <T extends View> T findViewById(int i2) {
        return a().a(i2);
    }

    public void invalidateOptionsMenu() {
        a().g();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        a().f();
        super.onCreate(bundle);
        a().a(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        a().k();
    }

    public void onSupportActionModeFinished(b bVar) {
    }

    public void onSupportActionModeStarted(b bVar) {
    }

    public b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }

    public void setContentView(int i2) {
        a().c(i2);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().a(charSequence);
    }

    public p a() {
        if (this.f413a == null) {
            this.f413a = p.a((Dialog) this, (o) this);
        }
        return this.f413a;
    }

    public void setContentView(View view) {
        a().a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        a().b(view, layoutParams);
    }

    public void setTitle(int i2) {
        super.setTitle(i2);
        a().a((CharSequence) getContext().getString(i2));
    }

    private static int a(Context context, int i2) {
        if (i2 != 0) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(b.a.a.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    /* access modifiers changed from: 0000 */
    public boolean a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
