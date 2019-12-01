package com.touchin.vtb.viewcontrollers.startup;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.touchin.vtb.R;
import com.touchin.vtb.activities.c;
import com.touchin.vtb.g.b;
import com.touchin.vtb.viewcontrollers.base.RegistrationWithToolbarViewController;
import com.touchin.vtb.views.ProgressButton;
import kotlin.TypeCastException;
import kotlin.e.b.h;

/* compiled from: ConnectBankViewController.kt */
public final class ConnectBankViewController extends RegistrationWithToolbarViewController<c, b> {
    public static final a Companion = new a(null);
    private static final float EXTRA_BANK_SUBTITLE_DEFAULT_LINE_SPACING_ADD = 24.0f;
    private static final float EXTRA_BANK_SUBTITLE_LINE_SPACING_MULT = 1.0f;
    private static final float EXTRA_BANK_SUBTITLE_REGISTRATION_LINE_SPACING_ADD = 7.0f;
    private static final float EXTRA_BANK_SUBTITLE_TEXT_SIZE = 14.0f;
    private static final int REGISTRATION_PROGRESS = 75;
    private final ChipGroup chipGroup = ((ChipGroup) findViewById(R.id.view_controller_connect_bank_chip_group));
    private final l.a.d.a.a.a.b onBackPressedListener = new C0686f(this);
    /* access modifiers changed from: private */
    public final ProgressButton progressButton = ((ProgressButton) findViewById(R.id.view_controller_connect_bank_progress_button));
    private final TextView subtitle = ((TextView) findViewById(R.id.view_controller_connect_bank_subtitle));

    /* compiled from: ConnectBankViewController.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    public ConnectBankViewController(ru.touchin.roboswag.components.navigation.viewcontrollers.c.a aVar) {
        h.b(aVar, "creationContext");
        super(aVar, R.layout.view_controller_connect_bank);
        initChipGroup();
        initToolbar();
        this.subtitle.setTextSize(EXTRA_BANK_SUBTITLE_TEXT_SIZE);
        if (!((b) getState()).q()) {
            this.subtitle.setTextColor(b.g.a.a.a((Context) getActivity(), (int) R.color.common_hint_color));
            this.subtitle.setLineSpacing(EXTRA_BANK_SUBTITLE_DEFAULT_LINE_SPACING_ADD, EXTRA_BANK_SUBTITLE_LINE_SPACING_MULT);
            ((c) getActivity()).a(new C0676a(this));
        } else {
            this.subtitle.setLineSpacing(EXTRA_BANK_SUBTITLE_REGISTRATION_LINE_SPACING_ADD, EXTRA_BANK_SUBTITLE_LINE_SPACING_MULT);
            ((c) getActivity()).a(this.onBackPressedListener);
        }
        this.progressButton.setOnClickListener(new C0682d(this));
    }

    private final void initChipGroup() {
        ChipGroup chipGroup2 = this.chipGroup;
        int childCount = chipGroup2.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = chipGroup2.getChildAt(i2);
            h.a((Object) childAt, "getChildAt(index)");
            if (childAt != null) {
                Chip chip = (Chip) childAt;
                String obj = chip.getText().toString();
                if (obj != null) {
                    String upperCase = obj.toUpperCase();
                    h.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
                    chip.setText(upperCase);
                    childAt.setVisibility(((b) getState()).o().contains(com.touchin.vtb.utils.a.f7607a.a(getActivity(), upperCase)) ^ true ? 0 : 8);
                    i2++;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.google.android.material.chip.Chip");
            }
        }
        this.chipGroup.setOnCheckedChangeListener(new C0684e(this));
    }

    private final void initToolbar() {
        setProgress(75);
        c.a((c) getActivity(), getToolbar(), getString(R.string.common_more_add_bank), null, true, 0, 20, null);
    }

    public void onDestroy() {
        super.onDestroy();
        if (((b) getState()).q()) {
            ((c) getActivity()).b(this.onBackPressedListener);
        }
    }
}
