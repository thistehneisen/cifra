package com.touchin.vtb.a.b;

import android.view.View;
import android.view.ViewGroup;
import com.touchin.vtb.R;
import com.touchin.vtb.a.c.m;
import com.touchin.vtb.api.TaskInfo;
import java.util.List;
import kotlin.e.b.h;
import l.a.a.f;
import l.a.d.a.b.a;

/* compiled from: TaskInfoDelegate.kt */
public final class b extends f<m, com.touchin.vtb.a.H.b> {

    /* renamed from: b reason: collision with root package name */
    private final kotlin.e.a.b<String, kotlin.m> f6901b;

    /* renamed from: c reason: collision with root package name */
    private final kotlin.e.a.b<String, kotlin.m> f6902c;

    /* renamed from: d reason: collision with root package name */
    private final kotlin.e.a.b<TaskInfo, kotlin.m> f6903d;

    public b(kotlin.e.a.b<? super String, kotlin.m> bVar, kotlin.e.a.b<? super String, kotlin.m> bVar2, kotlin.e.a.b<? super TaskInfo, kotlin.m> bVar3) {
        h.b(bVar, "deleteTaskAction");
        h.b(bVar2, "restoreTaskAction");
        h.b(bVar3, "onInfoItemClickAction");
        this.f6901b = bVar;
        this.f6902c = bVar2;
        this.f6903d = bVar3;
    }

    public boolean b(Object obj, int i2, int i3) {
        h.b(obj, "item");
        return obj instanceof com.touchin.vtb.a.H.b;
    }

    public m a(ViewGroup viewGroup) {
        h.b(viewGroup, "parent");
        View a2 = a.a(R.layout.item_task_info, viewGroup);
        h.a((Object) a2, "UiUtils.inflate(R.layout.item_task_info, parent)");
        return new m(a2, this.f6901b, this.f6902c, this.f6903d);
    }

    public void a(m mVar, com.touchin.vtb.a.H.b bVar, int i2, int i3, List<Object> list) {
        h.b(mVar, "holder");
        h.b(bVar, "item");
        h.b(list, "payloads");
        mVar.a(bVar.a());
    }
}
