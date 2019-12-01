package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import io.intercom.android.sdk.metrics.MetricTracker.Action;
import java.io.IOException;

public final class TaskStatus$$JsonTypeConverter implements TypeConverter<TaskStatus> {
    public TaskStatus parse(e eVar) throws IOException {
        if (eVar.d() == g.VALUE_NULL) {
            return null;
        }
        String E = eVar.E();
        if (E.equals("inProgress")) {
            return TaskStatus.IN_PROGRESS;
        }
        if (E.equals(Action.COMPLETED)) {
            return TaskStatus.COMPLETED;
        }
        if (E.equals("active")) {
            return TaskStatus.ACTIVE;
        }
        if (E.equals("deleted")) {
            return TaskStatus.DELETED;
        }
        throw new IllegalArgumentException(eVar.toString());
    }

    public void serialize(TaskStatus taskStatus, String str, boolean z, c cVar) throws IOException {
        String str2 = "deleted";
        String str3 = "active";
        String str4 = Action.COMPLETED;
        String str5 = "inProgress";
        if (str != null) {
            if (taskStatus == null) {
                cVar.d(str);
                return;
            }
            int i2 = t.f7131a[taskStatus.ordinal()];
            if (i2 == 1) {
                cVar.a(str, str5);
            } else if (i2 == 2) {
                cVar.a(str, str4);
            } else if (i2 == 3) {
                cVar.a(str, str3);
            } else if (i2 == 4) {
                cVar.a(str, str2);
            } else {
                throw new IllegalArgumentException(taskStatus.name());
            }
        } else if (taskStatus == null) {
            cVar.d();
        } else {
            int i3 = t.f7131a[taskStatus.ordinal()];
            if (i3 == 1) {
                cVar.f(str5);
            } else if (i3 == 2) {
                cVar.f(str4);
            } else if (i3 == 3) {
                cVar.f(str3);
            } else if (i3 == 4) {
                cVar.f(str2);
            } else {
                throw new IllegalArgumentException(taskStatus.name());
            }
        }
    }
}
