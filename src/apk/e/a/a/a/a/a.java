package e.a.a.a.a;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: AnnotatedHandlerFinder */
final class a {

    /* renamed from: a reason: collision with root package name */
    private static final ConcurrentMap<Class<?>, Map<Class<?>, Method>> f7853a = new ConcurrentHashMap();

    /* renamed from: b reason: collision with root package name */
    private static final ConcurrentMap<Class<?>, Map<Class<?>, Set<Method>>> f7854b = new ConcurrentHashMap();

    private static void a(Class<?> cls, Map<Class<?>, Method> map) {
        a(cls, map, new HashMap());
    }

    private static void b(Class<?> cls, Map<Class<?>, Set<Method>> map) {
        a(cls, new HashMap(), map);
    }

    private static void a(Class<?> cls, Map<Class<?>, Method> map, Map<Class<?>, Set<Method>> map2) {
        Method[] declaredMethods;
        for (Method method : cls.getDeclaredMethods()) {
            if (!method.isBridge()) {
                String str = " but is not 'public'.";
                String str2 = "Method ";
                if (method.isAnnotationPresent(k.class)) {
                    Class[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 1) {
                        Class cls2 = parameterTypes[0];
                        String str3 = " has @Subscribe annotation on ";
                        if (cls2.isInterface()) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(str2);
                            sb.append(method);
                            sb.append(str3);
                            sb.append(cls2);
                            sb.append(" which is an interface.  Subscription must be on a concrete class type.");
                            throw new IllegalArgumentException(sb.toString());
                        } else if ((1 & method.getModifiers()) != 0) {
                            Set set = (Set) map2.get(cls2);
                            if (set == null) {
                                set = new HashSet();
                                map2.put(cls2, set);
                            }
                            set.add(method);
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str2);
                            sb2.append(method);
                            sb2.append(str3);
                            sb2.append(cls2);
                            sb2.append(str);
                            throw new IllegalArgumentException(sb2.toString());
                        }
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str2);
                        sb3.append(method);
                        sb3.append(" has @Subscribe annotation but requires ");
                        sb3.append(parameterTypes.length);
                        sb3.append(" arguments.  Methods must require a single argument.");
                        throw new IllegalArgumentException(sb3.toString());
                    }
                } else if (method.isAnnotationPresent(j.class)) {
                    Class[] parameterTypes2 = method.getParameterTypes();
                    if (parameterTypes2.length != 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(str2);
                        sb4.append(method);
                        sb4.append("has @Produce annotation but requires ");
                        sb4.append(parameterTypes2.length);
                        sb4.append(" arguments.  Methods must require zero arguments.");
                        throw new IllegalArgumentException(sb4.toString());
                    } else if (method.getReturnType() != Void.class) {
                        Class returnType = method.getReturnType();
                        String str4 = " has @Produce annotation on ";
                        if (returnType.isInterface()) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(str2);
                            sb5.append(method);
                            sb5.append(str4);
                            sb5.append(returnType);
                            sb5.append(" which is an interface.  Producers must return a concrete class type.");
                            throw new IllegalArgumentException(sb5.toString());
                        } else if (returnType.equals(Void.TYPE)) {
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append(str2);
                            sb6.append(method);
                            sb6.append(" has @Produce annotation but has no return type.");
                            throw new IllegalArgumentException(sb6.toString());
                        } else if ((1 & method.getModifiers()) == 0) {
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append(str2);
                            sb7.append(method);
                            sb7.append(str4);
                            sb7.append(returnType);
                            sb7.append(str);
                            throw new IllegalArgumentException(sb7.toString());
                        } else if (!map.containsKey(returnType)) {
                            map.put(returnType, method);
                        } else {
                            StringBuilder sb8 = new StringBuilder();
                            sb8.append("Producer for type ");
                            sb8.append(returnType);
                            sb8.append(" has already been registered.");
                            throw new IllegalArgumentException(sb8.toString());
                        }
                    } else {
                        StringBuilder sb9 = new StringBuilder();
                        sb9.append(str2);
                        sb9.append(method);
                        sb9.append(" has a return type of void.  Must declare a non-void type.");
                        throw new IllegalArgumentException(sb9.toString());
                    }
                } else {
                    continue;
                }
            }
        }
        f7853a.put(cls, map);
        f7854b.put(cls, map2);
    }

    static Map<Class<?>, Set<f>> b(Object obj) {
        Class cls = obj.getClass();
        HashMap hashMap = new HashMap();
        Map map = (Map) f7854b.get(cls);
        if (map == null) {
            map = new HashMap();
            b(cls, map);
        }
        if (!map.isEmpty()) {
            for (Entry entry : map.entrySet()) {
                HashSet hashSet = new HashSet();
                for (Method fVar : (Set) entry.getValue()) {
                    hashSet.add(new f(obj, fVar));
                }
                hashMap.put(entry.getKey(), hashSet);
            }
        }
        return hashMap;
    }

    static Map<Class<?>, g> a(Object obj) {
        Class cls = obj.getClass();
        HashMap hashMap = new HashMap();
        Map map = (Map) f7853a.get(cls);
        if (map == null) {
            map = new HashMap();
            a(cls, map);
        }
        if (!map.isEmpty()) {
            for (Entry entry : map.entrySet()) {
                hashMap.put(entry.getKey(), new g(obj, (Method) entry.getValue()));
            }
        }
        return hashMap;
    }
}
