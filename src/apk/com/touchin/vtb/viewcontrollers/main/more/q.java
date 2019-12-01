package com.touchin.vtb.viewcontrollers.main.more;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.v;
import com.touchin.vtb.api.CompanyInfo;
import com.touchin.vtb.api.UserProfile;
import java.util.List;
import l.a.c.a.a;
import l.a.c.a.a.d;

/* compiled from: MoreViewController.kt */
final class q<T> implements v<a<? extends UserProfile>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ MoreViewController f7657a;

    q(MoreViewController moreViewController) {
        this.f7657a = moreViewController;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0048, code lost:
        if ((r4 == null || r4.isEmpty()) == false) goto L_0x004c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0021  */
    public final void a(a<? extends UserProfile> aVar) {
        String str;
        UserProfile userProfile;
        boolean z;
        if (aVar instanceof d) {
            TextView access$getOrganizationTitle$p = this.f7657a.organizationTitle;
            UserProfile userProfile2 = (UserProfile) aVar.a();
            if (userProfile2 != null) {
                CompanyInfo b2 = userProfile2.b();
                if (b2 != null) {
                    str = b2.h();
                    if (str == null) {
                        str = "";
                    }
                    access$getOrganizationTitle$p.setText(str);
                    View access$getManageBankButton$p = this.f7657a.manageBankButton;
                    userProfile = (UserProfile) aVar.a();
                    z = true;
                    int i2 = 0;
                    if (userProfile != null) {
                        List c2 = userProfile.c();
                        if (c2 != null) {
                        }
                    }
                    z = false;
                    if (!z) {
                        i2 = 8;
                    }
                    access$getManageBankButton$p.setVisibility(i2);
                }
            }
            str = null;
            if (str == null) {
            }
            access$getOrganizationTitle$p.setText(str);
            View access$getManageBankButton$p2 = this.f7657a.manageBankButton;
            userProfile = (UserProfile) aVar.a();
            z = true;
            int i22 = 0;
            if (userProfile != null) {
            }
            z = false;
            if (!z) {
            }
            access$getManageBankButton$p2.setVisibility(i22);
        }
    }
}
