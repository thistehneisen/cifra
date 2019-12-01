package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment.c;
import androidx.lifecycle.h.b;
import androidx.viewpager.widget.a;
import java.util.ArrayList;

/* compiled from: FragmentStatePagerAdapter */
public abstract class E extends a {

    /* renamed from: a reason: collision with root package name */
    private final C0200o f1405a;

    /* renamed from: b reason: collision with root package name */
    private final int f1406b;

    /* renamed from: c reason: collision with root package name */
    private F f1407c;

    /* renamed from: d reason: collision with root package name */
    private ArrayList<c> f1408d;

    /* renamed from: e reason: collision with root package name */
    private ArrayList<Fragment> f1409e;

    /* renamed from: f reason: collision with root package name */
    private Fragment f1410f;

    @Deprecated
    public E(C0200o oVar) {
        this(oVar, 0);
    }

    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f1407c == null) {
            this.f1407c = this.f1405a.a();
        }
        while (this.f1408d.size() <= i2) {
            this.f1408d.add(null);
        }
        this.f1408d.set(i2, fragment.isAdded() ? this.f1405a.a(fragment) : null);
        this.f1409e.set(i2, null);
        this.f1407c.c(fragment);
        if (fragment == this.f1410f) {
            this.f1410f = null;
        }
    }

    public void finishUpdate(ViewGroup viewGroup) {
        F f2 = this.f1407c;
        if (f2 != null) {
            f2.c();
            this.f1407c = null;
        }
    }

    public abstract Fragment getItem(int i2);

    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        if (this.f1409e.size() > i2) {
            Fragment fragment = (Fragment) this.f1409e.get(i2);
            if (fragment != null) {
                return fragment;
            }
        }
        if (this.f1407c == null) {
            this.f1407c = this.f1405a.a();
        }
        Fragment item = getItem(i2);
        if (this.f1408d.size() > i2) {
            c cVar = (c) this.f1408d.get(i2);
            if (cVar != null) {
                item.setInitialSavedState(cVar);
            }
        }
        while (this.f1409e.size() <= i2) {
            this.f1409e.add(null);
        }
        item.setMenuVisibility(false);
        if (this.f1406b == 0) {
            item.setUserVisibleHint(false);
        }
        this.f1409e.set(i2, item);
        this.f1407c.a(viewGroup.getId(), item);
        if (this.f1406b == 1) {
            this.f1407c.a(item, b.STARTED);
        }
        return item;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f1408d.clear();
            this.f1409e.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f1408d.add((c) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment a2 = this.f1405a.a(bundle, str);
                    if (a2 != null) {
                        while (this.f1409e.size() <= parseInt) {
                            this.f1409e.add(null);
                        }
                        a2.setMenuVisibility(false);
                        this.f1409e.set(parseInt, a2);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Bad fragment at key ");
                        sb.append(str);
                        Log.w("FragmentStatePagerAdapt", sb.toString());
                    }
                }
            }
        }
    }

    public Parcelable saveState() {
        Bundle bundle;
        if (this.f1408d.size() > 0) {
            bundle = new Bundle();
            c[] cVarArr = new c[this.f1408d.size()];
            this.f1408d.toArray(cVarArr);
            bundle.putParcelableArray("states", cVarArr);
        } else {
            bundle = null;
        }
        for (int i2 = 0; i2 < this.f1409e.size(); i2++) {
            Fragment fragment = (Fragment) this.f1409e.get(i2);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("f");
                sb.append(i2);
                this.f1405a.a(bundle, sb.toString(), fragment);
            }
        }
        return bundle;
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f1410f;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.f1406b == 1) {
                    if (this.f1407c == null) {
                        this.f1407c = this.f1405a.a();
                    }
                    this.f1407c.a(this.f1410f, b.STARTED);
                } else {
                    this.f1410f.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.f1406b == 1) {
                if (this.f1407c == null) {
                    this.f1407c = this.f1405a.a();
                }
                this.f1407c.a(fragment, b.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.f1410f = fragment;
        }
    }

    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            StringBuilder sb = new StringBuilder();
            sb.append("ViewPager with adapter ");
            sb.append(this);
            sb.append(" requires a view id");
            throw new IllegalStateException(sb.toString());
        }
    }

    public E(C0200o oVar, int i2) {
        this.f1407c = null;
        this.f1408d = new ArrayList<>();
        this.f1409e = new ArrayList<>();
        this.f1410f = null;
        this.f1405a = oVar;
        this.f1406b = i2;
    }
}
