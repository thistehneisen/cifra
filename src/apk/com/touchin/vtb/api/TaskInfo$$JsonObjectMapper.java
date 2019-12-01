package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;
import org.joda.time.b;

public final class TaskInfo$$JsonObjectMapper extends JsonMapper<TaskInfo> {
    private static final JsonMapper<Amount> COM_TOUCHIN_VTB_API_AMOUNT__JSONOBJECTMAPPER = LoganSquare.mapperFor(Amount.class);
    private static TypeConverter<TaskPriority> com_touchin_vtb_api_TaskPriority_type_converter;
    private static TypeConverter<TaskStatus> com_touchin_vtb_api_TaskStatus_type_converter;
    private static TypeConverter<TaskType> com_touchin_vtb_api_TaskType_type_converter;
    private static TypeConverter<b> org_joda_time_DateTime_type_converter;

    private static final TypeConverter<TaskPriority> getcom_touchin_vtb_api_TaskPriority_type_converter() {
        if (com_touchin_vtb_api_TaskPriority_type_converter == null) {
            com_touchin_vtb_api_TaskPriority_type_converter = LoganSquare.typeConverterFor(TaskPriority.class);
        }
        return com_touchin_vtb_api_TaskPriority_type_converter;
    }

    private static final TypeConverter<TaskStatus> getcom_touchin_vtb_api_TaskStatus_type_converter() {
        if (com_touchin_vtb_api_TaskStatus_type_converter == null) {
            com_touchin_vtb_api_TaskStatus_type_converter = LoganSquare.typeConverterFor(TaskStatus.class);
        }
        return com_touchin_vtb_api_TaskStatus_type_converter;
    }

    private static final TypeConverter<TaskType> getcom_touchin_vtb_api_TaskType_type_converter() {
        if (com_touchin_vtb_api_TaskType_type_converter == null) {
            com_touchin_vtb_api_TaskType_type_converter = LoganSquare.typeConverterFor(TaskType.class);
        }
        return com_touchin_vtb_api_TaskType_type_converter;
    }

    private static final TypeConverter<b> getorg_joda_time_DateTime_type_converter() {
        if (org_joda_time_DateTime_type_converter == null) {
            org_joda_time_DateTime_type_converter = LoganSquare.typeConverterFor(b.class);
        }
        return org_joda_time_DateTime_type_converter;
    }

    public TaskInfo parse(e eVar) throws IOException {
        TaskInfo taskInfo = new TaskInfo();
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
            parseField(taskInfo, c2, eVar);
            eVar.G();
        }
        return taskInfo;
    }

    public void parseField(TaskInfo taskInfo, String str, e eVar) throws IOException {
        if ("amount".equals(str)) {
            taskInfo.a((Amount) COM_TOUCHIN_VTB_API_AMOUNT__JSONOBJECTMAPPER.parse(eVar));
        } else if ("completionDate".equals(str)) {
            taskInfo.a((b) getorg_joda_time_DateTime_type_converter().parse(eVar));
        } else if ("creationDate".equals(str)) {
            taskInfo.b((b) getorg_joda_time_DateTime_type_converter().parse(eVar));
        } else if ("description".equals(str)) {
            taskInfo.a(eVar.c(null));
        } else if ("dueDate".equals(str)) {
            taskInfo.c((b) getorg_joda_time_DateTime_type_converter().parse(eVar));
        } else if ("id".equals(str)) {
            taskInfo.b(eVar.c(null));
        } else if ("priority".equals(str)) {
            taskInfo.a((TaskPriority) getcom_touchin_vtb_api_TaskPriority_type_converter().parse(eVar));
        } else if ("shortDescription".equals(str)) {
            taskInfo.c(eVar.c(null));
        } else if ("taskStatus".equals(str)) {
            taskInfo.a((TaskStatus) getcom_touchin_vtb_api_TaskStatus_type_converter().parse(eVar));
        } else if ("title".equals(str)) {
            taskInfo.d(eVar.c(null));
        } else if ("type".equals(str)) {
            taskInfo.a((TaskType) getcom_touchin_vtb_api_TaskType_type_converter().parse(eVar));
        }
    }

    public void serialize(TaskInfo taskInfo, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (taskInfo.b() != null) {
            cVar.c("amount");
            COM_TOUCHIN_VTB_API_AMOUNT__JSONOBJECTMAPPER.serialize(taskInfo.b(), cVar, true);
        }
        if (taskInfo.c() != null) {
            getorg_joda_time_DateTime_type_converter().serialize(taskInfo.c(), "completionDate", true, cVar);
        }
        if (taskInfo.d() != null) {
            getorg_joda_time_DateTime_type_converter().serialize(taskInfo.d(), "creationDate", true, cVar);
        }
        if (taskInfo.e() != null) {
            cVar.a("description", taskInfo.e());
        }
        if (taskInfo.f() != null) {
            getorg_joda_time_DateTime_type_converter().serialize(taskInfo.f(), "dueDate", true, cVar);
        }
        if (taskInfo.g() != null) {
            cVar.a("id", taskInfo.g());
        }
        if (taskInfo.h() != null) {
            getcom_touchin_vtb_api_TaskPriority_type_converter().serialize(taskInfo.h(), "priority", true, cVar);
        }
        if (taskInfo.i() != null) {
            cVar.a("shortDescription", taskInfo.i());
        }
        if (taskInfo.j() != null) {
            getcom_touchin_vtb_api_TaskStatus_type_converter().serialize(taskInfo.j(), "taskStatus", true, cVar);
        }
        if (taskInfo.k() != null) {
            cVar.a("title", taskInfo.k());
        }
        if (taskInfo.l() != null) {
            getcom_touchin_vtb_api_TaskType_type_converter().serialize(taskInfo.l(), "type", true, cVar);
        }
        if (z) {
            cVar.c();
        }
    }
}
