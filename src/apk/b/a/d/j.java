package b.a.d;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window.Callback;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

/* compiled from: WindowCallbackWrapper */
public class j implements Callback {

    /* renamed from: a reason: collision with root package name */
    final Callback f2236a;

    public j(Callback callback) {
        if (callback != null) {
            this.f2236a = callback;
            return;
        }
        throw new IllegalArgumentException("Window callback may not be null");
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f2236a.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f2236a.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f2236a.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f2236a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f2236a.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f2236a.dispatchTrackballEvent(motionEvent);
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.f2236a.onActionModeFinished(actionMode);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.f2236a.onActionModeStarted(actionMode);
    }

    public void onAttachedToWindow() {
        this.f2236a.onAttachedToWindow();
    }

    public void onContentChanged() {
        this.f2236a.onContentChanged();
    }

    public boolean onCreatePanelMenu(int i2, Menu menu) {
        return this.f2236a.onCreatePanelMenu(i2, menu);
    }

    public View onCreatePanelView(int i2) {
        return this.f2236a.onCreatePanelView(i2);
    }

    public void onDetachedFromWindow() {
        this.f2236a.onDetachedFromWindow();
    }

    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        return this.f2236a.onMenuItemSelected(i2, menuItem);
    }

    public boolean onMenuOpened(int i2, Menu menu) {
        return this.f2236a.onMenuOpened(i2, menu);
    }

    public void onPanelClosed(int i2, Menu menu) {
        this.f2236a.onPanelClosed(i2, menu);
    }

    public void onPointerCaptureChanged(boolean z) {
        this.f2236a.onPointerCaptureChanged(z);
    }

    public boolean onPreparePanel(int i2, View view, Menu menu) {
        return this.f2236a.onPreparePanel(i2, view, menu);
    }

    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i2) {
        this.f2236a.onProvideKeyboardShortcuts(list, menu, i2);
    }

    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.f2236a.onSearchRequested(searchEvent);
    }

    public void onWindowAttributesChanged(LayoutParams layoutParams) {
        this.f2236a.onWindowAttributesChanged(layoutParams);
    }

    public void onWindowFocusChanged(boolean z) {
        this.f2236a.onWindowFocusChanged(z);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f2236a.onWindowStartingActionMode(callback);
    }

    public boolean onSearchRequested() {
        return this.f2236a.onSearchRequested();
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
        return this.f2236a.onWindowStartingActionMode(callback, i2);
    }
}
