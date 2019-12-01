package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.f;

/* renamed from: com.google.android.gms.common.internal.j reason: case insensitive filesystem */
public class C0315j {

    /* renamed from: a reason: collision with root package name */
    private final SparseIntArray f4753a = new SparseIntArray();

    /* renamed from: b reason: collision with root package name */
    private f f4754b;

    public C0315j(f fVar) {
        q.a(fVar);
        this.f4754b = fVar;
    }

    public int a(Context context, a.f fVar) {
        q.a(context);
        q.a(fVar);
        if (!fVar.d()) {
            return 0;
        }
        int e2 = fVar.e();
        int i2 = this.f4753a.get(e2, -1);
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= this.f4753a.size()) {
                break;
            }
            int keyAt = this.f4753a.keyAt(i3);
            if (keyAt > e2 && this.f4753a.get(keyAt) == 0) {
                i2 = 0;
                break;
            }
            i3++;
        }
        if (i2 == -1) {
            i2 = this.f4754b.a(context, e2);
        }
        this.f4753a.put(e2, i2);
        return i2;
    }

    public void a() {
        this.f4753a.clear();
    }
}
