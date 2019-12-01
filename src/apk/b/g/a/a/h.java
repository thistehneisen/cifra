package b.g.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.TypedValue;
import b.g.b.c;
import b.g.h.g;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ResourcesCompat */
public final class h {

    /* compiled from: ResourcesCompat */
    public static abstract class a {
        public abstract void a(int i2);

        public abstract void a(Typeface typeface);

        public final void a(Typeface typeface, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new f(this, typeface));
        }

        public final void a(int i2, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new g(this, i2));
        }
    }

    public static Drawable a(Resources resources, int i2, Theme theme) throws NotFoundException {
        if (VERSION.SDK_INT >= 21) {
            return resources.getDrawable(i2, theme);
        }
        return resources.getDrawable(i2);
    }

    public static Typeface a(Context context, int i2) throws NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return a(context, i2, new TypedValue(), 0, null, null, false);
    }

    public static void a(Context context, int i2, a aVar, Handler handler) throws NotFoundException {
        g.a(aVar);
        if (context.isRestricted()) {
            aVar.a(-4, handler);
            return;
        }
        a(context, i2, new TypedValue(), 0, aVar, handler, false);
    }

    public static Typeface a(Context context, int i2, TypedValue typedValue, int i3, a aVar) throws NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return a(context, i2, typedValue, i3, aVar, null, true);
    }

    private static Typeface a(Context context, int i2, TypedValue typedValue, int i3, a aVar, Handler handler, boolean z) {
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        Typeface a2 = a(context, resources, typedValue, i2, i3, aVar, handler, z);
        if (a2 != null || aVar != null) {
            return a2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Font resource ID #0x");
        sb.append(Integer.toHexString(i2));
        sb.append(" could not be retrieved.");
        throw new NotFoundException(sb.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a3  */
    private static Typeface a(Context context, Resources resources, TypedValue typedValue, int i2, int i3, a aVar, Handler handler, boolean z) {
        Resources resources2 = resources;
        TypedValue typedValue2 = typedValue;
        int i4 = i2;
        int i5 = i3;
        a aVar2 = aVar;
        Handler handler2 = handler;
        String str = "ResourcesCompat";
        CharSequence charSequence = typedValue2.string;
        if (charSequence != null) {
            String charSequence2 = charSequence.toString();
            if (!charSequence2.startsWith("res/")) {
                if (aVar2 != null) {
                    aVar2.a(-3, handler2);
                }
                return null;
            }
            Typeface a2 = c.a(resources2, i4, i5);
            if (a2 != null) {
                if (aVar2 != null) {
                    aVar2.a(a2, handler2);
                }
                return a2;
            }
            try {
                if (charSequence2.toLowerCase().endsWith(".xml")) {
                    b.g.a.a.c.a a3 = c.a((XmlPullParser) resources2.getXml(i4), resources2);
                    if (a3 != null) {
                        return c.a(context, a3, resources, i2, i3, aVar, handler, z);
                    }
                    Log.e(str, "Failed to find font-family tag");
                    if (aVar2 != null) {
                        aVar2.a(-3, handler2);
                    }
                    return null;
                }
                Context context2 = context;
                Typeface a4 = c.a(context, resources2, i4, charSequence2, i5);
                if (aVar2 != null) {
                    if (a4 != null) {
                        aVar2.a(a4, handler2);
                    } else {
                        aVar2.a(-3, handler2);
                    }
                }
                return a4;
            } catch (XmlPullParserException e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to parse xml resource ");
                sb.append(charSequence2);
                Log.e(str, sb.toString(), e2);
                if (aVar2 != null) {
                    aVar2.a(-3, handler2);
                }
                return null;
            } catch (IOException e3) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to read xml resource ");
                sb2.append(charSequence2);
                Log.e(str, sb2.toString(), e3);
                if (aVar2 != null) {
                }
                return null;
            }
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Resource \"");
            sb3.append(resources2.getResourceName(i4));
            sb3.append("\" (");
            sb3.append(Integer.toHexString(i2));
            sb3.append(") is not a Font: ");
            sb3.append(typedValue2);
            throw new NotFoundException(sb3.toString());
        }
    }
}
