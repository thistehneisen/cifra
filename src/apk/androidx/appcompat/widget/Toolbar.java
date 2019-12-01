package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.C0134a.C0006a;
import androidx.appcompat.view.menu.D;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.widget.ActionMenuView.e;
import b.a.d.g;
import b.a.j;
import b.g.i.B;
import b.g.i.C0243d;
import b.g.i.C0246g;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private static final String TAG = "Toolbar";
    private androidx.appcompat.view.menu.v.a mActionMenuPresenterCallback;
    int mButtonGravity;
    ImageButton mCollapseButtonView;
    private CharSequence mCollapseDescription;
    private Drawable mCollapseIcon;
    private boolean mCollapsible;
    private int mContentInsetEndWithActions;
    private int mContentInsetStartWithNavigation;
    private W mContentInsets;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    View mExpandedActionView;
    private a mExpandedMenuPresenter;
    private int mGravity;
    private final ArrayList<View> mHiddenViews;
    private ImageView mLogoView;
    private int mMaxButtonHeight;
    private androidx.appcompat.view.menu.l.a mMenuBuilderCallback;
    private ActionMenuView mMenuView;
    private final e mMenuViewItemClickListener;
    private ImageButton mNavButtonView;
    c mOnMenuItemClickListener;
    private C0165g mOuterActionMenuPresenter;
    private Context mPopupContext;
    private int mPopupTheme;
    private final Runnable mShowOverflowMenuRunnable;
    private CharSequence mSubtitleText;
    private int mSubtitleTextAppearance;
    private int mSubtitleTextColor;
    private TextView mSubtitleTextView;
    private final int[] mTempMargins;
    private final ArrayList<View> mTempViews;
    private int mTitleMarginBottom;
    private int mTitleMarginEnd;
    private int mTitleMarginStart;
    private int mTitleMarginTop;
    private CharSequence mTitleText;
    private int mTitleTextAppearance;
    private int mTitleTextColor;
    private TextView mTitleTextView;
    private za mWrapper;

    private class a implements v {

        /* renamed from: a reason: collision with root package name */
        l f897a;

        /* renamed from: b reason: collision with root package name */
        p f898b;

        a() {
        }

        public void a(Context context, l lVar) {
            l lVar2 = this.f897a;
            if (lVar2 != null) {
                p pVar = this.f898b;
                if (pVar != null) {
                    lVar2.a(pVar);
                }
            }
            this.f897a = lVar;
        }

        public void a(l lVar, boolean z) {
        }

        public boolean a() {
            return false;
        }

        public boolean a(D d2) {
            return false;
        }

        public boolean b(l lVar, p pVar) {
            Toolbar.this.ensureCollapseButtonView();
            ViewParent parent = Toolbar.this.mCollapseButtonView.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.mCollapseButtonView);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.mCollapseButtonView);
            }
            Toolbar.this.mExpandedActionView = pVar.getActionView();
            this.f898b = pVar;
            ViewParent parent2 = Toolbar.this.mExpandedActionView.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.mExpandedActionView);
                }
                b generateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                generateDefaultLayoutParams.f471a = 8388611 | (toolbar4.mButtonGravity & 112);
                generateDefaultLayoutParams.f900b = 2;
                toolbar4.mExpandedActionView.setLayoutParams(generateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.mExpandedActionView);
            }
            Toolbar.this.removeChildrenForExpandedActionView();
            Toolbar.this.requestLayout();
            pVar.a(true);
            View view = Toolbar.this.mExpandedActionView;
            if (view instanceof b.a.d.c) {
                ((b.a.d.c) view).onActionViewExpanded();
            }
            return true;
        }

        public void a(boolean z) {
            if (this.f898b != null) {
                l lVar = this.f897a;
                boolean z2 = false;
                if (lVar != null) {
                    int size = lVar.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (this.f897a.getItem(i2) == this.f898b) {
                            z2 = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                if (!z2) {
                    a(this.f897a, this.f898b);
                }
            }
        }

        public boolean a(l lVar, p pVar) {
            View view = Toolbar.this.mExpandedActionView;
            if (view instanceof b.a.d.c) {
                ((b.a.d.c) view).onActionViewCollapsed();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.mExpandedActionView);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.mCollapseButtonView);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.mExpandedActionView = null;
            toolbar3.addChildrenForExpandedActionView();
            this.f898b = null;
            Toolbar.this.requestLayout();
            pVar.a(false);
            return true;
        }
    }

    public static class b extends C0006a {

        /* renamed from: b reason: collision with root package name */
        int f900b;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f900b = 0;
        }

        /* access modifiers changed from: 0000 */
        public void a(MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }

        public b(int i2, int i3) {
            super(i2, i3);
            this.f900b = 0;
            this.f471a = 8388627;
        }

        public b(b bVar) {
            super((C0006a) bVar);
            this.f900b = 0;
            this.f900b = bVar.f900b;
        }

        public b(C0006a aVar) {
            super(aVar);
            this.f900b = 0;
        }

        public b(MarginLayoutParams marginLayoutParams) {
            super((LayoutParams) marginLayoutParams);
            this.f900b = 0;
            a(marginLayoutParams);
        }

        public b(LayoutParams layoutParams) {
            super(layoutParams);
            this.f900b = 0;
        }
    }

    public interface c {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public static class d extends b.i.a.c {
        public static final Creator<d> CREATOR = new wa();

        /* renamed from: c reason: collision with root package name */
        int f901c;

        /* renamed from: d reason: collision with root package name */
        boolean f902d;

        public d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f901c = parcel.readInt();
            this.f902d = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f901c);
            parcel.writeInt(this.f902d ? 1 : 0);
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    private void addCustomViewsWithGravity(List<View> list, int i2) {
        boolean z = B.m(this) == 1;
        int childCount = getChildCount();
        int a2 = C0243d.a(i2, B.m(this));
        list.clear();
        if (z) {
            for (int i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                b bVar = (b) childAt.getLayoutParams();
                if (bVar.f900b == 0 && shouldLayout(childAt) && getChildHorizontalGravity(bVar.f471a) == a2) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt2 = getChildAt(i4);
            b bVar2 = (b) childAt2.getLayoutParams();
            if (bVar2.f900b == 0 && shouldLayout(childAt2) && getChildHorizontalGravity(bVar2.f471a) == a2) {
                list.add(childAt2);
            }
        }
    }

    private void addSystemView(View view, boolean z) {
        b bVar;
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            bVar = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams)) {
            bVar = generateLayoutParams(layoutParams);
        } else {
            bVar = (b) layoutParams;
        }
        bVar.f900b = 1;
        if (!z || this.mExpandedActionView == null) {
            addView(view, bVar);
            return;
        }
        view.setLayoutParams(bVar);
        this.mHiddenViews.add(view);
    }

    private void ensureContentInsets() {
        if (this.mContentInsets == null) {
            this.mContentInsets = new W();
        }
    }

    private void ensureLogoView() {
        if (this.mLogoView == null) {
            this.mLogoView = new AppCompatImageView(getContext());
        }
    }

    private void ensureMenu() {
        ensureMenuView();
        if (this.mMenuView.h() == null) {
            l lVar = (l) this.mMenuView.getMenu();
            if (this.mExpandedMenuPresenter == null) {
                this.mExpandedMenuPresenter = new a();
            }
            this.mMenuView.setExpandedActionViewsExclusive(true);
            lVar.a((v) this.mExpandedMenuPresenter, this.mPopupContext);
        }
    }

    private void ensureMenuView() {
        if (this.mMenuView == null) {
            this.mMenuView = new ActionMenuView(getContext());
            this.mMenuView.setPopupTheme(this.mPopupTheme);
            this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
            this.mMenuView.a(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
            b generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f471a = 8388613 | (this.mButtonGravity & 112);
            this.mMenuView.setLayoutParams(generateDefaultLayoutParams);
            addSystemView(this.mMenuView, false);
        }
    }

    private void ensureNavButtonView() {
        if (this.mNavButtonView == null) {
            this.mNavButtonView = new r(getContext(), null, b.a.a.toolbarNavigationButtonStyle);
            b generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f471a = 8388611 | (this.mButtonGravity & 112);
            this.mNavButtonView.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    private int getChildHorizontalGravity(int i2) {
        int m = B.m(this);
        int a2 = C0243d.a(i2, m) & 7;
        if (a2 != 1) {
            int i3 = 3;
            if (!(a2 == 3 || a2 == 5)) {
                if (m == 1) {
                    i3 = 5;
                }
                return i3;
            }
        }
        return a2;
    }

    private int getChildTop(View view, int i2) {
        b bVar = (b) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i3 = i2 > 0 ? (measuredHeight - i2) / 2 : 0;
        int childVerticalGravity = getChildVerticalGravity(bVar.f471a);
        if (childVerticalGravity == 48) {
            return getPaddingTop() - i3;
        }
        if (childVerticalGravity == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - bVar.bottomMargin) - i3;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i4 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i5 = bVar.topMargin;
        if (i4 < i5) {
            i4 = i5;
        } else {
            int i6 = (((height - paddingBottom) - measuredHeight) - i4) - paddingTop;
            int i7 = bVar.bottomMargin;
            if (i6 < i7) {
                i4 = Math.max(0, i4 - (i7 - i6));
            }
        }
        return paddingTop + i4;
    }

    private int getChildVerticalGravity(int i2) {
        int i3 = i2 & 112;
        return (i3 == 16 || i3 == 48 || i3 == 80) ? i3 : this.mGravity & 112;
    }

    private int getHorizontalMargins(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return C0246g.b(marginLayoutParams) + C0246g.a(marginLayoutParams);
    }

    private MenuInflater getMenuInflater() {
        return new g(getContext());
    }

    private int getVerticalMargins(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int getViewListMeasuredWidth(List<View> list, int[] iArr) {
        int i2 = iArr[0];
        int i3 = iArr[1];
        int size = list.size();
        int i4 = i3;
        int i5 = i2;
        int i6 = 0;
        int i7 = 0;
        while (i6 < size) {
            View view = (View) list.get(i6);
            b bVar = (b) view.getLayoutParams();
            int i8 = bVar.leftMargin - i5;
            int i9 = bVar.rightMargin - i4;
            int max = Math.max(0, i8);
            int max2 = Math.max(0, i9);
            int max3 = Math.max(0, -i8);
            i7 += max + view.getMeasuredWidth() + max2;
            i6++;
            i4 = Math.max(0, -i9);
            i5 = max3;
        }
        return i7;
    }

    private boolean isChildOrHidden(View view) {
        return view.getParent() == this || this.mHiddenViews.contains(view);
    }

    private static boolean isCustomView(View view) {
        return ((b) view.getLayoutParams()).f900b == 0;
    }

    private int layoutChildLeft(View view, int i2, int[] iArr, int i3) {
        b bVar = (b) view.getLayoutParams();
        int i4 = bVar.leftMargin - iArr[0];
        int max = i2 + Math.max(0, i4);
        iArr[0] = Math.max(0, -i4);
        int childTop = getChildTop(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, childTop, max + measuredWidth, view.getMeasuredHeight() + childTop);
        return max + measuredWidth + bVar.rightMargin;
    }

    private int layoutChildRight(View view, int i2, int[] iArr, int i3) {
        b bVar = (b) view.getLayoutParams();
        int i4 = bVar.rightMargin - iArr[1];
        int max = i2 - Math.max(0, i4);
        iArr[1] = Math.max(0, -i4);
        int childTop = getChildTop(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, childTop, max, view.getMeasuredHeight() + childTop);
        return max - (measuredWidth + bVar.leftMargin);
    }

    private int measureChildCollapseMargins(View view, int i2, int i3, int i4, int i5, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i6 = marginLayoutParams.leftMargin - iArr[0];
        int i7 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i6) + Math.max(0, i7);
        iArr[0] = Math.max(0, -i6);
        iArr[1] = Math.max(0, -i7);
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + max + i3, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private void measureChildConstrained(View view, int i2, int i3, int i4, int i5, int i6) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height);
        int mode = MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i6 >= 0) {
            if (mode != 0) {
                i6 = Math.min(MeasureSpec.getSize(childMeasureSpec2), i6);
            }
            childMeasureSpec2 = MeasureSpec.makeMeasureSpec(i6, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void postShowOverflowMenu() {
        removeCallbacks(this.mShowOverflowMenuRunnable);
        post(this.mShowOverflowMenuRunnable);
    }

    private boolean shouldCollapse() {
        if (!this.mCollapsible) {
            return false;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (shouldLayout(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean shouldLayout(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    /* access modifiers changed from: 0000 */
    public void addChildrenForExpandedActionView() {
        for (int size = this.mHiddenViews.size() - 1; size >= 0; size--) {
            addView((View) this.mHiddenViews.get(size));
        }
        this.mHiddenViews.clear();
    }

    public boolean canShowOverflowMenu() {
        if (getVisibility() == 0) {
            ActionMenuView actionMenuView = this.mMenuView;
            if (actionMenuView != null && actionMenuView.g()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof b);
    }

    public void collapseActionView() {
        a aVar = this.mExpandedMenuPresenter;
        p pVar = aVar == null ? null : aVar.f898b;
        if (pVar != null) {
            pVar.collapseActionView();
        }
    }

    public void dismissPopupMenus() {
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            actionMenuView.b();
        }
    }

    /* access modifiers changed from: 0000 */
    public void ensureCollapseButtonView() {
        if (this.mCollapseButtonView == null) {
            this.mCollapseButtonView = new r(getContext(), null, b.a.a.toolbarNavigationButtonStyle);
            this.mCollapseButtonView.setImageDrawable(this.mCollapseIcon);
            this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
            b generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f471a = 8388611 | (this.mButtonGravity & 112);
            generateDefaultLayoutParams.f900b = 2;
            this.mCollapseButtonView.setLayoutParams(generateDefaultLayoutParams);
            this.mCollapseButtonView.setOnClickListener(new va(this));
        }
    }

    public int getContentInsetEnd() {
        W w = this.mContentInsets;
        if (w != null) {
            return w.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i2 = this.mContentInsetEndWithActions;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        W w = this.mContentInsets;
        if (w != null) {
            return w.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        W w = this.mContentInsets;
        if (w != null) {
            return w.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        W w = this.mContentInsets;
        if (w != null) {
            return w.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i2 = this.mContentInsetStartWithNavigation;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetStart();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0016  */
    public int getCurrentContentInsetEnd() {
        boolean z;
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            l h2 = actionMenuView.h();
            if (h2 != null && h2.hasVisibleItems()) {
                z = true;
                if (!z) {
                    return Math.max(getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0));
                }
                return getContentInsetEnd();
            }
        }
        z = false;
        if (!z) {
        }
    }

    public int getCurrentContentInsetLeft() {
        if (B.m(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (B.m(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.mContentInsetStartWithNavigation, 0));
        }
        return getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        ensureMenu();
        return this.mMenuView.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public C0165g getOuterActionMenuPresenter() {
        return this.mOuterActionMenuPresenter;
    }

    public Drawable getOverflowIcon() {
        ensureMenu();
        return this.mMenuView.getOverflowIcon();
    }

    /* access modifiers changed from: 0000 */
    public Context getPopupContext() {
        return this.mPopupContext;
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitleText;
    }

    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public int getTitleMarginBottom() {
        return this.mTitleMarginBottom;
    }

    public int getTitleMarginEnd() {
        return this.mTitleMarginEnd;
    }

    public int getTitleMarginStart() {
        return this.mTitleMarginStart;
    }

    public int getTitleMarginTop() {
        return this.mTitleMarginTop;
    }

    public J getWrapper() {
        if (this.mWrapper == null) {
            this.mWrapper = new za(this, true);
        }
        return this.mWrapper;
    }

    public boolean hasExpandedActionView() {
        a aVar = this.mExpandedMenuPresenter;
        return (aVar == null || aVar.f898b == null) ? false : true;
    }

    public boolean hideOverflowMenu() {
        ActionMenuView actionMenuView = this.mMenuView;
        return actionMenuView != null && actionMenuView.d();
    }

    public void inflateMenu(int i2) {
        getMenuInflater().inflate(i2, getMenu());
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuView actionMenuView = this.mMenuView;
        return actionMenuView != null && actionMenuView.e();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuView actionMenuView = this.mMenuView;
        return actionMenuView != null && actionMenuView.f();
    }

    public boolean isTitleTruncated() {
        TextView textView = this.mTitleTextView;
        if (textView == null) {
            return false;
        }
        Layout layout = textView.getLayout();
        if (layout == null) {
            return false;
        }
        int lineCount = layout.getLineCount();
        for (int i2 = 0; i2 < lineCount; i2++) {
            if (layout.getEllipsisCount(i2) > 0) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mShowOverflowMenuRunnable);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.mEatingHover = false;
        }
        if (!this.mEatingHover) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.mEatingHover = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.mEatingHover = false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x02a6 A[LOOP:0: B:101:0x02a4->B:102:0x02a6, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02c8 A[LOOP:1: B:104:0x02c6->B:105:0x02c8, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x02f3  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0302 A[LOOP:2: B:112:0x0300->B:113:0x0302, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x022c  */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        boolean shouldLayout;
        boolean shouldLayout2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int size;
        int i15;
        int i16;
        int size2;
        int i17;
        int i18;
        int size3;
        boolean z2;
        int i19;
        int i20;
        boolean z3;
        int i21;
        int i22;
        int i23;
        int i24;
        char c2;
        int i25;
        int i26;
        boolean z4 = B.m(this) == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i27 = width - paddingRight;
        int[] iArr = this.mTempMargins;
        iArr[1] = 0;
        iArr[0] = 0;
        int n = B.n(this);
        int min = n >= 0 ? Math.min(n, i5 - i3) : 0;
        if (!shouldLayout(this.mNavButtonView)) {
            i7 = paddingLeft;
        } else if (z4) {
            i6 = layoutChildRight(this.mNavButtonView, i27, iArr, min);
            i7 = paddingLeft;
            if (shouldLayout(this.mCollapseButtonView)) {
                if (z4) {
                    i6 = layoutChildRight(this.mCollapseButtonView, i6, iArr, min);
                } else {
                    i7 = layoutChildLeft(this.mCollapseButtonView, i7, iArr, min);
                }
            }
            if (shouldLayout(this.mMenuView)) {
                if (z4) {
                    i7 = layoutChildLeft(this.mMenuView, i7, iArr, min);
                } else {
                    i6 = layoutChildRight(this.mMenuView, i6, iArr, min);
                }
            }
            int currentContentInsetLeft = getCurrentContentInsetLeft();
            int currentContentInsetRight = getCurrentContentInsetRight();
            iArr[0] = Math.max(0, currentContentInsetLeft - i7);
            iArr[1] = Math.max(0, currentContentInsetRight - (i27 - i6));
            int max = Math.max(i7, currentContentInsetLeft);
            int min2 = Math.min(i6, i27 - currentContentInsetRight);
            if (shouldLayout(this.mExpandedActionView)) {
                if (z4) {
                    min2 = layoutChildRight(this.mExpandedActionView, min2, iArr, min);
                } else {
                    max = layoutChildLeft(this.mExpandedActionView, max, iArr, min);
                }
            }
            if (shouldLayout(this.mLogoView)) {
                if (z4) {
                    min2 = layoutChildRight(this.mLogoView, min2, iArr, min);
                } else {
                    max = layoutChildLeft(this.mLogoView, max, iArr, min);
                }
            }
            shouldLayout = shouldLayout(this.mTitleTextView);
            shouldLayout2 = shouldLayout(this.mSubtitleTextView);
            if (!shouldLayout) {
                b bVar = (b) this.mTitleTextView.getLayoutParams();
                i9 = paddingRight;
                i10 = bVar.topMargin + this.mTitleTextView.getMeasuredHeight() + bVar.bottomMargin + 0;
            } else {
                i9 = paddingRight;
                i10 = 0;
            }
            if (!shouldLayout2) {
                b bVar2 = (b) this.mSubtitleTextView.getLayoutParams();
                i11 = width;
                i10 += bVar2.topMargin + this.mSubtitleTextView.getMeasuredHeight() + bVar2.bottomMargin;
            } else {
                i11 = width;
            }
            if (!shouldLayout || shouldLayout2) {
                b bVar3 = (b) (!shouldLayout ? this.mTitleTextView : this.mSubtitleTextView).getLayoutParams();
                b bVar4 = (b) (!shouldLayout2 ? this.mSubtitleTextView : this.mTitleTextView).getLayoutParams();
                if ((shouldLayout || this.mTitleTextView.getMeasuredWidth() <= 0) && (!shouldLayout2 || this.mSubtitleTextView.getMeasuredWidth() <= 0)) {
                    i13 = paddingLeft;
                    z2 = false;
                } else {
                    i13 = paddingLeft;
                    z2 = true;
                }
                i19 = this.mGravity & 112;
                i12 = min;
                if (i19 != 48) {
                    i20 = max;
                    z3 = shouldLayout2;
                    i21 = getPaddingTop() + bVar3.topMargin + this.mTitleMarginTop;
                } else if (i19 != 80) {
                    int i28 = (((height - paddingTop) - paddingBottom) - i10) / 2;
                    int i29 = bVar3.topMargin;
                    i20 = max;
                    int i30 = this.mTitleMarginTop;
                    z3 = shouldLayout2;
                    if (i28 < i29 + i30) {
                        i28 = i29 + i30;
                    } else {
                        int i31 = (((height - paddingBottom) - i10) - i28) - paddingTop;
                        int i32 = bVar3.bottomMargin;
                        int i33 = this.mTitleMarginBottom;
                        if (i31 < i32 + i33) {
                            i28 = Math.max(0, i28 - ((bVar4.bottomMargin + i33) - i31));
                        }
                    }
                    i21 = paddingTop + i28;
                } else {
                    i20 = max;
                    z3 = shouldLayout2;
                    i21 = (((height - paddingBottom) - bVar4.bottomMargin) - this.mTitleMarginBottom) - i10;
                }
                if (!z4) {
                    if (z2) {
                        i24 = this.mTitleMarginStart;
                        c2 = 1;
                    } else {
                        c2 = 1;
                        i24 = 0;
                    }
                    int i34 = i24 - iArr[c2];
                    i8 -= Math.max(0, i34);
                    iArr[c2] = Math.max(0, -i34);
                    if (shouldLayout) {
                        b bVar5 = (b) this.mTitleTextView.getLayoutParams();
                        int measuredWidth = i8 - this.mTitleTextView.getMeasuredWidth();
                        int measuredHeight = this.mTitleTextView.getMeasuredHeight() + i21;
                        this.mTitleTextView.layout(measuredWidth, i21, i8, measuredHeight);
                        i25 = measuredWidth - this.mTitleMarginEnd;
                        i21 = measuredHeight + bVar5.bottomMargin;
                    } else {
                        i25 = i8;
                    }
                    if (z3) {
                        b bVar6 = (b) this.mSubtitleTextView.getLayoutParams();
                        int i35 = i21 + bVar6.topMargin;
                        this.mSubtitleTextView.layout(i8 - this.mSubtitleTextView.getMeasuredWidth(), i35, i8, this.mSubtitleTextView.getMeasuredHeight() + i35);
                        i26 = i8 - this.mTitleMarginEnd;
                        int i36 = bVar6.bottomMargin;
                    } else {
                        i26 = i8;
                    }
                    if (z2) {
                        i8 = Math.min(i25, i26);
                    }
                    max = i20;
                } else {
                    i14 = 0;
                    int i37 = (z2 ? this.mTitleMarginStart : 0) - iArr[0];
                    max = i20 + Math.max(0, i37);
                    iArr[0] = Math.max(0, -i37);
                    if (shouldLayout) {
                        b bVar7 = (b) this.mTitleTextView.getLayoutParams();
                        int measuredWidth2 = this.mTitleTextView.getMeasuredWidth() + max;
                        int measuredHeight2 = this.mTitleTextView.getMeasuredHeight() + i21;
                        this.mTitleTextView.layout(max, i21, measuredWidth2, measuredHeight2);
                        i22 = measuredWidth2 + this.mTitleMarginEnd;
                        i21 = measuredHeight2 + bVar7.bottomMargin;
                    } else {
                        i22 = max;
                    }
                    if (z3) {
                        b bVar8 = (b) this.mSubtitleTextView.getLayoutParams();
                        int i38 = i21 + bVar8.topMargin;
                        int measuredWidth3 = this.mSubtitleTextView.getMeasuredWidth() + max;
                        this.mSubtitleTextView.layout(max, i38, measuredWidth3, this.mSubtitleTextView.getMeasuredHeight() + i38);
                        i23 = measuredWidth3 + this.mTitleMarginEnd;
                        int i39 = bVar8.bottomMargin;
                    } else {
                        i23 = max;
                    }
                    if (z2) {
                        max = Math.max(i22, i23);
                    }
                    addCustomViewsWithGravity(this.mTempViews, 3);
                    size = this.mTempViews.size();
                    i15 = max;
                    for (i16 = 0; i16 < size; i16++) {
                        i15 = layoutChildLeft((View) this.mTempViews.get(i16), i15, iArr, i12);
                    }
                    int i40 = i12;
                    addCustomViewsWithGravity(this.mTempViews, 5);
                    size2 = this.mTempViews.size();
                    for (i17 = 0; i17 < size2; i17++) {
                        i8 = layoutChildRight((View) this.mTempViews.get(i17), i8, iArr, i40);
                    }
                    addCustomViewsWithGravity(this.mTempViews, 1);
                    int viewListMeasuredWidth = getViewListMeasuredWidth(this.mTempViews, iArr);
                    i18 = (i13 + (((i11 - i13) - i9) / 2)) - (viewListMeasuredWidth / 2);
                    int i41 = viewListMeasuredWidth + i18;
                    if (i18 >= i15) {
                        i15 = i41 > i8 ? i18 - (i41 - i8) : i18;
                    }
                    size3 = this.mTempViews.size();
                    while (i14 < size3) {
                        i15 = layoutChildLeft((View) this.mTempViews.get(i14), i15, iArr, i40);
                        i14++;
                    }
                    this.mTempViews.clear();
                    return;
                }
            } else {
                i13 = paddingLeft;
                i12 = min;
            }
            i14 = 0;
            addCustomViewsWithGravity(this.mTempViews, 3);
            size = this.mTempViews.size();
            i15 = max;
            while (i16 < size) {
            }
            int i402 = i12;
            addCustomViewsWithGravity(this.mTempViews, 5);
            size2 = this.mTempViews.size();
            while (i17 < size2) {
            }
            addCustomViewsWithGravity(this.mTempViews, 1);
            int viewListMeasuredWidth2 = getViewListMeasuredWidth(this.mTempViews, iArr);
            i18 = (i13 + (((i11 - i13) - i9) / 2)) - (viewListMeasuredWidth2 / 2);
            int i412 = viewListMeasuredWidth2 + i18;
            if (i18 >= i15) {
            }
            size3 = this.mTempViews.size();
            while (i14 < size3) {
            }
            this.mTempViews.clear();
            return;
        } else {
            i7 = layoutChildLeft(this.mNavButtonView, paddingLeft, iArr, min);
        }
        i6 = i27;
        if (shouldLayout(this.mCollapseButtonView)) {
        }
        if (shouldLayout(this.mMenuView)) {
        }
        int currentContentInsetLeft2 = getCurrentContentInsetLeft();
        int currentContentInsetRight2 = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft2 - i7);
        iArr[1] = Math.max(0, currentContentInsetRight2 - (i27 - i6));
        int max2 = Math.max(i7, currentContentInsetLeft2);
        int min22 = Math.min(i6, i27 - currentContentInsetRight2);
        if (shouldLayout(this.mExpandedActionView)) {
        }
        if (shouldLayout(this.mLogoView)) {
        }
        shouldLayout = shouldLayout(this.mTitleTextView);
        shouldLayout2 = shouldLayout(this.mSubtitleTextView);
        if (!shouldLayout) {
        }
        if (!shouldLayout2) {
        }
        if (!shouldLayout) {
        }
        b bVar32 = (b) (!shouldLayout ? this.mTitleTextView : this.mSubtitleTextView).getLayoutParams();
        b bVar42 = (b) (!shouldLayout2 ? this.mSubtitleTextView : this.mTitleTextView).getLayoutParams();
        if (shouldLayout) {
        }
        i13 = paddingLeft;
        z2 = false;
        i19 = this.mGravity & 112;
        i12 = min;
        if (i19 != 48) {
        }
        if (!z4) {
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        char c2;
        char c3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int[] iArr = this.mTempMargins;
        if (Ga.a(this)) {
            c3 = 1;
            c2 = 0;
        } else {
            c3 = 0;
            c2 = 1;
        }
        if (shouldLayout(this.mNavButtonView)) {
            measureChildConstrained(this.mNavButtonView, i2, 0, i3, 0, this.mMaxButtonHeight);
            i6 = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(this.mNavButtonView);
            i5 = Math.max(0, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins(this.mNavButtonView));
            i4 = View.combineMeasuredStates(0, this.mNavButtonView.getMeasuredState());
        } else {
            i6 = 0;
            i5 = 0;
            i4 = 0;
        }
        if (shouldLayout(this.mCollapseButtonView)) {
            measureChildConstrained(this.mCollapseButtonView, i2, 0, i3, 0, this.mMaxButtonHeight);
            i6 = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(this.mCollapseButtonView);
            i5 = Math.max(i5, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(this.mCollapseButtonView));
            i4 = View.combineMeasuredStates(i4, this.mCollapseButtonView.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = 0 + Math.max(currentContentInsetStart, i6);
        iArr[c3] = Math.max(0, currentContentInsetStart - i6);
        if (shouldLayout(this.mMenuView)) {
            measureChildConstrained(this.mMenuView, i2, max, i3, 0, this.mMaxButtonHeight);
            i7 = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
            i5 = Math.max(i5, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
            i4 = View.combineMeasuredStates(i4, this.mMenuView.getMeasuredState());
        } else {
            i7 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i7);
        iArr[c2] = Math.max(0, currentContentInsetEnd - i7);
        if (shouldLayout(this.mExpandedActionView)) {
            max2 += measureChildCollapseMargins(this.mExpandedActionView, i2, max2, i3, 0, iArr);
            i5 = Math.max(i5, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
            i4 = View.combineMeasuredStates(i4, this.mExpandedActionView.getMeasuredState());
        }
        if (shouldLayout(this.mLogoView)) {
            max2 += measureChildCollapseMargins(this.mLogoView, i2, max2, i3, 0, iArr);
            i5 = Math.max(i5, this.mLogoView.getMeasuredHeight() + getVerticalMargins(this.mLogoView));
            i4 = View.combineMeasuredStates(i4, this.mLogoView.getMeasuredState());
        }
        int childCount = getChildCount();
        int i11 = i5;
        int i12 = max2;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (((b) childAt.getLayoutParams()).f900b == 0 && shouldLayout(childAt)) {
                i12 += measureChildCollapseMargins(childAt, i2, i12, i3, 0, iArr);
                i11 = Math.max(i11, childAt.getMeasuredHeight() + getVerticalMargins(childAt));
                i4 = View.combineMeasuredStates(i4, childAt.getMeasuredState());
            }
        }
        int i14 = this.mTitleMarginTop + this.mTitleMarginBottom;
        int i15 = this.mTitleMarginStart + this.mTitleMarginEnd;
        if (shouldLayout(this.mTitleTextView)) {
            measureChildCollapseMargins(this.mTitleTextView, i2, i12 + i15, i3, i14, iArr);
            int measuredWidth = this.mTitleTextView.getMeasuredWidth() + getHorizontalMargins(this.mTitleTextView);
            i8 = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins(this.mTitleTextView);
            i10 = View.combineMeasuredStates(i4, this.mTitleTextView.getMeasuredState());
            i9 = measuredWidth;
        } else {
            i10 = i4;
            i9 = 0;
            i8 = 0;
        }
        if (shouldLayout(this.mSubtitleTextView)) {
            int i16 = i8 + i14;
            int i17 = i10;
            i9 = Math.max(i9, measureChildCollapseMargins(this.mSubtitleTextView, i2, i12 + i15, i3, i16, iArr));
            i8 += this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(this.mSubtitleTextView);
            i10 = View.combineMeasuredStates(i17, this.mSubtitleTextView.getMeasuredState());
        } else {
            int i18 = i10;
        }
        int i19 = i12 + i9;
        int max3 = Math.max(i11, i8) + getPaddingTop() + getPaddingBottom();
        int i20 = i2;
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(i19 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i20, -16777216 & i10);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(max3, getSuggestedMinimumHeight()), i3, i10 << 16);
        if (shouldCollapse()) {
            resolveSizeAndState2 = 0;
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.n());
        ActionMenuView actionMenuView = this.mMenuView;
        l h2 = actionMenuView != null ? actionMenuView.h() : null;
        int i2 = dVar.f901c;
        if (!(i2 == 0 || this.mExpandedMenuPresenter == null || h2 == null)) {
            MenuItem findItem = h2.findItem(i2);
            if (findItem != null) {
                findItem.expandActionView();
            }
        }
        if (dVar.f902d) {
            postShowOverflowMenu();
        }
    }

    public void onRtlPropertiesChanged(int i2) {
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i2);
        }
        ensureContentInsets();
        W w = this.mContentInsets;
        boolean z = true;
        if (i2 != 1) {
            z = false;
        }
        w.a(z);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        a aVar = this.mExpandedMenuPresenter;
        if (aVar != null) {
            p pVar = aVar.f898b;
            if (pVar != null) {
                dVar.f901c = pVar.getItemId();
            }
        }
        dVar.f902d = isOverflowMenuShowing();
        return dVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mEatingTouch = false;
        }
        if (!this.mEatingTouch) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.mEatingTouch = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.mEatingTouch = false;
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void removeChildrenForExpandedActionView() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((b) childAt.getLayoutParams()).f900b == 2 || childAt == this.mMenuView)) {
                removeViewAt(childCount);
                this.mHiddenViews.add(childAt);
            }
        }
    }

    public void setCollapsible(boolean z) {
        this.mCollapsible = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.mContentInsetEndWithActions) {
            this.mContentInsetEndWithActions = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.mContentInsetStartWithNavigation) {
            this.mContentInsetStartWithNavigation = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetsAbsolute(int i2, int i3) {
        ensureContentInsets();
        this.mContentInsets.a(i2, i3);
    }

    public void setContentInsetsRelative(int i2, int i3) {
        ensureContentInsets();
        this.mContentInsets.b(i2, i3);
    }

    public void setLogo(int i2) {
        setLogo(b.a.a.a.a.b(getContext(), i2));
    }

    public void setLogoDescription(int i2) {
        setLogoDescription(getContext().getText(i2));
    }

    public void setMenu(l lVar, C0165g gVar) {
        if (lVar != null || this.mMenuView != null) {
            ensureMenuView();
            l h2 = this.mMenuView.h();
            if (h2 != lVar) {
                if (h2 != null) {
                    h2.b((v) this.mOuterActionMenuPresenter);
                    h2.b((v) this.mExpandedMenuPresenter);
                }
                if (this.mExpandedMenuPresenter == null) {
                    this.mExpandedMenuPresenter = new a();
                }
                gVar.b(true);
                if (lVar != null) {
                    lVar.a((v) gVar, this.mPopupContext);
                    lVar.a((v) this.mExpandedMenuPresenter, this.mPopupContext);
                } else {
                    gVar.a(this.mPopupContext, (l) null);
                    this.mExpandedMenuPresenter.a(this.mPopupContext, (l) null);
                    gVar.a(true);
                    this.mExpandedMenuPresenter.a(true);
                }
                this.mMenuView.setPopupTheme(this.mPopupTheme);
                this.mMenuView.setPresenter(gVar);
                this.mOuterActionMenuPresenter = gVar;
            }
        }
    }

    public void setMenuCallbacks(androidx.appcompat.view.menu.v.a aVar, androidx.appcompat.view.menu.l.a aVar2) {
        this.mActionMenuPresenterCallback = aVar;
        this.mMenuBuilderCallback = aVar2;
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            actionMenuView.a(aVar, aVar2);
        }
    }

    public void setNavigationContentDescription(int i2) {
        setNavigationContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setNavigationIcon(int i2) {
        setNavigationIcon(b.a.a.a.a.b(getContext(), i2));
    }

    public void setNavigationOnClickListener(OnClickListener onClickListener) {
        ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(c cVar) {
        this.mOnMenuItemClickListener = cVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        ensureMenu();
        this.mMenuView.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i2) {
        if (this.mPopupTheme != i2) {
            this.mPopupTheme = i2;
            if (i2 == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setSubtitle(int i2) {
        setSubtitle(getContext().getText(i2));
    }

    public void setSubtitleTextAppearance(Context context, int i2) {
        this.mSubtitleTextAppearance = i2;
        TextView textView = this.mSubtitleTextView;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    public void setSubtitleTextColor(int i2) {
        this.mSubtitleTextColor = i2;
        TextView textView = this.mSubtitleTextView;
        if (textView != null) {
            textView.setTextColor(i2);
        }
    }

    public void setTitle(int i2) {
        setTitle(getContext().getText(i2));
    }

    public void setTitleMargin(int i2, int i3, int i4, int i5) {
        this.mTitleMarginStart = i2;
        this.mTitleMarginTop = i3;
        this.mTitleMarginEnd = i4;
        this.mTitleMarginBottom = i5;
        requestLayout();
    }

    public void setTitleMarginBottom(int i2) {
        this.mTitleMarginBottom = i2;
        requestLayout();
    }

    public void setTitleMarginEnd(int i2) {
        this.mTitleMarginEnd = i2;
        requestLayout();
    }

    public void setTitleMarginStart(int i2) {
        this.mTitleMarginStart = i2;
        requestLayout();
    }

    public void setTitleMarginTop(int i2) {
        this.mTitleMarginTop = i2;
        requestLayout();
    }

    public void setTitleTextAppearance(Context context, int i2) {
        this.mTitleTextAppearance = i2;
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    public void setTitleTextColor(int i2) {
        this.mTitleTextColor = i2;
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextColor(i2);
        }
    }

    public boolean showOverflowMenu() {
        ActionMenuView actionMenuView = this.mMenuView;
        return actionMenuView != null && actionMenuView.i();
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.a.a.toolbarStyle);
    }

    /* access modifiers changed from: protected */
    public b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            ensureLogoView();
            if (!isChildOrHidden(this.mLogoView)) {
                addSystemView(this.mLogoView, true);
            }
        } else {
            ImageView imageView = this.mLogoView;
            if (imageView != null && isChildOrHidden(imageView)) {
                removeView(this.mLogoView);
                this.mHiddenViews.remove(this.mLogoView);
            }
        }
        ImageView imageView2 = this.mLogoView;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureLogoView();
        }
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureNavButtonView();
        }
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            ensureNavButtonView();
            if (!isChildOrHidden(this.mNavButtonView)) {
                addSystemView(this.mNavButtonView, true);
            }
        } else {
            ImageButton imageButton = this.mNavButtonView;
            if (imageButton != null && isChildOrHidden(imageButton)) {
                removeView(this.mNavButtonView);
                this.mHiddenViews.remove(this.mNavButtonView);
            }
        }
        ImageButton imageButton2 = this.mNavButtonView;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mSubtitleTextView == null) {
                Context context = getContext();
                this.mSubtitleTextView = new AppCompatTextView(context);
                this.mSubtitleTextView.setSingleLine();
                this.mSubtitleTextView.setEllipsize(TruncateAt.END);
                int i2 = this.mSubtitleTextAppearance;
                if (i2 != 0) {
                    this.mSubtitleTextView.setTextAppearance(context, i2);
                }
                int i3 = this.mSubtitleTextColor;
                if (i3 != 0) {
                    this.mSubtitleTextView.setTextColor(i3);
                }
            }
            if (!isChildOrHidden(this.mSubtitleTextView)) {
                addSystemView(this.mSubtitleTextView, true);
            }
        } else {
            TextView textView = this.mSubtitleTextView;
            if (textView != null && isChildOrHidden(textView)) {
                removeView(this.mSubtitleTextView);
                this.mHiddenViews.remove(this.mSubtitleTextView);
            }
        }
        TextView textView2 = this.mSubtitleTextView;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.mSubtitleText = charSequence;
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mTitleTextView == null) {
                Context context = getContext();
                this.mTitleTextView = new AppCompatTextView(context);
                this.mTitleTextView.setSingleLine();
                this.mTitleTextView.setEllipsize(TruncateAt.END);
                int i2 = this.mTitleTextAppearance;
                if (i2 != 0) {
                    this.mTitleTextView.setTextAppearance(context, i2);
                }
                int i3 = this.mTitleTextColor;
                if (i3 != 0) {
                    this.mTitleTextView.setTextColor(i3);
                }
            }
            if (!isChildOrHidden(this.mTitleTextView)) {
                addSystemView(this.mTitleTextView, true);
            }
        } else {
            TextView textView = this.mTitleTextView;
            if (textView != null && isChildOrHidden(textView)) {
                removeView(this.mTitleTextView);
                this.mHiddenViews.remove(this.mTitleTextView);
            }
        }
        TextView textView2 = this.mTitleTextView;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.mTitleText = charSequence;
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mGravity = 8388627;
        this.mTempViews = new ArrayList<>();
        this.mHiddenViews = new ArrayList<>();
        this.mTempMargins = new int[2];
        this.mMenuViewItemClickListener = new ta(this);
        this.mShowOverflowMenuRunnable = new ua(this);
        sa a2 = sa.a(getContext(), attributeSet, j.Toolbar, i2, 0);
        this.mTitleTextAppearance = a2.g(j.Toolbar_titleTextAppearance, 0);
        this.mSubtitleTextAppearance = a2.g(j.Toolbar_subtitleTextAppearance, 0);
        this.mGravity = a2.e(j.Toolbar_android_gravity, this.mGravity);
        this.mButtonGravity = a2.e(j.Toolbar_buttonGravity, 48);
        int b2 = a2.b(j.Toolbar_titleMargin, 0);
        if (a2.g(j.Toolbar_titleMargins)) {
            b2 = a2.b(j.Toolbar_titleMargins, b2);
        }
        this.mTitleMarginBottom = b2;
        this.mTitleMarginTop = b2;
        this.mTitleMarginEnd = b2;
        this.mTitleMarginStart = b2;
        int b3 = a2.b(j.Toolbar_titleMarginStart, -1);
        if (b3 >= 0) {
            this.mTitleMarginStart = b3;
        }
        int b4 = a2.b(j.Toolbar_titleMarginEnd, -1);
        if (b4 >= 0) {
            this.mTitleMarginEnd = b4;
        }
        int b5 = a2.b(j.Toolbar_titleMarginTop, -1);
        if (b5 >= 0) {
            this.mTitleMarginTop = b5;
        }
        int b6 = a2.b(j.Toolbar_titleMarginBottom, -1);
        if (b6 >= 0) {
            this.mTitleMarginBottom = b6;
        }
        this.mMaxButtonHeight = a2.c(j.Toolbar_maxButtonHeight, -1);
        int b7 = a2.b(j.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int b8 = a2.b(j.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int c2 = a2.c(j.Toolbar_contentInsetLeft, 0);
        int c3 = a2.c(j.Toolbar_contentInsetRight, 0);
        ensureContentInsets();
        this.mContentInsets.a(c2, c3);
        if (!(b7 == Integer.MIN_VALUE && b8 == Integer.MIN_VALUE)) {
            this.mContentInsets.b(b7, b8);
        }
        this.mContentInsetStartWithNavigation = a2.b(j.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.mContentInsetEndWithActions = a2.b(j.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.mCollapseIcon = a2.b(j.Toolbar_collapseIcon);
        this.mCollapseDescription = a2.e(j.Toolbar_collapseContentDescription);
        CharSequence e2 = a2.e(j.Toolbar_title);
        if (!TextUtils.isEmpty(e2)) {
            setTitle(e2);
        }
        CharSequence e3 = a2.e(j.Toolbar_subtitle);
        if (!TextUtils.isEmpty(e3)) {
            setSubtitle(e3);
        }
        this.mPopupContext = getContext();
        setPopupTheme(a2.g(j.Toolbar_popupTheme, 0));
        Drawable b9 = a2.b(j.Toolbar_navigationIcon);
        if (b9 != null) {
            setNavigationIcon(b9);
        }
        CharSequence e4 = a2.e(j.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(e4)) {
            setNavigationContentDescription(e4);
        }
        Drawable b10 = a2.b(j.Toolbar_logo);
        if (b10 != null) {
            setLogo(b10);
        }
        CharSequence e5 = a2.e(j.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(e5)) {
            setLogoDescription(e5);
        }
        if (a2.g(j.Toolbar_titleTextColor)) {
            setTitleTextColor(a2.a(j.Toolbar_titleTextColor, -1));
        }
        if (a2.g(j.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a2.a(j.Toolbar_subtitleTextColor, -1));
        }
        a2.a();
    }

    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public b generateLayoutParams(LayoutParams layoutParams) {
        if (layoutParams instanceof b) {
            return new b((b) layoutParams);
        }
        if (layoutParams instanceof C0006a) {
            return new b((C0006a) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new b((MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }
}
