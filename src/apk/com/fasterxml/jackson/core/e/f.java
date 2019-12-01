package com.fasterxml.jackson.core.e;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: InternCache */
public final class f extends ConcurrentHashMap<String, String> {

    /* renamed from: a reason: collision with root package name */
    public static final f f4376a = new f();
    private final Object lock = new Object();

    private f() {
        super(180, 0.8f, 4);
    }

    public String a(String str) {
        String str2 = (String) get(str);
        if (str2 != null) {
            return str2;
        }
        if (size() >= 180) {
            synchronized (this.lock) {
                if (size() >= 180) {
                    clear();
                }
            }
        }
        String intern = str.intern();
        put(intern, intern);
        return intern;
    }
}
