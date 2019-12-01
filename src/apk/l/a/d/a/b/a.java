package l.a.d.a.b;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

/* compiled from: UiUtils */
public final class a {

    /* renamed from: l.a.d.a.b.a$a reason: collision with other inner class name */
    /* compiled from: UiUtils */
    public static class C0122a {
        public static DisplayMetrics a(Context context) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int i2 = 0;
            while (i2 < 5 && (displayMetrics.heightPixels <= 0 || displayMetrics.widthPixels <= 0)) {
                try {
                    Thread.sleep(500);
                    displayMetrics = context.getResources().getDisplayMetrics();
                    i2++;
                } catch (InterruptedException unused) {
                }
            }
            return displayMetrics;
        }

        public static float a(Context context, float f2) {
            return TypedValue.applyDimension(1, f2, a(context));
        }
    }

    /* compiled from: UiUtils */
    public static class b {
        public static void a(Activity activity) {
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus != null) {
                a(currentFocus);
            }
        }

        public static void b(View view) {
            view.requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(view, 1);
            }
        }

        public static void a(View view) {
            view.clearFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    public static View a(int i2, ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, false);
    }

    public static View b(int i2, ViewGroup viewGroup) {
        LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, true);
        return viewGroup.getChildAt(viewGroup.getChildCount() - 1);
    }
}
