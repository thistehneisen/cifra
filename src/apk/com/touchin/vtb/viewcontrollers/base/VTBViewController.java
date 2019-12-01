package com.touchin.vtb.viewcontrollers.base;

import android.os.Parcelable;
import android.view.ViewGroup;
import com.touchin.vtb.activities.c;
import kotlin.e.b.h;
import ru.touchin.roboswag.components.navigation.viewcontrollers.c.a;

/* compiled from: VTBViewController.kt */
public class VTBViewController<TActivity extends c, TState extends Parcelable> extends ru.touchin.roboswag.components.navigation.viewcontrollers.c<TActivity, TState> {
    public VTBViewController(a aVar, int i2) {
        h.b(aVar, "creationContext");
        super(aVar, i2);
        ViewGroup b2 = aVar.b();
        if (b2 != null) {
            b2.requestApplyInsets();
        }
    }
}
