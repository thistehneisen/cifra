package io.intercom.com.google.gson.b;

/* compiled from: UnsafeAllocator */
class F extends G {
    F() {
    }

    public <T> T b(Class<T> cls) {
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot allocate ");
        sb.append(cls);
        throw new UnsupportedOperationException(sb.toString());
    }
}
