package com.touchin.vtb.a;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.C0232s.c;
import com.touchin.vtb.a.c.a;
import java.util.List;
import kotlin.e.b.h;
import l.a.a.e;
import l.a.a.f;

/* renamed from: com.touchin.vtb.a.a reason: case insensitive filesystem */
/* compiled from: BankCardsAdapter.kt */
public final class C0637a extends e<com.touchin.vtb.f.b> {

    /* renamed from: d reason: collision with root package name */
    private static final C0638b f6896d = new C0638b();

    /* renamed from: e reason: collision with root package name */
    public static final b f6897e = new b(null);

    /* renamed from: com.touchin.vtb.a.a$a reason: collision with other inner class name */
    /* compiled from: BankCardsAdapter.kt */
    public final class C0070a extends f<a, com.touchin.vtb.f.b> {
        public C0070a() {
        }

        public boolean b(Object obj, int i2, int i3) {
            h.b(obj, "item");
            return obj instanceof com.touchin.vtb.f.b;
        }

        public a a(ViewGroup viewGroup) {
            h.b(viewGroup, "parent");
            Context context = viewGroup.getContext();
            h.a((Object) context, "parent.context");
            com.touchin.vtb.views.a aVar = new com.touchin.vtb.views.a(context, null, 0, 6, null);
            return new a(aVar);
        }

        public void a(a aVar, com.touchin.vtb.f.b bVar, int i2, int i3, List<Object> list) {
            h.b(aVar, "holder");
            h.b(bVar, "item");
            h.b(list, "payloads");
            aVar.a(bVar);
        }
    }

    /* renamed from: com.touchin.vtb.a.a$b */
    /* compiled from: BankCardsAdapter.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(e eVar) {
            this();
        }
    }

    public C0637a() {
        super((c<TItem>) f6896d);
        a((l.a.a.a<?>) new C0070a<Object>());
    }
}
