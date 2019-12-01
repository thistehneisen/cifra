package com.touchin.vtb.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.D;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.t;
import androidx.recyclerview.widget.RecyclerView.u;
import kotlin.e.b.h;

/* compiled from: SpeedyLinearLayoutManager.kt */
public final class SpeedyLinearLayoutManager extends LinearLayoutManager {
    public static final a H = new a(null);
    private final D I;

    /* compiled from: SpeedyLinearLayoutManager.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    /* compiled from: SpeedyLinearLayoutManager.kt */
    private final class b extends D {
        final /* synthetic */ SpeedyLinearLayoutManager o;

        public b(SpeedyLinearLayoutManager speedyLinearLayoutManager, Context context) {
            h.b(context, "context");
            this.o = speedyLinearLayoutManager;
            super(context);
        }

        /* access modifiers changed from: protected */
        public float a(DisplayMetrics displayMetrics) {
            h.b(displayMetrics, "displayMetrics");
            return 50.0f / ((float) displayMetrics.densityDpi);
        }
    }

    public SpeedyLinearLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        h.b(context, "context");
        h.b(attributeSet, "attrs");
        super(context, attributeSet, i2, i3);
        this.I = new b(this, context);
    }

    public void a(RecyclerView recyclerView, u uVar, int i2) {
        h.b(recyclerView, "recyclerView");
        this.I.c(i2);
        b((t) this.I);
    }
}
