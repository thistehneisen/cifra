package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.p;
import java.lang.reflect.Method;

/* compiled from: MenuPopupWindow */
public class U extends S implements T {
    private static Method K;
    private T L;

    /* compiled from: MenuPopupWindow */
    public static class a extends L {
        final int o;
        final int p;
        private T q;
        private MenuItem r;

        public a(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (VERSION.SDK_INT < 17 || 1 != configuration.getLayoutDirection()) {
                this.o = 22;
                this.p = 21;
                return;
            }
            this.o = 21;
            this.p = 22;
        }

        public /* bridge */ /* synthetic */ int a(int i2, int i3, int i4, int i5, int i6) {
            return super.a(i2, i3, i4, i5, i6);
        }

        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        public boolean onHoverEvent(MotionEvent motionEvent) {
            int i2;
            k kVar;
            if (this.q != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i2 = headerViewListAdapter.getHeadersCount();
                    kVar = (k) headerViewListAdapter.getWrappedAdapter();
                } else {
                    i2 = 0;
                    kVar = (k) adapter;
                }
                p pVar = null;
                if (motionEvent.getAction() != 10) {
                    int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (pointToPosition != -1) {
                        int i3 = pointToPosition - i2;
                        if (i3 >= 0 && i3 < kVar.getCount()) {
                            pVar = kVar.getItem(i3);
                        }
                    }
                }
                MenuItem menuItem = this.r;
                if (menuItem != pVar) {
                    l b2 = kVar.b();
                    if (menuItem != null) {
                        this.q.b(b2, menuItem);
                    }
                    this.r = pVar;
                    if (pVar != null) {
                        this.q.a(b2, pVar);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i2 == this.o) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i2 != this.p) {
                return super.onKeyDown(i2, keyEvent);
            } else {
                setSelection(-1);
                ((k) getAdapter()).b().a(false);
                return true;
            }
        }

        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(T t) {
            this.q = t;
        }

        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }

        public /* bridge */ /* synthetic */ boolean a(MotionEvent motionEvent, int i2) {
            return super.a(motionEvent, i2);
        }
    }

    static {
        try {
            K = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public U(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    /* access modifiers changed from: 0000 */
    public L a(Context context, boolean z) {
        a aVar = new a(context, z);
        aVar.setHoverListener(this);
        return aVar;
    }

    public void b(Object obj) {
        if (VERSION.SDK_INT >= 23) {
            this.J.setExitTransition((Transition) obj);
        }
    }

    public void c(boolean z) {
        Method method = K;
        if (method != null) {
            try {
                method.invoke(this.J, new Object[]{Boolean.valueOf(z)});
            } catch (Exception unused) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    public void a(Object obj) {
        if (VERSION.SDK_INT >= 23) {
            this.J.setEnterTransition((Transition) obj);
        }
    }

    public void b(l lVar, MenuItem menuItem) {
        T t = this.L;
        if (t != null) {
            t.b(lVar, menuItem);
        }
    }

    public void a(T t) {
        this.L = t;
    }

    public void a(l lVar, MenuItem menuItem) {
        T t = this.L;
        if (t != null) {
            t.a(lVar, menuItem);
        }
    }
}
