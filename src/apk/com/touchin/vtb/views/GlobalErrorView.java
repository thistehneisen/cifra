package com.touchin.vtb.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.touchin.vtb.R;
import com.touchin.vtb.api.exceptions.ServerException;
import java.net.UnknownHostException;
import kotlin.e.a.a;
import kotlin.e.b.h;
import kotlin.m;
import l.a.b.g;

/* compiled from: GlobalErrorView.kt */
public final class GlobalErrorView extends ConstraintLayout {
    private final TextView x;
    private final TextView y;
    private final TextView z;

    public GlobalErrorView(Context context) {
        this(context, null, 0, 6, null);
    }

    public GlobalErrorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ GlobalErrorView(Context context, AttributeSet attributeSet, int i2, int i3, e eVar) {
        if ((i3 & 2) != 0) {
            attributeSet = null;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        this(context, attributeSet, i2);
    }

    public static /* synthetic */ void a(GlobalErrorView globalErrorView, String str, String str2, String str3, a aVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            str3 = null;
        }
        globalErrorView.a(str, str2, str3, aVar);
    }

    public GlobalErrorView(Context context, AttributeSet attributeSet, int i2) {
        h.b(context, "context");
        super(context, attributeSet, i2);
        l.a.d.a.b.a.b(R.layout.view_global_error, this);
        View findViewById = findViewById(R.id.view_global_error_title);
        h.a((Object) findViewById, "findViewById(R.id.view_global_error_title)");
        this.x = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.view_global_error_description);
        h.a((Object) findViewById2, "findViewById(R.id.view_global_error_description)");
        this.y = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.view_global_error_repeat_button);
        h.a((Object) findViewById3, "findViewById(R.id.view_global_error_repeat_button)");
        this.z = (TextView) findViewById3;
    }

    public final void a(String str, String str2, String str3, a<m> aVar) {
        h.b(aVar, "onRepeatClickAction");
        TextView textView = this.x;
        if (str == null) {
            str = getContext().getString(R.string.common_global_error_title);
        }
        textView.setText(str);
        TextView textView2 = this.y;
        if (str2 == null) {
            str2 = getContext().getString(R.string.common_global_error_description);
        }
        textView2.setText(str2);
        TextView textView3 = this.z;
        if (str3 == null) {
            str3 = getContext().getString(R.string.common_global_try_again);
        }
        textView3.setText(str3);
        g.a(this.z, aVar);
    }

    public final void a(Throwable th, a<m> aVar) {
        String string;
        h.b(th, "throwable");
        h.b(aVar, "onRepeatClickAction");
        if (th instanceof ServerException) {
            if (e.f7782a[((ServerException) th).a().ordinal()] != 1) {
                string = null;
            } else {
                string = getContext().getString(R.string.common_bank_session_expired_title);
            }
            a(this, th.getMessage(), string, null, aVar, 4, null);
        } else if (th instanceof UnknownHostException) {
            a(getContext().getString(R.string.common_no_connection_error_title), getContext().getString(R.string.common_no_connection_error_description), getContext().getString(R.string.common_global_update), aVar);
        } else {
            a(this, null, null, null, aVar, 7, null);
        }
    }
}
