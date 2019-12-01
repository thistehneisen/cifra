package b.h.a;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: ResourceCursorAdapter */
public abstract class c extends a {

    /* renamed from: i reason: collision with root package name */
    private int f2739i;

    /* renamed from: j reason: collision with root package name */
    private int f2740j;

    /* renamed from: k reason: collision with root package name */
    private LayoutInflater f2741k;

    @Deprecated
    public c(Context context, int i2, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f2740j = i2;
        this.f2739i = i2;
        this.f2741k = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f2741k.inflate(this.f2740j, viewGroup, false);
    }

    public View b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f2741k.inflate(this.f2739i, viewGroup, false);
    }
}
