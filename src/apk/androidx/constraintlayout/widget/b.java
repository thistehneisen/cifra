package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Xml;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: ConstraintAttribute */
public class b {

    /* renamed from: a reason: collision with root package name */
    String f1148a;

    /* renamed from: b reason: collision with root package name */
    private a f1149b;

    /* renamed from: c reason: collision with root package name */
    private int f1150c;

    /* renamed from: d reason: collision with root package name */
    private float f1151d;

    /* renamed from: e reason: collision with root package name */
    private String f1152e;

    /* renamed from: f reason: collision with root package name */
    boolean f1153f;

    /* renamed from: g reason: collision with root package name */
    private int f1154g;

    /* compiled from: ConstraintAttribute */
    public enum a {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE
    }

    public b(String str, a aVar, Object obj) {
        this.f1148a = str;
        this.f1149b = aVar;
        a(obj);
    }

    public void a(Object obj) {
        switch (a.f1147a[this.f1149b.ordinal()]) {
            case 1:
            case 2:
                this.f1154g = ((Integer) obj).intValue();
                return;
            case 3:
                this.f1150c = ((Integer) obj).intValue();
                return;
            case 4:
                this.f1151d = ((Float) obj).floatValue();
                return;
            case 5:
                this.f1152e = (String) obj;
                return;
            case 6:
                this.f1153f = ((Boolean) obj).booleanValue();
                return;
            case 7:
                this.f1151d = ((Float) obj).floatValue();
                return;
            default:
                return;
        }
    }

    public b(b bVar, Object obj) {
        this.f1148a = bVar.f1148a;
        this.f1149b = bVar.f1149b;
        a(obj);
    }

    public static HashMap<String, b> a(HashMap<String, b> hashMap, View view) {
        HashMap<String, b> hashMap2 = new HashMap<>();
        Class cls = view.getClass();
        for (String str : hashMap.keySet()) {
            b bVar = (b) hashMap.get(str);
            try {
                if (str.equals("BackgroundColor")) {
                    hashMap2.put(str, new b(bVar, Integer.valueOf(((ColorDrawable) view.getBackground()).getColor())));
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("getMap");
                    sb.append(str);
                    hashMap2.put(str, new b(bVar, cls.getMethod(sb.toString(), new Class[0]).invoke(view, new Object[0])));
                }
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
        }
        return hashMap2;
    }

    public static void a(View view, HashMap<String, b> hashMap) {
        Class cls = view.getClass();
        for (String str : hashMap.keySet()) {
            b bVar = (b) hashMap.get(str);
            StringBuilder sb = new StringBuilder();
            sb.append("set");
            sb.append(str);
            String sb2 = sb.toString();
            try {
                switch (a.f1147a[bVar.f1149b.ordinal()]) {
                    case 1:
                        cls.getMethod(sb2, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(bVar.f1154g)});
                        break;
                    case 2:
                        Method method = cls.getMethod(sb2, new Class[]{Drawable.class});
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(bVar.f1154g);
                        method.invoke(view, new Object[]{colorDrawable});
                        break;
                    case 3:
                        cls.getMethod(sb2, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(bVar.f1150c)});
                        break;
                    case 4:
                        cls.getMethod(sb2, new Class[]{Float.TYPE}).invoke(view, new Object[]{Float.valueOf(bVar.f1151d)});
                        break;
                    case 5:
                        cls.getMethod(sb2, new Class[]{CharSequence.class}).invoke(view, new Object[]{bVar.f1152e});
                        break;
                    case 6:
                        cls.getMethod(sb2, new Class[]{Boolean.TYPE}).invoke(view, new Object[]{Boolean.valueOf(bVar.f1153f)});
                        break;
                    case 7:
                        cls.getMethod(sb2, new Class[]{Float.TYPE}).invoke(view, new Object[]{Float.valueOf(bVar.f1151d)});
                        break;
                }
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
        }
    }

    public static void a(Context context, XmlPullParser xmlPullParser, HashMap<String, b> hashMap) {
        a aVar;
        Object string;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), l.CustomAttribute);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj = null;
        a aVar2 = null;
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == l.CustomAttribute_attributeName) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(Character.toUpperCase(str.charAt(0)));
                    sb.append(str.substring(1));
                    str = sb.toString();
                }
            } else if (index == l.CustomAttribute_customBoolean) {
                obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                aVar2 = a.BOOLEAN_TYPE;
            } else {
                if (index == l.CustomAttribute_customColorValue) {
                    aVar = a.COLOR_TYPE;
                    string = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == l.CustomAttribute_customColorDrawableValue) {
                    aVar = a.COLOR_DRAWABLE_TYPE;
                    string = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == l.CustomAttribute_customDimension) {
                    aVar = a.DIMENSION_TYPE;
                    string = Float.valueOf(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == l.CustomAttribute_customFloatValue) {
                    aVar = a.FLOAT_TYPE;
                    string = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                } else if (index == l.CustomAttribute_customIntegerValue) {
                    aVar = a.INT_TYPE;
                    string = Integer.valueOf(obtainStyledAttributes.getInteger(index, -1));
                } else if (index == l.CustomAttribute_customStringValue) {
                    aVar = a.STRING_TYPE;
                    string = obtainStyledAttributes.getString(index);
                }
                Object obj2 = string;
                aVar2 = aVar;
                obj = obj2;
            }
        }
        if (!(str == null || obj == null)) {
            hashMap.put(str, new b(str, aVar2, obj));
        }
        obtainStyledAttributes.recycle();
    }
}
