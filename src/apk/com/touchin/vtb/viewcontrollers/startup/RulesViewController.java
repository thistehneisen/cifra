package com.touchin.vtb.viewcontrollers.startup;

import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.touchin.vtb.R;
import com.touchin.vtb.activities.c;
import com.touchin.vtb.utils.j;
import com.touchin.vtb.viewcontrollers.base.VTBViewController;
import kotlin.e.b.h;
import ru.touchin.roboswag.components.navigation.viewcontrollers.b;

/* compiled from: RulesViewController.kt */
public final class RulesViewController extends VTBViewController<c, b> {
    public static final a Companion = new a(null);
    public static final String PRIVACY_POLICY_FILE = "privacy_policy.txt";

    /* compiled from: RulesViewController.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    public RulesViewController(ru.touchin.roboswag.components.navigation.viewcontrollers.c.a aVar) {
        h.b(aVar, "creationContext");
        super(aVar, R.layout.view_controller_rules);
        ((c) getActivity()).setSupportActionBar((Toolbar) findViewById(R.id.view_controller_rules_toolbar));
        ((TextView) findViewById(R.id.view_controller_rules_text)).setText(j.f7620a.a(getActivity(), PRIVACY_POLICY_FILE));
    }
}
