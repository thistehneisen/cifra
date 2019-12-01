package io.intercom.android.sdk.views;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.g.a.a;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.LastParticipatingAdmin;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.TeamPresence;
import io.intercom.android.sdk.utilities.GroupConversationTextFormatter;
import io.intercom.android.sdk.utilities.TimeFormatter;
import io.intercom.com.bumptech.glide.n;

public class InboxRowLayout extends RelativeLayout {
    private final AuthorAvatarView authorAvatar;
    private final TextView authorName;
    private final FrameLayout frameLayout;
    private final TextView summary;
    private final TextView timeStamp;
    private final ImageView unreadDot;

    public InboxRowLayout(Context context) {
        this(context, null);
    }

    private void setRowParticipantDetails(Conversation conversation, String str, n nVar, TeamPresence teamPresence, AppConfig appConfig) {
        LastParticipatingAdmin lastParticipatingAdmin = conversation.getLastParticipatingAdmin();
        if (!TextUtils.isEmpty(lastParticipatingAdmin.getFirstName())) {
            this.authorAvatar.loadAvatarWithActiveState(lastParticipatingAdmin.getAvatar(), lastParticipatingAdmin.isActive(), appConfig, nVar);
            this.authorName.setText(GroupConversationTextFormatter.groupConversationTitle(lastParticipatingAdmin.getFirstName(), conversation.getGroupConversationParticipants().size(), this.authorName.getContext()));
        } else if (teamPresence.isEmpty()) {
            this.authorAvatar.loadAvatar(lastParticipatingAdmin.getAvatar(), appConfig, nVar);
            this.authorName.setText(str);
        } else {
            this.authorAvatar.loadAvatars(teamPresence.getActiveAdmins(), appConfig, nVar);
            this.authorName.setText(str);
        }
    }

    public void updateConversation(Conversation conversation, UserIdentity userIdentity, AppConfig appConfig, TeamPresence teamPresence, n nVar, TimeFormatter timeFormatter) {
        Part lastNonEventPart = conversation.getLastNonEventPart();
        Part lastPart = conversation.getLastPart();
        Context context = getContext();
        if (lastNonEventPart.getParticipant().isUserWithId(userIdentity.getIntercomId())) {
            TextView textView = this.summary;
            StringBuilder sb = new StringBuilder();
            sb.append(context.getString(R.string.intercom_you));
            sb.append(": ");
            sb.append(lastNonEventPart.getSummary());
            textView.setText(sb.toString());
        } else {
            this.summary.setText(lastNonEventPart.getSummary());
        }
        this.timeStamp.setText(timeFormatter.getFormattedTime(lastPart.getCreatedAt()));
        setRowParticipantDetails(conversation, appConfig.getName(), nVar, teamPresence, appConfig);
        if (!conversation.isRead()) {
            this.authorName.setTypeface(Typeface.SANS_SERIF, 1);
            this.summary.setTypeface(Typeface.SANS_SERIF, 1);
            this.authorName.setTextColor(a.a(context, R.color.intercom_black));
            this.unreadDot.setVisibility(0);
            return;
        }
        this.authorName.setTypeface(Typeface.SANS_SERIF, 0);
        this.summary.setTypeface(Typeface.SANS_SERIF, 0);
        this.authorName.setTextColor(a.a(context, R.color.intercom_text_grey));
        this.unreadDot.setVisibility(8);
    }

    public void updateVerticalPadding(int i2) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i2);
        FrameLayout frameLayout2 = this.frameLayout;
        frameLayout2.setPadding(frameLayout2.getPaddingLeft(), dimensionPixelSize, this.frameLayout.getPaddingRight(), dimensionPixelSize);
    }

    public InboxRowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        RelativeLayout.inflate(getContext(), R.layout.intercom_row_inbox, this);
        this.authorAvatar = (AuthorAvatarView) findViewById(R.id.intercom_author_avatar);
        this.authorName = (TextView) findViewById(R.id.intercom_user_name);
        this.timeStamp = (TextView) findViewById(R.id.intercom_time_stamp);
        this.summary = (TextView) findViewById(R.id.intercom_message_summary);
        this.unreadDot = (ImageView) findViewById(R.id.intercom_unread_dot);
        this.frameLayout = (FrameLayout) findViewById(R.id.intercom_inbox_row_layout);
    }
}
