package com.franmontiel.persistentcookiejar;

import com.franmontiel.persistentcookiejar.cache.CookieCache;
import com.franmontiel.persistentcookiejar.persistence.CookiePersistor;
import i.B;
import i.C0728q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersistentCookieJar implements ClearableCookieJar {

    /* renamed from: a reason: collision with root package name */
    private CookieCache f4404a;

    /* renamed from: b reason: collision with root package name */
    private CookiePersistor f4405b;

    public synchronized void a(B b2, List<C0728q> list) {
        this.f4404a.addAll(list);
        this.f4405b.a(a(list));
    }

    private static List<C0728q> a(List<C0728q> list) {
        ArrayList arrayList = new ArrayList();
        for (C0728q qVar : list) {
            if (qVar.g()) {
                arrayList.add(qVar);
            }
        }
        return arrayList;
    }

    public synchronized List<C0728q> a(B b2) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        arrayList = new ArrayList();
        Iterator it = this.f4404a.iterator();
        while (it.hasNext()) {
            C0728q qVar = (C0728q) it.next();
            if (a(qVar)) {
                arrayList2.add(qVar);
                it.remove();
            } else if (qVar.a(b2)) {
                arrayList.add(qVar);
            }
        }
        this.f4405b.removeAll(arrayList2);
        return arrayList;
    }

    private static boolean a(C0728q qVar) {
        return qVar.b() < System.currentTimeMillis();
    }
}
