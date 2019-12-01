package com.touchin.vtb.viewcontrollers.base;

import android.os.Parcelable;
import com.touchin.vtb.R;
import com.touchin.vtb.activities.c;
import com.touchin.vtb.api.BankConnectResponse;
import com.touchin.vtb.api.BankConnectionStatus;
import com.touchin.vtb.api.BankType;
import com.touchin.vtb.g.e;
import com.touchin.vtb.g.f;
import com.touchin.vtb.viewcontrollers.main.bank.BankViewController;
import com.touchin.vtb.viewcontrollers.startup.GetAccessConfirmSmsViewController;
import com.touchin.vtb.viewcontrollers.startup.GetAccessViewController;
import com.touchin.vtb.viewcontrollers.success.SuccessViewController;
import java.util.List;
import kotlin.e.a.b;
import kotlin.e.b.h;
import ru.touchin.roboswag.components.navigation.viewcontrollers.d;

/* compiled from: SessionRestorable.kt */
public interface a {

    /* renamed from: com.touchin.vtb.viewcontrollers.base.a$a reason: collision with other inner class name */
    /* compiled from: SessionRestorable.kt */
    public static final class C0079a {
        public static void a(a aVar, c cVar, BankConnectionStatus bankConnectionStatus, String str, BankType bankType, List<BankConnectResponse> list) {
            h.b(cVar, "activity");
            h.b(bankConnectionStatus, "status");
            h.b(str, "connectedBankId");
            h.b(bankType, "connectedBankType");
            h.b(list, "banksToRestoreSession");
            int i2 = b.f7641a[bankConnectionStatus.ordinal()];
            if (i2 == 1) {
                d c2 = cVar.c();
                f fVar = new f(bankType, Integer.valueOf(R.string.app_name), false, BankViewController.class.getName(), true, str, list);
                d.a(c2, GetAccessViewController.class, (Parcelable) fVar, (b) null, 4, (Object) null);
            } else if (i2 == 2) {
                d c3 = cVar.c();
                e eVar = new e(str, bankType, null, null, 0, BankViewController.class.getName(), true, list, 28, null);
                d.a(c3, GetAccessConfirmSmsViewController.class, (Parcelable) eVar, (b) null, 4, (Object) null);
            }
        }

        public static void a(a aVar, c cVar, String str) {
            h.b(cVar, "activity");
            d c2 = cVar.c();
            Class<SuccessViewController> cls = SuccessViewController.class;
            String string = cVar.getString(R.string.common_more_add_bank_success_title);
            if (!(!h.a((Object) str, (Object) BankViewController.class.getName()))) {
                string = null;
            }
            if (string == null) {
                string = "";
            }
            String string2 = cVar.getString(R.string.common_more_add_bank_success_description);
            h.a((Object) string2, "activity.getString(R.str…bank_success_description)");
            d.a(c2, cls, new com.touchin.vtb.viewcontrollers.success.a(string, string2, str), false, null, null, 28, null);
        }
    }
}
