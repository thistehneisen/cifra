package androidx.fragment.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;

/* renamed from: androidx.fragment.app.e reason: case insensitive filesystem */
/* compiled from: DialogFragment */
public class C0190e extends Fragment implements OnCancelListener, OnDismissListener {

    /* renamed from: a reason: collision with root package name */
    private Handler f1522a;

    /* renamed from: b reason: collision with root package name */
    private Runnable f1523b = new C0189d(this);

    /* renamed from: c reason: collision with root package name */
    int f1524c = 0;

    /* renamed from: d reason: collision with root package name */
    int f1525d = 0;

    /* renamed from: e reason: collision with root package name */
    boolean f1526e = true;

    /* renamed from: f reason: collision with root package name */
    boolean f1527f = true;

    /* renamed from: g reason: collision with root package name */
    int f1528g = -1;

    /* renamed from: h reason: collision with root package name */
    Dialog f1529h;

    /* renamed from: i reason: collision with root package name */
    boolean f1530i;

    /* renamed from: j reason: collision with root package name */
    boolean f1531j;

    /* renamed from: k reason: collision with root package name */
    boolean f1532k;

    public Dialog a(Bundle bundle) {
        throw null;
    }

    public void a(C0200o oVar, String str) {
        this.f1531j = false;
        this.f1532k = true;
        F a2 = oVar.a();
        a2.a((Fragment) this, str);
        a2.a();
    }

    public int b() {
        return this.f1525d;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.f1527f) {
            View view = getView();
            if (view != null) {
                if (view.getParent() == null) {
                    this.f1529h.setContentView(view);
                } else {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
            }
            C0195j activity = getActivity();
            if (activity != null) {
                this.f1529h.setOwnerActivity(activity);
            }
            this.f1529h.setCancelable(this.f1526e);
            this.f1529h.setOnCancelListener(this);
            this.f1529h.setOnDismissListener(this);
            if (bundle != null) {
                Bundle bundle2 = bundle.getBundle("android:savedDialogState");
                if (bundle2 != null) {
                    this.f1529h.onRestoreInstanceState(bundle2);
                }
            }
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (!this.f1532k) {
            this.f1531j = false;
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1522a = new Handler();
        this.f1527f = this.mContainerId == 0;
        if (bundle != null) {
            this.f1524c = bundle.getInt("android:style", 0);
            this.f1525d = bundle.getInt("android:theme", 0);
            this.f1526e = bundle.getBoolean("android:cancelable", true);
            this.f1527f = bundle.getBoolean("android:showsDialog", this.f1527f);
            this.f1528g = bundle.getInt("android:backStackId", -1);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.f1529h;
        if (dialog != null) {
            this.f1530i = true;
            dialog.setOnDismissListener(null);
            this.f1529h.dismiss();
            if (!this.f1531j) {
                onDismiss(this.f1529h);
            }
            this.f1529h = null;
        }
    }

    public void onDetach() {
        super.onDetach();
        if (!this.f1532k && !this.f1531j) {
            this.f1531j = true;
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.f1530i) {
            a(true, true);
        }
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        if (!this.f1527f) {
            return super.onGetLayoutInflater(bundle);
        }
        this.f1529h = a(bundle);
        Dialog dialog = this.f1529h;
        String str = "layout_inflater";
        if (dialog == null) {
            return (LayoutInflater) this.mHost.c().getSystemService(str);
        }
        a(dialog, this.f1524c);
        return (LayoutInflater) this.f1529h.getContext().getSystemService(str);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Dialog dialog = this.f1529h;
        if (dialog != null) {
            Bundle onSaveInstanceState = dialog.onSaveInstanceState();
            if (onSaveInstanceState != null) {
                bundle.putBundle("android:savedDialogState", onSaveInstanceState);
            }
        }
        int i2 = this.f1524c;
        if (i2 != 0) {
            bundle.putInt("android:style", i2);
        }
        int i3 = this.f1525d;
        if (i3 != 0) {
            bundle.putInt("android:theme", i3);
        }
        boolean z = this.f1526e;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.f1527f;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i4 = this.f1528g;
        if (i4 != -1) {
            bundle.putInt("android:backStackId", i4);
        }
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = this.f1529h;
        if (dialog != null) {
            this.f1530i = false;
            dialog.show();
        }
    }

    public void onStop() {
        super.onStop();
        Dialog dialog = this.f1529h;
        if (dialog != null) {
            dialog.hide();
        }
    }

    public void b(boolean z) {
        this.f1527f = z;
    }

    public void a() {
        a(false, false);
    }

    /* access modifiers changed from: 0000 */
    public void a(boolean z, boolean z2) {
        if (!this.f1531j) {
            this.f1531j = true;
            this.f1532k = false;
            Dialog dialog = this.f1529h;
            if (dialog != null) {
                dialog.setOnDismissListener(null);
                this.f1529h.dismiss();
                if (!z2) {
                    if (Looper.myLooper() == this.f1522a.getLooper()) {
                        onDismiss(this.f1529h);
                    } else {
                        this.f1522a.post(this.f1523b);
                    }
                }
            }
            this.f1530i = true;
            if (this.f1528g >= 0) {
                requireFragmentManager().a(this.f1528g, 1);
                this.f1528g = -1;
            } else {
                F a2 = requireFragmentManager().a();
                a2.c(this);
                if (z) {
                    a2.b();
                } else {
                    a2.a();
                }
            }
        }
    }

    public void a(boolean z) {
        this.f1526e = z;
        Dialog dialog = this.f1529h;
        if (dialog != null) {
            dialog.setCancelable(z);
        }
    }

    public void a(Dialog dialog, int i2) {
        if (!(i2 == 1 || i2 == 2)) {
            if (i2 == 3) {
                dialog.getWindow().addFlags(24);
            } else {
                return;
            }
        }
        dialog.requestWindowFeature(1);
    }
}
