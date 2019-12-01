package com.intercom.input.gallery.adapter;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.n;

public class EndlessRecyclerScrollListener extends n {
    private final EndlessScrollListener endlessScrollListener;
    private final LinearLayoutManager layoutManager;
    private int maxCount = Integer.MIN_VALUE;

    public EndlessRecyclerScrollListener(LinearLayoutManager linearLayoutManager, EndlessScrollListener endlessScrollListener2) {
        this.layoutManager = linearLayoutManager;
        this.endlessScrollListener = endlessScrollListener2;
    }

    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        super.onScrolled(recyclerView, i2, i3);
        int childCount = recyclerView.getChildCount();
        int k2 = this.layoutManager.k();
        if (k2 - childCount <= this.layoutManager.G() && k2 < this.maxCount) {
            this.endlessScrollListener.onLoadMore();
        }
    }

    public void setMaxCount(int i2) {
        this.maxCount = i2;
    }
}
