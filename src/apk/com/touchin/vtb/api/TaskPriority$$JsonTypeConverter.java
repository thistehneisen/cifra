package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class TaskPriority$$JsonTypeConverter implements TypeConverter<TaskPriority> {
    public TaskPriority parse(e eVar) throws IOException {
        if (eVar.d() == g.VALUE_NULL) {
            return null;
        }
        String E = eVar.E();
        if (E.equals("high")) {
            return TaskPriority.HIGH;
        }
        if (E.equals("low")) {
            return TaskPriority.LOW;
        }
        throw new IllegalArgumentException(eVar.toString());
    }

    public void serialize(TaskPriority taskPriority, String str, boolean z, c cVar) throws IOException {
        String str2 = "low";
        String str3 = "high";
        if (str != null) {
            if (taskPriority == null) {
                cVar.d(str);
                return;
            }
            int i2 = s.f7130a[taskPriority.ordinal()];
            if (i2 == 1) {
                cVar.a(str, str3);
            } else if (i2 == 2) {
                cVar.a(str, str2);
            } else {
                throw new IllegalArgumentException(taskPriority.name());
            }
        } else if (taskPriority == null) {
            cVar.d();
        } else {
            int i3 = s.f7130a[taskPriority.ordinal()];
            if (i3 == 1) {
                cVar.f(str3);
            } else if (i3 == 2) {
                cVar.f(str2);
            } else {
                throw new IllegalArgumentException(taskPriority.name());
            }
        }
    }
}
