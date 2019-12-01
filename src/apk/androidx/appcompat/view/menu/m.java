package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.appcompat.app.C0146m;
import androidx.appcompat.view.menu.v.a;
import b.a.g;

/* compiled from: MenuDialogHelper */
class m implements OnKeyListener, OnClickListener, OnDismissListener, a {

    /* renamed from: a reason: collision with root package name */
    private l f659a;

    /* renamed from: b reason: collision with root package name */
    private C0146m f660b;

    /* renamed from: c reason: collision with root package name */
    j f661c;

    /* renamed from: d reason: collision with root package name */
    private a f662d;

    public m(l lVar) {
        this.f659a = lVar;
    }

    public void a(IBinder iBinder) {
        l lVar = this.f659a;
        C0146m.a aVar = new C0146m.a(lVar.e());
        this.f661c = new j(aVar.getContext(), g.abc_list_menu_item_layout);
        this.f661c.a((a) this);
        this.f659a.a((v) this.f661c);
        aVar.setAdapter(this.f661c.b(), this);
        View i2 = lVar.i();
        if (i2 != null) {
            aVar.setCustomTitle(i2);
        } else {
            aVar.setIcon(lVar.g()).setTitle(lVar.h());
        }
        aVar.setOnKeyListener(this);
        this.f660b = aVar.create();
        this.f660b.setOnDismissListener(this);
        LayoutParams attributes = this.f660b.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f660b.show();
    }

    public void onClick(DialogInterface dialogInterface, int i2) {
        this.f659a.a((MenuItem) (p) this.f661c.b().getItem(i2), 0);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f661c.a(this.f659a, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        if (i2 == 82 || i2 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window = this.f660b.getWindow();
                if (window != null) {
                    View decorView = window.getDecorView();
                    if (decorView != null) {
                        DispatcherState keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null) {
                            keyDispatcherState.startTracking(keyEvent, this);
                            return true;
                        }
                    }
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                Window window2 = this.f660b.getWindow();
                if (window2 != null) {
                    View decorView2 = window2.getDecorView();
                    if (decorView2 != null) {
                        DispatcherState keyDispatcherState2 = decorView2.getKeyDispatcherState();
                        if (keyDispatcherState2 != null && keyDispatcherState2.isTracking(keyEvent)) {
                            this.f659a.a(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.f659a.performShortcut(i2, keyEvent, 0);
    }

    public void a() {
        C0146m mVar = this.f660b;
        if (mVar != null) {
            mVar.dismiss();
        }
    }

    public void a(l lVar, boolean z) {
        if (z || lVar == this.f659a) {
            a();
        }
        a aVar = this.f662d;
        if (aVar != null) {
            aVar.a(lVar, z);
        }
    }

    public boolean a(l lVar) {
        a aVar = this.f662d;
        if (aVar != null) {
            return aVar.a(lVar);
        }
        return false;
    }
}
