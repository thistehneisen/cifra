package io.intercom.com.bumptech.glide.load.c.e;

import android.util.Log;
import io.intercom.com.bumptech.glide.h.a;
import io.intercom.com.bumptech.glide.load.c;
import io.intercom.com.bumptech.glide.load.engine.E;
import io.intercom.com.bumptech.glide.load.j;
import io.intercom.com.bumptech.glide.load.l;
import java.io.File;
import java.io.IOException;

/* compiled from: GifDrawableEncoder */
public class d implements l<c> {
    public c a(j jVar) {
        return c.SOURCE;
    }

    public boolean a(E<c> e2, File file, j jVar) {
        try {
            a.a(((c) e2.get()).b(), file);
            return true;
        } catch (IOException e3) {
            String str = "GifEncoder";
            if (Log.isLoggable(str, 5)) {
                Log.w(str, "Failed to encode GIF drawable data", e3);
            }
            return false;
        }
    }
}
