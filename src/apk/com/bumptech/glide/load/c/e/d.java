package com.bumptech.glide.load.c.e;

import android.util.Log;
import com.bumptech.glide.h.a;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.engine.G;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.k;
import java.io.File;
import java.io.IOException;

/* compiled from: GifDrawableEncoder */
public class d implements k<c> {
    public c a(i iVar) {
        return c.SOURCE;
    }

    public boolean a(G<c> g2, File file, i iVar) {
        try {
            a.a(((c) g2.get()).b(), file);
            return true;
        } catch (IOException e2) {
            String str = "GifEncoder";
            if (Log.isLoggable(str, 5)) {
                Log.w(str, "Failed to encode GIF drawable data", e2);
            }
            return false;
        }
    }
}
