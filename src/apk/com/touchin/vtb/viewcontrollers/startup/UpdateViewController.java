package com.touchin.vtb.viewcontrollers.startup;

import android.view.View;
import com.touchin.vtb.R;
import com.touchin.vtb.activities.StartupActivity;
import com.touchin.vtb.api.ApiError;
import com.touchin.vtb.api.exceptions.ServerException;
import com.touchin.vtb.g.n;
import com.touchin.vtb.views.GlobalErrorView;
import kotlin.e.b.h;
import l.a.b.g;
import l.a.d.a.a.a.b;
import ru.touchin.roboswag.components.navigation.viewcontrollers.c;
import ru.touchin.roboswag.components.navigation.viewcontrollers.c.a;
import ru.touchin.widget.Switcher;

/* compiled from: UpdateViewController.kt */
public final class UpdateViewController extends c<StartupActivity, n> {
    private final View closeButton = findViewById(R.id.update_view_controller_close_button);
    /* access modifiers changed from: private */
    public boolean isCancelable;
    private final b onBackPressedListener = new ta(this);
    private final Switcher switcher = ((Switcher) findViewById(R.id.update_view_controller_switcher));
    private final View updateButton = findViewById(R.id.update_view_controller_update_button);

    public UpdateViewController(a aVar) {
        h.b(aVar, "creationContext");
        super(aVar, R.layout.view_controller_update);
        Throwable n = ((n) getState()).n();
        if (!(n instanceof ServerException)) {
            n = null;
        }
        ServerException serverException = (ServerException) n;
        if (serverException != null) {
            ApiError a2 = serverException.a();
            if (a2 != null) {
                int i2 = sa.f7727a[a2.ordinal()];
                if (i2 == 1) {
                    this.isCancelable = true;
                } else if (i2 != 2) {
                    processError();
                } else {
                    this.isCancelable = false;
                }
                g.a(this.updateButton, new qa(this));
                g.a(this.closeButton, new ra(this));
            }
        }
        processError();
        g.a(this.updateButton, new qa(this));
        g.a(this.closeButton, new ra(this));
    }

    private final void processError() {
        this.switcher.a(R.id.update_view_controller_error);
        ((GlobalErrorView) findViewById(R.id.update_view_controller_error)).a(((n) getState()).n(), new ua(this));
    }

    public void onStart() {
        super.onStart();
        ((StartupActivity) getActivity()).a(this.onBackPressedListener);
    }

    public void onStop() {
        super.onStop();
        ((StartupActivity) getActivity()).b(this.onBackPressedListener);
    }
}
