package com.touchin.vtb.activities.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout;
import androidx.fragment.app.C0195j;
import androidx.fragment.app.C0200o;
import androidx.fragment.app.Fragment;
import com.touchin.vtb.R;
import com.touchin.vtb.activities.MainActivity;
import com.touchin.vtb.g.a;
import com.touchin.vtb.g.l;
import com.touchin.vtb.viewcontrollers.main.bank.BankViewController;
import com.touchin.vtb.viewcontrollers.main.chat.ChatViewController;
import com.touchin.vtb.viewcontrollers.main.more.MoreViewController;
import com.touchin.vtb.viewcontrollers.main.tasks.TasksTabsViewController;
import com.touchin.vtb.viewcontrollers.main.taxes.TaxesPagerViewController;
import java.util.HashMap;
import kotlin.TypeCastException;
import kotlin.e.b.h;
import kotlin.g;
import kotlin.k;
import l.a.d.a.a.a.b;
import ru.touchin.roboswag.components.navigation.viewcontrollers.c;

/* compiled from: MainNavigationFragment.kt */
public final class f extends Fragment {

    /* renamed from: a reason: collision with root package name */
    private c f7008a;

    /* renamed from: b reason: collision with root package name */
    private final b f7009b = new d(this);

    /* renamed from: c reason: collision with root package name */
    private HashMap f7010c;

    public static final /* synthetic */ c a(f fVar) {
        c cVar = fVar.f7008a;
        if (cVar != null) {
            return cVar;
        }
        h.b("bottomNavigationController");
        throw null;
    }

    public void a() {
        HashMap hashMap = this.f7010c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Context requireContext = requireContext();
        h.a((Object) requireContext, "requireContext()");
        C0200o childFragmentManager = getChildFragmentManager();
        h.a((Object) childFragmentManager, "childFragmentManager");
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("PUSH_TASK_ID_KEY", null) : null;
        Bundle arguments2 = getArguments();
        this.f7008a = new c(requireContext, childFragmentManager, a(string, arguments2 != null ? Boolean.valueOf(arguments2.getBoolean("IS_DEADLINE_PUSH_KEY", false)) : null), new e(this));
        Bundle arguments3 = getArguments();
        String str = "bottomNavigationController";
        if (arguments3 != null) {
            c cVar = this.f7008a;
            if (cVar != null) {
                c.a(cVar, arguments3.getInt("NAVIGATE_TO_ITEM_ID_KEY"), null, 2, null);
            } else {
                h.b(str);
                throw null;
            }
        } else if (bundle == null) {
            c cVar2 = this.f7008a;
            if (cVar2 != null) {
                c.a(cVar2, R.id.main_navigation_tasks, null, 2, null);
            } else {
                h.b(str);
                throw null;
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.b(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_main_navigation, viewGroup, false);
        if (inflate != null) {
            View findViewById = inflate.findViewById(R.id.main_navigation_container);
            h.a((Object) findViewById, "fragmentView.findViewByI…ain_navigation_container)");
            LinearLayout linearLayout = (LinearLayout) findViewById;
            linearLayout.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
            linearLayout.setClipToOutline(true);
            c cVar = this.f7008a;
            if (cVar != null) {
                cVar.a((ViewGroup) linearLayout);
                b().a(this.f7009b);
                return inflate;
            }
            h.b("bottomNavigationController");
            throw null;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.View");
    }

    public void onDestroyView() {
        super.onDestroyView();
        b().b(this.f7009b);
        c cVar = this.f7008a;
        if (cVar != null) {
            cVar.a();
            a();
            return;
        }
        h.b("bottomNavigationController");
        throw null;
    }

    private final SparseArray<g<Class<? extends c<?, ?>>, Parcelable>> a(String str, Boolean bool) {
        SparseArray<g<Class<? extends c<?, ?>>, Parcelable>> sparseArray = new SparseArray<>();
        l lVar = new l(0, str, bool, 1, null);
        sparseArray.put(R.id.main_navigation_tasks, k.a(TasksTabsViewController.class, lVar));
        sparseArray.put(R.id.main_navigation_taxes, k.a(TaxesPagerViewController.class, ru.touchin.roboswag.components.navigation.viewcontrollers.b.f11113a));
        sparseArray.put(R.id.main_navigation_bank, k.a(BankViewController.class, new a(null, 1, null)));
        sparseArray.put(R.id.main_navigation_chat, k.a(ChatViewController.class, ru.touchin.roboswag.components.navigation.viewcontrollers.b.f11113a));
        sparseArray.put(R.id.main_navigation_more, k.a(MoreViewController.class, ru.touchin.roboswag.components.navigation.viewcontrollers.b.f11113a));
        return sparseArray;
    }

    /* access modifiers changed from: private */
    public final MainActivity b() {
        C0195j requireActivity = requireActivity();
        if (requireActivity != null) {
            return (MainActivity) requireActivity;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.touchin.vtb.activities.MainActivity");
    }

    /* access modifiers changed from: private */
    public final com.touchin.vtb.activities.c c() {
        C0195j requireActivity = requireActivity();
        if (requireActivity != null) {
            return (com.touchin.vtb.activities.c) requireActivity;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.touchin.vtb.activities.NavigationActivity");
    }
}
