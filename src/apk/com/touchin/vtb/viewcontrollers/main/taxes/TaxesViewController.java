package com.touchin.vtb.viewcontrollers.main.taxes;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.C;
import androidx.recyclerview.widget.RecyclerView;
import com.touchin.vtb.R;
import com.touchin.vtb.a.J;
import com.touchin.vtb.activities.c;
import com.touchin.vtb.api.Amount;
import com.touchin.vtb.api.TaxesListResponse;
import com.touchin.vtb.g.m;
import com.touchin.vtb.h.a.r;
import com.touchin.vtb.viewcontrollers.base.VTBBottomMenuViewController;
import java.math.BigDecimal;
import java.util.List;
import kotlin.e.b.h;
import l.a.b.g;
import l.a.c.a.a.d;
import l.a.c.c.q;
import ru.touchin.roboswag.components.navigation.viewcontrollers.c.a;
import ru.touchin.widget.Switcher;

/* compiled from: TaxesViewController.kt */
public final class TaxesViewController extends VTBBottomMenuViewController<c, m> {
    private final J adapter;
    private final TextView emptyTitle = ((TextView) findViewById(R.id.view_controller_taxes_pager_empty_title));
    private final View goToChatButton = findViewById(R.id.view_controller_taxes_pager_empty_go_to_chat_button);
    private final RecyclerView recycler;
    private final Switcher switcher = ((Switcher) findViewById(R.id.view_controller_taxes_switcher));
    private final r viewModel;

    public TaxesViewController(a aVar) {
        h.b(aVar, "creationContext");
        super(aVar, R.layout.view_controller_taxes);
        q qVar = q.f10391a;
        Fragment parentFragment = getFragment().getParentFragment();
        if (parentFragment != null) {
            h.a((Object) parentFragment, "fragment.parentFragment!!");
            C a2 = q.a(qVar, parentFragment, null, 2, null).a(r.class);
            h.a((Object) a2, "LifecycleViewModelProvid…xesViewModel::class.java)");
            this.viewModel = (r) a2;
            this.recycler = (RecyclerView) findViewById(R.id.view_controller_taxes_recycler);
            this.adapter = new J();
            this.recycler.setAdapter(this.adapter);
            g.a(this.goToChatButton, new e(this));
            VTBBottomMenuViewController.addBottomMenuAnimation$default(this, this.recycler, false, 2, null);
            observeData();
            return;
        }
        h.a();
        throw null;
    }

    private final void observeData() {
        this.viewModel.c().a(this, new g(new f(this)));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0040, code lost:
        if (r5 != null) goto L_0x0045;
     */
    public final void showTaxesListEvent(l.a.c.a.a<? extends TaxesListResponse> aVar) {
        BigDecimal bigDecimal;
        if (aVar instanceof d) {
            r rVar = this.viewModel;
            int n = ((m) getState()).n();
            d dVar = (d) aVar;
            List c2 = ((TaxesListResponse) dVar.a()).c();
            h.a((Object) c2, "event.data.taxesList");
            List a2 = rVar.a(n, c2);
            this.adapter.a(a2);
            if (!a2.isEmpty()) {
                Amount b2 = ((TaxesListResponse) dVar.a()).b();
                if (b2 != null) {
                    bigDecimal = b2.c();
                }
                bigDecimal = BigDecimal.ZERO;
                if (!h.a((Object) bigDecimal, (Object) BigDecimal.ZERO)) {
                    this.switcher.a(this.recycler.getId());
                    return;
                }
            }
            this.goToChatButton.setVisibility(8);
            this.emptyTitle.setText(getString(R.string.common_taxes_empty_message, Integer.valueOf(((m) getState()).n())));
            this.switcher.a(R.id.view_controller_taxes_pager_empty);
        }
    }
}
