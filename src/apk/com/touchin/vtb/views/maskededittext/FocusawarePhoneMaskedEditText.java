package com.touchin.vtb.views.maskededittext;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.touchin.vtb.R;
import com.touchin.vtb.utils.i;
import com.touchin.vtb.utils.q;
import kotlin.e.b.h;
import kotlin.m;

/* compiled from: FocusawarePhoneMaskedEditText.kt */
public final class FocusawarePhoneMaskedEditText extends FrameLayout {

    /* renamed from: a reason: collision with root package name */
    public static final a f7814a = new a(null);

    /* renamed from: b reason: collision with root package name */
    private TextWatcher f7815b;

    /* renamed from: c reason: collision with root package name */
    private kotlin.e.a.a<m> f7816c;
    /* access modifiers changed from: private */

    /* renamed from: d reason: collision with root package name */
    public final TextView f7817d;
    /* access modifiers changed from: private */

    /* renamed from: e reason: collision with root package name */
    public final MaskedEditText f7818e;
    /* access modifiers changed from: private */

    /* renamed from: f reason: collision with root package name */
    public final TextView f7819f;

    /* renamed from: g reason: collision with root package name */
    private String f7820g;

    /* compiled from: FocusawarePhoneMaskedEditText.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    public FocusawarePhoneMaskedEditText(Context context) {
        this(context, null, 0, 6, null);
    }

    public FocusawarePhoneMaskedEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ FocusawarePhoneMaskedEditText(Context context, AttributeSet attributeSet, int i2, int i3, e eVar) {
        if ((i3 & 2) != 0) {
            attributeSet = null;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        this(context, attributeSet, i2);
    }

    private final Editable getText() {
        return this.f7818e.getText();
    }

    public final kotlin.e.a.a<m> getOnClickAction() {
        return this.f7816c;
    }

    public final String getRaw() {
        return this.f7818e.getRaw();
    }

    public final TextWatcher getTextChangedListener() {
        return this.f7815b;
    }

    public final String getTextString() {
        return String.valueOf(getText());
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        h.b(parcelable, "state");
        Bundle bundle = (Bundle) parcelable;
        String string = bundle.getString("phoneString", "");
        h.a((Object) string, "getString(\"phoneString\", \"\")");
        this.f7820g = string;
        super.onRestoreInstanceState(bundle.getParcelable("super"));
        if (this.f7820g.length() > 0) {
            this.f7818e.setHint("0000000000");
            this.f7818e.setMask("+7 (###) ### – ## – ##");
            this.f7818e.setText(this.f7820g);
            this.f7818e.setEnabled(true);
            this.f7819f.setVisibility(8);
            this.f7819f.setEnabled(false);
            this.f7817d.setVisibility(0);
            return;
        }
        this.f7819f.setVisibility(0);
        this.f7819f.setEnabled(true);
        this.f7817d.setVisibility(0);
    }

    public final void setOnClickAction(kotlin.e.a.a<m> aVar) {
        h.b(aVar, "<set-?>");
        this.f7816c = aVar;
    }

    public final void setTextChangedListener(TextWatcher textWatcher) {
        this.f7818e.addTextChangedListener(textWatcher);
        this.f7815b = textWatcher;
    }

    public FocusawarePhoneMaskedEditText(Context context, AttributeSet attributeSet, int i2) {
        h.b(context, "context");
        super(context, attributeSet, i2);
        FrameLayout.inflate(context, R.layout.view_focusaware_masked_edit_text, this);
        this.f7816c = d.f7833a;
        View findViewById = findViewById(R.id.view_focusaware_masked_edit_text_hint);
        h.a((Object) findViewById, "findViewById(R.id.view_f…re_masked_edit_text_hint)");
        this.f7817d = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.view_focusaware_masked_edit_text);
        h.a((Object) findViewById2, "findViewById(R.id.view_f…usaware_masked_edit_text)");
        this.f7818e = (MaskedEditText) findViewById2;
        View findViewById3 = findViewById(R.id.view_focusaware_masked_edit_text_placeholder);
        h.a((Object) findViewById3, "findViewById(R.id.view_f…ed_edit_text_placeholder)");
        this.f7819f = (TextView) findViewById3;
        this.f7820g = "";
        this.f7817d.setText(context.getString(R.string.common_registration_phone_number_placeholder));
        b();
        this.f7818e.addTextChangedListener(new q(new a(this)));
        this.f7818e.setOnClickListener(new b(this));
        this.f7818e.setCustomSelectionActionModeCallback(new i());
        this.f7818e.setTextIsSelectable(false);
        this.f7818e.setLongClickable(false);
    }

    private final void b() {
        this.f7819f.setOnClickListener(new c(this));
    }

    /* access modifiers changed from: protected */
    public Bundle onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("super", super.onSaveInstanceState());
        bundle.putString("phoneString", getRaw());
        return bundle;
    }

    public final m a() {
        Editable text = this.f7818e.getText();
        if (text == null) {
            return null;
        }
        text.clear();
        return m.f10346a;
    }

    /* access modifiers changed from: private */
    public final void a(Editable editable) {
        Integer valueOf = Integer.valueOf(Selection.getSelectionStart(editable));
        boolean z = false;
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            int intValue = valueOf.intValue();
            Character a2 = u.a((CharSequence) "+7 (###) ### – ## – ##", intValue - 1);
            if (a2 != null) {
                if (!(a2.charValue() != '#')) {
                    a2 = null;
                }
                if (a2 != null) {
                    a2.charValue();
                    Integer valueOf2 = Integer.valueOf(s.a((CharSequence) "+7 (###) ### – ## – ##", '#', intValue, false, 4, (Object) null));
                    if (valueOf2.intValue() > 0) {
                        z = true;
                    }
                    if (!z) {
                        valueOf2 = null;
                    }
                    if (valueOf2 != null) {
                        Selection.setSelection(editable, valueOf2.intValue());
                    }
                }
            }
        }
    }
}
