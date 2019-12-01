package com.touchin.vtb.viewcontrollers.main.bank;

import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.touchin.vtb.R;
import com.touchin.vtb.activities.c;
import com.touchin.vtb.api.Amount;
import com.touchin.vtb.api.OperationRequisites;
import com.touchin.vtb.g.g;
import com.touchin.vtb.utils.k;
import com.touchin.vtb.viewcontrollers.base.VTBViewController;
import kotlin.e.b.h;
import org.joda.time.b;
import ru.touchin.roboswag.components.navigation.viewcontrollers.c.a;

/* compiled from: PaymentDetailsViewController.kt */
public final class PaymentDetailsViewController extends VTBViewController<c, g> {
    public PaymentDetailsViewController(a aVar) {
        h.b(aVar, "creationContext");
        super(aVar, R.layout.view_controller_payment_details);
        initializeToolbars();
        initializeViews();
    }

    private final String getSubTitle(b bVar) {
        return getString(R.string.common_global_from, getString(R.string.common_global_year_date_template, com.touchin.vtb.utils.b.f7611a.a(bVar, k.DAY_MONTH_YEAR)));
    }

    private final void initializeToolbars() {
        String str;
        c cVar = (c) getActivity();
        Toolbar toolbar = (Toolbar) findViewById(R.id.global_toolbar);
        Amount b2 = ((g) getState()).n().b();
        h.a((Object) b2, "state.operationInfo.amount");
        if (com.touchin.vtb.e.a.a(b2)) {
            str = getString(R.string.common_global_outgoing_payment);
        } else {
            str = getString(R.string.common_global_incoming_payment);
        }
        String str2 = str;
        b d2 = ((g) getState()).n().d();
        h.a((Object) d2, "state.operationInfo.date");
        c.a(cVar, toolbar, str2, getSubTitle(d2), true, 0, 16, null);
    }

    private final void initializeViews() {
        TextView textView = (TextView) findViewById(R.id.view_controller_payment_details_payer);
        OperationRequisites g2 = ((g) getState()).n().g();
        String str = null;
        textView.setText(g2 != null ? g2.b() : null);
        TextView textView2 = (TextView) findViewById(R.id.view_controller_payment_details_payer_account);
        OperationRequisites g3 = ((g) getState()).n().g();
        textView2.setText(g3 != null ? g3.c() : null);
        TextView textView3 = (TextView) findViewById(R.id.view_controller_payment_details_payer_bank);
        OperationRequisites g4 = ((g) getState()).n().g();
        textView3.setText(g4 != null ? g4.e() : null);
        TextView textView4 = (TextView) findViewById(R.id.view_controller_payment_details_payer_bik);
        OperationRequisites g5 = ((g) getState()).n().g();
        textView4.setText(g5 != null ? g5.d() : null);
        TextView textView5 = (TextView) findViewById(R.id.view_controller_payment_details_receiver);
        OperationRequisites h2 = ((g) getState()).n().h();
        textView5.setText(h2 != null ? h2.b() : null);
        TextView textView6 = (TextView) findViewById(R.id.view_controller_payment_details_receiver_account);
        OperationRequisites h3 = ((g) getState()).n().h();
        textView6.setText(h3 != null ? h3.c() : null);
        TextView textView7 = (TextView) findViewById(R.id.view_controller_payment_details_receiver_bank);
        OperationRequisites h4 = ((g) getState()).n().h();
        textView7.setText(h4 != null ? h4.e() : null);
        TextView textView8 = (TextView) findViewById(R.id.view_controller_payment_details_receiver_bik);
        OperationRequisites h5 = ((g) getState()).n().h();
        textView8.setText(h5 != null ? h5.d() : null);
        TextView textView9 = (TextView) findViewById(R.id.view_controller_payment_details_receiver_inn);
        OperationRequisites h6 = ((g) getState()).n().h();
        if (h6 != null) {
            str = h6.f();
        }
        textView9.setText(str);
        ((TextView) findViewById(R.id.view_controller_payment_details_description)).setText(((g) getState()).n().c());
        TextView textView10 = (TextView) findViewById(R.id.view_controller_payment_details_amount);
        Amount b2 = ((g) getState()).n().b();
        h.a((Object) b2, "state.operationInfo.amount");
        textView10.setText(com.touchin.vtb.e.a.a(b2, true, true, null, 4, null));
    }
}
