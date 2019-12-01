package io.intercom.android.sdk.homescreen;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView.x;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.utilities.ColorUtils;

class ConversationCardLoadingViewHolder extends x {
    ConversationCardLoadingViewHolder(View view, Provider<AppConfig> provider) {
        super(view);
        ColorUtils.updateInnerBorderColor((AppConfig) provider.get(), (FrameLayout) view.findViewById(R.id.loading_layout));
    }
}
