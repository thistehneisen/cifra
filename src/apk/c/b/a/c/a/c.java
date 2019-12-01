package c.b.a.c.a;

import android.animation.TypeEvaluator;

/* compiled from: ArgbEvaluatorCompat */
public class c implements TypeEvaluator<Integer> {

    /* renamed from: a reason: collision with root package name */
    private static final c f3096a = new c();

    public static c a() {
        return f3096a;
    }

    /* renamed from: a */
    public Integer evaluate(float f2, Integer num, Integer num2) {
        int intValue = num.intValue();
        float f3 = ((float) ((intValue >> 24) & 255)) / 255.0f;
        float f4 = ((float) ((intValue >> 16) & 255)) / 255.0f;
        float f5 = ((float) ((intValue >> 8) & 255)) / 255.0f;
        float f6 = ((float) (intValue & 255)) / 255.0f;
        int intValue2 = num2.intValue();
        float f7 = ((float) ((intValue2 >> 24) & 255)) / 255.0f;
        float f8 = ((float) ((intValue2 >> 16) & 255)) / 255.0f;
        float f9 = ((float) ((intValue2 >> 8) & 255)) / 255.0f;
        float pow = (float) Math.pow((double) f4, 2.2d);
        float pow2 = (float) Math.pow((double) f5, 2.2d);
        float pow3 = (float) Math.pow((double) f6, 2.2d);
        float pow4 = pow2 + ((((float) Math.pow((double) f9, 2.2d)) - pow2) * f2);
        float pow5 = pow3 + (f2 * (((float) Math.pow((double) (((float) (intValue2 & 255)) / 255.0f), 2.2d)) - pow3));
        float f10 = (f3 + ((f7 - f3) * f2)) * 255.0f;
        return Integer.valueOf((Math.round(((float) Math.pow((double) (pow + ((((float) Math.pow((double) f8, 2.2d)) - pow) * f2)), 0.45454545454545453d)) * 255.0f) << 16) | (Math.round(f10) << 24) | (Math.round(((float) Math.pow((double) pow4, 0.45454545454545453d)) * 255.0f) << 8) | Math.round(((float) Math.pow((double) pow5, 0.45454545454545453d)) * 255.0f));
    }
}
