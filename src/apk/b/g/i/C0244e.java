package b.g.i;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnKeyListener;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: b.g.i.e reason: case insensitive filesystem */
/* compiled from: KeyEventDispatcher */
public class C0244e {

    /* renamed from: a reason: collision with root package name */
    private static boolean f2710a = false;

    /* renamed from: b reason: collision with root package name */
    private static Method f2711b = null;

    /* renamed from: c reason: collision with root package name */
    private static boolean f2712c = false;

    /* renamed from: d reason: collision with root package name */
    private static Field f2713d;

    /* renamed from: b.g.i.e$a */
    /* compiled from: KeyEventDispatcher */
    public interface a {
        boolean superDispatchKeyEvent(KeyEvent keyEvent);
    }

    public static boolean a(View view, KeyEvent keyEvent) {
        return B.b(view, keyEvent);
    }

    public static boolean a(a aVar, View view, Callback callback, KeyEvent keyEvent) {
        boolean z = false;
        if (aVar == null) {
            return false;
        }
        if (VERSION.SDK_INT >= 28) {
            return aVar.superDispatchKeyEvent(keyEvent);
        }
        if (callback instanceof Activity) {
            return a((Activity) callback, keyEvent);
        }
        if (callback instanceof Dialog) {
            return a((Dialog) callback, keyEvent);
        }
        if ((view != null && B.a(view, keyEvent)) || aVar.superDispatchKeyEvent(keyEvent)) {
            z = true;
        }
        return z;
    }

    private static boolean a(ActionBar actionBar, KeyEvent keyEvent) {
        if (!f2710a) {
            try {
                f2711b = actionBar.getClass().getMethod("onMenuKeyEvent", new Class[]{KeyEvent.class});
            } catch (NoSuchMethodException unused) {
            }
            f2710a = true;
        }
        Method method = f2711b;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(actionBar, new Object[]{keyEvent})).booleanValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return false;
    }

    private static boolean a(Activity activity, KeyEvent keyEvent) {
        activity.onUserInteraction();
        Window window = activity.getWindow();
        if (window.hasFeature(8)) {
            ActionBar actionBar = activity.getActionBar();
            if (keyEvent.getKeyCode() == 82 && actionBar != null && a(actionBar, keyEvent)) {
                return true;
            }
        }
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (B.a(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null, activity);
    }

    private static OnKeyListener a(Dialog dialog) {
        if (!f2712c) {
            try {
                f2713d = Dialog.class.getDeclaredField("mOnKeyListener");
                f2713d.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f2712c = true;
        }
        Field field = f2713d;
        if (field != null) {
            try {
                return (OnKeyListener) field.get(dialog);
            } catch (IllegalAccessException unused2) {
            }
        }
        return null;
    }

    private static boolean a(Dialog dialog, KeyEvent keyEvent) {
        OnKeyListener a2 = a(dialog);
        if (a2 != null && a2.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
            return true;
        }
        Window window = dialog.getWindow();
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (B.a(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(dialog, decorView != null ? decorView.getKeyDispatcherState() : null, dialog);
    }
}
