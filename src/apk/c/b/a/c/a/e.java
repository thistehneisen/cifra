package c.b.a.c.a;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Property;
import java.util.WeakHashMap;

/* compiled from: DrawableAlphaProperty */
public class e extends Property<Drawable, Integer> {

    /* renamed from: a reason: collision with root package name */
    public static final Property<Drawable, Integer> f3098a = new e();

    /* renamed from: b reason: collision with root package name */
    private final WeakHashMap<Drawable, Integer> f3099b = new WeakHashMap<>();

    private e() {
        super(Integer.class, "drawableAlphaCompat");
    }

    /* renamed from: a */
    public Integer get(Drawable drawable) {
        if (VERSION.SDK_INT >= 19) {
            return Integer.valueOf(drawable.getAlpha());
        }
        if (this.f3099b.containsKey(drawable)) {
            return (Integer) this.f3099b.get(drawable);
        }
        return Integer.valueOf(255);
    }

    /* renamed from: a */
    public void set(Drawable drawable, Integer num) {
        if (VERSION.SDK_INT < 19) {
            this.f3099b.put(drawable, num);
        }
        drawable.setAlpha(num.intValue());
    }
}
