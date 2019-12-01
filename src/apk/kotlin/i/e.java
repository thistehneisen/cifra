package kotlin.i;

import io.intercom.android.sdk.metrics.MetricTracker.Object;
import java.io.Serializable;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.e.b.h;

/* compiled from: Regex.kt */
public final class e implements Serializable {

    /* renamed from: a reason: collision with root package name */
    public static final a f10343a = new a(null);
    private Set<? extends Object> _options;
    private final Pattern nativePattern;

    /* compiled from: Regex.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    /* compiled from: Regex.kt */
    private static final class b implements Serializable {

        /* renamed from: a reason: collision with root package name */
        public static final a f10344a = new a(null);
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        /* compiled from: Regex.kt */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(e eVar) {
                this();
            }
        }

        public b(String str, int i2) {
            h.b(str, "pattern");
            this.pattern = str;
            this.flags = i2;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.pattern, this.flags);
            h.a((Object) compile, "Pattern.compile(pattern, flags)");
            return new e(compile);
        }
    }

    public e(Pattern pattern) {
        h.b(pattern, "nativePattern");
        this.nativePattern = pattern;
    }

    private final Object writeReplace() {
        String pattern = this.nativePattern.pattern();
        h.a((Object) pattern, "nativePattern.pattern()");
        return new b(pattern, this.nativePattern.flags());
    }

    public final String a(CharSequence charSequence, String str) {
        h.b(charSequence, Object.INPUT);
        h.b(str, "replacement");
        String replaceAll = this.nativePattern.matcher(charSequence).replaceAll(str);
        h.a((Object) replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    public String toString() {
        String pattern = this.nativePattern.toString();
        h.a((Object) pattern, "nativePattern.toString()");
        return pattern;
    }

    public e(String str) {
        h.b(str, "pattern");
        Pattern compile = Pattern.compile(str);
        h.a((Object) compile, "Pattern.compile(pattern)");
        this(compile);
    }
}
