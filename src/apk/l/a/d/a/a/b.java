package l.a.d.a.a;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import java.util.ArrayList;
import l.a.d.b.a.c;
import l.a.d.b.a.d;
import l.a.d.b.a.e;
import l.a.d.b.a.f;
import ru.touchin.roboswag.core.utils.ShouldNotHappenException;
import ru.touchin.templates.ApiModel;

/* compiled from: TouchinApp */
public abstract class b extends Application {

    /* compiled from: TouchinApp */
    private static class a extends f {

        /* renamed from: b reason: collision with root package name */
        private final Crashlytics f10402b;

        public a(Crashlytics crashlytics) {
            super(e.INFO);
            this.f10402b = crashlytics;
        }

        public void a(d dVar, e eVar, String str, String str2, Throwable th) {
            if (dVar == d.f10427b) {
                this.f10402b.core.log(eVar.getPriority(), str, str2);
            } else if (!eVar.a(e.ASSERT) || (dVar == ApiModel.f11174a && eVar == e.ERROR)) {
                Log.e(str, str2);
                if (th != null) {
                    this.f10402b.core.log(eVar.getPriority(), str, str2);
                    this.f10402b.core.logException(th);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(':');
                sb.append(str2);
                ShouldNotHappenException shouldNotHappenException = new ShouldNotHappenException(sb.toString());
                a(shouldNotHappenException);
                this.f10402b.core.logException(shouldNotHappenException);
            }
        }

        private void a(Throwable th) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            ArrayList arrayList = new ArrayList();
            for (int length = stackTrace.length - 1; length >= 0; length--) {
                StackTraceElement stackTraceElement = stackTrace[length];
                if (stackTraceElement.getClassName().contains(a.class.getSimpleName()) || stackTraceElement.getClassName().contains(d.class.getName()) || stackTraceElement.getClassName().contains(c.class.getName())) {
                    break;
                }
                arrayList.add(0, stackTraceElement);
            }
            th.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[arrayList.size()]));
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        b.m.a.a(context);
    }

    public void onCreate() {
        super.onCreate();
        h.a.a.a.a.a(this);
        try {
            Crashlytics crashlytics = new Crashlytics();
            io.fabric.sdk.android.f.a((Context) this, crashlytics);
            io.fabric.sdk.android.f.e().a(6);
            c.a((f) new a(crashlytics), false);
        } catch (NoClassDefFoundError e2) {
            c.a((f) new l.a.d.b.a.b(e.INFO), false);
            c.a("Crashlytics initialization error! Did you forget to add\ncompile('com.crashlytics.sdk.android:crashlytics:+@aar') {\n        transitive = true;\n}\nto your build.gradle?", e2);
        }
    }
}
