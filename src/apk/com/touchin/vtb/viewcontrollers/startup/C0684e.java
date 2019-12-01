package com.touchin.vtb.viewcontrollers.startup;

import androidx.fragment.app.C0195j;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.chip.ChipGroup.c;
import com.touchin.vtb.g.b;
import com.touchin.vtb.utils.a;
import com.touchin.vtb.views.ProgressButton;
import kotlin.e.b.h;

/* renamed from: com.touchin.vtb.viewcontrollers.startup.e reason: case insensitive filesystem */
/* compiled from: ConnectBankViewController.kt */
final class C0684e implements c {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ ConnectBankViewController f7713a;

    C0684e(ConnectBankViewController connectBankViewController) {
        this.f7713a = connectBankViewController;
    }

    public final void a(ChipGroup chipGroup, int i2) {
        int i3 = 8;
        if (i2 > 0) {
            ProgressButton access$getProgressButton$p = this.f7713a.progressButton;
            if (((Chip) this.f7713a.findViewById(i2)).isChecked()) {
                i3 = 0;
            }
            access$getProgressButton$p.setVisibility(i3);
            b bVar = (b) this.f7713a.getState();
            a aVar = a.f7607a;
            C0195j activity = this.f7713a.getActivity();
            ConnectBankViewController connectBankViewController = this.f7713a;
            h.a((Object) chipGroup, "chipGroup");
            bVar.a(aVar.a(activity, ((Chip) connectBankViewController.findViewById(chipGroup.getCheckedChipId())).getText().toString()));
            return;
        }
        this.f7713a.progressButton.setVisibility(8);
    }
}
