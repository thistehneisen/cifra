package e.a.a.a.a;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: Bus */
public class d {
    public static final String DEFAULT_IDENTIFIER = "default";
    private final n enforcer;
    private final ThreadLocal<ConcurrentLinkedQueue<a>> eventsToDispatch;
    private final ConcurrentMap<Class<?>, Set<Class<?>>> flattenHierarchyCache;
    private final i handlerFinder;
    private final ConcurrentMap<Class<?>, Set<f>> handlersByType;
    private final String identifier;
    private final ThreadLocal<Boolean> isDispatching;
    private final ConcurrentMap<Class<?>, g> producersByType;

    /* compiled from: Bus */
    static class a {

        /* renamed from: a reason: collision with root package name */
        final Object f7857a;

        /* renamed from: b reason: collision with root package name */
        final f f7858b;

        public a(Object obj, f fVar) {
            this.f7857a = obj;
            this.f7858b = fVar;
        }
    }

    public d() {
        this(DEFAULT_IDENTIFIER);
    }

    private void dispatchProducerResultToHandler(f fVar, g gVar) {
        try {
            Object c2 = gVar.c();
            if (c2 != null) {
                dispatch(c2, fVar);
            }
        } catch (InvocationTargetException e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Producer ");
            sb.append(gVar);
            sb.append(" threw an exception.");
            throwRuntimeException(sb.toString(), e2);
            throw null;
        }
    }

    private Set<Class<?>> getClassesFor(Class<?> cls) {
        LinkedList linkedList = new LinkedList();
        HashSet hashSet = new HashSet();
        linkedList.add(cls);
        while (!linkedList.isEmpty()) {
            Class cls2 = (Class) linkedList.remove(0);
            hashSet.add(cls2);
            Class superclass = cls2.getSuperclass();
            if (superclass != null) {
                linkedList.add(superclass);
            }
        }
        return hashSet;
    }

    private static void throwRuntimeException(String str, InvocationTargetException invocationTargetException) {
        Throwable cause = invocationTargetException.getCause();
        String str2 = ": ";
        if (cause != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            sb.append(cause.getMessage());
            throw new RuntimeException(sb.toString(), cause);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(str2);
        sb2.append(invocationTargetException.getMessage());
        throw new RuntimeException(sb2.toString(), invocationTargetException);
    }

    /* access modifiers changed from: protected */
    public void dispatch(Object obj, f fVar) {
        try {
            fVar.a(obj);
        } catch (InvocationTargetException e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not dispatch event: ");
            sb.append(obj.getClass());
            sb.append(" to handler ");
            sb.append(fVar);
            throwRuntimeException(sb.toString(), e2);
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchQueuedEvents() {
        if (!((Boolean) this.isDispatching.get()).booleanValue()) {
            this.isDispatching.set(Boolean.valueOf(true));
            while (true) {
                try {
                    a aVar = (a) ((ConcurrentLinkedQueue) this.eventsToDispatch.get()).poll();
                    if (aVar != null) {
                        if (aVar.f7858b.b()) {
                            dispatch(aVar.f7857a, aVar.f7858b);
                        }
                    } else {
                        return;
                    }
                } finally {
                    this.isDispatching.set(Boolean.valueOf(false));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void enqueueEvent(Object obj, f fVar) {
        ((ConcurrentLinkedQueue) this.eventsToDispatch.get()).offer(new a(obj, fVar));
    }

    /* access modifiers changed from: 0000 */
    public Set<Class<?>> flattenHierarchy(Class<?> cls) {
        Set<Class<?>> set = (Set) this.flattenHierarchyCache.get(cls);
        if (set != null) {
            return set;
        }
        Set<Class<?>> classesFor = getClassesFor(cls);
        Set set2 = (Set) this.flattenHierarchyCache.putIfAbsent(cls, classesFor);
        return set2 == null ? classesFor : set2;
    }

    /* access modifiers changed from: 0000 */
    public Set<f> getHandlersForEventType(Class<?> cls) {
        return (Set) this.handlersByType.get(cls);
    }

    /* access modifiers changed from: 0000 */
    public g getProducerForEventType(Class<?> cls) {
        return (g) this.producersByType.get(cls);
    }

    public void post(Object obj) {
        if (obj != null) {
            this.enforcer.a(this);
            boolean z = false;
            for (Class handlersForEventType : flattenHierarchy(obj.getClass())) {
                Set<f> handlersForEventType2 = getHandlersForEventType(handlersForEventType);
                if (handlersForEventType2 != null && !handlersForEventType2.isEmpty()) {
                    z = true;
                    for (f enqueueEvent : handlersForEventType2) {
                        enqueueEvent(obj, enqueueEvent);
                    }
                }
            }
            if (!z && !(obj instanceof e)) {
                post(new e(this, obj));
            }
            dispatchQueuedEvents();
            return;
        }
        throw new NullPointerException("Event to post must not be null.");
    }

    public void register(Object obj) {
        if (obj != null) {
            this.enforcer.a(this);
            Map b2 = this.handlerFinder.b(obj);
            for (Class cls : b2.keySet()) {
                g gVar = (g) b2.get(cls);
                g gVar2 = (g) this.producersByType.putIfAbsent(cls, gVar);
                if (gVar2 == null) {
                    Set<f> set = (Set) this.handlersByType.get(cls);
                    if (set != null && !set.isEmpty()) {
                        for (f dispatchProducerResultToHandler : set) {
                            dispatchProducerResultToHandler(dispatchProducerResultToHandler, gVar);
                        }
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Producer method for type ");
                    sb.append(cls);
                    sb.append(" found on type ");
                    sb.append(gVar.f7865a.getClass());
                    sb.append(", but already registered by type ");
                    sb.append(gVar2.f7865a.getClass());
                    sb.append(".");
                    throw new IllegalArgumentException(sb.toString());
                }
            }
            Map a2 = this.handlerFinder.a(obj);
            for (Class cls2 : a2.keySet()) {
                Set set2 = (Set) this.handlersByType.get(cls2);
                if (set2 == null) {
                    set2 = new CopyOnWriteArraySet();
                    Set set3 = (Set) this.handlersByType.putIfAbsent(cls2, set2);
                    if (set3 != null) {
                        set2 = set3;
                    }
                }
                if (!set2.addAll((Set) a2.get(cls2))) {
                    throw new IllegalArgumentException("Object already registered.");
                }
            }
            for (Entry entry : a2.entrySet()) {
                g gVar3 = (g) this.producersByType.get((Class) entry.getKey());
                if (gVar3 != null && gVar3.b()) {
                    for (f fVar : (Set) entry.getValue()) {
                        if (!gVar3.b()) {
                            break;
                        } else if (fVar.b()) {
                            dispatchProducerResultToHandler(fVar, gVar3);
                        }
                    }
                }
            }
            return;
        }
        throw new NullPointerException("Object to register must not be null.");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Bus \"");
        sb.append(this.identifier);
        sb.append("\"]");
        return sb.toString();
    }

    public void unregister(Object obj) {
        String str;
        if (obj != null) {
            this.enforcer.a(this);
            Iterator it = this.handlerFinder.b(obj).entrySet().iterator();
            while (true) {
                str = " registered?";
                if (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    Class cls = (Class) entry.getKey();
                    g producerForEventType = getProducerForEventType(cls);
                    g gVar = (g) entry.getValue();
                    if (gVar == null || !gVar.equals(producerForEventType)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Missing event producer for an annotated method. Is ");
                        sb.append(obj.getClass());
                        sb.append(str);
                    } else {
                        ((g) this.producersByType.remove(cls)).a();
                    }
                } else {
                    for (Entry entry2 : this.handlerFinder.a(obj).entrySet()) {
                        Set<f> handlersForEventType = getHandlersForEventType((Class) entry2.getKey());
                        Collection collection = (Collection) entry2.getValue();
                        if (handlersForEventType == null || !handlersForEventType.containsAll(collection)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Missing event handler for an annotated method. Is ");
                            sb2.append(obj.getClass());
                            sb2.append(str);
                            throw new IllegalArgumentException(sb2.toString());
                        }
                        for (f fVar : handlersForEventType) {
                            if (collection.contains(fVar)) {
                                fVar.a();
                            }
                        }
                        handlersForEventType.removeAll(collection);
                    }
                    return;
                }
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Missing event producer for an annotated method. Is ");
            sb3.append(obj.getClass());
            sb3.append(str);
            throw new IllegalArgumentException(sb3.toString());
        }
        throw new NullPointerException("Object to unregister must not be null.");
    }

    public d(String str) {
        this(n.f7871b, str);
    }

    public d(n nVar) {
        this(nVar, DEFAULT_IDENTIFIER);
    }

    public d(n nVar, String str) {
        this(nVar, str, i.f7869a);
    }

    d(n nVar, String str, i iVar) {
        this.handlersByType = new ConcurrentHashMap();
        this.producersByType = new ConcurrentHashMap();
        this.eventsToDispatch = new b(this);
        this.isDispatching = new c(this);
        this.flattenHierarchyCache = new ConcurrentHashMap();
        this.enforcer = nVar;
        this.identifier = str;
        this.handlerFinder = iVar;
    }
}
