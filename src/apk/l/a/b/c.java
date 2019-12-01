package l.a.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.x;
import b.g.a.a;
import java.util.Arrays;
import kotlin.e.b.h;

/* compiled from: ViewHolder.kt */
public final class c {
    public static final <T extends View> T a(x xVar, int i2) {
        h.b(xVar, "$this$findViewById");
        T findViewById = xVar.itemView.findViewById(i2);
        h.a((Object) findViewById, "itemView.findViewById(resId)");
        return findViewById;
    }

    public static final int b(x xVar, int i2) {
        h.b(xVar, "$this$getColor");
        return a.a(a(xVar), i2);
    }

    public static final Drawable c(x xVar, int i2) {
        h.b(xVar, "$this$getDrawable");
        return a.c(a(xVar), i2);
    }

    public static final Context a(x xVar) {
        h.b(xVar, "$this$context");
        View view = xVar.itemView;
        h.a((Object) view, "itemView");
        Context context = view.getContext();
        h.a((Object) context, "itemView.context");
        return context;
    }

    public static final String a(x xVar, int i2, Object... objArr) {
        h.b(xVar, "$this$getString");
        h.b(objArr, "args");
        String string = a(xVar).getString(i2, Arrays.copyOf(objArr, objArr.length));
        h.a((Object) string, "context.getString(resId, *args)");
        return string;
    }
}
