package l.a.d.b.a;

import java.text.SimpleDateFormat;
import java.util.Locale;
import ru.touchin.roboswag.core.utils.ShouldNotHappenException;
import ru.touchin.roboswag.core.utils.c;

/* compiled from: LcGroup */
public class d {

    /* renamed from: a reason: collision with root package name */
    public static final d f10426a = new d("UI_METRICS");

    /* renamed from: b reason: collision with root package name */
    public static final d f10427b = new d("UI_LIFECYCLE");

    /* renamed from: c reason: collision with root package name */
    private static final c<SimpleDateFormat> f10428c = new c<>(a.f10421a);

    /* renamed from: d reason: collision with root package name */
    private final String f10429d;

    /* renamed from: e reason: collision with root package name */
    private boolean f10430e;

    public d(String str) {
        this.f10429d = str;
    }

    static /* synthetic */ SimpleDateFormat a() {
        return new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
    }

    private String b() {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[c.f10423b + 3];
        StringBuilder sb = new StringBuilder();
        sb.append(stackTraceElement.getFileName());
        sb.append(':');
        sb.append(stackTraceElement.getLineNumber());
        return sb.toString();
    }

    private String d(String str, Object... objArr) {
        try {
            if (objArr.length > 0) {
                if (str == null) {
                    throw new ShouldNotHappenException("Args are not empty but format message is null");
                }
            }
            if (str == null) {
                str = null;
            } else if (objArr.length > 0) {
                str = String.format(str, objArr);
            }
            return str;
        } catch (Throwable th) {
            c.a(th);
            return null;
        }
    }

    public void c(String str, Object... objArr) {
        a(e.WARN, str, null, objArr);
    }

    private void a(e eVar, String str, Throwable th, Object... objArr) {
        if (!this.f10430e && !eVar.a(c.a().a())) {
            if (th == null && objArr.length > 0 && (objArr[0] instanceof Throwable)) {
                c.b("Maybe you've misplaced exception with first format arg? format: %s; arg: %s", str, objArr[0]);
            }
            String d2 = d(str, objArr);
            if (eVar != e.ASSERT || !c.b()) {
                c.a().a(this, eVar, b(), b(d2), th);
                return;
            }
            throw a(d2, th);
        }
    }

    private String b(String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(((SimpleDateFormat) f10428c.get()).format(Long.valueOf(System.currentTimeMillis())));
        sb.append(' ');
        sb.append(Thread.currentThread().getName());
        sb.append(' ');
        sb.append(this.f10429d);
        if (str != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(' ');
            sb2.append(str);
            str2 = sb2.toString();
        } else {
            str2 = "";
        }
        sb.append(str2);
        return sb.toString();
    }

    public void b(String str, Object... objArr) {
        a(e.INFO, str, null, objArr);
    }

    public void b(Throwable th, String str, Object... objArr) {
        a(e.WARN, str, th, objArr);
    }

    private ShouldNotHappenException a(String str, Throwable th) {
        if (th == null) {
            return str != null ? new ShouldNotHappenException(str) : new ShouldNotHappenException();
        }
        if (str != null) {
            return new ShouldNotHappenException(str, th);
        }
        return th instanceof ShouldNotHappenException ? (ShouldNotHappenException) th : new ShouldNotHappenException(th);
    }

    public void a(String str, Object... objArr) {
        a(e.ERROR, str, null, objArr);
    }

    public void a(Throwable th, String str, Object... objArr) {
        a(e.ERROR, str, th, objArr);
    }

    public void a(String str) {
        a(e.ASSERT, "Assertion appears at %s with message: %s", null, c.a((Object) null, 2), str);
    }

    public void a(Throwable th) {
        a(e.ASSERT, "Assertion appears at %s", th, c.a((Object) null, 2));
    }
}
