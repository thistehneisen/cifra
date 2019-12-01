package b.g.a.a;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import kotlin.e.b.h;

/* compiled from: TypedArray.kt */
public final class i {
    public static final Drawable a(TypedArray typedArray, int i2) {
        h.b(typedArray, "$receiver");
        c(typedArray, i2);
        Drawable drawable = typedArray.getDrawable(i2);
        h.a((Object) drawable, "getDrawable(index)");
        return drawable;
    }

    public static final String b(TypedArray typedArray, int i2) {
        h.b(typedArray, "$receiver");
        c(typedArray, i2);
        String string = typedArray.getString(i2);
        if (string != null) {
            return string;
        }
        throw new IllegalStateException("Attribute value could not be coerced to String.");
    }

    private static final void c(TypedArray typedArray, int i2) {
        if (!typedArray.hasValue(i2)) {
            throw new IllegalArgumentException("Attribute not defined in set.");
        }
    }
}
