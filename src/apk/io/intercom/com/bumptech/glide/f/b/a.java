package io.intercom.com.bumptech.glide.f.b;

import android.graphics.drawable.Drawable;

/* compiled from: DrawableCrossFadeFactory */
public class a implements e<Drawable> {

    /* renamed from: a reason: collision with root package name */
    private final int f9315a;

    /* renamed from: b reason: collision with root package name */
    private final boolean f9316b;

    /* renamed from: c reason: collision with root package name */
    private b f9317c;

    /* renamed from: io.intercom.com.bumptech.glide.f.b.a$a reason: collision with other inner class name */
    /* compiled from: DrawableCrossFadeFactory */
    public static class C0103a {

        /* renamed from: a reason: collision with root package name */
        private final int f9318a;

        /* renamed from: b reason: collision with root package name */
        private boolean f9319b;

        public C0103a() {
            this(300);
        }

        public a a() {
            return new a(this.f9318a, this.f9319b);
        }

        public C0103a(int i2) {
            this.f9318a = i2;
        }
    }

    protected a(int i2, boolean z) {
        this.f9315a = i2;
        this.f9316b = z;
    }

    public d<Drawable> a(io.intercom.com.bumptech.glide.load.a aVar, boolean z) {
        return aVar == io.intercom.com.bumptech.glide.load.a.MEMORY_CACHE ? c.a() : a();
    }

    private d<Drawable> a() {
        if (this.f9317c == null) {
            this.f9317c = new b(this.f9315a, this.f9316b);
        }
        return this.f9317c;
    }
}
