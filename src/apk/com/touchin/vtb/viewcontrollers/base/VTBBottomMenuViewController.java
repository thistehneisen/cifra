package com.touchin.vtb.viewcontrollers.base;

import android.animation.ObjectAnimator;
import android.graphics.Rect;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.n;
import com.touchin.vtb.R;
import com.touchin.vtb.activities.c;
import com.touchin.vtb.utils.o;
import com.touchin.vtb.views.InterceptLinearLayout;
import kotlin.e.b.h;
import l.a.d.a.b.a.C0122a;

/* compiled from: VTBBottomMenuViewController.kt */
public class VTBBottomMenuViewController<TActivity extends c, TState extends Parcelable> extends VTBViewController<TActivity, TState> {
    private static final long ANIMATION_DURATION = 300;
    private static final float BOTTOM_MENU_SIZE_DP = 72.0f;
    private static final float BOTTOM_MENU_TASKS_HIDING_COEF = 0.65f;
    public static final a Companion = new a(null);
    private final o animatorListener = new o(new d(this), new e(this));
    /* access modifiers changed from: private */
    public InterceptLinearLayout bottomMenu;
    private float bottomMenuHeightPixels = C0122a.a(getActivity(), BOTTOM_MENU_SIZE_DP);
    private float bottomMenuYTopPosition;
    private int bottomYPosition;
    /* access modifiers changed from: private */
    public boolean isAnimationGoing;

    /* compiled from: VTBBottomMenuViewController.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    public VTBBottomMenuViewController(ru.touchin.roboswag.components.navigation.viewcontrollers.c.a aVar, int i2) {
        h.b(aVar, "creationContext");
        super(aVar, i2);
        View findViewById = ((c) getActivity()).getWindow().findViewById(R.id.main_navigation_container);
        h.a((Object) findViewById, "activity.window.findView…ain_navigation_container)");
        this.bottomMenu = (InterceptLinearLayout) findViewById;
    }

    public static /* synthetic */ void addBottomMenuAnimation$default(VTBBottomMenuViewController vTBBottomMenuViewController, RecyclerView recyclerView, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            vTBBottomMenuViewController.addBottomMenuAnimation(recyclerView, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addBottomMenuAnimation");
    }

    private final float getBottomMenuOffset(boolean z) {
        return z ? this.bottomMenuHeightPixels * BOTTOM_MENU_TASKS_HIDING_COEF : this.bottomMenuHeightPixels;
    }

    private final void initBottomMenuPositions() {
        Rect rect = new Rect();
        Window window = ((c) getActivity()).getWindow();
        h.a((Object) window, "activity.window");
        window.getDecorView().getWindowVisibleDisplayFrame(rect);
        this.bottomYPosition = rect.bottom;
        this.bottomMenuYTopPosition = ((float) this.bottomYPosition) - C0122a.a(getActivity(), BOTTOM_MENU_SIZE_DP);
    }

    public final void addBottomMenuAnimation(RecyclerView recyclerView, boolean z) {
        h.b(recyclerView, "recyclerView");
        initBottomMenuPositions();
        recyclerView.a((n) new c(this, z));
    }

    public final void hideBottomMenu(boolean z) {
        if (!this.isAnimationGoing) {
            if (this.bottomYPosition == 0) {
                initBottomMenuPositions();
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bottomMenu, View.TRANSLATION_Y, new float[]{getBottomMenuOffset(z)});
            if (z) {
                this.bottomMenu.setNeedToInterceptTouch(true);
                this.bottomMenu.setOnClickListener(new f(this));
            }
            h.a((Object) ofFloat, "animator");
            ofFloat.setDuration(ANIMATION_DURATION);
            ofFloat.start();
            this.isAnimationGoing = true;
            ofFloat.addListener(this.animatorListener);
        }
    }

    public void onStop() {
        super.onStop();
        showBottomMenu();
    }

    public final void showBottomMenu() {
        if (!this.isAnimationGoing) {
            if (this.bottomYPosition == 0) {
                initBottomMenuPositions();
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bottomMenu, View.TRANSLATION_Y, new float[]{0.0f});
            h.a((Object) ofFloat, "animator");
            ofFloat.setDuration(ANIMATION_DURATION);
            ofFloat.addListener(this.animatorListener);
            ofFloat.start();
        }
    }
}
