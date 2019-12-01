package ru.touchin.templates.a;

import l.a.d.b.a.c;
import ru.touchin.templates.ApiModel;
import ru.touchin.templates.ApiModel.ValidationException;

/* compiled from: LoganSquareJsonModel */
public abstract class d extends ApiModel {
    protected static void a(Object obj) throws ValidationException {
        if (obj == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Not nullable object is null or missed at ");
            sb.append(c.a((Object) null, 1));
            throw new ValidationException(sb.toString());
        }
    }
}
