package androidx.activity;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import androidx.core.app.g;
import androidx.lifecycle.B;
import androidx.lifecycle.F;
import androidx.lifecycle.G;
import androidx.lifecycle.h;
import androidx.lifecycle.l;
import androidx.lifecycle.n;
import androidx.savedstate.b;

/* compiled from: ComponentActivity */
public class c extends g implements l, G, androidx.savedstate.c, e {
    private int mContentLayoutId;
    private final n mLifecycleRegistry;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final b mSavedStateRegistryController;
    private F mViewModelStore;

    /* compiled from: ComponentActivity */
    static final class a {

        /* renamed from: a reason: collision with root package name */
        Object f376a;

        /* renamed from: b reason: collision with root package name */
        F f377b;

        a() {
        }
    }

    public c() {
        this.mLifecycleRegistry = new n(this);
        this.mSavedStateRegistryController = b.a((androidx.savedstate.c) this);
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new b(this));
        if (getLifecycle() != null) {
            if (VERSION.SDK_INT >= 19) {
                getLifecycle().a(new ComponentActivity$2(this));
            }
            getLifecycle().a(new ComponentActivity$3(this));
            int i2 = VERSION.SDK_INT;
            if (19 <= i2 && i2 <= 23) {
                getLifecycle().a(new ImmLeaksCleaner(this));
                return;
            }
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        a aVar = (a) getLastNonConfigurationInstance();
        if (aVar != null) {
            return aVar.f376a;
        }
        return null;
    }

    public h getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    public final androidx.savedstate.a getSavedStateRegistry() {
        return this.mSavedStateRegistryController.a();
    }

    public F getViewModelStore() {
        if (getApplication() != null) {
            if (this.mViewModelStore == null) {
                a aVar = (a) getLastNonConfigurationInstance();
                if (aVar != null) {
                    this.mViewModelStore = aVar.f377b;
                }
                if (this.mViewModelStore == null) {
                    this.mViewModelStore = new F();
                }
            }
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public void onBackPressed() {
        this.mOnBackPressedDispatcher.a();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSavedStateRegistryController.a(bundle);
        B.b((Activity) this);
        int i2 = this.mContentLayoutId;
        if (i2 != 0) {
            setContentView(i2);
        }
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public final Object onRetainNonConfigurationInstance() {
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        F f2 = this.mViewModelStore;
        if (f2 == null) {
            a aVar = (a) getLastNonConfigurationInstance();
            if (aVar != null) {
                f2 = aVar.f377b;
            }
        }
        if (f2 == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        a aVar2 = new a();
        aVar2.f376a = onRetainCustomNonConfigurationInstance;
        aVar2.f377b = f2;
        return aVar2;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        h lifecycle = getLifecycle();
        if (lifecycle instanceof n) {
            ((n) lifecycle).b(h.b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.b(bundle);
    }

    public c(int i2) {
        this();
        this.mContentLayoutId = i2;
    }
}
