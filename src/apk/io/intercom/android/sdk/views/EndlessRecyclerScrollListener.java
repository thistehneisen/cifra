package io.intercom.android.sdk.views;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.n;

public class EndlessRecyclerScrollListener extends n {
    final EndlessScrollListener endlessScrollListener;
    private final LinearLayoutManager layoutManager;
    private boolean morePagesAvailable = true;

    public EndlessRecyclerScrollListener(LinearLayoutManager linearLayoutManager, EndlessScrollListener endlessScrollListener2) {
        this.layoutManager = linearLayoutManager;
        this.endlessScrollListener = endlessScrollListener2;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        super.onScrollStateChanged(recyclerView, i2);
        this.endlessScrollListener.setOverScrollColour();
    }

    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        super.onScrolled(recyclerView, i2, i3);
        int childCount = recyclerView.getChildCount();
        if (this.layoutManager.k() - childCount <= this.layoutManager.G() && this.morePagesAvailable) {
            recyclerView.post(new Runnable() {
                public void run() {
                    EndlessRecyclerScrollListener.this.endlessScrollListener.onLoadMore();
                }
            });
        }
    }

    public void setMorePagesAvailable(boolean z) {
        this.morePagesAvailable = z;
    }
}
