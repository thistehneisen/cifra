package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class TaskIdBody$$JsonObjectMapper extends JsonMapper<TaskIdBody> {
    private static final JsonMapper<SessionIdBody> parentObjectMapper = LoganSquare.mapperFor(SessionIdBody.class);

    public TaskIdBody parse(e eVar) throws IOException {
        TaskIdBody taskIdBody = new TaskIdBody();
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
            parseField(taskIdBody, c2, eVar);
            eVar.G();
        }
        return taskIdBody;
    }

    public void parseField(TaskIdBody taskIdBody, String str, e eVar) throws IOException {
        if ("taskId".equals(str)) {
            taskIdBody.b(eVar.c(null));
        } else {
            parentObjectMapper.parseField(taskIdBody, str, eVar);
        }
    }

    public void serialize(TaskIdBody taskIdBody, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (taskIdBody.c() != null) {
            cVar.a("taskId", taskIdBody.c());
        }
        parentObjectMapper.serialize(taskIdBody, cVar, false);
        if (z) {
            cVar.c();
        }
    }
}
