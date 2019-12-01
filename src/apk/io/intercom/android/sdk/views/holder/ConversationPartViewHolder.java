package io.intercom.android.sdk.views.holder;

import android.view.ViewGroup;
import io.intercom.android.sdk.models.Part;

public interface ConversationPartViewHolder {
    void bind(Part part, ViewGroup viewGroup);
}
