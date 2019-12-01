package b.h.a;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

/* compiled from: CursorAdapter */
public abstract class a extends BaseAdapter implements Filterable, a {

    /* renamed from: a reason: collision with root package name */
    protected boolean f2728a;

    /* renamed from: b reason: collision with root package name */
    protected boolean f2729b;

    /* renamed from: c reason: collision with root package name */
    protected Cursor f2730c;

    /* renamed from: d reason: collision with root package name */
    protected Context f2731d;

    /* renamed from: e reason: collision with root package name */
    protected int f2732e;

    /* renamed from: f reason: collision with root package name */
    protected C0031a f2733f;

    /* renamed from: g reason: collision with root package name */
    protected DataSetObserver f2734g;

    /* renamed from: h reason: collision with root package name */
    protected b f2735h;

    /* renamed from: b.h.a.a$a reason: collision with other inner class name */
    /* compiled from: CursorAdapter */
    private class C0031a extends ContentObserver {
        C0031a() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            a.this.b();
        }
    }

    /* compiled from: CursorAdapter */
    private class b extends DataSetObserver {
        b() {
        }

        public void onChanged() {
            a aVar = a.this;
            aVar.f2728a = true;
            aVar.notifyDataSetChanged();
        }

        public void onInvalidated() {
            a aVar = a.this;
            aVar.f2728a = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z) {
        a(context, cursor, z ? 1 : 2);
    }

    public abstract View a(Context context, Cursor cursor, ViewGroup viewGroup);

    /* access modifiers changed from: 0000 */
    public void a(Context context, Cursor cursor, int i2) {
        boolean z = false;
        if ((i2 & 1) == 1) {
            i2 |= 2;
            this.f2729b = true;
        } else {
            this.f2729b = false;
        }
        if (cursor != null) {
            z = true;
        }
        this.f2730c = cursor;
        this.f2728a = z;
        this.f2731d = context;
        this.f2732e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i2 & 2) == 2) {
            this.f2733f = new C0031a();
            this.f2734g = new b();
        } else {
            this.f2733f = null;
            this.f2734g = null;
        }
        if (z) {
            C0031a aVar = this.f2733f;
            if (aVar != null) {
                cursor.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f2734g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract void a(View view, Context context, Cursor cursor);

    public Cursor b(Cursor cursor) {
        Cursor cursor2 = this.f2730c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0031a aVar = this.f2733f;
            if (aVar != null) {
                cursor2.unregisterContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f2734g;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f2730c = cursor;
        if (cursor != null) {
            C0031a aVar2 = this.f2733f;
            if (aVar2 != null) {
                cursor.registerContentObserver(aVar2);
            }
            DataSetObserver dataSetObserver2 = this.f2734g;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f2732e = cursor.getColumnIndexOrThrow("_id");
            this.f2728a = true;
            notifyDataSetChanged();
        } else {
            this.f2732e = -1;
            this.f2728a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    public abstract View b(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract CharSequence convertToString(Cursor cursor);

    public int getCount() {
        if (this.f2728a) {
            Cursor cursor = this.f2730c;
            if (cursor != null) {
                return cursor.getCount();
            }
        }
        return 0;
    }

    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f2728a) {
            return null;
        }
        this.f2730c.moveToPosition(i2);
        if (view == null) {
            view = a(this.f2731d, this.f2730c, viewGroup);
        }
        a(view, this.f2731d, this.f2730c);
        return view;
    }

    public Filter getFilter() {
        if (this.f2735h == null) {
            this.f2735h = new b(this);
        }
        return this.f2735h;
    }

    public Object getItem(int i2) {
        if (this.f2728a) {
            Cursor cursor = this.f2730c;
            if (cursor != null) {
                cursor.moveToPosition(i2);
                return this.f2730c;
            }
        }
        return null;
    }

    public long getItemId(int i2) {
        if (this.f2728a) {
            Cursor cursor = this.f2730c;
            if (cursor != null && cursor.moveToPosition(i2)) {
                return this.f2730c.getLong(this.f2732e);
            }
        }
        return 0;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f2728a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f2730c.moveToPosition(i2)) {
            if (view == null) {
                view = b(this.f2731d, this.f2730c, viewGroup);
            }
            a(view, this.f2731d, this.f2730c);
            return view;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("couldn't move cursor to position ");
            sb.append(i2);
            throw new IllegalStateException(sb.toString());
        }
    }

    public Cursor a() {
        return this.f2730c;
    }

    /* access modifiers changed from: protected */
    public void b() {
        if (this.f2729b) {
            Cursor cursor = this.f2730c;
            if (cursor != null && !cursor.isClosed()) {
                this.f2728a = this.f2730c.requery();
            }
        }
    }

    public void a(Cursor cursor) {
        Cursor b2 = b(cursor);
        if (b2 != null) {
            b2.close();
        }
    }
}
