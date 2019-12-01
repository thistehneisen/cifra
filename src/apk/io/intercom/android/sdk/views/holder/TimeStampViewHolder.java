package io.intercom.android.sdk.views.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.x;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.utilities.TimeFormatter;

public class TimeStampViewHolder extends x implements ConversationPartViewHolder {
    private final TimeFormatter timeFormatter;

    public TimeStampViewHolder(View view, TimeFormatter timeFormatter2) {
        super(view);
        this.timeFormatter = timeFormatter2;
    }

    public void bind(Part part, ViewGroup viewGroup) {
        ((TextView) this.itemView).setText(this.timeFormatter.getAbsoluteDate(part.getCreatedAt()));
    }
}
