package b.i.b;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: FocusStrategy */
class d {

    /* compiled from: FocusStrategy */
    public interface a<T> {
        void a(T t, Rect rect);
    }

    /* compiled from: FocusStrategy */
    public interface b<T, V> {
        int a(T t);

        V a(T t, int i2);
    }

    /* compiled from: FocusStrategy */
    private static class c<T> implements Comparator<T> {

        /* renamed from: a reason: collision with root package name */
        private final Rect f2754a = new Rect();

        /* renamed from: b reason: collision with root package name */
        private final Rect f2755b = new Rect();

        /* renamed from: c reason: collision with root package name */
        private final boolean f2756c;

        /* renamed from: d reason: collision with root package name */
        private final a<T> f2757d;

        c(boolean z, a<T> aVar) {
            this.f2756c = z;
            this.f2757d = aVar;
        }

        public int compare(T t, T t2) {
            Rect rect = this.f2754a;
            Rect rect2 = this.f2755b;
            this.f2757d.a(t, rect);
            this.f2757d.a(t2, rect2);
            int i2 = rect.top;
            int i3 = rect2.top;
            int i4 = -1;
            if (i2 < i3) {
                return -1;
            }
            if (i2 > i3) {
                return 1;
            }
            int i5 = rect.left;
            int i6 = rect2.left;
            if (i5 < i6) {
                if (this.f2756c) {
                    i4 = 1;
                }
                return i4;
            } else if (i5 > i6) {
                if (!this.f2756c) {
                    i4 = 1;
                }
                return i4;
            } else {
                int i7 = rect.bottom;
                int i8 = rect2.bottom;
                if (i7 < i8) {
                    return -1;
                }
                if (i7 > i8) {
                    return 1;
                }
                int i9 = rect.right;
                int i10 = rect2.right;
                if (i9 < i10) {
                    if (this.f2756c) {
                        i4 = 1;
                    }
                    return i4;
                } else if (i9 <= i10) {
                    return 0;
                } else {
                    if (!this.f2756c) {
                        i4 = 1;
                    }
                    return i4;
                }
            }
        }
    }

    private static int a(int i2, int i3) {
        return (i2 * 13 * i2) + (i3 * i3);
    }

    public static <L, T> T a(L l2, b<L, T> bVar, a<T> aVar, T t, int i2, boolean z, boolean z2) {
        int a2 = bVar.a(l2);
        ArrayList arrayList = new ArrayList(a2);
        for (int i3 = 0; i3 < a2; i3++) {
            arrayList.add(bVar.a(l2, i3));
        }
        Collections.sort(arrayList, new c(z, aVar));
        if (i2 == 1) {
            return b(t, arrayList, z2);
        }
        if (i2 == 2) {
            return a(t, arrayList, z2);
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    }

    private static <T> T b(T t, ArrayList<T> arrayList, boolean z) {
        int i2;
        int size = arrayList.size();
        if (t == null) {
            i2 = size;
        } else {
            i2 = arrayList.indexOf(t);
        }
        int i3 = i2 - 1;
        if (i3 >= 0) {
            return arrayList.get(i3);
        }
        if (!z || size <= 0) {
            return null;
        }
        return arrayList.get(size - 1);
    }

    private static int c(int i2, Rect rect, Rect rect2) {
        return Math.max(0, d(i2, rect, rect2));
    }

    private static int d(int i2, Rect rect, Rect rect2) {
        int i3;
        int i4;
        if (i2 == 17) {
            i3 = rect.left;
            i4 = rect2.right;
        } else if (i2 == 33) {
            i3 = rect.top;
            i4 = rect2.bottom;
        } else if (i2 == 66) {
            i3 = rect2.left;
            i4 = rect.right;
        } else if (i2 == 130) {
            i3 = rect2.top;
            i4 = rect.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return i3 - i4;
    }

    private static int e(int i2, Rect rect, Rect rect2) {
        return Math.max(1, f(i2, rect, rect2));
    }

    private static int f(int i2, Rect rect, Rect rect2) {
        int i3;
        int i4;
        if (i2 == 17) {
            i3 = rect.left;
            i4 = rect2.left;
        } else if (i2 == 33) {
            i3 = rect.top;
            i4 = rect2.top;
        } else if (i2 == 66) {
            i3 = rect2.right;
            i4 = rect.right;
        } else if (i2 == 130) {
            i3 = rect2.bottom;
            i4 = rect.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return i3 - i4;
    }

    private static int g(int i2, Rect rect, Rect rect2) {
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs((rect.left + (rect.width() / 2)) - (rect2.left + (rect2.width() / 2)));
        }
        return Math.abs((rect.top + (rect.height() / 2)) - (rect2.top + (rect2.height() / 2)));
    }

    private static boolean b(int i2, Rect rect, Rect rect2, Rect rect3) {
        boolean z = false;
        if (!a(rect, rect2, i2)) {
            return false;
        }
        if (!a(rect, rect3, i2) || a(i2, rect, rect2, rect3)) {
            return true;
        }
        if (a(i2, rect, rect3, rect2)) {
            return false;
        }
        if (a(c(i2, rect, rect2), g(i2, rect, rect2)) < a(c(i2, rect, rect3), g(i2, rect, rect3))) {
            z = true;
        }
        return z;
    }

    private static <T> T a(T t, ArrayList<T> arrayList, boolean z) {
        int i2;
        int size = arrayList.size();
        if (t == null) {
            i2 = -1;
        } else {
            i2 = arrayList.lastIndexOf(t);
        }
        int i3 = i2 + 1;
        if (i3 < size) {
            return arrayList.get(i3);
        }
        if (!z || size <= 0) {
            return null;
        }
        return arrayList.get(0);
    }

    public static <L, T> T a(L l2, b<L, T> bVar, a<T> aVar, T t, Rect rect, int i2) {
        Rect rect2 = new Rect(rect);
        if (i2 == 17) {
            rect2.offset(rect.width() + 1, 0);
        } else if (i2 == 33) {
            rect2.offset(0, rect.height() + 1);
        } else if (i2 == 66) {
            rect2.offset(-(rect.width() + 1), 0);
        } else if (i2 == 130) {
            rect2.offset(0, -(rect.height() + 1));
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        T t2 = null;
        int a2 = bVar.a(l2);
        Rect rect3 = new Rect();
        for (int i3 = 0; i3 < a2; i3++) {
            T a3 = bVar.a(l2, i3);
            if (a3 != t) {
                aVar.a(a3, rect3);
                if (b(i2, rect, rect3, rect2)) {
                    rect2.set(rect3);
                    t2 = a3;
                }
            }
        }
        return t2;
    }

    private static boolean b(int i2, Rect rect, Rect rect2) {
        boolean z = true;
        if (i2 == 17) {
            if (rect.left < rect2.right) {
                z = false;
            }
            return z;
        } else if (i2 == 33) {
            if (rect.top < rect2.bottom) {
                z = false;
            }
            return z;
        } else if (i2 == 66) {
            if (rect.right > rect2.left) {
                z = false;
            }
            return z;
        } else if (i2 == 130) {
            if (rect.bottom > rect2.top) {
                z = false;
            }
            return z;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    private static boolean a(int i2, Rect rect, Rect rect2, Rect rect3) {
        boolean a2 = a(i2, rect, rect2);
        if (a(i2, rect, rect3) || !a2) {
            return false;
        }
        boolean z = true;
        if (!b(i2, rect, rect3)) {
            return true;
        }
        if (!(i2 == 17 || i2 == 66 || c(i2, rect, rect2) < e(i2, rect, rect3))) {
            z = false;
        }
        return z;
    }

    private static boolean a(Rect rect, Rect rect2, int i2) {
        boolean z = true;
        if (i2 == 17) {
            int i3 = rect.right;
            int i4 = rect2.right;
            if ((i3 <= i4 && rect.left < i4) || rect.left <= rect2.left) {
                z = false;
            }
            return z;
        } else if (i2 == 33) {
            int i5 = rect.bottom;
            int i6 = rect2.bottom;
            if ((i5 <= i6 && rect.top < i6) || rect.top <= rect2.top) {
                z = false;
            }
            return z;
        } else if (i2 == 66) {
            int i7 = rect.left;
            int i8 = rect2.left;
            if ((i7 >= i8 && rect.right > i8) || rect.right >= rect2.right) {
                z = false;
            }
            return z;
        } else if (i2 == 130) {
            int i9 = rect.top;
            int i10 = rect2.top;
            if ((i9 >= i10 && rect.bottom > i10) || rect.bottom >= rect2.bottom) {
                z = false;
            }
            return z;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    private static boolean a(int i2, Rect rect, Rect rect2) {
        boolean z = true;
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            if (rect2.right < rect.left || rect2.left > rect.right) {
                z = false;
            }
            return z;
        }
        if (rect2.bottom < rect.top || rect2.top > rect.bottom) {
            z = false;
        }
        return z;
    }
}
