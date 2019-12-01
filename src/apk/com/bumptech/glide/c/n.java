package com.bumptech.glide.c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.C0195j;
import androidx.fragment.app.C0200o;
import androidx.fragment.app.F;
import androidx.fragment.app.Fragment;
import b.d.b;
import com.bumptech.glide.e;
import com.bumptech.glide.h.l;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: RequestManagerRetriever */
public class n implements Callback {

    /* renamed from: a reason: collision with root package name */
    private static final a f3368a = new m();

    /* renamed from: b reason: collision with root package name */
    private volatile com.bumptech.glide.n f3369b;

    /* renamed from: c reason: collision with root package name */
    final Map<FragmentManager, l> f3370c = new HashMap();

    /* renamed from: d reason: collision with root package name */
    final Map<C0200o, q> f3371d = new HashMap();

    /* renamed from: e reason: collision with root package name */
    private final Handler f3372e;

    /* renamed from: f reason: collision with root package name */
    private final a f3373f;

    /* renamed from: g reason: collision with root package name */
    private final b<View, Fragment> f3374g = new b<>();

    /* renamed from: h reason: collision with root package name */
    private final b<View, android.app.Fragment> f3375h = new b<>();

    /* renamed from: i reason: collision with root package name */
    private final Bundle f3376i = new Bundle();

    /* compiled from: RequestManagerRetriever */
    public interface a {
        com.bumptech.glide.n a(e eVar, i iVar, o oVar, Context context);
    }

    public n(a aVar) {
        if (aVar == null) {
            aVar = f3368a;
        }
        this.f3373f = aVar;
        this.f3372e = new Handler(Looper.getMainLooper(), this);
    }

    @Deprecated
    private void b(FragmentManager fragmentManager, b<View, android.app.Fragment> bVar) {
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            String str = "key";
            this.f3376i.putInt(str, i2);
            android.app.Fragment fragment = null;
            try {
                fragment = fragmentManager.getFragment(this.f3376i, str);
            } catch (Exception unused) {
            }
            if (fragment != null) {
                if (fragment.getView() != null) {
                    bVar.put(fragment.getView(), fragment);
                    if (VERSION.SDK_INT >= 17) {
                        a(fragment.getChildFragmentManager(), bVar);
                    }
                }
                i2 = i3;
            } else {
                return;
            }
        }
    }

    private com.bumptech.glide.n c(Context context) {
        if (this.f3369b == null) {
            synchronized (this) {
                if (this.f3369b == null) {
                    this.f3369b = this.f3373f.a(e.a(context.getApplicationContext()), new b(), new h(), context.getApplicationContext());
                }
            }
        }
        return this.f3369b;
    }

    private static boolean d(Activity activity) {
        return !activity.isFinishing();
    }

    public com.bumptech.glide.n a(Context context) {
        if (context != null) {
            if (com.bumptech.glide.h.n.c() && !(context instanceof Application)) {
                if (context instanceof C0195j) {
                    return a((C0195j) context);
                }
                if (context instanceof Activity) {
                    return a((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    return a(((ContextWrapper) context).getBaseContext());
                }
            }
            return c(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    public boolean handleMessage(Message message) {
        Object obj;
        int i2 = message.what;
        Object obj2 = null;
        boolean z = true;
        if (i2 == 1) {
            obj2 = (FragmentManager) message.obj;
            obj = this.f3370c.remove(obj2);
        } else if (i2 != 2) {
            z = false;
            obj = null;
        } else {
            obj2 = (C0200o) message.obj;
            obj = this.f3371d.remove(obj2);
        }
        if (z && obj == null) {
            String str = "RMRetriever";
            if (Log.isLoggable(str, 5)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to remove expected request manager fragment, manager: ");
                sb.append(obj2);
                Log.w(str, sb.toString());
            }
        }
        return z;
    }

    private Activity b(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return b(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @TargetApi(17)
    private static void c(Activity activity) {
        if (VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    public com.bumptech.glide.n a(C0195j jVar) {
        if (com.bumptech.glide.h.n.b()) {
            return a(jVar.getApplicationContext());
        }
        c((Activity) jVar);
        return a((Context) jVar, jVar.getSupportFragmentManager(), (Fragment) null, d(jVar));
    }

    /* access modifiers changed from: 0000 */
    @Deprecated
    public l b(Activity activity) {
        return a(activity.getFragmentManager(), (android.app.Fragment) null, d(activity));
    }

    /* access modifiers changed from: 0000 */
    public q b(C0195j jVar) {
        return a(jVar.getSupportFragmentManager(), (Fragment) null, d(jVar));
    }

    public com.bumptech.glide.n a(Fragment fragment) {
        l.a(fragment.getActivity(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (com.bumptech.glide.h.n.b()) {
            return a(fragment.getActivity().getApplicationContext());
        }
        return a((Context) fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    public com.bumptech.glide.n a(Activity activity) {
        if (com.bumptech.glide.h.n.b()) {
            return a(activity.getApplicationContext());
        }
        c(activity);
        return a((Context) activity, activity.getFragmentManager(), (android.app.Fragment) null, d(activity));
    }

    public com.bumptech.glide.n a(View view) {
        if (com.bumptech.glide.h.n.b()) {
            return a(view.getContext().getApplicationContext());
        }
        l.a(view);
        l.a(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity b2 = b(view.getContext());
        if (b2 == null) {
            return a(view.getContext().getApplicationContext());
        }
        if (b2 instanceof C0195j) {
            Fragment a2 = a(view, (C0195j) b2);
            return a2 != null ? a(a2) : a(b2);
        }
        android.app.Fragment a3 = a(view, b2);
        if (a3 == null) {
            return a(b2);
        }
        return a(a3);
    }

    private static void a(Collection<Fragment> collection, Map<View, Fragment> map) {
        if (collection != null) {
            for (Fragment fragment : collection) {
                if (!(fragment == null || fragment.getView() == null)) {
                    map.put(fragment.getView(), fragment);
                    a((Collection<Fragment>) fragment.getChildFragmentManager().d(), map);
                }
            }
        }
    }

    private Fragment a(View view, C0195j jVar) {
        this.f3374g.clear();
        a((Collection<Fragment>) jVar.getSupportFragmentManager().d(), (Map<View, Fragment>) this.f3374g);
        View findViewById = jVar.findViewById(16908290);
        Fragment fragment = null;
        while (!view.equals(findViewById)) {
            fragment = (Fragment) this.f3374g.get(view);
            if (fragment != null || !(view.getParent() instanceof View)) {
                break;
            }
            view = (View) view.getParent();
        }
        this.f3374g.clear();
        return fragment;
    }

    @Deprecated
    private android.app.Fragment a(View view, Activity activity) {
        this.f3375h.clear();
        a(activity.getFragmentManager(), this.f3375h);
        View findViewById = activity.findViewById(16908290);
        android.app.Fragment fragment = null;
        while (!view.equals(findViewById)) {
            fragment = (android.app.Fragment) this.f3375h.get(view);
            if (fragment != null || !(view.getParent() instanceof View)) {
                break;
            }
            view = (View) view.getParent();
        }
        this.f3375h.clear();
        return fragment;
    }

    @TargetApi(26)
    @Deprecated
    private void a(FragmentManager fragmentManager, b<View, android.app.Fragment> bVar) {
        if (VERSION.SDK_INT >= 26) {
            for (android.app.Fragment fragment : fragmentManager.getFragments()) {
                if (fragment.getView() != null) {
                    bVar.put(fragment.getView(), fragment);
                    a(fragment.getChildFragmentManager(), bVar);
                }
            }
            return;
        }
        b(fragmentManager, bVar);
    }

    @TargetApi(17)
    @Deprecated
    public com.bumptech.glide.n a(android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        } else if (com.bumptech.glide.h.n.b() || VERSION.SDK_INT < 17) {
            return a(fragment.getActivity().getApplicationContext());
        } else {
            return a((Context) fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
        }
    }

    private l a(FragmentManager fragmentManager, android.app.Fragment fragment, boolean z) {
        String str = "com.bumptech.glide.manager";
        l lVar = (l) fragmentManager.findFragmentByTag(str);
        if (lVar == null) {
            lVar = (l) this.f3370c.get(fragmentManager);
            if (lVar == null) {
                lVar = new l();
                lVar.a(fragment);
                if (z) {
                    lVar.a().b();
                }
                this.f3370c.put(fragmentManager, lVar);
                fragmentManager.beginTransaction().add(lVar, str).commitAllowingStateLoss();
                this.f3372e.obtainMessage(1, fragmentManager).sendToTarget();
            }
        }
        return lVar;
    }

    @Deprecated
    private com.bumptech.glide.n a(Context context, FragmentManager fragmentManager, android.app.Fragment fragment, boolean z) {
        l a2 = a(fragmentManager, fragment, z);
        com.bumptech.glide.n b2 = a2.b();
        if (b2 != null) {
            return b2;
        }
        com.bumptech.glide.n a3 = this.f3373f.a(e.a(context), a2.a(), a2.c(), context);
        a2.a(a3);
        return a3;
    }

    private q a(C0200o oVar, Fragment fragment, boolean z) {
        String str = "com.bumptech.glide.manager";
        q qVar = (q) oVar.a(str);
        if (qVar == null) {
            qVar = (q) this.f3371d.get(oVar);
            if (qVar == null) {
                qVar = new q();
                qVar.a(fragment);
                if (z) {
                    qVar.a().b();
                }
                this.f3371d.put(oVar, qVar);
                F a2 = oVar.a();
                a2.a((Fragment) qVar, str);
                a2.b();
                this.f3372e.obtainMessage(2, oVar).sendToTarget();
            }
        }
        return qVar;
    }

    private com.bumptech.glide.n a(Context context, C0200o oVar, Fragment fragment, boolean z) {
        q a2 = a(oVar, fragment, z);
        com.bumptech.glide.n b2 = a2.b();
        if (b2 != null) {
            return b2;
        }
        com.bumptech.glide.n a3 = this.f3373f.a(e.a(context), a2.a(), a2.c(), context);
        a2.a(a3);
        return a3;
    }
}
