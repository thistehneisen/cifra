package com.touchin.vtb.a.c;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.touchin.vtb.R;
import com.touchin.vtb.api.TaskInfo;
import kotlin.e.a.b;
import kotlin.e.b.h;
import l.a.b.c;
import l.a.b.g;

/* compiled from: TaskInfoViewHolder.kt */
public final class m extends e {

    /* renamed from: c reason: collision with root package name */
    private final View f6924c = c.a(this, R.id.item_task_info_content_container);

    /* renamed from: d reason: collision with root package name */
    private final View f6925d = c.a(this, R.id.item_task_info_remove_button);

    /* renamed from: e reason: collision with root package name */
    private final View f6926e = c.a(this, R.id.item_task_info_remove_button_container);

    /* renamed from: f reason: collision with root package name */
    private final View f6927f = c.a(this, R.id.item_task_info_remove_button);

    /* renamed from: g reason: collision with root package name */
    private final TextView f6928g = ((TextView) c.a(this, R.id.item_task_info_title));

    /* renamed from: h reason: collision with root package name */
    private final TextView f6929h = ((TextView) c.a(this, R.id.item_task_info_description));
    /* access modifiers changed from: private */

    /* renamed from: i reason: collision with root package name */
    public final View f6930i = c.a(this, R.id.item_task_info_restore_container);

    /* renamed from: j reason: collision with root package name */
    private final View f6931j = c.a(this, R.id.item_task_info_restore_button);

    /* renamed from: k reason: collision with root package name */
    private final Animation f6932k;

    /* renamed from: l reason: collision with root package name */
    private final Animation f6933l;
    private final Animation m;
    private final Animation n;
    private final AnimationListener o;
    /* access modifiers changed from: private */
    public final b<String, kotlin.m> p;
    /* access modifiers changed from: private */
    public final b<String, kotlin.m> q;
    /* access modifiers changed from: private */
    public final b<TaskInfo, kotlin.m> r;

    public m(View view, b<? super String, kotlin.m> bVar, b<? super String, kotlin.m> bVar2, b<? super TaskInfo, kotlin.m> bVar3) {
        h.b(view, "itemView");
        h.b(bVar, "deleteTaskAction");
        h.b(bVar2, "restoreTaskAction");
        h.b(bVar3, "onInfoItemClickAction");
        super(view);
        this.p = bVar;
        this.q = bVar2;
        this.r = bVar3;
        Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.slide_to_left_animation);
        h.a((Object) loadAnimation, "AnimationUtils.loadAnima….slide_to_left_animation)");
        this.f6932k = loadAnimation;
        Animation loadAnimation2 = AnimationUtils.loadAnimation(view.getContext(), R.anim.slide_to_right_animation);
        h.a((Object) loadAnimation2, "AnimationUtils.loadAnima…slide_to_right_animation)");
        this.f6933l = loadAnimation2;
        Animation loadAnimation3 = AnimationUtils.loadAnimation(view.getContext(), R.anim.common_high_alpha_animation);
        h.a((Object) loadAnimation3, "AnimationUtils.loadAnima…mon_high_alpha_animation)");
        this.m = loadAnimation3;
        Animation loadAnimation4 = AnimationUtils.loadAnimation(view.getContext(), R.anim.common_low_alpha_animation);
        h.a((Object) loadAnimation4, "AnimationUtils.loadAnima…mmon_low_alpha_animation)");
        this.n = loadAnimation4;
        this.o = new i(this);
    }

    /* access modifiers changed from: protected */
    public View b() {
        return this.f6924c;
    }

    /* access modifiers changed from: protected */
    public View c() {
        return this.f6925d;
    }

    public final void a(TaskInfo taskInfo) {
        h.b(taskInfo, "taskInfo");
        b().setVisibility(0);
        this.f6926e.setVisibility(0);
        this.f6930i.setVisibility(8);
        this.f6928g.setText(taskInfo.k());
        this.f6929h.setText(taskInfo.i());
        g.a(this.f6927f, new j(this, taskInfo));
        g.a(this.f6931j, new k(this, taskInfo));
        g.a(b(), new l(this, taskInfo));
    }

    /* access modifiers changed from: private */
    public final void a(boolean z) {
        Animation animation;
        int i2 = 0;
        this.f6926e.setVisibility(z ? 4 : 0);
        View view = this.f6930i;
        if (!z) {
            i2 = 8;
        }
        view.setVisibility(i2);
        if (z) {
            this.f6926e.startAnimation(this.n);
            animation = this.f6932k;
        } else {
            a(0.0f);
            this.f6926e.startAnimation(this.m);
            animation = this.f6933l;
        }
        View b2 = b();
        animation.setAnimationListener(this.o);
        b2.startAnimation(animation);
    }
}
