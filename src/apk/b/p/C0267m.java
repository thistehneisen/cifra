package b.p;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import b.g.i.B;
import b.p.E.c;

/* renamed from: b.p.m reason: case insensitive filesystem */
/* compiled from: ChangeBounds */
public class C0267m extends E {
    private static final String[] K = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> L = new C0258d(PointF.class, "boundsOrigin");
    private static final Property<a, PointF> M;
    private static final Property<a, PointF> N;
    private static final Property<View, PointF> O;
    private static final Property<View, PointF> P;
    private static final Property<View, PointF> Q = new C0263i(PointF.class, "position");
    private static C0279z R = new C0279z();
    private int[] S = new int[2];
    private boolean T = false;
    private boolean U = false;

    /* renamed from: b.p.m$a */
    /* compiled from: ChangeBounds */
    private static class a {

        /* renamed from: a reason: collision with root package name */
        private int f2912a;

        /* renamed from: b reason: collision with root package name */
        private int f2913b;

        /* renamed from: c reason: collision with root package name */
        private int f2914c;

        /* renamed from: d reason: collision with root package name */
        private int f2915d;

        /* renamed from: e reason: collision with root package name */
        private View f2916e;

        /* renamed from: f reason: collision with root package name */
        private int f2917f;

        /* renamed from: g reason: collision with root package name */
        private int f2918g;

        a(View view) {
            this.f2916e = view;
        }

        /* access modifiers changed from: 0000 */
        public void a(PointF pointF) {
            this.f2914c = Math.round(pointF.x);
            this.f2915d = Math.round(pointF.y);
            this.f2918g++;
            if (this.f2917f == this.f2918g) {
                a();
            }
        }

        /* access modifiers changed from: 0000 */
        public void b(PointF pointF) {
            this.f2912a = Math.round(pointF.x);
            this.f2913b = Math.round(pointF.y);
            this.f2917f++;
            if (this.f2917f == this.f2918g) {
                a();
            }
        }

        private void a() {
            ba.a(this.f2916e, this.f2912a, this.f2913b, this.f2914c, this.f2915d);
            this.f2917f = 0;
            this.f2918g = 0;
        }
    }

    static {
        String str = "topLeft";
        M = new C0259e(PointF.class, str);
        String str2 = "bottomRight";
        N = new C0260f(PointF.class, str2);
        O = new C0261g(PointF.class, str2);
        P = new C0262h(PointF.class, str);
    }

    private void d(M m) {
        View view = m.f2840b;
        if (B.C(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            m.f2839a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            m.f2839a.put("android:changeBounds:parent", m.f2840b.getParent());
            if (this.U) {
                m.f2840b.getLocationInWindow(this.S);
                m.f2839a.put("android:changeBounds:windowX", Integer.valueOf(this.S[0]));
                m.f2839a.put("android:changeBounds:windowY", Integer.valueOf(this.S[1]));
            }
            if (this.T) {
                m.f2839a.put("android:changeBounds:clip", B.g(view));
            }
        }
    }

    public void a(M m) {
        d(m);
    }

    public void c(M m) {
        d(m);
    }

    public String[] m() {
        return K;
    }

    private boolean a(View view, View view2) {
        if (!this.U) {
            return true;
        }
        M a2 = a(view, true);
        if (a2 == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == a2.f2840b) {
            return true;
        }
        return false;
    }

    public Animator a(ViewGroup viewGroup, M m, M m2) {
        int i2;
        View view;
        Animator animator;
        Animator animator2;
        int i3;
        Rect rect;
        ObjectAnimator objectAnimator;
        M m3 = m;
        M m4 = m2;
        if (m3 == null || m4 == null) {
            return null;
        }
        String str = "android:changeBounds:parent";
        ViewGroup viewGroup2 = (ViewGroup) m3.f2839a.get(str);
        ViewGroup viewGroup3 = (ViewGroup) m4.f2839a.get(str);
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = m4.f2840b;
        if (a(viewGroup2, viewGroup3)) {
            String str2 = "android:changeBounds:bounds";
            Rect rect2 = (Rect) m3.f2839a.get(str2);
            Rect rect3 = (Rect) m4.f2839a.get(str2);
            int i4 = rect2.left;
            int i5 = rect3.left;
            int i6 = rect2.top;
            int i7 = rect3.top;
            int i8 = rect2.right;
            int i9 = rect3.right;
            int i10 = rect2.bottom;
            int i11 = rect3.bottom;
            int i12 = i8 - i4;
            int i13 = i10 - i6;
            int i14 = i9 - i5;
            int i15 = i11 - i7;
            View view3 = view2;
            String str3 = "android:changeBounds:clip";
            Rect rect4 = (Rect) m3.f2839a.get(str3);
            Rect rect5 = (Rect) m4.f2839a.get(str3);
            if ((i12 == 0 || i13 == 0) && (i14 == 0 || i15 == 0)) {
                i2 = 0;
            } else {
                i2 = (i4 == i5 && i6 == i7) ? 0 : 1;
                if (!(i8 == i9 && i10 == i11)) {
                    i2++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i2++;
            }
            if (i2 > 0) {
                Rect rect6 = rect5;
                Rect rect7 = rect4;
                if (!this.T) {
                    view = view3;
                    ba.a(view, i4, i6, i8, i10);
                    if (i2 == 2) {
                        if (i12 == i14 && i13 == i15) {
                            animator = C0274u.a(view, Q, f().a((float) i4, (float) i6, (float) i5, (float) i7));
                        } else {
                            a aVar = new a(view);
                            ObjectAnimator a2 = C0274u.a(aVar, M, f().a((float) i4, (float) i6, (float) i5, (float) i7));
                            ObjectAnimator a3 = C0274u.a(aVar, N, f().a((float) i8, (float) i10, (float) i9, (float) i11));
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.playTogether(new Animator[]{a2, a3});
                            animatorSet.addListener(new C0264j(this, aVar));
                            animator = animatorSet;
                        }
                    } else if (i4 == i5 && i6 == i7) {
                        animator = C0274u.a(view, O, f().a((float) i8, (float) i10, (float) i9, (float) i11));
                    } else {
                        animator = C0274u.a(view, P, f().a((float) i4, (float) i6, (float) i5, (float) i7));
                    }
                } else {
                    view = view3;
                    ba.a(view, i4, i6, Math.max(i12, i14) + i4, Math.max(i13, i15) + i6);
                    if (i4 == i5 && i6 == i7) {
                        animator2 = null;
                    } else {
                        animator2 = C0274u.a(view, Q, f().a((float) i4, (float) i6, (float) i5, (float) i7));
                    }
                    if (rect7 == null) {
                        i3 = 0;
                        rect = new Rect(0, 0, i12, i13);
                    } else {
                        i3 = 0;
                        rect = rect7;
                    }
                    Rect rect8 = rect6 == null ? new Rect(i3, i3, i14, i15) : rect6;
                    if (!rect.equals(rect8)) {
                        B.a(view, rect);
                        C0279z zVar = R;
                        Object[] objArr = new Object[2];
                        objArr[i3] = rect;
                        objArr[1] = rect8;
                        objectAnimator = ObjectAnimator.ofObject(view, "clipBounds", zVar, objArr);
                        C0265k kVar = new C0265k(this, view, rect6, i5, i7, i9, i11);
                        objectAnimator.addListener(kVar);
                    } else {
                        objectAnimator = null;
                    }
                    animator = L.a(animator2, objectAnimator);
                }
                if (view.getParent() instanceof ViewGroup) {
                    ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                    S.a(viewGroup4, true);
                    a((c) new C0266l(this, viewGroup4));
                }
                return animator;
            }
        } else {
            String str4 = "android:changeBounds:windowX";
            int intValue = ((Integer) m3.f2839a.get(str4)).intValue();
            String str5 = "android:changeBounds:windowY";
            int intValue2 = ((Integer) m3.f2839a.get(str5)).intValue();
            int intValue3 = ((Integer) m4.f2839a.get(str4)).intValue();
            int intValue4 = ((Integer) m4.f2839a.get(str5)).intValue();
            if (!(intValue == intValue3 && intValue2 == intValue4)) {
                viewGroup.getLocationInWindow(this.S);
                Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Config.ARGB_8888);
                view2.draw(new Canvas(createBitmap));
                BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
                float c2 = ba.c(view2);
                ba.a(view2, 0.0f);
                ba.b(viewGroup).a(bitmapDrawable);
                C0275v f2 = f();
                int[] iArr = this.S;
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, new PropertyValuesHolder[]{C0277x.a(L, f2.a((float) (intValue - iArr[0]), (float) (intValue2 - iArr[1]), (float) (intValue3 - iArr[0]), (float) (intValue4 - iArr[1])))});
                C0257c cVar = new C0257c(this, viewGroup, bitmapDrawable, view2, c2);
                ofPropertyValuesHolder.addListener(cVar);
                return ofPropertyValuesHolder;
            }
        }
        return null;
    }
}
