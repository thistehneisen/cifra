package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.lifecycle.F;
import androidx.lifecycle.G;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.h;
import androidx.lifecycle.j;
import androidx.lifecycle.k;
import androidx.lifecycle.l;
import androidx.lifecycle.n;
import androidx.lifecycle.u;
import b.g.i.C0245f;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Fragment implements ComponentCallbacks, OnCreateContextMenuListener, l, G, androidx.savedstate.c {
    static final int ACTIVITY_CREATED = 2;
    static final int CREATED = 1;
    static final int INITIALIZING = 0;
    static final int RESUMED = 4;
    static final int STARTED = 3;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    boolean mAdded;
    a mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    private boolean mCalled;
    C0207w mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    C0207w mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    C0199n mHost;
    boolean mInLayout;
    View mInnerView;
    boolean mIsCreated;
    boolean mIsNewlyAdded;
    private Boolean mIsPrimaryNavigationFragment;
    LayoutInflater mLayoutInflater;
    n mLifecycleRegistry;
    androidx.lifecycle.h.b mMaxState;
    boolean mMenuVisible;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    float mPostponedAlpha;
    Runnable mPostponedDurationRunnable;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    androidx.savedstate.b mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    SparseArray<Parcelable> mSavedViewState;
    int mState;
    String mTag;
    Fragment mTarget;
    int mTargetRequestCode;
    String mTargetWho;
    boolean mUserVisibleHint;
    View mView;
    V mViewLifecycleOwner;
    u<l> mViewLifecycleOwnerLiveData;
    String mWho;

    public static class InstantiationException extends RuntimeException {
        public InstantiationException(String str, Exception exc) {
            super(str, exc);
        }
    }

    static class a {

        /* renamed from: a reason: collision with root package name */
        View f1432a;

        /* renamed from: b reason: collision with root package name */
        Animator f1433b;

        /* renamed from: c reason: collision with root package name */
        int f1434c;

        /* renamed from: d reason: collision with root package name */
        int f1435d;

        /* renamed from: e reason: collision with root package name */
        int f1436e;

        /* renamed from: f reason: collision with root package name */
        int f1437f;

        /* renamed from: g reason: collision with root package name */
        Object f1438g = null;

        /* renamed from: h reason: collision with root package name */
        Object f1439h;

        /* renamed from: i reason: collision with root package name */
        Object f1440i;

        /* renamed from: j reason: collision with root package name */
        Object f1441j;

        /* renamed from: k reason: collision with root package name */
        Object f1442k;

        /* renamed from: l reason: collision with root package name */
        Object f1443l;
        Boolean m;
        Boolean n;
        androidx.core.app.n o;
        androidx.core.app.n p;
        boolean q;
        b r;
        boolean s;

        a() {
            Object obj = Fragment.USE_DEFAULT_TRANSITION;
            this.f1439h = obj;
            this.f1440i = null;
            this.f1441j = obj;
            this.f1442k = null;
            this.f1443l = obj;
            this.o = null;
            this.p = null;
        }
    }

    interface b {
        void a();

        void b();
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class c implements Parcelable {
        public static final Creator<c> CREATOR = new C0194i();

        /* renamed from: a reason: collision with root package name */
        final Bundle f1444a;

        c(Bundle bundle) {
            this.f1444a = bundle;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeBundle(this.f1444a);
        }

        c(Parcel parcel, ClassLoader classLoader) {
            this.f1444a = parcel.readBundle();
            if (classLoader != null) {
                Bundle bundle = this.f1444a;
                if (bundle != null) {
                    bundle.setClassLoader(classLoader);
                }
            }
        }
    }

    public Fragment() {
        this.mState = 0;
        this.mWho = UUID.randomUUID().toString();
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = new C0207w();
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mPostponedDurationRunnable = new C0191f(this);
        this.mMaxState = androidx.lifecycle.h.b.RESUMED;
        this.mViewLifecycleOwnerLiveData = new u<>();
        initLifecycle();
    }

    private a ensureAnimationInfo() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new a();
        }
        return this.mAnimationInfo;
    }

    private void initLifecycle() {
        this.mLifecycleRegistry = new n(this);
        this.mSavedStateRegistryController = androidx.savedstate.b.a((androidx.savedstate.c) this);
        if (VERSION.SDK_INT >= 19) {
            this.mLifecycleRegistry.a((k) new j() {
                public void a(l lVar, androidx.lifecycle.h.a aVar) {
                    if (aVar == androidx.lifecycle.h.a.ON_STOP) {
                        View view = Fragment.this.mView;
                        if (view != null) {
                            view.cancelPendingInputEvents();
                        }
                    }
                }
            });
        }
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    /* access modifiers changed from: 0000 */
    public void callStartTransitionListener() {
        a aVar = this.mAnimationInfo;
        b bVar = null;
        if (aVar != null) {
            aVar.q = false;
            b bVar2 = aVar.r;
            aVar.r = null;
            bVar = bVar2;
        }
        if (bVar != null) {
            bVar.b();
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(targetFragment);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        if (getNextAnim() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(getNextAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (this.mInnerView != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(getStateAfterAnimating());
        }
        if (getContext() != null) {
            b.l.a.a.a(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        StringBuilder sb = new StringBuilder();
        sb.append("Child ");
        sb.append(this.mChildFragmentManager);
        sb.append(":");
        printWriter.println(sb.toString());
        C0207w wVar = this.mChildFragmentManager;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("  ");
        wVar.a(sb2.toString(), fileDescriptor, printWriter, strArr);
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* access modifiers changed from: 0000 */
    public Fragment findFragmentByWho(String str) {
        if (str.equals(this.mWho)) {
            return this;
        }
        return this.mChildFragmentManager.b(str);
    }

    public final C0195j getActivity() {
        C0199n nVar = this.mHost;
        if (nVar == null) {
            return null;
        }
        return (C0195j) nVar.b();
    }

    public boolean getAllowEnterTransitionOverlap() {
        a aVar = this.mAnimationInfo;
        if (aVar != null) {
            Boolean bool = aVar.n;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return true;
    }

    public boolean getAllowReturnTransitionOverlap() {
        a aVar = this.mAnimationInfo;
        if (aVar != null) {
            Boolean bool = aVar.m;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public View getAnimatingAway() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.f1432a;
    }

    /* access modifiers changed from: 0000 */
    public Animator getAnimator() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.f1433b;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final C0200o getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" has not been attached yet.");
        throw new IllegalStateException(sb.toString());
    }

    public Context getContext() {
        C0199n nVar = this.mHost;
        if (nVar == null) {
            return null;
        }
        return nVar.c();
    }

    public Object getEnterTransition() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.f1438g;
    }

    /* access modifiers changed from: 0000 */
    public androidx.core.app.n getEnterTransitionCallback() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.o;
    }

    public Object getExitTransition() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.f1440i;
    }

    /* access modifiers changed from: 0000 */
    public androidx.core.app.n getExitTransitionCallback() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.p;
    }

    public final C0200o getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        C0199n nVar = this.mHost;
        if (nVar == null) {
            return null;
        }
        return nVar.e();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    public h getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated
    public b.l.a.a getLoaderManager() {
        return b.l.a.a.a(this);
    }

    /* access modifiers changed from: 0000 */
    public int getNextAnim() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return 0;
        }
        return aVar.f1435d;
    }

    /* access modifiers changed from: 0000 */
    public int getNextTransition() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return 0;
        }
        return aVar.f1436e;
    }

    /* access modifiers changed from: 0000 */
    public int getNextTransitionStyle() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return 0;
        }
        return aVar.f1437f;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public Object getReenterTransition() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        Object obj = aVar.f1441j;
        if (obj == USE_DEFAULT_TRANSITION) {
            obj = getExitTransition();
        }
        return obj;
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        Object obj = aVar.f1439h;
        if (obj == USE_DEFAULT_TRANSITION) {
            obj = getEnterTransition();
        }
        return obj;
    }

    public final androidx.savedstate.a getSavedStateRegistry() {
        return this.mSavedStateRegistryController.a();
    }

    public Object getSharedElementEnterTransition() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.f1442k;
    }

    public Object getSharedElementReturnTransition() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        Object obj = aVar.f1443l;
        if (obj == USE_DEFAULT_TRANSITION) {
            obj = getSharedElementEnterTransition();
        }
        return obj;
    }

    /* access modifiers changed from: 0000 */
    public int getStateAfterAnimating() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return 0;
        }
        return aVar.f1434c;
    }

    public final String getString(int i2) {
        return getResources().getString(i2);
    }

    public final String getTag() {
        return this.mTag;
    }

    public final Fragment getTargetFragment() {
        Fragment fragment = this.mTarget;
        if (fragment != null) {
            return fragment;
        }
        C0207w wVar = this.mFragmentManager;
        if (wVar != null) {
            String str = this.mTargetWho;
            if (str != null) {
                return (Fragment) wVar.f1568j.get(str);
            }
        }
        return null;
    }

    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int i2) {
        return getResources().getText(i2);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public l getViewLifecycleOwner() {
        V v = this.mViewLifecycleOwner;
        if (v != null) {
            return v;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public LiveData<l> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    public F getViewModelStore() {
        C0207w wVar = this.mFragmentManager;
        if (wVar != null) {
            return wVar.h(this);
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    /* access modifiers changed from: 0000 */
    public void initState() {
        initLifecycle();
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new C0207w();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    /* access modifiers changed from: 0000 */
    public boolean isHideReplaced() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return false;
        }
        return aVar.s;
    }

    /* access modifiers changed from: 0000 */
    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        return this.mMenuVisible;
    }

    /* access modifiers changed from: 0000 */
    public boolean isPostponed() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return false;
        }
        return aVar.q;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isResumed() {
        return this.mState >= 4;
    }

    public final boolean isStateSaved() {
        C0207w wVar = this.mFragmentManager;
        if (wVar == null) {
            return false;
        }
        return wVar.x();
    }

    public final boolean isVisible() {
        if (isAdded() && !isHidden()) {
            View view = this.mView;
            if (!(view == null || view.getWindowToken() == null || this.mView.getVisibility() != 0)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public void noteStateNotSaved() {
        this.mChildFragmentManager.y();
    }

    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        C0199n nVar = this.mHost;
        Activity b2 = nVar == null ? null : nVar.b();
        if (b2 != null) {
            this.mCalled = false;
            onAttach(b2);
        }
    }

    public void onAttachFragment(Fragment fragment) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        if (!this.mChildFragmentManager.d(1)) {
            this.mChildFragmentManager.k();
        }
    }

    public Animation onCreateAnimation(int i2, boolean z, int i3) {
        return null;
    }

    public Animator onCreateAnimator(int i2, boolean z, int i3) {
        return null;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2 = this.mContentLayoutId;
        if (i2 != 0) {
            return layoutInflater.inflate(i2, viewGroup, false);
        }
        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public void onHiddenChanged(boolean z) {
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        C0199n nVar = this.mHost;
        Activity b2 = nVar == null ? null : nVar.b();
        if (b2 != null) {
            this.mCalled = false;
            onInflate(b2, attributeSet, bundle);
        }
    }

    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean z) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean z) {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z) {
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    /* access modifiers changed from: 0000 */
    public void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.y();
        this.mState = 2;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (this.mCalled) {
            this.mChildFragmentManager.j();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not call through to super.onActivityCreated()");
        throw new W(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    public void performAttach() {
        this.mChildFragmentManager.a(this.mHost, (C0196k) new C0193h(this), this);
        this.mCalled = false;
        onAttach(this.mHost.c());
        if (!this.mCalled) {
            StringBuilder sb = new StringBuilder();
            sb.append("Fragment ");
            sb.append(this);
            sb.append(" did not call through to super.onAttach()");
            throw new W(sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
        this.mChildFragmentManager.a(configuration);
    }

    /* access modifiers changed from: 0000 */
    public boolean performContextItemSelected(MenuItem menuItem) {
        if (this.mHidden || (!onContextItemSelected(menuItem) && !this.mChildFragmentManager.a(menuItem))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void performCreate(Bundle bundle) {
        this.mChildFragmentManager.y();
        this.mState = 1;
        this.mCalled = false;
        this.mSavedStateRegistryController.a(bundle);
        onCreate(bundle);
        this.mIsCreated = true;
        if (this.mCalled) {
            this.mLifecycleRegistry.b(androidx.lifecycle.h.a.ON_CREATE);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not call through to super.onCreate()");
        throw new W(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onCreateOptionsMenu(menu, menuInflater);
        }
        return z | this.mChildFragmentManager.a(menu, menuInflater);
    }

    /* access modifiers changed from: 0000 */
    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.y();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new V();
        this.mView = onCreateView(layoutInflater, viewGroup, bundle);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a();
            this.mViewLifecycleOwnerLiveData.b(this.mViewLifecycleOwner);
        } else if (!this.mViewLifecycleOwner.b()) {
            this.mViewLifecycleOwner = null;
        } else {
            throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
        }
    }

    /* access modifiers changed from: 0000 */
    public void performDestroy() {
        this.mChildFragmentManager.l();
        this.mLifecycleRegistry.b(androidx.lifecycle.h.a.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (!this.mCalled) {
            StringBuilder sb = new StringBuilder();
            sb.append("Fragment ");
            sb.append(this);
            sb.append(" did not call through to super.onDestroy()");
            throw new W(sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public void performDestroyView() {
        this.mChildFragmentManager.m();
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(androidx.lifecycle.h.a.ON_DESTROY);
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled) {
            b.l.a.a.a(this).a();
            this.mPerformedCreateView = false;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not call through to super.onDestroyView()");
        throw new W(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    public void performDetach() {
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (!this.mCalled) {
            StringBuilder sb = new StringBuilder();
            sb.append("Fragment ");
            sb.append(this);
            sb.append(" did not call through to super.onDetach()");
            throw new W(sb.toString());
        } else if (!this.mChildFragmentManager.f()) {
            this.mChildFragmentManager.l();
            this.mChildFragmentManager = new C0207w();
        }
    }

    /* access modifiers changed from: 0000 */
    public LayoutInflater performGetLayoutInflater(Bundle bundle) {
        this.mLayoutInflater = onGetLayoutInflater(bundle);
        return this.mLayoutInflater;
    }

    /* access modifiers changed from: 0000 */
    public void performLowMemory() {
        onLowMemory();
        this.mChildFragmentManager.n();
    }

    /* access modifiers changed from: 0000 */
    public void performMultiWindowModeChanged(boolean z) {
        onMultiWindowModeChanged(z);
        this.mChildFragmentManager.a(z);
    }

    /* access modifiers changed from: 0000 */
    public boolean performOptionsItemSelected(MenuItem menuItem) {
        if (this.mHidden || ((!this.mHasMenu || !this.mMenuVisible || !onOptionsItemSelected(menuItem)) && !this.mChildFragmentManager.b(menuItem))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void performOptionsMenuClosed(Menu menu) {
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible) {
                onOptionsMenuClosed(menu);
            }
            this.mChildFragmentManager.a(menu);
        }
    }

    /* access modifiers changed from: 0000 */
    public void performPause() {
        this.mChildFragmentManager.o();
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(androidx.lifecycle.h.a.ON_PAUSE);
        }
        this.mLifecycleRegistry.b(androidx.lifecycle.h.a.ON_PAUSE);
        this.mState = 3;
        this.mCalled = false;
        onPause();
        if (!this.mCalled) {
            StringBuilder sb = new StringBuilder();
            sb.append("Fragment ");
            sb.append(this);
            sb.append(" did not call through to super.onPause()");
            throw new W(sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public void performPictureInPictureModeChanged(boolean z) {
        onPictureInPictureModeChanged(z);
        this.mChildFragmentManager.b(z);
    }

    /* access modifiers changed from: 0000 */
    public boolean performPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onPrepareOptionsMenu(menu);
        }
        return z | this.mChildFragmentManager.b(menu);
    }

    /* access modifiers changed from: 0000 */
    public void performPrimaryNavigationFragmentChanged() {
        boolean j2 = this.mFragmentManager.j(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != j2) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(j2);
            onPrimaryNavigationFragmentChanged(j2);
            this.mChildFragmentManager.p();
        }
    }

    /* access modifiers changed from: 0000 */
    public void performResume() {
        this.mChildFragmentManager.y();
        this.mChildFragmentManager.u();
        this.mState = 4;
        this.mCalled = false;
        onResume();
        if (this.mCalled) {
            this.mLifecycleRegistry.b(androidx.lifecycle.h.a.ON_RESUME);
            if (this.mView != null) {
                this.mViewLifecycleOwner.a(androidx.lifecycle.h.a.ON_RESUME);
            }
            this.mChildFragmentManager.q();
            this.mChildFragmentManager.u();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not call through to super.onResume()");
        throw new W(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    public void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.b(bundle);
        Parcelable A = this.mChildFragmentManager.A();
        if (A != null) {
            bundle.putParcelable("android:support:fragments", A);
        }
    }

    /* access modifiers changed from: 0000 */
    public void performStart() {
        this.mChildFragmentManager.y();
        this.mChildFragmentManager.u();
        this.mState = 3;
        this.mCalled = false;
        onStart();
        if (this.mCalled) {
            this.mLifecycleRegistry.b(androidx.lifecycle.h.a.ON_START);
            if (this.mView != null) {
                this.mViewLifecycleOwner.a(androidx.lifecycle.h.a.ON_START);
            }
            this.mChildFragmentManager.r();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not call through to super.onStart()");
        throw new W(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    public void performStop() {
        this.mChildFragmentManager.s();
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(androidx.lifecycle.h.a.ON_STOP);
        }
        this.mLifecycleRegistry.b(androidx.lifecycle.h.a.ON_STOP);
        this.mState = 2;
        this.mCalled = false;
        onStop();
        if (!this.mCalled) {
            StringBuilder sb = new StringBuilder();
            sb.append("Fragment ");
            sb.append(this);
            sb.append(" did not call through to super.onStop()");
            throw new W(sb.toString());
        }
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().q = true;
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    public final void requestPermissions(String[] strArr, int i2) {
        C0199n nVar = this.mHost;
        if (nVar != null) {
            nVar.a(this, strArr, i2);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" not attached to Activity");
        throw new IllegalStateException(sb.toString());
    }

    public final C0195j requireActivity() {
        C0195j activity = getActivity();
        if (activity != null) {
            return activity;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" not attached to an activity.");
        throw new IllegalStateException(sb.toString());
    }

    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" does not have any arguments.");
        throw new IllegalStateException(sb.toString());
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" not attached to a context.");
        throw new IllegalStateException(sb.toString());
    }

    public final C0200o requireFragmentManager() {
        C0200o fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            return fragmentManager;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" not associated with a fragment manager.");
        throw new IllegalStateException(sb.toString());
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" not attached to a host.");
        throw new IllegalStateException(sb.toString());
    }

    public final Fragment requireParentFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        String str = "Fragment ";
        if (getContext() == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(this);
            sb.append(" is not attached to any Fragment or host");
            throw new IllegalStateException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(this);
        sb2.append(" is not a child Fragment, it is directly attached to ");
        sb2.append(getContext());
        throw new IllegalStateException(sb2.toString());
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not return a View from onCreateView() or this was called before onCreateView().");
        throw new IllegalStateException(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    public void restoreChildFragmentState(Bundle bundle) {
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null) {
                this.mChildFragmentManager.a(parcelable);
                this.mChildFragmentManager.k();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mInnerView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (!this.mCalled) {
            StringBuilder sb = new StringBuilder();
            sb.append("Fragment ");
            sb.append(this);
            sb.append(" did not call through to super.onViewStateRestored()");
            throw new W(sb.toString());
        } else if (this.mView != null) {
            this.mViewLifecycleOwner.a(androidx.lifecycle.h.a.ON_CREATE);
        }
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        ensureAnimationInfo().n = Boolean.valueOf(z);
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        ensureAnimationInfo().m = Boolean.valueOf(z);
    }

    /* access modifiers changed from: 0000 */
    public void setAnimatingAway(View view) {
        ensureAnimationInfo().f1432a = view;
    }

    /* access modifiers changed from: 0000 */
    public void setAnimator(Animator animator) {
        ensureAnimationInfo().f1433b = animator;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager == null || !isStateSaved()) {
            this.mArguments = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already added and state has been saved");
    }

    public void setEnterSharedElementCallback(androidx.core.app.n nVar) {
        ensureAnimationInfo().o = nVar;
    }

    public void setEnterTransition(Object obj) {
        ensureAnimationInfo().f1438g = obj;
    }

    public void setExitSharedElementCallback(androidx.core.app.n nVar) {
        ensureAnimationInfo().p = nVar;
    }

    public void setExitTransition(Object obj) {
        ensureAnimationInfo().f1440i = obj;
    }

    public void setHasOptionsMenu(boolean z) {
        if (this.mHasMenu != z) {
            this.mHasMenu = z;
            if (isAdded() && !isHidden()) {
                this.mHost.i();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void setHideReplaced(boolean z) {
        ensureAnimationInfo().s = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        if (r2 != null) goto L_0x000c;
     */
    public void setInitialSavedState(c cVar) {
        Bundle bundle;
        if (this.mFragmentManager == null) {
            if (cVar != null) {
                bundle = cVar.f1444a;
            }
            bundle = null;
            this.mSavedFragmentState = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already added");
    }

    public void setMenuVisibility(boolean z) {
        if (this.mMenuVisible != z) {
            this.mMenuVisible = z;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                this.mHost.i();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void setNextAnim(int i2) {
        if (this.mAnimationInfo != null || i2 != 0) {
            ensureAnimationInfo().f1435d = i2;
        }
    }

    /* access modifiers changed from: 0000 */
    public void setNextTransition(int i2, int i3) {
        if (this.mAnimationInfo != null || i2 != 0 || i3 != 0) {
            ensureAnimationInfo();
            a aVar = this.mAnimationInfo;
            aVar.f1436e = i2;
            aVar.f1437f = i3;
        }
    }

    /* access modifiers changed from: 0000 */
    public void setOnStartEnterTransitionListener(b bVar) {
        ensureAnimationInfo();
        b bVar2 = this.mAnimationInfo.r;
        if (bVar != bVar2) {
            if (bVar == null || bVar2 == null) {
                a aVar = this.mAnimationInfo;
                if (aVar.q) {
                    aVar.r = bVar;
                }
                if (bVar != null) {
                    bVar.a();
                }
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Trying to set a replacement startPostponedEnterTransition on ");
            sb.append(this);
            throw new IllegalStateException(sb.toString());
        }
    }

    public void setReenterTransition(Object obj) {
        ensureAnimationInfo().f1441j = obj;
    }

    public void setRetainInstance(boolean z) {
        this.mRetainInstance = z;
        C0207w wVar = this.mFragmentManager;
        if (wVar == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z) {
            wVar.b(this);
        } else {
            wVar.q(this);
        }
    }

    public void setReturnTransition(Object obj) {
        ensureAnimationInfo().f1439h = obj;
    }

    public void setSharedElementEnterTransition(Object obj) {
        ensureAnimationInfo().f1442k = obj;
    }

    public void setSharedElementReturnTransition(Object obj) {
        ensureAnimationInfo().f1443l = obj;
    }

    /* access modifiers changed from: 0000 */
    public void setStateAfterAnimating(int i2) {
        ensureAnimationInfo().f1434c = i2;
    }

    public void setTargetFragment(Fragment fragment, int i2) {
        C0200o fragmentManager = getFragmentManager();
        C0200o fragmentManager2 = fragment != null ? fragment.getFragmentManager() : null;
        if (fragmentManager == null || fragmentManager2 == null || fragmentManager == fragmentManager2) {
            Fragment fragment2 = fragment;
            while (fragment2 != null) {
                if (fragment2 != this) {
                    fragment2 = fragment2.getTargetFragment();
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Setting ");
                    sb.append(fragment);
                    sb.append(" as the target of ");
                    sb.append(this);
                    sb.append(" would create a target cycle");
                    throw new IllegalArgumentException(sb.toString());
                }
            }
            if (fragment == null) {
                this.mTargetWho = null;
                this.mTarget = null;
            } else if (this.mFragmentManager == null || fragment.mFragmentManager == null) {
                this.mTargetWho = null;
                this.mTarget = fragment;
            } else {
                this.mTargetWho = fragment.mWho;
                this.mTarget = null;
            }
            this.mTargetRequestCode = i2;
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Fragment ");
        sb2.append(fragment);
        sb2.append(" must share the same FragmentManager to be set as a target fragment");
        throw new IllegalArgumentException(sb2.toString());
    }

    @Deprecated
    public void setUserVisibleHint(boolean z) {
        if (!this.mUserVisibleHint && z && this.mState < 3 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            this.mFragmentManager.o(this);
        }
        this.mUserVisibleHint = z;
        this.mDeferStart = this.mState < 3 && !z;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z);
        }
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        C0199n nVar = this.mHost;
        if (nVar != null) {
            return nVar.a(str);
        }
        return false;
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent) {
        startActivity(intent, null);
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2) {
        startActivityForResult(intent, i2, null);
    }

    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws SendIntentException {
        C0199n nVar = this.mHost;
        if (nVar != null) {
            nVar.a(this, intentSender, i2, intent, i3, i4, i5, bundle);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" not attached to Activity");
        throw new IllegalStateException(sb.toString());
    }

    public void startPostponedEnterTransition() {
        C0207w wVar = this.mFragmentManager;
        if (wVar == null || wVar.t == null) {
            ensureAnimationInfo().q = false;
        } else if (Looper.myLooper() != this.mFragmentManager.t.d().getLooper()) {
            this.mFragmentManager.t.d().postAtFrontOfQueue(new C0192g(this));
        } else {
            callStartTransitionListener();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        b.g.h.a.a(this, sb);
        sb.append(" (");
        sb.append(this.mWho);
        sb.append(")");
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" ");
            sb.append(this.mTag);
        }
        sb.append('}');
        return sb.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str, Bundle bundle) {
        String str2 = ": make sure class name exists, is public, and has an empty constructor that is public";
        String str3 = "Unable to instantiate fragment ";
        try {
            Fragment fragment = (Fragment) C0198m.c(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.setArguments(bundle);
            }
            return fragment;
        } catch (InstantiationException e2) {
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append(str);
            sb.append(str2);
            throw new InstantiationException(sb.toString(), e2);
        } catch (IllegalAccessException e3) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(str);
            sb2.append(str2);
            throw new InstantiationException(sb2.toString(), e3);
        } catch (NoSuchMethodException e4) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str3);
            sb3.append(str);
            sb3.append(": could not find Fragment constructor");
            throw new InstantiationException(sb3.toString(), e4);
        } catch (InvocationTargetException e5) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str3);
            sb4.append(str);
            sb4.append(": calling Fragment constructor caused an exception");
            throw new InstantiationException(sb4.toString(), e5);
        }
    }

    public final String getString(int i2, Object... objArr) {
        return getResources().getString(i2, objArr);
    }

    public final void postponeEnterTransition(long j2, TimeUnit timeUnit) {
        Handler handler;
        ensureAnimationInfo().q = true;
        C0207w wVar = this.mFragmentManager;
        if (wVar != null) {
            handler = wVar.t.d();
        } else {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.removeCallbacks(this.mPostponedDurationRunnable);
        handler.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j2));
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent, Bundle bundle) {
        C0199n nVar = this.mHost;
        if (nVar != null) {
            nVar.a(this, intent, -1, bundle);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" not attached to Activity");
        throw new IllegalStateException(sb.toString());
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        C0199n nVar = this.mHost;
        if (nVar != null) {
            nVar.a(this, intent, i2, bundle);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" not attached to Activity");
        throw new IllegalStateException(sb.toString());
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        C0199n nVar = this.mHost;
        if (nVar != null) {
            LayoutInflater f2 = nVar.f();
            C0207w wVar = this.mChildFragmentManager;
            wVar.v();
            C0245f.a(f2, wVar);
            return f2;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }

    public Fragment(int i2) {
        this();
        this.mContentLayoutId = i2;
    }
}
