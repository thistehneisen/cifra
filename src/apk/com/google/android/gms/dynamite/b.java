package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import com.google.android.gms.dynamite.DynamiteModule.a;
import com.google.android.gms.dynamite.DynamiteModule.a.C0068a;

final class b implements a {
    b() {
    }

    public final com.google.android.gms.dynamite.DynamiteModule.a.b a(Context context, String str, C0068a aVar) throws LoadingException {
        com.google.android.gms.dynamite.DynamiteModule.a.b bVar = new com.google.android.gms.dynamite.DynamiteModule.a.b();
        bVar.f4832b = aVar.a(context, str, true);
        if (bVar.f4832b != 0) {
            bVar.f4833c = 1;
        } else {
            bVar.f4831a = aVar.a(context, str);
            if (bVar.f4831a != 0) {
                bVar.f4833c = -1;
            }
        }
        return bVar;
    }
}