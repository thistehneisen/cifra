package io.intercom.com.bumptech.glide.load;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/* compiled from: Key */
public interface g {

    /* renamed from: a reason: collision with root package name */
    public static final Charset f9988a = Charset.forName("UTF-8");

    boolean equals(Object obj);

    int hashCode();

    void updateDiskCacheKey(MessageDigest messageDigest);
}
