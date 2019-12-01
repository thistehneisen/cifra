package b.g.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import b.g.d;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ColorStateListInflaterCompat */
public final class a {
    public static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return a(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    private static ColorStateList b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        AttributeSet attributeSet2 = attributeSet;
        int i2 = 1;
        int depth = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20][];
        int[] iArr2 = new int[iArr.length];
        int i3 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i2) {
                break;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                break;
            }
            if (next != 2 || depth2 > depth || !xmlPullParser.getName().equals("item")) {
                Resources resources2 = resources;
                Theme theme2 = theme;
            } else {
                TypedArray a2 = a(resources, theme, attributeSet2, d.ColorStateListItem);
                int color = a2.getColor(d.ColorStateListItem_android_color, -65281);
                float f2 = 1.0f;
                if (a2.hasValue(d.ColorStateListItem_android_alpha)) {
                    f2 = a2.getFloat(d.ColorStateListItem_android_alpha, 1.0f);
                } else if (a2.hasValue(d.ColorStateListItem_alpha)) {
                    f2 = a2.getFloat(d.ColorStateListItem_alpha, 1.0f);
                }
                a2.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr3 = new int[attributeCount];
                int i4 = 0;
                for (int i5 = 0; i5 < attributeCount; i5++) {
                    int attributeNameResource = attributeSet2.getAttributeNameResource(i5);
                    if (!(attributeNameResource == 16843173 || attributeNameResource == 16843551 || attributeNameResource == b.g.a.alpha)) {
                        int i6 = i4 + 1;
                        if (!attributeSet2.getAttributeBooleanValue(i5, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr3[i4] = attributeNameResource;
                        i4 = i6;
                    }
                }
                int[] trimStateSet = StateSet.trimStateSet(iArr3, i4);
                iArr2 = e.a(iArr2, i3, a(color, f2));
                iArr = (int[][]) e.a((T[]) iArr, i3, trimStateSet);
                i3++;
            }
            i2 = 1;
        }
        int[] iArr4 = new int[i3];
        int[][] iArr5 = new int[i3][];
        System.arraycopy(iArr2, 0, iArr4, 0, i3);
        System.arraycopy(iArr, 0, iArr5, 0, i3);
        return new ColorStateList(iArr5, iArr4);
    }

    public static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return b(resources, xmlPullParser, attributeSet, theme);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(xmlPullParser.getPositionDescription());
        sb.append(": invalid color state list tag ");
        sb.append(name);
        throw new XmlPullParserException(sb.toString());
    }

    private static TypedArray a(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    private static int a(int i2, float f2) {
        return (i2 & 16777215) | (Math.round(((float) Color.alpha(i2)) * f2) << 24);
    }
}
