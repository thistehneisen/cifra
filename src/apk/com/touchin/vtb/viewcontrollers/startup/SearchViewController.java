package com.touchin.vtb.viewcontrollers.startup;

import android.view.View;
import android.widget.EditText;
import androidx.lifecycle.C;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.x;
import com.touchin.vtb.R;
import com.touchin.vtb.a.s;
import com.touchin.vtb.activities.c;
import com.touchin.vtb.e.k;
import com.touchin.vtb.h.c.v;
import com.touchin.vtb.viewcontrollers.base.VTBViewController;
import kotlin.e.b.h;
import kotlin.m;
import l.a.b.g;
import l.a.c.c.q;
import ru.touchin.roboswag.components.navigation.viewcontrollers.b;
import ru.touchin.roboswag.components.navigation.viewcontrollers.c.a;
import ru.touchin.widget.Switcher;

/* compiled from: SearchViewController.kt */
public final class SearchViewController extends VTBViewController<c, b> {
    /* access modifiers changed from: private */
    public final s adapter = new s();
    private final View backView = findViewById(R.id.view_controller_search_back_icon);
    private final View clearView = findViewById(R.id.view_controller_search_clear_icon);
    /* access modifiers changed from: private */
    public final EditText editText = ((EditText) findViewById(R.id.view_controller_search_edit_text));
    private final RecyclerView recycler = ((RecyclerView) findViewById(R.id.view_controller_search_recycler));
    /* access modifiers changed from: private */
    public final Switcher switcher = ((Switcher) findViewById(R.id.view_controller_search_switcher));
    /* access modifiers changed from: private */
    public final v viewModel;

    public SearchViewController(a aVar) {
        h.b(aVar, "creationContext");
        super(aVar, R.layout.view_controller_search);
        C a2 = q.a(q.f10391a, this, null, 2, null).a(v.class);
        h.a((Object) a2, "LifecycleViewModelProvid…rchViewModel::class.java)");
        this.viewModel = (v) a2;
        this.recycler.setAdapter(this.adapter);
        g.a(this.clearView, new ka(this));
        g.a(this.backView, new la(this));
        this.editText.addTextChangedListener(new com.touchin.vtb.utils.q(new ma(this)));
        k.a(this.editText, new na(this));
        this.adapter.a((kotlin.e.a.c<? super TItem, ? super x, m>) new oa<Object,Object,m>(this));
        this.viewModel.c().a(this, new pa(this));
    }

    public void onPause() {
        super.onPause();
        l.a.d.a.b.a.b.a((View) this.editText);
    }

    public void onResume() {
        super.onResume();
        l.a.d.a.b.a.b.b(this.editText);
    }
}
