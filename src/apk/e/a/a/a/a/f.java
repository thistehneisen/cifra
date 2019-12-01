package e.a.a.a.a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: EventHandler */
class f {

    /* renamed from: a reason: collision with root package name */
    private final Object f7861a;

    /* renamed from: b reason: collision with root package name */
    private final Method f7862b;

    /* renamed from: c reason: collision with root package name */
    private final int f7863c;

    /* renamed from: d reason: collision with root package name */
    private boolean f7864d = true;

    f(Object obj, Method method) {
        if (obj == null) {
            throw new NullPointerException("EventHandler target cannot be null.");
        } else if (method != null) {
            this.f7861a = obj;
            this.f7862b = method;
            method.setAccessible(true);
            this.f7863c = ((method.hashCode() + 31) * 31) + obj.hashCode();
        } else {
            throw new NullPointerException("EventHandler method cannot be null.");
        }
    }

    public void a() {
        this.f7864d = false;
    }

    public boolean b() {
        return this.f7864d;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (!this.f7862b.equals(fVar.f7862b) || this.f7861a != fVar.f7861a) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.f7863c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[EventHandler ");
        sb.append(this.f7862b);
        sb.append("]");
        return sb.toString();
    }

    public void a(Object obj) throws InvocationTargetException {
        if (this.f7864d) {
            try {
                this.f7862b.invoke(this.f7861a, new Object[]{obj});
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InvocationTargetException e3) {
                if (e3.getCause() instanceof Error) {
                    throw ((Error) e3.getCause());
                }
                throw e3;
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(toString());
            sb.append(" has been invalidated and can no longer handle events.");
            throw new IllegalStateException(sb.toString());
        }
    }
}
