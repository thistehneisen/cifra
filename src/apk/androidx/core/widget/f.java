package androidx.core.widget;

import android.widget.ListView;

/* compiled from: ListViewAutoScrollHelper */
public class f extends a {
    private final ListView s;

    public f(ListView listView) {
        super(listView);
        this.s = listView;
    }

    public void a(int i2, int i3) {
        g.b(this.s, i3);
    }

    public boolean a(int i2) {
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038 A[RETURN] */
    public boolean b(int i2) {
        ListView listView = this.s;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i3 = firstVisiblePosition + childCount;
        if (i2 > 0) {
            if (i3 < count || listView.getChildAt(childCount - 1).getBottom() > listView.getHeight()) {
                return true;
            }
            return false;
        } else if (i2 >= 0) {
            return false;
        } else {
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }
}
