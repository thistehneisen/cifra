package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: androidx.lifecycle.b reason: case insensitive filesystem */
/* compiled from: ClassesInfoCache */
class C0209b {

    /* renamed from: a reason: collision with root package name */
    static C0209b f1634a = new C0209b();

    /* renamed from: b reason: collision with root package name */
    private final Map<Class, a> f1635b = new HashMap();

    /* renamed from: c reason: collision with root package name */
    private final Map<Class, Boolean> f1636c = new HashMap();

    /* renamed from: androidx.lifecycle.b$a */
    /* compiled from: ClassesInfoCache */
    static class a {

        /* renamed from: a reason: collision with root package name */
        final Map<androidx.lifecycle.h.a, List<C0012b>> f1637a = new HashMap();

        /* renamed from: b reason: collision with root package name */
        final Map<C0012b, androidx.lifecycle.h.a> f1638b;

        a(Map<C0012b, androidx.lifecycle.h.a> map) {
            this.f1638b = map;
            for (Entry entry : map.entrySet()) {
                androidx.lifecycle.h.a aVar = (androidx.lifecycle.h.a) entry.getValue();
                List list = (List) this.f1637a.get(aVar);
                if (list == null) {
                    list = new ArrayList();
                    this.f1637a.put(aVar, list);
                }
                list.add(entry.getKey());
            }
        }

        /* access modifiers changed from: 0000 */
        public void a(l lVar, androidx.lifecycle.h.a aVar, Object obj) {
            a((List) this.f1637a.get(aVar), lVar, aVar, obj);
            a((List) this.f1637a.get(androidx.lifecycle.h.a.ON_ANY), lVar, aVar, obj);
        }

        private static void a(List<C0012b> list, l lVar, androidx.lifecycle.h.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((C0012b) list.get(size)).a(lVar, aVar, obj);
                }
            }
        }
    }

    /* renamed from: androidx.lifecycle.b$b reason: collision with other inner class name */
    /* compiled from: ClassesInfoCache */
    static class C0012b {

        /* renamed from: a reason: collision with root package name */
        final int f1639a;

        /* renamed from: b reason: collision with root package name */
        final Method f1640b;

        C0012b(int i2, Method method) {
            this.f1639a = i2;
            this.f1640b = method;
            this.f1640b.setAccessible(true);
        }

        /* access modifiers changed from: 0000 */
        public void a(l lVar, androidx.lifecycle.h.a aVar, Object obj) {
            try {
                int i2 = this.f1639a;
                if (i2 == 0) {
                    this.f1640b.invoke(obj, new Object[0]);
                } else if (i2 == 1) {
                    this.f1640b.invoke(obj, new Object[]{lVar});
                } else if (i2 == 2) {
                    this.f1640b.invoke(obj, new Object[]{lVar, aVar});
                }
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to call observer method", e2.getCause());
            } catch (IllegalAccessException e3) {
                throw new RuntimeException(e3);
            }
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj == null || C0012b.class != obj.getClass()) {
                return false;
            }
            C0012b bVar = (C0012b) obj;
            if (this.f1639a != bVar.f1639a || !this.f1640b.getName().equals(bVar.f1640b.getName())) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return (this.f1639a * 31) + this.f1640b.getName().hashCode();
        }
    }

    C0209b() {
    }

    private Method[] c(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e2) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
        }
    }

    /* access modifiers changed from: 0000 */
    public a a(Class cls) {
        a aVar = (a) this.f1635b.get(cls);
        if (aVar != null) {
            return aVar;
        }
        return a(cls, null);
    }

    /* access modifiers changed from: 0000 */
    public boolean b(Class cls) {
        Boolean bool = (Boolean) this.f1636c.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] c2 = c(cls);
        for (Method annotation : c2) {
            if (((w) annotation.getAnnotation(w.class)) != null) {
                a(cls, c2);
                return true;
            }
        }
        this.f1636c.put(cls, Boolean.valueOf(false));
        return false;
    }

    private void a(Map<C0012b, androidx.lifecycle.h.a> map, C0012b bVar, androidx.lifecycle.h.a aVar, Class cls) {
        androidx.lifecycle.h.a aVar2 = (androidx.lifecycle.h.a) map.get(bVar);
        if (aVar2 != null && aVar != aVar2) {
            Method method = bVar.f1640b;
            StringBuilder sb = new StringBuilder();
            sb.append("Method ");
            sb.append(method.getName());
            sb.append(" in ");
            sb.append(cls.getName());
            sb.append(" already declared with different @OnLifecycleEvent value: previous value ");
            sb.append(aVar2);
            sb.append(", new value ");
            sb.append(aVar);
            throw new IllegalArgumentException(sb.toString());
        } else if (aVar2 == null) {
            map.put(bVar, aVar);
        }
    }

    private a a(Class cls, Method[] methodArr) {
        int i2;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null) {
            a a2 = a(superclass);
            if (a2 != null) {
                hashMap.putAll(a2.f1638b);
            }
        }
        for (Class a3 : cls.getInterfaces()) {
            for (Entry entry : a(a3).f1638b.entrySet()) {
                a(hashMap, (C0012b) entry.getKey(), (androidx.lifecycle.h.a) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = c(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            w wVar = (w) method.getAnnotation(w.class);
            if (wVar != null) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i2 = 0;
                } else if (parameterTypes[0].isAssignableFrom(l.class)) {
                    i2 = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                androidx.lifecycle.h.a value = wVar.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(androidx.lifecycle.h.a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (value == androidx.lifecycle.h.a.ON_ANY) {
                        i2 = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    a(hashMap, new C0012b(i2, method), value, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        a aVar = new a(hashMap);
        this.f1635b.put(cls, aVar);
        this.f1636c.put(cls, Boolean.valueOf(z));
        return aVar;
    }
}
