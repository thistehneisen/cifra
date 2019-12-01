package b.h.a;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

/* compiled from: CursorFilter */
class b extends Filter {

    /* renamed from: a reason: collision with root package name */
    a f2738a;

    /* compiled from: CursorFilter */
    interface a {
        Cursor a();

        Cursor a(CharSequence charSequence);

        void a(Cursor cursor);

        CharSequence convertToString(Cursor cursor);
    }

    b(a aVar) {
        this.f2738a = aVar;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f2738a.convertToString((Cursor) obj);
    }

    /* access modifiers changed from: protected */
    public FilterResults performFiltering(CharSequence charSequence) {
        Cursor a2 = this.f2738a.a(charSequence);
        FilterResults filterResults = new FilterResults();
        if (a2 != null) {
            filterResults.count = a2.getCount();
            filterResults.values = a2;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    /* access modifiers changed from: protected */
    public void publishResults(CharSequence charSequence, FilterResults filterResults) {
        Cursor a2 = this.f2738a.a();
        Object obj = filterResults.values;
        if (obj != null && obj != a2) {
            this.f2738a.a((Cursor) obj);
        }
    }
}
