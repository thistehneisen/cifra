package l.a.c.c;

import androidx.lifecycle.C;
import androidx.lifecycle.D.b;
import f.a.a;
import java.util.Map;
import kotlin.e.b.h;

/* compiled from: ViewModelFactory.kt */
public final class t implements b {

    /* renamed from: a reason: collision with root package name */
    private final Map<Class<? extends C>, a<C>> f10394a;

    public t(Map<Class<? extends C>, a<C>> map) {
        h.b(map, "creators");
        this.f10394a = map;
    }

    public <T extends C> T a(Class<T> cls) {
        h.b(cls, "modelClass");
        a aVar = (a) this.f10394a.get(cls);
        T t = aVar != null ? (C) aVar.get() : null;
        if (!(t instanceof C)) {
            t = null;
        }
        if (t != null) {
            return t;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown model class ");
        sb.append(cls);
        throw new IllegalArgumentException(sb.toString());
    }
}
