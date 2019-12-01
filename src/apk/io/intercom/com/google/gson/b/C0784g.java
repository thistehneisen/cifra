package io.intercom.com.google.gson.b;

import java.lang.reflect.Type;

/* renamed from: io.intercom.com.google.gson.b.g reason: case insensitive filesystem */
/* compiled from: ConstructorConstructor */
class C0784g implements z<T> {

    /* renamed from: a reason: collision with root package name */
    private final G f10112a = G.a();

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ Class f10113b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ Type f10114c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ q f10115d;

    C0784g(q qVar, Class cls, Type type) {
        this.f10115d = qVar;
        this.f10113b = cls;
        this.f10114c = type;
    }

    public T a() {
        try {
            return this.f10112a.b(this.f10113b);
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to invoke no-args constructor for ");
            sb.append(this.f10114c);
            sb.append(". Registering an InstanceCreator with Gson for this type may fix this problem.");
            throw new RuntimeException(sb.toString(), e2);
        }
    }
}
