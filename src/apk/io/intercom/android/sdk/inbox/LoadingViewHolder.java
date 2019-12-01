package io.intercom.android.sdk.inbox;

import android.content.res.Resources;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.x;
import io.intercom.android.sdk.R;

class LoadingViewHolder extends x {
    LoadingViewHolder(View view) {
        super(view);
        Resources resources = view.getResources();
        view.getLayoutParams().height = resources.getDimensionPixelSize(R.dimen.intercom_inbox_row_height);
    }
}
