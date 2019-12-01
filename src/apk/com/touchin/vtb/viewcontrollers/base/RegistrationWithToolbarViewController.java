package com.touchin.vtb.viewcontrollers.base;

import android.os.Parcelable;
import android.widget.ProgressBar;
import androidx.appcompat.widget.Toolbar;
import com.touchin.vtb.R;
import com.touchin.vtb.activities.c;
import kotlin.e.b.h;
import ru.touchin.roboswag.components.navigation.viewcontrollers.c.a;

/* compiled from: RegistrationWithToolbarViewController.kt */
public class RegistrationWithToolbarViewController<TActivity extends c, TState extends Parcelable> extends VTBViewController<TActivity, TState> {
    private final ProgressBar progressBar = ((ProgressBar) findViewById(R.id.registration_progress));
    private final Toolbar toolbar = ((Toolbar) findViewById(R.id.global_toolbar));

    public RegistrationWithToolbarViewController(a aVar, int i2) {
        h.b(aVar, "creationContext");
        super(aVar, i2);
    }

    /* access modifiers changed from: protected */
    public final Toolbar getToolbar() {
        return this.toolbar;
    }

    public final void setProgress(int i2) {
        this.progressBar.setProgress(i2);
    }

    /* access modifiers changed from: protected */
    public final void setToolbarTitle(int i2) {
        this.toolbar.setTitle((CharSequence) getString(i2));
    }

    /* access modifiers changed from: protected */
    public final void setToolbarTitleVisible(boolean z) {
        this.toolbar.setVisibility(z ? 0 : 8);
    }
}
