package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

/* renamed from: androidx.appcompat.app.m reason: case insensitive filesystem */
/* compiled from: AlertDialog */
public class C0146m extends C implements DialogInterface {

    /* renamed from: c reason: collision with root package name */
    final AlertController f497c = new AlertController(getContext(), this, getWindow());

    /* renamed from: androidx.appcompat.app.m$a */
    /* compiled from: AlertDialog */
    public static class a {
        private final androidx.appcompat.app.AlertController.a P;
        private final int mTheme;

        public a(Context context) {
            this(context, C0146m.a(context, 0));
        }

        public C0146m create() {
            C0146m mVar = new C0146m(this.P.f395a, this.mTheme);
            this.P.a(mVar.f497c);
            mVar.setCancelable(this.P.r);
            if (this.P.r) {
                mVar.setCanceledOnTouchOutside(true);
            }
            mVar.setOnCancelListener(this.P.s);
            mVar.setOnDismissListener(this.P.t);
            OnKeyListener onKeyListener = this.P.u;
            if (onKeyListener != null) {
                mVar.setOnKeyListener(onKeyListener);
            }
            return mVar;
        }

        public Context getContext() {
            return this.P.f395a;
        }

        public a setAdapter(ListAdapter listAdapter, OnClickListener onClickListener) {
            androidx.appcompat.app.AlertController.a aVar = this.P;
            aVar.w = listAdapter;
            aVar.x = onClickListener;
            return this;
        }

        public a setCancelable(boolean z) {
            this.P.r = z;
            return this;
        }

        public a setCursor(Cursor cursor, OnClickListener onClickListener, String str) {
            androidx.appcompat.app.AlertController.a aVar = this.P;
            aVar.K = cursor;
            aVar.L = str;
            aVar.x = onClickListener;
            return this;
        }

        public a setCustomTitle(View view) {
            this.P.f401g = view;
            return this;
        }

        public a setIcon(int i2) {
            this.P.f397c = i2;
            return this;
        }

        public a setIconAttribute(int i2) {
            TypedValue typedValue = new TypedValue();
            this.P.f395a.getTheme().resolveAttribute(i2, typedValue, true);
            this.P.f397c = typedValue.resourceId;
            return this;
        }

        @Deprecated
        public a setInverseBackgroundForced(boolean z) {
            this.P.N = z;
            return this;
        }

        public a setItems(int i2, OnClickListener onClickListener) {
            androidx.appcompat.app.AlertController.a aVar = this.P;
            aVar.v = aVar.f395a.getResources().getTextArray(i2);
            this.P.x = onClickListener;
            return this;
        }

        public a setMessage(int i2) {
            androidx.appcompat.app.AlertController.a aVar = this.P;
            aVar.f402h = aVar.f395a.getText(i2);
            return this;
        }

        public a setMultiChoiceItems(int i2, boolean[] zArr, OnMultiChoiceClickListener onMultiChoiceClickListener) {
            androidx.appcompat.app.AlertController.a aVar = this.P;
            aVar.v = aVar.f395a.getResources().getTextArray(i2);
            androidx.appcompat.app.AlertController.a aVar2 = this.P;
            aVar2.J = onMultiChoiceClickListener;
            aVar2.F = zArr;
            aVar2.G = true;
            return this;
        }

        public a setNegativeButton(int i2, OnClickListener onClickListener) {
            androidx.appcompat.app.AlertController.a aVar = this.P;
            aVar.f406l = aVar.f395a.getText(i2);
            this.P.n = onClickListener;
            return this;
        }

        public a setNegativeButtonIcon(Drawable drawable) {
            this.P.m = drawable;
            return this;
        }

        public a setNeutralButton(int i2, OnClickListener onClickListener) {
            androidx.appcompat.app.AlertController.a aVar = this.P;
            aVar.o = aVar.f395a.getText(i2);
            this.P.q = onClickListener;
            return this;
        }

        public a setNeutralButtonIcon(Drawable drawable) {
            this.P.p = drawable;
            return this;
        }

        public a setOnCancelListener(OnCancelListener onCancelListener) {
            this.P.s = onCancelListener;
            return this;
        }

        public a setOnDismissListener(OnDismissListener onDismissListener) {
            this.P.t = onDismissListener;
            return this;
        }

        public a setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
            this.P.O = onItemSelectedListener;
            return this;
        }

        public a setOnKeyListener(OnKeyListener onKeyListener) {
            this.P.u = onKeyListener;
            return this;
        }

        public a setPositiveButton(int i2, OnClickListener onClickListener) {
            androidx.appcompat.app.AlertController.a aVar = this.P;
            aVar.f403i = aVar.f395a.getText(i2);
            this.P.f405k = onClickListener;
            return this;
        }

        public a setPositiveButtonIcon(Drawable drawable) {
            this.P.f404j = drawable;
            return this;
        }

        public a setRecycleOnMeasureEnabled(boolean z) {
            this.P.Q = z;
            return this;
        }

        public a setSingleChoiceItems(int i2, int i3, OnClickListener onClickListener) {
            androidx.appcompat.app.AlertController.a aVar = this.P;
            aVar.v = aVar.f395a.getResources().getTextArray(i2);
            androidx.appcompat.app.AlertController.a aVar2 = this.P;
            aVar2.x = onClickListener;
            aVar2.I = i3;
            aVar2.H = true;
            return this;
        }

        public a setTitle(int i2) {
            androidx.appcompat.app.AlertController.a aVar = this.P;
            aVar.f400f = aVar.f395a.getText(i2);
            return this;
        }

        public a setView(int i2) {
            androidx.appcompat.app.AlertController.a aVar = this.P;
            aVar.z = null;
            aVar.y = i2;
            aVar.E = false;
            return this;
        }

        public C0146m show() {
            C0146m create = create();
            create.show();
            return create;
        }

        public a(Context context, int i2) {
            this.P = new androidx.appcompat.app.AlertController.a(new ContextThemeWrapper(context, C0146m.a(context, i2)));
            this.mTheme = i2;
        }

        public a setIcon(Drawable drawable) {
            this.P.f398d = drawable;
            return this;
        }

        public a setMessage(CharSequence charSequence) {
            this.P.f402h = charSequence;
            return this;
        }

        public a setTitle(CharSequence charSequence) {
            this.P.f400f = charSequence;
            return this;
        }

        public a setItems(CharSequence[] charSequenceArr, OnClickListener onClickListener) {
            androidx.appcompat.app.AlertController.a aVar = this.P;
            aVar.v = charSequenceArr;
            aVar.x = onClickListener;
            return this;
        }

        public a setNegativeButton(CharSequence charSequence, OnClickListener onClickListener) {
            androidx.appcompat.app.AlertController.a aVar = this.P;
            aVar.f406l = charSequence;
            aVar.n = onClickListener;
            return this;
        }

        public a setNeutralButton(CharSequence charSequence, OnClickListener onClickListener) {
            androidx.appcompat.app.AlertController.a aVar = this.P;
            aVar.o = charSequence;
            aVar.q = onClickListener;
            return this;
        }

        public a setPositiveButton(CharSequence charSequence, OnClickListener onClickListener) {
            androidx.appcompat.app.AlertController.a aVar = this.P;
            aVar.f403i = charSequence;
            aVar.f405k = onClickListener;
            return this;
        }

        public a setView(View view) {
            androidx.appcompat.app.AlertController.a aVar = this.P;
            aVar.z = view;
            aVar.y = 0;
            aVar.E = false;
            return this;
        }

        public a setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, OnMultiChoiceClickListener onMultiChoiceClickListener) {
            androidx.appcompat.app.AlertController.a aVar = this.P;
            aVar.v = charSequenceArr;
            aVar.J = onMultiChoiceClickListener;
            aVar.F = zArr;
            aVar.G = true;
            return this;
        }

        public a setSingleChoiceItems(Cursor cursor, int i2, String str, OnClickListener onClickListener) {
            androidx.appcompat.app.AlertController.a aVar = this.P;
            aVar.K = cursor;
            aVar.x = onClickListener;
            aVar.I = i2;
            aVar.L = str;
            aVar.H = true;
            return this;
        }

        @Deprecated
        public a setView(View view, int i2, int i3, int i4, int i5) {
            androidx.appcompat.app.AlertController.a aVar = this.P;
            aVar.z = view;
            aVar.y = 0;
            aVar.E = true;
            aVar.A = i2;
            aVar.B = i3;
            aVar.C = i4;
            aVar.D = i5;
            return this;
        }

        public a setMultiChoiceItems(Cursor cursor, String str, String str2, OnMultiChoiceClickListener onMultiChoiceClickListener) {
            androidx.appcompat.app.AlertController.a aVar = this.P;
            aVar.K = cursor;
            aVar.J = onMultiChoiceClickListener;
            aVar.M = str;
            aVar.L = str2;
            aVar.G = true;
            return this;
        }

        public a setSingleChoiceItems(CharSequence[] charSequenceArr, int i2, OnClickListener onClickListener) {
            androidx.appcompat.app.AlertController.a aVar = this.P;
            aVar.v = charSequenceArr;
            aVar.x = onClickListener;
            aVar.I = i2;
            aVar.H = true;
            return this;
        }

        public a setSingleChoiceItems(ListAdapter listAdapter, int i2, OnClickListener onClickListener) {
            androidx.appcompat.app.AlertController.a aVar = this.P;
            aVar.w = listAdapter;
            aVar.x = onClickListener;
            aVar.I = i2;
            aVar.H = true;
            return this;
        }
    }

    protected C0146m(Context context, int i2) {
        super(context, a(context, i2));
    }

    static int a(Context context, int i2) {
        if (((i2 >>> 24) & 255) >= 1) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(b.a.a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public Button b(int i2) {
        return this.f497c.a(i2);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f497c.b();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (this.f497c.a(i2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (this.f497c.b(i2, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f497c.b(charSequence);
    }

    public ListView b() {
        return this.f497c.a();
    }
}
