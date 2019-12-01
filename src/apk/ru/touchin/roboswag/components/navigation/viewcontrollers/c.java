package ru.touchin.roboswag.components.navigation.viewcontrollers;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.C0195j;
import androidx.lifecycle.l;
import java.util.Arrays;
import kotlin.TypeCastException;
import kotlin.e.b.h;
import l.a.d.a.b.a.b;

/* compiled from: ViewController.kt */
public class c<TActivity extends C0195j, TState extends Parcelable> implements l {
    private final TActivity activity;
    private final l.a.d.a.a.b.a<? extends TActivity, ? extends TState> fragment;
    private final TState state;
    private final View view;

    /* compiled from: ViewController.kt */
    public static final class a {

        /* renamed from: a reason: collision with root package name */
        private final C0195j f11114a;

        /* renamed from: b reason: collision with root package name */
        private final l.a.d.a.a.b.a<?, ?> f11115b;

        /* renamed from: c reason: collision with root package name */
        private final LayoutInflater f11116c;

        /* renamed from: d reason: collision with root package name */
        private final ViewGroup f11117d;

        public a(C0195j jVar, l.a.d.a.a.b.a<?, ?> aVar, LayoutInflater layoutInflater, ViewGroup viewGroup) {
            h.b(jVar, "activity");
            h.b(aVar, "fragment");
            h.b(layoutInflater, "inflater");
            this.f11114a = jVar;
            this.f11115b = aVar;
            this.f11116c = layoutInflater;
            this.f11117d = viewGroup;
        }

        public final C0195j a() {
            return this.f11114a;
        }

        public final ViewGroup b() {
            return this.f11117d;
        }

        public final l.a.d.a.a.b.a<?, ?> c() {
            return this.f11115b;
        }

        public final LayoutInflater d() {
            return this.f11116c;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
            if (kotlin.e.b.h.a((java.lang.Object) r2.f11117d, (java.lang.Object) r3.f11117d) != false) goto L_0x0033;
         */
        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (h.a((Object) this.f11114a, (Object) aVar.f11114a)) {
                        if (h.a((Object) this.f11115b, (Object) aVar.f11115b)) {
                            if (h.a((Object) this.f11116c, (Object) aVar.f11116c)) {
                            }
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            C0195j jVar = this.f11114a;
            int i2 = 0;
            int hashCode = (jVar != null ? jVar.hashCode() : 0) * 31;
            l.a.d.a.a.b.a<?, ?> aVar = this.f11115b;
            int hashCode2 = (hashCode + (aVar != null ? aVar.hashCode() : 0)) * 31;
            LayoutInflater layoutInflater = this.f11116c;
            int hashCode3 = (hashCode2 + (layoutInflater != null ? layoutInflater.hashCode() : 0)) * 31;
            ViewGroup viewGroup = this.f11117d;
            if (viewGroup != null) {
                i2 = viewGroup.hashCode();
            }
            return hashCode3 + i2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("CreationContext(activity=");
            sb.append(this.f11114a);
            sb.append(", fragment=");
            sb.append(this.f11115b);
            sb.append(", inflater=");
            sb.append(this.f11116c);
            sb.append(", container=");
            sb.append(this.f11117d);
            sb.append(")");
            return sb.toString();
        }
    }

    public c(a aVar, int i2) {
        h.b(aVar, "creationContext");
        TActivity a2 = aVar.a();
        if (a2 != null) {
            this.activity = a2;
            l.a.d.a.a.b.a<? extends TActivity, ? extends TState> c2 = aVar.c();
            if (c2 != null) {
                this.fragment = c2;
                this.state = this.fragment.a();
                View inflate = aVar.d().inflate(i2, aVar.b(), false);
                h.a((Object) inflate, "creationContext.inflater…Context.container, false)");
                this.view = inflate;
                getLifecycle().a(new LifecycleLoggingObserver());
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type ru.touchin.roboswag.components.navigation.fragments.ViewControllerFragment<out TActivity, out TState>");
        }
        throw new TypeCastException("null cannot be cast to non-null type TActivity");
    }

    public final <T extends View> T findViewById(int i2) {
        T findViewById = this.view.findViewById(i2);
        h.a((Object) findViewById, "view.findViewById(id)");
        return findViewById;
    }

    public final TActivity getActivity() {
        return this.activity;
    }

    public final int getColor(int i2) {
        return b.g.a.a.a((Context) this.activity, i2);
    }

    public final ColorStateList getColorStateList(int i2) {
        return b.g.a.a.b(this.activity, i2);
    }

    public final Drawable getDrawable(int i2) {
        return b.g.a.a.c(this.activity, i2);
    }

    public final l.a.d.a.a.b.a<? extends TActivity, ? extends TState> getFragment() {
        return this.fragment;
    }

    public androidx.lifecycle.h getLifecycle() {
        l viewLifecycleOwner = this.fragment.getViewLifecycleOwner();
        h.a((Object) viewLifecycleOwner, "fragment.viewLifecycleOwner");
        androidx.lifecycle.h lifecycle = viewLifecycleOwner.getLifecycle();
        h.a((Object) lifecycle, "fragment.viewLifecycleOwner.lifecycle");
        return lifecycle;
    }

    public final TState getState() {
        return this.state;
    }

    public final String getString(int i2) {
        String string = this.activity.getString(i2);
        h.a((Object) string, "activity.getString(resId)");
        return string;
    }

    public final CharSequence getText(int i2) {
        CharSequence text = this.activity.getText(i2);
        h.a((Object) text, "activity.getText(resId)");
        return text;
    }

    public final View getView() {
        return this.view;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
    }

    public void onAppear() {
    }

    public void onCreate() {
    }

    public Animation onCreateAnimation(int i2, boolean z, int i3) {
        return null;
    }

    public Animator onCreateAnimator(int i2, boolean z, int i3) {
        return null;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        h.b(menu, "menu");
        h.b(menuInflater, "inflater");
    }

    public void onDestroy() {
    }

    public void onDisappear() {
    }

    public void onLowMemory() {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        h.b(menuItem, "item");
        return false;
    }

    public void onPause() {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        h.b(strArr, "permissions");
        h.b(iArr, "grantResults");
    }

    public void onResume() {
    }

    public void onSaveInstanceState(Bundle bundle) {
        h.b(bundle, "savedInstanceState");
    }

    public void onStart() {
        b.a(this.view);
    }

    public void onStop() {
    }

    public void onViewStateRestored(Bundle bundle) {
    }

    public final void startActivity(Intent intent) {
        h.b(intent, "intent");
        this.fragment.startActivity(intent);
    }

    public final void startActivityForResult(Intent intent, int i2) {
        h.b(intent, "intent");
        this.fragment.startActivityForResult(intent, i2);
    }

    public final String getString(int i2, Object... objArr) {
        h.b(objArr, "formatArgs");
        String string = this.activity.getString(i2, Arrays.copyOf(objArr, objArr.length));
        h.a((Object) string, "activity.getString(resId, *formatArgs)");
        return string;
    }
}
