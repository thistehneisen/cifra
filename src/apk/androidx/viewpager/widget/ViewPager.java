package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import b.g.i.B;
import b.g.i.C0240a;
import b.g.i.r;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final Comparator<b> COMPARATOR = new b();
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    static final int[] LAYOUT_ATTRS = {16842931};
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private static final Interpolator sInterpolator = new c();
    private static final j sPositionComparator = new j();
    private int mActivePointerId = -1;
    a mAdapter;
    private List<e> mAdapterChangeListeners;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable = new d(this);
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout = true;
    private float mFirstOffset = -3.4028235E38f;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private f mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList<b> mItems = new ArrayList<>();
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset = Float.MAX_VALUE;
    private EdgeEffect mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets = false;
    private h mObserver;
    private int mOffscreenPageLimit = 1;
    private f mOnPageChangeListener;
    private List<f> mOnPageChangeListeners;
    private int mPageMargin;
    private g mPageTransformer;
    private int mPageTransformerLayerType;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState = null;
    private ClassLoader mRestoredClassLoader = null;
    private int mRestoredCurItem = -1;
    private EdgeEffect mRightEdge;
    private int mScrollState = 0;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private final b mTempItem = new b();
    private final Rect mTempRect = new Rect();
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    @Inherited
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface a {
    }

    static class b {

        /* renamed from: a reason: collision with root package name */
        Object f2126a;

        /* renamed from: b reason: collision with root package name */
        int f2127b;

        /* renamed from: c reason: collision with root package name */
        boolean f2128c;

        /* renamed from: d reason: collision with root package name */
        float f2129d;

        /* renamed from: e reason: collision with root package name */
        float f2130e;

        b() {
        }
    }

    public static class c extends LayoutParams {

        /* renamed from: a reason: collision with root package name */
        public boolean f2131a;

        /* renamed from: b reason: collision with root package name */
        public int f2132b;

        /* renamed from: c reason: collision with root package name */
        float f2133c = 0.0f;

        /* renamed from: d reason: collision with root package name */
        boolean f2134d;

        /* renamed from: e reason: collision with root package name */
        int f2135e;

        /* renamed from: f reason: collision with root package name */
        int f2136f;

        public c() {
            super(-1, -1);
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.LAYOUT_ATTRS);
            this.f2132b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    class d extends C0240a {
        d() {
        }

        public void a(View view, b.g.i.a.d dVar) {
            super.a(view, dVar);
            dVar.b((CharSequence) ViewPager.class.getName());
            dVar.j(b());
            if (ViewPager.this.canScrollHorizontally(1)) {
                dVar.a((int) CodedOutputStream.DEFAULT_BUFFER_SIZE);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                dVar.a(8192);
            }
        }

        public void b(View view, AccessibilityEvent accessibilityEvent) {
            super.b(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(b());
            if (accessibilityEvent.getEventType() == 4096) {
                a aVar = ViewPager.this.mAdapter;
                if (aVar != null) {
                    accessibilityEvent.setItemCount(aVar.getCount());
                    accessibilityEvent.setFromIndex(ViewPager.this.mCurItem);
                    accessibilityEvent.setToIndex(ViewPager.this.mCurItem);
                }
            }
        }

        private boolean b() {
            a aVar = ViewPager.this.mAdapter;
            return aVar != null && aVar.getCount() > 1;
        }

        public boolean a(View view, int i2, Bundle bundle) {
            if (super.a(view, i2, bundle)) {
                return true;
            }
            if (i2 != 4096) {
                if (i2 != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                ViewPager viewPager = ViewPager.this;
                viewPager.setCurrentItem(viewPager.mCurItem - 1);
                return true;
            } else if (!ViewPager.this.canScrollHorizontally(1)) {
                return false;
            } else {
                ViewPager viewPager2 = ViewPager.this;
                viewPager2.setCurrentItem(viewPager2.mCurItem + 1);
                return true;
            }
        }
    }

    public interface e {
        void a(ViewPager viewPager, a aVar, a aVar2);
    }

    public interface f {
        void a(int i2);

        void a(int i2, float f2, int i3);

        void b(int i2);
    }

    public interface g {
        void a(View view, float f2);
    }

    private class h extends DataSetObserver {
        h() {
        }

        public void onChanged() {
            ViewPager.this.dataSetChanged();
        }

        public void onInvalidated() {
            ViewPager.this.dataSetChanged();
        }
    }

    public static class i extends b.i.a.c {
        public static final Creator<i> CREATOR = new f();

        /* renamed from: c reason: collision with root package name */
        int f2139c;

        /* renamed from: d reason: collision with root package name */
        Parcelable f2140d;

        /* renamed from: e reason: collision with root package name */
        ClassLoader f2141e;

        public i(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("FragmentPager.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" position=");
            sb.append(this.f2139c);
            sb.append("}");
            return sb.toString();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f2139c);
            parcel.writeParcelable(this.f2140d, i2);
        }

        i(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                classLoader = i.class.getClassLoader();
            }
            this.f2139c = parcel.readInt();
            this.f2140d = parcel.readParcelable(classLoader);
            this.f2141e = classLoader;
        }
    }

    static class j implements Comparator<View> {
        j() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            c cVar = (c) view.getLayoutParams();
            c cVar2 = (c) view2.getLayoutParams();
            boolean z = cVar.f2131a;
            if (z == cVar2.f2131a) {
                return cVar.f2135e - cVar2.f2135e;
            }
            return z ? 1 : -1;
        }
    }

    public ViewPager(Context context) {
        super(context);
        initViewPager();
    }

    private void calculatePageOffsets(b bVar, int i2, b bVar2) {
        int i3;
        int i4;
        b bVar3;
        b bVar4;
        int count = this.mAdapter.getCount();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? ((float) this.mPageMargin) / ((float) clientWidth) : 0.0f;
        if (bVar2 != null) {
            int i5 = bVar2.f2127b;
            int i6 = bVar.f2127b;
            if (i5 < i6) {
                float f3 = bVar2.f2130e + bVar2.f2129d + f2;
                int i7 = i5 + 1;
                int i8 = 0;
                while (i7 <= bVar.f2127b && i8 < this.mItems.size()) {
                    Object obj = this.mItems.get(i8);
                    while (true) {
                        bVar4 = (b) obj;
                        if (i7 > bVar4.f2127b && i8 < this.mItems.size() - 1) {
                            i8++;
                            obj = this.mItems.get(i8);
                        }
                    }
                    while (i7 < bVar4.f2127b) {
                        f3 += this.mAdapter.getPageWidth(i7) + f2;
                        i7++;
                    }
                    bVar4.f2130e = f3;
                    f3 += bVar4.f2129d + f2;
                    i7++;
                }
            } else if (i5 > i6) {
                int size = this.mItems.size() - 1;
                float f4 = bVar2.f2130e;
                while (true) {
                    i5--;
                    if (i5 < bVar.f2127b || size < 0) {
                        break;
                    }
                    Object obj2 = this.mItems.get(size);
                    while (true) {
                        bVar3 = (b) obj2;
                        if (i5 < bVar3.f2127b && size > 0) {
                            size--;
                            obj2 = this.mItems.get(size);
                        }
                    }
                    while (i5 > bVar3.f2127b) {
                        f4 -= this.mAdapter.getPageWidth(i5) + f2;
                        i5--;
                    }
                    f4 -= bVar3.f2129d + f2;
                    bVar3.f2130e = f4;
                }
            }
        }
        int size2 = this.mItems.size();
        float f5 = bVar.f2130e;
        int i9 = bVar.f2127b;
        int i10 = i9 - 1;
        this.mFirstOffset = i9 == 0 ? f5 : -3.4028235E38f;
        int i11 = count - 1;
        this.mLastOffset = bVar.f2127b == i11 ? (bVar.f2130e + bVar.f2129d) - 1.0f : Float.MAX_VALUE;
        int i12 = i2 - 1;
        while (i12 >= 0) {
            b bVar5 = (b) this.mItems.get(i12);
            while (true) {
                i4 = bVar5.f2127b;
                if (i10 <= i4) {
                    break;
                }
                f5 -= this.mAdapter.getPageWidth(i10) + f2;
                i10--;
            }
            f5 -= bVar5.f2129d + f2;
            bVar5.f2130e = f5;
            if (i4 == 0) {
                this.mFirstOffset = f5;
            }
            i12--;
            i10--;
        }
        float f6 = bVar.f2130e + bVar.f2129d + f2;
        int i13 = bVar.f2127b + 1;
        int i14 = i2 + 1;
        while (i14 < size2) {
            b bVar6 = (b) this.mItems.get(i14);
            while (true) {
                i3 = bVar6.f2127b;
                if (i13 >= i3) {
                    break;
                }
                f6 += this.mAdapter.getPageWidth(i13) + f2;
                i13++;
            }
            if (i3 == i11) {
                this.mLastOffset = (bVar6.f2129d + f6) - 1.0f;
            }
            bVar6.f2130e = f6;
            f6 += bVar6.f2129d + f2;
            i14++;
            i13++;
        }
        this.mNeedCalculatePageOffsets = false;
    }

    private void completeScroll(boolean z) {
        boolean z2 = this.mScrollState == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        pageScrolled(currX);
                    }
                }
            }
        }
        this.mPopulatePending = false;
        boolean z3 = z2;
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            b bVar = (b) this.mItems.get(i2);
            if (bVar.f2128c) {
                bVar.f2128c = false;
                z3 = true;
            }
        }
        if (!z3) {
            return;
        }
        if (z) {
            B.a((View) this, this.mEndScrollRunnable);
        } else {
            this.mEndScrollRunnable.run();
        }
    }

    private int determineTargetPage(int i2, float f2, int i3, int i4) {
        if (Math.abs(i4) <= this.mFlingDistance || Math.abs(i3) <= this.mMinimumVelocity) {
            i2 += (int) (f2 + (i2 >= this.mCurItem ? 0.4f : 0.6f));
        } else if (i3 <= 0) {
            i2++;
        }
        if (this.mItems.size() <= 0) {
            return i2;
        }
        b bVar = (b) this.mItems.get(0);
        ArrayList<b> arrayList = this.mItems;
        return Math.max(bVar.f2127b, Math.min(i2, ((b) arrayList.get(arrayList.size() - 1)).f2127b));
    }

    private void dispatchOnPageScrolled(int i2, float f2, int i3) {
        f fVar = this.mOnPageChangeListener;
        if (fVar != null) {
            fVar.a(i2, f2, i3);
        }
        List<f> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                f fVar2 = (f) this.mOnPageChangeListeners.get(i4);
                if (fVar2 != null) {
                    fVar2.a(i2, f2, i3);
                }
            }
        }
        f fVar3 = this.mInternalPageChangeListener;
        if (fVar3 != null) {
            fVar3.a(i2, f2, i3);
        }
    }

    private void dispatchOnPageSelected(int i2) {
        f fVar = this.mOnPageChangeListener;
        if (fVar != null) {
            fVar.b(i2);
        }
        List<f> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                f fVar2 = (f) this.mOnPageChangeListeners.get(i3);
                if (fVar2 != null) {
                    fVar2.b(i2);
                }
            }
        }
        f fVar3 = this.mInternalPageChangeListener;
        if (fVar3 != null) {
            fVar3.b(i2);
        }
    }

    private void dispatchOnScrollStateChanged(int i2) {
        f fVar = this.mOnPageChangeListener;
        if (fVar != null) {
            fVar.a(i2);
        }
        List<f> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                f fVar2 = (f) this.mOnPageChangeListeners.get(i3);
                if (fVar2 != null) {
                    fVar2.a(i2);
                }
            }
        }
        f fVar3 = this.mInternalPageChangeListener;
        if (fVar3 != null) {
            fVar3.a(i2);
        }
    }

    private void enableLayers(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).setLayerType(z ? this.mPageTransformerLayerType : 0, null);
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private b infoForCurrentScrollPosition() {
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f2 = clientWidth > 0 ? ((float) this.mPageMargin) / ((float) clientWidth) : 0.0f;
        b bVar = null;
        int i2 = 0;
        boolean z = true;
        int i3 = -1;
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (i2 < this.mItems.size()) {
            b bVar2 = (b) this.mItems.get(i2);
            if (!z) {
                int i4 = i3 + 1;
                if (bVar2.f2127b != i4) {
                    bVar2 = this.mTempItem;
                    bVar2.f2130e = f3 + f4 + f2;
                    bVar2.f2127b = i4;
                    bVar2.f2129d = this.mAdapter.getPageWidth(bVar2.f2127b);
                    i2--;
                }
            }
            f3 = bVar2.f2130e;
            float f5 = bVar2.f2129d + f3 + f2;
            if (!z && scrollX < f3) {
                return bVar;
            }
            if (scrollX < f5 || i2 == this.mItems.size() - 1) {
                return bVar2;
            }
            i3 = bVar2.f2127b;
            f4 = bVar2.f2129d;
            i2++;
            bVar = bVar2;
            z = false;
        }
        return bVar;
    }

    private static boolean isDecorView(View view) {
        return view.getClass().getAnnotation(a.class) != null;
    }

    private boolean isGutterDrag(float f2, float f3) {
        return (f2 < ((float) this.mGutterSize) && f3 > 0.0f) || (f2 > ((float) (getWidth() - this.mGutterSize)) && f3 < 0.0f);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.mLastMotionX = motionEvent.getX(i2);
            this.mActivePointerId = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private boolean pageScrolled(int i2) {
        String str = "onPageScrolled did not call superclass implementation";
        if (this.mItems.size() != 0) {
            b infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            int clientWidth = getClientWidth();
            int i3 = this.mPageMargin;
            int i4 = clientWidth + i3;
            float f2 = (float) clientWidth;
            float f3 = ((float) i3) / f2;
            int i5 = infoForCurrentScrollPosition.f2127b;
            float f4 = ((((float) i2) / f2) - infoForCurrentScrollPosition.f2130e) / (infoForCurrentScrollPosition.f2129d + f3);
            int i6 = (int) (((float) i4) * f4);
            this.mCalledSuper = false;
            onPageScrolled(i5, f4, i6);
            if (this.mCalledSuper) {
                return true;
            }
            throw new IllegalStateException(str);
        } else if (this.mFirstLayout) {
            return false;
        } else {
            this.mCalledSuper = false;
            onPageScrolled(0, 0.0f, 0);
            if (this.mCalledSuper) {
                return false;
            }
            throw new IllegalStateException(str);
        }
    }

    private boolean performDrag(float f2) {
        boolean z;
        boolean z2;
        float f3 = this.mLastMotionX - f2;
        this.mLastMotionX = f2;
        float scrollX = ((float) getScrollX()) + f3;
        float clientWidth = (float) getClientWidth();
        float f4 = this.mFirstOffset * clientWidth;
        float f5 = this.mLastOffset * clientWidth;
        boolean z3 = false;
        b bVar = (b) this.mItems.get(0);
        ArrayList<b> arrayList = this.mItems;
        b bVar2 = (b) arrayList.get(arrayList.size() - 1);
        if (bVar.f2127b != 0) {
            f4 = bVar.f2130e * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (bVar2.f2127b != this.mAdapter.getCount() - 1) {
            f5 = bVar2.f2130e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f4) {
            if (z) {
                this.mLeftEdge.onPull(Math.abs(f4 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z2) {
                this.mRightEdge.onPull(Math.abs(scrollX - f5) / clientWidth);
                z3 = true;
            }
            scrollX = f5;
        }
        int i2 = (int) scrollX;
        this.mLastMotionX += scrollX - ((float) i2);
        scrollTo(i2, getScrollY());
        pageScrolled(i2);
        return z3;
    }

    private void recomputeScrollPosition(int i2, int i3, int i4, int i5) {
        if (i3 <= 0 || this.mItems.isEmpty()) {
            b infoForPosition = infoForPosition(this.mCurItem);
            int min = (int) ((infoForPosition != null ? Math.min(infoForPosition.f2130e, this.mLastOffset) : 0.0f) * ((float) ((i2 - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                completeScroll(false);
                scrollTo(min, getScrollY());
            }
        } else if (!this.mScroller.isFinished()) {
            this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
        } else {
            scrollTo((int) ((((float) getScrollX()) / ((float) (((i3 - getPaddingLeft()) - getPaddingRight()) + i5))) * ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))), getScrollY());
        }
    }

    private void removeNonDecorViews() {
        int i2 = 0;
        while (i2 < getChildCount()) {
            if (!((c) getChildAt(i2).getLayoutParams()).f2131a) {
                removeViewAt(i2);
                i2--;
            }
            i2++;
        }
    }

    private void requestParentDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean resetTouch() {
        this.mActivePointerId = -1;
        endDrag();
        this.mLeftEdge.onRelease();
        this.mRightEdge.onRelease();
        return this.mLeftEdge.isFinished() || this.mRightEdge.isFinished();
    }

    private void scrollToItem(int i2, boolean z, int i3, boolean z2) {
        b infoForPosition = infoForPosition(i2);
        int clientWidth = infoForPosition != null ? (int) (((float) getClientWidth()) * Math.max(this.mFirstOffset, Math.min(infoForPosition.f2130e, this.mLastOffset))) : 0;
        if (z) {
            smoothScrollTo(clientWidth, 0, i3);
            if (z2) {
                dispatchOnPageSelected(i2);
                return;
            }
            return;
        }
        if (z2) {
            dispatchOnPageSelected(i2);
        }
        completeScroll(false);
        scrollTo(clientWidth, 0);
        pageScrolled(clientWidth);
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.mScrollingCacheEnabled != z) {
            this.mScrollingCacheEnabled = z;
        }
    }

    private void sortChildDrawingOrder() {
        if (this.mDrawingOrder != 0) {
            ArrayList<View> arrayList = this.mDrawingOrderedChildren;
            if (arrayList == null) {
                this.mDrawingOrderedChildren = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.mDrawingOrderedChildren.add(getChildAt(i2));
            }
            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0) {
                    b infoForChild = infoForChild(childAt);
                    if (infoForChild != null && infoForChild.f2127b == this.mCurItem) {
                        childAt.addFocusables(arrayList, i2, i3);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i3 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    /* access modifiers changed from: 0000 */
    public b addNewItem(int i2, int i3) {
        b bVar = new b();
        bVar.f2127b = i2;
        bVar.f2126a = this.mAdapter.instantiateItem((ViewGroup) this, i2);
        bVar.f2129d = this.mAdapter.getPageWidth(i2);
        if (i3 < 0 || i3 >= this.mItems.size()) {
            this.mItems.add(bVar);
        } else {
            this.mItems.add(i3, bVar);
        }
        return bVar;
    }

    public void addOnAdapterChangeListener(e eVar) {
        if (this.mAdapterChangeListeners == null) {
            this.mAdapterChangeListeners = new ArrayList();
        }
        this.mAdapterChangeListeners.add(eVar);
    }

    public void addOnPageChangeListener(f fVar) {
        if (this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList();
        }
        this.mOnPageChangeListeners.add(fVar);
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                b infoForChild = infoForChild(childAt);
                if (infoForChild != null && infoForChild.f2127b == this.mCurItem) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    public void addView(View view, int i2, LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        c cVar = (c) layoutParams;
        cVar.f2131a |= isDecorView(view);
        if (!this.mInLayout) {
            super.addView(view, i2, layoutParams);
        } else if (cVar == null || !cVar.f2131a) {
            cVar.f2134d = true;
            addViewInLayout(view, i2, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public boolean arrowScroll(int i2) {
        boolean requestFocus;
        boolean z;
        View findFocus = findFocus();
        boolean z2 = false;
        View view = null;
        if (findFocus != this) {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z = false;
                        break;
                    } else if (parent == this) {
                        z = true;
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (!z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ");
                        sb.append(parent2.getClass().getSimpleName());
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("arrowScroll tried to find focus based on non-child current focused view ");
                    sb2.append(sb.toString());
                    Log.e(TAG, sb2.toString());
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i2);
        if (findNextFocus != null && findNextFocus != view) {
            if (i2 == 17) {
                int i3 = getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).left;
                int i4 = getChildRectInPagerCoordinates(this.mTempRect, view).left;
                if (view == null || i3 < i4) {
                    requestFocus = findNextFocus.requestFocus();
                } else {
                    requestFocus = pageLeft();
                }
            } else if (i2 == 66) {
                int i5 = getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).left;
                int i6 = getChildRectInPagerCoordinates(this.mTempRect, view).left;
                if (view == null || i5 > i6) {
                    requestFocus = findNextFocus.requestFocus();
                } else {
                    requestFocus = pageRight();
                }
            }
            z2 = requestFocus;
        } else if (i2 == 17 || i2 == 1) {
            z2 = pageLeft();
        } else if (i2 == 66 || i2 == 2) {
            z2 = pageRight();
        }
        if (z2) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i2));
        }
        return z2;
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return false;
        }
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
        this.mFakeDragBeginTime = uptimeMillis;
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean canScroll(View view, boolean z, int i2, int i3, int i4) {
        View view2 = view;
        boolean z2 = true;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i3 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight()) {
                    int i6 = i4 + scrollY;
                    if (i6 >= childAt.getTop() && i6 < childAt.getBottom()) {
                        if (canScroll(childAt, true, i2, i5 - childAt.getLeft(), i6 - childAt.getTop())) {
                            return true;
                        }
                    }
                }
            }
        }
        if (!z || !view.canScrollHorizontally(-i2)) {
            z2 = false;
        }
        return z2;
    }

    public boolean canScrollHorizontally(int i2) {
        boolean z = false;
        if (this.mAdapter == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i2 < 0) {
            if (scrollX > ((int) (((float) clientWidth) * this.mFirstOffset))) {
                z = true;
            }
            return z;
        }
        if (i2 > 0 && scrollX < ((int) (((float) clientWidth) * this.mLastOffset))) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof c) && super.checkLayoutParams(layoutParams);
    }

    public void clearOnPageChangeListeners() {
        List<f> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void computeScroll() {
        this.mIsScrollStarted = true;
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            completeScroll(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.mScroller.getCurrX();
        int currY = this.mScroller.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!pageScrolled(currX)) {
                this.mScroller.abortAnimation();
                scrollTo(0, currY);
            }
        }
        B.G(this);
    }

    /* access modifiers changed from: 0000 */
    public void dataSetChanged() {
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        boolean z = this.mItems.size() < (this.mOffscreenPageLimit * 2) + 1 && this.mItems.size() < count;
        int i2 = this.mCurItem;
        int i3 = 0;
        boolean z2 = false;
        while (i3 < this.mItems.size()) {
            b bVar = (b) this.mItems.get(i3);
            int itemPosition = this.mAdapter.getItemPosition(bVar.f2126a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.mItems.remove(i3);
                    i3--;
                    if (!z2) {
                        this.mAdapter.startUpdate((ViewGroup) this);
                        z2 = true;
                    }
                    this.mAdapter.destroyItem((ViewGroup) this, bVar.f2127b, bVar.f2126a);
                    int i4 = this.mCurItem;
                    if (i4 == bVar.f2127b) {
                        i2 = Math.max(0, Math.min(i4, count - 1));
                    }
                } else {
                    int i5 = bVar.f2127b;
                    if (i5 != itemPosition) {
                        if (i5 == this.mCurItem) {
                            i2 = itemPosition;
                        }
                        bVar.f2127b = itemPosition;
                    }
                }
                z = true;
            }
            i3++;
        }
        if (z2) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (z) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                c cVar = (c) getChildAt(i6).getLayoutParams();
                if (!cVar.f2131a) {
                    cVar.f2133c = 0.0f;
                }
            }
            setCurrentItemInternal(i2, false, true);
            requestLayout();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                b infoForChild = infoForChild(childAt);
                if (infoForChild != null && infoForChild.f2127b == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public float distanceInfluenceForSnapDuration(float f2) {
        return (float) Math.sin((double) ((f2 - 0.5f) * 0.47123894f));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r0.getCount() > 1) goto L_0x0024;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z = false;
        if (overScrollMode != 0) {
            if (overScrollMode == 1) {
                a aVar = this.mAdapter;
                if (aVar != null) {
                }
            }
            this.mLeftEdge.finish();
            this.mRightEdge.finish();
            if (!z) {
                B.G(this);
                return;
            }
            return;
        }
        if (!this.mLeftEdge.isFinished()) {
            int save = canvas.save();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int width = getWidth();
            canvas.rotate(270.0f);
            canvas.translate((float) ((-height) + getPaddingTop()), this.mFirstOffset * ((float) width));
            this.mLeftEdge.setSize(height, width);
            z = false | this.mLeftEdge.draw(canvas);
            canvas.restoreToCount(save);
        }
        if (!this.mRightEdge.isFinished()) {
            int save2 = canvas.save();
            int width2 = getWidth();
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(90.0f);
            canvas.translate((float) (-getPaddingTop()), (-(this.mLastOffset + 1.0f)) * ((float) width2));
            this.mRightEdge.setSize(height2, width2);
            z |= this.mRightEdge.draw(canvas);
            canvas.restoreToCount(save2);
        }
        if (!z) {
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public void endFakeDrag() {
        if (this.mFakeDragging) {
            if (this.mAdapter != null) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
                int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
                this.mPopulatePending = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                b infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.f2127b, ((((float) scrollX) / ((float) clientWidth)) - infoForCurrentScrollPosition.f2130e) / infoForCurrentScrollPosition.f2129d, xVelocity, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, xVelocity);
            }
            endDrag();
            this.mFakeDragging = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode != 22) {
                    if (keyCode == 61) {
                        if (keyEvent.hasNoModifiers()) {
                            return arrowScroll(2);
                        }
                        if (keyEvent.hasModifiers(1)) {
                            return arrowScroll(1);
                        }
                    }
                } else if (keyEvent.hasModifiers(2)) {
                    return pageRight();
                } else {
                    return arrowScroll(66);
                }
            } else if (keyEvent.hasModifiers(2)) {
                return pageLeft();
            } else {
                return arrowScroll(17);
            }
        }
        return false;
    }

    public void fakeDragBy(float f2) {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        } else if (this.mAdapter != null) {
            this.mLastMotionX += f2;
            float scrollX = ((float) getScrollX()) - f2;
            float clientWidth = (float) getClientWidth();
            float f3 = this.mFirstOffset * clientWidth;
            float f4 = this.mLastOffset * clientWidth;
            b bVar = (b) this.mItems.get(0);
            ArrayList<b> arrayList = this.mItems;
            b bVar2 = (b) arrayList.get(arrayList.size() - 1);
            if (bVar.f2127b != 0) {
                f3 = bVar.f2130e * clientWidth;
            }
            if (bVar2.f2127b != this.mAdapter.getCount() - 1) {
                f4 = bVar2.f2130e * clientWidth;
            }
            if (scrollX < f3) {
                scrollX = f3;
            } else if (scrollX > f4) {
                scrollX = f4;
            }
            int i2 = (int) scrollX;
            this.mLastMotionX += scrollX - ((float) i2);
            scrollTo(i2, getScrollY());
            pageScrolled(i2);
            MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0.0f, 0);
            this.mVelocityTracker.addMovement(obtain);
            obtain.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new c();
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public a getAdapter() {
        return this.mAdapter;
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        if (this.mDrawingOrder == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((c) ((View) this.mDrawingOrderedChildren.get(i3)).getLayoutParams()).f2136f;
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    /* access modifiers changed from: 0000 */
    public b infoForAnyChild(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return infoForChild(view);
            }
            if (parent != null && (parent instanceof View)) {
                view = (View) parent;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public b infoForChild(View view) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            b bVar = (b) this.mItems.get(i2);
            if (this.mAdapter.isViewFromObject(view, bVar.f2126a)) {
                return bVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public b infoForPosition(int i2) {
        for (int i3 = 0; i3 < this.mItems.size(); i3++) {
            b bVar = (b) this.mItems.get(i3);
            if (bVar.f2127b == i2) {
                return bVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int) (400.0f * f2);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffect(context);
        this.mRightEdge = new EdgeEffect(context);
        this.mFlingDistance = (int) (25.0f * f2);
        this.mCloseEnough = (int) (2.0f * f2);
        this.mDefaultGutterSize = (int) (f2 * 16.0f);
        B.a((View) this, (C0240a) new d());
        if (B.k(this) == 0) {
            B.e((View) this, 1);
        }
        B.a((View) this, (r) new e(this));
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        Scroller scroller = this.mScroller;
        if (scroller != null && !scroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f2;
        float f3;
        super.onDraw(canvas);
        if (this.mPageMargin > 0 && this.mMarginDrawable != null && this.mItems.size() > 0 && this.mAdapter != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f4 = (float) width;
            float f5 = ((float) this.mPageMargin) / f4;
            int i2 = 0;
            b bVar = (b) this.mItems.get(0);
            float f6 = bVar.f2130e;
            int size = this.mItems.size();
            int i3 = bVar.f2127b;
            int i4 = ((b) this.mItems.get(size - 1)).f2127b;
            while (i3 < i4) {
                while (i3 > bVar.f2127b && i2 < size) {
                    i2++;
                    bVar = (b) this.mItems.get(i2);
                }
                if (i3 == bVar.f2127b) {
                    float f7 = bVar.f2130e;
                    float f8 = bVar.f2129d;
                    f2 = (f7 + f8) * f4;
                    f6 = f7 + f8 + f5;
                } else {
                    float pageWidth = this.mAdapter.getPageWidth(i3);
                    f2 = (f6 + pageWidth) * f4;
                    f6 += pageWidth + f5;
                }
                if (((float) this.mPageMargin) + f2 > ((float) scrollX)) {
                    f3 = f5;
                    this.mMarginDrawable.setBounds(Math.round(f2), this.mTopPageBounds, Math.round(((float) this.mPageMargin) + f2), this.mBottomPageBounds);
                    this.mMarginDrawable.draw(canvas);
                } else {
                    Canvas canvas2 = canvas;
                    f3 = f5;
                }
                if (f2 <= ((float) (scrollX + width))) {
                    i3++;
                    f5 = f3;
                } else {
                    return;
                }
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            resetTouch();
            return false;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                return true;
            }
            if (this.mIsUnableToDrag) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.mInitialMotionX = x;
            this.mLastMotionX = x;
            float y = motionEvent.getY();
            this.mInitialMotionY = y;
            this.mLastMotionY = y;
            this.mActivePointerId = motionEvent2.getPointerId(0);
            this.mIsUnableToDrag = false;
            this.mIsScrollStarted = true;
            this.mScroller.computeScrollOffset();
            if (this.mScrollState != 2 || Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) <= this.mCloseEnough) {
                completeScroll(false);
                this.mIsBeingDragged = false;
            } else {
                this.mScroller.abortAnimation();
                this.mPopulatePending = false;
                populate();
                this.mIsBeingDragged = true;
                requestParentDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i2 = this.mActivePointerId;
            if (i2 != -1) {
                int findPointerIndex = motionEvent2.findPointerIndex(i2);
                float x2 = motionEvent2.getX(findPointerIndex);
                float f2 = x2 - this.mLastMotionX;
                float abs = Math.abs(f2);
                float y2 = motionEvent2.getY(findPointerIndex);
                float abs2 = Math.abs(y2 - this.mInitialMotionY);
                int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                if (i3 != 0 && !isGutterDrag(this.mLastMotionX, f2)) {
                    if (canScroll(this, false, (int) f2, (int) x2, (int) y2)) {
                        this.mLastMotionX = x2;
                        this.mLastMotionY = y2;
                        this.mIsUnableToDrag = true;
                        return false;
                    }
                }
                if (abs > ((float) this.mTouchSlop) && abs * 0.5f > abs2) {
                    this.mIsBeingDragged = true;
                    requestParentDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                    this.mLastMotionX = i3 > 0 ? this.mInitialMotionX + ((float) this.mTouchSlop) : this.mInitialMotionX - ((float) this.mTouchSlop);
                    this.mLastMotionY = y2;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > ((float) this.mTouchSlop)) {
                    this.mIsUnableToDrag = true;
                }
                if (this.mIsBeingDragged && performDrag(x2)) {
                    B.G(this);
                }
            }
        } else if (action == 6) {
            onSecondaryPointerUp(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent2);
        return this.mIsBeingDragged;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean z2;
        int i6;
        int i7;
        int childCount = getChildCount();
        int i8 = i4 - i2;
        int i9 = i5 - i3;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i10 = paddingBottom;
        int i11 = 0;
        int i12 = paddingTop;
        int i13 = paddingLeft;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f2131a) {
                    int i15 = cVar.f2132b;
                    int i16 = i15 & 7;
                    int i17 = i15 & 112;
                    if (i16 == 1) {
                        i6 = Math.max((i8 - childAt.getMeasuredWidth()) / 2, i13);
                    } else if (i16 == 3) {
                        i6 = i13;
                        i13 = childAt.getMeasuredWidth() + i13;
                    } else if (i16 != 5) {
                        i6 = i13;
                    } else {
                        i6 = (i8 - paddingRight) - childAt.getMeasuredWidth();
                        paddingRight += childAt.getMeasuredWidth();
                    }
                    if (i17 == 16) {
                        i7 = Math.max((i9 - childAt.getMeasuredHeight()) / 2, i12);
                    } else if (i17 == 48) {
                        i7 = i12;
                        i12 = childAt.getMeasuredHeight() + i12;
                    } else if (i17 != 80) {
                        i7 = i12;
                    } else {
                        i7 = (i9 - i10) - childAt.getMeasuredHeight();
                        i10 += childAt.getMeasuredHeight();
                    }
                    int i18 = i6 + scrollX;
                    childAt.layout(i18, i7, childAt.getMeasuredWidth() + i18, i7 + childAt.getMeasuredHeight());
                    i11++;
                }
            }
        }
        int i19 = (i8 - i13) - paddingRight;
        for (int i20 = 0; i20 < childCount; i20++) {
            View childAt2 = getChildAt(i20);
            if (childAt2.getVisibility() != 8) {
                c cVar2 = (c) childAt2.getLayoutParams();
                if (!cVar2.f2131a) {
                    b infoForChild = infoForChild(childAt2);
                    if (infoForChild != null) {
                        float f2 = (float) i19;
                        int i21 = ((int) (infoForChild.f2130e * f2)) + i13;
                        if (cVar2.f2134d) {
                            cVar2.f2134d = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (f2 * cVar2.f2133c), 1073741824), MeasureSpec.makeMeasureSpec((i9 - i12) - i10, 1073741824));
                        }
                        childAt2.layout(i21, i12, childAt2.getMeasuredWidth() + i21, childAt2.getMeasuredHeight() + i12);
                    }
                }
            }
        }
        this.mTopPageBounds = i12;
        this.mBottomPageBounds = i9 - i10;
        this.mDecorChildCount = i11;
        if (this.mFirstLayout) {
            z2 = false;
            scrollToItem(this.mCurItem, false, 0, false);
        } else {
            z2 = false;
        }
        this.mFirstLayout = z2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00aa  */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        setMeasuredDimension(ViewGroup.getDefaultSize(0, i2), ViewGroup.getDefaultSize(0, i3));
        int measuredWidth = getMeasuredWidth();
        this.mGutterSize = Math.min(measuredWidth / 10, this.mDefaultGutterSize);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i7 = measuredHeight;
        int i8 = paddingLeft;
        int i9 = 0;
        while (true) {
            boolean z = true;
            int i10 = 1073741824;
            if (i9 >= childCount) {
                break;
            }
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar != null && cVar.f2131a) {
                    int i11 = cVar.f2132b;
                    int i12 = i11 & 7;
                    int i13 = i11 & 112;
                    boolean z2 = i13 == 48 || i13 == 80;
                    if (!(i12 == 3 || i12 == 5)) {
                        z = false;
                    }
                    int i14 = Integer.MIN_VALUE;
                    if (z2) {
                        i14 = 1073741824;
                    } else if (z) {
                        i4 = 1073741824;
                        i5 = cVar.width;
                        if (i5 == -2) {
                            if (i5 == -1) {
                                i5 = i8;
                            }
                            i14 = 1073741824;
                        } else {
                            i5 = i8;
                        }
                        i6 = cVar.height;
                        if (i6 != -2) {
                            i6 = i7;
                            i10 = i4;
                        } else if (i6 == -1) {
                            i6 = i7;
                        }
                        childAt.measure(MeasureSpec.makeMeasureSpec(i5, i14), MeasureSpec.makeMeasureSpec(i6, i10));
                        if (!z2) {
                            i7 -= childAt.getMeasuredHeight();
                        } else if (z) {
                            i8 -= childAt.getMeasuredWidth();
                        }
                    }
                    i4 = Integer.MIN_VALUE;
                    i5 = cVar.width;
                    if (i5 == -2) {
                    }
                    i6 = cVar.height;
                    if (i6 != -2) {
                    }
                    childAt.measure(MeasureSpec.makeMeasureSpec(i5, i14), MeasureSpec.makeMeasureSpec(i6, i10));
                    if (!z2) {
                    }
                }
            }
            i9++;
        }
        this.mChildWidthMeasureSpec = MeasureSpec.makeMeasureSpec(i8, 1073741824);
        this.mChildHeightMeasureSpec = MeasureSpec.makeMeasureSpec(i7, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        int childCount2 = getChildCount();
        for (int i15 = 0; i15 < childCount2; i15++) {
            View childAt2 = getChildAt(i15);
            if (childAt2.getVisibility() != 8) {
                c cVar2 = (c) childAt2.getLayoutParams();
                if (cVar2 == null || !cVar2.f2131a) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (((float) i8) * cVar2.f2133c), 1073741824), this.mChildHeightMeasureSpec);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0066  */
    public void onPageScrolled(int i2, float f2, int i3) {
        int i4;
        int left;
        int i5;
        if (this.mDecorChildCount > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            int i6 = paddingRight;
            int i7 = paddingLeft;
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f2131a) {
                    int i9 = cVar.f2132b & 7;
                    if (i9 != 1) {
                        if (i9 == 3) {
                            i4 = childAt.getWidth() + i7;
                        } else if (i9 != 5) {
                            i4 = i7;
                        } else {
                            i5 = (width - i6) - childAt.getMeasuredWidth();
                            i6 += childAt.getMeasuredWidth();
                        }
                        left = (i7 + scrollX) - childAt.getLeft();
                        if (left != 0) {
                            childAt.offsetLeftAndRight(left);
                        }
                        i7 = i4;
                    } else {
                        i5 = Math.max((width - childAt.getMeasuredWidth()) / 2, i7);
                    }
                    int i10 = i5;
                    i4 = i7;
                    i7 = i10;
                    left = (i7 + scrollX) - childAt.getLeft();
                    if (left != 0) {
                    }
                    i7 = i4;
                }
            }
        }
        dispatchOnPageScrolled(i2, f2, i3);
        if (this.mPageTransformer != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i11 = 0; i11 < childCount2; i11++) {
                View childAt2 = getChildAt(i11);
                if (!((c) childAt2.getLayoutParams()).f2131a) {
                    this.mPageTransformer.a(childAt2, ((float) (childAt2.getLeft() - scrollX2)) / ((float) getClientWidth()));
                }
            }
        }
        this.mCalledSuper = true;
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        int childCount = getChildCount();
        int i5 = -1;
        if ((i2 & 2) != 0) {
            i5 = childCount;
            i4 = 0;
            i3 = 1;
        } else {
            i4 = childCount - 1;
            i3 = -1;
        }
        while (i4 != i5) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 0) {
                b infoForChild = infoForChild(childAt);
                if (infoForChild != null && infoForChild.f2127b == this.mCurItem && childAt.requestFocus(i2, rect)) {
                    return true;
                }
            }
            i4 += i3;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof i)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        i iVar = (i) parcelable;
        super.onRestoreInstanceState(iVar.n());
        a aVar = this.mAdapter;
        if (aVar != null) {
            aVar.restoreState(iVar.f2140d, iVar.f2141e);
            setCurrentItemInternal(iVar.f2139c, false, true);
        } else {
            this.mRestoredCurItem = iVar.f2139c;
            this.mRestoredAdapterState = iVar.f2140d;
            this.mRestoredClassLoader = iVar.f2141e;
        }
    }

    public Parcelable onSaveInstanceState() {
        i iVar = new i(super.onSaveInstanceState());
        iVar.f2139c = this.mCurItem;
        a aVar = this.mAdapter;
        if (aVar != null) {
            iVar.f2140d = aVar.saveState();
        }
        return iVar;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            int i6 = this.mPageMargin;
            recomputeScrollPosition(i2, i4, i6, i6);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mFakeDragging) {
            return true;
        }
        boolean z = false;
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        a aVar = this.mAdapter;
        if (aVar == null || aVar.getCount() == 0) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.mScroller.abortAnimation();
            this.mPopulatePending = false;
            populate();
            float x = motionEvent.getX();
            this.mInitialMotionX = x;
            this.mLastMotionX = x;
            float y = motionEvent.getY();
            this.mInitialMotionY = y;
            this.mLastMotionY = y;
            this.mActivePointerId = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.mIsBeingDragged) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        z = resetTouch();
                    } else {
                        float x2 = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x2 - this.mLastMotionX);
                        float y2 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y2 - this.mLastMotionY);
                        if (abs > ((float) this.mTouchSlop) && abs > abs2) {
                            this.mIsBeingDragged = true;
                            requestParentDisallowInterceptTouchEvent(true);
                            float f2 = this.mInitialMotionX;
                            this.mLastMotionX = x2 - f2 > 0.0f ? f2 + ((float) this.mTouchSlop) : f2 - ((float) this.mTouchSlop);
                            this.mLastMotionY = y2;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.mIsBeingDragged) {
                    z = false | performDrag(motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    this.mLastMotionX = motionEvent.getX(actionIndex);
                    this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                } else if (action == 6) {
                    onSecondaryPointerUp(motionEvent);
                    this.mLastMotionX = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                }
            } else if (this.mIsBeingDragged) {
                scrollToItem(this.mCurItem, true, 0, false);
                z = resetTouch();
            }
        } else if (this.mIsBeingDragged) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
            int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
            this.mPopulatePending = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            b infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            float f3 = (float) clientWidth;
            setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.f2127b, ((((float) scrollX) / f3) - infoForCurrentScrollPosition.f2130e) / (infoForCurrentScrollPosition.f2129d + (((float) this.mPageMargin) / f3)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX)), true, true, xVelocity);
            z = resetTouch();
        }
        if (z) {
            B.G(this);
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public boolean pageLeft() {
        int i2 = this.mCurItem;
        if (i2 <= 0) {
            return false;
        }
        setCurrentItem(i2 - 1, true);
        return true;
    }

    /* access modifiers changed from: 0000 */
    public boolean pageRight() {
        a aVar = this.mAdapter;
        if (aVar == null || this.mCurItem >= aVar.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void populate() {
        populate(this.mCurItem);
    }

    public void removeOnAdapterChangeListener(e eVar) {
        List<e> list = this.mAdapterChangeListeners;
        if (list != null) {
            list.remove(eVar);
        }
    }

    public void removeOnPageChangeListener(f fVar) {
        List<f> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.remove(fVar);
        }
    }

    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(a aVar) {
        a aVar2 = this.mAdapter;
        if (aVar2 != null) {
            aVar2.setViewPagerObserver(null);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i2 = 0; i2 < this.mItems.size(); i2++) {
                b bVar = (b) this.mItems.get(i2);
                this.mAdapter.destroyItem((ViewGroup) this, bVar.f2127b, bVar.f2126a);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            removeNonDecorViews();
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        a aVar3 = this.mAdapter;
        this.mAdapter = aVar;
        this.mExpectedAdapterCount = 0;
        if (this.mAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new h();
            }
            this.mAdapter.setViewPagerObserver(this.mObserver);
            this.mPopulatePending = false;
            boolean z = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (!z) {
                populate();
            } else {
                requestLayout();
            }
        }
        List<e> list = this.mAdapterChangeListeners;
        if (list != null && !list.isEmpty()) {
            int size = this.mAdapterChangeListeners.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((e) this.mAdapterChangeListeners.get(i3)).a(this, aVar3, aVar);
            }
        }
    }

    public void setCurrentItem(int i2) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i2, !this.mFirstLayout, false);
    }

    /* access modifiers changed from: 0000 */
    public void setCurrentItemInternal(int i2, boolean z, boolean z2) {
        setCurrentItemInternal(i2, z, z2, 0);
    }

    /* access modifiers changed from: 0000 */
    public f setInternalPageChangeListener(f fVar) {
        f fVar2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = fVar;
        return fVar2;
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested offscreen page limit ");
            sb.append(i2);
            sb.append(" too small; defaulting to ");
            sb.append(1);
            Log.w(TAG, sb.toString());
            i2 = 1;
        }
        if (i2 != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i2;
            populate();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(f fVar) {
        this.mOnPageChangeListener = fVar;
    }

    public void setPageMargin(int i2) {
        int i3 = this.mPageMargin;
        this.mPageMargin = i2;
        int width = getWidth();
        recomputeScrollPosition(width, width, i2, i3);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageTransformer(boolean z, g gVar) {
        setPageTransformer(z, gVar, 2);
    }

    /* access modifiers changed from: 0000 */
    public void setScrollState(int i2) {
        if (this.mScrollState != i2) {
            this.mScrollState = i2;
            if (this.mPageTransformer != null) {
                enableLayers(i2 != 0);
            }
            dispatchOnScrollStateChanged(i2);
        }
    }

    /* access modifiers changed from: 0000 */
    public void smoothScrollTo(int i2, int i3) {
        smoothScrollTo(i2, i3, 0);
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mMarginDrawable;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0060, code lost:
        if (r9 == r10) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0066, code lost:
        r8 = null;
     */
    public void populate(int i2) {
        b bVar;
        String str;
        b bVar2;
        float f2;
        float f3;
        b bVar3;
        int i3 = i2;
        int i4 = this.mCurItem;
        if (i4 != i3) {
            bVar = infoForPosition(i4);
            this.mCurItem = i3;
        } else {
            bVar = null;
        }
        if (this.mAdapter == null) {
            sortChildDrawingOrder();
        } else if (this.mPopulatePending) {
            sortChildDrawingOrder();
        } else if (getWindowToken() != null) {
            this.mAdapter.startUpdate((ViewGroup) this);
            int i5 = this.mOffscreenPageLimit;
            int max = Math.max(0, this.mCurItem - i5);
            int count = this.mAdapter.getCount();
            int min = Math.min(count - 1, this.mCurItem + i5);
            if (count == this.mExpectedAdapterCount) {
                int i6 = 0;
                while (true) {
                    if (i6 >= this.mItems.size()) {
                        break;
                    }
                    bVar2 = (b) this.mItems.get(i6);
                    int i7 = bVar2.f2127b;
                    int i8 = this.mCurItem;
                    if (i7 < i8) {
                        i6++;
                    }
                }
                if (bVar2 == null && count > 0) {
                    bVar2 = addNewItem(this.mCurItem, i6);
                }
                if (bVar2 != null) {
                    int i9 = i6 - 1;
                    b bVar4 = i9 >= 0 ? (b) this.mItems.get(i9) : null;
                    int clientWidth = getClientWidth();
                    if (clientWidth <= 0) {
                        f2 = 0.0f;
                    } else {
                        f2 = (2.0f - bVar2.f2129d) + (((float) getPaddingLeft()) / ((float) clientWidth));
                    }
                    int i10 = i9;
                    int i11 = i6;
                    float f4 = 0.0f;
                    for (int i12 = this.mCurItem - 1; i12 >= 0; i12--) {
                        if (f4 < f2 || i12 >= max) {
                            if (bVar4 == null || i12 != bVar4.f2127b) {
                                f4 += addNewItem(i12, i10 + 1).f2129d;
                                i11++;
                                if (i10 >= 0) {
                                    bVar3 = (b) this.mItems.get(i10);
                                    bVar4 = bVar3;
                                }
                            } else {
                                f4 += bVar4.f2129d;
                                i10--;
                                if (i10 >= 0) {
                                    bVar3 = (b) this.mItems.get(i10);
                                    bVar4 = bVar3;
                                }
                            }
                        } else if (bVar4 == null) {
                            break;
                        } else {
                            if (i12 == bVar4.f2127b && !bVar4.f2128c) {
                                this.mItems.remove(i10);
                                this.mAdapter.destroyItem((ViewGroup) this, i12, bVar4.f2126a);
                                i10--;
                                i11--;
                                if (i10 >= 0) {
                                    bVar3 = (b) this.mItems.get(i10);
                                    bVar4 = bVar3;
                                }
                            }
                        }
                        bVar3 = null;
                        bVar4 = bVar3;
                    }
                    float f5 = bVar2.f2129d;
                    int i13 = i11 + 1;
                    if (f5 < 2.0f) {
                        b bVar5 = i13 < this.mItems.size() ? (b) this.mItems.get(i13) : null;
                        if (clientWidth <= 0) {
                            f3 = 0.0f;
                        } else {
                            f3 = (((float) getPaddingRight()) / ((float) clientWidth)) + 2.0f;
                        }
                        int i14 = this.mCurItem;
                        while (true) {
                            i14++;
                            if (i14 >= count) {
                                break;
                            }
                            if (f5 < f3 || i14 <= min) {
                                if (bVar5 == null || i14 != bVar5.f2127b) {
                                    b addNewItem = addNewItem(i14, i13);
                                    i13++;
                                    f5 += addNewItem.f2129d;
                                    if (i13 < this.mItems.size()) {
                                        bVar5 = (b) this.mItems.get(i13);
                                    }
                                } else {
                                    f5 += bVar5.f2129d;
                                    i13++;
                                    if (i13 < this.mItems.size()) {
                                        bVar5 = (b) this.mItems.get(i13);
                                    }
                                }
                            } else if (bVar5 == null) {
                                break;
                            } else if (i14 == bVar5.f2127b && !bVar5.f2128c) {
                                this.mItems.remove(i13);
                                this.mAdapter.destroyItem((ViewGroup) this, i14, bVar5.f2126a);
                                if (i13 < this.mItems.size()) {
                                    bVar5 = (b) this.mItems.get(i13);
                                }
                            }
                            bVar5 = null;
                        }
                    }
                    calculatePageOffsets(bVar2, i11, bVar);
                    this.mAdapter.setPrimaryItem((ViewGroup) this, this.mCurItem, bVar2.f2126a);
                }
                this.mAdapter.finishUpdate((ViewGroup) this);
                int childCount = getChildCount();
                for (int i15 = 0; i15 < childCount; i15++) {
                    View childAt = getChildAt(i15);
                    c cVar = (c) childAt.getLayoutParams();
                    cVar.f2136f = i15;
                    if (!cVar.f2131a && cVar.f2133c == 0.0f) {
                        b infoForChild = infoForChild(childAt);
                        if (infoForChild != null) {
                            cVar.f2133c = infoForChild.f2129d;
                            cVar.f2135e = infoForChild.f2127b;
                        }
                    }
                }
                sortChildDrawingOrder();
                if (hasFocus()) {
                    View findFocus = findFocus();
                    b infoForAnyChild = findFocus != null ? infoForAnyChild(findFocus) : null;
                    if (infoForAnyChild == null || infoForAnyChild.f2127b != this.mCurItem) {
                        for (int i16 = 0; i16 < getChildCount(); i16++) {
                            View childAt2 = getChildAt(i16);
                            b infoForChild2 = infoForChild(childAt2);
                            if (infoForChild2 != null && infoForChild2.f2127b == this.mCurItem && childAt2.requestFocus(2)) {
                                break;
                            }
                        }
                    }
                }
                return;
            }
            try {
                str = getResources().getResourceName(getId());
            } catch (NotFoundException unused) {
                str = Integer.toHexString(getId());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ");
            sb.append(this.mExpectedAdapterCount);
            sb.append(", found: ");
            sb.append(count);
            sb.append(" Pager id: ");
            sb.append(str);
            sb.append(" Pager class: ");
            sb.append(getClass());
            sb.append(" Problematic adapter: ");
            sb.append(this.mAdapter.getClass());
            throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public void setCurrentItemInternal(int i2, boolean z, boolean z2, int i3) {
        a aVar = this.mAdapter;
        if (aVar == null || aVar.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.mCurItem != i2 || this.mItems.size() == 0) {
            boolean z3 = true;
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 >= this.mAdapter.getCount()) {
                i2 = this.mAdapter.getCount() - 1;
            }
            int i4 = this.mOffscreenPageLimit;
            int i5 = this.mCurItem;
            if (i2 > i5 + i4 || i2 < i5 - i4) {
                for (int i6 = 0; i6 < this.mItems.size(); i6++) {
                    ((b) this.mItems.get(i6)).f2128c = true;
                }
            }
            if (this.mCurItem == i2) {
                z3 = false;
            }
            if (this.mFirstLayout) {
                this.mCurItem = i2;
                if (z3) {
                    dispatchOnPageSelected(i2);
                }
                requestLayout();
            } else {
                populate(i2);
                scrollToItem(i2, z, i3, z3);
            }
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    public void setPageTransformer(boolean z, g gVar, int i2) {
        int i3 = 1;
        boolean z2 = gVar != null;
        boolean z3 = z2 != (this.mPageTransformer != null);
        this.mPageTransformer = gVar;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            if (z) {
                i3 = 2;
            }
            this.mDrawingOrder = i3;
            this.mPageTransformerLayerType = i2;
        } else {
            this.mDrawingOrder = 0;
        }
        if (z3) {
            populate();
        }
    }

    /* access modifiers changed from: 0000 */
    public void smoothScrollTo(int i2, int i3, int i4) {
        int i5;
        int i6;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.mScroller;
        if (scroller != null && !scroller.isFinished()) {
            i5 = this.mIsScrollStarted ? this.mScroller.getCurrX() : this.mScroller.getStartX();
            this.mScroller.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            i5 = getScrollX();
        }
        int i7 = i5;
        int scrollY = getScrollY();
        int i8 = i2 - i7;
        int i9 = i3 - scrollY;
        if (i8 == 0 && i9 == 0) {
            completeScroll(false);
            populate();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i10 = clientWidth / 2;
        float f2 = (float) clientWidth;
        float f3 = (float) i10;
        float distanceInfluenceForSnapDuration = f3 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (((float) Math.abs(i8)) * 1.0f) / f2)) * f3);
        int abs = Math.abs(i4);
        if (abs > 0) {
            i6 = Math.round(Math.abs(distanceInfluenceForSnapDuration / ((float) abs)) * 1000.0f) * 4;
        } else {
            i6 = (int) (((((float) Math.abs(i8)) / ((f2 * this.mAdapter.getPageWidth(this.mCurItem)) + ((float) this.mPageMargin))) + 1.0f) * 100.0f);
        }
        int min = Math.min(i6, MAX_SETTLE_DURATION);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(i7, scrollY, i8, i9, min);
        B.G(this);
    }

    public void setCurrentItem(int i2, boolean z) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i2, z, false);
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(b.g.a.a.c(getContext(), i2));
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initViewPager();
    }
}
