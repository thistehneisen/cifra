package com.bumptech.glide.e;

import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ImageHeaderParserRegistry */
public final class b {

    /* renamed from: a reason: collision with root package name */
    private final List<ImageHeaderParser> f3404a = new ArrayList();

    public synchronized List<ImageHeaderParser> a() {
        return this.f3404a;
    }

    public synchronized void a(ImageHeaderParser imageHeaderParser) {
        this.f3404a.add(imageHeaderParser);
    }
}
