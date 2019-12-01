package io.intercom.android.sdk.utilities;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EdgeEffect;
import androidx.recyclerview.widget.RecyclerView;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.twig.Twig;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ViewUtils {
    private static final Twig twig = LumberMill.getLogger();

    public static void removeGlobalLayoutListener(View view, OnGlobalLayoutListener onGlobalLayoutListener) {
        if (VERSION.SDK_INT >= 16) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
        } else {
            view.getViewTreeObserver().removeGlobalOnLayoutListener(onGlobalLayoutListener);
        }
    }

    public static void requestLayoutIfPossible(View view) {
        if (VERSION.SDK_INT < 18 || !view.isInLayout()) {
            view.requestLayout();
        }
    }

    public static void setOverScrollColour(RecyclerView recyclerView, int i2) {
        if (VERSION.SDK_INT >= 21) {
            Class<RecyclerView> cls = RecyclerView.class;
            try {
                for (String declaredMethod : new String[]{"ensureTopGlow", "ensureBottomGlow"}) {
                    Method declaredMethod2 = cls.getDeclaredMethod(declaredMethod, new Class[0]);
                    declaredMethod2.setAccessible(true);
                    declaredMethod2.invoke(recyclerView, new Object[0]);
                }
                for (String declaredField : new String[]{"mTopGlow", "mBottomGlow"}) {
                    Field declaredField2 = cls.getDeclaredField(declaredField);
                    declaredField2.setAccessible(true);
                    Object obj = declaredField2.get(recyclerView);
                    Field declaredField3 = obj.getClass().getDeclaredField("mEdgeEffect");
                    declaredField3.setAccessible(true);
                    ((EdgeEffect) declaredField3.get(obj)).setColor(i2);
                }
            } catch (Exception unused) {
                twig.d("Could not set overscroll colour", new Object[0]);
            }
        }
    }

    public static void waitForViewAttachment(final View view, final Runnable runnable) {
        if (view.getHeight() == 0) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    ViewUtils.removeGlobalLayoutListener(view, this);
                    runnable.run();
                }
            });
        } else {
            runnable.run();
        }
    }
}
