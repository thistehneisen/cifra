package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.f;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class GlideException extends Exception {

    /* renamed from: a reason: collision with root package name */
    private static final StackTraceElement[] f3867a = new StackTraceElement[0];
    private static final long serialVersionUID = 1;
    private final List<Throwable> causes;
    private Class<?> dataClass;
    private com.bumptech.glide.load.a dataSource;
    private String detailMessage;
    private Exception exception;
    private f key;

    private static final class a implements Appendable {

        /* renamed from: a reason: collision with root package name */
        private final Appendable f3868a;

        /* renamed from: b reason: collision with root package name */
        private boolean f3869b = true;

        a(Appendable appendable) {
            this.f3868a = appendable;
        }

        private CharSequence a(CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        public Appendable append(char c2) throws IOException {
            boolean z = false;
            if (this.f3869b) {
                this.f3869b = false;
                this.f3868a.append("  ");
            }
            if (c2 == 10) {
                z = true;
            }
            this.f3869b = z;
            this.f3868a.append(c2);
            return this;
        }

        public Appendable append(CharSequence charSequence) throws IOException {
            CharSequence a2 = a(charSequence);
            append(a2, 0, a2.length());
            return this;
        }

        public Appendable append(CharSequence charSequence, int i2, int i3) throws IOException {
            CharSequence a2 = a(charSequence);
            boolean z = false;
            if (this.f3869b) {
                this.f3869b = false;
                this.f3868a.append("  ");
            }
            if (a2.length() > 0 && a2.charAt(i3 - 1) == 10) {
                z = true;
            }
            this.f3869b = z;
            this.f3868a.append(a2, i2, i3);
            return this;
        }
    }

    public GlideException(String str) {
        this(str, Collections.emptyList());
    }

    /* access modifiers changed from: 0000 */
    public void a(f fVar, com.bumptech.glide.load.a aVar) {
        a(fVar, aVar, null);
    }

    public List<Throwable> b() {
        ArrayList arrayList = new ArrayList();
        a((Throwable) this, (List<Throwable>) arrayList);
        return arrayList;
    }

    public Throwable fillInStackTrace() {
        return this;
    }

    public String getMessage() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.detailMessage);
        String str3 = ", ";
        String str4 = "";
        if (this.dataClass != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(this.dataClass);
            str = sb2.toString();
        } else {
            str = str4;
        }
        sb.append(str);
        if (this.dataSource != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str3);
            sb3.append(this.dataSource);
            str2 = sb3.toString();
        } else {
            str2 = str4;
        }
        sb.append(str2);
        if (this.key != null) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str3);
            sb4.append(this.key);
            str4 = sb4.toString();
        }
        sb.append(str4);
        List<Throwable> b2 = b();
        if (b2.isEmpty()) {
            return sb.toString();
        }
        if (b2.size() == 1) {
            sb.append("\nThere was 1 cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(b2.size());
            sb.append(" causes:");
        }
        for (Throwable th : b2) {
            sb.append(10);
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public GlideException(String str, Throwable th) {
        this(str, Collections.singletonList(th));
    }

    /* access modifiers changed from: 0000 */
    public void a(f fVar, com.bumptech.glide.load.a aVar, Class<?> cls) {
        this.key = fVar;
        this.dataSource = aVar;
        this.dataClass = cls;
    }

    public void printStackTrace(PrintStream printStream) {
        a((Appendable) printStream);
    }

    public GlideException(String str, List<Throwable> list) {
        this.detailMessage = str;
        setStackTrace(f3867a);
        this.causes = list;
    }

    private static void b(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            appendable.append("Cause (").append(String.valueOf(i3)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = (Throwable) list.get(i2);
            if (th instanceof GlideException) {
                ((GlideException) th).a(appendable);
            } else {
                a(th, appendable);
            }
            i2 = i3;
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        a((Appendable) printWriter);
    }

    public void a(Exception exc) {
        this.exception = exc;
    }

    public List<Throwable> a() {
        return this.causes;
    }

    public void a(String str) {
        List b2 = b();
        int size = b2.size();
        int i2 = 0;
        while (i2 < size) {
            StringBuilder sb = new StringBuilder();
            sb.append("Root cause (");
            int i3 = i2 + 1;
            sb.append(i3);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            Log.i(str, sb.toString(), (Throwable) b2.get(i2));
            i2 = i3;
        }
    }

    private void a(Throwable th, List<Throwable> list) {
        if (th instanceof GlideException) {
            for (Throwable a2 : ((GlideException) th).a()) {
                a(a2, list);
            }
            return;
        }
        list.add(th);
    }

    private void a(Appendable appendable) {
        a((Throwable) this, appendable);
        a(a(), (Appendable) new a(appendable));
    }

    private static void a(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append(10);
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    private static void a(List<Throwable> list, Appendable appendable) {
        try {
            b(list, appendable);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }
}
