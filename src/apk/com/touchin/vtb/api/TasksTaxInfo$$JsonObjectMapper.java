package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class TasksTaxInfo$$JsonObjectMapper extends JsonMapper<TasksTaxInfo> {
    private static final JsonMapper<TaxRequisites> COM_TOUCHIN_VTB_API_TAXREQUISITES__JSONOBJECTMAPPER = LoganSquare.mapperFor(TaxRequisites.class);
    private static final JsonMapper<BasePaymentInfo> parentObjectMapper = LoganSquare.mapperFor(BasePaymentInfo.class);

    public TasksTaxInfo parse(e eVar) throws IOException {
        TasksTaxInfo tasksTaxInfo = new TasksTaxInfo();
        if (eVar.d() == null) {
            eVar.F();
        }
        if (eVar.d() != g.START_OBJECT) {
            eVar.G();
            return null;
        }
        while (eVar.F() != g.END_OBJECT) {
            String c2 = eVar.c();
            eVar.F();
            parseField(tasksTaxInfo, c2, eVar);
            eVar.G();
        }
        return tasksTaxInfo;
    }

    public void parseField(TasksTaxInfo tasksTaxInfo, String str, e eVar) throws IOException {
        if ("id".equals(str)) {
            tasksTaxInfo.b(eVar.c(null));
        } else if ("payerRequisites".equals(str)) {
            tasksTaxInfo.a((TaxRequisites) COM_TOUCHIN_VTB_API_TAXREQUISITES__JSONOBJECTMAPPER.parse(eVar));
        } else if ("receiverRequisites".equals(str)) {
            tasksTaxInfo.b((TaxRequisites) COM_TOUCHIN_VTB_API_TAXREQUISITES__JSONOBJECTMAPPER.parse(eVar));
        } else {
            parentObjectMapper.parseField(tasksTaxInfo, str, eVar);
        }
    }

    public void serialize(TasksTaxInfo tasksTaxInfo, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (tasksTaxInfo.d() != null) {
            cVar.a("id", tasksTaxInfo.d());
        }
        if (tasksTaxInfo.e() != null) {
            cVar.c("payerRequisites");
            COM_TOUCHIN_VTB_API_TAXREQUISITES__JSONOBJECTMAPPER.serialize(tasksTaxInfo.e(), cVar, true);
        }
        if (tasksTaxInfo.f() != null) {
            cVar.c("receiverRequisites");
            COM_TOUCHIN_VTB_API_TAXREQUISITES__JSONOBJECTMAPPER.serialize(tasksTaxInfo.f(), cVar, true);
        }
        parentObjectMapper.serialize(tasksTaxInfo, cVar, false);
        if (z) {
            cVar.c();
        }
    }
}
