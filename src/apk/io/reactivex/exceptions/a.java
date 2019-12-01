package io.reactivex.exceptions;

import e.b.d.j.f;

/* compiled from: Exceptions */
public final class a {
    public static RuntimeException a(Throwable th) {
        throw f.a(th);
    }

    public static void b(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        } else if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        } else if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }
}
