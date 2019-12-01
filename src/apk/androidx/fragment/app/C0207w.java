package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.F;
import androidx.lifecycle.G;
import b.g.i.s;
import io.intercom.android.sdk.views.holder.AttributeType;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: androidx.fragment.app.w reason: case insensitive filesystem */
/* compiled from: FragmentManagerImpl */
final class C0207w extends C0200o implements Factory2 {

    /* renamed from: c reason: collision with root package name */
    static boolean f1561c = false;

    /* renamed from: d reason: collision with root package name */
    static final Interpolator f1562d = new DecelerateInterpolator(2.5f);

    /* renamed from: e reason: collision with root package name */
    static final Interpolator f1563e = new DecelerateInterpolator(1.5f);
    boolean A;
    boolean B;
    ArrayList<C0186a> C;
    ArrayList<Boolean> D;
    ArrayList<Fragment> E;
    Bundle F = null;
    SparseArray<Parcelable> G = null;
    ArrayList<g> H;
    private A I;
    Runnable J = new C0202q(this);

    /* renamed from: f reason: collision with root package name */
    ArrayList<e> f1564f;

    /* renamed from: g reason: collision with root package name */
    boolean f1565g;

    /* renamed from: h reason: collision with root package name */
    int f1566h = 0;

    /* renamed from: i reason: collision with root package name */
    final ArrayList<Fragment> f1567i = new ArrayList<>();

    /* renamed from: j reason: collision with root package name */
    final HashMap<String, Fragment> f1568j = new HashMap<>();

    /* renamed from: k reason: collision with root package name */
    ArrayList<C0186a> f1569k;

    /* renamed from: l reason: collision with root package name */
    ArrayList<Fragment> f1570l;
    private OnBackPressedDispatcher m;
    private final androidx.activity.d n = new C0201p(this, false);
    ArrayList<C0186a> o;
    ArrayList<Integer> p;
    ArrayList<androidx.fragment.app.C0200o.c> q;
    private final CopyOnWriteArrayList<c> r = new CopyOnWriteArrayList<>();
    int s = 0;
    C0199n t;
    C0196k u;
    Fragment v;
    Fragment w;
    boolean x;
    boolean y;
    boolean z;

    /* renamed from: androidx.fragment.app.w$a */
    /* compiled from: FragmentManagerImpl */
    private static class a {

        /* renamed from: a reason: collision with root package name */
        public final Animation f1571a;

        /* renamed from: b reason: collision with root package name */
        public final Animator f1572b;

        a(Animation animation) {
            this.f1571a = animation;
            this.f1572b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        a(Animator animator) {
            this.f1571a = null;
            this.f1572b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* renamed from: androidx.fragment.app.w$b */
    /* compiled from: FragmentManagerImpl */
    private static class b extends AnimationSet implements Runnable {

        /* renamed from: a reason: collision with root package name */
        private final ViewGroup f1573a;

        /* renamed from: b reason: collision with root package name */
        private final View f1574b;

        /* renamed from: c reason: collision with root package name */
        private boolean f1575c;

        /* renamed from: d reason: collision with root package name */
        private boolean f1576d;

        /* renamed from: e reason: collision with root package name */
        private boolean f1577e = true;

        b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f1573a = viewGroup;
            this.f1574b = view;
            addAnimation(animation);
            this.f1573a.post(this);
        }

        public boolean getTransformation(long j2, Transformation transformation) {
            this.f1577e = true;
            if (this.f1575c) {
                return !this.f1576d;
            }
            if (!super.getTransformation(j2, transformation)) {
                this.f1575c = true;
                s.a(this.f1573a, this);
            }
            return true;
        }

        public void run() {
            if (this.f1575c || !this.f1577e) {
                this.f1573a.endViewTransition(this.f1574b);
                this.f1576d = true;
                return;
            }
            this.f1577e = false;
            this.f1573a.post(this);
        }

        public boolean getTransformation(long j2, Transformation transformation, float f2) {
            this.f1577e = true;
            if (this.f1575c) {
                return !this.f1576d;
            }
            if (!super.getTransformation(j2, transformation, f2)) {
                this.f1575c = true;
                s.a(this.f1573a, this);
            }
            return true;
        }
    }

    /* renamed from: androidx.fragment.app.w$c */
    /* compiled from: FragmentManagerImpl */
    private static final class c {

        /* renamed from: a reason: collision with root package name */
        final androidx.fragment.app.C0200o.b f1578a;

        /* renamed from: b reason: collision with root package name */
        final boolean f1579b;

        c(androidx.fragment.app.C0200o.b bVar, boolean z) {
            this.f1578a = bVar;
            this.f1579b = z;
        }
    }

    /* renamed from: androidx.fragment.app.w$d */
    /* compiled from: FragmentManagerImpl */
    static class d {

        /* renamed from: a reason: collision with root package name */
        public static final int[] f1580a = {16842755, 16842960, 16842961};
    }

    /* renamed from: androidx.fragment.app.w$e */
    /* compiled from: FragmentManagerImpl */
    interface e {
        boolean a(ArrayList<C0186a> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* renamed from: androidx.fragment.app.w$f */
    /* compiled from: FragmentManagerImpl */
    private class f implements e {

        /* renamed from: a reason: collision with root package name */
        final String f1581a;

        /* renamed from: b reason: collision with root package name */
        final int f1582b;

        /* renamed from: c reason: collision with root package name */
        final int f1583c;

        f(String str, int i2, int i3) {
            this.f1581a = str;
            this.f1582b = i2;
            this.f1583c = i3;
        }

        public boolean a(ArrayList<C0186a> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = C0207w.this.w;
            if (fragment != null && this.f1582b < 0 && this.f1581a == null && fragment.getChildFragmentManager().h()) {
                return false;
            }
            return C0207w.this.a(arrayList, arrayList2, this.f1581a, this.f1582b, this.f1583c);
        }
    }

    /* renamed from: androidx.fragment.app.w$g */
    /* compiled from: FragmentManagerImpl */
    static class g implements b {

        /* renamed from: a reason: collision with root package name */
        final boolean f1585a;

        /* renamed from: b reason: collision with root package name */
        final C0186a f1586b;

        /* renamed from: c reason: collision with root package name */
        private int f1587c;

        g(C0186a aVar, boolean z) {
            this.f1585a = z;
            this.f1586b = aVar;
        }

        public void a() {
            this.f1587c++;
        }

        public void b() {
            this.f1587c--;
            if (this.f1587c == 0) {
                this.f1586b.s.B();
            }
        }

        public void c() {
            C0186a aVar = this.f1586b;
            aVar.s.a(aVar, this.f1585a, false, false);
        }

        public void d() {
            boolean z = this.f1587c > 0;
            C0207w wVar = this.f1586b.s;
            int size = wVar.f1567i.size();
            for (int i2 = 0; i2 < size; i2++) {
                Fragment fragment = (Fragment) wVar.f1567i.get(i2);
                fragment.setOnStartEnterTransitionListener(null);
                if (z && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            C0186a aVar = this.f1586b;
            aVar.s.a(aVar, this.f1585a, !z, true);
        }

        public boolean e() {
            return this.f1587c == 0;
        }
    }

    C0207w() {
    }

    private void D() {
        this.f1568j.values().removeAll(Collections.singleton(null));
    }

    private void E() {
        if (x()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private void F() {
        this.f1565g = false;
        this.D.clear();
        this.C.clear();
    }

    private void G() {
        for (Fragment fragment : this.f1568j.values()) {
            if (fragment != null) {
                if (fragment.getAnimatingAway() != null) {
                    int stateAfterAnimating = fragment.getStateAfterAnimating();
                    View animatingAway = fragment.getAnimatingAway();
                    Animation animation = animatingAway.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        animatingAway.clearAnimation();
                    }
                    fragment.setAnimatingAway(null);
                    a(fragment, stateAfterAnimating, 0, 0, false);
                } else if (fragment.getAnimator() != null) {
                    fragment.getAnimator().end();
                }
            }
        }
    }

    private void H() {
        if (this.H != null) {
            while (!this.H.isEmpty()) {
                ((g) this.H.remove(0)).d();
            }
        }
    }

    private void I() {
        ArrayList<e> arrayList = this.f1564f;
        boolean z2 = true;
        if (arrayList == null || arrayList.isEmpty()) {
            androidx.activity.d dVar = this.n;
            if (b() <= 0 || !j(this.v)) {
                z2 = false;
            }
            dVar.a(z2);
            return;
        }
        this.n.a(true);
    }

    private void a(RuntimeException runtimeException) {
        String str = "FragmentManager";
        Log.e(str, runtimeException.getMessage());
        Log.e(str, "Activity state:");
        PrintWriter printWriter = new PrintWriter(new b.g.h.b(str));
        C0199n nVar = this.t;
        String str2 = "Failed dumping state";
        String str3 = "  ";
        if (nVar != null) {
            try {
                nVar.a(str3, (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e2) {
                Log.e(str, str2, e2);
            }
        } else {
            try {
                a(str3, (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e3) {
                Log.e(str, str2, e3);
            }
        }
        throw runtimeException;
    }

    public static int b(int i2, boolean z2) {
        if (i2 == 4097) {
            return z2 ? 1 : 2;
        }
        if (i2 == 4099) {
            return z2 ? 5 : 6;
        }
        if (i2 != 8194) {
            return -1;
        }
        return z2 ? 3 : 4;
    }

    public static int e(int i2) {
        if (i2 == 4097) {
            return 8194;
        }
        if (i2 != 4099) {
            return i2 != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    private void v(Fragment fragment) {
        if (fragment != null && this.f1568j.get(fragment.mWho) == fragment) {
            fragment.performPrimaryNavigationFragmentChanged();
        }
    }

    /* access modifiers changed from: 0000 */
    public Parcelable A() {
        ArrayList<String> arrayList;
        H();
        G();
        u();
        this.y = true;
        C0188c[] cVarArr = null;
        if (this.f1568j.isEmpty()) {
            return null;
        }
        ArrayList<D> arrayList2 = new ArrayList<>(this.f1568j.size());
        Iterator it = this.f1568j.values().iterator();
        boolean z2 = false;
        while (true) {
            String str = ": ";
            String str2 = " was removed from the FragmentManager";
            String str3 = "Failure saving state: active ";
            String str4 = "FragmentManager";
            if (it.hasNext()) {
                Fragment fragment = (Fragment) it.next();
                if (fragment != null) {
                    if (fragment.mFragmentManager == this) {
                        D d2 = new D(fragment);
                        arrayList2.add(d2);
                        if (fragment.mState <= 0 || d2.m != null) {
                            d2.m = fragment.mSavedFragmentState;
                        } else {
                            d2.m = r(fragment);
                            String str5 = fragment.mTargetWho;
                            if (str5 != null) {
                                Fragment fragment2 = (Fragment) this.f1568j.get(str5);
                                if (fragment2 != null) {
                                    if (d2.m == null) {
                                        d2.m = new Bundle();
                                    }
                                    a(d2.m, "android:target_state", fragment2);
                                    int i2 = fragment.mTargetRequestCode;
                                    if (i2 != 0) {
                                        d2.m.putInt("android:target_req_state", i2);
                                    }
                                } else {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("Failure saving state: ");
                                    sb.append(fragment);
                                    sb.append(" has target not in fragment manager: ");
                                    sb.append(fragment.mTargetWho);
                                    a((RuntimeException) new IllegalStateException(sb.toString()));
                                    throw null;
                                }
                            }
                        }
                        if (f1561c) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Saved state of ");
                            sb2.append(fragment);
                            sb2.append(str);
                            sb2.append(d2.m);
                            Log.v(str4, sb2.toString());
                        }
                        z2 = true;
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str3);
                        sb3.append(fragment);
                        sb3.append(str2);
                        a((RuntimeException) new IllegalStateException(sb3.toString()));
                        throw null;
                    }
                }
            } else if (!z2) {
                if (f1561c) {
                    Log.v(str4, "saveAllState: no fragments!");
                }
                return null;
            } else {
                int size = this.f1567i.size();
                if (size > 0) {
                    arrayList = new ArrayList<>(size);
                    Iterator it2 = this.f1567i.iterator();
                    while (it2.hasNext()) {
                        Fragment fragment3 = (Fragment) it2.next();
                        arrayList.add(fragment3.mWho);
                        if (fragment3.mFragmentManager != this) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(str3);
                            sb4.append(fragment3);
                            sb4.append(str2);
                            a((RuntimeException) new IllegalStateException(sb4.toString()));
                            throw null;
                        } else if (f1561c) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("saveAllState: adding fragment (");
                            sb5.append(fragment3.mWho);
                            sb5.append("): ");
                            sb5.append(fragment3);
                            Log.v(str4, sb5.toString());
                        }
                    }
                } else {
                    arrayList = null;
                }
                ArrayList<C0186a> arrayList3 = this.f1569k;
                if (arrayList3 != null) {
                    int size2 = arrayList3.size();
                    if (size2 > 0) {
                        cVarArr = new C0188c[size2];
                        for (int i3 = 0; i3 < size2; i3++) {
                            cVarArr[i3] = new C0188c((C0186a) this.f1569k.get(i3));
                            if (f1561c) {
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append("saveAllState: adding back stack #");
                                sb6.append(i3);
                                sb6.append(str);
                                sb6.append(this.f1569k.get(i3));
                                Log.v(str4, sb6.toString());
                            }
                        }
                    }
                }
                y yVar = new y();
                yVar.f1588a = arrayList2;
                yVar.f1589b = arrayList;
                yVar.f1590c = cVarArr;
                Fragment fragment4 = this.w;
                if (fragment4 != null) {
                    yVar.f1591d = fragment4.mWho;
                }
                yVar.f1592e = this.f1566h;
                return yVar;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void B() {
        synchronized (this) {
            boolean z2 = false;
            boolean z3 = this.H != null && !this.H.isEmpty();
            if (this.f1564f != null && this.f1564f.size() == 1) {
                z2 = true;
            }
            if (z3 || z2) {
                this.t.d().removeCallbacks(this.J);
                this.t.d().post(this.J);
                I();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void C() {
        for (Fragment fragment : this.f1568j.values()) {
            if (fragment != null) {
                o(fragment);
            }
        }
    }

    public int b() {
        ArrayList<C0186a> arrayList = this.f1569k;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public void c(Fragment fragment) {
        if (f1561c) {
            StringBuilder sb = new StringBuilder();
            sb.append("attach: ");
            sb.append(fragment);
            Log.v("FragmentManager", sb.toString());
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            if (!this.f1567i.contains(fragment)) {
                if (f1561c) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("add from attach: ");
                    sb2.append(fragment);
                    Log.v("FragmentManager", sb2.toString());
                }
                synchronized (this.f1567i) {
                    this.f1567i.add(fragment);
                }
                fragment.mAdded = true;
                if (x(fragment)) {
                    this.x = true;
                    return;
                }
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Fragment already added: ");
            sb3.append(fragment);
            throw new IllegalStateException(sb3.toString());
        }
    }

    public List<Fragment> d() {
        List<Fragment> list;
        if (this.f1567i.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f1567i) {
            list = (List) this.f1567i.clone();
        }
        return list;
    }

    public void e(Fragment fragment) {
        if (f1561c) {
            StringBuilder sb = new StringBuilder();
            sb.append("detach: ");
            sb.append(fragment);
            Log.v("FragmentManager", sb.toString());
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (f1561c) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("remove from detach: ");
                    sb2.append(fragment);
                    Log.v("FragmentManager", sb2.toString());
                }
                synchronized (this.f1567i) {
                    this.f1567i.remove(fragment);
                }
                if (x(fragment)) {
                    this.x = true;
                }
                fragment.mAdded = false;
            }
        }
    }

    public boolean f() {
        return this.A;
    }

    public void g() {
        a((e) new f(null, -1, 0), false);
    }

    public boolean h() {
        E();
        return a((String) null, -1, 0);
    }

    public void i(Fragment fragment) {
        if (f1561c) {
            StringBuilder sb = new StringBuilder();
            sb.append("hide: ");
            sb.append(fragment);
            Log.v("FragmentManager", sb.toString());
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean j(Fragment fragment) {
        boolean z2 = true;
        if (fragment == null) {
            return true;
        }
        C0207w wVar = fragment.mFragmentManager;
        if (fragment != wVar.e() || !j(wVar.v)) {
            z2 = false;
        }
        return z2;
    }

    /* access modifiers changed from: 0000 */
    public void k(Fragment fragment) {
        if (this.f1568j.get(fragment.mWho) == null) {
            this.f1568j.put(fragment.mWho, fragment);
            if (fragment.mRetainInstanceChangedWhileDetached) {
                if (fragment.mRetainInstance) {
                    b(fragment);
                } else {
                    q(fragment);
                }
                fragment.mRetainInstanceChangedWhileDetached = false;
            }
            if (f1561c) {
                StringBuilder sb = new StringBuilder();
                sb.append("Added fragment to active set ");
                sb.append(fragment);
                Log.v("FragmentManager", sb.toString());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void l(Fragment fragment) {
        if (this.f1568j.get(fragment.mWho) != null) {
            if (f1561c) {
                StringBuilder sb = new StringBuilder();
                sb.append("Removed fragment from active set ");
                sb.append(fragment);
                Log.v("FragmentManager", sb.toString());
            }
            for (Fragment fragment2 : this.f1568j.values()) {
                if (fragment2 != null && fragment.mWho.equals(fragment2.mTargetWho)) {
                    fragment2.mTarget = fragment;
                    fragment2.mTargetWho = null;
                }
            }
            this.f1568j.put(fragment.mWho, null);
            q(fragment);
            String str = fragment.mTargetWho;
            if (str != null) {
                fragment.mTarget = (Fragment) this.f1568j.get(str);
            }
            fragment.initState();
        }
    }

    /* access modifiers changed from: 0000 */
    public void m(Fragment fragment) {
        if (fragment != null) {
            if (!this.f1568j.containsKey(fragment.mWho)) {
                if (f1561c) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Ignoring moving ");
                    sb.append(fragment);
                    sb.append(" to state ");
                    sb.append(this.s);
                    sb.append("since it is not added to ");
                    sb.append(this);
                    Log.v("FragmentManager", sb.toString());
                }
                return;
            }
            int i2 = this.s;
            if (fragment.mRemoving) {
                if (fragment.isInBackStack()) {
                    i2 = Math.min(i2, 1);
                } else {
                    i2 = Math.min(i2, 0);
                }
            }
            a(fragment, i2, fragment.getNextTransition(), fragment.getNextTransitionStyle(), false);
            if (fragment.mView != null) {
                Fragment w2 = w(fragment);
                if (w2 != null) {
                    View view = w2.mView;
                    ViewGroup viewGroup = fragment.mContainer;
                    int indexOfChild = viewGroup.indexOfChild(view);
                    int indexOfChild2 = viewGroup.indexOfChild(fragment.mView);
                    if (indexOfChild2 < indexOfChild) {
                        viewGroup.removeViewAt(indexOfChild2);
                        viewGroup.addView(fragment.mView, indexOfChild);
                    }
                }
                if (fragment.mIsNewlyAdded && fragment.mContainer != null) {
                    float f2 = fragment.mPostponedAlpha;
                    if (f2 > 0.0f) {
                        fragment.mView.setAlpha(f2);
                    }
                    fragment.mPostponedAlpha = 0.0f;
                    fragment.mIsNewlyAdded = false;
                    a a2 = a(fragment, fragment.getNextTransition(), true, fragment.getNextTransitionStyle());
                    if (a2 != null) {
                        Animation animation = a2.f1571a;
                        if (animation != null) {
                            fragment.mView.startAnimation(animation);
                        } else {
                            a2.f1572b.setTarget(fragment.mView);
                            a2.f1572b.start();
                        }
                    }
                }
            }
            if (fragment.mHiddenChanged) {
                d(fragment);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void n(Fragment fragment) {
        a(fragment, this.s, 0, 0, false);
    }

    public void o(Fragment fragment) {
        if (fragment.mDeferStart) {
            if (this.f1565g) {
                this.B = true;
                return;
            }
            fragment.mDeferStart = false;
            a(fragment, this.s, 0, 0, false);
        }
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        Fragment fragment;
        AttributeSet attributeSet2 = attributeSet;
        String str2 = str;
        Fragment fragment2 = null;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet2.getAttributeValue(null, "class");
        Context context2 = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet2, d.f1580a);
        int i2 = 0;
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        String str3 = attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (str3 == null || !C0198m.b(context.getClassLoader(), str3)) {
            return null;
        }
        if (view != null) {
            i2 = view.getId();
        }
        if (i2 == -1 && resourceId == -1 && string == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(attributeSet.getPositionDescription());
            sb.append(": Must specify unique android:id, android:tag, or have a parent with an id for ");
            sb.append(str3);
            throw new IllegalArgumentException(sb.toString());
        }
        if (resourceId != -1) {
            fragment2 = a(resourceId);
        }
        if (fragment2 == null && string != null) {
            fragment2 = a(string);
        }
        if (fragment2 == null && i2 != -1) {
            fragment2 = a(i2);
        }
        if (f1561c) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onCreateView: id=0x");
            sb2.append(Integer.toHexString(resourceId));
            sb2.append(" fname=");
            sb2.append(str3);
            sb2.append(" existing=");
            sb2.append(fragment2);
            Log.v("FragmentManager", sb2.toString());
        }
        if (fragment2 == null) {
            Fragment a2 = c().a(context.getClassLoader(), str3);
            a2.mFromLayout = true;
            a2.mFragmentId = resourceId != 0 ? resourceId : i2;
            a2.mContainerId = i2;
            a2.mTag = string;
            a2.mInLayout = true;
            a2.mFragmentManager = this;
            C0199n nVar = this.t;
            a2.mHost = nVar;
            a2.onInflate(nVar.c(), attributeSet2, a2.mSavedFragmentState);
            a(a2, true);
            fragment = a2;
        } else if (!fragment2.mInLayout) {
            fragment2.mInLayout = true;
            C0199n nVar2 = this.t;
            fragment2.mHost = nVar2;
            fragment2.onInflate(nVar2.c(), attributeSet2, fragment2.mSavedFragmentState);
            fragment = fragment2;
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(attributeSet.getPositionDescription());
            sb3.append(": Duplicate id 0x");
            sb3.append(Integer.toHexString(resourceId));
            sb3.append(", tag ");
            sb3.append(string);
            sb3.append(", or parent id 0x");
            sb3.append(Integer.toHexString(i2));
            sb3.append(" with another fragment for ");
            sb3.append(str3);
            throw new IllegalArgumentException(sb3.toString());
        }
        if (this.s >= 1 || !fragment.mFromLayout) {
            n(fragment);
        } else {
            a(fragment, 1, 0, 0, false);
        }
        View view2 = fragment.mView;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (fragment.mView.getTag() == null) {
                fragment.mView.setTag(string);
            }
            return fragment.mView;
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Fragment ");
        sb4.append(str3);
        sb4.append(" did not create a view.");
        throw new IllegalStateException(sb4.toString());
    }

    public void p(Fragment fragment) {
        if (f1561c) {
            StringBuilder sb = new StringBuilder();
            sb.append("remove: ");
            sb.append(fragment);
            sb.append(" nesting=");
            sb.append(fragment.mBackStackNesting);
            Log.v("FragmentManager", sb.toString());
        }
        boolean z2 = !fragment.isInBackStack();
        if (!fragment.mDetached || z2) {
            synchronized (this.f1567i) {
                this.f1567i.remove(fragment);
            }
            if (x(fragment)) {
                this.x = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
        }
    }

    /* access modifiers changed from: 0000 */
    public void q(Fragment fragment) {
        String str = "FragmentManager";
        if (x()) {
            if (f1561c) {
                Log.v(str, "Ignoring removeRetainedFragment as the state is already saved");
            }
            return;
        }
        if (this.I.e(fragment) && f1561c) {
            StringBuilder sb = new StringBuilder();
            sb.append("Updating retained Fragments: Removed ");
            sb.append(fragment);
            Log.v(str, sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public Bundle r(Fragment fragment) {
        Bundle bundle;
        if (this.F == null) {
            this.F = new Bundle();
        }
        fragment.performSaveInstanceState(this.F);
        d(fragment, this.F, false);
        if (!this.F.isEmpty()) {
            bundle = this.F;
            this.F = null;
        } else {
            bundle = null;
        }
        if (fragment.mView != null) {
            s(fragment);
        }
        if (fragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
        }
        if (!fragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
        }
        return bundle;
    }

    /* access modifiers changed from: 0000 */
    public void s(Fragment fragment) {
        if (fragment.mInnerView != null) {
            SparseArray<Parcelable> sparseArray = this.G;
            if (sparseArray == null) {
                this.G = new SparseArray<>();
            } else {
                sparseArray.clear();
            }
            fragment.mInnerView.saveHierarchyState(this.G);
            if (this.G.size() > 0) {
                fragment.mSavedViewState = this.G;
                this.G = null;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void t() {
        if (this.B) {
            this.B = false;
            C();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.v;
        if (fragment != null) {
            b.g.h.a.a(fragment, sb);
        } else {
            b.g.h.a.a(this.t, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    public void u(Fragment fragment) {
        if (f1561c) {
            StringBuilder sb = new StringBuilder();
            sb.append("show: ");
            sb.append(fragment);
            Log.v("FragmentManager", sb.toString());
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    /* access modifiers changed from: 0000 */
    public Factory2 v() {
        return this;
    }

    /* access modifiers changed from: 0000 */
    public void w() {
        u();
        if (this.n.b()) {
            h();
        } else {
            this.m.a();
        }
    }

    public boolean x() {
        return this.y || this.z;
    }

    public void y() {
        this.y = false;
        this.z = false;
        int size = this.f1567i.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = (Fragment) this.f1567i.get(i2);
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void z() {
        if (this.q != null) {
            for (int i2 = 0; i2 < this.q.size(); i2++) {
                ((androidx.fragment.app.C0200o.c) this.q.get(i2)).onBackStackChanged();
            }
        }
    }

    private boolean x(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.i();
    }

    public androidx.fragment.app.C0200o.a b(int i2) {
        return (androidx.fragment.app.C0200o.a) this.f1569k.get(i2);
    }

    /* access modifiers changed from: 0000 */
    public void f(Fragment fragment) {
        if (fragment.mFromLayout && !fragment.mPerformedCreateView) {
            fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), null, fragment.mSavedFragmentState);
            View view = fragment.mView;
            if (view != null) {
                fragment.mInnerView = view;
                view.setSaveFromParentEnabled(false);
                if (fragment.mHidden) {
                    fragment.mView.setVisibility(8);
                }
                fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
                a(fragment, fragment.mView, fragment.mSavedFragmentState, false);
                return;
            }
            fragment.mInnerView = null;
        }
    }

    /* access modifiers changed from: 0000 */
    public A g(Fragment fragment) {
        return this.I.c(fragment);
    }

    public void n() {
        for (int i2 = 0; i2 < this.f1567i.size(); i2++) {
            Fragment fragment = (Fragment) this.f1567i.get(i2);
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void b(Fragment fragment) {
        String str = "FragmentManager";
        if (x()) {
            if (f1561c) {
                Log.v(str, "Ignoring addRetainedFragment as the state is already saved");
            }
            return;
        }
        if (this.I.a(fragment) && f1561c) {
            StringBuilder sb = new StringBuilder();
            sb.append("Updating retained Fragments: Added ");
            sb.append(fragment);
            Log.v(str, sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public void g(Fragment fragment, boolean z2) {
        Fragment fragment2 = this.v;
        if (fragment2 != null) {
            C0200o fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof C0207w) {
                ((C0207w) fragmentManager).g(fragment, true);
            }
        }
        Iterator it = this.r.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (!z2 || cVar.f1579b) {
                cVar.f1578a.f(this, fragment);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public F h(Fragment fragment) {
        return this.I.d(fragment);
    }

    /* access modifiers changed from: 0000 */
    public void h(Fragment fragment, boolean z2) {
        Fragment fragment2 = this.v;
        if (fragment2 != null) {
            C0200o fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof C0207w) {
                ((C0207w) fragmentManager).h(fragment, true);
            }
        }
        Iterator it = this.r.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (!z2 || cVar.f1579b) {
                cVar.f1578a.g(this, fragment);
            }
        }
    }

    public void t(Fragment fragment) {
        if (fragment == null || (this.f1568j.get(fragment.mWho) == fragment && (fragment.mHost == null || fragment.getFragmentManager() == this))) {
            Fragment fragment2 = this.w;
            this.w = fragment;
            v(fragment2);
            v(this.w);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(fragment);
        sb.append(" is not an active fragment of FragmentManager ");
        sb.append(this);
        throw new IllegalArgumentException(sb.toString());
    }

    private Fragment w(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        View view = fragment.mView;
        if (!(viewGroup == null || view == null)) {
            for (int indexOf = this.f1567i.indexOf(fragment) - 1; indexOf >= 0; indexOf--) {
                Fragment fragment2 = (Fragment) this.f1567i.get(indexOf);
                if (fragment2.mContainer == viewGroup && fragment2.mView != null) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public boolean i() {
        boolean z2 = false;
        for (Fragment fragment : this.f1568j.values()) {
            if (fragment != null) {
                z2 = x(fragment);
                continue;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public void j() {
        this.y = false;
        this.z = false;
        f(2);
    }

    /* JADX INFO: finally extract failed */
    public boolean u() {
        c(true);
        boolean z2 = false;
        while (b(this.C, this.D)) {
            this.f1565g = true;
            try {
                c(this.C, this.D);
                F();
                z2 = true;
            } catch (Throwable th) {
                F();
                throw th;
            }
        }
        I();
        t();
        D();
        return z2;
    }

    /* access modifiers changed from: 0000 */
    public boolean d(int i2) {
        return this.s >= i2;
    }

    public void o() {
        f(3);
    }

    /* access modifiers changed from: 0000 */
    public void d(Fragment fragment) {
        if (fragment.mView != null) {
            a a2 = a(fragment, fragment.getNextTransition(), !fragment.mHidden, fragment.getNextTransitionStyle());
            if (a2 != null) {
                Animator animator = a2.f1572b;
                if (animator != null) {
                    animator.setTarget(fragment.mView);
                    if (!fragment.mHidden) {
                        fragment.mView.setVisibility(0);
                    } else if (fragment.isHideReplaced()) {
                        fragment.setHideReplaced(false);
                    } else {
                        ViewGroup viewGroup = fragment.mContainer;
                        View view = fragment.mView;
                        viewGroup.startViewTransition(view);
                        a2.f1572b.addListener(new C0205u(this, viewGroup, view, fragment));
                    }
                    a2.f1572b.start();
                }
            }
            if (a2 != null) {
                fragment.mView.startAnimation(a2.f1571a);
                a2.f1571a.start();
            }
            fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
            if (fragment.isHideReplaced()) {
                fragment.setHideReplaced(false);
            }
        }
        if (fragment.mAdded && x(fragment)) {
            this.x = true;
        }
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    public void q() {
        this.y = false;
        this.z = false;
        f(4);
    }

    public Fragment b(String str) {
        for (Fragment fragment : this.f1568j.values()) {
            if (fragment != null) {
                Fragment findFragmentByWho = fragment.findFragmentByWho(str);
                if (findFragmentByWho != null) {
                    return findFragmentByWho;
                }
            }
        }
        return null;
    }

    public void k() {
        this.y = false;
        this.z = false;
        f(1);
    }

    public void s() {
        this.z = true;
        f(2);
    }

    /* JADX INFO: finally extract failed */
    private void f(int i2) {
        try {
            this.f1565g = true;
            a(i2, false);
            this.f1565g = false;
            u();
        } catch (Throwable th) {
            this.f1565g = false;
            throw th;
        }
    }

    public F a() {
        return new C0186a(this);
    }

    public int b(C0186a aVar) {
        synchronized (this) {
            if (this.p != null) {
                if (this.p.size() > 0) {
                    int intValue = ((Integer) this.p.remove(this.p.size() - 1)).intValue();
                    if (f1561c) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Adding back stack index ");
                        sb.append(intValue);
                        sb.append(" with ");
                        sb.append(aVar);
                        Log.v("FragmentManager", sb.toString());
                    }
                    this.o.set(intValue, aVar);
                    return intValue;
                }
            }
            if (this.o == null) {
                this.o = new ArrayList<>();
            }
            int size = this.o.size();
            if (f1561c) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Setting back stack index ");
                sb2.append(size);
                sb2.append(" to ");
                sb2.append(aVar);
                Log.v("FragmentManager", sb2.toString());
            }
            this.o.add(aVar);
            return size;
        }
    }

    public void a(String str, int i2) {
        a((e) new f(str, -1, i2), false);
    }

    public void l() {
        this.A = true;
        u();
        f(0);
        this.t = null;
        this.u = null;
        this.v = null;
        if (this.m != null) {
            this.n.c();
            this.m = null;
        }
    }

    /* access modifiers changed from: 0000 */
    public void p() {
        I();
        v(this.w);
    }

    public void a(int i2, int i3) {
        if (i2 >= 0) {
            a((e) new f(null, i2, i3), false);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Bad id: ");
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }

    public Fragment e() {
        return this.w;
    }

    /* access modifiers changed from: 0000 */
    public void e(Fragment fragment, boolean z2) {
        Fragment fragment2 = this.v;
        if (fragment2 != null) {
            C0200o fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof C0207w) {
                ((C0207w) fragmentManager).e(fragment, true);
            }
        }
        Iterator it = this.r.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (!z2 || cVar.f1579b) {
                cVar.f1578a.d(this, fragment);
            }
        }
    }

    private boolean a(String str, int i2, int i3) {
        u();
        c(true);
        Fragment fragment = this.w;
        if (fragment != null && i2 < 0 && str == null && fragment.getChildFragmentManager().h()) {
            return true;
        }
        boolean a2 = a(this.C, this.D, str, i2, i3);
        if (a2) {
            this.f1565g = true;
            try {
                c(this.C, this.D);
            } finally {
                F();
            }
        }
        I();
        t();
        D();
        return a2;
    }

    public void c(int i2) {
        synchronized (this) {
            this.o.set(i2, null);
            if (this.p == null) {
                this.p = new ArrayList<>();
            }
            if (f1561c) {
                StringBuilder sb = new StringBuilder();
                sb.append("Freeing back stack index ");
                sb.append(i2);
                Log.v("FragmentManager", sb.toString());
            }
            this.p.add(Integer.valueOf(i2));
        }
    }

    public void r() {
        this.y = false;
        this.z = false;
        f(3);
    }

    /* access modifiers changed from: 0000 */
    public void f(Fragment fragment, boolean z2) {
        Fragment fragment2 = this.v;
        if (fragment2 != null) {
            C0200o fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof C0207w) {
                ((C0207w) fragmentManager).f(fragment, true);
            }
        }
        Iterator it = this.r.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (!z2 || cVar.f1579b) {
                cVar.f1578a.e(this, fragment);
            }
        }
    }

    private void c(boolean z2) {
        if (this.f1565g) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.t == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        } else if (Looper.myLooper() == this.t.d().getLooper()) {
            if (!z2) {
                E();
            }
            if (this.C == null) {
                this.C = new ArrayList<>();
                this.D = new ArrayList<>();
            }
            this.f1565g = true;
            try {
                a(null, null);
            } finally {
                this.f1565g = false;
            }
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    public void b(e eVar, boolean z2) {
        if (!z2 || (this.t != null && !this.A)) {
            c(z2);
            if (eVar.a(this.C, this.D)) {
                this.f1565g = true;
                try {
                    c(this.C, this.D);
                } finally {
                    F();
                }
            }
            I();
            t();
            D();
        }
    }

    public void a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager == this) {
            bundle.putString(str, fragment.mWho);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(fragment);
        sb.append(" is not currently in the FragmentManager");
        a((RuntimeException) new IllegalStateException(sb.toString()));
        throw null;
    }

    public Fragment a(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment fragment = (Fragment) this.f1568j.get(string);
        if (fragment != null) {
            return fragment;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment no longer exists for key ");
        sb.append(str);
        sb.append(": unique id ");
        sb.append(string);
        a((RuntimeException) new IllegalStateException(sb.toString()));
        throw null;
    }

    /* access modifiers changed from: 0000 */
    public void d(Fragment fragment, boolean z2) {
        Fragment fragment2 = this.v;
        if (fragment2 != null) {
            C0200o fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof C0207w) {
                ((C0207w) fragmentManager).d(fragment, true);
            }
        }
        Iterator it = this.r.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (!z2 || cVar.f1579b) {
                cVar.f1578a.c(this, fragment);
            }
        }
    }

    public void m() {
        f(1);
    }

    private void b(ArrayList<C0186a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        int i4;
        ArrayList<C0186a> arrayList3 = arrayList;
        ArrayList<Boolean> arrayList4 = arrayList2;
        int i5 = i2;
        int i6 = i3;
        boolean z2 = ((C0186a) arrayList3.get(i5)).q;
        ArrayList<Fragment> arrayList5 = this.E;
        if (arrayList5 == null) {
            this.E = new ArrayList<>();
        } else {
            arrayList5.clear();
        }
        this.E.addAll(this.f1567i);
        Fragment e2 = e();
        boolean z3 = false;
        for (int i7 = i5; i7 < i6; i7++) {
            C0186a aVar = (C0186a) arrayList3.get(i7);
            if (!((Boolean) arrayList4.get(i7)).booleanValue()) {
                e2 = aVar.a(this.E, e2);
            } else {
                e2 = aVar.b(this.E, e2);
            }
            z3 = z3 || aVar.f1418h;
        }
        this.E.clear();
        if (!z2) {
            K.a(this, arrayList, arrayList2, i2, i3, false);
        }
        a(arrayList, arrayList2, i2, i3);
        if (z2) {
            b.d.d dVar = new b.d.d();
            a(dVar);
            int a2 = a(arrayList, arrayList2, i2, i3, dVar);
            b(dVar);
            i4 = a2;
        } else {
            i4 = i6;
        }
        if (i4 != i5 && z2) {
            K.a(this, arrayList, arrayList2, i2, i4, true);
            a(this.s, true);
        }
        while (i5 < i6) {
            C0186a aVar2 = (C0186a) arrayList3.get(i5);
            if (((Boolean) arrayList4.get(i5)).booleanValue()) {
                int i8 = aVar2.u;
                if (i8 >= 0) {
                    c(i8);
                    aVar2.u = -1;
                }
            }
            aVar2.g();
            i5++;
        }
        if (z3) {
            z();
        }
    }

    public androidx.fragment.app.Fragment.c a(Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            StringBuilder sb = new StringBuilder();
            sb.append("Fragment ");
            sb.append(fragment);
            sb.append(" is not currently in the FragmentManager");
            a((RuntimeException) new IllegalStateException(sb.toString()));
            throw null;
        } else if (fragment.mState <= 0) {
            return null;
        } else {
            Bundle r2 = r(fragment);
            if (r2 != null) {
                return new androidx.fragment.app.Fragment.c(r2);
            }
            return null;
        }
    }

    private void c(ArrayList<C0186a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList != null && !arrayList.isEmpty()) {
            if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
                throw new IllegalStateException("Internal error with the back stack records");
            }
            a(arrayList, arrayList2);
            int size = arrayList.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                if (!((C0186a) arrayList.get(i2)).q) {
                    if (i3 != i2) {
                        b(arrayList, arrayList2, i3, i2);
                    }
                    i3 = i2 + 1;
                    if (((Boolean) arrayList2.get(i2)).booleanValue()) {
                        while (i3 < size && ((Boolean) arrayList2.get(i3)).booleanValue() && !((C0186a) arrayList.get(i3)).q) {
                            i3++;
                        }
                    }
                    b(arrayList, arrayList2, i2, i3);
                    i2 = i3 - 1;
                }
                i2++;
            }
            if (i3 != size) {
                b(arrayList, arrayList2, i3, size);
            }
        }
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("    ");
        String sb2 = sb.toString();
        if (!this.f1568j.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (Fragment fragment : this.f1568j.values()) {
                printWriter.print(str);
                printWriter.println(fragment);
                if (fragment != null) {
                    fragment.dump(sb2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size = this.f1567i.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size; i2++) {
                Fragment fragment2 = (Fragment) this.f1567i.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        ArrayList<Fragment> arrayList = this.f1570l;
        if (arrayList != null) {
            int size2 = arrayList.size();
            if (size2 > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (int i3 = 0; i3 < size2; i3++) {
                    Fragment fragment3 = (Fragment) this.f1570l.get(i3);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i3);
                    printWriter.print(": ");
                    printWriter.println(fragment3.toString());
                }
            }
        }
        ArrayList<C0186a> arrayList2 = this.f1569k;
        if (arrayList2 != null) {
            int size3 = arrayList2.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (int i4 = 0; i4 < size3; i4++) {
                    C0186a aVar = (C0186a) this.f1569k.get(i4);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println(aVar.toString());
                    aVar.a(sb2, printWriter);
                }
            }
        }
        synchronized (this) {
            if (this.o != null) {
                int size4 = this.o.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (int i5 = 0; i5 < size4; i5++) {
                        C0186a aVar2 = (C0186a) this.o.get(i5);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i5);
                        printWriter.print(": ");
                        printWriter.println(aVar2);
                    }
                }
            }
            if (this.p != null && this.p.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.p.toArray()));
            }
        }
        ArrayList<e> arrayList3 = this.f1564f;
        if (arrayList3 != null) {
            int size5 = arrayList3.size();
            if (size5 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i6 = 0; i6 < size5; i6++) {
                    e eVar = (e) this.f1564f.get(i6);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i6);
                    printWriter.print(": ");
                    printWriter.println(eVar);
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.t);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.u);
        if (this.v != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.v);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.s);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.y);
        printWriter.print(" mStopped=");
        printWriter.print(this.z);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.A);
        if (this.x) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.x);
        }
    }

    /* access modifiers changed from: 0000 */
    public void d(Fragment fragment, Bundle bundle, boolean z2) {
        Fragment fragment2 = this.v;
        if (fragment2 != null) {
            C0200o fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof C0207w) {
                ((C0207w) fragmentManager).d(fragment, bundle, true);
            }
        }
        Iterator it = this.r.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (!z2 || cVar.f1579b) {
                cVar.f1578a.d(this, fragment, bundle);
            }
        }
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public C0198m c() {
        if (super.c() == C0200o.f1544a) {
            Fragment fragment = this.v;
            if (fragment != null) {
                return fragment.mFragmentManager.c();
            }
            a((C0198m) new C0206v(this));
        }
        return super.c();
    }

    /* access modifiers changed from: 0000 */
    public void c(Fragment fragment, Bundle bundle, boolean z2) {
        Fragment fragment2 = this.v;
        if (fragment2 != null) {
            C0200o fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof C0207w) {
                ((C0207w) fragmentManager).c(fragment, bundle, true);
            }
        }
        Iterator it = this.r.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (!z2 || cVar.f1579b) {
                cVar.f1578a.c(this, fragment, bundle);
            }
        }
    }

    private void b(b.d.d<Fragment> dVar) {
        int size = dVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = (Fragment) dVar.g(i2);
            if (!fragment.mAdded) {
                View requireView = fragment.requireView();
                fragment.mPostponedAlpha = requireView.getAlpha();
                requireView.setAlpha(0.0f);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void c(Fragment fragment, boolean z2) {
        Fragment fragment2 = this.v;
        if (fragment2 != null) {
            C0200o fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof C0207w) {
                ((C0207w) fragmentManager).c(fragment, true);
            }
        }
        Iterator it = this.r.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (!z2 || cVar.f1579b) {
                cVar.f1578a.b(this, fragment);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        return false;
     */
    private boolean b(ArrayList<C0186a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this) {
            if (this.f1564f != null) {
                if (this.f1564f.size() != 0) {
                    boolean z2 = false;
                    for (int i2 = 0; i2 < this.f1564f.size(); i2++) {
                        z2 |= ((e) this.f1564f.get(i2)).a(arrayList, arrayList2);
                    }
                    this.f1564f.clear();
                    this.t.d().removeCallbacks(this.J);
                    return z2;
                }
            }
        }
    }

    public void b(boolean z2) {
        for (int size = this.f1567i.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.f1567i.get(size);
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z2);
            }
        }
    }

    public boolean b(Menu menu) {
        if (this.s < 1) {
            return false;
        }
        boolean z2 = false;
        for (int i2 = 0; i2 < this.f1567i.size(); i2++) {
            Fragment fragment = (Fragment) this.f1567i.get(i2);
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                z2 = true;
            }
        }
        return z2;
    }

    public boolean b(MenuItem menuItem) {
        if (this.s < 1) {
            return false;
        }
        for (int i2 = 0; i2 < this.f1567i.size(); i2++) {
            Fragment fragment = (Fragment) this.f1567i.get(i2);
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public void b(Fragment fragment, Context context, boolean z2) {
        Fragment fragment2 = this.v;
        if (fragment2 != null) {
            C0200o fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof C0207w) {
                ((C0207w) fragmentManager).b(fragment, context, true);
            }
        }
        Iterator it = this.r.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (!z2 || cVar.f1579b) {
                cVar.f1578a.b((C0200o) this, fragment, context);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void b(Fragment fragment, Bundle bundle, boolean z2) {
        Fragment fragment2 = this.v;
        if (fragment2 != null) {
            C0200o fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof C0207w) {
                ((C0207w) fragmentManager).b(fragment, bundle, true);
            }
        }
        Iterator it = this.r.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (!z2 || cVar.f1579b) {
                cVar.f1578a.b((C0200o) this, fragment, bundle);
            }
        }
    }

    static a a(float f2, float f3, float f4, float f5) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f1562d);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f4, f5);
        alphaAnimation.setInterpolator(f1563e);
        alphaAnimation.setDuration(220);
        animationSet.addAnimation(alphaAnimation);
        return new a((Animation) animationSet);
    }

    /* access modifiers changed from: 0000 */
    public void b(Fragment fragment, boolean z2) {
        Fragment fragment2 = this.v;
        if (fragment2 != null) {
            C0200o fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof C0207w) {
                ((C0207w) fragmentManager).b(fragment, true);
            }
        }
        Iterator it = this.r.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (!z2 || cVar.f1579b) {
                cVar.f1578a.a(this, fragment);
            }
        }
    }

    static a a(float f2, float f3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setInterpolator(f1563e);
        alphaAnimation.setDuration(220);
        return new a((Animation) alphaAnimation);
    }

    /* access modifiers changed from: 0000 */
    public a a(Fragment fragment, int i2, boolean z2, int i3) {
        int nextAnim = fragment.getNextAnim();
        boolean z3 = false;
        fragment.setNextAnim(0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && viewGroup.getLayoutTransition() != null) {
            return null;
        }
        Animation onCreateAnimation = fragment.onCreateAnimation(i2, z2, nextAnim);
        if (onCreateAnimation != null) {
            return new a(onCreateAnimation);
        }
        Animator onCreateAnimator = fragment.onCreateAnimator(i2, z2, nextAnim);
        if (onCreateAnimator != null) {
            return new a(onCreateAnimator);
        }
        if (nextAnim != 0) {
            boolean equals = "anim".equals(this.t.c().getResources().getResourceTypeName(nextAnim));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.t.c(), nextAnim);
                    if (loadAnimation != null) {
                        return new a(loadAnimation);
                    }
                    z3 = true;
                } catch (NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            }
            if (!z3) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(this.t.c(), nextAnim);
                    if (loadAnimator != null) {
                        return new a(loadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (!equals) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.t.c(), nextAnim);
                        if (loadAnimation2 != null) {
                            return new a(loadAnimation2);
                        }
                    } else {
                        throw e3;
                    }
                }
            }
        }
        if (i2 == 0) {
            return null;
        }
        int b2 = b(i2, z2);
        if (b2 < 0) {
            return null;
        }
        switch (b2) {
            case 1:
                return a(1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return a(1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return a(0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return a(1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return a(0.0f, 1.0f);
            case 6:
                return a(1.0f, 0.0f);
            default:
                if (i3 == 0 && this.t.h()) {
                    i3 = this.t.g();
                }
                if (i3 == 0) {
                }
                return null;
        }
    }

    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r8v1, types: [int] */
    /* JADX WARNING: type inference failed for: r11v1 */
    /* JADX WARNING: type inference failed for: r8v2 */
    /* JADX WARNING: type inference failed for: r8v3 */
    /* JADX WARNING: type inference failed for: r8v5, types: [boolean] */
    /* JADX WARNING: type inference failed for: r11v2 */
    /* JADX WARNING: type inference failed for: r8v6, types: [boolean] */
    /* JADX WARNING: type inference failed for: r8v7 */
    /* JADX WARNING: type inference failed for: r11v3 */
    /* JADX WARNING: type inference failed for: r11v4 */
    /* JADX WARNING: type inference failed for: r11v5 */
    /* JADX WARNING: type inference failed for: r11v6 */
    /* JADX WARNING: type inference failed for: r8v8 */
    /* JADX WARNING: type inference failed for: r8v9 */
    /* JADX WARNING: type inference failed for: r8v10 */
    /* JADX WARNING: type inference failed for: r11v7 */
    /* JADX WARNING: type inference failed for: r11v8 */
    /* JADX WARNING: type inference failed for: r11v9 */
    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0084, code lost:
        if (r0 != 3) goto L_0x04d6;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r11v3
      assigns: []
      uses: []
      mth insns count: 492
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x02df  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x04db  */
    /* JADX WARNING: Unknown variable types count: 5 */
    public void a(Fragment fragment, int i2, int i3, int i4, boolean z2) {
        int i5;
        int i6;
        ? r8;
        ViewGroup viewGroup;
        String str;
        String str2;
        String str3;
        Fragment fragment2 = fragment;
        ? r82 = 1;
        if (!fragment2.mAdded || fragment2.mDetached) {
            i5 = i2;
            if (i5 > 1) {
                i5 = 1;
            }
        } else {
            i5 = i2;
        }
        if (fragment2.mRemoving) {
            int i7 = fragment2.mState;
            if (i5 > i7) {
                if (i7 != 0 || !fragment.isInBackStack()) {
                    i5 = fragment2.mState;
                } else {
                    i5 = 1;
                }
            }
        }
        if (fragment2.mDeferStart && fragment2.mState < 3 && i5 > 2) {
            i5 = 2;
        }
        androidx.lifecycle.h.b bVar = fragment2.mMaxState;
        if (bVar == androidx.lifecycle.h.b.CREATED) {
            i6 = Math.min(i5, 1);
        } else {
            i6 = Math.min(i5, bVar.ordinal());
        }
        ? r11 = i6;
        int i8 = fragment2.mState;
        String str4 = "FragmentManager";
        if (i8 <= r11) {
            if (!fragment2.mFromLayout || fragment2.mInLayout) {
                if (!(fragment.getAnimatingAway() == null && fragment.getAnimator() == null)) {
                    fragment2.setAnimatingAway(null);
                    fragment2.setAnimator(null);
                    a(fragment, fragment.getStateAfterAnimating(), 0, 0, true);
                }
                int i9 = fragment2.mState;
                if (i9 != 0) {
                    if (i9 != 1) {
                        if (i9 != 2) {
                        }
                        if (r11 > 2) {
                            if (f1561c) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("moveto STARTED: ");
                                sb.append(fragment2);
                                Log.v(str4, sb.toString());
                            }
                            fragment.performStart();
                            f(fragment2, false);
                        }
                    }
                    if (r11 > 0) {
                        f(fragment);
                    }
                    if (r11 > 1) {
                        if (f1561c) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("moveto ACTIVITY_CREATED: ");
                            sb2.append(fragment2);
                            Log.v(str4, sb2.toString());
                        }
                        if (!fragment2.mFromLayout) {
                            int i10 = fragment2.mContainerId;
                            if (i10 == 0) {
                                viewGroup = null;
                            } else if (i10 != -1) {
                                viewGroup = (ViewGroup) this.u.a(i10);
                                if (viewGroup == null && !fragment2.mRestored) {
                                    try {
                                        str = fragment.getResources().getResourceName(fragment2.mContainerId);
                                    } catch (NotFoundException unused) {
                                        str = AttributeType.UNKNOWN;
                                    }
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("No view found for id 0x");
                                    sb3.append(Integer.toHexString(fragment2.mContainerId));
                                    sb3.append(" (");
                                    sb3.append(str);
                                    sb3.append(") for fragment ");
                                    sb3.append(fragment2);
                                    a((RuntimeException) new IllegalArgumentException(sb3.toString()));
                                    throw null;
                                }
                            } else {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("Cannot create fragment ");
                                sb4.append(fragment2);
                                sb4.append(" for a container view with no id");
                                a((RuntimeException) new IllegalArgumentException(sb4.toString()));
                                throw null;
                            }
                            fragment2.mContainer = viewGroup;
                            fragment2.performCreateView(fragment2.performGetLayoutInflater(fragment2.mSavedFragmentState), viewGroup, fragment2.mSavedFragmentState);
                            View view = fragment2.mView;
                            if (view != null) {
                                fragment2.mInnerView = view;
                                view.setSaveFromParentEnabled(false);
                                if (viewGroup != null) {
                                    viewGroup.addView(fragment2.mView);
                                }
                                if (fragment2.mHidden) {
                                    fragment2.mView.setVisibility(8);
                                }
                                fragment2.onViewCreated(fragment2.mView, fragment2.mSavedFragmentState);
                                a(fragment2, fragment2.mView, fragment2.mSavedFragmentState, false);
                                if (fragment2.mView.getVisibility() != 0 || fragment2.mContainer == null) {
                                    r82 = 0;
                                }
                                fragment2.mIsNewlyAdded = r82;
                            } else {
                                fragment2.mInnerView = null;
                            }
                        }
                        fragment2.performActivityCreated(fragment2.mSavedFragmentState);
                        a(fragment2, fragment2.mSavedFragmentState, false);
                        if (fragment2.mView != null) {
                            fragment2.restoreViewState(fragment2.mSavedFragmentState);
                        }
                        fragment2.mSavedFragmentState = null;
                    }
                    if (r11 > 2) {
                    }
                } else {
                    if (r11 > 0) {
                        if (f1561c) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("moveto CREATED: ");
                            sb5.append(fragment2);
                            Log.v(str4, sb5.toString());
                        }
                        Bundle bundle = fragment2.mSavedFragmentState;
                        if (bundle != null) {
                            bundle.setClassLoader(this.t.c().getClassLoader());
                            fragment2.mSavedViewState = fragment2.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                            Fragment a2 = a(fragment2.mSavedFragmentState, "android:target_state");
                            fragment2.mTargetWho = a2 != null ? a2.mWho : null;
                            if (fragment2.mTargetWho != null) {
                                fragment2.mTargetRequestCode = fragment2.mSavedFragmentState.getInt("android:target_req_state", 0);
                            }
                            Boolean bool = fragment2.mSavedUserVisibleHint;
                            if (bool != null) {
                                fragment2.mUserVisibleHint = bool.booleanValue();
                                fragment2.mSavedUserVisibleHint = null;
                            } else {
                                fragment2.mUserVisibleHint = fragment2.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
                            }
                            if (!fragment2.mUserVisibleHint) {
                                fragment2.mDeferStart = true;
                                if (r11 > 2) {
                                    r11 = 2;
                                }
                            }
                        }
                        C0199n nVar = this.t;
                        fragment2.mHost = nVar;
                        Fragment fragment3 = this.v;
                        fragment2.mParentFragment = fragment3;
                        fragment2.mFragmentManager = fragment3 != null ? fragment3.mChildFragmentManager : nVar.f1543e;
                        Fragment fragment4 = fragment2.mTarget;
                        String str5 = " that does not belong to this FragmentManager!";
                        String str6 = " declared target fragment ";
                        String str7 = "Fragment ";
                        if (fragment4 != null) {
                            Object obj = this.f1568j.get(fragment4.mWho);
                            Fragment fragment5 = fragment2.mTarget;
                            if (obj == fragment5) {
                                if (fragment5.mState < 1) {
                                    str3 = str7;
                                    str2 = str6;
                                    a(fragment5, 1, 0, 0, true);
                                } else {
                                    str3 = str7;
                                    str2 = str6;
                                }
                                fragment2.mTargetWho = fragment2.mTarget.mWho;
                                fragment2.mTarget = null;
                            } else {
                                String str8 = str7;
                                String str9 = str6;
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append(str8);
                                sb6.append(fragment2);
                                sb6.append(str9);
                                sb6.append(fragment2.mTarget);
                                sb6.append(str5);
                                throw new IllegalStateException(sb6.toString());
                            }
                        } else {
                            str3 = str7;
                            str2 = str6;
                        }
                        String str10 = fragment2.mTargetWho;
                        if (str10 != null) {
                            Fragment fragment6 = (Fragment) this.f1568j.get(str10);
                            if (fragment6 == null) {
                                StringBuilder sb7 = new StringBuilder();
                                sb7.append(str3);
                                sb7.append(fragment2);
                                sb7.append(str2);
                                sb7.append(fragment2.mTargetWho);
                                sb7.append(str5);
                                throw new IllegalStateException(sb7.toString());
                            } else if (fragment6.mState < 1) {
                                a(fragment6, 1, 0, 0, true);
                            }
                        }
                        b(fragment2, this.t.c(), false);
                        fragment.performAttach();
                        Fragment fragment7 = fragment2.mParentFragment;
                        if (fragment7 == null) {
                            this.t.a(fragment2);
                        } else {
                            fragment7.onAttachFragment(fragment2);
                        }
                        a(fragment2, this.t.c(), false);
                        if (!fragment2.mIsCreated) {
                            c(fragment2, fragment2.mSavedFragmentState, false);
                            fragment2.performCreate(fragment2.mSavedFragmentState);
                            b(fragment2, fragment2.mSavedFragmentState, false);
                            r11 = r11;
                        } else {
                            fragment2.restoreChildFragmentState(fragment2.mSavedFragmentState);
                            fragment2.mState = 1;
                            r11 = r11;
                        }
                    }
                    if (r11 > 0) {
                    }
                    if (r11 > 1) {
                    }
                    if (r11 > 2) {
                    }
                }
                if (r11 > 3) {
                    if (f1561c) {
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append("moveto RESUMED: ");
                        sb8.append(fragment2);
                        Log.v(str4, sb8.toString());
                    }
                    fragment.performResume();
                    e(fragment2, false);
                    fragment2.mSavedFragmentState = null;
                    fragment2.mSavedViewState = null;
                }
            } else {
                return;
            }
        } else if (i8 > r11) {
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 != 3) {
                        if (i8 == 4) {
                            if (r11 < 4) {
                                if (f1561c) {
                                    StringBuilder sb9 = new StringBuilder();
                                    sb9.append("movefrom RESUMED: ");
                                    sb9.append(fragment2);
                                    Log.v(str4, sb9.toString());
                                }
                                fragment.performPause();
                                d(fragment2, false);
                            }
                        }
                    }
                    if (r11 < 3) {
                        if (f1561c) {
                            StringBuilder sb10 = new StringBuilder();
                            sb10.append("movefrom STARTED: ");
                            sb10.append(fragment2);
                            Log.v(str4, sb10.toString());
                        }
                        fragment.performStop();
                        g(fragment2, false);
                    }
                }
                if (r11 < 2) {
                    if (f1561c) {
                        StringBuilder sb11 = new StringBuilder();
                        sb11.append("movefrom ACTIVITY_CREATED: ");
                        sb11.append(fragment2);
                        Log.v(str4, sb11.toString());
                    }
                    if (fragment2.mView != null && this.t.b(fragment2) && fragment2.mSavedViewState == null) {
                        s(fragment);
                    }
                    fragment.performDestroyView();
                    h(fragment2, false);
                    View view2 = fragment2.mView;
                    if (view2 != null) {
                        ViewGroup viewGroup2 = fragment2.mContainer;
                        if (viewGroup2 != null) {
                            viewGroup2.endViewTransition(view2);
                            fragment2.mView.clearAnimation();
                            if (fragment.getParentFragment() == null || !fragment.getParentFragment().mRemoving) {
                                a a3 = (this.s <= 0 || this.A || fragment2.mView.getVisibility() != 0 || fragment2.mPostponedAlpha < 0.0f) ? null : a(fragment2, i3, false, i4);
                                fragment2.mPostponedAlpha = 0.0f;
                                if (a3 != null) {
                                    a(fragment2, a3, r11);
                                }
                                fragment2.mContainer.removeView(fragment2.mView);
                            }
                        }
                    }
                    fragment2.mContainer = null;
                    fragment2.mView = null;
                    fragment2.mViewLifecycleOwner = null;
                    fragment2.mViewLifecycleOwnerLiveData.b(null);
                    fragment2.mInnerView = null;
                    fragment2.mInLayout = false;
                }
            }
            if (r11 < 1) {
                if (this.A) {
                    if (fragment.getAnimatingAway() != null) {
                        View animatingAway = fragment.getAnimatingAway();
                        fragment2.setAnimatingAway(null);
                        animatingAway.clearAnimation();
                    } else if (fragment.getAnimator() != null) {
                        Animator animator = fragment.getAnimator();
                        fragment2.setAnimator(null);
                        animator.cancel();
                    }
                }
                if (fragment.getAnimatingAway() == null && fragment.getAnimator() == null) {
                    if (f1561c) {
                        StringBuilder sb12 = new StringBuilder();
                        sb12.append("movefrom CREATED: ");
                        sb12.append(fragment2);
                        Log.v(str4, sb12.toString());
                    }
                    boolean z3 = fragment2.mRemoving && !fragment.isInBackStack();
                    if (z3 || this.I.f(fragment2)) {
                        C0199n nVar2 = this.t;
                        if (nVar2 instanceof G) {
                            r82 = this.I.d();
                        } else if (nVar2.c() instanceof Activity) {
                            r82 = true ^ ((Activity) this.t.c()).isChangingConfigurations();
                        }
                        if (z3 || r82 != 0) {
                            this.I.b(fragment2);
                        }
                        fragment.performDestroy();
                        b(fragment2, false);
                    } else {
                        fragment2.mState = 0;
                    }
                    fragment.performDetach();
                    c(fragment2, false);
                    if (!z2) {
                        if (z3 || this.I.f(fragment2)) {
                            l(fragment);
                        } else {
                            fragment2.mHost = null;
                            fragment2.mParentFragment = null;
                            fragment2.mFragmentManager = null;
                            String str11 = fragment2.mTargetWho;
                            if (str11 != null) {
                                Fragment fragment8 = (Fragment) this.f1568j.get(str11);
                                if (fragment8 != null && fragment8.getRetainInstance()) {
                                    fragment2.mTarget = fragment8;
                                }
                            }
                        }
                    }
                } else {
                    fragment2.setStateAfterAnimating(r11);
                    r8 = r82;
                    if (fragment2.mState != r8) {
                        StringBuilder sb13 = new StringBuilder();
                        sb13.append("moveToState: Fragment state for ");
                        sb13.append(fragment2);
                        sb13.append(" not updated inline; expected state ");
                        sb13.append(r8);
                        sb13.append(" found ");
                        sb13.append(fragment2.mState);
                        Log.w(str4, sb13.toString());
                        fragment2.mState = r8;
                    }
                }
            }
        }
        r8 = r11;
        if (fragment2.mState != r8) {
        }
    }

    private void a(Fragment fragment, a aVar, int i2) {
        View view = fragment.mView;
        ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        fragment.setStateAfterAnimating(i2);
        Animation animation = aVar.f1571a;
        if (animation != null) {
            b bVar = new b(animation, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            bVar.setAnimationListener(new C0203s(this, viewGroup, fragment));
            fragment.mView.startAnimation(bVar);
            return;
        }
        Animator animator = aVar.f1572b;
        fragment.setAnimator(animator);
        animator.addListener(new C0204t(this, viewGroup, view, fragment));
        animator.setTarget(fragment.mView);
        animator.start();
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2, boolean z2) {
        if (this.t == null && i2 != 0) {
            throw new IllegalStateException("No activity");
        } else if (z2 || i2 != this.s) {
            this.s = i2;
            int size = this.f1567i.size();
            for (int i3 = 0; i3 < size; i3++) {
                m((Fragment) this.f1567i.get(i3));
            }
            for (Fragment fragment : this.f1568j.values()) {
                if (fragment != null && ((fragment.mRemoving || fragment.mDetached) && !fragment.mIsNewlyAdded)) {
                    m(fragment);
                }
            }
            C();
            if (this.x) {
                C0199n nVar = this.t;
                if (nVar != null && this.s == 4) {
                    nVar.i();
                    this.x = false;
                }
            }
        }
    }

    public void a(Fragment fragment, boolean z2) {
        if (f1561c) {
            StringBuilder sb = new StringBuilder();
            sb.append("add: ");
            sb.append(fragment);
            Log.v("FragmentManager", sb.toString());
        }
        k(fragment);
        if (fragment.mDetached) {
            return;
        }
        if (!this.f1567i.contains(fragment)) {
            synchronized (this.f1567i) {
                this.f1567i.add(fragment);
            }
            fragment.mAdded = true;
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (x(fragment)) {
                this.x = true;
            }
            if (z2) {
                n(fragment);
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Fragment already added: ");
        sb2.append(fragment);
        throw new IllegalStateException(sb2.toString());
    }

    public Fragment a(int i2) {
        for (int size = this.f1567i.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.f1567i.get(size);
            if (fragment != null && fragment.mFragmentId == i2) {
                return fragment;
            }
        }
        for (Fragment fragment2 : this.f1568j.values()) {
            if (fragment2 != null && fragment2.mFragmentId == i2) {
                return fragment2;
            }
        }
        return null;
    }

    public Fragment a(String str) {
        if (str != null) {
            for (int size = this.f1567i.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.f1567i.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str != null) {
            for (Fragment fragment2 : this.f1568j.values()) {
                if (fragment2 != null && str.equals(fragment2.mTag)) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    public void a(e eVar, boolean z2) {
        if (!z2) {
            E();
        }
        synchronized (this) {
            if (!this.A) {
                if (this.t != null) {
                    if (this.f1564f == null) {
                        this.f1564f = new ArrayList<>();
                    }
                    this.f1564f.add(eVar);
                    B();
                    return;
                }
            }
            if (!z2) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    public void a(int i2, C0186a aVar) {
        synchronized (this) {
            if (this.o == null) {
                this.o = new ArrayList<>();
            }
            int size = this.o.size();
            if (i2 < size) {
                if (f1561c) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Setting back stack index ");
                    sb.append(i2);
                    sb.append(" to ");
                    sb.append(aVar);
                    Log.v("FragmentManager", sb.toString());
                }
                this.o.set(i2, aVar);
            } else {
                while (size < i2) {
                    this.o.add(null);
                    if (this.p == null) {
                        this.p = new ArrayList<>();
                    }
                    if (f1561c) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Adding available back stack index ");
                        sb2.append(size);
                        Log.v("FragmentManager", sb2.toString());
                    }
                    this.p.add(Integer.valueOf(size));
                    size++;
                }
                if (f1561c) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Adding back stack index ");
                    sb3.append(i2);
                    sb3.append(" with ");
                    sb3.append(aVar);
                    Log.v("FragmentManager", sb3.toString());
                }
                this.o.add(aVar);
            }
        }
    }

    private void a(ArrayList<C0186a> arrayList, ArrayList<Boolean> arrayList2) {
        ArrayList<g> arrayList3 = this.H;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            g gVar = (g) this.H.get(i2);
            if (arrayList != null && !gVar.f1585a) {
                int indexOf = arrayList.indexOf(gVar.f1586b);
                if (indexOf != -1 && ((Boolean) arrayList2.get(indexOf)).booleanValue()) {
                    this.H.remove(i2);
                    i2--;
                    size--;
                    gVar.c();
                    i2++;
                }
            }
            if (gVar.e() || (arrayList != null && gVar.f1586b.a(arrayList, 0, arrayList.size()))) {
                this.H.remove(i2);
                i2--;
                size--;
                if (arrayList != null && !gVar.f1585a) {
                    int indexOf2 = arrayList.indexOf(gVar.f1586b);
                    if (indexOf2 != -1 && ((Boolean) arrayList2.get(indexOf2)).booleanValue()) {
                        gVar.c();
                    }
                }
                gVar.d();
            }
            i2++;
        }
    }

    private int a(ArrayList<C0186a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, b.d.d<Fragment> dVar) {
        int i4 = i3;
        for (int i5 = i3 - 1; i5 >= i2; i5--) {
            C0186a aVar = (C0186a) arrayList.get(i5);
            boolean booleanValue = ((Boolean) arrayList2.get(i5)).booleanValue();
            if (aVar.f() && !aVar.a(arrayList, i5 + 1, i3)) {
                if (this.H == null) {
                    this.H = new ArrayList<>();
                }
                g gVar = new g(aVar, booleanValue);
                this.H.add(gVar);
                aVar.a(gVar);
                if (booleanValue) {
                    aVar.e();
                } else {
                    aVar.c(false);
                }
                i4--;
                if (i5 != i4) {
                    arrayList.remove(i5);
                    arrayList.add(i4, aVar);
                }
                a(dVar);
            }
        }
        return i4;
    }

    /* access modifiers changed from: 0000 */
    public void a(C0186a aVar, boolean z2, boolean z3, boolean z4) {
        if (z2) {
            aVar.c(z4);
        } else {
            aVar.e();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z2));
        if (z3) {
            K.a(this, arrayList, arrayList2, 0, 1, true);
        }
        if (z4) {
            a(this.s, true);
        }
        for (Fragment fragment : this.f1568j.values()) {
            if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && aVar.c(fragment.mContainerId)) {
                float f2 = fragment.mPostponedAlpha;
                if (f2 > 0.0f) {
                    fragment.mView.setAlpha(f2);
                }
                if (z4) {
                    fragment.mPostponedAlpha = 0.0f;
                } else {
                    fragment.mPostponedAlpha = -1.0f;
                    fragment.mIsNewlyAdded = false;
                }
            }
        }
    }

    private static void a(ArrayList<C0186a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        while (i2 < i3) {
            C0186a aVar = (C0186a) arrayList.get(i2);
            boolean z2 = true;
            if (((Boolean) arrayList2.get(i2)).booleanValue()) {
                aVar.b(-1);
                if (i2 != i3 - 1) {
                    z2 = false;
                }
                aVar.c(z2);
            } else {
                aVar.b(1);
                aVar.e();
            }
            i2++;
        }
    }

    private void a(b.d.d<Fragment> dVar) {
        int i2 = this.s;
        if (i2 >= 1) {
            int min = Math.min(i2, 3);
            int size = this.f1567i.size();
            for (int i3 = 0; i3 < size; i3++) {
                Fragment fragment = (Fragment) this.f1567i.get(i3);
                if (fragment.mState < min) {
                    a(fragment, min, fragment.getNextAnim(), fragment.getNextTransition(), false);
                    if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                        dVar.add(fragment);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(C0186a aVar) {
        if (this.f1569k == null) {
            this.f1569k = new ArrayList<>();
        }
        this.f1569k.add(aVar);
    }

    /* access modifiers changed from: 0000 */
    public boolean a(ArrayList<C0186a> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        int i4;
        ArrayList<C0186a> arrayList3 = this.f1569k;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f1569k.remove(size));
            arrayList2.add(Boolean.valueOf(true));
        } else {
            if (str != null || i2 >= 0) {
                i4 = this.f1569k.size() - 1;
                while (i4 >= 0) {
                    C0186a aVar = (C0186a) this.f1569k.get(i4);
                    if ((str != null && str.equals(aVar.getName())) || (i2 >= 0 && i2 == aVar.u)) {
                        break;
                    }
                    i4--;
                }
                if (i4 < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        i4--;
                        if (i4 < 0) {
                            break;
                        }
                        C0186a aVar2 = (C0186a) this.f1569k.get(i4);
                        if ((str == null || !str.equals(aVar2.getName())) && (i2 < 0 || i2 != aVar2.u)) {
                            break;
                        }
                    }
                }
            } else {
                i4 = -1;
            }
            if (i4 == this.f1569k.size() - 1) {
                return false;
            }
            for (int size2 = this.f1569k.size() - 1; size2 > i4; size2--) {
                arrayList.add(this.f1569k.remove(size2));
                arrayList2.add(Boolean.valueOf(true));
            }
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void a(Parcelable parcelable) {
        D d2;
        if (parcelable != null) {
            y yVar = (y) parcelable;
            if (yVar.f1588a != null) {
                for (Fragment fragment : this.I.c()) {
                    if (f1561c) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("restoreSaveState: re-attaching retained ");
                        sb.append(fragment);
                        Log.v("FragmentManager", sb.toString());
                    }
                    Iterator it = yVar.f1588a.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            d2 = null;
                            break;
                        }
                        d2 = (D) it.next();
                        if (d2.f1394b.equals(fragment.mWho)) {
                            break;
                        }
                    }
                    if (d2 == null) {
                        if (f1561c) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Discarding retained Fragment ");
                            sb2.append(fragment);
                            sb2.append(" that was not found in the set of active Fragments ");
                            sb2.append(yVar.f1588a);
                            Log.v("FragmentManager", sb2.toString());
                        }
                        Fragment fragment2 = fragment;
                        a(fragment2, 1, 0, 0, false);
                        fragment.mRemoving = true;
                        a(fragment2, 0, 0, 0, false);
                    } else {
                        d2.n = fragment;
                        fragment.mSavedViewState = null;
                        fragment.mBackStackNesting = 0;
                        fragment.mInLayout = false;
                        fragment.mAdded = false;
                        Fragment fragment3 = fragment.mTarget;
                        fragment.mTargetWho = fragment3 != null ? fragment3.mWho : null;
                        fragment.mTarget = null;
                        Bundle bundle = d2.m;
                        if (bundle != null) {
                            bundle.setClassLoader(this.t.c().getClassLoader());
                            fragment.mSavedViewState = d2.m.getSparseParcelableArray("android:view_state");
                            fragment.mSavedFragmentState = d2.m;
                        }
                    }
                }
                this.f1568j.clear();
                Iterator it2 = yVar.f1588a.iterator();
                while (it2.hasNext()) {
                    D d3 = (D) it2.next();
                    if (d3 != null) {
                        Fragment a2 = d3.a(this.t.c().getClassLoader(), c());
                        a2.mFragmentManager = this;
                        if (f1561c) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("restoreSaveState: active (");
                            sb3.append(a2.mWho);
                            sb3.append("): ");
                            sb3.append(a2);
                            Log.v("FragmentManager", sb3.toString());
                        }
                        this.f1568j.put(a2.mWho, a2);
                        d3.n = null;
                    }
                }
                this.f1567i.clear();
                ArrayList<String> arrayList = yVar.f1589b;
                if (arrayList != null) {
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        String str = (String) it3.next();
                        Fragment fragment4 = (Fragment) this.f1568j.get(str);
                        if (fragment4 != null) {
                            fragment4.mAdded = true;
                            if (f1561c) {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("restoreSaveState: added (");
                                sb4.append(str);
                                sb4.append("): ");
                                sb4.append(fragment4);
                                Log.v("FragmentManager", sb4.toString());
                            }
                            if (!this.f1567i.contains(fragment4)) {
                                synchronized (this.f1567i) {
                                    this.f1567i.add(fragment4);
                                }
                            } else {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("Already added ");
                                sb5.append(fragment4);
                                throw new IllegalStateException(sb5.toString());
                            }
                        } else {
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("No instantiated fragment for (");
                            sb6.append(str);
                            sb6.append(")");
                            a((RuntimeException) new IllegalStateException(sb6.toString()));
                            throw null;
                        }
                    }
                }
                C0188c[] cVarArr = yVar.f1590c;
                if (cVarArr != null) {
                    this.f1569k = new ArrayList<>(cVarArr.length);
                    int i2 = 0;
                    while (true) {
                        C0188c[] cVarArr2 = yVar.f1590c;
                        if (i2 >= cVarArr2.length) {
                            break;
                        }
                        C0186a a3 = cVarArr2[i2].a(this);
                        if (f1561c) {
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append("restoreAllState: back stack #");
                            sb7.append(i2);
                            sb7.append(" (index ");
                            sb7.append(a3.u);
                            sb7.append("): ");
                            sb7.append(a3);
                            Log.v("FragmentManager", sb7.toString());
                            PrintWriter printWriter = new PrintWriter(new b.g.h.b("FragmentManager"));
                            a3.a("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.f1569k.add(a3);
                        int i3 = a3.u;
                        if (i3 >= 0) {
                            a(i3, a3);
                        }
                        i2++;
                    }
                } else {
                    this.f1569k = null;
                }
                String str2 = yVar.f1591d;
                if (str2 != null) {
                    this.w = (Fragment) this.f1568j.get(str2);
                    v(this.w);
                }
                this.f1566h = yVar.f1592e;
            }
        }
    }

    /* JADX WARNING: type inference failed for: r4v8, types: [androidx.lifecycle.l] */
    /* JADX WARNING: Multi-variable type inference failed */
    public void a(C0199n nVar, C0196k kVar, Fragment fragment) {
        if (this.t == null) {
            this.t = nVar;
            this.u = kVar;
            this.v = fragment;
            if (this.v != null) {
                I();
            }
            if (nVar instanceof androidx.activity.e) {
                androidx.activity.e eVar = (androidx.activity.e) nVar;
                this.m = eVar.getOnBackPressedDispatcher();
                if (fragment != 0) {
                    eVar = fragment;
                }
                this.m.a(eVar, this.n);
            }
            if (fragment != 0) {
                this.I = fragment.mFragmentManager.g(fragment);
            } else if (nVar instanceof G) {
                this.I = A.a(((G) nVar).getViewModelStore());
            } else {
                this.I = new A(false);
            }
        } else {
            throw new IllegalStateException("Already attached");
        }
    }

    public void a(boolean z2) {
        for (int size = this.f1567i.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.f1567i.get(size);
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z2);
            }
        }
    }

    public void a(Configuration configuration) {
        for (int i2 = 0; i2 < this.f1567i.size(); i2++) {
            Fragment fragment = (Fragment) this.f1567i.get(i2);
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        if (this.s < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z2 = false;
        for (int i2 = 0; i2 < this.f1567i.size(); i2++) {
            Fragment fragment = (Fragment) this.f1567i.get(i2);
            if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z2 = true;
            }
        }
        if (this.f1570l != null) {
            for (int i3 = 0; i3 < this.f1570l.size(); i3++) {
                Fragment fragment2 = (Fragment) this.f1570l.get(i3);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f1570l = arrayList;
        return z2;
    }

    public boolean a(MenuItem menuItem) {
        if (this.s < 1) {
            return false;
        }
        for (int i2 = 0; i2 < this.f1567i.size(); i2++) {
            Fragment fragment = (Fragment) this.f1567i.get(i2);
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void a(Menu menu) {
        if (this.s >= 1) {
            for (int i2 = 0; i2 < this.f1567i.size(); i2++) {
                Fragment fragment = (Fragment) this.f1567i.get(i2);
                if (fragment != null) {
                    fragment.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    public void a(Fragment fragment, androidx.lifecycle.h.b bVar) {
        if (this.f1568j.get(fragment.mWho) == fragment && (fragment.mHost == null || fragment.getFragmentManager() == this)) {
            fragment.mMaxState = bVar;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(fragment);
        sb.append(" is not an active fragment of FragmentManager ");
        sb.append(this);
        throw new IllegalArgumentException(sb.toString());
    }

    public void a(androidx.fragment.app.C0200o.b bVar, boolean z2) {
        this.r.add(new c(bVar, z2));
    }

    public void a(androidx.fragment.app.C0200o.b bVar) {
        synchronized (this.r) {
            int i2 = 0;
            int size = this.r.size();
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (((c) this.r.get(i2)).f1578a == bVar) {
                    this.r.remove(i2);
                    break;
                } else {
                    i2++;
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(Fragment fragment, Context context, boolean z2) {
        Fragment fragment2 = this.v;
        if (fragment2 != null) {
            C0200o fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof C0207w) {
                ((C0207w) fragmentManager).a(fragment, context, true);
            }
        }
        Iterator it = this.r.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (!z2 || cVar.f1579b) {
                cVar.f1578a.a((C0200o) this, fragment, context);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(Fragment fragment, Bundle bundle, boolean z2) {
        Fragment fragment2 = this.v;
        if (fragment2 != null) {
            C0200o fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof C0207w) {
                ((C0207w) fragmentManager).a(fragment, bundle, true);
            }
        }
        Iterator it = this.r.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (!z2 || cVar.f1579b) {
                cVar.f1578a.a((C0200o) this, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(Fragment fragment, View view, Bundle bundle, boolean z2) {
        Fragment fragment2 = this.v;
        if (fragment2 != null) {
            C0200o fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof C0207w) {
                ((C0207w) fragmentManager).a(fragment, view, bundle, true);
            }
        }
        Iterator it = this.r.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (!z2 || cVar.f1579b) {
                cVar.f1578a.a(this, fragment, view, bundle);
            }
        }
    }
}
