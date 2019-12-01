package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import io.fabric.sdk.android.a.b.C0730a;
import java.io.IOException;

public final class Platform$$JsonTypeConverter implements TypeConverter<Platform> {
    public Platform parse(e eVar) throws IOException {
        if (eVar.d() == g.VALUE_NULL) {
            return null;
        }
        String E = eVar.E();
        if (E.equals(C0730a.ANDROID_CLIENT_TYPE)) {
            return Platform.ANDROID;
        }
        if (E.equals("ios")) {
            return Platform.IOS;
        }
        throw new IllegalArgumentException(eVar.toString());
    }

    public void serialize(Platform platform, String str, boolean z, c cVar) throws IOException {
        String str2 = "ios";
        String str3 = C0730a.ANDROID_CLIENT_TYPE;
        if (str != null) {
            if (platform == null) {
                cVar.d(str);
                return;
            }
            int i2 = q.f7128a[platform.ordinal()];
            if (i2 == 1) {
                cVar.a(str, str3);
            } else if (i2 == 2) {
                cVar.a(str, str2);
            } else {
                throw new IllegalArgumentException(platform.name());
            }
        } else if (platform == null) {
            cVar.d();
        } else {
            int i3 = q.f7128a[platform.ordinal()];
            if (i3 == 1) {
                cVar.f(str3);
            } else if (i3 == 2) {
                cVar.f(str2);
            } else {
                throw new IllegalArgumentException(platform.name());
            }
        }
    }
}
