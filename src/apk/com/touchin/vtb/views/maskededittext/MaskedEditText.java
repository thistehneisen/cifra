package com.touchin.vtb.views.maskededittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View.OnFocusChangeListener;
import androidx.appcompat.widget.C0176p;
import b.g.a.a.i;
import com.touchin.vtb.f;
import io.intercom.android.sdk.views.holder.AttributeType;
import kotlin.TypeCastException;
import kotlin.e.b.h;
import kotlin.g;
import kotlin.k;
import ru.touchin.roboswag.core.utils.ShouldNotHappenException;

/* compiled from: MaskedEditText.kt */
public final class MaskedEditText extends C0176p implements TextWatcher {

    /* renamed from: c reason: collision with root package name */
    private String f7821c;

    /* renamed from: d reason: collision with root package name */
    private String f7822d;

    /* renamed from: e reason: collision with root package name */
    private String f7823e;

    /* renamed from: f reason: collision with root package name */
    private boolean f7824f;

    /* renamed from: g reason: collision with root package name */
    private char f7825g;

    /* renamed from: h reason: collision with root package name */
    private boolean f7826h;

    /* renamed from: i reason: collision with root package name */
    private boolean f7827i;

    /* renamed from: j reason: collision with root package name */
    private boolean f7828j;

    /* renamed from: k reason: collision with root package name */
    private int f7829k;

    /* renamed from: l reason: collision with root package name */
    private boolean f7830l;
    private boolean m;
    private int n;
    private int o;
    /* access modifiers changed from: private */
    public boolean p;
    private int[] q;
    private h r;
    private int[] s;

    public MaskedEditText(Context context) {
        this(context, null, 0, 6, null);
    }

    public MaskedEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ MaskedEditText(Context context, AttributeSet attributeSet, int i2, int i3, e eVar) {
        if ((i3 & 2) != 0) {
            attributeSet = null;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        this(context, attributeSet, i2);
    }

    private final int b() {
        int[] iArr = this.s;
        String str = "maskToRaw";
        if (iArr != null) {
            int length = iArr.length - 1;
            while (length >= 0) {
                int[] iArr2 = this.s;
                if (iArr2 == null) {
                    h.b(str);
                    throw null;
                } else if (iArr2[length] != -1) {
                    return length;
                } else {
                    length--;
                }
            }
            throw new ShouldNotHappenException("Mask must contain at least one representation char");
        }
        h.b(str);
        throw null;
    }

    private final void c() {
        int[] iArr = new int[this.f7821c.length()];
        this.s = new int[this.f7821c.length()];
        int length = this.f7821c.length();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            String str = "maskToRaw";
            if (this.f7821c.charAt(i4) == this.f7825g) {
                iArr[i3] = i4;
                int[] iArr2 = this.s;
                if (iArr2 != null) {
                    int i5 = i3 + 1;
                    iArr2[i4] = i3;
                    i3 = i5;
                } else {
                    h.b(str);
                    throw null;
                }
            } else {
                int[] iArr3 = this.s;
                if (iArr3 != null) {
                    iArr3[i4] = -1;
                } else {
                    h.b(str);
                    throw null;
                }
            }
        }
        this.q = new int[i3];
        while (i2 < i3) {
            int[] iArr4 = this.q;
            if (iArr4 != null) {
                iArr4[i2] = iArr[i2];
                i2++;
            } else {
                h.b("rawToMask");
                throw null;
            }
        }
    }

    private final boolean d() {
        return getHint() != null;
    }

    /* access modifiers changed from: private */
    public final int e() {
        h hVar = this.r;
        String str = "rawText";
        if (hVar != null) {
            String str2 = "rawToMask";
            if (hVar.b() == this.n) {
                int[] iArr = this.q;
                if (iArr != null) {
                    h hVar2 = this.r;
                    if (hVar2 != null) {
                        return iArr[hVar2.b() - 1] + 1;
                    }
                    h.b(str);
                    throw null;
                }
                h.b(str2);
                throw null;
            }
            int[] iArr2 = this.q;
            if (iArr2 != null) {
                h hVar3 = this.r;
                if (hVar3 != null) {
                    return c(iArr2[hVar3.b()]);
                }
                h.b(str);
                throw null;
            }
            h.b(str2);
            throw null;
        }
        h.b(str);
        throw null;
    }

    private final String f() {
        int i2;
        h hVar = this.r;
        String str = "rawText";
        if (hVar != null) {
            int b2 = hVar.b();
            int[] iArr = this.q;
            String str2 = "rawToMask";
            if (iArr != null) {
                if (b2 >= iArr.length) {
                    i2 = this.f7821c.length();
                } else if (iArr != null) {
                    h hVar2 = this.r;
                    if (hVar2 != null) {
                        i2 = iArr[hVar2.b()];
                    } else {
                        h.b(str);
                        throw null;
                    }
                } else {
                    h.b(str2);
                    throw null;
                }
                char[] cArr = new char[i2];
                int i3 = 0;
                int length = cArr.length;
                while (i3 < length) {
                    int[] iArr2 = this.s;
                    if (iArr2 != null) {
                        int i4 = iArr2[i3];
                        if (i4 == -1) {
                            cArr[i3] = this.f7821c.charAt(i3);
                        } else {
                            h hVar3 = this.r;
                            if (hVar3 != null) {
                                cArr[i3] = hVar3.a(i4);
                            } else {
                                h.b(str);
                                throw null;
                            }
                        }
                        i3++;
                    } else {
                        h.b("maskToRaw");
                        throw null;
                    }
                }
                return new String(cArr);
            }
            h.b(str2);
            throw null;
        }
        h.b(str);
        throw null;
    }

    private final CharSequence g() {
        boolean z;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int[] iArr = this.q;
        String str = "rawToMask";
        if (iArr != null) {
            int i2 = iArr[0];
            int length = this.f7821c.length();
            int i3 = 0;
            while (true) {
                String str2 = "rawText";
                if (i3 < length) {
                    int[] iArr2 = this.s;
                    String str3 = "maskToRaw";
                    if (iArr2 != null) {
                        int i4 = iArr2[i3];
                        if (i4 != -1) {
                            h hVar = this.r;
                            if (hVar == null) {
                                h.b(str2);
                                throw null;
                            } else if (i4 < hVar.b()) {
                                h hVar2 = this.r;
                                if (hVar2 != null) {
                                    spannableStringBuilder.append(hVar2.a(i4));
                                } else {
                                    h.b(str2);
                                    throw null;
                                }
                            } else {
                                CharSequence hint = getHint();
                                int[] iArr3 = this.s;
                                if (iArr3 != null) {
                                    spannableStringBuilder.append(hint.charAt(iArr3[i3]));
                                } else {
                                    h.b(str3);
                                    throw null;
                                }
                            }
                        } else {
                            spannableStringBuilder.append(this.f7821c.charAt(i3));
                        }
                        h hVar3 = this.r;
                        if (hVar3 != null) {
                            if (hVar3.b() > 0) {
                                h hVar4 = this.r;
                                if (hVar4 != null) {
                                    int b2 = hVar4.b();
                                    int[] iArr4 = this.q;
                                    if (iArr4 != null) {
                                        if (b2 < iArr4.length) {
                                            if (iArr4 != null) {
                                                h hVar5 = this.r;
                                                if (hVar5 == null) {
                                                    h.b(str2);
                                                    throw null;
                                                } else if (i3 >= iArr4[hVar5.b()]) {
                                                    z = true;
                                                    if ((this.f7824f && z) || (!this.f7824f && i3 >= i2)) {
                                                        spannableStringBuilder.setSpan(new ForegroundColorSpan(getCurrentHintTextColor()), i3, i3 + 1, 0);
                                                    }
                                                }
                                            } else {
                                                h.b(str);
                                                throw null;
                                            }
                                        }
                                        z = false;
                                        spannableStringBuilder.setSpan(new ForegroundColorSpan(getCurrentHintTextColor()), i3, i3 + 1, 0);
                                    } else {
                                        h.b(str);
                                        throw null;
                                    }
                                } else {
                                    h.b(str2);
                                    throw null;
                                }
                            }
                            i3++;
                        } else {
                            h.b(str2);
                            throw null;
                        }
                    } else {
                        h.b(str3);
                        throw null;
                    }
                } else {
                    h hVar6 = this.r;
                    if (hVar6 != null) {
                        if (hVar6.b() == 0) {
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(getCurrentHintTextColor()), 2, spannableStringBuilder.length(), 0);
                        }
                        return spannableStringBuilder;
                    }
                    h.b(str2);
                    throw null;
                }
            }
        } else {
            h.b(str);
            throw null;
        }
    }

    private final int getTextLength() {
        Editable text = getText();
        if (text != null) {
            return text.length();
        }
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
        if (r2.b() == 0) goto L_0x0030;
     */
    public void afterTextChanged(Editable editable) {
        h.b(editable, "s");
        if (!this.f7828j && this.f7826h && this.f7827i) {
            this.f7828j = true;
            if (d()) {
                if (!this.f7824f) {
                    h hVar = this.r;
                    if (hVar == null) {
                        h.b("rawText");
                        throw null;
                    }
                }
                setText(g());
                this.p = false;
                setSelection(this.f7829k);
                this.f7826h = false;
                this.f7827i = false;
                this.f7828j = false;
                this.m = false;
            }
            setText(f());
            this.p = false;
            setSelection(this.f7829k);
            this.f7826h = false;
            this.f7827i = false;
            this.f7828j = false;
            this.m = false;
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        h.b(charSequence, "s");
        if (!this.f7826h) {
            this.f7826h = true;
            if (i2 > this.o) {
                this.m = true;
            }
            g a2 = a(i4 == 0 ? a(i2) : i2, i2 + i3);
            if (a2.b() != -1) {
                h hVar = this.r;
                if (hVar != null) {
                    hVar.a(a2);
                } else {
                    h.b("rawText");
                    throw null;
                }
            }
            if (i3 > 0) {
                this.f7829k = d(i2);
            }
        }
    }

    public final String getAllowedChars() {
        return this.f7822d;
    }

    public final char getCharRepresentation() {
        return this.f7825g;
    }

    public final String getDeniedChars() {
        return this.f7823e;
    }

    public final boolean getKeepHint() {
        return this.f7824f;
    }

    public final String getMaskText() {
        return this.f7821c;
    }

    public final String getRaw() {
        h hVar = this.r;
        if (hVar != null) {
            return hVar.a();
        }
        h.b("rawText");
        throw null;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        h.b(parcelable, "state");
        Bundle bundle = (Bundle) parcelable;
        this.f7824f = bundle.getBoolean("keepHint", false);
        super.onRestoreInstanceState(bundle.getParcelable("super"));
        setText(bundle.getString(AttributeType.TEXT));
    }

    /* access modifiers changed from: protected */
    public void onSelectionChanged(int i2, int i3) {
        if (this.f7830l && !this.p) {
            g b2 = b(i2, i3);
            int intValue = ((Number) b2.c()).intValue();
            i3 = ((Number) b2.d()).intValue();
            i2 = intValue;
        } else if (this.f7830l && this.p) {
            h hVar = this.r;
            if (hVar == null) {
                h.b("rawText");
                throw null;
            } else if (i2 > hVar.b() - 1) {
                int b3 = b(i2);
                int b4 = b(i3);
                if (b3 >= 0 && b4 < getTextLength()) {
                    setSelection(b3, b4);
                }
            }
        }
        super.onSelectionChanged(i2, i3);
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        int i5;
        h.b(charSequence, "s");
        if (!this.f7827i && this.f7826h) {
            this.f7827i = true;
            if (!this.m && i4 > 0) {
                int[] iArr = this.s;
                if (iArr != null) {
                    int i6 = iArr[c(i2)];
                    String obj = charSequence.subSequence(i2, i4 + i2).toString();
                    h hVar = this.r;
                    if (hVar != null) {
                        int a2 = hVar.a(a(obj), i6, this.n);
                        if (this.f7830l) {
                            int i7 = i6 + a2;
                            int[] iArr2 = this.q;
                            String str = "rawToMask";
                            if (iArr2 != null) {
                                if (i7 >= iArr2.length) {
                                    i5 = this.o + 1;
                                } else if (iArr2 != null) {
                                    i5 = iArr2[i7];
                                } else {
                                    h.b(str);
                                    throw null;
                                }
                                this.f7829k = c(i5);
                            } else {
                                h.b(str);
                                throw null;
                            }
                        }
                    } else {
                        h.b("rawText");
                        throw null;
                    }
                } else {
                    h.b("maskToRaw");
                    throw null;
                }
            }
        }
    }

    public final void setAllowedChars(String str) {
        this.f7822d = str;
    }

    public final void setCharRepresentation(char c2) {
        this.f7825g = c2;
    }

    public final void setDeniedChars(String str) {
        this.f7823e = str;
    }

    public final void setHintVisible(boolean z) {
        this.f7824f = z;
        setText(getRaw());
    }

    public final void setKeepHint(boolean z) {
        this.f7824f = z;
    }

    public final void setMask(String str) {
        h.b(str, "mask");
        this.f7821c = str;
        a();
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        h.b(onFocusChangeListener, "listener");
        super.setOnFocusChangeListener(new f(this, onFocusChangeListener));
    }

    public MaskedEditText(Context context, AttributeSet attributeSet, int i2) {
        h.b(context, "context");
        super(context, attributeSet, i2);
        this.f7821c = "#";
        char c2 = '#';
        this.f7825g = '#';
        addTextChangedListener(this);
        int[] iArr = f.MaskedEditText;
        h.a((Object) iArr, "R.styleable.MaskedEditText");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        this.f7821c = i.b(obtainStyledAttributes, 4);
        this.f7822d = obtainStyledAttributes.getString(0);
        this.f7823e = obtainStyledAttributes.getString(2);
        this.f7824f = obtainStyledAttributes.getBoolean(3, false);
        String string = obtainStyledAttributes.getString(1);
        if (string != null) {
            c2 = string.charAt(0);
        }
        this.f7825g = c2;
        a();
        obtainStyledAttributes.recycle();
        setOnFocusChangeListener(e.f7834a);
    }

    private final int d(int i2) {
        while (i2 >= 0) {
            int[] iArr = this.s;
            if (iArr != null) {
                if (iArr[i2] != -1) {
                    break;
                }
                i2--;
                if (i2 < 0) {
                    return c(0);
                }
            } else {
                h.b("maskToRaw");
                throw null;
            }
        }
        return i2;
    }

    public Bundle onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("super", super.onSaveInstanceState());
        bundle.putString(AttributeType.TEXT, getRaw());
        bundle.putBoolean("keepHint", this.f7824f);
        return bundle;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006e  */
    private final void a() {
        int[] iArr;
        this.f7830l = false;
        c();
        this.r = new h();
        int[] iArr2 = this.q;
        if (iArr2 != null) {
            this.f7829k = iArr2[0];
            this.f7826h = true;
            this.f7827i = true;
            this.f7828j = true;
            if (d()) {
                h hVar = this.r;
                if (hVar != null) {
                    if (hVar.a().length() == 0) {
                        setText(g());
                        this.f7826h = false;
                        this.f7827i = false;
                        this.f7828j = false;
                        iArr = this.s;
                        if (iArr == null) {
                            this.n = iArr[d(this.f7821c.length() - 1)] + 1;
                            this.o = b();
                            this.f7830l = true;
                            return;
                        }
                        h.b("maskToRaw");
                        throw null;
                    }
                } else {
                    h.b("rawText");
                    throw null;
                }
            }
            setText(f());
            this.f7826h = false;
            this.f7827i = false;
            this.f7828j = false;
            iArr = this.s;
            if (iArr == null) {
            }
        } else {
            h.b("rawToMask");
            throw null;
        }
    }

    private final g<Integer, Integer> b(int i2, int i3) {
        int b2 = b(i2);
        int b3 = b(i3);
        if (b2 > getTextLength()) {
            b2 = getTextLength();
        }
        if (b2 < 0) {
            b2 = 0;
        }
        if (b3 > getTextLength()) {
            b3 = getTextLength();
        }
        if (b3 < 0) {
            b3 = 0;
        }
        setSelection(b2, b3);
        this.p = true;
        return k.a(Integer.valueOf(b2), Integer.valueOf(b3));
    }

    private final int c(int i2) {
        while (i2 < this.o) {
            int[] iArr = this.s;
            if (iArr != null) {
                if (iArr[i2] != -1) {
                    break;
                }
                i2++;
            } else {
                h.b("maskToRaw");
                throw null;
            }
        }
        int i3 = this.o;
        return i2 > i3 ? i3 + 1 : i2;
    }

    private final int b(int i2) {
        if (i2 > e()) {
            return e();
        }
        return c(i2);
    }

    private final int a(int i2) {
        while (i2 > 0) {
            int[] iArr = this.s;
            if (iArr != null) {
                if (iArr[i2] != -1) {
                    break;
                }
                i2--;
            } else {
                h.b("maskToRaw");
                throw null;
            }
        }
        return i2;
    }

    private final g a(int i2, int i3) {
        g gVar = new g(0, 0, 3, null);
        int i4 = i2;
        while (i4 <= i3 && i4 < this.f7821c.length()) {
            int[] iArr = this.s;
            String str = "maskToRaw";
            if (iArr != null) {
                if (iArr[i4] != -1) {
                    if (gVar.b() == -1) {
                        int[] iArr2 = this.s;
                        if (iArr2 != null) {
                            gVar.b(iArr2[i4]);
                        } else {
                            h.b(str);
                            throw null;
                        }
                    }
                    int[] iArr3 = this.s;
                    if (iArr3 != null) {
                        gVar.a(iArr3[i4]);
                    } else {
                        h.b(str);
                        throw null;
                    }
                }
                i4++;
            } else {
                h.b(str);
                throw null;
            }
        }
        if (i3 == this.f7821c.length()) {
            h hVar = this.r;
            if (hVar != null) {
                gVar.a(hVar.b());
            } else {
                h.b("rawText");
                throw null;
            }
        }
        if (gVar.b() == gVar.a() && i2 < i3) {
            int d2 = d(gVar.b() - 1);
            if (d2 < gVar.b()) {
                gVar.b(d2);
            }
        }
        return gVar;
    }

    private final String a(String str) {
        String str2 = this.f7823e;
        String str3 = "null cannot be cast to non-null type java.lang.String";
        String str4 = "(this as java.lang.String).toCharArray()";
        if (str2 != null) {
            if (str2 != null) {
                char[] charArray = str2.toCharArray();
                h.a((Object) charArray, str4);
                String str5 = str;
                for (char valueOf : charArray) {
                    str5 = n.a(str5, String.valueOf(valueOf), "", false, 4, (Object) null);
                }
                str = str5;
            } else {
                throw new TypeCastException(str3);
            }
        }
        String str6 = this.f7822d;
        if (str6 == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        if (str != null) {
            char[] charArray2 = str.toCharArray();
            h.a((Object) charArray2, str4);
            for (char c2 : charArray2) {
                if (s.a((CharSequence) str6, (CharSequence) String.valueOf(c2), false, 2, (Object) null)) {
                    sb.append(c2);
                }
            }
            String sb2 = sb.toString();
            h.a((Object) sb2, "builder.toString()");
            return sb2;
        }
        throw new TypeCastException(str3);
    }
}
