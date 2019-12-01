package io.intercom.android.sdk.views.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.x;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.models.EventData;
import io.intercom.android.sdk.models.EventParticipant;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.utilities.AvatarUtils;
import io.intercom.com.bumptech.glide.n;

public class EventViewHolder extends x implements ConversationPartViewHolder {
    private final Provider<AppConfig> appConfigProvider;
    private final ImageView avatar;
    private final TextView eventTitle;
    private final n requestManager;

    public EventViewHolder(View view, Provider<AppConfig> provider, n nVar) {
        super(view);
        this.appConfigProvider = provider;
        this.requestManager = nVar;
        this.eventTitle = (TextView) view.findViewById(R.id.event_name);
        this.avatar = (ImageView) view.findViewById(R.id.avatar);
    }

    public void bind(Part part, ViewGroup viewGroup) {
        EventData eventData = part.getEventData();
        EventParticipant participant = eventData.getParticipant();
        this.eventTitle.setText(eventData.getEventAsPlainText());
        AvatarUtils.loadAvatarIntoView(Avatar.create(participant.getAvatar().getImageUrl(), participant.getInitial()), this.avatar, (AppConfig) this.appConfigProvider.get(), this.requestManager);
    }
}
