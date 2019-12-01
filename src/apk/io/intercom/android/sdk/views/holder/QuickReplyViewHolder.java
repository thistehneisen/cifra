package io.intercom.android.sdk.views.holder;

import android.content.ClipboardManager;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.flexbox.FlexboxLayout;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.views.PartMetadataFormatter;
import io.intercom.com.bumptech.glide.n;

public class QuickReplyViewHolder extends PartViewHolder {
    public QuickReplyViewHolder(View view, int i2, ConversationListener conversationListener, ClipboardManager clipboardManager, PartMetadataFormatter partMetadataFormatter, Provider<AppConfig> provider, n nVar, MetricTracker metricTracker) {
        super(view, i2, conversationListener, clipboardManager, partMetadataFormatter, provider, nVar, metricTracker);
    }

    public void bind(Part part, ViewGroup viewGroup) {
        FlexboxLayout flexboxLayout = (FlexboxLayout) this.itemView.findViewById(R.id.quick_reply_layout);
        if (flexboxLayout != null) {
            addReplyOptions(part, flexboxLayout);
        }
    }
}
