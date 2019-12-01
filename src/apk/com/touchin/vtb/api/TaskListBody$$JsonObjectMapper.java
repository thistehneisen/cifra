package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class TaskListBody$$JsonObjectMapper extends JsonMapper<TaskListBody> {
    private static TypeConverter<TaskFilter> com_touchin_vtb_api_TaskFilter_type_converter;
    private static final JsonMapper<SessionIdBody> parentObjectMapper = LoganSquare.mapperFor(SessionIdBody.class);

    private static final TypeConverter<TaskFilter> getcom_touchin_vtb_api_TaskFilter_type_converter() {
        if (com_touchin_vtb_api_TaskFilter_type_converter == null) {
            com_touchin_vtb_api_TaskFilter_type_converter = LoganSquare.typeConverterFor(TaskFilter.class);
        }
        return com_touchin_vtb_api_TaskFilter_type_converter;
    }

    public TaskListBody parse(e eVar) throws IOException {
        TaskListBody taskListBody = new TaskListBody();
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
            parseField(taskListBody, c2, eVar);
            eVar.G();
        }
        return taskListBody;
    }

    public void parseField(TaskListBody taskListBody, String str, e eVar) throws IOException {
        if ("limit".equals(str)) {
            taskListBody.a(eVar.m());
        } else if ("offset".equals(str)) {
            taskListBody.b(eVar.m());
        } else if ("taskFilter".equals(str)) {
            taskListBody.a((TaskFilter) getcom_touchin_vtb_api_TaskFilter_type_converter().parse(eVar));
        } else {
            parentObjectMapper.parseField(taskListBody, str, eVar);
        }
    }

    public void serialize(TaskListBody taskListBody, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        cVar.a("limit", taskListBody.c());
        cVar.a("offset", taskListBody.d());
        if (taskListBody.e() != null) {
            getcom_touchin_vtb_api_TaskFilter_type_converter().serialize(taskListBody.e(), "taskFilter", true, cVar);
        }
        parentObjectMapper.serialize(taskListBody, cVar, false);
        if (z) {
            cVar.c();
        }
    }
}
