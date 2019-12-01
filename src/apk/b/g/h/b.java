package b.g.h;

import android.util.Log;
import java.io.Writer;

/* compiled from: LogWriter */
public class b extends Writer {

    /* renamed from: a reason: collision with root package name */
    private final String f2619a;

    /* renamed from: b reason: collision with root package name */
    private StringBuilder f2620b = new StringBuilder(128);

    public b(String str) {
        this.f2619a = str;
    }

    private void a() {
        if (this.f2620b.length() > 0) {
            Log.d(this.f2619a, this.f2620b.toString());
            StringBuilder sb = this.f2620b;
            sb.delete(0, sb.length());
        }
    }

    public void close() {
        a();
    }

    public void flush() {
        a();
    }

    public void write(char[] cArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            char c2 = cArr[i2 + i4];
            if (c2 == 10) {
                a();
            } else {
                this.f2620b.append(c2);
            }
        }
    }
}
