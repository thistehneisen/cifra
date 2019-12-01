package com.touchin.vtb.viewcontrollers.main.bank;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.C;
import androidx.recyclerview.widget.K;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.x;
import com.touchin.vtb.R;
import com.touchin.vtb.a.C0637a;
import com.touchin.vtb.a.C0640d;
import com.touchin.vtb.activities.c;
import com.touchin.vtb.api.ApiError;
import com.touchin.vtb.api.BankConnectResponse;
import com.touchin.vtb.api.BankConnectStatusesResponse;
import com.touchin.vtb.api.BankConnectionStatus;
import com.touchin.vtb.api.BankType;
import com.touchin.vtb.api.exceptions.ServerException;
import com.touchin.vtb.b.g;
import com.touchin.vtb.g.a;
import com.touchin.vtb.g.e;
import com.touchin.vtb.g.f;
import com.touchin.vtb.h.a.d;
import com.touchin.vtb.utils.m;
import com.touchin.vtb.viewcontrollers.base.VTBBottomMenuViewController;
import com.touchin.vtb.viewcontrollers.startup.GetAccessConfirmSmsViewController;
import com.touchin.vtb.viewcontrollers.startup.GetAccessViewController;
import com.touchin.vtb.views.GlobalErrorView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.e.b.h;
import l.a.c.c.q;
import org.joda.time.b;
import ru.touchin.roboswag.core.utils.ShouldNotHappenException;
import ru.touchin.widget.Switcher;

/* compiled from: BankViewController.kt */
public final class BankViewController extends VTBBottomMenuViewController<c, a> implements m {
    private final C0637a cardsAdapter = new C0637a();
    /* access modifiers changed from: private */
    public final RecyclerView cardsRecycler = ((RecyclerView) findViewById(R.id.view_controller_bank_cards_recycler));
    private final Switcher cardsSwitcher = ((Switcher) findViewById(R.id.view_controller_bank_cards_switcher));
    private final ViewGroup dotsView = ((ViewGroup) findViewById(R.id.view_controller_bank_dots_view));
    private final View emptyCardContainer = findViewById(R.id.view_controller_bank_cards_empty_card_container);
    private final GlobalErrorView errorView = ((GlobalErrorView) findViewById(R.id.view_controller_bank_error));
    private final C0640d operationsAdapter = new C0640d();
    private final RecyclerView operationsRecycler = ((RecyclerView) findViewById(R.id.view_controller_bank_operations_recycler));
    private final Switcher switcher = ((Switcher) findViewById(R.id.view_controller_bank_switcher));
    private b timeOfStart;
    private final TextView titleTextView = ((TextView) findViewById(R.id.view_controller_bank_title));
    /* access modifiers changed from: private */
    public final d viewModel;

    public BankViewController(ru.touchin.roboswag.components.navigation.viewcontrollers.c.a aVar) {
        h.b(aVar, "creationContext");
        super(aVar, R.layout.view_controller_bank);
        C a2 = q.a(q.f10391a, this, null, 2, null).a(d.class);
        h.a((Object) a2, "LifecycleViewModelProvid…ankViewModel::class.java)");
        this.viewModel = (d) a2;
        this.titleTextView.setText(this.viewModel.i());
        this.cardsRecycler.setAdapter(this.cardsAdapter);
        com.touchin.vtb.e.h.a(this.cardsRecycler, new K(), this, null, 4, null);
        this.operationsRecycler.setAdapter(this.operationsAdapter);
        this.operationsRecycler.setItemAnimator(null);
        this.operationsAdapter.a((kotlin.e.a.c<? super TItem, ? super x, kotlin.m>) new a<Object,Object,kotlin.m>(this));
        this.emptyCardContainer.setOnClickListener(new b(this));
        this.viewModel.e().a(this, new h(new c(this)));
        this.viewModel.h().a(this, new h(new d(this)));
        this.viewModel.g().a(this, new h(new e(this)));
        this.viewModel.d();
        VTBBottomMenuViewController.addBottomMenuAnimation$default(this, this.operationsRecycler, false, 2, null);
    }

    private final void fillDotsView(int i2) {
        this.dotsView.removeAllViews();
        int size = this.cardsAdapter.d().size();
        if (size > 0) {
            int i3 = 0;
            while (i3 < size) {
                View b2 = l.a.d.a.b.a.b(R.layout.item_bank_card_dot, this.dotsView);
                h.a((Object) b2, "view");
                b2.setSelected(i3 == i2);
                i3++;
            }
        }
    }

    private final List<BankType> getConnectedBanksList(List<com.touchin.vtb.f.b> list) {
        HashSet<String> hashSet = new HashSet<>();
        for (com.touchin.vtb.f.b g2 : list) {
            hashSet.add(g2.g());
        }
        ArrayList arrayList = new ArrayList(j.a(hashSet, 10));
        for (String a2 : hashSet) {
            arrayList.add(this.viewModel.a(a2));
        }
        return arrayList;
    }

    private final void initCardSwitcherLayoutChangeListener() {
        this.cardsSwitcher.addOnLayoutChangeListener(new g(this));
    }

    /* access modifiers changed from: private */
    public final boolean isBankSessionExpiredError(Throwable th) {
        ApiError apiError = null;
        if (!(th instanceof ServerException)) {
            th = null;
        }
        ServerException serverException = (ServerException) th;
        if (serverException != null) {
            apiError = serverException.a();
        }
        return apiError == ApiError.BANK_SESSION_EXPIRED;
    }

    private final void navigateToGetAccess(BankConnectionStatus bankConnectionStatus, String str, List<BankConnectResponse> list) {
        BankType a2 = this.viewModel.a(str);
        if (a2 != null) {
            int i2 = f.f7647b[bankConnectionStatus.ordinal()];
            if (i2 == 1) {
                ru.touchin.roboswag.components.navigation.viewcontrollers.d c2 = ((c) getActivity()).c();
                f fVar = new f(a2, Integer.valueOf(R.string.app_name), false, BankViewController.class.getName(), true, str, list);
                ru.touchin.roboswag.components.navigation.viewcontrollers.d.a(c2, GetAccessViewController.class, (Parcelable) fVar, (kotlin.e.a.b) null, 4, (Object) null);
            } else if (i2 != 2) {
                this.switcher.a(R.id.view_controller_bank_accounts);
            } else {
                ru.touchin.roboswag.components.navigation.viewcontrollers.d c3 = ((c) getActivity()).c();
                e eVar = new e(str, a2, null, null, 0, BankViewController.class.getName(), true, list, 28, null);
                ru.touchin.roboswag.components.navigation.viewcontrollers.d.a(c3, GetAccessConfirmSmsViewController.class, (Parcelable) eVar, (kotlin.e.a.b) null, 4, (Object) null);
            }
        } else {
            throw new ShouldNotHappenException("BankType is not init");
        }
    }

    private final void processThrowable(Throwable th) {
        if (th instanceof ServerException) {
            int i2 = f.f7646a[((ServerException) th).a().ordinal()];
            if (i2 == 1 || i2 == 2) {
                this.cardsSwitcher.a(R.id.view_controller_bank_cards_empty_card_container);
                this.titleTextView.setVisibility(8);
                this.dotsView.setVisibility(8);
                this.operationsAdapter.a(h.a(com.touchin.vtb.a.q.b.f6974a));
            } else if (i2 == 3) {
                this.switcher.a(R.id.view_controller_bank_error);
                setupErrorView(th);
            }
        } else {
            this.switcher.a(R.id.view_controller_bank_error);
            setupErrorView(th);
        }
    }

    private final void setupErrorView(Throwable th) {
        this.errorView.a(th, new i(this, th));
        ApiError apiError = null;
        if (!(th instanceof ServerException)) {
            th = null;
        }
        ServerException serverException = (ServerException) th;
        if (serverException != null) {
            apiError = serverException.a();
        }
        if (apiError == ApiError.BANK_SESSION_EXPIRED) {
            this.viewModel.f();
        }
    }

    /* access modifiers changed from: private */
    public final void showAccountsList(l.a.c.a.a<? extends List<com.touchin.vtb.f.b>> aVar) {
        Object obj;
        if (aVar instanceof l.a.c.a.a.c) {
            this.switcher.a(R.id.view_controller_bank_accounts);
            this.cardsSwitcher.a(R.id.global_loader);
        } else if (aVar instanceof l.a.c.a.a.d) {
            l.a.c.a.a.d dVar = (l.a.c.a.a.d) aVar;
            this.cardsAdapter.a((List) dVar.a());
            ((c) getActivity()).d().a((g) new g.c(getConnectedBanksList((List) dVar.a())));
            if (((List) dVar.a()).isEmpty()) {
                this.switcher.a(R.id.view_controller_bank_error);
                GlobalErrorView.a(this.errorView, null, null, null, new j(this), 7, null);
                return;
            }
            this.switcher.a(R.id.view_controller_bank_accounts);
            this.cardsSwitcher.a(R.id.view_controller_bank_cards_recycler);
            Iterator it = ((Iterable) dVar.a()).iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (h.a((Object) ((com.touchin.vtb.f.b) obj).h(), (Object) ((a) getState()).n())) {
                    break;
                }
            }
            com.touchin.vtb.f.b bVar = (com.touchin.vtb.f.b) obj;
            this.viewModel.a(bVar != null ? bVar : (com.touchin.vtb.f.b) q.d((List) dVar.a()));
            int indexOf = bVar != null ? ((List) dVar.a()).indexOf(bVar) : 0;
            fillDotsView(indexOf);
            this.cardsRecycler.post(new k(this, indexOf));
        } else if (aVar instanceof l.a.c.a.a.b) {
            processThrowable(((l.a.c.a.a.b) aVar).b());
        }
    }

    /* access modifiers changed from: private */
    public final void showCheckBankStatusesEvent(l.a.c.a.a<? extends BankConnectStatusesResponse> aVar) {
        if (!(aVar instanceof l.a.c.a.a.c)) {
            if (aVar instanceof l.a.c.a.a.d) {
                List b2 = ((BankConnectStatusesResponse) ((l.a.c.a.a.d) aVar).a()).b();
                h.a((Object) b2, "event.data.banksList");
                ArrayList arrayList = new ArrayList();
                Iterator it = b2.iterator();
                while (true) {
                    boolean z = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    BankConnectResponse bankConnectResponse = (BankConnectResponse) next;
                    h.a((Object) bankConnectResponse, "bank");
                    if (bankConnectResponse.b() != BankConnectionStatus.CONNECTED) {
                        z = true;
                    }
                    if (z) {
                        arrayList.add(next);
                    }
                }
                List a2 = q.a((Collection) arrayList);
                if (a2.isEmpty()) {
                    this.switcher.a(R.id.view_controller_bank_accounts);
                    return;
                }
                BankConnectResponse bankConnectResponse2 = (BankConnectResponse) a2.get(0);
                a2.remove(bankConnectResponse2);
                h.a((Object) bankConnectResponse2, "bankToNextRestoreSession");
                BankConnectionStatus b3 = bankConnectResponse2.b();
                h.a((Object) b3, "bankToNextRestoreSession.bankConnectionStatus");
                String c2 = bankConnectResponse2.c();
                h.a((Object) c2, "bankToNextRestoreSession.connectedBankId");
                navigateToGetAccess(b3, c2, a2);
            } else if (aVar instanceof l.a.c.a.a.b) {
                this.switcher.a(R.id.view_controller_bank_error);
                this.errorView.a(((l.a.c.a.a.b) aVar).b(), new l(this));
            }
        }
    }

    /* access modifiers changed from: private */
    public final void showOperationsList(l.a.c.a.a<? extends List<com.touchin.vtb.a.q.a>> aVar) {
        if (aVar instanceof l.a.c.a.a.c) {
            this.operationsAdapter.a(h.a(com.touchin.vtb.a.q.c.f6975a));
        } else if (aVar instanceof l.a.c.a.a.d) {
            this.operationsAdapter.a((List) ((l.a.c.a.a.d) aVar).a());
            initCardSwitcherLayoutChangeListener();
        } else if (aVar instanceof l.a.c.a.a.b) {
            this.switcher.a(R.id.view_controller_bank_error);
            setupErrorView(((l.a.c.a.a.b) aVar).b());
        }
    }

    public void onSnapPositionChange(int i2) {
        if (i2 != -1) {
            fillDotsView(i2);
            com.touchin.vtb.f.b bVar = (com.touchin.vtb.f.b) q.a(this.cardsAdapter.d(), i2);
            if (bVar != null) {
                ((a) getState()).a(bVar.h());
                this.viewModel.a(bVar);
            }
            showBottomMenu();
        }
    }

    public void onStart() {
        super.onStart();
        b g2 = b.g();
        h.a((Object) g2, "DateTime.now()");
        this.timeOfStart = g2;
    }

    public void onStop() {
        super.onStop();
        d dVar = this.viewModel;
        long c2 = dVar.c();
        b g2 = b.g();
        h.a((Object) g2, "DateTime.now()");
        long n = g2.n();
        b bVar = this.timeOfStart;
        if (bVar != null) {
            dVar.a(c2 + (n - bVar.n()));
        } else {
            h.b("timeOfStart");
            throw null;
        }
    }
}
