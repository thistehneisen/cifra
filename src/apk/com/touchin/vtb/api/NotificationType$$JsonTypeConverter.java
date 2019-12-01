package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class NotificationType$$JsonTypeConverter implements TypeConverter<NotificationType> {
    public NotificationType parse(e eVar) throws IOException {
        if (eVar.d() == g.VALUE_NULL) {
            return null;
        }
        String E = eVar.E();
        if (E.equals("tasks")) {
            return NotificationType.TASKS;
        }
        if (E.equals("connection")) {
            return NotificationType.CONNECTION;
        }
        if (E.equals("quarterEnd")) {
            return NotificationType.QUARTER_END;
        }
        if (E.equals("deadline")) {
            return NotificationType.DEADLINE;
        }
        if (E.equals("activity")) {
            return NotificationType.ACTIVITY;
        }
        throw new IllegalArgumentException(eVar.toString());
    }

    public void serialize(NotificationType notificationType, String str, boolean z, c cVar) throws IOException {
        String str2 = "activity";
        String str3 = "deadline";
        String str4 = "quarterEnd";
        String str5 = "connection";
        String str6 = "tasks";
        if (str != null) {
            if (notificationType == null) {
                cVar.d(str);
                return;
            }
            int i2 = o.f7126a[notificationType.ordinal()];
            if (i2 == 1) {
                cVar.a(str, str6);
            } else if (i2 == 2) {
                cVar.a(str, str5);
            } else if (i2 == 3) {
                cVar.a(str, str4);
            } else if (i2 == 4) {
                cVar.a(str, str3);
            } else if (i2 == 5) {
                cVar.a(str, str2);
            } else {
                throw new IllegalArgumentException(notificationType.name());
            }
        } else if (notificationType == null) {
            cVar.d();
        } else {
            int i3 = o.f7126a[notificationType.ordinal()];
            if (i3 == 1) {
                cVar.f(str6);
            } else if (i3 == 2) {
                cVar.f(str5);
            } else if (i3 == 3) {
                cVar.f(str4);
            } else if (i3 == 4) {
                cVar.f(str3);
            } else if (i3 == 5) {
                cVar.f(str2);
            } else {
                throw new IllegalArgumentException(notificationType.name());
            }
        }
    }
}
