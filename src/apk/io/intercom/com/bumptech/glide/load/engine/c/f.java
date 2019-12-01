package io.intercom.com.bumptech.glide.load.engine.c;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* compiled from: RuntimeCompat */
class f implements FilenameFilter {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Pattern f9863a;

    f(Pattern pattern) {
        this.f9863a = pattern;
    }

    public boolean accept(File file, String str) {
        return this.f9863a.matcher(str).matches();
    }
}
