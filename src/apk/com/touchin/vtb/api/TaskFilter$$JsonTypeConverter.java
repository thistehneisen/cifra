package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class TaskFilter$$JsonTypeConverter implements TypeConverter<TaskFilter> {
    public TaskFilter parse(e eVar) throws IOException {
        if (eVar.d() == g.VALUE_NULL) {
            return null;
        }
        String E = eVar.E();
        if (E.equals("active")) {
            return TaskFilter.ACTIVE;
        }
        if (E.equals("archived")) {
            return TaskFilter.ARCHIVED;
        }
        throw new IllegalArgumentException(eVar.toString());
    }

    public void serialize(TaskFilter taskFilter, String str, boolean z, c cVar) throws IOException {
        String str2 = "archived";
        String str3 = "active";
        if (str != null) {
            if (taskFilter == null) {
                cVar.d(str);
                return;
            }
            int i2 = r.f7129a[taskFilter.ordinal()];
            if (i2 == 1) {
                cVar.a(str, str3);
            } else if (i2 == 2) {
                cVar.a(str, str2);
            } else {
                throw new IllegalArgumentException(taskFilter.name());
            }
        } else if (taskFilter == null) {
            cVar.d();
        } else {
            int i3 = r.f7129a[taskFilter.ordinal()];
            if (i3 == 1) {
                cVar.f(str3);
            } else if (i3 == 2) {
                cVar.f(str2);
            } else {
                throw new IllegalArgumentException(taskFilter.name());
            }
        }
    }
}
