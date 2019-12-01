package com.touchin.vtb.views.focus_edit_text;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.touchin.vtb.R;
import com.touchin.vtb.f;
import com.touchin.vtb.utils.q;
import kotlin.e.b.h;
import kotlin.m;
import l.a.b.g;
import l.a.d.a.b.a.C0122a;
import l.a.d.b.a.c;

/* compiled from: FocusawareEditText.kt */
public final class FocusawareEditText extends FrameLayout {

    /* renamed from: a reason: collision with root package name */
    public static final a f7789a = new a(null);

    /* renamed from: b reason: collision with root package name */
    private boolean f7790b;

    /* renamed from: c reason: collision with root package name */
    private boolean f7791c;

    /* renamed from: d reason: collision with root package name */
    private kotlin.e.a.a<m> f7792d;

    /* renamed from: e reason: collision with root package name */
    private kotlin.e.a.a<m> f7793e;
    /* access modifiers changed from: private */

    /* renamed from: f reason: collision with root package name */
    public final TextView f7794f;
    /* access modifiers changed from: private */

    /* renamed from: g reason: collision with root package name */
    public final EditText f7795g;
    /* access modifiers changed from: private */

    /* renamed from: h reason: collision with root package name */
    public final TextView f7796h;

    /* renamed from: i reason: collision with root package name */
    private final AppCompatImageView f7797i;
    /* access modifiers changed from: private */

    /* renamed from: j reason: collision with root package name */
    public final int f7798j;
    /* access modifiers changed from: private */

    /* renamed from: k reason: collision with root package name */
    public final int f7799k;

    /* renamed from: l reason: collision with root package name */
    private final Drawable f7800l;
    private final Drawable m;
    private final Typeface n;
    /* access modifiers changed from: private */
    public String o;

    /* compiled from: FocusawareEditText.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    /* compiled from: FocusawareEditText.kt */
    public enum b {
        TEXT(65536),
        PASSWORD(129);
        

        /* renamed from: d reason: collision with root package name */
        public static final a f7804d = null;
        private final int inputType;

        /* compiled from: FocusawareEditText.kt */
        public static final class a {
            private a() {
            }

            public final b a(int i2) {
                if (i2 >= 0 && i2 < b.values().length) {
                    return b.values()[i2];
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected resIndex ");
                sb.append(i2);
                c.a(sb.toString());
                return b.TEXT;
            }

            public /* synthetic */ a(e eVar) {
                this();
            }
        }

        static {
            f7804d = new a(null);
        }

        private b(int i2) {
            this.inputType = i2;
        }

        public final int a() {
            return this.inputType;
        }
    }

    public FocusawareEditText(Context context) {
        this(context, null, 0, 6, null);
    }

    public FocusawareEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ FocusawareEditText(Context context, AttributeSet attributeSet, int i2, int i3, e eVar) {
        if ((i3 & 2) != 0) {
            attributeSet = null;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        this(context, attributeSet, i2);
    }

    /* access modifiers changed from: private */
    public final void setInputType(int i2) {
        this.f7795g.setInputType(i2);
        this.f7795g.setTypeface(this.n);
        if (this.f7791c) {
            AppCompatImageView appCompatImageView = this.f7797i;
            int i3 = i2 == b.PASSWORD.a() ? R.drawable.common_show_password_icon : i2 == b.TEXT.a() ? R.drawable.common_hide_password_icon : 0;
            appCompatImageView.setImageResource(i3);
        }
    }

    public final kotlin.e.a.a<m> getOnEditTextClickListener() {
        return this.f7793e;
    }

    public final kotlin.e.a.a<m> getOnFocusAction() {
        return this.f7792d;
    }

    public final String getText() {
        Editable text = this.f7795g.getText();
        String obj = text != null ? text.toString() : null;
        return obj != null ? obj : "";
    }

    public final void setErrorSet(boolean z) {
        this.f7790b = z;
        this.f7795g.setBackground(z ? this.m : this.f7800l);
    }

    public final void setHint(String str) {
        h.b(str, "hintString");
        this.f7794f.setText(str);
    }

    public final void setOnEditTextClickListener(kotlin.e.a.a<m> aVar) {
        h.b(aVar, "<set-?>");
        this.f7793e = aVar;
    }

    public final void setOnFocusAction(kotlin.e.a.a<m> aVar) {
        h.b(aVar, "<set-?>");
        this.f7792d = aVar;
    }

    public final void setPassword(boolean z) {
        this.f7791c = z;
    }

    public final void setText(String str) {
        h.b(str, "value");
        this.f7795g.setText(str);
    }

    public FocusawareEditText(Context context, AttributeSet attributeSet, int i2) {
        h.b(context, "context");
        super(context, attributeSet, i2);
        FrameLayout.inflate(context, R.layout.view_focusaware_edit_text, this);
        this.f7792d = f.f7808a;
        this.f7793e = e.f7807a;
        View findViewById = findViewById(R.id.view_focusaware_edit_text_hint);
        h.a((Object) findViewById, "findViewById(R.id.view_focusaware_edit_text_hint)");
        this.f7794f = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.view_focusaware_edit_text);
        h.a((Object) findViewById2, "findViewById(R.id.view_focusaware_edit_text)");
        this.f7795g = (EditText) findViewById2;
        View findViewById3 = findViewById(R.id.view_focusaware_edit_text_placeholder);
        h.a((Object) findViewById3, "findViewById(R.id.view_f…re_edit_text_placeholder)");
        this.f7796h = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.view_focusaware_edit_text_icon);
        h.a((Object) findViewById4, "findViewById(R.id.view_focusaware_edit_text_icon)");
        this.f7797i = (AppCompatImageView) findViewById4;
        this.f7798j = b.g.a.a.a(context, (int) R.color.common_text_gray);
        this.f7799k = b.g.a.a.a(context, (int) R.color.common_black);
        this.f7800l = b.g.a.a.c(context, R.drawable.common_startup_edit_text_selector);
        this.m = b.g.a.a.c(context, R.drawable.common_startup_edit_text_error_selector);
        this.n = this.f7795g.getTypeface();
        String str = "";
        this.o = str;
        int[] iArr = f.FocusawareEditText;
        h.a((Object) iArr, "R.styleable.FocusawareEditText");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        this.f7794f.setText(obtainStyledAttributes.getString(0));
        this.f7796h.setText(this.f7794f.getText());
        String string = obtainStyledAttributes.getString(1);
        if (string == null) {
            string = str;
        }
        this.o = string;
        int a2 = b.f7804d.a(obtainStyledAttributes.getInt(2, b.TEXT.ordinal())).a();
        if (a2 == b.PASSWORD.a()) {
            this.f7791c = true;
        }
        setInputType(a2);
        obtainStyledAttributes.recycle();
        b();
        a();
        a((TextWatcher) new q(new a(this)));
        this.f7795g.setOnClickListener(new b(this));
    }

    private final void b() {
        boolean z = this.f7795g.getInputType() == b.PASSWORD.a();
        EditText editText = this.f7795g;
        editText.setPadding(editText.getPaddingLeft(), editText.getPaddingTop(), (int) C0122a.a(getContext(), z ? 32.0f : 0.0f), editText.getPaddingBottom());
        g.a(this.f7797i, new d(this));
    }

    public final void a(TextWatcher textWatcher) {
        h.b(textWatcher, "listener");
        this.f7795g.addTextChangedListener(textWatcher);
    }

    private final void a() {
        this.f7795g.setOnFocusChangeListener(new c(this));
    }
}
