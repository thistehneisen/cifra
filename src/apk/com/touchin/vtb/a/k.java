package com.touchin.vtb.a;

import com.touchin.vtb.api.OperationInfo;
import kotlin.e.a.c;
import kotlin.e.b.h;
import kotlin.e.b.i;
import org.joda.time.b;

/* compiled from: BankOperationsAdapter.kt */
final class k extends i implements c<OperationInfo, OperationInfo, Boolean> {

    /* renamed from: a reason: collision with root package name */
    public static final k f6959a = new k();

    k() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj, Object obj2) {
        return Boolean.valueOf(a((OperationInfo) obj, (OperationInfo) obj2));
    }

    public final boolean a(OperationInfo operationInfo, OperationInfo operationInfo2) {
        h.b(operationInfo, "prevElement");
        h.b(operationInfo2, "currentElement");
        b d2 = operationInfo.d();
        String str = "prevElement.date";
        h.a((Object) d2, str);
        int e2 = d2.e();
        b d3 = operationInfo2.d();
        String str2 = "currentElement.date";
        h.a((Object) d3, str2);
        if (e2 == d3.e()) {
            b d4 = operationInfo.d();
            h.a((Object) d4, str);
            int c2 = d4.c();
            b d5 = operationInfo2.d();
            h.a((Object) d5, str2);
            if (c2 == d5.c()) {
                return false;
            }
        }
        return true;
    }
}
