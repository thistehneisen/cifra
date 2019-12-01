package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.c;
import androidx.activity.e;
import androidx.core.app.b;
import androidx.core.app.b.C0009b;
import androidx.lifecycle.F;
import androidx.lifecycle.G;
import androidx.lifecycle.h;
import androidx.lifecycle.n;
import b.d.j;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: androidx.fragment.app.j reason: case insensitive filesystem */
/* compiled from: FragmentActivity */
public class C0195j extends c implements androidx.core.app.b.a, b.c {
    static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
    static final String FRAGMENTS_TAG = "android:support:fragments";
    static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
    static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
    static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
    private static final String TAG = "FragmentActivity";
    boolean mCreated;
    final n mFragmentLifecycleRegistry = new n(this);
    final C0197l mFragments = C0197l.a((C0199n<?>) new a<Object>());
    int mNextCandidateRequestIndex;
    j<String> mPendingFragmentActivityResults;
    boolean mRequestedPermissionsFromFragment;
    boolean mResumed;
    boolean mStartedActivityFromFragment;
    boolean mStartedIntentSenderFromFragment;
    boolean mStopped = true;

    /* renamed from: androidx.fragment.app.j$a */
    /* compiled from: FragmentActivity */
    class a extends C0199n<C0195j> implements G, e {
        public a() {
            super(C0195j.this);
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            C0195j.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        public boolean b(Fragment fragment) {
            return !C0195j.this.isFinishing();
        }

        public LayoutInflater f() {
            return C0195j.this.getLayoutInflater().cloneInContext(C0195j.this);
        }

        public int g() {
            Window window = C0195j.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        public h getLifecycle() {
            return C0195j.this.mFragmentLifecycleRegistry;
        }

        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return C0195j.this.getOnBackPressedDispatcher();
        }

        public F getViewModelStore() {
            return C0195j.this.getViewModelStore();
        }

        public boolean h() {
            return C0195j.this.getWindow() != null;
        }

        public void i() {
            C0195j.this.supportInvalidateOptionsMenu();
        }

        public void a(Fragment fragment, Intent intent, int i2, Bundle bundle) {
            C0195j.this.startActivityFromFragment(fragment, intent, i2, bundle);
        }

        public C0195j e() {
            return C0195j.this;
        }

        public void a(Fragment fragment, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws SendIntentException {
            C0195j.this.startIntentSenderFromFragment(fragment, intentSender, i2, intent, i3, i4, i5, bundle);
        }

        public void a(Fragment fragment, String[] strArr, int i2) {
            C0195j.this.requestPermissionsFromFragment(fragment, strArr, i2);
        }

        public boolean a(String str) {
            return b.a((Activity) C0195j.this, str);
        }

        public void a(Fragment fragment) {
            C0195j.this.onAttachFragment(fragment);
        }

        public View a(int i2) {
            return C0195j.this.findViewById(i2);
        }

        public boolean a() {
            Window window = C0195j.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }

    public C0195j() {
    }

    private int allocateRequestIndex(Fragment fragment) {
        if (this.mPendingFragmentActivityResults.b() < MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS) {
            while (this.mPendingFragmentActivityResults.b(this.mNextCandidateRequestIndex) >= 0) {
                this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
            }
            int i2 = this.mNextCandidateRequestIndex;
            this.mPendingFragmentActivityResults.c(i2, fragment.mWho);
            this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
            return i2;
        }
        throw new IllegalStateException("Too many pending Fragment activity results.");
    }

    static void checkForValidRequestCode(int i2) {
        if ((i2 & -65536) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    private void markFragmentsCreated() {
        do {
        } while (markState(getSupportFragmentManager(), h.b.CREATED));
    }

    private static boolean markState(C0200o oVar, h.b bVar) {
        boolean z = false;
        for (Fragment fragment : oVar.d()) {
            if (fragment != null) {
                if (fragment.getLifecycle().a().a(h.b.STARTED)) {
                    fragment.mLifecycleRegistry.b(bVar);
                    z = true;
                }
                if (fragment.getHost() != null) {
                    z |= markState(fragment.getChildFragmentManager(), bVar);
                }
            }
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.a(view, str, context, attributeSet);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("  ");
        String sb2 = sb.toString();
        printWriter.print(sb2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            b.l.a.a.a(this).a(sb2, fileDescriptor, printWriter, strArr);
        }
        this.mFragments.j().a(str, fileDescriptor, printWriter, strArr);
    }

    public C0200o getSupportFragmentManager() {
        return this.mFragments.j();
    }

    @Deprecated
    public b.l.a.a getSupportLoaderManager() {
        return b.l.a.a.a(this);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        this.mFragments.k();
        int i4 = i2 >> 16;
        if (i4 != 0) {
            int i5 = i4 - 1;
            String str = (String) this.mPendingFragmentActivityResults.a(i5);
            this.mPendingFragmentActivityResults.d(i5);
            String str2 = TAG;
            if (str == null) {
                Log.w(str2, "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment a2 = this.mFragments.a(str);
            if (a2 == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Activity result no fragment exists for who: ");
                sb.append(str);
                Log.w(str2, sb.toString());
            } else {
                a2.onActivityResult(i2 & 65535, i3, intent);
            }
            return;
        }
        C0009b a3 = b.a();
        if (a3 == null || !a3.a(this, i2, i3, intent)) {
            super.onActivityResult(i2, i3, intent);
        }
    }

    public void onAttachFragment(Fragment fragment) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFragments.k();
        this.mFragments.a(configuration);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        this.mFragments.a((Fragment) null);
        if (bundle != null) {
            this.mFragments.a(bundle.getParcelable(FRAGMENTS_TAG));
            String str = NEXT_CANDIDATE_REQUEST_INDEX_TAG;
            if (bundle.containsKey(str)) {
                this.mNextCandidateRequestIndex = bundle.getInt(str);
                int[] intArray = bundle.getIntArray(ALLOCATED_REQUEST_INDICIES_TAG);
                String[] stringArray = bundle.getStringArray(REQUEST_FRAGMENT_WHO_TAG);
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w(TAG, "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.mPendingFragmentActivityResults = new j<>(intArray.length);
                    for (int i2 = 0; i2 < intArray.length; i2++) {
                        this.mPendingFragmentActivityResults.c(intArray[i2], stringArray[i2]);
                    }
                }
            }
        }
        if (this.mPendingFragmentActivityResults == null) {
            this.mPendingFragmentActivityResults = new j<>();
            this.mNextCandidateRequestIndex = 0;
        }
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.b(androidx.lifecycle.h.a.ON_CREATE);
        this.mFragments.b();
    }

    public boolean onCreatePanelMenu(int i2, Menu menu) {
        if (i2 == 0) {
            return super.onCreatePanelMenu(i2, menu) | this.mFragments.a(menu, getMenuInflater());
        }
        return super.onCreatePanelMenu(i2, menu);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.c();
        this.mFragmentLifecycleRegistry.b(androidx.lifecycle.h.a.ON_DESTROY);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.d();
    }

    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 == 0) {
            return this.mFragments.b(menuItem);
        }
        if (i2 != 6) {
            return false;
        }
        return this.mFragments.a(menuItem);
    }

    public void onMultiWindowModeChanged(boolean z) {
        this.mFragments.a(z);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.k();
    }

    public void onPanelClosed(int i2, Menu menu) {
        if (i2 == 0) {
            this.mFragments.a(menu);
        }
        super.onPanelClosed(i2, menu);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.e();
        this.mFragmentLifecycleRegistry.b(androidx.lifecycle.h.a.ON_PAUSE);
    }

    public void onPictureInPictureModeChanged(boolean z) {
        this.mFragments.b(z);
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public boolean onPreparePanel(int i2, View view, Menu menu) {
        if (i2 == 0) {
            return onPrepareOptionsPanel(view, menu) | this.mFragments.b(menu);
        }
        return super.onPreparePanel(i2, view, menu);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        this.mFragments.k();
        int i3 = (i2 >> 16) & 65535;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String str = (String) this.mPendingFragmentActivityResults.a(i4);
            this.mPendingFragmentActivityResults.d(i4);
            String str2 = TAG;
            if (str == null) {
                Log.w(str2, "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment a2 = this.mFragments.a(str);
            if (a2 == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Activity result no fragment exists for who: ");
                sb.append(str);
                Log.w(str2, sb.toString());
            } else {
                a2.onRequestPermissionsResult(i2 & 65535, strArr, iArr);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.mResumed = true;
        this.mFragments.k();
        this.mFragments.i();
    }

    /* access modifiers changed from: protected */
    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.b(androidx.lifecycle.h.a.ON_RESUME);
        this.mFragments.f();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        markFragmentsCreated();
        this.mFragmentLifecycleRegistry.b(androidx.lifecycle.h.a.ON_STOP);
        Parcelable l2 = this.mFragments.l();
        if (l2 != null) {
            bundle.putParcelable(FRAGMENTS_TAG, l2);
        }
        if (this.mPendingFragmentActivityResults.b() > 0) {
            bundle.putInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG, this.mNextCandidateRequestIndex);
            int[] iArr = new int[this.mPendingFragmentActivityResults.b()];
            String[] strArr = new String[this.mPendingFragmentActivityResults.b()];
            for (int i2 = 0; i2 < this.mPendingFragmentActivityResults.b(); i2++) {
                iArr[i2] = this.mPendingFragmentActivityResults.c(i2);
                strArr[i2] = (String) this.mPendingFragmentActivityResults.e(i2);
            }
            bundle.putIntArray(ALLOCATED_REQUEST_INDICIES_TAG, iArr);
            bundle.putStringArray(REQUEST_FRAGMENT_WHO_TAG, strArr);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.a();
        }
        this.mFragments.k();
        this.mFragments.i();
        this.mFragmentLifecycleRegistry.b(androidx.lifecycle.h.a.ON_START);
        this.mFragments.g();
    }

    public void onStateNotSaved() {
        this.mFragments.k();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.h();
        this.mFragmentLifecycleRegistry.b(androidx.lifecycle.h.a.ON_STOP);
    }

    /* access modifiers changed from: 0000 */
    public void requestPermissionsFromFragment(Fragment fragment, String[] strArr, int i2) {
        if (i2 == -1) {
            b.a(this, strArr, i2);
            return;
        }
        checkForValidRequestCode(i2);
        try {
            this.mRequestedPermissionsFromFragment = true;
            b.a(this, strArr, ((allocateRequestIndex(fragment) + 1) << 16) + (i2 & 65535));
        } finally {
            this.mRequestedPermissionsFromFragment = false;
        }
    }

    public void setEnterSharedElementCallback(androidx.core.app.n nVar) {
        b.a((Activity) this, nVar);
    }

    public void setExitSharedElementCallback(androidx.core.app.n nVar) {
        b.b(this, nVar);
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2) {
        if (!this.mStartedActivityFromFragment && i2 != -1) {
            checkForValidRequestCode(i2);
        }
        super.startActivityForResult(intent, i2);
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2) {
        startActivityFromFragment(fragment, intent, i2, null);
    }

    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) throws SendIntentException {
        if (!this.mStartedIntentSenderFromFragment && i2 != -1) {
            checkForValidRequestCode(i2);
        }
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
    }

    public void startIntentSenderFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws SendIntentException {
        int i6 = i2;
        this.mStartedIntentSenderFromFragment = true;
        if (i6 == -1) {
            try {
                b.a(this, intentSender, i2, intent, i3, i4, i5, bundle);
            } finally {
                this.mStartedIntentSenderFromFragment = false;
            }
        } else {
            checkForValidRequestCode(i2);
            b.a(this, intentSender, ((allocateRequestIndex(fragment) + 1) << 16) + (i6 & 65535), intent, i3, i4, i5, bundle);
            this.mStartedIntentSenderFromFragment = false;
        }
    }

    public void supportFinishAfterTransition() {
        b.b(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        b.d(this);
    }

    public void supportStartPostponedEnterTransition() {
        b.e(this);
    }

    public final void validateRequestPermissionsRequestCode(int i2) {
        if (!this.mRequestedPermissionsFromFragment && i2 != -1) {
            checkForValidRequestCode(i2);
        }
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        this.mStartedActivityFromFragment = true;
        if (i2 == -1) {
            try {
                b.a(this, intent, -1, bundle);
            } finally {
                this.mStartedActivityFromFragment = false;
            }
        } else {
            checkForValidRequestCode(i2);
            b.a(this, intent, ((allocateRequestIndex(fragment) + 1) << 16) + (i2 & 65535), bundle);
            this.mStartedActivityFromFragment = false;
        }
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        if (!this.mStartedActivityFromFragment && i2 != -1) {
            checkForValidRequestCode(i2);
        }
        super.startActivityForResult(intent, i2, bundle);
    }

    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws SendIntentException {
        if (!this.mStartedIntentSenderFromFragment && i2 != -1) {
            checkForValidRequestCode(i2);
        }
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
    }

    public C0195j(int i2) {
        super(i2);
    }
}
