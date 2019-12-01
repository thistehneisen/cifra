package com.touchin.vtb.viewcontrollers.main.taxes;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.C;
import androidx.viewpager.widget.ViewPager;
import b.g.a.a.h;
import com.google.android.material.tabs.TabLayout.c;
import com.google.android.material.tabs.TabLayout.f;
import com.touchin.vtb.R;
import com.touchin.vtb.a.t;
import com.touchin.vtb.activities.StartupActivity;
import com.touchin.vtb.api.Amount;
import com.touchin.vtb.api.TaxesListResponse;
import com.touchin.vtb.api.TaxesYearInfo;
import com.touchin.vtb.api.exceptions.ServerException;
import com.touchin.vtb.g.m;
import com.touchin.vtb.h.a.r;
import com.touchin.vtb.utils.k;
import com.touchin.vtb.viewcontrollers.base.VTBViewController;
import com.touchin.vtb.views.GlobalErrorView;
import com.touchin.vtb.views.TaxesSmartTabLayout;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import l.a.c.a.a.d;
import l.a.c.c.q;
import ru.touchin.roboswag.components.navigation.viewcontrollers.b;
import ru.touchin.roboswag.components.navigation.viewcontrollers.c.a;
import ru.touchin.widget.Switcher;

/* compiled from: TaxesPagerViewController.kt */
public final class TaxesPagerViewController extends VTBViewController<StartupActivity, b> implements c {
    private final TextView amountTextView = ((TextView) findViewById(R.id.view_controller_taxes_amount_text_view));
    private final GlobalErrorView errorView = ((GlobalErrorView) findViewById(R.id.view_controller_taxes_pager_error));
    private final ViewPager pager = ((ViewPager) findViewById(R.id.view_controller_taxes_view_pager));
    private final Typeface rubikLightFont = h.a(getActivity(), R.font.rubik_light);
    private final Typeface rubikMediumFont = h.a(getActivity(), R.font.rubik_medium);
    private final Switcher switcher = ((Switcher) findViewById(R.id.view_controller_taxes_pager_switcher));
    private final TaxesSmartTabLayout tabLayout = ((TaxesSmartTabLayout) findViewById(R.id.view_controller_taxes_pager_tab_layout));
    private e.b.b.b taxesListDisposable;
    private final TextView titleTextView = ((TextView) findViewById(R.id.view_controller_taxes_title_text_view));
    private final r viewModel;

    public TaxesPagerViewController(a aVar) {
        kotlin.e.b.h.b(aVar, "creationContext");
        super(aVar, R.layout.view_controller_taxes_pager);
        C a2 = q.a(q.f10391a, this, null, 2, null).a(r.class);
        kotlin.e.b.h.a((Object) a2, "LifecycleViewModelProvid…xesViewModel::class.java)");
        this.viewModel = (r) a2;
        initTitle();
        observeData();
        loadData();
    }

    private final void initPagerAdapter(List<? extends TaxesYearInfo> list) {
        ArrayList arrayList = new ArrayList(j.a(list, 10));
        for (TaxesYearInfo taxesYearInfo : list) {
            arrayList.add(new t.a(TaxesViewController.class, new m(taxesYearInfo.d()), String.valueOf(taxesYearInfo.d())));
        }
        this.pager.setAdapter(new t(getFragment(), arrayList));
        this.tabLayout.setViewPager(this.pager);
        this.tabLayout.a(arrayList.size() - 1).performClick();
    }

    private final void initTitle() {
        TextView textView = this.titleTextView;
        com.touchin.vtb.utils.b bVar = com.touchin.vtb.utils.b.f7611a;
        org.joda.time.b g2 = org.joda.time.b.g();
        kotlin.e.b.h.a((Object) g2, "DateTime.now()");
        textView.setText(getString(R.string.common_taxes_title_template, bVar.a(g2, k.DAY_MONTH_YEAR)));
    }

    /* access modifiers changed from: private */
    public final void loadData() {
        e.b.b.b bVar = this.taxesListDisposable;
        if (bVar != null) {
            bVar.b();
        }
        this.taxesListDisposable = this.viewModel.d();
    }

    private final void observeData() {
        this.viewModel.c().a(this, new d(new b(this)));
    }

    private final void processThrowable(Throwable th) {
        if (th instanceof ServerException) {
            if (a.f7679a[((ServerException) th).a().ordinal()] == 1) {
                this.amountTextView.setText(getString(R.string.common_taxes_not_calculated));
                org.joda.time.b g2 = org.joda.time.b.g();
                kotlin.e.b.h.a((Object) g2, "DateTime.now()");
                initPagerAdapter(h.a(new TaxesYearInfo(g2.e(), null, i.a())));
                this.switcher.a(R.id.view_controller_taxes_pager_tabs);
                return;
            }
        } else {
            l.a.d.b.a.c.a(th);
        }
        this.switcher.a(R.id.view_controller_taxes_pager_error);
        this.errorView.a(th, new c(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003b, code lost:
        if (r2 != null) goto L_0x0040;
     */
    public final void showTaxesListEvent(l.a.c.a.a<? extends TaxesListResponse> aVar) {
        String str;
        BigDecimal bigDecimal;
        if (aVar instanceof l.a.c.a.a.c) {
            this.switcher.a(R.id.global_loader);
        } else if (aVar instanceof d) {
            d dVar = (d) aVar;
            List c2 = ((TaxesListResponse) dVar.a()).c();
            kotlin.e.b.h.a((Object) c2, "event.data.taxesList");
            TextView textView = this.amountTextView;
            if (!c2.isEmpty()) {
                Amount b2 = ((TaxesListResponse) dVar.a()).b();
                if (b2 != null) {
                    bigDecimal = b2.c();
                }
                bigDecimal = BigDecimal.ZERO;
                if (!kotlin.e.b.h.a((Object) bigDecimal, (Object) BigDecimal.ZERO)) {
                    Amount b3 = ((TaxesListResponse) dVar.a()).b();
                    str = b3 != null ? com.touchin.vtb.e.a.a(b3, false, false, null, 7, null) : null;
                    textView.setText(str);
                    initPagerAdapter(c2);
                    this.switcher.a(R.id.view_controller_taxes_pager_tabs);
                }
            }
            str = getString(R.string.common_taxes_not_accured);
            textView.setText(str);
            initPagerAdapter(c2);
            this.switcher.a(R.id.view_controller_taxes_pager_tabs);
        } else if (aVar instanceof l.a.c.a.a.b) {
            processThrowable(((l.a.c.a.a.b) aVar).b());
        }
    }

    public void onTabReselected(f fVar) {
        View a2 = fVar != null ? fVar.a() : null;
        if (!(a2 instanceof TextView)) {
            a2 = null;
        }
        TextView textView = (TextView) a2;
        if (textView != null) {
            textView.setTypeface(this.rubikMediumFont);
        }
    }

    public void onTabSelected(f fVar) {
        View a2 = fVar != null ? fVar.a() : null;
        if (!(a2 instanceof TextView)) {
            a2 = null;
        }
        TextView textView = (TextView) a2;
        if (textView != null) {
            textView.setTypeface(this.rubikMediumFont);
        }
    }

    public void onTabUnselected(f fVar) {
        View a2 = fVar != null ? fVar.a() : null;
        if (!(a2 instanceof TextView)) {
            a2 = null;
        }
        TextView textView = (TextView) a2;
        if (textView != null) {
            textView.setTypeface(this.rubikLightFont);
        }
    }
}
