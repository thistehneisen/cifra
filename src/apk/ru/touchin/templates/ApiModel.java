package ru.touchin.templates;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import l.a.d.b.a.c;
import l.a.d.b.a.d;

public abstract class ApiModel implements Serializable {

    /* renamed from: a reason: collision with root package name */
    public static final d f11174a = new d("API_VALIDATION");
    private static final long serialVersionUID = 1;

    public static class ValidationException extends IOException {
        public ValidationException(String str) {
            super(str);
        }
    }

    public enum a {
        EXCEPTION_IF_ANY_INVALID,
        EXCEPTION_IF_ALL_INVALID,
        REMOVE_INVALID_ITEMS
    }

    public static void a(Collection collection, a aVar) throws ValidationException {
        Iterator it = collection.iterator();
        int i2 = 0;
        boolean z = false;
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof ApiModel) {
                try {
                    ((ApiModel) next).a();
                    z = true;
                } catch (ValidationException e2) {
                    int i3 = a.f11179a[aVar.ordinal()];
                    if (i3 != 1) {
                        String str = "Item %s is invalid at ";
                        if (i3 == 2) {
                            it.remove();
                            d dVar = f11174a;
                            StringBuilder sb = new StringBuilder();
                            sb.append(str);
                            sb.append(c.a((Object) null, 1));
                            dVar.a(e2, sb.toString(), Integer.valueOf(i2));
                            if (!it.hasNext() && !z) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Whole list is invalid at ");
                                sb2.append(c.a((Object) null, 1));
                                throw new ValidationException(sb2.toString());
                            }
                        } else if (i3 != 3) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Unexpected rule ");
                            sb3.append(aVar);
                            c.a(sb3.toString());
                        } else {
                            it.remove();
                            d dVar2 = f11174a;
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(str);
                            sb4.append(c.a((Object) null, 1));
                            dVar2.a(e2, sb4.toString(), Integer.valueOf(i2));
                        }
                    } else {
                        throw e2;
                    }
                }
                i2++;
            } else if (next != null) {
                return;
            }
        }
    }

    public void a() throws ValidationException {
    }
}
