package androidx.appcompat.app;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import androidx.appcompat.app.AlertController.RecycleListView;
import androidx.appcompat.app.AlertController.a;

/* renamed from: androidx.appcompat.app.j reason: case insensitive filesystem */
/* compiled from: AlertController */
class C0143j extends CursorAdapter {

    /* renamed from: a reason: collision with root package name */
    private final int f487a;

    /* renamed from: b reason: collision with root package name */
    private final int f488b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ RecycleListView f489c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ AlertController f490d;

    /* renamed from: e reason: collision with root package name */
    final /* synthetic */ a f491e;

    C0143j(a aVar, Context context, Cursor cursor, boolean z, RecycleListView recycleListView, AlertController alertController) {
        this.f491e = aVar;
        this.f489c = recycleListView;
        this.f490d = alertController;
        super(context, cursor, z);
        Cursor cursor2 = getCursor();
        this.f487a = cursor2.getColumnIndexOrThrow(this.f491e.L);
        this.f488b = cursor2.getColumnIndexOrThrow(this.f491e.M);
    }

    public void bindView(View view, Context context, Cursor cursor) {
        ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f487a));
        RecycleListView recycleListView = this.f489c;
        int position = cursor.getPosition();
        boolean z = true;
        if (cursor.getInt(this.f488b) != 1) {
            z = false;
        }
        recycleListView.setItemChecked(position, z);
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f491e.f396b.inflate(this.f490d.M, viewGroup, false);
    }
}
