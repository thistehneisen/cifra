package com.franmontiel.persistentcookiejar.cache;

import i.C0728q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class IdentifiableCookie {

    /* renamed from: a reason: collision with root package name */
    private C0728q f4406a;

    IdentifiableCookie(C0728q qVar) {
        this.f4406a = qVar;
    }

    static List<IdentifiableCookie> a(Collection<C0728q> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (C0728q identifiableCookie : collection) {
            arrayList.add(new IdentifiableCookie(identifiableCookie));
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof IdentifiableCookie)) {
            return false;
        }
        IdentifiableCookie identifiableCookie = (IdentifiableCookie) obj;
        if (identifiableCookie.f4406a.e().equals(this.f4406a.e()) && identifiableCookie.f4406a.a().equals(this.f4406a.a()) && identifiableCookie.f4406a.f().equals(this.f4406a.f()) && identifiableCookie.f4406a.h() == this.f4406a.h() && identifiableCookie.f4406a.c() == this.f4406a.c()) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return ((((((((527 + this.f4406a.e().hashCode()) * 31) + this.f4406a.a().hashCode()) * 31) + this.f4406a.f().hashCode()) * 31) + (this.f4406a.h() ^ true ? 1 : 0)) * 31) + (this.f4406a.c() ^ true ? 1 : 0);
    }

    /* access modifiers changed from: 0000 */
    public C0728q a() {
        return this.f4406a;
    }
}
