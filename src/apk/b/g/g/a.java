package b.g.g;

import android.text.SpannableStringBuilder;
import java.util.Locale;

/* compiled from: BidiFormatter */
public final class a {

    /* renamed from: a reason: collision with root package name */
    static final d f2574a = e.f2608c;

    /* renamed from: b reason: collision with root package name */
    private static final String f2575b = Character.toString(8206);

    /* renamed from: c reason: collision with root package name */
    private static final String f2576c = Character.toString(8207);

    /* renamed from: d reason: collision with root package name */
    static final a f2577d = new a(false, 2, f2574a);

    /* renamed from: e reason: collision with root package name */
    static final a f2578e = new a(true, 2, f2574a);

    /* renamed from: f reason: collision with root package name */
    private final boolean f2579f;

    /* renamed from: g reason: collision with root package name */
    private final int f2580g;

    /* renamed from: h reason: collision with root package name */
    private final d f2581h;

    /* renamed from: b.g.g.a$a reason: collision with other inner class name */
    /* compiled from: BidiFormatter */
    public static final class C0024a {

        /* renamed from: a reason: collision with root package name */
        private boolean f2582a;

        /* renamed from: b reason: collision with root package name */
        private int f2583b;

        /* renamed from: c reason: collision with root package name */
        private d f2584c;

        public C0024a() {
            b(a.a(Locale.getDefault()));
        }

        private static a a(boolean z) {
            return z ? a.f2578e : a.f2577d;
        }

        private void b(boolean z) {
            this.f2582a = z;
            this.f2584c = a.f2574a;
            this.f2583b = 2;
        }

        public a a() {
            if (this.f2583b == 2 && this.f2584c == a.f2574a) {
                return a(this.f2582a);
            }
            return new a(this.f2582a, this.f2583b, this.f2584c);
        }
    }

    /* compiled from: BidiFormatter */
    private static class b {

        /* renamed from: a reason: collision with root package name */
        private static final byte[] f2585a = new byte[1792];

        /* renamed from: b reason: collision with root package name */
        private final CharSequence f2586b;

        /* renamed from: c reason: collision with root package name */
        private final boolean f2587c;

        /* renamed from: d reason: collision with root package name */
        private final int f2588d;

        /* renamed from: e reason: collision with root package name */
        private int f2589e;

        /* renamed from: f reason: collision with root package name */
        private char f2590f;

        static {
            for (int i2 = 0; i2 < 1792; i2++) {
                f2585a[i2] = Character.getDirectionality(i2);
            }
        }

        b(CharSequence charSequence, boolean z) {
            this.f2586b = charSequence;
            this.f2587c = z;
            this.f2588d = charSequence.length();
        }

        private static byte a(char c2) {
            return c2 < 1792 ? f2585a[c2] : Character.getDirectionality(c2);
        }

        private byte e() {
            char c2;
            int i2 = this.f2589e;
            do {
                int i3 = this.f2589e;
                if (i3 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f2586b;
                int i4 = i3 - 1;
                this.f2589e = i4;
                this.f2590f = charSequence.charAt(i4);
                c2 = this.f2590f;
                if (c2 == '&') {
                    return 12;
                }
            } while (c2 != ';');
            this.f2589e = i2;
            this.f2590f = ';';
            return 13;
        }

        private byte f() {
            char charAt;
            do {
                int i2 = this.f2589e;
                if (i2 >= this.f2588d) {
                    break;
                }
                CharSequence charSequence = this.f2586b;
                this.f2589e = i2 + 1;
                charAt = charSequence.charAt(i2);
                this.f2590f = charAt;
            } while (charAt != ';');
            return 12;
        }

        private byte g() {
            char charAt;
            int i2 = this.f2589e;
            while (true) {
                int i3 = this.f2589e;
                if (i3 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f2586b;
                int i4 = i3 - 1;
                this.f2589e = i4;
                this.f2590f = charSequence.charAt(i4);
                char c2 = this.f2590f;
                if (c2 == '<') {
                    return 12;
                }
                if (c2 == '>') {
                    break;
                } else if (c2 == '\"' || c2 == '\'') {
                    char c3 = this.f2590f;
                    do {
                        int i5 = this.f2589e;
                        if (i5 <= 0) {
                            break;
                        }
                        CharSequence charSequence2 = this.f2586b;
                        int i6 = i5 - 1;
                        this.f2589e = i6;
                        charAt = charSequence2.charAt(i6);
                        this.f2590f = charAt;
                    } while (charAt != c3);
                }
            }
            this.f2589e = i2;
            this.f2590f = '>';
            return 13;
        }

        private byte h() {
            char charAt;
            int i2 = this.f2589e;
            while (true) {
                int i3 = this.f2589e;
                if (i3 < this.f2588d) {
                    CharSequence charSequence = this.f2586b;
                    this.f2589e = i3 + 1;
                    this.f2590f = charSequence.charAt(i3);
                    char c2 = this.f2590f;
                    if (c2 == '>') {
                        return 12;
                    }
                    if (c2 == '\"' || c2 == '\'') {
                        char c3 = this.f2590f;
                        do {
                            int i4 = this.f2589e;
                            if (i4 >= this.f2588d) {
                                break;
                            }
                            CharSequence charSequence2 = this.f2586b;
                            this.f2589e = i4 + 1;
                            charAt = charSequence2.charAt(i4);
                            this.f2590f = charAt;
                        } while (charAt != c3);
                    }
                } else {
                    this.f2589e = i2;
                    this.f2590f = '<';
                    return 13;
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public byte b() {
            this.f2590f = this.f2586b.charAt(this.f2589e);
            if (Character.isHighSurrogate(this.f2590f)) {
                int codePointAt = Character.codePointAt(this.f2586b, this.f2589e);
                this.f2589e += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f2589e++;
            byte a2 = a(this.f2590f);
            if (this.f2587c) {
                char c2 = this.f2590f;
                if (c2 == '<') {
                    a2 = h();
                } else if (c2 == '&') {
                    a2 = f();
                }
            }
            return a2;
        }

        /* access modifiers changed from: 0000 */
        public int c() {
            this.f2589e = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (this.f2589e < this.f2588d && i2 == 0) {
                byte b2 = b();
                if (b2 != 0) {
                    if (b2 == 1 || b2 == 2) {
                        if (i4 == 0) {
                            return 1;
                        }
                    } else if (b2 != 9) {
                        switch (b2) {
                            case 14:
                            case 15:
                                i4++;
                                i3 = -1;
                                continue;
                            case 16:
                            case 17:
                                i4++;
                                i3 = 1;
                                continue;
                            case 18:
                                i4--;
                                i3 = 0;
                                continue;
                        }
                    }
                } else if (i4 == 0) {
                    return -1;
                }
                i2 = i4;
            }
            if (i2 == 0) {
                return 0;
            }
            if (i3 != 0) {
                return i3;
            }
            while (this.f2589e > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i2 == i4) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i2 == i4) {
                            return 1;
                        }
                        break;
                    case 18:
                        i4++;
                        continue;
                }
                i4--;
            }
            return 0;
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
            r2 = r2 - 1;
         */
        public int d() {
            this.f2589e = this.f2588d;
            int i2 = 0;
            int i3 = 0;
            while (this.f2589e > 0) {
                byte a2 = a();
                if (a2 != 0) {
                    if (a2 == 1 || a2 == 2) {
                        if (i3 == 0) {
                            return 1;
                        }
                        if (i2 != 0) {
                        }
                    } else if (a2 != 9) {
                        switch (a2) {
                            case 14:
                            case 15:
                                if (i2 == i3) {
                                    return -1;
                                }
                                break;
                            case 16:
                            case 17:
                                if (i2 == i3) {
                                    return 1;
                                }
                                break;
                            case 18:
                                i3++;
                                break;
                            default:
                                if (i2 != 0) {
                                    break;
                                }
                                break;
                        }
                    } else {
                        continue;
                    }
                } else if (i3 == 0) {
                    return -1;
                } else {
                    if (i2 != 0) {
                    }
                }
                i2 = i3;
            }
            return 0;
        }

        /* access modifiers changed from: 0000 */
        public byte a() {
            this.f2590f = this.f2586b.charAt(this.f2589e - 1);
            if (Character.isLowSurrogate(this.f2590f)) {
                int codePointBefore = Character.codePointBefore(this.f2586b, this.f2589e);
                this.f2589e -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f2589e--;
            byte a2 = a(this.f2590f);
            if (this.f2587c) {
                char c2 = this.f2590f;
                if (c2 == '>') {
                    a2 = g();
                } else if (c2 == ';') {
                    a2 = e();
                }
            }
            return a2;
        }
    }

    a(boolean z, int i2, d dVar) {
        this.f2579f = z;
        this.f2580g = i2;
        this.f2581h = dVar;
    }

    public static a a() {
        return new C0024a().a();
    }

    private static int c(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    public boolean b() {
        return (this.f2580g & 2) != 0;
    }

    private String a(CharSequence charSequence, d dVar) {
        boolean isRtl = dVar.isRtl(charSequence, 0, charSequence.length());
        if (this.f2579f || (!isRtl && c(charSequence) != 1)) {
            return (!this.f2579f || (isRtl && c(charSequence) != -1)) ? "" : f2576c;
        }
        return f2575b;
    }

    private String b(CharSequence charSequence, d dVar) {
        boolean isRtl = dVar.isRtl(charSequence, 0, charSequence.length());
        if (this.f2579f || (!isRtl && b(charSequence) != 1)) {
            return (!this.f2579f || (isRtl && b(charSequence) != -1)) ? "" : f2576c;
        }
        return f2575b;
    }

    private static int b(CharSequence charSequence) {
        return new b(charSequence, false).c();
    }

    public CharSequence a(CharSequence charSequence, d dVar, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean isRtl = dVar.isRtl(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (b() && z) {
            spannableStringBuilder.append(b(charSequence, isRtl ? e.f2607b : e.f2606a));
        }
        if (isRtl != this.f2579f) {
            spannableStringBuilder.append(isRtl ? (char) 8235 : 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append(a(charSequence, isRtl ? e.f2607b : e.f2606a));
        }
        return spannableStringBuilder;
    }

    public CharSequence a(CharSequence charSequence) {
        return a(charSequence, this.f2581h, true);
    }

    static boolean a(Locale locale) {
        return f.a(locale) == 1;
    }
}
