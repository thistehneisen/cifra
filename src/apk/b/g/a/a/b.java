package b.g.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ComplexColorCompat */
public final class b {

    /* renamed from: a reason: collision with root package name */
    private final Shader f2476a;

    /* renamed from: b reason: collision with root package name */
    private final ColorStateList f2477b;

    /* renamed from: c reason: collision with root package name */
    private int f2478c;

    private b(Shader shader, ColorStateList colorStateList, int i2) {
        this.f2476a = shader;
        this.f2477b = colorStateList;
        this.f2478c = i2;
    }

    static b a(Shader shader) {
        return new b(shader, null, 0);
    }

    public Shader b() {
        return this.f2476a;
    }

    public boolean c() {
        return this.f2476a != null;
    }

    public boolean d() {
        if (this.f2476a == null) {
            ColorStateList colorStateList = this.f2477b;
            if (colorStateList != null && colorStateList.isStateful()) {
                return true;
            }
        }
        return false;
    }

    public boolean e() {
        return c() || this.f2478c != 0;
    }

    static b a(ColorStateList colorStateList) {
        return new b(null, colorStateList, colorStateList.getDefaultColor());
    }

    public void b(int i2) {
        this.f2478c = i2;
    }

    static b a(int i2) {
        return new b(null, null, i2);
    }

    private static b b(Resources resources, int i2, Theme theme) throws IOException, XmlPullParserException {
        int next;
        XmlResourceParser xml = resources.getXml(i2);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            String name = xml.getName();
            char c2 = 65535;
            int hashCode = name.hashCode();
            if (hashCode != 89650992) {
                if (hashCode == 1191572447 && name.equals("selector")) {
                    c2 = 0;
                }
            } else if (name.equals("gradient")) {
                c2 = 1;
            }
            if (c2 == 0) {
                return a(a.a(resources, (XmlPullParser) xml, asAttributeSet, theme));
            }
            if (c2 == 1) {
                return a(d.a(resources, xml, asAttributeSet, theme));
            }
            StringBuilder sb = new StringBuilder();
            sb.append(xml.getPositionDescription());
            sb.append(": unsupported complex color tag ");
            sb.append(name);
            throw new XmlPullParserException(sb.toString());
        }
        throw new XmlPullParserException("No start tag found");
    }

    public int a() {
        return this.f2478c;
    }

    public boolean a(int[] iArr) {
        if (d()) {
            ColorStateList colorStateList = this.f2477b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f2478c) {
                this.f2478c = colorForState;
                return true;
            }
        }
        return false;
    }

    public static b a(Resources resources, int i2, Theme theme) {
        try {
            return b(resources, i2, theme);
        } catch (Exception e2) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e2);
            return null;
        }
    }
}
