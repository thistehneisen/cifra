package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.C0214g;
import androidx.lifecycle.h.a;
import androidx.lifecycle.l;
import androidx.savedstate.a.C0016a;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint({"RestrictedApi"})
final class Recreator implements C0214g {

    /* renamed from: a reason: collision with root package name */
    private final c f2054a;

    Recreator(c cVar) {
        this.f2054a = cVar;
    }

    public void a(l lVar, a aVar) {
        if (aVar == a.ON_CREATE) {
            lVar.getLifecycle().b(this);
            Bundle a2 = this.f2054a.getSavedStateRegistry().a("androidx.savedstate.Restarter");
            if (a2 != null) {
                ArrayList stringArrayList = a2.getStringArrayList("classes_to_restore");
                if (stringArrayList != null) {
                    Iterator it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        a((String) it.next());
                    }
                    return;
                }
                throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
            }
            return;
        }
        throw new AssertionError("Next event must be ON_CREATE");
    }

    private void a(String str) {
        try {
            Class asSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(C0016a.class);
            try {
                Constructor declaredConstructor = asSubclass.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                try {
                    ((C0016a) declaredConstructor.newInstance(new Object[0])).a(this.f2054a);
                } catch (Exception e2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to instantiate ");
                    sb.append(str);
                    throw new RuntimeException(sb.toString(), e2);
                }
            } catch (NoSuchMethodException e3) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Class");
                sb2.append(asSubclass.getSimpleName());
                sb2.append(" must have default constructor in order to be automatically recreated");
                throw new IllegalStateException(sb2.toString(), e3);
            }
        } catch (ClassNotFoundException e4) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Class ");
            sb3.append(str);
            sb3.append(" wasn't found");
            throw new RuntimeException(sb3.toString(), e4);
        }
    }
}
