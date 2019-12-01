package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.h.b;
import androidx.viewpager.widget.a;

/* compiled from: FragmentPagerAdapter */
public abstract class B extends a {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
    @Deprecated
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentPagerAdapter";
    private final int mBehavior;
    private F mCurTransaction;
    private Fragment mCurrentPrimaryItem;
    private final C0200o mFragmentManager;

    @Deprecated
    public B(C0200o oVar) {
        this(oVar, 0);
    }

    private static String makeFragmentName(int i2, long j2) {
        StringBuilder sb = new StringBuilder();
        sb.append("android:switcher:");
        sb.append(i2);
        sb.append(":");
        sb.append(j2);
        return sb.toString();
    }

    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.a();
        }
        this.mCurTransaction.b(fragment);
        if (fragment == this.mCurrentPrimaryItem) {
            this.mCurrentPrimaryItem = null;
        }
    }

    public void finishUpdate(ViewGroup viewGroup) {
        F f2 = this.mCurTransaction;
        if (f2 != null) {
            f2.c();
            this.mCurTransaction = null;
        }
    }

    public abstract Fragment getItem(int i2);

    public long getItemId(int i2) {
        return (long) i2;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.a();
        }
        long itemId = getItemId(i2);
        Fragment a2 = this.mFragmentManager.a(makeFragmentName(viewGroup.getId(), itemId));
        if (a2 != null) {
            this.mCurTransaction.a(a2);
        } else {
            a2 = getItem(i2);
            this.mCurTransaction.a(viewGroup.getId(), a2, makeFragmentName(viewGroup.getId(), itemId));
        }
        if (a2 != this.mCurrentPrimaryItem) {
            a2.setMenuVisibility(false);
            if (this.mBehavior == 1) {
                this.mCurTransaction.a(a2, b.STARTED);
            } else {
                a2.setUserVisibleHint(false);
            }
        }
        return a2;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable saveState() {
        return null;
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.mCurrentPrimaryItem;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.mBehavior == 1) {
                    if (this.mCurTransaction == null) {
                        this.mCurTransaction = this.mFragmentManager.a();
                    }
                    this.mCurTransaction.a(this.mCurrentPrimaryItem, b.STARTED);
                } else {
                    this.mCurrentPrimaryItem.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.mBehavior == 1) {
                if (this.mCurTransaction == null) {
                    this.mCurTransaction = this.mFragmentManager.a();
                }
                this.mCurTransaction.a(fragment, b.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.mCurrentPrimaryItem = fragment;
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

    public B(C0200o oVar, int i2) {
        this.mCurTransaction = null;
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = oVar;
        this.mBehavior = i2;
    }
}
