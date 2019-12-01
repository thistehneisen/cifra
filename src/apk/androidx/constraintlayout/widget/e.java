package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import com.appsflyer.share.Constants;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ConstraintLayoutStates */
public class e {

    /* renamed from: a reason: collision with root package name */
    private final ConstraintLayout f1171a;

    /* renamed from: b reason: collision with root package name */
    f f1172b;

    /* renamed from: c reason: collision with root package name */
    int f1173c = -1;

    /* renamed from: d reason: collision with root package name */
    int f1174d = -1;

    /* renamed from: e reason: collision with root package name */
    private SparseArray<a> f1175e = new SparseArray<>();

    /* renamed from: f reason: collision with root package name */
    private SparseArray<f> f1176f = new SparseArray<>();

    /* renamed from: g reason: collision with root package name */
    private h f1177g = null;

    /* compiled from: ConstraintLayoutStates */
    static class a {

        /* renamed from: a reason: collision with root package name */
        int f1178a;

        /* renamed from: b reason: collision with root package name */
        ArrayList<b> f1179b = new ArrayList<>();

        /* renamed from: c reason: collision with root package name */
        int f1180c = -1;

        /* renamed from: d reason: collision with root package name */
        f f1181d;

        public a(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), l.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == l.State_android_id) {
                    this.f1178a = obtainStyledAttributes.getResourceId(index, this.f1178a);
                } else if (index == l.State_constraints) {
                    this.f1180c = obtainStyledAttributes.getResourceId(index, this.f1180c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f1180c);
                    context.getResources().getResourceName(this.f1180c);
                    if ("layout".equals(resourceTypeName)) {
                        this.f1181d = new f();
                        this.f1181d.a(context, this.f1180c);
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: 0000 */
        public void a(b bVar) {
            this.f1179b.add(bVar);
        }

        public int a(float f2, float f3) {
            for (int i2 = 0; i2 < this.f1179b.size(); i2++) {
                if (((b) this.f1179b.get(i2)).a(f2, f3)) {
                    return i2;
                }
            }
            return -1;
        }
    }

    /* compiled from: ConstraintLayoutStates */
    static class b {

        /* renamed from: a reason: collision with root package name */
        float f1182a = Float.NaN;

        /* renamed from: b reason: collision with root package name */
        float f1183b = Float.NaN;

        /* renamed from: c reason: collision with root package name */
        float f1184c = Float.NaN;

        /* renamed from: d reason: collision with root package name */
        float f1185d = Float.NaN;

        /* renamed from: e reason: collision with root package name */
        int f1186e = -1;

        /* renamed from: f reason: collision with root package name */
        f f1187f;

        public b(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), l.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == l.Variant_constraints) {
                    this.f1186e = obtainStyledAttributes.getResourceId(index, this.f1186e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f1186e);
                    context.getResources().getResourceName(this.f1186e);
                    if ("layout".equals(resourceTypeName)) {
                        this.f1187f = new f();
                        this.f1187f.a(context, this.f1186e);
                    }
                } else if (index == l.Variant_region_heightLessThan) {
                    this.f1185d = obtainStyledAttributes.getDimension(index, this.f1185d);
                } else if (index == l.Variant_region_heightMoreThan) {
                    this.f1183b = obtainStyledAttributes.getDimension(index, this.f1183b);
                } else if (index == l.Variant_region_widthLessThan) {
                    this.f1184c = obtainStyledAttributes.getDimension(index, this.f1184c);
                } else if (index == l.Variant_region_widthMoreThan) {
                    this.f1182a = obtainStyledAttributes.getDimension(index, this.f1182a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: 0000 */
        public boolean a(float f2, float f3) {
            if (!Float.isNaN(this.f1182a) && f2 < this.f1182a) {
                return false;
            }
            if (!Float.isNaN(this.f1183b) && f3 < this.f1183b) {
                return false;
            }
            if (!Float.isNaN(this.f1184c) && f2 > this.f1184c) {
                return false;
            }
            if (Float.isNaN(this.f1185d) || f3 <= this.f1185d) {
                return true;
            }
            return false;
        }
    }

    e(Context context, ConstraintLayout constraintLayout, int i2) {
        this.f1171a = constraintLayout;
        a(context, i2);
    }

    public void a(int i2, float f2, float f3) {
        f fVar;
        int i3;
        a aVar;
        f fVar2;
        int i4;
        int i5 = this.f1173c;
        if (i5 == i2) {
            if (i2 == -1) {
                aVar = (a) this.f1175e.valueAt(0);
            } else {
                aVar = (a) this.f1175e.get(i5);
            }
            int i6 = this.f1174d;
            if (i6 == -1 || !((b) aVar.f1179b.get(i6)).a(f2, f3)) {
                int a2 = aVar.a(f2, f3);
                if (this.f1174d != a2) {
                    if (a2 == -1) {
                        fVar2 = this.f1172b;
                    } else {
                        fVar2 = ((b) aVar.f1179b.get(a2)).f1187f;
                    }
                    if (a2 == -1) {
                        i4 = aVar.f1180c;
                    } else {
                        i4 = ((b) aVar.f1179b.get(a2)).f1186e;
                    }
                    if (fVar2 != null) {
                        this.f1174d = a2;
                        h hVar = this.f1177g;
                        if (hVar != null) {
                            hVar.b(-1, i4);
                        }
                        fVar2.a(this.f1171a);
                        h hVar2 = this.f1177g;
                        if (hVar2 != null) {
                            hVar2.a(-1, i4);
                        }
                    }
                }
            }
        } else {
            this.f1173c = i2;
            a aVar2 = (a) this.f1175e.get(this.f1173c);
            int a3 = aVar2.a(f2, f3);
            if (a3 == -1) {
                fVar = aVar2.f1181d;
            } else {
                fVar = ((b) aVar2.f1179b.get(a3)).f1187f;
            }
            if (a3 == -1) {
                i3 = aVar2.f1180c;
            } else {
                i3 = ((b) aVar2.f1179b.get(a3)).f1186e;
            }
            if (fVar == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("NO Constraint set found ! id=");
                sb.append(i2);
                sb.append(", dim =");
                sb.append(f2);
                sb.append(", ");
                sb.append(f3);
                Log.v("ConstraintLayoutStates", sb.toString());
                return;
            }
            this.f1174d = a3;
            h hVar3 = this.f1177g;
            if (hVar3 != null) {
                hVar3.b(i2, i3);
            }
            fVar.a(this.f1171a);
            h hVar4 = this.f1177g;
            if (hVar4 != null) {
                hVar4.a(i2, i3);
            }
        }
    }

    public void a(h hVar) {
        this.f1177g = hVar;
    }

    private void a(Context context, int i2) {
        XmlResourceParser xml = context.getResources().getXml(i2);
        a aVar = null;
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    char c2 = 65535;
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 1657696882:
                            if (name.equals("layoutDescription")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                c2 = 3;
                                break;
                            }
                            break;
                    }
                    if (!(c2 == 0 || c2 == 1)) {
                        if (c2 == 2) {
                            aVar = new a(context, xml);
                            this.f1175e.put(aVar.f1178a, aVar);
                        } else if (c2 == 3) {
                            b bVar = new b(context, xml);
                            if (aVar != null) {
                                aVar.a(bVar);
                            }
                        } else if (c2 != 4) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("unknown tag ");
                            sb.append(name);
                            Log.v("ConstraintLayoutStates", sb.toString());
                        } else {
                            a(context, (XmlPullParser) xml);
                        }
                    }
                }
            }
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    private void a(Context context, XmlPullParser xmlPullParser) {
        int i2;
        f fVar = new f();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i3 = 0; i3 < attributeCount; i3++) {
            String str = "mId";
            if (str.equals(xmlPullParser.getAttributeName(i3))) {
                String attributeValue = xmlPullParser.getAttributeValue(i3);
                if (attributeValue.contains(Constants.URL_PATH_DELIMITER)) {
                    i2 = context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), str, null);
                } else {
                    i2 = -1;
                }
                if (i2 == -1) {
                    if (attributeValue == null || attributeValue.length() <= 1) {
                        Log.e("ConstraintLayoutStates", "error in parsing mId");
                    } else {
                        i2 = Integer.parseInt(attributeValue.substring(1));
                    }
                }
                fVar.a(context, xmlPullParser);
                this.f1176f.put(i2, fVar);
                return;
            }
        }
    }
}
