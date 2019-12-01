package com.touchin.vtb.utils.a;

import kotlin.e.b.h;

/* compiled from: CurrencyCode.kt */
public enum a {
    RUB("643", "810");
    

    /* renamed from: c reason: collision with root package name */
    public static final C0078a f7610c = null;
    /* access modifiers changed from: private */
    public final String[] numericCodes;

    /* renamed from: com.touchin.vtb.utils.a.a$a reason: collision with other inner class name */
    /* compiled from: CurrencyCode.kt */
    public static final class C0078a {
        private C0078a() {
        }

        public final a a(String str) {
            a[] values;
            h.b(str, "numericCode");
            for (a aVar : a.values()) {
                if (e.a(aVar.numericCodes, str)) {
                    return aVar;
                }
            }
            return null;
        }

        public /* synthetic */ C0078a(e eVar) {
            this();
        }
    }

    static {
        f7610c = new C0078a(null);
    }

    private a(String... strArr) {
        this.numericCodes = strArr;
    }
}
