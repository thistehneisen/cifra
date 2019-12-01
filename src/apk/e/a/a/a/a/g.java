package e.a.a.a.a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: EventProducer */
class g {

    /* renamed from: a reason: collision with root package name */
    final Object f7865a;

    /* renamed from: b reason: collision with root package name */
    private final Method f7866b;

    /* renamed from: c reason: collision with root package name */
    private final int f7867c;

    /* renamed from: d reason: collision with root package name */
    private boolean f7868d = true;

    g(Object obj, Method method) {
        if (obj == null) {
            throw new NullPointerException("EventProducer target cannot be null.");
        } else if (method != null) {
            this.f7865a = obj;
            this.f7866b = method;
            method.setAccessible(true);
            this.f7867c = ((method.hashCode() + 31) * 31) + obj.hashCode();
        } else {
            throw new NullPointerException("EventProducer method cannot be null.");
        }
    }

    public void a() {
        this.f7868d = false;
    }

    public boolean b() {
        return this.f7868d;
    }

    public Object c() throws InvocationTargetException {
        if (this.f7868d) {
            try {
                return this.f7866b.invoke(this.f7865a, new Object[0]);
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
            sb.append(" has been invalidated and can no longer produce events.");
            throw new IllegalStateException(sb.toString());
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        if (!this.f7866b.equals(gVar.f7866b) || this.f7865a != gVar.f7865a) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.f7867c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[EventProducer ");
        sb.append(this.f7866b);
        sb.append("]");
        return sb.toString();
    }
}
