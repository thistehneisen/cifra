package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class TaskListResponse$$JsonObjectMapper extends JsonMapper<TaskListResponse> {
    private static final JsonMapper<TaskInfo> COM_TOUCHIN_VTB_API_TASKINFO__JSONOBJECTMAPPER = LoganSquare.mapperFor(TaskInfo.class);

    public TaskListResponse parse(e eVar) throws IOException {
        TaskListResponse taskListResponse = new TaskListResponse();
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
            parseField(taskListResponse, c2, eVar);
            eVar.G();
        }
        return taskListResponse;
    }

    public void parseField(TaskListResponse taskListResponse, String str, e eVar) throws IOException {
        if ("taskList".equals(str)) {
            if (eVar.d() == g.START_ARRAY) {
                ArrayList arrayList = new ArrayList();
                while (eVar.F() != g.END_ARRAY) {
                    arrayList.add((TaskInfo) COM_TOUCHIN_VTB_API_TASKINFO__JSONOBJECTMAPPER.parse(eVar));
                }
                taskListResponse.a(arrayList);
                return;
            }
            taskListResponse.a(null);
        } else if (!"urgentTaskList".equals(str)) {
        } else {
            if (eVar.d() == g.START_ARRAY) {
                ArrayList arrayList2 = new ArrayList();
                while (eVar.F() != g.END_ARRAY) {
                    arrayList2.add((TaskInfo) COM_TOUCHIN_VTB_API_TASKINFO__JSONOBJECTMAPPER.parse(eVar));
                }
                taskListResponse.b(arrayList2);
                return;
            }
            taskListResponse.b(null);
        }
    }

    public void serialize(TaskListResponse taskListResponse, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        List<TaskInfo> b2 = taskListResponse.b();
        if (b2 != null) {
            cVar.c("taskList");
            cVar.e();
            for (TaskInfo taskInfo : b2) {
                if (taskInfo != null) {
                    COM_TOUCHIN_VTB_API_TASKINFO__JSONOBJECTMAPPER.serialize(taskInfo, cVar, true);
                }
            }
            cVar.b();
        }
        List<TaskInfo> c2 = taskListResponse.c();
        if (c2 != null) {
            cVar.c("urgentTaskList");
            cVar.e();
            for (TaskInfo taskInfo2 : c2) {
                if (taskInfo2 != null) {
                    COM_TOUCHIN_VTB_API_TASKINFO__JSONOBJECTMAPPER.serialize(taskInfo2, cVar, true);
                }
            }
            cVar.b();
        }
        if (z) {
            cVar.c();
        }
    }
}
