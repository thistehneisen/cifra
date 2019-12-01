package com.touchin.vtb.a;

import android.content.Context;
import android.os.Parcelable;
import androidx.fragment.app.E;
import androidx.fragment.app.Fragment;
import java.util.List;
import kotlin.e.b.h;
import l.a.d.a.a.b.a.b;
import ru.touchin.roboswag.components.navigation.viewcontrollers.c;

/* compiled from: SimplePageAdapter.kt */
public final class t extends E {

    /* renamed from: g reason: collision with root package name */
    private final Fragment f6978g;

    /* renamed from: h reason: collision with root package name */
    private final List<a> f6979h;

    /* compiled from: SimplePageAdapter.kt */
    public static final class a {

        /* renamed from: a reason: collision with root package name */
        private final Class<? extends c<? extends l.a.d.a.a.a.a, ? extends Parcelable>> f6980a;

        /* renamed from: b reason: collision with root package name */
        private final Parcelable f6981b;

        /* renamed from: c reason: collision with root package name */
        private final String f6982c;

        public a(Class<? extends c<? extends l.a.d.a.a.a.a, ? extends Parcelable>> cls, Parcelable parcelable, String str) {
            h.b(cls, "viewControllerClass");
            h.b(str, "title");
            this.f6980a = cls;
            this.f6981b = parcelable;
            this.f6982c = str;
        }

        public final Parcelable a() {
            return this.f6981b;
        }

        public final String b() {
            return this.f6982c;
        }

        public final Class<? extends c<? extends l.a.d.a.a.a.a, ? extends Parcelable>> c() {
            return this.f6980a;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
            if (kotlin.e.b.h.a((java.lang.Object) r2.f6982c, (java.lang.Object) r3.f6982c) != false) goto L_0x0029;
         */
        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (h.a((Object) this.f6980a, (Object) aVar.f6980a)) {
                        if (h.a((Object) this.f6981b, (Object) aVar.f6981b)) {
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            Class<? extends c<? extends l.a.d.a.a.a.a, ? extends Parcelable>> cls = this.f6980a;
            int i2 = 0;
            int hashCode = (cls != null ? cls.hashCode() : 0) * 31;
            Parcelable parcelable = this.f6981b;
            int hashCode2 = (hashCode + (parcelable != null ? parcelable.hashCode() : 0)) * 31;
            String str = this.f6982c;
            if (str != null) {
                i2 = str.hashCode();
            }
            return hashCode2 + i2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Page(viewControllerClass=");
            sb.append(this.f6980a);
            sb.append(", initialState=");
            sb.append(this.f6981b);
            sb.append(", title=");
            sb.append(this.f6982c);
            sb.append(")");
            return sb.toString();
        }
    }

    public t(Fragment fragment, List<a> list) {
        h.b(fragment, "parentFragment");
        h.b(list, "pages");
        super(fragment.getChildFragmentManager());
        this.f6978g = fragment;
        this.f6979h = list;
    }

    public int getCount() {
        return this.f6979h.size();
    }

    public Fragment getItem(int i2) {
        Context requireContext = this.f6978g.requireContext();
        String name = l.a.d.a.a.b.a.class.getName();
        b bVar = l.a.d.a.a.b.a.f10403a;
        Class c2 = ((a) this.f6979h.get(i2)).c();
        Parcelable a2 = ((a) this.f6979h.get(i2)).a();
        if (a2 == null) {
            a2 = ru.touchin.roboswag.components.navigation.viewcontrollers.b.f11113a;
        }
        Fragment instantiate = Fragment.instantiate(requireContext, name, bVar.a(c2, a2));
        h.a((Object) instantiate, "Fragment.instantiate(\n  …tate ?: EmptyState)\n    )");
        return instantiate;
    }

    public String getPageTitle(int i2) {
        return ((a) this.f6979h.get(i2)).b();
    }
}
