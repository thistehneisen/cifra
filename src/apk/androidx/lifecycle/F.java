package androidx.lifecycle;

import java.util.HashMap;

/* compiled from: ViewModelStore */
public class F {

    /* renamed from: a reason: collision with root package name */
    private final HashMap<String, C> f1610a = new HashMap<>();

    /* access modifiers changed from: 0000 */
    public final void a(String str, C c2) {
        C c3 = (C) this.f1610a.put(str, c2);
        if (c3 != null) {
            c3.b();
        }
    }

    /* access modifiers changed from: 0000 */
    public final C a(String str) {
        return (C) this.f1610a.get(str);
    }

    public final void a() {
        for (C a2 : this.f1610a.values()) {
            a2.a();
        }
        this.f1610a.clear();
    }
}
