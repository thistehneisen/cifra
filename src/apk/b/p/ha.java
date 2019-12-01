package b.p;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import b.p.E.c;

/* compiled from: Visibility */
public abstract class ha extends E {
    private static final String[] K = {"android:visibility:visibility", "android:visibility:parent"};
    private int L = 3;

    /* compiled from: Visibility */
    private static class a extends AnimatorListenerAdapter implements c, C0036a {

        /* renamed from: a reason: collision with root package name */
        private final View f2885a;

        /* renamed from: b reason: collision with root package name */
        private final int f2886b;

        /* renamed from: c reason: collision with root package name */
        private final ViewGroup f2887c;

        /* renamed from: d reason: collision with root package name */
        private final boolean f2888d;

        /* renamed from: e reason: collision with root package name */
        private boolean f2889e;

        /* renamed from: f reason: collision with root package name */
        boolean f2890f = false;

        a(View view, int i2, boolean z) {
            this.f2885a = view;
            this.f2886b = i2;
            this.f2887c = (ViewGroup) view.getParent();
            this.f2888d = z;
            a(true);
        }

        private void a() {
            if (!this.f2890f) {
                ba.a(this.f2885a, this.f2886b);
                ViewGroup viewGroup = this.f2887c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            a(false);
        }

        public void a(E e2) {
        }

        public void b(E e2) {
            a(false);
        }

        public void c(E e2) {
            a();
            e2.b((c) this);
        }

        public void d(E e2) {
            a(true);
        }

        public void onAnimationCancel(Animator animator) {
            this.f2890f = true;
        }

        public void onAnimationEnd(Animator animator) {
            a();
        }

        public void onAnimationPause(Animator animator) {
            if (!this.f2890f) {
                ba.a(this.f2885a, this.f2886b);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationResume(Animator animator) {
            if (!this.f2890f) {
                ba.a(this.f2885a, 0);
            }
        }

        public void onAnimationStart(Animator animator) {
        }

        private void a(boolean z) {
            if (this.f2888d && this.f2889e != z) {
                ViewGroup viewGroup = this.f2887c;
                if (viewGroup != null) {
                    this.f2889e = z;
                    S.a(viewGroup, z);
                }
            }
        }
    }

    /* compiled from: Visibility */
    private static class b {

        /* renamed from: a reason: collision with root package name */
        boolean f2891a;

        /* renamed from: b reason: collision with root package name */
        boolean f2892b;

        /* renamed from: c reason: collision with root package name */
        int f2893c;

        /* renamed from: d reason: collision with root package name */
        int f2894d;

        /* renamed from: e reason: collision with root package name */
        ViewGroup f2895e;

        /* renamed from: f reason: collision with root package name */
        ViewGroup f2896f;

        b() {
        }
    }

    private b b(M m, M m2) {
        b bVar = new b();
        bVar.f2891a = false;
        bVar.f2892b = false;
        String str = "android:visibility:parent";
        String str2 = "android:visibility:visibility";
        if (m == null || !m.f2839a.containsKey(str2)) {
            bVar.f2893c = -1;
            bVar.f2895e = null;
        } else {
            bVar.f2893c = ((Integer) m.f2839a.get(str2)).intValue();
            bVar.f2895e = (ViewGroup) m.f2839a.get(str);
        }
        if (m2 == null || !m2.f2839a.containsKey(str2)) {
            bVar.f2894d = -1;
            bVar.f2896f = null;
        } else {
            bVar.f2894d = ((Integer) m2.f2839a.get(str2)).intValue();
            bVar.f2896f = (ViewGroup) m2.f2839a.get(str);
        }
        if (m == null || m2 == null) {
            if (m == null && bVar.f2894d == 0) {
                bVar.f2892b = true;
                bVar.f2891a = true;
            } else if (m2 == null && bVar.f2893c == 0) {
                bVar.f2892b = false;
                bVar.f2891a = true;
            }
        } else if (bVar.f2893c == bVar.f2894d && bVar.f2895e == bVar.f2896f) {
            return bVar;
        } else {
            int i2 = bVar.f2893c;
            int i3 = bVar.f2894d;
            if (i2 != i3) {
                if (i2 == 0) {
                    bVar.f2892b = false;
                    bVar.f2891a = true;
                } else if (i3 == 0) {
                    bVar.f2892b = true;
                    bVar.f2891a = true;
                }
            } else if (bVar.f2896f == null) {
                bVar.f2892b = false;
                bVar.f2891a = true;
            } else if (bVar.f2895e == null) {
                bVar.f2892b = true;
                bVar.f2891a = true;
            }
        }
        return bVar;
    }

    private void d(M m) {
        String str = "android:visibility:visibility";
        m.f2839a.put(str, Integer.valueOf(m.f2840b.getVisibility()));
        m.f2839a.put("android:visibility:parent", m.f2840b.getParent());
        int[] iArr = new int[2];
        m.f2840b.getLocationOnScreen(iArr);
        m.f2839a.put("android:visibility:screenLocation", iArr);
    }

    public abstract Animator a(ViewGroup viewGroup, View view, M m, M m2);

    public void a(int i2) {
        if ((i2 & -4) == 0) {
            this.L = i2;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    public abstract Animator b(ViewGroup viewGroup, View view, M m, M m2);

    public void c(M m) {
        d(m);
    }

    public String[] m() {
        return K;
    }

    public void a(M m) {
        d(m);
    }

    public Animator a(ViewGroup viewGroup, M m, M m2) {
        b b2 = b(m, m2);
        if (!b2.f2891a || (b2.f2895e == null && b2.f2896f == null)) {
            return null;
        }
        if (b2.f2892b) {
            return a(viewGroup, m, b2.f2893c, m2, b2.f2894d);
        }
        return b(viewGroup, m, b2.f2893c, m2, b2.f2894d);
    }

    public Animator a(ViewGroup viewGroup, M m, int i2, M m2, int i3) {
        if ((this.L & 1) != 1 || m2 == null) {
            return null;
        }
        if (m == null) {
            View view = (View) m2.f2840b.getParent();
            if (b(a(view, false), b(view, false)).f2891a) {
                return null;
            }
        }
        return a(viewGroup, m2.f2840b, m, m2);
    }

    public boolean a(M m, M m2) {
        boolean z = false;
        if (m == null && m2 == null) {
            return false;
        }
        if (!(m == null || m2 == null)) {
            String str = "android:visibility:visibility";
            if (m2.f2839a.containsKey(str) != m.f2839a.containsKey(str)) {
                return false;
            }
        }
        b b2 = b(m, m2);
        if (b2.f2891a && (b2.f2893c == 0 || b2.f2894d == 0)) {
            z = true;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x007d, code lost:
        if (r6.z != false) goto L_0x003a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0087 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ee A[RETURN] */
    public Animator b(ViewGroup viewGroup, M m, int i2, M m2, int i3) {
        if ((this.L & 2) != 2) {
            return null;
        }
        View view = m != null ? m.f2840b : null;
        View view2 = m2 != null ? m2.f2840b : null;
        if (view2 == null || view2.getParent() == null) {
            if (view2 != null) {
                view = view2;
            } else {
                if (view != null) {
                    if (view.getParent() != null) {
                        if (view.getParent() instanceof View) {
                            View view3 = (View) view.getParent();
                            if (!b(b(view3, true), a(view3, true)).f2891a) {
                                view = L.a(viewGroup, view, view3);
                            } else {
                                if (view3.getParent() == null) {
                                    int id = view3.getId();
                                    if (id != -1) {
                                        if (viewGroup.findViewById(id) != null) {
                                        }
                                    }
                                }
                                view = null;
                            }
                        }
                    }
                }
                view = null;
                view2 = null;
                if (view == null && m != null) {
                    int[] iArr = (int[]) m.f2839a.get("android:visibility:screenLocation");
                    int i4 = iArr[0];
                    int i5 = iArr[1];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr2);
                    view.offsetLeftAndRight((i4 - iArr2[0]) - view.getLeft());
                    view.offsetTopAndBottom((i5 - iArr2[1]) - view.getTop());
                    Q a2 = S.a(viewGroup);
                    a2.a(view);
                    Animator b2 = b(viewGroup, view, m, m2);
                    if (b2 == null) {
                        a2.b(view);
                    } else {
                        b2.addListener(new ga(this, a2, view));
                    }
                    return b2;
                } else if (view2 == null) {
                    return null;
                } else {
                    int visibility = view2.getVisibility();
                    ba.a(view2, 0);
                    Animator b3 = b(viewGroup, view2, m, m2);
                    if (b3 != null) {
                        a aVar = new a(view2, i3, true);
                        b3.addListener(aVar);
                        C0255a.a(b3, aVar);
                        a((c) aVar);
                    } else {
                        ba.a(view2, visibility);
                    }
                    return b3;
                }
            }
        } else if (i3 == 4 || view == view2) {
            view = null;
            if (view == null) {
            }
            if (view2 == null) {
            }
        } else if (!this.z) {
            view = L.a(viewGroup, view, (View) view.getParent());
        }
        view2 = null;
        if (view == null) {
        }
        if (view2 == null) {
        }
    }
}
