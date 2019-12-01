package com.franmontiel.persistentcookiejar.cache;

import i.C0728q;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetCookieCache implements CookieCache {
    /* access modifiers changed from: private */

    /* renamed from: a reason: collision with root package name */
    public Set<IdentifiableCookie> f4407a = new HashSet();

    private class SetCookieCacheIterator implements Iterator<C0728q> {

        /* renamed from: a reason: collision with root package name */
        private Iterator<IdentifiableCookie> f4408a;

        public SetCookieCacheIterator() {
            this.f4408a = SetCookieCache.this.f4407a.iterator();
        }

        public boolean hasNext() {
            return this.f4408a.hasNext();
        }

        public void remove() {
            this.f4408a.remove();
        }

        public C0728q next() {
            return ((IdentifiableCookie) this.f4408a.next()).a();
        }
    }

    public void addAll(Collection<C0728q> collection) {
        for (IdentifiableCookie identifiableCookie : IdentifiableCookie.a(collection)) {
            this.f4407a.remove(identifiableCookie);
            this.f4407a.add(identifiableCookie);
        }
    }

    public Iterator<C0728q> iterator() {
        return new SetCookieCacheIterator();
    }
}
