package com.touchin.vtb.a;

import android.content.Context;
import androidx.recyclerview.widget.C0232s.c;
import androidx.recyclerview.widget.RecyclerView;
import com.touchin.vtb.R;
import com.touchin.vtb.api.DaDataSuggestion;
import com.touchin.vtb.views.a.b;
import kotlin.e.b.h;
import l.a.a.e;

/* compiled from: SearchCompanyAdapter.kt */
public final class s extends e<DaDataSuggestion> {

    /* renamed from: d reason: collision with root package name */
    public static final a f6976d = new a(null);

    /* compiled from: SearchCompanyAdapter.kt */
    public static final class a {

        /* renamed from: com.touchin.vtb.a.s$a$a reason: collision with other inner class name */
        /* compiled from: SearchCompanyAdapter.kt */
        private static final class C0072a extends c<DaDataSuggestion> {

            /* renamed from: a reason: collision with root package name */
            public static final C0072a f6977a = new C0072a();

            private C0072a() {
            }

            public boolean a(DaDataSuggestion daDataSuggestion, DaDataSuggestion daDataSuggestion2) {
                h.b(daDataSuggestion, "oldItem");
                h.b(daDataSuggestion2, "newItem");
                return h.a((Object) daDataSuggestion, (Object) daDataSuggestion2);
            }

            public boolean b(DaDataSuggestion daDataSuggestion, DaDataSuggestion daDataSuggestion2) {
                h.b(daDataSuggestion, "oldItem");
                h.b(daDataSuggestion2, "newItem");
                return h.a((Object) daDataSuggestion.c(), (Object) daDataSuggestion2.c());
            }
        }

        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    public s() {
        super((c<TItem>) C0072a.f6977a);
        a((l.a.a.a<?>) new r<Object>());
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        h.b(recyclerView, "recyclerView");
        Context context = recyclerView.getContext();
        String str = "recyclerView.context";
        h.a((Object) context, str);
        Integer valueOf = Integer.valueOf(R.drawable.global_divider);
        Context context2 = recyclerView.getContext();
        h.a((Object) context2, str);
        int dimensionPixelOffset = context2.getResources().getDimensionPixelOffset(R.dimen.global_decoration_start_margin);
        Context context3 = recyclerView.getContext();
        h.a((Object) context3, str);
        b bVar = new b(context, valueOf, null, dimensionPixelOffset, context3.getResources().getDimensionPixelOffset(R.dimen.global_decoration_end_margin), false, 36, null);
        recyclerView.a((RecyclerView.h) bVar);
    }
}
