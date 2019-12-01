package io.intercom.android.sdk.homescreen;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.g.a.a;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.TeamPresence;
import io.intercom.android.sdk.utilities.BackgroundUtils;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.android.sdk.utilities.FontUtils;
import io.intercom.android.sdk.utilities.TimeFormatter;
import io.intercom.android.sdk.views.InboxRowLayout;
import io.intercom.com.bumptech.glide.n;
import java.util.List;

public class RecentConversationCardViewHolder extends BaseConversationCardViewHolder {
    /* access modifiers changed from: private */
    public final HomeClickListener clickListener;
    private final LinearLayout inboxLayout;
    private final TextView newConversationButton;
    OnClickListener onConversationClicked = new OnClickListener() {
        public void onClick(View view) {
            if (view.getTag() instanceof Conversation) {
                RecentConversationCardViewHolder.this.clickListener.onConversationClicked((Conversation) view.getTag());
            }
        }
    };
    private final n requestManager;
    private final TextView seePreviousButton;
    private final TimeFormatter timeFormatter;

    RecentConversationCardViewHolder(View view, TimeFormatter timeFormatter2, Provider<AppConfig> provider, n nVar, HomeClickListener homeClickListener) {
        super(view, provider, homeClickListener);
        this.timeFormatter = timeFormatter2;
        this.requestManager = nVar;
        this.clickListener = homeClickListener;
        this.inboxLayout = (LinearLayout) view.findViewById(R.id.inbox_layout);
        this.newConversationButton = (TextView) view.findViewById(R.id.new_conversation_button);
        this.seePreviousButton = (TextView) view.findViewById(R.id.see_previous);
        this.newConversationButton.setOnClickListener(this.onNewConversationClicked);
        this.seePreviousButton.setOnClickListener(this.onSeePreviousClicked);
        applyCardBorderStyle((ConstraintLayout) view.findViewById(R.id.recent_conversation_card_layout));
        applyNewConversationButtonStyle();
        applyAllConversationButtonStyle(this.seePreviousButton);
    }

    private void applyNewConversationButtonStyle() {
        FontUtils.setRobotoMediumTypeface(this.newConversationButton);
        AppConfig appConfig = (AppConfig) this.appConfigProvider.get();
        int primaryColor = appConfig.getPrimaryColor();
        Context context = this.newConversationButton.getContext();
        if (appConfig.primaryColorRenderDarkText()) {
            updateButtonBackgroundColor(this.newConversationButton, primaryColor);
        } else {
            BackgroundUtils.setRippleButtonStroke(context, this.newConversationButton.getBackground(), R.id.background, primaryColor);
        }
        int primaryOrDarkColor = ColorUtils.primaryOrDarkColor(context, appConfig);
        updateLeftDrawableColor(this.newConversationButton, primaryOrDarkColor);
        this.newConversationButton.setTextColor(primaryOrDarkColor);
    }

    private View createDivider(Context context) {
        View view = new View(context);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.intercom_conversation_card_padding);
        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
        view.setLayoutParams(layoutParams);
        BackgroundUtils.setBackground(view, a.c(context, R.drawable.intercom_list_divider));
        return view;
    }

    public void bindConversationCard(ConversationCard conversationCard, UserIdentity userIdentity, AppConfig appConfig, TeamPresence teamPresence) {
        Context context = this.inboxLayout.getContext();
        this.inboxLayout.removeAllViews();
        List recentConversations = conversationCard.recentConversations();
        int i2 = 0;
        int i3 = 0;
        while (i3 < recentConversations.size() && i3 <= 2) {
            InboxRowLayout inboxRowLayout = new InboxRowLayout(context);
            inboxRowLayout.updateVerticalPadding(R.dimen.intercom_home_inbox_vertical_padding);
            Conversation conversation = (Conversation) recentConversations.get(i3);
            inboxRowLayout.updateConversation(conversation, userIdentity, appConfig, teamPresence, this.requestManager, this.timeFormatter);
            inboxRowLayout.setTag(conversation);
            inboxRowLayout.setOnClickListener(this.onConversationClicked);
            View createDivider = createDivider(context);
            if (i3 > 0) {
                this.inboxLayout.addView(createDivider);
            }
            this.inboxLayout.addView(inboxRowLayout);
            i3++;
        }
        this.seePreviousButton.setVisibility(conversationCard.hasOlderConversations() ? 0 : 8);
        TextView textView = this.newConversationButton;
        if (!appConfig.isInboundMessages()) {
            i2 = 8;
        }
        textView.setVisibility(i2);
        updateOlderConversationUnreadState(this.seePreviousButton, conversationCard.hasOlderUnreadConversations());
    }
}
