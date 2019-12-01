package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* renamed from: androidx.fragment.app.k reason: case insensitive filesystem */
/* compiled from: FragmentContainer */
public abstract class C0196k {
    public abstract View a(int i2);

    @Deprecated
    public Fragment a(Context context, String str, Bundle bundle) {
        return Fragment.instantiate(context, str, bundle);
    }

    public abstract boolean a();
}
