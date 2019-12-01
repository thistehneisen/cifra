package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.FirebaseApp;
import com.google.firebase.a.d;
import com.google.firebase.c.f;
import com.google.firebase.components.e;
import com.google.firebase.components.e.a;
import com.google.firebase.components.j;
import com.google.firebase.components.q;
import java.util.Arrays;
import java.util.List;

@Keep
public class AnalyticsConnectorRegistrar implements j {
    @SuppressLint({"MissingPermission"})
    @Keep
    public List<e<?>> getComponents() {
        a a2 = e.a(com.google.firebase.analytics.a.a.class);
        a2.a(q.a(FirebaseApp.class));
        a2.a(q.a(Context.class));
        a2.a(q.a(d.class));
        a2.a(a.f6661a);
        a2.c();
        return Arrays.asList(new e[]{a2.b(), f.a("fire-analytics", "16.5.0")});
    }
}
