package b.e.b.a;

import java.util.HashSet;
import java.util.List;

/* compiled from: ConstraintWidgetGroup */
public class j {

    /* renamed from: a reason: collision with root package name */
    public List<h> f2390a;

    /* renamed from: b reason: collision with root package name */
    int f2391b = -1;

    /* renamed from: c reason: collision with root package name */
    int f2392c = -1;

    /* renamed from: d reason: collision with root package name */
    public final int[] f2393d = {this.f2391b, this.f2392c};

    /* renamed from: e reason: collision with root package name */
    HashSet<h> f2394e = new HashSet<>();

    /* renamed from: f reason: collision with root package name */
    HashSet<h> f2395f = new HashSet<>();

    /* renamed from: g reason: collision with root package name */
    HashSet<h> f2396g = new HashSet<>();

    /* renamed from: h reason: collision with root package name */
    HashSet<h> f2397h = new HashSet<>();

    j(List<h> list) {
        this.f2390a = list;
    }

    public HashSet<h> a(int i2) {
        if (i2 == 0) {
            return this.f2394e;
        }
        if (i2 == 1) {
            return this.f2395f;
        }
        return null;
    }

    public HashSet<h> b(int i2) {
        if (i2 == 0) {
            return this.f2396g;
        }
        if (i2 == 1) {
            return this.f2397h;
        }
        return null;
    }
}
