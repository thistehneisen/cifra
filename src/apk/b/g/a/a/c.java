package b.g.a.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: FontResourcesParserCompat */
public class c {

    /* compiled from: FontResourcesParserCompat */
    public interface a {
    }

    /* compiled from: FontResourcesParserCompat */
    public static final class b implements a {

        /* renamed from: a reason: collision with root package name */
        private final C0021c[] f2479a;

        public b(C0021c[] cVarArr) {
            this.f2479a = cVarArr;
        }

        public C0021c[] a() {
            return this.f2479a;
        }
    }

    /* renamed from: b.g.a.a.c$c reason: collision with other inner class name */
    /* compiled from: FontResourcesParserCompat */
    public static final class C0021c {

        /* renamed from: a reason: collision with root package name */
        private final String f2480a;

        /* renamed from: b reason: collision with root package name */
        private int f2481b;

        /* renamed from: c reason: collision with root package name */
        private boolean f2482c;

        /* renamed from: d reason: collision with root package name */
        private String f2483d;

        /* renamed from: e reason: collision with root package name */
        private int f2484e;

        /* renamed from: f reason: collision with root package name */
        private int f2485f;

        public C0021c(String str, int i2, boolean z, String str2, int i3, int i4) {
            this.f2480a = str;
            this.f2481b = i2;
            this.f2482c = z;
            this.f2483d = str2;
            this.f2484e = i3;
            this.f2485f = i4;
        }

        public String a() {
            return this.f2480a;
        }

        public int b() {
            return this.f2485f;
        }

        public int c() {
            return this.f2484e;
        }

        public String d() {
            return this.f2483d;
        }

        public int e() {
            return this.f2481b;
        }

        public boolean f() {
            return this.f2482c;
        }
    }

    /* compiled from: FontResourcesParserCompat */
    public static final class d implements a {

        /* renamed from: a reason: collision with root package name */
        private final b.g.f.a f2486a;

        /* renamed from: b reason: collision with root package name */
        private final int f2487b;

        /* renamed from: c reason: collision with root package name */
        private final int f2488c;

        public d(b.g.f.a aVar, int i2, int i3) {
            this.f2486a = aVar;
            this.f2488c = i2;
            this.f2487b = i3;
        }

        public int a() {
            return this.f2488c;
        }

        public b.g.f.a b() {
            return this.f2486a;
        }

        public int c() {
            return this.f2487b;
        }
    }

    public static a a(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    private static a b(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        String str = "font-family";
        xmlPullParser.require(2, null, str);
        if (xmlPullParser.getName().equals(str)) {
            return c(xmlPullParser, resources);
        }
        a(xmlPullParser);
        return null;
    }

    private static a c(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), b.g.d.FontFamily);
        String string = obtainAttributes.getString(b.g.d.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(b.g.d.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(b.g.d.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(b.g.d.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(b.g.d.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(b.g.d.FontFamily_fontProviderFetchTimeout, 500);
        obtainAttributes.recycle();
        if (string == null || string2 == null || string3 == null) {
            ArrayList arrayList = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("font")) {
                        arrayList.add(d(xmlPullParser, resources));
                    } else {
                        a(xmlPullParser);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new b((C0021c[]) arrayList.toArray(new C0021c[arrayList.size()]));
        }
        while (xmlPullParser.next() != 3) {
            a(xmlPullParser);
        }
        return new d(new b.g.f.a(string, string2, string3, a(resources, resourceId)), integer, integer2);
    }

    private static C0021c d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), b.g.d.FontFamilyFont);
        int i2 = obtainAttributes.getInt(obtainAttributes.hasValue(b.g.d.FontFamilyFont_fontWeight) ? b.g.d.FontFamilyFont_fontWeight : b.g.d.FontFamilyFont_android_fontWeight, 400);
        boolean z = 1 == obtainAttributes.getInt(obtainAttributes.hasValue(b.g.d.FontFamilyFont_fontStyle) ? b.g.d.FontFamilyFont_fontStyle : b.g.d.FontFamilyFont_android_fontStyle, 0);
        int i3 = obtainAttributes.hasValue(b.g.d.FontFamilyFont_ttcIndex) ? b.g.d.FontFamilyFont_ttcIndex : b.g.d.FontFamilyFont_android_ttcIndex;
        String string = obtainAttributes.getString(obtainAttributes.hasValue(b.g.d.FontFamilyFont_fontVariationSettings) ? b.g.d.FontFamilyFont_fontVariationSettings : b.g.d.FontFamilyFont_android_fontVariationSettings);
        int i4 = obtainAttributes.getInt(i3, 0);
        int i5 = obtainAttributes.hasValue(b.g.d.FontFamilyFont_font) ? b.g.d.FontFamilyFont_font : b.g.d.FontFamilyFont_android_font;
        int resourceId = obtainAttributes.getResourceId(i5, 0);
        String string2 = obtainAttributes.getString(i5);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            a(xmlPullParser);
        }
        C0021c cVar = new C0021c(string2, i2, z, string, i4, resourceId);
        return cVar;
    }

    private static int a(TypedArray typedArray, int i2) {
        if (VERSION.SDK_INT >= 21) {
            return typedArray.getType(i2);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i2, typedValue);
        return typedValue.type;
    }

    public static List<List<byte[]>> a(Resources resources, int i2) {
        if (i2 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i2);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (int i3 = 0; i3 < obtainTypedArray.length(); i3++) {
                    int resourceId = obtainTypedArray.getResourceId(i3, 0);
                    if (resourceId != 0) {
                        arrayList.add(a(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(a(resources.getStringArray(i2)));
            }
            obtainTypedArray.recycle();
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static List<byte[]> a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String decode : strArr) {
            arrayList.add(Base64.decode(decode, 0));
        }
        return arrayList;
    }

    private static void a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i2 = 1;
        while (i2 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i2++;
            } else if (next == 3) {
                i2--;
            }
        }
    }
}
