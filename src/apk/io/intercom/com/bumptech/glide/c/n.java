package io.intercom.com.bumptech.glide.c;

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
import io.intercom.com.bumptech.glide.c;
import io.intercom.com.bumptech.glide.h.h;
import io.intercom.com.bumptech.glide.h.j;
import java.util.HashMap;
import java.util.Map;

/* compiled from: RequestManagerRetriever */
public class n implements Callback {

    /* renamed from: a reason: collision with root package name */
    private static final a f9237a = new m();

    /* renamed from: b reason: collision with root package name */
    private volatile io.intercom.com.bumptech.glide.n f9238b;

    /* renamed from: c reason: collision with root package name */
    final Map<FragmentManager, l> f9239c = new HashMap();

    /* renamed from: d reason: collision with root package name */
    final Map<C0200o, q> f9240d = new HashMap();

    /* renamed from: e reason: collision with root package name */
    private final Handler f9241e;

    /* renamed from: f reason: collision with root package name */
    private final a f9242f;

    /* renamed from: g reason: collision with root package name */
    private final b<View, Fragment> f9243g = new b<>();

    /* renamed from: h reason: collision with root package name */
    private final b<View, android.app.Fragment> f9244h = new b<>();

    /* renamed from: i reason: collision with root package name */
    private final Bundle f9245i = new Bundle();

    /* compiled from: RequestManagerRetriever */
    public interface a {
        io.intercom.com.bumptech.glide.n a(c cVar, i iVar, o oVar, Context context);
    }

    public n(a aVar) {
        if (aVar == null) {
            aVar = f9237a;
        }
        this.f9242f = aVar;
        this.f9241e = new Handler(Looper.getMainLooper(), this);
    }

    private io.intercom.com.bumptech.glide.n b(Context context) {
        if (this.f9238b == null) {
            synchronized (this) {
                if (this.f9238b == null) {
                    this.f9238b = this.f9242f.a(c.a(context.getApplicationContext()), new b(), new h(), context.getApplicationContext());
                }
            }
        }
        return this.f9238b;
    }

    public io.intercom.com.bumptech.glide.n a(Context context) {
        if (context != null) {
            if (j.d() && !(context instanceof Application)) {
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
            return b(context);
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
            obj = this.f9239c.remove(obj2);
        } else if (i2 != 2) {
            z = false;
            obj = null;
        } else {
            obj2 = (C0200o) message.obj;
            obj = this.f9240d.remove(obj2);
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

    @TargetApi(17)
    private static void b(Activity activity) {
        if (VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    public io.intercom.com.bumptech.glide.n a(C0195j jVar) {
        if (j.c()) {
            return a(jVar.getApplicationContext());
        }
        b((Activity) jVar);
        return a((Context) jVar, jVar.getSupportFragmentManager(), (Fragment) null);
    }

    public io.intercom.com.bumptech.glide.n a(Fragment fragment) {
        h.a(fragment.getActivity(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (j.c()) {
            return a(fragment.getActivity().getApplicationContext());
        }
        return a((Context) fragment.getActivity(), fragment.getChildFragmentManager(), fragment);
    }

    public io.intercom.com.bumptech.glide.n a(Activity activity) {
        if (j.c()) {
            return a(activity.getApplicationContext());
        }
        b(activity);
        return a((Context) activity, activity.getFragmentManager(), (android.app.Fragment) null);
    }

    /* access modifiers changed from: 0000 */
    @TargetApi(17)
    public l a(FragmentManager fragmentManager, android.app.Fragment fragment) {
        String str = "io.intercom.com.bumptech.glide.manager";
        l lVar = (l) fragmentManager.findFragmentByTag(str);
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = (l) this.f9239c.get(fragmentManager);
        if (lVar2 != null) {
            return lVar2;
        }
        l lVar3 = new l();
        lVar3.a(fragment);
        this.f9239c.put(fragmentManager, lVar3);
        fragmentManager.beginTransaction().add(lVar3, str).commitAllowingStateLoss();
        this.f9241e.obtainMessage(1, fragmentManager).sendToTarget();
        return lVar3;
    }

    private io.intercom.com.bumptech.glide.n a(Context context, FragmentManager fragmentManager, android.app.Fragment fragment) {
        l a2 = a(fragmentManager, fragment);
        io.intercom.com.bumptech.glide.n b2 = a2.b();
        if (b2 != null) {
            return b2;
        }
        io.intercom.com.bumptech.glide.n a3 = this.f9242f.a(c.a(context), a2.a(), a2.c(), context);
        a2.a(a3);
        return a3;
    }

    /* access modifiers changed from: 0000 */
    public q a(C0200o oVar, Fragment fragment) {
        String str = "io.intercom.com.bumptech.glide.manager";
        q qVar = (q) oVar.a(str);
        if (qVar != null) {
            return qVar;
        }
        q qVar2 = (q) this.f9240d.get(oVar);
        if (qVar2 != null) {
            return qVar2;
        }
        q qVar3 = new q();
        qVar3.a(fragment);
        this.f9240d.put(oVar, qVar3);
        F a2 = oVar.a();
        a2.a((Fragment) qVar3, str);
        a2.b();
        this.f9241e.obtainMessage(2, oVar).sendToTarget();
        return qVar3;
    }

    private io.intercom.com.bumptech.glide.n a(Context context, C0200o oVar, Fragment fragment) {
        q a2 = a(oVar, fragment);
        io.intercom.com.bumptech.glide.n b2 = a2.b();
        if (b2 != null) {
            return b2;
        }
        io.intercom.com.bumptech.glide.n a3 = this.f9242f.a(c.a(context), a2.a(), a2.c(), context);
        a2.a(a3);
        return a3;
    }
}
