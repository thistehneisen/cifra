package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.C0200o.a;
import androidx.lifecycle.h;
import b.g.h.b;
import java.io.PrintWriter;
import java.util.ArrayList;

/* renamed from: androidx.fragment.app.a reason: case insensitive filesystem */
/* compiled from: BackStackRecord */
final class C0186a extends F implements a, e {
    final C0207w s;
    boolean t;
    int u = -1;

    public C0186a(C0207w wVar) {
        this.s = wVar;
    }

    public void a(String str, PrintWriter printWriter) {
        a(str, printWriter, true);
    }

    public F b(Fragment fragment) {
        C0207w wVar = fragment.mFragmentManager;
        if (wVar == null || wVar == this.s) {
            super.b(fragment);
            return this;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot detach Fragment attached to a different FragmentManager. Fragment ");
        sb.append(fragment.toString());
        sb.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(sb.toString());
    }

    public F c(Fragment fragment) {
        C0207w wVar = fragment.mFragmentManager;
        if (wVar == null || wVar == this.s) {
            super.c(fragment);
            return this;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot remove Fragment attached to a different FragmentManager. Fragment ");
        sb.append(fragment.toString());
        sb.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(sb.toString());
    }

    public F d(Fragment fragment) {
        if (fragment != null) {
            C0207w wVar = fragment.mFragmentManager;
            if (!(wVar == null || wVar == this.s)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment ");
                sb.append(fragment.toString());
                sb.append(" is already attached to a FragmentManager.");
                throw new IllegalStateException(sb.toString());
            }
        }
        super.d(fragment);
        return this;
    }

    /* access modifiers changed from: 0000 */
    public void e() {
        int size = this.f1411a.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = (a) this.f1411a.get(i2);
            Fragment fragment = aVar.f1424b;
            if (fragment != null) {
                fragment.setNextTransition(this.f1416f, this.f1417g);
            }
            switch (aVar.f1423a) {
                case 1:
                    fragment.setNextAnim(aVar.f1425c);
                    this.s.a(fragment, false);
                    break;
                case 3:
                    fragment.setNextAnim(aVar.f1426d);
                    this.s.p(fragment);
                    break;
                case 4:
                    fragment.setNextAnim(aVar.f1426d);
                    this.s.i(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(aVar.f1425c);
                    this.s.u(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(aVar.f1426d);
                    this.s.e(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(aVar.f1425c);
                    this.s.c(fragment);
                    break;
                case 8:
                    this.s.t(fragment);
                    break;
                case 9:
                    this.s.t(null);
                    break;
                case 10:
                    this.s.a(fragment, aVar.f1430h);
                    break;
                default:
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unknown cmd: ");
                    sb.append(aVar.f1423a);
                    throw new IllegalArgumentException(sb.toString());
            }
            if (!(this.q || aVar.f1423a == 1 || fragment == null)) {
                this.s.m(fragment);
            }
        }
        if (!this.q) {
            C0207w wVar = this.s;
            wVar.a(wVar.s, true);
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean f() {
        for (int i2 = 0; i2 < this.f1411a.size(); i2++) {
            if (b((a) this.f1411a.get(i2))) {
                return true;
            }
        }
        return false;
    }

    public void g() {
        if (this.r != null) {
            for (int i2 = 0; i2 < this.r.size(); i2++) {
                ((Runnable) this.r.get(i2)).run();
            }
            this.r = null;
        }
    }

    public String getName() {
        return this.f1420j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.u >= 0) {
            sb.append(" #");
            sb.append(this.u);
        }
        if (this.f1420j != null) {
            sb.append(" ");
            sb.append(this.f1420j);
        }
        sb.append("}");
        return sb.toString();
    }

    public void a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f1420j);
            printWriter.print(" mIndex=");
            printWriter.print(this.u);
            printWriter.print(" mCommitted=");
            printWriter.println(this.t);
            if (this.f1416f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f1416f));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f1417g));
            }
            if (!(this.f1412b == 0 && this.f1413c == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1412b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1413c));
            }
            if (!(this.f1414d == 0 && this.f1415e == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1414d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1415e));
            }
            if (!(this.f1421k == 0 && this.f1422l == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1421k));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f1422l);
            }
            if (!(this.m == 0 && this.n == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.m));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.n);
            }
        }
        if (!this.f1411a.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.f1411a.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = (a) this.f1411a.get(i2);
                switch (aVar.f1423a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        StringBuilder sb = new StringBuilder();
                        sb.append("cmd=");
                        sb.append(aVar.f1423a);
                        str2 = sb.toString();
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.f1424b);
                if (z) {
                    if (!(aVar.f1425c == 0 && aVar.f1426d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f1425c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f1426d));
                    }
                    if (aVar.f1427e != 0 || aVar.f1428f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f1427e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f1428f));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void b(int i2) {
        if (this.f1418h) {
            String str = "FragmentManager";
            if (C0207w.f1561c) {
                StringBuilder sb = new StringBuilder();
                sb.append("Bump nesting in ");
                sb.append(this);
                sb.append(" by ");
                sb.append(i2);
                Log.v(str, sb.toString());
            }
            int size = this.f1411a.size();
            for (int i3 = 0; i3 < size; i3++) {
                a aVar = (a) this.f1411a.get(i3);
                Fragment fragment = aVar.f1424b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i2;
                    if (C0207w.f1561c) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Bump nesting of ");
                        sb2.append(aVar.f1424b);
                        sb2.append(" to ");
                        sb2.append(aVar.f1424b.mBackStackNesting);
                        Log.v(str, sb2.toString());
                    }
                }
            }
        }
    }

    public void c() {
        d();
        this.s.b((e) this, true);
    }

    /* access modifiers changed from: 0000 */
    public boolean c(int i2) {
        int size = this.f1411a.size();
        for (int i3 = 0; i3 < size; i3++) {
            Fragment fragment = ((a) this.f1411a.get(i3)).f1424b;
            int i4 = fragment != null ? fragment.mContainerId : 0;
            if (i4 != 0 && i4 == i2) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public void c(boolean z) {
        for (int size = this.f1411a.size() - 1; size >= 0; size--) {
            a aVar = (a) this.f1411a.get(size);
            Fragment fragment = aVar.f1424b;
            if (fragment != null) {
                fragment.setNextTransition(C0207w.e(this.f1416f), this.f1417g);
            }
            switch (aVar.f1423a) {
                case 1:
                    fragment.setNextAnim(aVar.f1428f);
                    this.s.p(fragment);
                    break;
                case 3:
                    fragment.setNextAnim(aVar.f1427e);
                    this.s.a(fragment, false);
                    break;
                case 4:
                    fragment.setNextAnim(aVar.f1427e);
                    this.s.u(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(aVar.f1428f);
                    this.s.i(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(aVar.f1427e);
                    this.s.c(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(aVar.f1428f);
                    this.s.e(fragment);
                    break;
                case 8:
                    this.s.t(null);
                    break;
                case 9:
                    this.s.t(fragment);
                    break;
                case 10:
                    this.s.a(fragment, aVar.f1429g);
                    break;
                default:
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unknown cmd: ");
                    sb.append(aVar.f1423a);
                    throw new IllegalArgumentException(sb.toString());
            }
            if (!(this.q || aVar.f1423a == 3 || fragment == null)) {
                this.s.m(fragment);
            }
        }
        if (!this.q && z) {
            C0207w wVar = this.s;
            wVar.a(wVar.s, true);
        }
    }

    public int b() {
        return b(true);
    }

    /* access modifiers changed from: 0000 */
    public int b(boolean z) {
        if (!this.t) {
            if (C0207w.f1561c) {
                StringBuilder sb = new StringBuilder();
                sb.append("Commit: ");
                sb.append(this);
                String str = "FragmentManager";
                Log.v(str, sb.toString());
                PrintWriter printWriter = new PrintWriter(new b(str));
                a("  ", printWriter);
                printWriter.close();
            }
            this.t = true;
            if (this.f1418h) {
                this.u = this.s.b(this);
            } else {
                this.u = -1;
            }
            this.s.a((e) this, z);
            return this.u;
        }
        throw new IllegalStateException("commit already called");
    }

    /* access modifiers changed from: 0000 */
    public Fragment b(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.f1411a.size() - 1; size >= 0; size--) {
            a aVar = (a) this.f1411a.get(size);
            int i2 = aVar.f1423a;
            if (i2 != 1) {
                if (i2 != 3) {
                    switch (i2) {
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = aVar.f1424b;
                            break;
                        case 10:
                            aVar.f1430h = aVar.f1429g;
                            break;
                    }
                }
                arrayList.add(aVar.f1424b);
            }
            arrayList.remove(aVar.f1424b);
        }
        return fragment;
    }

    private static boolean b(a aVar) {
        Fragment fragment = aVar.f1424b;
        return fragment != null && fragment.mAdded && fragment.mView != null && !fragment.mDetached && !fragment.mHidden && fragment.isPostponed();
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2, Fragment fragment, String str, int i3) {
        super.a(i2, fragment, str, i3);
        fragment.mFragmentManager = this.s;
    }

    public F a(Fragment fragment, h.b bVar) {
        if (fragment.mFragmentManager != this.s) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot setMaxLifecycle for Fragment not attached to FragmentManager ");
            sb.append(this.s);
            throw new IllegalArgumentException(sb.toString());
        } else if (bVar.a(h.b.CREATED)) {
            super.a(fragment, bVar);
            return this;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Cannot set maximum Lifecycle below ");
            sb2.append(h.b.CREATED);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public int a() {
        return b(false);
    }

    public boolean a(ArrayList<C0186a> arrayList, ArrayList<Boolean> arrayList2) {
        if (C0207w.f1561c) {
            StringBuilder sb = new StringBuilder();
            sb.append("Run: ");
            sb.append(this);
            Log.v("FragmentManager", sb.toString());
        }
        arrayList.add(this);
        arrayList2.add(Boolean.valueOf(false));
        if (this.f1418h) {
            this.s.a(this);
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public boolean a(ArrayList<C0186a> arrayList, int i2, int i3) {
        if (i3 == i2) {
            return false;
        }
        int size = this.f1411a.size();
        int i4 = -1;
        for (int i5 = 0; i5 < size; i5++) {
            Fragment fragment = ((a) this.f1411a.get(i5)).f1424b;
            int i6 = fragment != null ? fragment.mContainerId : 0;
            if (!(i6 == 0 || i6 == i4)) {
                for (int i7 = i2; i7 < i3; i7++) {
                    C0186a aVar = (C0186a) arrayList.get(i7);
                    int size2 = aVar.f1411a.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        Fragment fragment2 = ((a) aVar.f1411a.get(i8)).f1424b;
                        if ((fragment2 != null ? fragment2.mContainerId : 0) == i6) {
                            return true;
                        }
                    }
                }
                i4 = i6;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public Fragment a(ArrayList<Fragment> arrayList, Fragment fragment) {
        ArrayList<Fragment> arrayList2 = arrayList;
        Fragment fragment2 = fragment;
        int i2 = 0;
        while (i2 < this.f1411a.size()) {
            a aVar = (a) this.f1411a.get(i2);
            int i3 = aVar.f1423a;
            if (i3 != 1) {
                if (i3 == 2) {
                    Fragment fragment3 = aVar.f1424b;
                    int i4 = fragment3.mContainerId;
                    Fragment fragment4 = fragment2;
                    int i5 = i2;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment5 = (Fragment) arrayList2.get(size);
                        if (fragment5.mContainerId == i4) {
                            if (fragment5 == fragment3) {
                                z = true;
                            } else {
                                if (fragment5 == fragment4) {
                                    this.f1411a.add(i5, new a(9, fragment5));
                                    i5++;
                                    fragment4 = null;
                                }
                                a aVar2 = new a(3, fragment5);
                                aVar2.f1425c = aVar.f1425c;
                                aVar2.f1427e = aVar.f1427e;
                                aVar2.f1426d = aVar.f1426d;
                                aVar2.f1428f = aVar.f1428f;
                                this.f1411a.add(i5, aVar2);
                                arrayList2.remove(fragment5);
                                i5++;
                            }
                        }
                    }
                    if (z) {
                        this.f1411a.remove(i5);
                        i5--;
                    } else {
                        aVar.f1423a = 1;
                        arrayList2.add(fragment3);
                    }
                    i2 = i5;
                    fragment2 = fragment4;
                } else if (i3 == 3 || i3 == 6) {
                    arrayList2.remove(aVar.f1424b);
                    Fragment fragment6 = aVar.f1424b;
                    if (fragment6 == fragment2) {
                        this.f1411a.add(i2, new a(9, fragment6));
                        i2++;
                        fragment2 = null;
                    }
                } else if (i3 != 7) {
                    if (i3 == 8) {
                        this.f1411a.add(i2, new a(9, fragment2));
                        i2++;
                        fragment2 = aVar.f1424b;
                    }
                }
                i2++;
            }
            arrayList2.add(aVar.f1424b);
            i2++;
        }
        return fragment2;
    }

    /* access modifiers changed from: 0000 */
    public void a(b bVar) {
        for (int i2 = 0; i2 < this.f1411a.size(); i2++) {
            a aVar = (a) this.f1411a.get(i2);
            if (b(aVar)) {
                aVar.f1424b.setOnStartEnterTransitionListener(bVar);
            }
        }
    }
}
