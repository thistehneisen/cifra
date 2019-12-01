package com.touchin.vtb.utils;

import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import kotlin.e.b.h;

/* compiled from: EmptyActionModeCallback.kt */
public final class i implements Callback {
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        h.b(actionMode, "mode");
        h.b(menuItem, "item");
        return false;
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        h.b(actionMode, "mode");
        h.b(menu, "menu");
        return false;
    }

    public void onDestroyActionMode(ActionMode actionMode) {
        h.b(actionMode, "mode");
    }

    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        h.b(actionMode, "mode");
        h.b(menu, "menu");
        return false;
    }
}
