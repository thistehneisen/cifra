package io.intercom.com.google.gson.b;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* compiled from: ConstructorConstructor */
class j implements z<T> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Constructor f10122a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ q f10123b;

    j(q qVar, Constructor constructor) {
        this.f10123b = qVar;
        this.f10122a = constructor;
    }

    public T a() {
        String str = " with no args";
        String str2 = "Failed to invoke ";
        try {
            return this.f10122a.newInstance(null);
        } catch (InstantiationException e2) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(this.f10122a);
            sb.append(str);
            throw new RuntimeException(sb.toString(), e2);
        } catch (InvocationTargetException e3) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(this.f10122a);
            sb2.append(str);
            throw new RuntimeException(sb2.toString(), e3.getTargetException());
        } catch (IllegalAccessException e4) {
            throw new AssertionError(e4);
        }
    }
}
