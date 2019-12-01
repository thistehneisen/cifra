package b.q.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import b.g.a.a.j;
import b.g.b.b;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: PathInterpolatorCompat */
public class h implements Interpolator {

    /* renamed from: a reason: collision with root package name */
    private float[] f2971a;

    /* renamed from: b reason: collision with root package name */
    private float[] f2972b;

    public h(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        String str = "pathData";
        if (j.a(xmlPullParser, str)) {
            String a2 = j.a(typedArray, xmlPullParser, str, 4);
            Path b2 = b.b(a2);
            if (b2 != null) {
                a(b2);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("The path is null, which is created from ");
            sb.append(a2);
            throw new InflateException(sb.toString());
        }
        String str2 = "controlX1";
        if (j.a(xmlPullParser, str2)) {
            String str3 = "controlY1";
            if (j.a(xmlPullParser, str3)) {
                float a3 = j.a(typedArray, xmlPullParser, str2, 0, 0.0f);
                float a4 = j.a(typedArray, xmlPullParser, str3, 1, 0.0f);
                String str4 = "controlX2";
                boolean a5 = j.a(xmlPullParser, str4);
                String str5 = "controlY2";
                if (a5 != j.a(xmlPullParser, str5)) {
                    throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
                } else if (!a5) {
                    a(a3, a4);
                } else {
                    a(a3, a4, j.a(typedArray, xmlPullParser, str4, 2, 0.0f), j.a(typedArray, xmlPullParser, str5, 3, 0.0f));
                }
            } else {
                throw new InflateException("pathInterpolator requires the controlY1 attribute");
            }
        } else {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        }
    }

    public float getInterpolation(float f2) {
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        int i2 = 0;
        int length = this.f2971a.length - 1;
        while (length - i2 > 1) {
            int i3 = (i2 + length) / 2;
            if (f2 < this.f2971a[i3]) {
                length = i3;
            } else {
                i2 = i3;
            }
        }
        float[] fArr = this.f2971a;
        float f3 = fArr[length] - fArr[i2];
        if (f3 == 0.0f) {
            return this.f2972b[i2];
        }
        float f4 = (f2 - fArr[i2]) / f3;
        float[] fArr2 = this.f2972b;
        float f5 = fArr2[i2];
        return f5 + (f4 * (fArr2[length] - f5));
    }

    public h(Resources resources, Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray a2 = j.a(resources, theme, attributeSet, a.f2955l);
        a(a2, xmlPullParser);
        a2.recycle();
    }

    private void a(float f2, float f3) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f2, f3, 1.0f, 1.0f);
        a(path);
    }

    private void a(float f2, float f3, float f4, float f5) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f2, f3, f4, f5, 1.0f, 1.0f);
        a(path);
    }

    private void a(Path path) {
        int i2 = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = Math.min(3000, ((int) (length / 0.002f)) + 1);
        if (min > 0) {
            this.f2971a = new float[min];
            this.f2972b = new float[min];
            float[] fArr = new float[2];
            for (int i3 = 0; i3 < min; i3++) {
                pathMeasure.getPosTan((((float) i3) * length) / ((float) (min - 1)), fArr, null);
                this.f2971a[i3] = fArr[0];
                this.f2972b[i3] = fArr[1];
            }
            if (((double) Math.abs(this.f2971a[0])) <= 1.0E-5d && ((double) Math.abs(this.f2972b[0])) <= 1.0E-5d) {
                int i4 = min - 1;
                if (((double) Math.abs(this.f2971a[i4] - 1.0f)) <= 1.0E-5d && ((double) Math.abs(this.f2972b[i4] - 1.0f)) <= 1.0E-5d) {
                    int i5 = 0;
                    float f2 = 0.0f;
                    while (i2 < min) {
                        float[] fArr2 = this.f2971a;
                        int i6 = i5 + 1;
                        float f3 = fArr2[i5];
                        if (f3 >= f2) {
                            fArr2[i2] = f3;
                            i2++;
                            f2 = f3;
                            i5 = i6;
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("The Path cannot loop back on itself, x :");
                            sb.append(f3);
                            throw new IllegalArgumentException(sb.toString());
                        }
                    }
                    if (pathMeasure.nextContour()) {
                        throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                    }
                    return;
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("The Path must start at (0,0) and end at (1,1) start: ");
            sb2.append(this.f2971a[0]);
            String str = ",";
            sb2.append(str);
            sb2.append(this.f2972b[0]);
            sb2.append(" end:");
            int i7 = min - 1;
            sb2.append(this.f2971a[i7]);
            sb2.append(str);
            sb2.append(this.f2972b[i7]);
            throw new IllegalArgumentException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("The Path has a invalid length ");
        sb3.append(length);
        throw new IllegalArgumentException(sb3.toString());
    }
}
