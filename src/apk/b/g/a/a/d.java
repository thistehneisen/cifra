package b.g.a.a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: GradientColorInflaterCompat */
final class d {

    /* compiled from: GradientColorInflaterCompat */
    static final class a {

        /* renamed from: a reason: collision with root package name */
        final int[] f2489a;

        /* renamed from: b reason: collision with root package name */
        final float[] f2490b;

        a(List<Integer> list, List<Float> list2) {
            int size = list.size();
            this.f2489a = new int[size];
            this.f2490b = new float[size];
            for (int i2 = 0; i2 < size; i2++) {
                this.f2489a[i2] = ((Integer) list.get(i2)).intValue();
                this.f2490b[i2] = ((Float) list2.get(i2)).floatValue();
            }
        }

        a(int i2, int i3) {
            this.f2489a = new int[]{i2, i3};
            this.f2490b = new float[]{0.0f, 1.0f};
        }

        a(int i2, int i3, int i4) {
            this.f2489a = new int[]{i2, i3, i4};
            this.f2490b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }

    static Shader a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws IOException, XmlPullParserException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        String name = xmlPullParser.getName();
        if (name.equals("gradient")) {
            Theme theme2 = theme;
            TypedArray a2 = j.a(resources, theme2, attributeSet, b.g.d.GradientColor);
            float a3 = j.a(a2, xmlPullParser2, "startX", b.g.d.GradientColor_android_startX, 0.0f);
            float a4 = j.a(a2, xmlPullParser2, "startY", b.g.d.GradientColor_android_startY, 0.0f);
            float a5 = j.a(a2, xmlPullParser2, "endX", b.g.d.GradientColor_android_endX, 0.0f);
            float a6 = j.a(a2, xmlPullParser2, "endY", b.g.d.GradientColor_android_endY, 0.0f);
            float a7 = j.a(a2, xmlPullParser2, "centerX", b.g.d.GradientColor_android_centerX, 0.0f);
            float a8 = j.a(a2, xmlPullParser2, "centerY", b.g.d.GradientColor_android_centerY, 0.0f);
            int b2 = j.b(a2, xmlPullParser2, "type", b.g.d.GradientColor_android_type, 0);
            int a9 = j.a(a2, xmlPullParser2, "startColor", b.g.d.GradientColor_android_startColor, 0);
            String str = "centerColor";
            boolean a10 = j.a(xmlPullParser2, str);
            int a11 = j.a(a2, xmlPullParser2, str, b.g.d.GradientColor_android_centerColor, 0);
            int a12 = j.a(a2, xmlPullParser2, "endColor", b.g.d.GradientColor_android_endColor, 0);
            int b3 = j.b(a2, xmlPullParser2, "tileMode", b.g.d.GradientColor_android_tileMode, 0);
            float f2 = a7;
            float a13 = j.a(a2, xmlPullParser2, "gradientRadius", b.g.d.GradientColor_android_gradientRadius, 0.0f);
            a2.recycle();
            a a14 = a(b(resources, xmlPullParser, attributeSet, theme), a9, a12, a10, a11);
            if (b2 == 1) {
                float f3 = f2;
                if (a13 > 0.0f) {
                    int[] iArr = a14.f2489a;
                    RadialGradient radialGradient = new RadialGradient(f3, a8, a13, iArr, a14.f2490b, a(b3));
                    return radialGradient;
                }
                throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
            } else if (b2 != 2) {
                LinearGradient linearGradient = new LinearGradient(a3, a4, a5, a6, a14.f2489a, a14.f2490b, a(b3));
                return linearGradient;
            } else {
                return new SweepGradient(f2, a8, a14.f2489a, a14.f2490b);
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(xmlPullParser.getPositionDescription());
            sb.append(": invalid gradient color tag ");
            sb.append(name);
            throw new XmlPullParserException(sb.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0084, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r10.toString());
     */
    private static a b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        ArrayList arrayList = new ArrayList(20);
        ArrayList arrayList2 = new ArrayList(20);
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                break;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                break;
            } else if (next == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                TypedArray a2 = j.a(resources, theme, attributeSet, b.g.d.GradientColorItem);
                boolean hasValue = a2.hasValue(b.g.d.GradientColorItem_android_color);
                boolean hasValue2 = a2.hasValue(b.g.d.GradientColorItem_android_offset);
                if (!hasValue || !hasValue2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(xmlPullParser.getPositionDescription());
                    sb.append(": <item> tag requires a 'color' attribute and a 'offset' attribute!");
                } else {
                    int color = a2.getColor(b.g.d.GradientColorItem_android_color, 0);
                    float f2 = a2.getFloat(b.g.d.GradientColorItem_android_offset, 0.0f);
                    a2.recycle();
                    arrayList2.add(Integer.valueOf(color));
                    arrayList.add(Float.valueOf(f2));
                }
            }
        }
        if (arrayList2.size() > 0) {
            return new a((List<Integer>) arrayList2, (List<Float>) arrayList);
        }
        return null;
    }

    private static a a(a aVar, int i2, int i3, boolean z, int i4) {
        if (aVar != null) {
            return aVar;
        }
        if (z) {
            return new a(i2, i4, i3);
        }
        return new a(i2, i3);
    }

    private static TileMode a(int i2) {
        if (i2 == 1) {
            return TileMode.REPEAT;
        }
        if (i2 != 2) {
            return TileMode.CLAMP;
        }
        return TileMode.MIRROR;
    }
}
