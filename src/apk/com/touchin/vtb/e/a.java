package com.touchin.vtb.e;

import com.touchin.vtb.api.Amount;
import com.touchin.vtb.utils.a.a.C0078a;
import com.touchin.vtb.utils.l;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Currency;
import java.util.Locale;
import kotlin.e.b.h;
import kotlin.e.b.q;
import l.a.d.b.a.c;

/* compiled from: Amount.kt */
public final class a {
    public static /* synthetic */ String a(Amount amount, boolean z, boolean z2, Locale locale, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        if ((i2 & 4) != 0) {
            locale = l.f7628b.a();
        }
        return a(amount, z, z2, locale);
    }

    public static final String a(Amount amount, boolean z, boolean z2, Locale locale) {
        String str;
        int i2;
        h.b(amount, "$this$printWithCurrency");
        h.b(locale, "locale");
        NumberFormat currencyInstance = DecimalFormat.getCurrencyInstance(locale);
        BigDecimal abs = z ? amount.c().abs() : amount.c();
        boolean z3 = abs.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) != 0;
        try {
            C0078a aVar = com.touchin.vtb.utils.a.a.f7610c;
            String b2 = amount.b();
            h.a((Object) b2, "this.currencyCode");
            com.touchin.vtb.utils.a.a a2 = aVar.a(b2);
            String name = a2 != null ? a2.name() : null;
            h.a((Object) currencyInstance, "decimalFormat");
            if (name == null) {
                name = amount.b();
            }
            currencyInstance.setCurrency(Currency.getInstance(name));
            if (!z3 || !z2) {
                i2 = 0;
            } else {
                Currency currency = currencyInstance.getCurrency();
                h.a((Object) currency, "decimalFormat.currency");
                i2 = currency.getDefaultFractionDigits();
            }
            currencyInstance.setMinimumFractionDigits(i2);
            if (h.a((Object) locale, (Object) l.f7628b.a())) {
                DecimalFormat decimalFormat = (DecimalFormat) currencyInstance;
                DecimalFormatSymbols instance = DecimalFormatSymbols.getInstance(locale);
                h.a((Object) instance, "formatSymbols");
                instance.setCurrencySymbol("₽");
                decimalFormat.setDecimalFormatSymbols(instance);
            }
            str = currencyInstance.format(abs);
            h.a((Object) str, "decimalFormat.format(sumAmount)");
        } catch (IllegalArgumentException e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unsupported currency format: ");
            sb.append(amount.b());
            c.a(e2, sb.toString(), new Object[0]);
            int i3 = (!z3 || !z2) ? 0 : 2;
            q qVar = q.f10310a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("%,.");
            sb2.append(i3);
            sb2.append("f ₽");
            String sb3 = sb2.toString();
            Object[] objArr = {abs};
            str = String.format(locale, sb3, Arrays.copyOf(objArr, objArr.length));
            h.a((Object) str, "java.lang.String.format(locale, format, *args)");
        }
        return n.a(str, ',', '.', false, 4, (Object) null);
    }

    public static final boolean a(Amount amount) {
        h.b(amount, "$this$isSumNegate");
        return amount.c().signum() < 0;
    }
}
