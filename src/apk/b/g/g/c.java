package b.g.g;

import android.os.Build.VERSION;
import android.text.PrecomputedText.Params;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import java.util.concurrent.Executor;

/* compiled from: PrecomputedTextCompat */
public class c implements Spannable {

    /* renamed from: a reason: collision with root package name */
    private static final Object f2593a = new Object();

    /* renamed from: b reason: collision with root package name */
    private static Executor f2594b = null;

    /* renamed from: c reason: collision with root package name */
    private final Spannable f2595c;

    /* renamed from: d reason: collision with root package name */
    private final a f2596d;

    /* compiled from: PrecomputedTextCompat */
    public static final class a {

        /* renamed from: a reason: collision with root package name */
        private final TextPaint f2597a;

        /* renamed from: b reason: collision with root package name */
        private final TextDirectionHeuristic f2598b;

        /* renamed from: c reason: collision with root package name */
        private final int f2599c;

        /* renamed from: d reason: collision with root package name */
        private final int f2600d;

        /* renamed from: e reason: collision with root package name */
        final Params f2601e = null;

        /* renamed from: b.g.g.c$a$a reason: collision with other inner class name */
        /* compiled from: PrecomputedTextCompat */
        public static class C0025a {

            /* renamed from: a reason: collision with root package name */
            private final TextPaint f2602a;

            /* renamed from: b reason: collision with root package name */
            private TextDirectionHeuristic f2603b;

            /* renamed from: c reason: collision with root package name */
            private int f2604c;

            /* renamed from: d reason: collision with root package name */
            private int f2605d;

            public C0025a(TextPaint textPaint) {
                this.f2602a = textPaint;
                if (VERSION.SDK_INT >= 23) {
                    this.f2604c = 1;
                    this.f2605d = 1;
                } else {
                    this.f2605d = 0;
                    this.f2604c = 0;
                }
                if (VERSION.SDK_INT >= 18) {
                    this.f2603b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.f2603b = null;
                }
            }

            public C0025a a(int i2) {
                this.f2604c = i2;
                return this;
            }

            public C0025a b(int i2) {
                this.f2605d = i2;
                return this;
            }

            public C0025a a(TextDirectionHeuristic textDirectionHeuristic) {
                this.f2603b = textDirectionHeuristic;
                return this;
            }

            public a a() {
                return new a(this.f2602a, this.f2603b, this.f2604c, this.f2605d);
            }
        }

        a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i2, int i3) {
            this.f2597a = textPaint;
            this.f2598b = textDirectionHeuristic;
            this.f2599c = i2;
            this.f2600d = i3;
        }

        public int a() {
            return this.f2599c;
        }

        public int b() {
            return this.f2600d;
        }

        public TextDirectionHeuristic c() {
            return this.f2598b;
        }

        public TextPaint d() {
            return this.f2597a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!a(aVar)) {
                return false;
            }
            return VERSION.SDK_INT < 18 || this.f2598b == aVar.c();
        }

        public int hashCode() {
            int i2 = VERSION.SDK_INT;
            if (i2 >= 24) {
                return b.g.h.c.a(Float.valueOf(this.f2597a.getTextSize()), Float.valueOf(this.f2597a.getTextScaleX()), Float.valueOf(this.f2597a.getTextSkewX()), Float.valueOf(this.f2597a.getLetterSpacing()), Integer.valueOf(this.f2597a.getFlags()), this.f2597a.getTextLocales(), this.f2597a.getTypeface(), Boolean.valueOf(this.f2597a.isElegantTextHeight()), this.f2598b, Integer.valueOf(this.f2599c), Integer.valueOf(this.f2600d));
            } else if (i2 >= 21) {
                return b.g.h.c.a(Float.valueOf(this.f2597a.getTextSize()), Float.valueOf(this.f2597a.getTextScaleX()), Float.valueOf(this.f2597a.getTextSkewX()), Float.valueOf(this.f2597a.getLetterSpacing()), Integer.valueOf(this.f2597a.getFlags()), this.f2597a.getTextLocale(), this.f2597a.getTypeface(), Boolean.valueOf(this.f2597a.isElegantTextHeight()), this.f2598b, Integer.valueOf(this.f2599c), Integer.valueOf(this.f2600d));
            } else if (i2 >= 18) {
                return b.g.h.c.a(Float.valueOf(this.f2597a.getTextSize()), Float.valueOf(this.f2597a.getTextScaleX()), Float.valueOf(this.f2597a.getTextSkewX()), Integer.valueOf(this.f2597a.getFlags()), this.f2597a.getTextLocale(), this.f2597a.getTypeface(), this.f2598b, Integer.valueOf(this.f2599c), Integer.valueOf(this.f2600d));
            } else if (i2 >= 17) {
                return b.g.h.c.a(Float.valueOf(this.f2597a.getTextSize()), Float.valueOf(this.f2597a.getTextScaleX()), Float.valueOf(this.f2597a.getTextSkewX()), Integer.valueOf(this.f2597a.getFlags()), this.f2597a.getTextLocale(), this.f2597a.getTypeface(), this.f2598b, Integer.valueOf(this.f2599c), Integer.valueOf(this.f2600d));
            } else {
                return b.g.h.c.a(Float.valueOf(this.f2597a.getTextSize()), Float.valueOf(this.f2597a.getTextScaleX()), Float.valueOf(this.f2597a.getTextSkewX()), Integer.valueOf(this.f2597a.getFlags()), this.f2597a.getTypeface(), this.f2598b, Integer.valueOf(this.f2599c), Integer.valueOf(this.f2600d));
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("textSize=");
            sb2.append(this.f2597a.getTextSize());
            sb.append(sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(", textScaleX=");
            sb3.append(this.f2597a.getTextScaleX());
            sb.append(sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append(", textSkewX=");
            sb4.append(this.f2597a.getTextSkewX());
            sb.append(sb4.toString());
            if (VERSION.SDK_INT >= 21) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(", letterSpacing=");
                sb5.append(this.f2597a.getLetterSpacing());
                sb.append(sb5.toString());
                StringBuilder sb6 = new StringBuilder();
                sb6.append(", elegantTextHeight=");
                sb6.append(this.f2597a.isElegantTextHeight());
                sb.append(sb6.toString());
            }
            int i2 = VERSION.SDK_INT;
            String str = ", textLocale=";
            if (i2 >= 24) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append(str);
                sb7.append(this.f2597a.getTextLocales());
                sb.append(sb7.toString());
            } else if (i2 >= 17) {
                StringBuilder sb8 = new StringBuilder();
                sb8.append(str);
                sb8.append(this.f2597a.getTextLocale());
                sb.append(sb8.toString());
            }
            StringBuilder sb9 = new StringBuilder();
            sb9.append(", typeface=");
            sb9.append(this.f2597a.getTypeface());
            sb.append(sb9.toString());
            if (VERSION.SDK_INT >= 26) {
                StringBuilder sb10 = new StringBuilder();
                sb10.append(", variationSettings=");
                sb10.append(this.f2597a.getFontVariationSettings());
                sb.append(sb10.toString());
            }
            StringBuilder sb11 = new StringBuilder();
            sb11.append(", textDir=");
            sb11.append(this.f2598b);
            sb.append(sb11.toString());
            StringBuilder sb12 = new StringBuilder();
            sb12.append(", breakStrategy=");
            sb12.append(this.f2599c);
            sb.append(sb12.toString());
            StringBuilder sb13 = new StringBuilder();
            sb13.append(", hyphenationFrequency=");
            sb13.append(this.f2600d);
            sb.append(sb13.toString());
            sb.append("}");
            return sb.toString();
        }

        public boolean a(a aVar) {
            Params params = this.f2601e;
            if (params != null) {
                return params.equals(aVar.f2601e);
            }
            if ((VERSION.SDK_INT >= 23 && (this.f2599c != aVar.a() || this.f2600d != aVar.b())) || this.f2597a.getTextSize() != aVar.d().getTextSize() || this.f2597a.getTextScaleX() != aVar.d().getTextScaleX() || this.f2597a.getTextSkewX() != aVar.d().getTextSkewX()) {
                return false;
            }
            if ((VERSION.SDK_INT >= 21 && (this.f2597a.getLetterSpacing() != aVar.d().getLetterSpacing() || !TextUtils.equals(this.f2597a.getFontFeatureSettings(), aVar.d().getFontFeatureSettings()))) || this.f2597a.getFlags() != aVar.d().getFlags()) {
                return false;
            }
            int i2 = VERSION.SDK_INT;
            if (i2 >= 24) {
                if (!this.f2597a.getTextLocales().equals(aVar.d().getTextLocales())) {
                    return false;
                }
            } else if (i2 >= 17 && !this.f2597a.getTextLocale().equals(aVar.d().getTextLocale())) {
                return false;
            }
            if (this.f2597a.getTypeface() == null) {
                if (aVar.d().getTypeface() != null) {
                    return false;
                }
            } else if (!this.f2597a.getTypeface().equals(aVar.d().getTypeface())) {
                return false;
            }
            return true;
        }

        public a(Params params) {
            this.f2597a = params.getTextPaint();
            this.f2598b = params.getTextDirection();
            this.f2599c = params.getBreakStrategy();
            this.f2600d = params.getHyphenationFrequency();
        }
    }

    public a a() {
        return this.f2596d;
    }

    public char charAt(int i2) {
        return this.f2595c.charAt(i2);
    }

    public int getSpanEnd(Object obj) {
        return this.f2595c.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        return this.f2595c.getSpanFlags(obj);
    }

    public int getSpanStart(Object obj) {
        return this.f2595c.getSpanStart(obj);
    }

    public <T> T[] getSpans(int i2, int i3, Class<T> cls) {
        return this.f2595c.getSpans(i2, i3, cls);
    }

    public int length() {
        return this.f2595c.length();
    }

    public int nextSpanTransition(int i2, int i3, Class cls) {
        return this.f2595c.nextSpanTransition(i2, i3, cls);
    }

    public void removeSpan(Object obj) {
        if (!(obj instanceof MetricAffectingSpan)) {
            this.f2595c.removeSpan(obj);
            return;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    public void setSpan(Object obj, int i2, int i3, int i4) {
        if (!(obj instanceof MetricAffectingSpan)) {
            this.f2595c.setSpan(obj, i2, i3, i4);
            return;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    public CharSequence subSequence(int i2, int i3) {
        return this.f2595c.subSequence(i2, i3);
    }

    public String toString() {
        return this.f2595c.toString();
    }
}
