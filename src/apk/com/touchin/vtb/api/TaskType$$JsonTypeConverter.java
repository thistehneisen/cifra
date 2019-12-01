package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class TaskType$$JsonTypeConverter implements TypeConverter<TaskType> {
    public TaskType parse(e eVar) throws IOException {
        if (eVar.d() == g.VALUE_NULL) {
            return null;
        }
        String E = eVar.E();
        if (E.equals("bank_connection")) {
            return TaskType.BANK_CONNECTION;
        }
        if (E.equals("tax")) {
            return TaskType.TAX;
        }
        if (E.equals("info")) {
            return TaskType.INFO;
        }
        throw new IllegalArgumentException(eVar.toString());
    }

    public void serialize(TaskType taskType, String str, boolean z, c cVar) throws IOException {
        String str2 = "info";
        String str3 = "tax";
        String str4 = "bank_connection";
        if (str != null) {
            if (taskType == null) {
                cVar.d(str);
                return;
            }
            int i2 = u.f7132a[taskType.ordinal()];
            if (i2 == 1) {
                cVar.a(str, str4);
            } else if (i2 == 2) {
                cVar.a(str, str3);
            } else if (i2 == 3) {
                cVar.a(str, str2);
            } else {
                throw new IllegalArgumentException(taskType.name());
            }
        } else if (taskType == null) {
            cVar.d();
        } else {
            int i3 = u.f7132a[taskType.ordinal()];
            if (i3 == 1) {
                cVar.f(str4);
            } else if (i3 == 2) {
                cVar.f(str3);
            } else if (i3 == 3) {
                cVar.f(str2);
            } else {
                throw new IllegalArgumentException(taskType.name());
            }
        }
    }
}
