package b.q.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import b.g.a.a.j;
import b.g.b.b.C0022b;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: VectorDrawableCompat */
public class k extends i {

    /* renamed from: b reason: collision with root package name */
    static final Mode f2974b = Mode.SRC_IN;

    /* renamed from: c reason: collision with root package name */
    private g f2975c;

    /* renamed from: d reason: collision with root package name */
    private PorterDuffColorFilter f2976d;

    /* renamed from: e reason: collision with root package name */
    private ColorFilter f2977e;

    /* renamed from: f reason: collision with root package name */
    private boolean f2978f;

    /* renamed from: g reason: collision with root package name */
    private boolean f2979g;

    /* renamed from: h reason: collision with root package name */
    private ConstantState f2980h;

    /* renamed from: i reason: collision with root package name */
    private final float[] f2981i;

    /* renamed from: j reason: collision with root package name */
    private final Matrix f2982j;

    /* renamed from: k reason: collision with root package name */
    private final Rect f2983k;

    /* compiled from: VectorDrawableCompat */
    private static class a extends e {
        public a() {
        }

        public void a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            if (j.a(xmlPullParser, "pathData")) {
                TypedArray a2 = j.a(resources, theme, attributeSet, a.f2947d);
                a(a2);
                a2.recycle();
            }
        }

        public boolean b() {
            return true;
        }

        public a(a aVar) {
            super(aVar);
        }

        private void a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f3006b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f3005a = b.g.b.b.a(string2);
            }
        }
    }

    /* compiled from: VectorDrawableCompat */
    private static class b extends e {

        /* renamed from: d reason: collision with root package name */
        private int[] f2984d;

        /* renamed from: e reason: collision with root package name */
        b.g.a.a.b f2985e;

        /* renamed from: f reason: collision with root package name */
        float f2986f = 0.0f;

        /* renamed from: g reason: collision with root package name */
        b.g.a.a.b f2987g;

        /* renamed from: h reason: collision with root package name */
        float f2988h = 1.0f;

        /* renamed from: i reason: collision with root package name */
        int f2989i = 0;

        /* renamed from: j reason: collision with root package name */
        float f2990j = 1.0f;

        /* renamed from: k reason: collision with root package name */
        float f2991k = 0.0f;

        /* renamed from: l reason: collision with root package name */
        float f2992l = 1.0f;
        float m = 0.0f;
        Cap n = Cap.BUTT;
        Join o = Join.MITER;
        float p = 4.0f;

        public b() {
        }

        private Cap a(int i2, Cap cap) {
            if (i2 == 0) {
                return Cap.BUTT;
            }
            if (i2 != 1) {
                return i2 != 2 ? cap : Cap.SQUARE;
            }
            return Cap.ROUND;
        }

        /* access modifiers changed from: 0000 */
        public float getFillAlpha() {
            return this.f2990j;
        }

        /* access modifiers changed from: 0000 */
        public int getFillColor() {
            return this.f2987g.a();
        }

        /* access modifiers changed from: 0000 */
        public float getStrokeAlpha() {
            return this.f2988h;
        }

        /* access modifiers changed from: 0000 */
        public int getStrokeColor() {
            return this.f2985e.a();
        }

        /* access modifiers changed from: 0000 */
        public float getStrokeWidth() {
            return this.f2986f;
        }

        /* access modifiers changed from: 0000 */
        public float getTrimPathEnd() {
            return this.f2992l;
        }

        /* access modifiers changed from: 0000 */
        public float getTrimPathOffset() {
            return this.m;
        }

        /* access modifiers changed from: 0000 */
        public float getTrimPathStart() {
            return this.f2991k;
        }

        /* access modifiers changed from: 0000 */
        public void setFillAlpha(float f2) {
            this.f2990j = f2;
        }

        /* access modifiers changed from: 0000 */
        public void setFillColor(int i2) {
            this.f2987g.b(i2);
        }

        /* access modifiers changed from: 0000 */
        public void setStrokeAlpha(float f2) {
            this.f2988h = f2;
        }

        /* access modifiers changed from: 0000 */
        public void setStrokeColor(int i2) {
            this.f2985e.b(i2);
        }

        /* access modifiers changed from: 0000 */
        public void setStrokeWidth(float f2) {
            this.f2986f = f2;
        }

        /* access modifiers changed from: 0000 */
        public void setTrimPathEnd(float f2) {
            this.f2992l = f2;
        }

        /* access modifiers changed from: 0000 */
        public void setTrimPathOffset(float f2) {
            this.m = f2;
        }

        /* access modifiers changed from: 0000 */
        public void setTrimPathStart(float f2) {
            this.f2991k = f2;
        }

        private Join a(int i2, Join join) {
            if (i2 == 0) {
                return Join.MITER;
            }
            if (i2 != 1) {
                return i2 != 2 ? join : Join.BEVEL;
            }
            return Join.ROUND;
        }

        public void a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a2 = j.a(resources, theme, attributeSet, a.f2946c);
            a(a2, xmlPullParser, theme);
            a2.recycle();
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser, Theme theme) {
            this.f2984d = null;
            if (j.a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f3006b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f3005a = b.g.b.b.a(string2);
                }
                Theme theme2 = theme;
                this.f2987g = j.a(typedArray, xmlPullParser, theme2, "fillColor", 1, 0);
                this.f2990j = j.a(typedArray, xmlPullParser, "fillAlpha", 12, this.f2990j);
                this.n = a(j.b(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.n);
                this.o = a(j.b(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.o);
                this.p = j.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.p);
                this.f2985e = j.a(typedArray, xmlPullParser, theme2, "strokeColor", 3, 0);
                this.f2988h = j.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.f2988h);
                this.f2986f = j.a(typedArray, xmlPullParser, "strokeWidth", 4, this.f2986f);
                this.f2992l = j.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.f2992l);
                this.m = j.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.m);
                this.f2991k = j.a(typedArray, xmlPullParser, "trimPathStart", 5, this.f2991k);
                this.f2989i = j.b(typedArray, xmlPullParser, "fillType", 13, this.f2989i);
            }
        }

        public b(b bVar) {
            super(bVar);
            this.f2984d = bVar.f2984d;
            this.f2985e = bVar.f2985e;
            this.f2986f = bVar.f2986f;
            this.f2988h = bVar.f2988h;
            this.f2987g = bVar.f2987g;
            this.f2989i = bVar.f2989i;
            this.f2990j = bVar.f2990j;
            this.f2991k = bVar.f2991k;
            this.f2992l = bVar.f2992l;
            this.m = bVar.m;
            this.n = bVar.n;
            this.o = bVar.o;
            this.p = bVar.p;
        }

        public boolean a() {
            return this.f2987g.d() || this.f2985e.d();
        }

        public boolean a(int[] iArr) {
            return this.f2985e.a(iArr) | this.f2987g.a(iArr);
        }
    }

    /* compiled from: VectorDrawableCompat */
    private static class c extends d {

        /* renamed from: a reason: collision with root package name */
        final Matrix f2993a = new Matrix();

        /* renamed from: b reason: collision with root package name */
        final ArrayList<d> f2994b = new ArrayList<>();

        /* renamed from: c reason: collision with root package name */
        float f2995c = 0.0f;

        /* renamed from: d reason: collision with root package name */
        private float f2996d = 0.0f;

        /* renamed from: e reason: collision with root package name */
        private float f2997e = 0.0f;

        /* renamed from: f reason: collision with root package name */
        private float f2998f = 1.0f;

        /* renamed from: g reason: collision with root package name */
        private float f2999g = 1.0f;

        /* renamed from: h reason: collision with root package name */
        private float f3000h = 0.0f;

        /* renamed from: i reason: collision with root package name */
        private float f3001i = 0.0f;

        /* renamed from: j reason: collision with root package name */
        final Matrix f3002j = new Matrix();

        /* renamed from: k reason: collision with root package name */
        int f3003k;

        /* renamed from: l reason: collision with root package name */
        private int[] f3004l;
        private String m = null;

        public c(c cVar, b.d.b<String, Object> bVar) {
            e eVar;
            super();
            this.f2995c = cVar.f2995c;
            this.f2996d = cVar.f2996d;
            this.f2997e = cVar.f2997e;
            this.f2998f = cVar.f2998f;
            this.f2999g = cVar.f2999g;
            this.f3000h = cVar.f3000h;
            this.f3001i = cVar.f3001i;
            this.f3004l = cVar.f3004l;
            this.m = cVar.m;
            this.f3003k = cVar.f3003k;
            String str = this.m;
            if (str != null) {
                bVar.put(str, this);
            }
            this.f3002j.set(cVar.f3002j);
            ArrayList<d> arrayList = cVar.f2994b;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                Object obj = arrayList.get(i2);
                if (obj instanceof c) {
                    this.f2994b.add(new c((c) obj, bVar));
                } else {
                    if (obj instanceof b) {
                        eVar = new b((b) obj);
                    } else if (obj instanceof a) {
                        eVar = new a((a) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f2994b.add(eVar);
                    String str2 = eVar.f3006b;
                    if (str2 != null) {
                        bVar.put(str2, eVar);
                    }
                }
            }
        }

        private void b() {
            this.f3002j.reset();
            this.f3002j.postTranslate(-this.f2996d, -this.f2997e);
            this.f3002j.postScale(this.f2998f, this.f2999g);
            this.f3002j.postRotate(this.f2995c, 0.0f, 0.0f);
            this.f3002j.postTranslate(this.f3000h + this.f2996d, this.f3001i + this.f2997e);
        }

        public void a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a2 = j.a(resources, theme, attributeSet, a.f2945b);
            a(a2, xmlPullParser);
            a2.recycle();
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.f3002j;
        }

        public float getPivotX() {
            return this.f2996d;
        }

        public float getPivotY() {
            return this.f2997e;
        }

        public float getRotation() {
            return this.f2995c;
        }

        public float getScaleX() {
            return this.f2998f;
        }

        public float getScaleY() {
            return this.f2999g;
        }

        public float getTranslateX() {
            return this.f3000h;
        }

        public float getTranslateY() {
            return this.f3001i;
        }

        public void setPivotX(float f2) {
            if (f2 != this.f2996d) {
                this.f2996d = f2;
                b();
            }
        }

        public void setPivotY(float f2) {
            if (f2 != this.f2997e) {
                this.f2997e = f2;
                b();
            }
        }

        public void setRotation(float f2) {
            if (f2 != this.f2995c) {
                this.f2995c = f2;
                b();
            }
        }

        public void setScaleX(float f2) {
            if (f2 != this.f2998f) {
                this.f2998f = f2;
                b();
            }
        }

        public void setScaleY(float f2) {
            if (f2 != this.f2999g) {
                this.f2999g = f2;
                b();
            }
        }

        public void setTranslateX(float f2) {
            if (f2 != this.f3000h) {
                this.f3000h = f2;
                b();
            }
        }

        public void setTranslateY(float f2) {
            if (f2 != this.f3001i) {
                this.f3001i = f2;
                b();
            }
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f3004l = null;
            this.f2995c = j.a(typedArray, xmlPullParser, "rotation", 5, this.f2995c);
            this.f2996d = typedArray.getFloat(1, this.f2996d);
            this.f2997e = typedArray.getFloat(2, this.f2997e);
            this.f2998f = j.a(typedArray, xmlPullParser, "scaleX", 3, this.f2998f);
            this.f2999g = j.a(typedArray, xmlPullParser, "scaleY", 4, this.f2999g);
            this.f3000h = j.a(typedArray, xmlPullParser, "translateX", 6, this.f3000h);
            this.f3001i = j.a(typedArray, xmlPullParser, "translateY", 7, this.f3001i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            b();
        }

        public boolean a() {
            for (int i2 = 0; i2 < this.f2994b.size(); i2++) {
                if (((d) this.f2994b.get(i2)).a()) {
                    return true;
                }
            }
            return false;
        }

        public boolean a(int[] iArr) {
            boolean z = false;
            for (int i2 = 0; i2 < this.f2994b.size(); i2++) {
                z |= ((d) this.f2994b.get(i2)).a(iArr);
            }
            return z;
        }

        public c() {
            super();
        }
    }

    /* compiled from: VectorDrawableCompat */
    private static abstract class d {
        private d() {
        }

        public boolean a() {
            return false;
        }

        public boolean a(int[] iArr) {
            return false;
        }
    }

    /* compiled from: VectorDrawableCompat */
    private static abstract class e extends d {

        /* renamed from: a reason: collision with root package name */
        protected C0022b[] f3005a = null;

        /* renamed from: b reason: collision with root package name */
        String f3006b;

        /* renamed from: c reason: collision with root package name */
        int f3007c;

        public e() {
            super();
        }

        public void a(Path path) {
            path.reset();
            C0022b[] bVarArr = this.f3005a;
            if (bVarArr != null) {
                C0022b.a(bVarArr, path);
            }
        }

        public boolean b() {
            return false;
        }

        public C0022b[] getPathData() {
            return this.f3005a;
        }

        public String getPathName() {
            return this.f3006b;
        }

        public void setPathData(C0022b[] bVarArr) {
            if (!b.g.b.b.a(this.f3005a, bVarArr)) {
                this.f3005a = b.g.b.b.a(bVarArr);
            } else {
                b.g.b.b.b(this.f3005a, bVarArr);
            }
        }

        public e(e eVar) {
            super();
            this.f3006b = eVar.f3006b;
            this.f3007c = eVar.f3007c;
            this.f3005a = b.g.b.b.a(eVar.f3005a);
        }
    }

    /* compiled from: VectorDrawableCompat */
    private static class f {

        /* renamed from: a reason: collision with root package name */
        private static final Matrix f3008a = new Matrix();

        /* renamed from: b reason: collision with root package name */
        private final Path f3009b;

        /* renamed from: c reason: collision with root package name */
        private final Path f3010c;

        /* renamed from: d reason: collision with root package name */
        private final Matrix f3011d;

        /* renamed from: e reason: collision with root package name */
        Paint f3012e;

        /* renamed from: f reason: collision with root package name */
        Paint f3013f;

        /* renamed from: g reason: collision with root package name */
        private PathMeasure f3014g;

        /* renamed from: h reason: collision with root package name */
        private int f3015h;

        /* renamed from: i reason: collision with root package name */
        final c f3016i;

        /* renamed from: j reason: collision with root package name */
        float f3017j;

        /* renamed from: k reason: collision with root package name */
        float f3018k;

        /* renamed from: l reason: collision with root package name */
        float f3019l;
        float m;
        int n;
        String o;
        Boolean p;
        final b.d.b<String, Object> q;

        public f() {
            this.f3011d = new Matrix();
            this.f3017j = 0.0f;
            this.f3018k = 0.0f;
            this.f3019l = 0.0f;
            this.m = 0.0f;
            this.n = 255;
            this.o = null;
            this.p = null;
            this.q = new b.d.b<>();
            this.f3016i = new c();
            this.f3009b = new Path();
            this.f3010c = new Path();
        }

        private static float a(float f2, float f3, float f4, float f5) {
            return (f2 * f5) - (f3 * f4);
        }

        private void a(c cVar, Matrix matrix, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            cVar.f2993a.set(matrix);
            cVar.f2993a.preConcat(cVar.f3002j);
            canvas.save();
            for (int i4 = 0; i4 < cVar.f2994b.size(); i4++) {
                d dVar = (d) cVar.f2994b.get(i4);
                if (dVar instanceof c) {
                    a((c) dVar, cVar.f2993a, canvas, i2, i3, colorFilter);
                } else if (dVar instanceof e) {
                    a(cVar, (e) dVar, canvas, i2, i3, colorFilter);
                }
            }
            canvas.restore();
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public int getRootAlpha() {
            return this.n;
        }

        public void setAlpha(float f2) {
            setRootAlpha((int) (f2 * 255.0f));
        }

        public void setRootAlpha(int i2) {
            this.n = i2;
        }

        public void a(Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            a(this.f3016i, f3008a, canvas, i2, i3, colorFilter);
        }

        public f(f fVar) {
            this.f3011d = new Matrix();
            this.f3017j = 0.0f;
            this.f3018k = 0.0f;
            this.f3019l = 0.0f;
            this.m = 0.0f;
            this.n = 255;
            this.o = null;
            this.p = null;
            this.q = new b.d.b<>();
            this.f3016i = new c(fVar.f3016i, this.q);
            this.f3009b = new Path(fVar.f3009b);
            this.f3010c = new Path(fVar.f3010c);
            this.f3017j = fVar.f3017j;
            this.f3018k = fVar.f3018k;
            this.f3019l = fVar.f3019l;
            this.m = fVar.m;
            this.f3015h = fVar.f3015h;
            this.n = fVar.n;
            this.o = fVar.o;
            String str = fVar.o;
            if (str != null) {
                this.q.put(str, this);
            }
            this.p = fVar.p;
        }

        private void a(c cVar, e eVar, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            float f2 = ((float) i2) / this.f3019l;
            float f3 = ((float) i3) / this.m;
            float min = Math.min(f2, f3);
            Matrix matrix = cVar.f2993a;
            this.f3011d.set(matrix);
            this.f3011d.postScale(f2, f3);
            float a2 = a(matrix);
            if (a2 != 0.0f) {
                eVar.a(this.f3009b);
                Path path = this.f3009b;
                this.f3010c.reset();
                if (eVar.b()) {
                    this.f3010c.addPath(path, this.f3011d);
                    canvas.clipPath(this.f3010c);
                } else {
                    b bVar = (b) eVar;
                    if (!(bVar.f2991k == 0.0f && bVar.f2992l == 1.0f)) {
                        float f4 = bVar.f2991k;
                        float f5 = bVar.m;
                        float f6 = (f4 + f5) % 1.0f;
                        float f7 = (bVar.f2992l + f5) % 1.0f;
                        if (this.f3014g == null) {
                            this.f3014g = new PathMeasure();
                        }
                        this.f3014g.setPath(this.f3009b, false);
                        float length = this.f3014g.getLength();
                        float f8 = f6 * length;
                        float f9 = f7 * length;
                        path.reset();
                        if (f8 > f9) {
                            this.f3014g.getSegment(f8, length, path, true);
                            this.f3014g.getSegment(0.0f, f9, path, true);
                        } else {
                            this.f3014g.getSegment(f8, f9, path, true);
                        }
                        path.rLineTo(0.0f, 0.0f);
                    }
                    this.f3010c.addPath(path, this.f3011d);
                    if (bVar.f2987g.e()) {
                        b.g.a.a.b bVar2 = bVar.f2987g;
                        if (this.f3013f == null) {
                            this.f3013f = new Paint(1);
                            this.f3013f.setStyle(Style.FILL);
                        }
                        Paint paint = this.f3013f;
                        if (bVar2.c()) {
                            Shader b2 = bVar2.b();
                            b2.setLocalMatrix(this.f3011d);
                            paint.setShader(b2);
                            paint.setAlpha(Math.round(bVar.f2990j * 255.0f));
                        } else {
                            paint.setShader(null);
                            paint.setAlpha(255);
                            paint.setColor(k.a(bVar2.a(), bVar.f2990j));
                        }
                        paint.setColorFilter(colorFilter);
                        this.f3010c.setFillType(bVar.f2989i == 0 ? FillType.WINDING : FillType.EVEN_ODD);
                        canvas.drawPath(this.f3010c, paint);
                    }
                    if (bVar.f2985e.e()) {
                        b.g.a.a.b bVar3 = bVar.f2985e;
                        if (this.f3012e == null) {
                            this.f3012e = new Paint(1);
                            this.f3012e.setStyle(Style.STROKE);
                        }
                        Paint paint2 = this.f3012e;
                        Join join = bVar.o;
                        if (join != null) {
                            paint2.setStrokeJoin(join);
                        }
                        Cap cap = bVar.n;
                        if (cap != null) {
                            paint2.setStrokeCap(cap);
                        }
                        paint2.setStrokeMiter(bVar.p);
                        if (bVar3.c()) {
                            Shader b3 = bVar3.b();
                            b3.setLocalMatrix(this.f3011d);
                            paint2.setShader(b3);
                            paint2.setAlpha(Math.round(bVar.f2988h * 255.0f));
                        } else {
                            paint2.setShader(null);
                            paint2.setAlpha(255);
                            paint2.setColor(k.a(bVar3.a(), bVar.f2988h));
                        }
                        paint2.setColorFilter(colorFilter);
                        paint2.setStrokeWidth(bVar.f2986f * min * a2);
                        canvas.drawPath(this.f3010c, paint2);
                    }
                }
            }
        }

        private float a(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot((double) fArr[0], (double) fArr[1]);
            float hypot2 = (float) Math.hypot((double) fArr[2], (double) fArr[3]);
            float a2 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max(hypot, hypot2);
            if (max > 0.0f) {
                return Math.abs(a2) / max;
            }
            return 0.0f;
        }

        public boolean a() {
            if (this.p == null) {
                this.p = Boolean.valueOf(this.f3016i.a());
            }
            return this.p.booleanValue();
        }

        public boolean a(int[] iArr) {
            return this.f3016i.a(iArr);
        }
    }

    /* compiled from: VectorDrawableCompat */
    private static class g extends ConstantState {

        /* renamed from: a reason: collision with root package name */
        int f3020a;

        /* renamed from: b reason: collision with root package name */
        f f3021b;

        /* renamed from: c reason: collision with root package name */
        ColorStateList f3022c;

        /* renamed from: d reason: collision with root package name */
        Mode f3023d;

        /* renamed from: e reason: collision with root package name */
        boolean f3024e;

        /* renamed from: f reason: collision with root package name */
        Bitmap f3025f;

        /* renamed from: g reason: collision with root package name */
        ColorStateList f3026g;

        /* renamed from: h reason: collision with root package name */
        Mode f3027h;

        /* renamed from: i reason: collision with root package name */
        int f3028i;

        /* renamed from: j reason: collision with root package name */
        boolean f3029j;

        /* renamed from: k reason: collision with root package name */
        boolean f3030k;

        /* renamed from: l reason: collision with root package name */
        Paint f3031l;

        public g(g gVar) {
            this.f3022c = null;
            this.f3023d = k.f2974b;
            if (gVar != null) {
                this.f3020a = gVar.f3020a;
                this.f3021b = new f(gVar.f3021b);
                Paint paint = gVar.f3021b.f3013f;
                if (paint != null) {
                    this.f3021b.f3013f = new Paint(paint);
                }
                Paint paint2 = gVar.f3021b.f3012e;
                if (paint2 != null) {
                    this.f3021b.f3012e = new Paint(paint2);
                }
                this.f3022c = gVar.f3022c;
                this.f3023d = gVar.f3023d;
                this.f3024e = gVar.f3024e;
            }
        }

        public void a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f3025f, null, rect, a(colorFilter));
        }

        public boolean b() {
            return this.f3021b.getRootAlpha() < 255;
        }

        public void c(int i2, int i3) {
            this.f3025f.eraseColor(0);
            this.f3021b.a(new Canvas(this.f3025f), i2, i3, (ColorFilter) null);
        }

        public void d() {
            this.f3026g = this.f3022c;
            this.f3027h = this.f3023d;
            this.f3028i = this.f3021b.getRootAlpha();
            this.f3029j = this.f3024e;
            this.f3030k = false;
        }

        public int getChangingConfigurations() {
            return this.f3020a;
        }

        public Drawable newDrawable() {
            return new k(this);
        }

        public void b(int i2, int i3) {
            if (this.f3025f == null || !a(i2, i3)) {
                this.f3025f = Bitmap.createBitmap(i2, i3, Config.ARGB_8888);
                this.f3030k = true;
            }
        }

        public Drawable newDrawable(Resources resources) {
            return new k(this);
        }

        public Paint a(ColorFilter colorFilter) {
            if (!b() && colorFilter == null) {
                return null;
            }
            if (this.f3031l == null) {
                this.f3031l = new Paint();
                this.f3031l.setFilterBitmap(true);
            }
            this.f3031l.setAlpha(this.f3021b.getRootAlpha());
            this.f3031l.setColorFilter(colorFilter);
            return this.f3031l;
        }

        public boolean c() {
            return this.f3021b.a();
        }

        public boolean a(int i2, int i3) {
            return i2 == this.f3025f.getWidth() && i3 == this.f3025f.getHeight();
        }

        public boolean a() {
            return !this.f3030k && this.f3026g == this.f3022c && this.f3027h == this.f3023d && this.f3029j == this.f3024e && this.f3028i == this.f3021b.getRootAlpha();
        }

        public g() {
            this.f3022c = null;
            this.f3023d = k.f2974b;
            this.f3021b = new f();
        }

        public boolean a(int[] iArr) {
            boolean a2 = this.f3021b.a(iArr);
            this.f3030k |= a2;
            return a2;
        }
    }

    /* compiled from: VectorDrawableCompat */
    private static class h extends ConstantState {

        /* renamed from: a reason: collision with root package name */
        private final ConstantState f3032a;

        public h(ConstantState constantState) {
            this.f3032a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f3032a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f3032a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            k kVar = new k();
            kVar.f2973a = (VectorDrawable) this.f3032a.newDrawable();
            return kVar;
        }

        public Drawable newDrawable(Resources resources) {
            k kVar = new k();
            kVar.f2973a = (VectorDrawable) this.f3032a.newDrawable(resources);
            return kVar;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            k kVar = new k();
            kVar.f2973a = (VectorDrawable) this.f3032a.newDrawable(resources, theme);
            return kVar;
        }
    }

    k() {
        this.f2979g = true;
        this.f2981i = new float[9];
        this.f2982j = new Matrix();
        this.f2983k = new Rect();
        this.f2975c = new g();
    }

    public static k createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        k kVar = new k();
        kVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return kVar;
    }

    /* access modifiers changed from: 0000 */
    public Object a(String str) {
        return this.f2975c.f3021b.q.get(str);
    }

    public /* bridge */ /* synthetic */ void applyTheme(Theme theme) {
        super.applyTheme(theme);
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable);
        }
        return false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f2983k);
        if (this.f2983k.width() > 0 && this.f2983k.height() > 0) {
            ColorFilter colorFilter = this.f2977e;
            if (colorFilter == null) {
                colorFilter = this.f2976d;
            }
            canvas.getMatrix(this.f2982j);
            this.f2982j.getValues(this.f2981i);
            float abs = Math.abs(this.f2981i[0]);
            float abs2 = Math.abs(this.f2981i[4]);
            float abs3 = Math.abs(this.f2981i[1]);
            float abs4 = Math.abs(this.f2981i[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int height = (int) (((float) this.f2983k.height()) * abs2);
            int min = Math.min(2048, (int) (((float) this.f2983k.width()) * abs));
            int min2 = Math.min(2048, height);
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                Rect rect = this.f2983k;
                canvas.translate((float) rect.left, (float) rect.top);
                if (a()) {
                    canvas.translate((float) this.f2983k.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f2983k.offsetTo(0, 0);
                this.f2975c.b(min, min2);
                if (!this.f2979g) {
                    this.f2975c.c(min, min2);
                } else if (!this.f2975c.a()) {
                    this.f2975c.c(min, min2);
                    this.f2975c.d();
                }
                this.f2975c.a(canvas, colorFilter, this.f2983k);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.c(drawable);
        }
        return this.f2975c.f3021b.getRootAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f2975c.getChangingConfigurations();
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public ConstantState getConstantState() {
        Drawable drawable = this.f2973a;
        if (drawable != null && VERSION.SDK_INT >= 24) {
            return new h(drawable.getConstantState());
        }
        this.f2975c.f3020a = getChangingConfigurations();
        return this.f2975c;
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.f2975c.f3021b.f3018k;
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.f2975c.f3021b.f3017j;
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public void invalidateSelf() {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.f(drawable);
        }
        return this.f2975c.f3024e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        if (r0.isStateful() != false) goto L_0x0028;
     */
    public boolean isStateful() {
        boolean z;
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (!super.isStateful()) {
            g gVar = this.f2975c;
            if (gVar != null) {
                if (!gVar.c()) {
                    ColorStateList colorStateList = this.f2975c.f3022c;
                    if (colorStateList != null) {
                    }
                }
            }
            z = false;
            return z;
        }
        z = true;
        return z;
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f2978f && super.mutate() == this) {
            this.f2975c = new g(this.f2975c);
            this.f2978f = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        g gVar = this.f2975c;
        ColorStateList colorStateList = gVar.f3022c;
        if (colorStateList != null) {
            Mode mode = gVar.f3023d;
            if (mode != null) {
                this.f2976d = a(this.f2976d, colorStateList, mode);
                invalidateSelf();
                z = true;
            }
        }
        if (gVar.c() && gVar.a(iArr)) {
            invalidateSelf();
            z = true;
        }
        return z;
    }

    public void scheduleSelf(Runnable runnable, long j2) {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j2);
        } else {
            super.scheduleSelf(runnable, j2);
        }
    }

    public void setAlpha(int i2) {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            drawable.setAlpha(i2);
            return;
        }
        if (this.f2975c.f3021b.getRootAlpha() != i2) {
            this.f2975c.f3021b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, z);
        } else {
            this.f2975c.f3024e = z;
        }
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i2) {
        super.setChangingConfigurations(i2);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i2, Mode mode) {
        super.setColorFilter(i2, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i2, int i3, int i4, int i5) {
        super.setHotspotBounds(i2, i3, i4, i5);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i2) {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.b(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, colorStateList);
            return;
        }
        g gVar = this.f2975c;
        if (gVar.f3022c != colorStateList) {
            gVar.f3022c = colorStateList;
            this.f2976d = a(this.f2976d, colorStateList, gVar.f3023d);
            invalidateSelf();
        }
    }

    public void setTintMode(Mode mode) {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, mode);
            return;
        }
        g gVar = this.f2975c;
        if (gVar.f3023d != mode) {
            gVar.f3023d = mode;
            this.f2976d = a(this.f2976d, gVar.f3022c, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* access modifiers changed from: 0000 */
    public PorterDuffColorFilter a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f2977e = colorFilter;
        invalidateSelf();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038 A[Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d A[Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }] */
    public static k a(Resources resources, int i2, Theme theme) {
        int next;
        String str = "parser error";
        String str2 = "VectorDrawableCompat";
        if (VERSION.SDK_INT >= 24) {
            k kVar = new k();
            kVar.f2973a = b.g.a.a.h.a(resources, i2, theme);
            kVar.f2980h = new h(kVar.f2973a.getConstantState());
            return kVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i2);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            while (true) {
                next = xml.next();
                if (next == 2 || next == 1) {
                    if (next != 2) {
                        return createFromXmlInner(resources, xml, asAttributeSet, theme);
                    }
                    throw new XmlPullParserException("No start tag found");
                }
            }
            if (next != 2) {
            }
        } catch (XmlPullParserException e2) {
            Log.e(str2, str, e2);
            return null;
        } catch (IOException e3) {
            Log.e(str2, str, e3);
            return null;
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f2973a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        g gVar = this.f2975c;
        gVar.f3021b = new f();
        TypedArray a2 = j.a(resources, theme, attributeSet, a.f2944a);
        a(a2, xmlPullParser);
        a2.recycle();
        gVar.f3020a = getChangingConfigurations();
        gVar.f3030k = true;
        a(resources, xmlPullParser, attributeSet, theme);
        this.f2976d = a(this.f2976d, gVar.f3022c, gVar.f3023d);
    }

    k(g gVar) {
        this.f2979g = true;
        this.f2981i = new float[9];
        this.f2982j = new Matrix();
        this.f2983k = new Rect();
        this.f2975c = gVar;
        this.f2976d = a(this.f2976d, gVar.f3022c, gVar.f3023d);
    }

    static int a(int i2, float f2) {
        return (i2 & 16777215) | (((int) (((float) Color.alpha(i2)) * f2)) << 24);
    }

    private static Mode a(int i2, Mode mode) {
        if (i2 == 3) {
            return Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return Mode.SRC_IN;
        }
        if (i2 == 9) {
            return Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                return Mode.ADD;
            default:
                return mode;
        }
    }

    private void a(TypedArray typedArray, XmlPullParser xmlPullParser) throws XmlPullParserException {
        g gVar = this.f2975c;
        f fVar = gVar.f3021b;
        gVar.f3023d = a(j.b(typedArray, xmlPullParser, "tintMode", 6, -1), Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            gVar.f3022c = colorStateList;
        }
        gVar.f3024e = j.a(typedArray, xmlPullParser, "autoMirrored", 5, gVar.f3024e);
        fVar.f3019l = j.a(typedArray, xmlPullParser, "viewportWidth", 7, fVar.f3019l);
        fVar.m = j.a(typedArray, xmlPullParser, "viewportHeight", 8, fVar.m);
        if (fVar.f3019l <= 0.0f) {
            StringBuilder sb = new StringBuilder();
            sb.append(typedArray.getPositionDescription());
            sb.append("<vector> tag requires viewportWidth > 0");
            throw new XmlPullParserException(sb.toString());
        } else if (fVar.m > 0.0f) {
            fVar.f3017j = typedArray.getDimension(3, fVar.f3017j);
            fVar.f3018k = typedArray.getDimension(2, fVar.f3018k);
            if (fVar.f3017j <= 0.0f) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(typedArray.getPositionDescription());
                sb2.append("<vector> tag requires width > 0");
                throw new XmlPullParserException(sb2.toString());
            } else if (fVar.f3018k > 0.0f) {
                fVar.setAlpha(j.a(typedArray, xmlPullParser, "alpha", 4, fVar.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    fVar.o = string;
                    fVar.q.put(string, fVar);
                }
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(typedArray.getPositionDescription());
                sb3.append("<vector> tag requires height > 0");
                throw new XmlPullParserException(sb3.toString());
            }
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(typedArray.getPositionDescription());
            sb4.append("<vector> tag requires viewportHeight > 0");
            throw new XmlPullParserException(sb4.toString());
        }
    }

    private void a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        g gVar = this.f2975c;
        f fVar = gVar.f3021b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(fVar.f3016i);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            String str = "group";
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                c cVar = (c) arrayDeque.peek();
                if ("path".equals(name)) {
                    b bVar = new b();
                    bVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f2994b.add(bVar);
                    if (bVar.getPathName() != null) {
                        fVar.q.put(bVar.getPathName(), bVar);
                    }
                    z = false;
                    gVar.f3020a = bVar.f3007c | gVar.f3020a;
                } else if ("clip-path".equals(name)) {
                    a aVar = new a();
                    aVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f2994b.add(aVar);
                    if (aVar.getPathName() != null) {
                        fVar.q.put(aVar.getPathName(), aVar);
                    }
                    gVar.f3020a = aVar.f3007c | gVar.f3020a;
                } else if (str.equals(name)) {
                    c cVar2 = new c();
                    cVar2.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f2994b.add(cVar2);
                    arrayDeque.push(cVar2);
                    if (cVar2.getGroupName() != null) {
                        fVar.q.put(cVar2.getGroupName(), cVar2);
                    }
                    gVar.f3020a = cVar2.f3003k | gVar.f3020a;
                }
            } else if (eventType == 3 && str.equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(boolean z) {
        this.f2979g = z;
    }

    private boolean a() {
        if (VERSION.SDK_INT < 17 || !isAutoMirrored() || androidx.core.graphics.drawable.a.e(this) != 1) {
            return false;
        }
        return true;
    }
}
