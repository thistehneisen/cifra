package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import b.g.g.c;
import b.g.g.c.a.C0025a;
import b.g.h.g;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TextViewCompat */
public final class j {

    /* renamed from: a reason: collision with root package name */
    private static Field f1376a;

    /* renamed from: b reason: collision with root package name */
    private static boolean f1377b;

    /* renamed from: c reason: collision with root package name */
    private static Field f1378c;

    /* renamed from: d reason: collision with root package name */
    private static boolean f1379d;

    /* compiled from: TextViewCompat */
    private static class a implements Callback {

        /* renamed from: a reason: collision with root package name */
        private final Callback f1380a;

        /* renamed from: b reason: collision with root package name */
        private final TextView f1381b;

        /* renamed from: c reason: collision with root package name */
        private Class f1382c;

        /* renamed from: d reason: collision with root package name */
        private Method f1383d;

        /* renamed from: e reason: collision with root package name */
        private boolean f1384e;

        /* renamed from: f reason: collision with root package name */
        private boolean f1385f = false;

        a(Callback callback, TextView textView) {
            this.f1380a = callback;
            this.f1381b = textView;
        }

        private void a(Menu menu) {
            Method method;
            Context context = this.f1381b.getContext();
            PackageManager packageManager = context.getPackageManager();
            String str = "removeItemAt";
            if (!this.f1385f) {
                this.f1385f = true;
                try {
                    this.f1382c = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.f1383d = this.f1382c.getDeclaredMethod(str, new Class[]{Integer.TYPE});
                    this.f1384e = true;
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    this.f1382c = null;
                    this.f1383d = null;
                    this.f1384e = false;
                }
            }
            try {
                if (!this.f1384e || !this.f1382c.isInstance(menu)) {
                    method = menu.getClass().getDeclaredMethod(str, new Class[]{Integer.TYPE});
                } else {
                    method = this.f1383d;
                }
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        method.invoke(menu, new Object[]{Integer.valueOf(size)});
                    }
                }
                List a2 = a(context, packageManager);
                for (int i2 = 0; i2 < a2.size(); i2++) {
                    ResolveInfo resolveInfo = (ResolveInfo) a2.get(i2);
                    menu.add(0, 0, i2 + 100, resolveInfo.loadLabel(packageManager)).setIntent(a(resolveInfo, this.f1381b)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f1380a.onActionItemClicked(actionMode, menuItem);
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f1380a.onCreateActionMode(actionMode, menu);
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.f1380a.onDestroyActionMode(actionMode);
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            a(menu);
            return this.f1380a.onPrepareActionMode(actionMode, menu);
        }

        private List<ResolveInfo> a(Context context, PackageManager packageManager) {
            ArrayList arrayList = new ArrayList();
            if (!(context instanceof Activity)) {
                return arrayList;
            }
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(a(), 0)) {
                if (a(resolveInfo, context)) {
                    arrayList.add(resolveInfo);
                }
            }
            return arrayList;
        }

        private boolean a(ResolveInfo resolveInfo, Context context) {
            boolean z = true;
            if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            if (!resolveInfo.activityInfo.exported) {
                return false;
            }
            String str = resolveInfo.activityInfo.permission;
            if (!(str == null || context.checkSelfPermission(str) == 0)) {
                z = false;
            }
            return z;
        }

        private Intent a(ResolveInfo resolveInfo, TextView textView) {
            return a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !a(textView)).setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        }

        private boolean a(TextView textView) {
            return (textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled();
        }

        private Intent a() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }
    }

    private static Field a(String str) {
        Field field = null;
        try {
            field = TextView.class.getDeclaredField(str);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not retrieve ");
            sb.append(str);
            sb.append(" field.");
            Log.e("TextViewCompat", sb.toString());
            return field;
        }
    }

    public static void b(TextView textView, int i2) {
        int i3;
        g.a(i2);
        FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (VERSION.SDK_INT < 16 || textView.getIncludeFontPadding()) {
            i3 = fontMetricsInt.bottom;
        } else {
            i3 = fontMetricsInt.descent;
        }
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i2 - i3);
        }
    }

    public static int c(TextView textView) {
        if (VERSION.SDK_INT >= 16) {
            return textView.getMaxLines();
        }
        if (!f1379d) {
            f1378c = a("mMaxMode");
            f1379d = true;
        }
        Field field = f1378c;
        if (field != null && a(field, textView) == 1) {
            if (!f1377b) {
                f1376a = a("mMaximum");
                f1377b = true;
            }
            Field field2 = f1376a;
            if (field2 != null) {
                return a(field2, textView);
            }
        }
        return -1;
    }

    public static void d(TextView textView, int i2) {
        if (VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i2);
        } else {
            textView.setTextAppearance(textView.getContext(), i2);
        }
    }

    private static TextDirectionHeuristic e(TextView textView) {
        TextDirectionHeuristic textDirectionHeuristic;
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        boolean z = false;
        if (VERSION.SDK_INT < 28 || (textView.getInputType() & 15) != 3) {
            if (textView.getLayoutDirection() == 1) {
                z = true;
            }
            switch (textView.getTextDirection()) {
                case 2:
                    return TextDirectionHeuristics.ANYRTL_LTR;
                case 3:
                    return TextDirectionHeuristics.LTR;
                case 4:
                    return TextDirectionHeuristics.RTL;
                case 5:
                    return TextDirectionHeuristics.LOCALE;
                case 6:
                    return TextDirectionHeuristics.FIRSTSTRONG_LTR;
                case 7:
                    return TextDirectionHeuristics.FIRSTSTRONG_RTL;
                default:
                    if (z) {
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    } else {
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                    }
                    return textDirectionHeuristic;
            }
        } else {
            byte directionality = Character.getDirectionality(DecimalFormatSymbols.getInstance(textView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
            if (directionality == 1 || directionality == 2) {
                return TextDirectionHeuristics.RTL;
            }
            return TextDirectionHeuristics.LTR;
        }
    }

    private static int a(Field field, TextView textView) {
        try {
            return field.getInt(textView);
        } catch (IllegalAccessException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not retrieve value of ");
            sb.append(field.getName());
            sb.append(" field.");
            Log.d("TextViewCompat", sb.toString());
            return -1;
        }
    }

    public static b.g.g.c.a d(TextView textView) {
        if (VERSION.SDK_INT >= 28) {
            return new b.g.g.c.a(textView.getTextMetricsParams());
        }
        C0025a aVar = new C0025a(new TextPaint(textView.getPaint()));
        if (VERSION.SDK_INT >= 23) {
            aVar.a(textView.getBreakStrategy());
            aVar.b(textView.getHyphenationFrequency());
        }
        if (VERSION.SDK_INT >= 18) {
            aVar.a(e(textView));
        }
        return aVar.a();
    }

    public static void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        int i2 = VERSION.SDK_INT;
        if (i2 >= 18) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else if (i2 >= 17) {
            boolean z = true;
            if (textView.getLayoutDirection() != 1) {
                z = false;
            }
            Drawable drawable5 = z ? drawable3 : drawable;
            if (!z) {
                drawable = drawable3;
            }
            textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
        } else {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }
    }

    public static Callback a(TextView textView, Callback callback) {
        int i2 = VERSION.SDK_INT;
        return (i2 < 26 || i2 > 27 || (callback instanceof a)) ? callback : new a(callback, textView);
    }

    public static int b(TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    public static void c(TextView textView, int i2) {
        g.a(i2);
        int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
        if (i2 != fontMetricsInt) {
            textView.setLineSpacing((float) (i2 - fontMetricsInt), 1.0f);
        }
    }

    public static void a(TextView textView, int i2) {
        int i3;
        g.a(i2);
        if (VERSION.SDK_INT >= 28) {
            textView.setFirstBaselineToTopHeight(i2);
            return;
        }
        FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (VERSION.SDK_INT < 16 || textView.getIncludeFontPadding()) {
            i3 = fontMetricsInt.top;
        } else {
            i3 = fontMetricsInt.ascent;
        }
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), i2 - (-i3), textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static int a(TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    public static void a(TextView textView, b.g.g.c.a aVar) {
        if (VERSION.SDK_INT >= 18) {
            textView.setTextDirection(a(aVar.c()));
        }
        if (VERSION.SDK_INT < 23) {
            float textScaleX = aVar.d().getTextScaleX();
            textView.getPaint().set(aVar.d());
            if (textScaleX == textView.getTextScaleX()) {
                textView.setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            textView.setTextScaleX(textScaleX);
            return;
        }
        textView.getPaint().set(aVar.d());
        textView.setBreakStrategy(aVar.a());
        textView.setHyphenationFrequency(aVar.b());
    }

    public static void a(TextView textView, c cVar) {
        if (d(textView).a(cVar.a())) {
            textView.setText(cVar);
            return;
        }
        throw new IllegalArgumentException("Given text can not be applied to TextView.");
    }

    private static int a(TextDirectionHeuristic textDirectionHeuristic) {
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL || textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 6;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
            return 7;
        }
        return 1;
    }
}
