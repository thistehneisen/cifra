package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.app.b;
import b.g.h.g;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: androidx.fragment.app.n reason: case insensitive filesystem */
/* compiled from: FragmentHostCallback */
public abstract class C0199n<E> extends C0196k {

    /* renamed from: a reason: collision with root package name */
    private final Activity f1539a;

    /* renamed from: b reason: collision with root package name */
    private final Context f1540b;

    /* renamed from: c reason: collision with root package name */
    private final Handler f1541c;

    /* renamed from: d reason: collision with root package name */
    private final int f1542d;

    /* renamed from: e reason: collision with root package name */
    final C0207w f1543e;

    C0199n(C0195j jVar) {
        this(jVar, jVar, new Handler(), 0);
    }

    public View a(int i2) {
        return null;
    }

    /* access modifiers changed from: 0000 */
    public void a(Fragment fragment) {
    }

    public void a(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        if (i2 == -1) {
            this.f1540b.startActivity(intent);
            return;
        }
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    public void a(Fragment fragment, String[] strArr, int i2) {
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public boolean a() {
        return true;
    }

    public boolean a(String str) {
        return false;
    }

    /* access modifiers changed from: 0000 */
    public Activity b() {
        return this.f1539a;
    }

    public boolean b(Fragment fragment) {
        return true;
    }

    /* access modifiers changed from: 0000 */
    public Context c() {
        return this.f1540b;
    }

    /* access modifiers changed from: 0000 */
    public Handler d() {
        return this.f1541c;
    }

    public abstract E e();

    public LayoutInflater f() {
        return LayoutInflater.from(this.f1540b);
    }

    public int g() {
        return this.f1542d;
    }

    public boolean h() {
        return true;
    }

    public void i() {
    }

    C0199n(Activity activity, Context context, Handler handler, int i2) {
        this.f1543e = new C0207w();
        this.f1539a = activity;
        g.a(context, "context == null");
        this.f1540b = context;
        g.a(handler, "handler == null");
        this.f1541c = handler;
        this.f1542d = i2;
    }

    public void a(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws SendIntentException {
        if (i2 == -1) {
            b.a(this.f1539a, intentSender, i2, intent, i3, i4, i5, bundle);
        } else {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
    }
}
