package com.touchin.vtb.a;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.C0232s.c;
import com.touchin.vtb.api.ConnectedBank;
import kotlin.e.b.h;

/* compiled from: BanksManagementAdapter.kt */
public final class l extends c<ConnectedBank> {
    l() {
    }

    @SuppressLint({"DiffUtilEquals"})
    public boolean a(ConnectedBank connectedBank, ConnectedBank connectedBank2) {
        h.b(connectedBank, "oldItem");
        h.b(connectedBank2, "newItem");
        return h.a((Object) connectedBank, (Object) connectedBank2);
    }

    public boolean b(ConnectedBank connectedBank, ConnectedBank connectedBank2) {
        h.b(connectedBank, "oldItem");
        h.b(connectedBank2, "newItem");
        return h.a((Object) connectedBank.c(), (Object) connectedBank2.c());
    }
}
