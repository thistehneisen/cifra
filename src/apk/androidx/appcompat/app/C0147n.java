package androidx.appcompat.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import androidx.appcompat.widget.Fa;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.h;
import androidx.core.app.o;
import androidx.core.app.o.a;
import androidx.fragment.app.C0195j;
import b.a.d.b;

/* renamed from: androidx.appcompat.app.n reason: case insensitive filesystem */
/* compiled from: AppCompatActivity */
public class C0147n extends C0195j implements o, a, C0136c {
    private p mDelegate;
    private Resources mResources;
    private int mThemeId = 0;

    private boolean performMenuItemShortcut(int i2, KeyEvent keyEvent) {
        if (VERSION.SDK_INT < 26 && !keyEvent.isCtrlPressed() && !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) && keyEvent.getRepeatCount() == 0 && !KeyEvent.isModifierKey(keyEvent.getKeyCode())) {
            Window window = getWindow();
            if (!(window == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent))) {
                return true;
            }
        }
        return false;
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        getDelegate().a(view, layoutParams);
    }

    public void closeOptionsMenu() {
        C0134a supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.e()) {
            super.closeOptionsMenu();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        C0134a supportActionBar = getSupportActionBar();
        if (keyCode != 82 || supportActionBar == null || !supportActionBar.a(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public <T extends View> T findViewById(int i2) {
        return getDelegate().a(i2);
    }

    public p getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = p.a((Activity) this, (o) this);
        }
        return this.mDelegate;
    }

    public C0135b getDrawerToggleDelegate() {
        return getDelegate().c();
    }

    public MenuInflater getMenuInflater() {
        return getDelegate().d();
    }

    public Resources getResources() {
        if (this.mResources == null && Fa.b()) {
            this.mResources = new Fa(this, super.getResources());
        }
        Resources resources = this.mResources;
        return resources == null ? super.getResources() : resources;
    }

    public C0134a getSupportActionBar() {
        return getDelegate().e();
    }

    public Intent getSupportParentActivityIntent() {
        return h.a(this);
    }

    public void invalidateOptionsMenu() {
        getDelegate().g();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getDelegate().a(configuration);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    public void onContentChanged() {
        onSupportContentChanged();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        p delegate = getDelegate();
        delegate.f();
        delegate.a(bundle);
        if (delegate.a()) {
            int i2 = this.mThemeId;
            if (i2 != 0) {
                if (VERSION.SDK_INT >= 23) {
                    onApplyThemeResource(getTheme(), this.mThemeId, false);
                } else {
                    setTheme(i2);
                }
            }
        }
        super.onCreate(bundle);
    }

    public void onCreateSupportNavigateUpTaskStack(o oVar) {
        oVar.a((Activity) this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        getDelegate().h();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (performMenuItemShortcut(i2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public final boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        C0134a supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.g() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    public boolean onMenuOpened(int i2, Menu menu) {
        return super.onMenuOpened(i2, menu);
    }

    public void onPanelClosed(int i2, Menu menu) {
        super.onPanelClosed(i2, menu);
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        getDelegate().b(bundle);
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        getDelegate().i();
    }

    public void onPrepareSupportNavigateUpTaskStack(o oVar) {
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        getDelegate().c(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        getDelegate().j();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        getDelegate().k();
    }

    public void onSupportActionModeFinished(b bVar) {
    }

    public void onSupportActionModeStarted(b bVar) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (supportShouldUpRecreateTask(supportParentActivityIntent)) {
            o a2 = o.a((Context) this);
            onCreateSupportNavigateUpTaskStack(a2);
            onPrepareSupportNavigateUpTaskStack(a2);
            a2.e();
            try {
                androidx.core.app.b.a(this);
            } catch (IllegalStateException unused) {
                finish();
            }
        } else {
            supportNavigateUpTo(supportParentActivityIntent);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onTitleChanged(CharSequence charSequence, int i2) {
        super.onTitleChanged(charSequence, i2);
        getDelegate().a(charSequence);
    }

    public b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }

    public void openOptionsMenu() {
        C0134a supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.k()) {
            super.openOptionsMenu();
        }
    }

    public void setContentView(int i2) {
        getDelegate().c(i2);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        getDelegate().a(toolbar);
    }

    @Deprecated
    public void setSupportProgress(int i2) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z) {
    }

    public void setTheme(int i2) {
        super.setTheme(i2);
        this.mThemeId = i2;
    }

    public b startSupportActionMode(b.a aVar) {
        return getDelegate().a(aVar);
    }

    public void supportInvalidateOptionsMenu() {
        getDelegate().g();
    }

    public void supportNavigateUpTo(Intent intent) {
        h.a((Activity) this, intent);
    }

    public boolean supportRequestWindowFeature(int i2) {
        return getDelegate().b(i2);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return h.b((Activity) this, intent);
    }

    public void setContentView(View view) {
        getDelegate().a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        getDelegate().b(view, layoutParams);
    }
}
