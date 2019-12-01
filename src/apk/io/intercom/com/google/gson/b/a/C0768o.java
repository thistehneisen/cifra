package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.c.a;
import io.intercom.com.google.gson.o;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;
import java.lang.reflect.Field;

/* renamed from: io.intercom.com.google.gson.b.a.o reason: case insensitive filesystem */
/* compiled from: ReflectiveTypeAdapterFactory */
class C0768o extends b {

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ Field f10076d;

    /* renamed from: e reason: collision with root package name */
    final /* synthetic */ boolean f10077e;

    /* renamed from: f reason: collision with root package name */
    final /* synthetic */ D f10078f;

    /* renamed from: g reason: collision with root package name */
    final /* synthetic */ o f10079g;

    /* renamed from: h reason: collision with root package name */
    final /* synthetic */ a f10080h;

    /* renamed from: i reason: collision with root package name */
    final /* synthetic */ boolean f10081i;

    /* renamed from: j reason: collision with root package name */
    final /* synthetic */ C0769p f10082j;

    C0768o(C0769p pVar, String str, boolean z, boolean z2, Field field, boolean z3, D d2, o oVar, a aVar, boolean z4) {
        this.f10082j = pVar;
        this.f10076d = field;
        this.f10077e = z3;
        this.f10078f = d2;
        this.f10079g = oVar;
        this.f10080h = aVar;
        this.f10081i = z4;
        super(str, z, z2);
    }

    /* access modifiers changed from: 0000 */
    public void a(d dVar, Object obj) throws IOException, IllegalAccessException {
        D d2;
        Object obj2 = this.f10076d.get(obj);
        if (this.f10077e) {
            d2 = this.f10078f;
        } else {
            d2 = new C0775w(this.f10079g, this.f10078f, this.f10080h.b());
        }
        d2.a(dVar, obj2);
    }

    /* access modifiers changed from: 0000 */
    public void a(b bVar, Object obj) throws IOException, IllegalAccessException {
        Object a2 = this.f10078f.a(bVar);
        if (a2 != null || !this.f10081i) {
            this.f10076d.set(obj, a2);
        }
    }

    public boolean a(Object obj) throws IOException, IllegalAccessException {
        boolean z = false;
        if (!this.f10090b) {
            return false;
        }
        if (this.f10076d.get(obj) != obj) {
            z = true;
        }
        return z;
    }
}
