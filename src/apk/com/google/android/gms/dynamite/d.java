package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import com.google.android.gms.dynamite.DynamiteModule.a;
import com.google.android.gms.dynamite.DynamiteModule.a.C0068a;
import com.google.android.gms.dynamite.DynamiteModule.a.b;

final class d implements a {
    d() {
    }

    public final b a(Context context, String str, C0068a aVar) throws LoadingException {
        b bVar = new b();
        bVar.f4831a = aVar.a(context, str);
        bVar.f4832b = aVar.a(context, str, true);
        if (bVar.f4831a == 0 && bVar.f4832b == 0) {
            bVar.f4833c = 0;
        } else if (bVar.f4831a >= bVar.f4832b) {
            bVar.f4833c = -1;
        } else {
            bVar.f4833c = 1;
        }
        return bVar;
    }
}