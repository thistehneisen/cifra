package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: DrawableCompat */
public final class a {

    /* renamed from: a reason: collision with root package name */
    private static Method f1312a;

    /* renamed from: b reason: collision with root package name */
    private static boolean f1313b;

    /* renamed from: c reason: collision with root package name */
    private static Method f1314c;

    /* renamed from: d reason: collision with root package name */
    private static boolean f1315d;

    public static void a(Drawable drawable, boolean z) {
        if (VERSION.SDK_INT >= 19) {
            drawable.setAutoMirrored(z);
        }
    }

    public static void b(Drawable drawable, int i2) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setTint(i2);
        } else if (drawable instanceof b) {
            ((b) drawable).setTint(i2);
        }
    }

    public static int c(Drawable drawable) {
        if (VERSION.SDK_INT >= 19) {
            return drawable.getAlpha();
        }
        return 0;
    }

    public static ColorFilter d(Drawable drawable) {
        if (VERSION.SDK_INT >= 21) {
            return drawable.getColorFilter();
        }
        return null;
    }

    public static int e(Drawable drawable) {
        int i2 = VERSION.SDK_INT;
        if (i2 >= 23) {
            return drawable.getLayoutDirection();
        }
        if (i2 >= 17) {
            String str = "DrawableCompat";
            if (!f1315d) {
                try {
                    f1314c = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                    f1314c.setAccessible(true);
                } catch (NoSuchMethodException e2) {
                    Log.i(str, "Failed to retrieve getLayoutDirection() method", e2);
                }
                f1315d = true;
            }
            Method method = f1314c;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(drawable, new Object[0])).intValue();
                } catch (Exception e3) {
                    Log.i(str, "Failed to invoke getLayoutDirection() via reflection", e3);
                    f1314c = null;
                }
            }
        }
        return 0;
    }

    public static boolean f(Drawable drawable) {
        if (VERSION.SDK_INT >= 19) {
            return drawable.isAutoMirrored();
        }
        return false;
    }

    @Deprecated
    public static void g(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static <T extends Drawable> T h(Drawable drawable) {
        return drawable instanceof c ? ((c) drawable).a() : drawable;
    }

    public static Drawable i(Drawable drawable) {
        int i2 = VERSION.SDK_INT;
        if (i2 >= 23) {
            return drawable;
        }
        return i2 >= 21 ? !(drawable instanceof b) ? new e(drawable) : drawable : !(drawable instanceof b) ? new d(drawable) : drawable;
    }

    public static void a(Drawable drawable, float f2, float f3) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setHotspot(f2, f3);
        }
    }

    public static void a(Drawable drawable, int i2, int i3, int i4, int i5) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setHotspotBounds(i2, i3, i4, i5);
        }
    }

    public static void b(Drawable drawable) {
        int i2 = VERSION.SDK_INT;
        if (i2 >= 23) {
            drawable.clearColorFilter();
        } else if (i2 >= 21) {
            drawable.clearColorFilter();
            if (drawable instanceof InsetDrawable) {
                b(((InsetDrawable) drawable).getDrawable());
            } else if (drawable instanceof c) {
                b(((c) drawable).a());
            } else if (drawable instanceof DrawableContainer) {
                DrawableContainerState drawableContainerState = (DrawableContainerState) ((DrawableContainer) drawable).getConstantState();
                if (drawableContainerState != null) {
                    int childCount = drawableContainerState.getChildCount();
                    for (int i3 = 0; i3 < childCount; i3++) {
                        Drawable child = drawableContainerState.getChild(i3);
                        if (child != null) {
                            b(child);
                        }
                    }
                }
            }
        } else {
            drawable.clearColorFilter();
        }
    }

    public static void a(Drawable drawable, ColorStateList colorStateList) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setTintList(colorStateList);
        } else if (drawable instanceof b) {
            ((b) drawable).setTintList(colorStateList);
        }
    }

    public static void a(Drawable drawable, Mode mode) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setTintMode(mode);
        } else if (drawable instanceof b) {
            ((b) drawable).setTintMode(mode);
        }
    }

    public static void a(Drawable drawable, Theme theme) {
        if (VERSION.SDK_INT >= 21) {
            drawable.applyTheme(theme);
        }
    }

    public static boolean a(Drawable drawable) {
        if (VERSION.SDK_INT >= 21) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    public static void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        if (VERSION.SDK_INT >= 21) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        } else {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        }
    }

    public static boolean a(Drawable drawable, int i2) {
        int i3 = VERSION.SDK_INT;
        if (i3 >= 23) {
            return drawable.setLayoutDirection(i2);
        }
        if (i3 >= 17) {
            String str = "DrawableCompat";
            if (!f1313b) {
                try {
                    f1312a = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                    f1312a.setAccessible(true);
                } catch (NoSuchMethodException e2) {
                    Log.i(str, "Failed to retrieve setLayoutDirection(int) method", e2);
                }
                f1313b = true;
            }
            Method method = f1312a;
            if (method != null) {
                try {
                    method.invoke(drawable, new Object[]{Integer.valueOf(i2)});
                    return true;
                } catch (Exception e3) {
                    Log.i(str, "Failed to invoke setLayoutDirection(int) via reflection", e3);
                    f1312a = null;
                }
            }
        }
        return false;
    }
}
