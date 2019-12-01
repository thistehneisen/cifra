package com.touchin.vtb.utils.b;

import android.content.Context;
import android.widget.TextView;
import com.touchin.vtb.R;
import com.touchin.vtb.utils.b;
import kotlin.e.b.h;
import kotlin.m;

/* compiled from: RepeatSmsCountDownTimer.kt */
public class a extends b {

    /* renamed from: a reason: collision with root package name */
    private boolean f7612a;

    /* renamed from: b reason: collision with root package name */
    private final Context f7613b;

    /* renamed from: c reason: collision with root package name */
    private final TextView f7614c;

    /* renamed from: d reason: collision with root package name */
    private final kotlin.e.a.a<m> f7615d;

    public a(Context context, TextView textView, kotlin.e.a.a<m> aVar, long j2, long j3) {
        h.b(context, "context");
        h.b(textView, "repeatTextView");
        h.b(aVar, "onFinishAction");
        super(j2, j3);
        this.f7613b = context;
        this.f7614c = textView;
        this.f7615d = aVar;
    }

    public final void a(boolean z) {
        this.f7612a = z;
    }

    public void onFinish() {
        this.f7615d.b();
    }

    public void onTick(long j2) {
        a(j2);
    }

    private final void a(long j2) {
        String str;
        if (!this.f7612a) {
            TextView textView = this.f7614c;
            if (j2 < 1000) {
                str = this.f7613b.getString(R.string.common_registration_code_resend_button_title);
            } else {
                Context context = this.f7613b;
                b bVar = b.f7611a;
                str = context.getString(R.string.android_registration_code_send_after_button_title, new Object[]{org.joda.time.e.a.a(b.f7611a.a(j2)).a(j2), bVar.a(this.f7613b, bVar.d(j2))});
            }
            textView.setText(str);
            this.f7614c.setTextColor(b.g.a.a.a(this.f7613b, (int) R.color.common_action_color));
        }
    }
}
