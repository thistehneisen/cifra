package com.touchin.vtb.viewcontrollers.main.tasks;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.C;
import com.touchin.vtb.R;
import com.touchin.vtb.activities.MainActivity;
import com.touchin.vtb.api.Amount;
import com.touchin.vtb.api.TasksTaxInfo;
import com.touchin.vtb.api.TaxRequisites;
import com.touchin.vtb.g.k;
import com.touchin.vtb.h.d.c;
import com.touchin.vtb.viewcontrollers.base.VTBViewController;
import com.touchin.vtb.views.ProgressButton;
import kotlin.e.b.h;
import l.a.c.c.q;
import ru.touchin.roboswag.components.navigation.viewcontrollers.c.a;
import ru.touchin.widget.Switcher;

/* compiled from: TaskTaxViewController.kt */
public final class TaskTaxViewController extends VTBViewController<MainActivity, k> {
    private final TextView amountText = ((TextView) findViewById(R.id.view_controller_payment_details_amount));
    private final TextView destinationText = ((TextView) findViewById(R.id.view_controller_payment_details_description));
    private final TextView payerAccountNumber = ((TextView) findViewById(R.id.view_controller_payment_details_payer_account));
    private final TextView payerBankName = ((TextView) findViewById(R.id.view_controller_payment_details_payer_bank));
    private final TextView payerBic = ((TextView) findViewById(R.id.view_controller_payment_details_payer_bik));
    private final TextView payerName = ((TextView) findViewById(R.id.view_controller_payment_details_payer));
    /* access modifiers changed from: private */
    public final ProgressButton progressButton = ((ProgressButton) findViewById(R.id.view_controller_task_tax_progress_button));
    private final TextView receiverAccountNumber = ((TextView) findViewById(R.id.view_controller_payment_details_receiver_account));
    private final TextView receiverBank = ((TextView) findViewById(R.id.view_controller_payment_details_receiver_bank));
    private final TextView receiverBic = ((TextView) findViewById(R.id.view_controller_payment_details_receiver_bik));
    private final TextView receiverInn = ((TextView) findViewById(R.id.view_controller_payment_details_receiver_inn));
    private final TextView receiverName = ((TextView) findViewById(R.id.view_controller_payment_details_receiver));
    /* access modifiers changed from: private */
    public final Switcher switcher = ((Switcher) findViewById(R.id.view_controller_task_tax_switcher));
    /* access modifiers changed from: private */
    public final c viewModel;

    public TaskTaxViewController(a aVar) {
        h.b(aVar, "creationContext");
        super(aVar, R.layout.view_controller_task_tax);
        C a2 = q.a(q.f10391a, this, null, 2, null).a(c.class);
        h.a((Object) a2, "LifecycleViewModelProvid…TaxViewModel::class.java)");
        this.viewModel = (c) a2;
        initializeToolbars();
        initListeners();
        initObservers();
        this.viewModel.a(((k) getState()).n());
    }

    private final void initConfirmDataObserver() {
        this.viewModel.d().a(this, new f(this));
    }

    private final void initListeners() {
        this.progressButton.setOnClickListener(new g(this));
    }

    private final void initObservers() {
        initConfirmDataObserver();
        initPayTaskTaxObserver();
        this.viewModel.e().a(this, new h(this));
    }

    private final void initPayTaskTaxObserver() {
        this.viewModel.f().a(this, new i(this));
    }

    private final void initializeToolbars() {
        com.touchin.vtb.activities.c.a((MainActivity) getActivity(), (Toolbar) findViewById(R.id.global_toolbar), getString(R.string.common_requisite_navigation_title), null, true, 0, 20, null);
    }

    private final void onClickChatButton() {
    }

    /* access modifiers changed from: private */
    public final void setData(TasksTaxInfo tasksTaxInfo) {
        TaxRequisites e2 = tasksTaxInfo.e();
        h.a((Object) e2, "data.payerRequisites");
        TaxRequisites f2 = tasksTaxInfo.f();
        h.a((Object) f2, "data.receiverRequisites");
        this.payerName.setText(e2.b());
        this.payerAccountNumber.setText(e2.c());
        this.payerBankName.setText(e2.e());
        this.payerBic.setText(e2.d());
        this.receiverName.setText(f2.b());
        this.receiverAccountNumber.setText(f2.c());
        this.receiverBank.setText(f2.e());
        this.receiverBic.setText(f2.d());
        this.receiverInn.setText(f2.f());
        this.destinationText.setText(tasksTaxInfo.c());
        TextView textView = this.amountText;
        Amount b2 = tasksTaxInfo.b();
        h.a((Object) b2, "data.amount");
        textView.setText(com.touchin.vtb.e.a.a(b2, false, true, null, 5, null));
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 200 || (i2 == 301 && i3 == -1)) {
            this.viewModel.b(((k) getState()).n());
        } else if (i3 != 0) {
            super.onActivityResult(i2, i3, intent);
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        h.b(menu, "menu");
        h.b(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.menu_task_tax, menu);
        MenuItem findItem = menu.findItem(R.id.menu_chat);
        h.a((Object) findItem, "menu.findItem(R.id.menu_chat)");
        findItem.setVisible(false);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        h.b(menuItem, "item");
        if (menuItem.getItemId() != R.id.menu_chat) {
            return super.onOptionsItemSelected(menuItem);
        }
        onClickChatButton();
        return true;
    }
}
