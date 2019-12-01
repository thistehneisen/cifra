package com.touchin.vtb.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.C0146m;
import androidx.fragment.app.C0200o;
import androidx.fragment.app.Fragment;
import com.touchin.vtb.R;
import com.touchin.vtb.d.a;
import kotlin.m;
import l.a.b.g;

/* compiled from: DialogManager.kt */
public final class h {

    /* renamed from: a reason: collision with root package name */
    public static final h f7619a = new h();

    private h() {
    }

    public static /* synthetic */ void a(h hVar, C0200o oVar, int i2, Fragment fragment, String str, String str2, String str3, int i3, Object obj) {
        hVar.a(oVar, (i3 & 2) != 0 ? 200 : i2, (i3 & 4) != 0 ? null : fragment, (i3 & 8) != 0 ? null : str, str2, str3);
    }

    public final void a(C0200o oVar, int i2, Fragment fragment, String str, String str2, String str3) {
        kotlin.e.b.h.b(oVar, "fragmentManager");
        kotlin.e.b.h.b(str2, "title");
        kotlin.e.b.h.b(str3, "actionText");
        a a2 = a.f7235l.a(str2, str3);
        if (fragment != null) {
            a2.setTargetFragment(fragment, i2);
        }
        a2.a(oVar, str);
    }

    public static /* synthetic */ void a(h hVar, Context context, String str, CharSequence charSequence, CharSequence charSequence2, kotlin.e.a.a aVar, kotlin.e.a.a aVar2, boolean z, int i2, Object obj) {
        hVar.a(context, str, charSequence, charSequence2, aVar, (i2 & 32) != 0 ? d.f7617a : aVar2, (i2 & 64) != 0 ? false : z);
    }

    public final void a(Context context, String str, CharSequence charSequence, CharSequence charSequence2, kotlin.e.a.a<m> aVar, kotlin.e.a.a<m> aVar2, boolean z) {
        Context context2 = context;
        kotlin.e.b.h.b(context, "context");
        String str2 = str;
        kotlin.e.b.h.b(str, "title");
        CharSequence charSequence3 = charSequence;
        kotlin.e.b.h.b(charSequence3, "positiveButtonText");
        CharSequence charSequence4 = charSequence2;
        kotlin.e.b.h.b(charSequence4, "negativeButtonText");
        kotlin.e.a.a<m> aVar3 = aVar;
        kotlin.e.b.h.b(aVar3, "positiveButtonAction");
        kotlin.e.a.a<m> aVar4 = aVar2;
        kotlin.e.b.h.b(aVar4, "negativeButtonAction");
        a(this, context2, str2, null, charSequence3, charSequence4, aVar3, aVar4, z, R.layout.dialog_logout, 4, null);
    }

    public static /* synthetic */ void a(h hVar, Context context, String str, String str2, CharSequence charSequence, CharSequence charSequence2, kotlin.e.a.a aVar, kotlin.e.a.a aVar2, boolean z, int i2, int i3, Object obj) {
        int i4 = i3;
        hVar.a(context, str, (i4 & 4) != 0 ? null : str2, charSequence, charSequence2, aVar, (i4 & 64) != 0 ? g.f7618a : aVar2, (i4 & 128) != 0 ? false : z, (i4 & 256) != 0 ? R.layout.dialog_simple : i2);
    }

    public final void a(Context context, String str, String str2, CharSequence charSequence, CharSequence charSequence2, kotlin.e.a.a<m> aVar, kotlin.e.a.a<m> aVar2, boolean z, int i2) {
        kotlin.e.b.h.b(context, "context");
        kotlin.e.b.h.b(str, "title");
        kotlin.e.b.h.b(charSequence, "positiveButtonText");
        kotlin.e.b.h.b(charSequence2, "negativeButtonText");
        kotlin.e.b.h.b(aVar, "positiveButtonAction");
        kotlin.e.b.h.b(aVar2, "negativeButtonAction");
        int i3 = 0;
        View inflate = LayoutInflater.from(context).inflate(i2, null, false);
        C0146m create = new C0146m.a(context).setView(inflate).setCancelable(z).create();
        kotlin.e.b.h.a((Object) create, "dialog");
        Window window = create.getWindow();
        boolean z2 = true;
        if (window != null) {
            window.requestFeature(1);
        }
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_title);
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = (TextView) inflate.findViewById(R.id.dialog_message);
        if (textView2 != null) {
            textView2.setText(str2);
            if (str2 == null) {
                z2 = false;
            }
            if (!z2) {
                i3 = 8;
            }
            textView2.setVisibility(i3);
        }
        TextView textView3 = (TextView) inflate.findViewById(R.id.dialog_positive_button);
        if (textView3 != null) {
            textView3.setText(charSequence);
            g.a(textView3, new e(charSequence, aVar, create));
        }
        TextView textView4 = (TextView) inflate.findViewById(R.id.dialog_negative_button);
        if (textView4 != null) {
            textView4.setText(charSequence2);
            g.a(textView4, new f(charSequence2, aVar2, create));
        }
        create.show();
    }
}
