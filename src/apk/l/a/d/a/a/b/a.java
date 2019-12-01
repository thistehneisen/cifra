package l.a.d.a.a.b;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Intent;
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
import androidx.fragment.app.Fragment;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import kotlin.TypeCastException;
import kotlin.e.b.h;
import ru.touchin.roboswag.components.navigation.viewcontrollers.c;

/* compiled from: ViewControllerFragment.kt */
public class a<TActivity extends C0195j, TState extends Parcelable> extends Fragment {

    /* renamed from: a reason: collision with root package name */
    public static final b f10403a = new b(null);

    /* renamed from: b reason: collision with root package name */
    private TState f10404b;

    /* renamed from: c reason: collision with root package name */
    private Class<c<TActivity, TState>> f10405c;

    /* renamed from: d reason: collision with root package name */
    private c<? extends TActivity, ? extends TState> f10406d;

    /* renamed from: e reason: collision with root package name */
    private C0121a f10407e;

    /* renamed from: f reason: collision with root package name */
    private boolean f10408f;

    /* renamed from: l.a.d.a.a.b.a$a reason: collision with other inner class name */
    /* compiled from: ViewControllerFragment.kt */
    private static final class C0121a {

        /* renamed from: a reason: collision with root package name */
        private final int f10409a;

        /* renamed from: b reason: collision with root package name */
        private final int f10410b;

        /* renamed from: c reason: collision with root package name */
        private final Intent f10411c;

        public C0121a(int i2, int i3, Intent intent) {
            this.f10409a = i2;
            this.f10410b = i3;
            this.f10411c = intent;
        }

        public final Intent a() {
            return this.f10411c;
        }

        public final int b() {
            return this.f10409a;
        }

        public final int c() {
            return this.f10410b;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof C0121a) {
                    C0121a aVar = (C0121a) obj;
                    if (this.f10409a == aVar.f10409a) {
                        if (!(this.f10410b == aVar.f10410b) || !h.a((Object) this.f10411c, (Object) aVar.f10411c)) {
                            return false;
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i2 = ((this.f10409a * 31) + this.f10410b) * 31;
            Intent intent = this.f10411c;
            return i2 + (intent != null ? intent.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ActivityResult(requestCode=");
            sb.append(this.f10409a);
            sb.append(", resultCode=");
            sb.append(this.f10410b);
            sb.append(", data=");
            sb.append(this.f10411c);
            sb.append(")");
            return sb.toString();
        }
    }

    /* compiled from: ViewControllerFragment.kt */
    public static final class b {
        private b() {
        }

        public final Bundle a(Class<? extends c<?, ?>> cls, Parcelable parcelable) {
            h.b(cls, "viewControllerClass");
            Bundle bundle = new Bundle();
            bundle.putSerializable("VIEW_CONTROLLER_CLASS_EXTRA", cls);
            bundle.putParcelable("VIEW_CONTROLLER_STATE_EXTRA", parcelable);
            return bundle;
        }

        public /* synthetic */ b(e eVar) {
            this();
        }
    }

    private final void b() {
        this.f10408f = true;
        c<? extends TActivity, ? extends TState> cVar = this.f10406d;
        if (cVar != null) {
            cVar.onAppear();
        }
    }

    private final void c() {
        this.f10408f = false;
        c<? extends TActivity, ? extends TState> cVar = this.f10406d;
        if (cVar != null) {
            cVar.onDisappear();
        }
    }

    public final TState a() {
        TState tstate = this.f10404b;
        if (tstate != null) {
            return tstate;
        }
        h.b("state");
        throw null;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        C0121a aVar = this.f10407e;
        c<? extends TActivity, ? extends TState> cVar = this.f10406d;
        if (cVar != null && aVar != null) {
            if (cVar != null) {
                cVar.onActivityResult(aVar.b(), aVar.c(), aVar.a());
            }
            this.f10407e = null;
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        c<? extends TActivity, ? extends TState> cVar = this.f10406d;
        if (cVar != null) {
            cVar.onActivityResult(i2, i3, intent);
        } else {
            this.f10407e = new C0121a(i2, i3, intent);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c  */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        Bundle arguments = getArguments();
        TState tstate = null;
        Serializable serializable = arguments != null ? arguments.getSerializable("VIEW_CONTROLLER_CLASS_EXTRA") : null;
        if (!(serializable instanceof Class)) {
            serializable = null;
        }
        Class<c<TActivity, TState>> cls = (Class) serializable;
        if (cls != null) {
            this.f10405c = cls;
            String str = "VIEW_CONTROLLER_STATE_EXTRA";
            if (bundle != null) {
                TState parcelable = bundle.getParcelable(str);
                if (parcelable != null) {
                    tstate = parcelable;
                    if (tstate == null) {
                        this.f10404b = tstate;
                        return;
                    }
                    throw new IllegalStateException("State is required and null");
                }
            }
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                tstate = arguments2.getParcelable(str);
            }
            if (tstate == null) {
            }
        } else {
            throw new IllegalArgumentException("View controller class must be not-null");
        }
    }

    public Animation onCreateAnimation(int i2, boolean z, int i3) {
        c<? extends TActivity, ? extends TState> cVar = this.f10406d;
        if (cVar != null) {
            return cVar.onCreateAnimation(i2, z, i3);
        }
        return null;
    }

    public Animator onCreateAnimator(int i2, boolean z, int i3) {
        c<? extends TActivity, ? extends TState> cVar = this.f10406d;
        if (cVar != null) {
            return cVar.onCreateAnimator(i2, z, i3);
        }
        return null;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        h.b(menu, "menu");
        h.b(menuInflater, "inflater");
        c<? extends TActivity, ? extends TState> cVar = this.f10406d;
        if (cVar != null) {
            cVar.onCreateOptionsMenu(menu, menuInflater);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.b(layoutInflater, "inflater");
        C0195j requireActivity = requireActivity();
        h.a((Object) requireActivity, "requireActivity()");
        c<? extends TActivity, ? extends TState> a2 = a(new ru.touchin.roboswag.components.navigation.viewcontrollers.c.a(requireActivity, this, layoutInflater, viewGroup), bundle);
        this.f10406d = a2;
        a2.onCreate();
        return a2.getView();
    }

    public void onDestroyView() {
        c<? extends TActivity, ? extends TState> cVar = this.f10406d;
        if (cVar != null) {
            cVar.onDestroy();
        }
        this.f10406d = null;
        super.onDestroyView();
    }

    public void onLowMemory() {
        super.onLowMemory();
        c<? extends TActivity, ? extends TState> cVar = this.f10406d;
        if (cVar != null) {
            cVar.onLowMemory();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        h.b(menuItem, "item");
        c<? extends TActivity, ? extends TState> cVar = this.f10406d;
        return (cVar != null && cVar.onOptionsItemSelected(menuItem)) || super.onOptionsItemSelected(menuItem);
    }

    public void onPause() {
        super.onPause();
        c<? extends TActivity, ? extends TState> cVar = this.f10406d;
        if (cVar != null) {
            cVar.onPause();
        }
    }

    public void onPrepareOptionsMenu(Menu menu) {
        h.b(menu, "menu");
        c<? extends TActivity, ? extends TState> cVar = this.f10406d;
        if (cVar != null) {
            cVar.onPrepareOptionsMenu(menu);
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        h.b(strArr, "permissions");
        h.b(iArr, "grantResults");
        c<? extends TActivity, ? extends TState> cVar = this.f10406d;
        if (cVar != null) {
            cVar.onRequestPermissionsResult(i2, strArr, iArr);
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public void onResume() {
        super.onResume();
        c<? extends TActivity, ? extends TState> cVar = this.f10406d;
        if (cVar != null) {
            cVar.onResume();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        h.b(bundle, "savedInstanceState");
        super.onSaveInstanceState(bundle);
        c<? extends TActivity, ? extends TState> cVar = this.f10406d;
        if (cVar != null) {
            cVar.onSaveInstanceState(bundle);
        }
        TState tstate = this.f10404b;
        if (tstate != null) {
            bundle.putParcelable("VIEW_CONTROLLER_STATE_EXTRA", tstate);
        } else {
            h.b("state");
            throw null;
        }
    }

    @SuppressLint({"RestrictedApi"})
    public void onStart() {
        super.onStart();
        if (!this.f10408f && isMenuVisible()) {
            b();
        }
        c<? extends TActivity, ? extends TState> cVar = this.f10406d;
        if (cVar != null) {
            cVar.onStart();
        }
    }

    public void onStop() {
        if (this.f10408f) {
            c();
        }
        c<? extends TActivity, ? extends TState> cVar = this.f10406d;
        if (cVar != null) {
            cVar.onStop();
        }
        super.onStop();
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        c<? extends TActivity, ? extends TState> cVar = this.f10406d;
        if (cVar != null) {
            cVar.onViewStateRestored(bundle);
        }
    }

    public void setMenuVisibility(boolean z) {
        super.setMenuVisibility(z);
        if (getActivity() != null && getView() != null) {
            androidx.lifecycle.h lifecycle = getLifecycle();
            h.a((Object) lifecycle, "lifecycle");
            boolean a2 = lifecycle.a().a(androidx.lifecycle.h.b.STARTED);
            if (!this.f10408f && z && a2) {
                b();
            }
            if (!this.f10408f) {
                return;
            }
            if (!z || !a2) {
                c();
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" ViewController: ");
        Class<c<TActivity, TState>> cls = this.f10405c;
        if (cls != null) {
            sb.append(cls);
            return sb.toString();
        }
        h.b("viewControllerClass");
        throw null;
    }

    private final c<? extends TActivity, ? extends TState> a(ru.touchin.roboswag.components.navigation.viewcontrollers.c.a aVar, Bundle bundle) {
        Object obj;
        Class<c<TActivity, TState>> cls = this.f10405c;
        String str = "viewControllerClass";
        if (cls == null) {
            h.b(str);
            throw null;
        } else if (cls.getConstructors().length != 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("There should be single constructor for ");
            Class<c<TActivity, TState>> cls2 = this.f10405c;
            if (cls2 == null) {
                h.b(str);
                throw null;
            }
            sb.append(cls2);
            throw new IllegalStateException(sb.toString());
        } else {
            Class<c<TActivity, TState>> cls3 = this.f10405c;
            if (cls3 != null) {
                Constructor constructor = cls3.getConstructors()[0];
                h.a((Object) constructor, "constructor");
                int length = constructor.getParameterTypes().length;
                if (length == 1) {
                    obj = constructor.newInstance(new Object[]{aVar});
                } else if (length == 2) {
                    obj = constructor.newInstance(new Object[]{aVar, bundle});
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Wrong constructor parameters count: ");
                    sb2.append(constructor.getParameterTypes().length);
                    throw new IllegalArgumentException(sb2.toString());
                }
                if (obj != null) {
                    return (c) obj;
                }
                throw new TypeCastException("null cannot be cast to non-null type ru.touchin.roboswag.components.navigation.viewcontrollers.ViewController<out TActivity, out TState>");
            }
            h.b(str);
            throw null;
        }
    }
}
