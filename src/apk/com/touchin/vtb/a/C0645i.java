package com.touchin.vtb.a;

import android.view.View;
import android.view.ViewGroup;
import com.touchin.vtb.R;
import kotlin.e.a.b;
import kotlin.e.b.h;
import kotlin.e.b.i;
import l.a.d.a.b.a;

/* renamed from: com.touchin.vtb.a.i reason: case insensitive filesystem */
/* compiled from: BankOperationsAdapter.kt */
final class C0645i extends i implements b<ViewGroup, com.touchin.vtb.a.c.b> {

    /* renamed from: a reason: collision with root package name */
    public static final C0645i f6958a = new C0645i();

    C0645i() {
        super(1);
    }

    public final com.touchin.vtb.a.c.b a(ViewGroup viewGroup) {
        h.b(viewGroup, "parent");
        View a2 = a.a(R.layout.item_date_header, viewGroup);
        h.a((Object) a2, "UiUtils.inflate(R.layout.item_date_header, parent)");
        return new com.touchin.vtb.a.c.b(a2);
    }
}
