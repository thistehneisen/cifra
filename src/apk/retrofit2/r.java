package retrofit2;

import i.A;
import i.L;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ParameterHandler */
abstract class r<T> {

    /* compiled from: ParameterHandler */
    static final class a<T> extends r<T> {

        /* renamed from: a reason: collision with root package name */
        private final e<T, L> f11022a;

        a(e<T, L> eVar) {
            this.f11022a = eVar;
        }

        /* access modifiers changed from: 0000 */
        public void a(t tVar, T t) {
            if (t != null) {
                try {
                    tVar.a((L) this.f11022a.convert(t));
                } catch (IOException e2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unable to convert ");
                    sb.append(t);
                    sb.append(" to RequestBody");
                    throw new RuntimeException(sb.toString(), e2);
                }
            } else {
                throw new IllegalArgumentException("Body parameter value must not be null.");
            }
        }
    }

    /* compiled from: ParameterHandler */
    static final class b<T> extends r<T> {

        /* renamed from: a reason: collision with root package name */
        private final String f11023a;

        /* renamed from: b reason: collision with root package name */
        private final e<T, String> f11024b;

        /* renamed from: c reason: collision with root package name */
        private final boolean f11025c;

        b(String str, e<T, String> eVar, boolean z) {
            y.a(str, "name == null");
            this.f11023a = str;
            this.f11024b = eVar;
            this.f11025c = z;
        }

        /* access modifiers changed from: 0000 */
        public void a(t tVar, T t) throws IOException {
            if (t != null) {
                String str = (String) this.f11024b.convert(t);
                if (str != null) {
                    tVar.a(this.f11023a, str, this.f11025c);
                }
            }
        }
    }

    /* compiled from: ParameterHandler */
    static final class c<T> extends r<Map<String, T>> {

        /* renamed from: a reason: collision with root package name */
        private final e<T, String> f11026a;

        /* renamed from: b reason: collision with root package name */
        private final boolean f11027b;

        c(e<T, String> eVar, boolean z) {
            this.f11026a = eVar;
            this.f11027b = z;
        }

        /* access modifiers changed from: 0000 */
        public void a(t tVar, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str != null) {
                        Object value = entry.getValue();
                        String str2 = "'.";
                        if (value != null) {
                            String str3 = (String) this.f11026a.convert(value);
                            if (str3 != null) {
                                tVar.a(str, str3, this.f11027b);
                            } else {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Field map value '");
                                sb.append(value);
                                sb.append("' converted to null by ");
                                sb.append(this.f11026a.getClass().getName());
                                sb.append(" for key '");
                                sb.append(str);
                                sb.append(str2);
                                throw new IllegalArgumentException(sb.toString());
                            }
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Field map contained null value for key '");
                            sb2.append(str);
                            sb2.append(str2);
                            throw new IllegalArgumentException(sb2.toString());
                        }
                    } else {
                        throw new IllegalArgumentException("Field map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Field map was null.");
        }
    }

    /* compiled from: ParameterHandler */
    static final class d<T> extends r<T> {

        /* renamed from: a reason: collision with root package name */
        private final String f11028a;

        /* renamed from: b reason: collision with root package name */
        private final e<T, String> f11029b;

        d(String str, e<T, String> eVar) {
            y.a(str, "name == null");
            this.f11028a = str;
            this.f11029b = eVar;
        }

        /* access modifiers changed from: 0000 */
        public void a(t tVar, T t) throws IOException {
            if (t != null) {
                String str = (String) this.f11029b.convert(t);
                if (str != null) {
                    tVar.a(this.f11028a, str);
                }
            }
        }
    }

    /* compiled from: ParameterHandler */
    static final class e<T> extends r<T> {

        /* renamed from: a reason: collision with root package name */
        private final A f11030a;

        /* renamed from: b reason: collision with root package name */
        private final e<T, L> f11031b;

        e(A a2, e<T, L> eVar) {
            this.f11030a = a2;
            this.f11031b = eVar;
        }

        /* access modifiers changed from: 0000 */
        public void a(t tVar, T t) {
            if (t != null) {
                try {
                    tVar.a(this.f11030a, (L) this.f11031b.convert(t));
                } catch (IOException e2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unable to convert ");
                    sb.append(t);
                    sb.append(" to RequestBody");
                    throw new RuntimeException(sb.toString(), e2);
                }
            }
        }
    }

    /* compiled from: ParameterHandler */
    static final class f<T> extends r<Map<String, T>> {

        /* renamed from: a reason: collision with root package name */
        private final e<T, L> f11032a;

        /* renamed from: b reason: collision with root package name */
        private final String f11033b;

        f(e<T, L> eVar, String str) {
            this.f11032a = eVar;
            this.f11033b = str;
        }

        /* access modifiers changed from: 0000 */
        public void a(t tVar, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str != null) {
                        Object value = entry.getValue();
                        if (value != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("form-data; name=\"");
                            sb.append(str);
                            sb.append("\"");
                            tVar.a(A.a("Content-Disposition", sb.toString(), "Content-Transfer-Encoding", this.f11033b), (L) this.f11032a.convert(value));
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Part map contained null value for key '");
                            sb2.append(str);
                            sb2.append("'.");
                            throw new IllegalArgumentException(sb2.toString());
                        }
                    } else {
                        throw new IllegalArgumentException("Part map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Part map was null.");
        }
    }

    /* compiled from: ParameterHandler */
    static final class g<T> extends r<T> {

        /* renamed from: a reason: collision with root package name */
        private final String f11034a;

        /* renamed from: b reason: collision with root package name */
        private final e<T, String> f11035b;

        /* renamed from: c reason: collision with root package name */
        private final boolean f11036c;

        g(String str, e<T, String> eVar, boolean z) {
            y.a(str, "name == null");
            this.f11034a = str;
            this.f11035b = eVar;
            this.f11036c = z;
        }

        /* access modifiers changed from: 0000 */
        public void a(t tVar, T t) throws IOException {
            if (t != null) {
                tVar.b(this.f11034a, (String) this.f11035b.convert(t), this.f11036c);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Path parameter \"");
            sb.append(this.f11034a);
            sb.append("\" value must not be null.");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* compiled from: ParameterHandler */
    static final class h<T> extends r<T> {

        /* renamed from: a reason: collision with root package name */
        private final String f11037a;

        /* renamed from: b reason: collision with root package name */
        private final e<T, String> f11038b;

        /* renamed from: c reason: collision with root package name */
        private final boolean f11039c;

        h(String str, e<T, String> eVar, boolean z) {
            y.a(str, "name == null");
            this.f11037a = str;
            this.f11038b = eVar;
            this.f11039c = z;
        }

        /* access modifiers changed from: 0000 */
        public void a(t tVar, T t) throws IOException {
            if (t != null) {
                String str = (String) this.f11038b.convert(t);
                if (str != null) {
                    tVar.c(this.f11037a, str, this.f11039c);
                }
            }
        }
    }

    /* compiled from: ParameterHandler */
    static final class i<T> extends r<Map<String, T>> {

        /* renamed from: a reason: collision with root package name */
        private final e<T, String> f11040a;

        /* renamed from: b reason: collision with root package name */
        private final boolean f11041b;

        i(e<T, String> eVar, boolean z) {
            this.f11040a = eVar;
            this.f11041b = z;
        }

        /* access modifiers changed from: 0000 */
        public void a(t tVar, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str != null) {
                        Object value = entry.getValue();
                        String str2 = "'.";
                        if (value != null) {
                            String str3 = (String) this.f11040a.convert(value);
                            if (str3 != null) {
                                tVar.c(str, str3, this.f11041b);
                            } else {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Query map value '");
                                sb.append(value);
                                sb.append("' converted to null by ");
                                sb.append(this.f11040a.getClass().getName());
                                sb.append(" for key '");
                                sb.append(str);
                                sb.append(str2);
                                throw new IllegalArgumentException(sb.toString());
                            }
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Query map contained null value for key '");
                            sb2.append(str);
                            sb2.append(str2);
                            throw new IllegalArgumentException(sb2.toString());
                        }
                    } else {
                        throw new IllegalArgumentException("Query map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Query map was null.");
        }
    }

    /* compiled from: ParameterHandler */
    static final class j<T> extends r<T> {

        /* renamed from: a reason: collision with root package name */
        private final e<T, String> f11042a;

        /* renamed from: b reason: collision with root package name */
        private final boolean f11043b;

        j(e<T, String> eVar, boolean z) {
            this.f11042a = eVar;
            this.f11043b = z;
        }

        /* access modifiers changed from: 0000 */
        public void a(t tVar, T t) throws IOException {
            if (t != null) {
                tVar.c((String) this.f11042a.convert(t), null, this.f11043b);
            }
        }
    }

    /* compiled from: ParameterHandler */
    static final class k extends r<i.E.b> {

        /* renamed from: a reason: collision with root package name */
        static final k f11044a = new k();

        private k() {
        }

        /* access modifiers changed from: 0000 */
        public void a(t tVar, i.E.b bVar) {
            if (bVar != null) {
                tVar.a(bVar);
            }
        }
    }

    r() {
    }

    /* access modifiers changed from: 0000 */
    public final r<Object> a() {
        return new q(this);
    }

    /* access modifiers changed from: 0000 */
    public abstract void a(t tVar, T t) throws IOException;

    /* access modifiers changed from: 0000 */
    public final r<Iterable<T>> b() {
        return new p(this);
    }
}
