package androidx.core.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.ListView;

/* compiled from: ListViewCompat */
public final class g {
    public static boolean a(ListView listView, int i2) {
        if (VERSION.SDK_INT >= 19) {
            return listView.canScrollList(i2);
        }
        int childCount = listView.getChildCount();
        boolean z = false;
        if (childCount == 0) {
            return false;
        }
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (i2 > 0) {
            int bottom = listView.getChildAt(childCount - 1).getBottom();
            if (firstVisiblePosition + childCount < listView.getCount() || bottom > listView.getHeight() - listView.getListPaddingBottom()) {
                z = true;
            }
            return z;
        }
        int top = listView.getChildAt(0).getTop();
        if (firstVisiblePosition > 0 || top < listView.getListPaddingTop()) {
            z = true;
        }
        return z;
    }

    public static void b(ListView listView, int i2) {
        if (VERSION.SDK_INT >= 19) {
            listView.scrollListBy(i2);
        } else {
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            if (firstVisiblePosition != -1) {
                View childAt = listView.getChildAt(0);
                if (childAt != null) {
                    listView.setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i2);
                }
            }
        }
    }
}
