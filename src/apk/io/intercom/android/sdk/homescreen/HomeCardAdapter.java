package io.intercom.android.sdk.homescreen;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.x;
import e.a.a.a.a.d;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.HomeCard;
import io.intercom.android.sdk.models.HomeErrorRow;
import io.intercom.android.sdk.models.TeamPresence;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Selectors;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.utilities.TimeFormatter;
import io.intercom.com.bumptech.glide.n;
import io.intercom.com.google.gson.o;
import java.util.List;

public class HomeCardAdapter extends a<x> {
    private final Activity activity;
    private final Provider<AppConfig> appConfigProvider;
    private final d bus;
    private final List<Object> cardList;
    private final HomeClickListener clickListener;
    private final o gson;
    private final MetricTracker metricTracker;
    private final n requestManager;
    private final Store<State> store;
    private final TimeFormatter timeFormatter;
    private final UserIdentity userIdentity;

    public HomeCardAdapter(List<Object> list, Store<State> store2, Provider<AppConfig> provider, d dVar, o oVar, MetricTracker metricTracker2, TimeFormatter timeFormatter2, n nVar, HomeClickListener homeClickListener, UserIdentity userIdentity2, Activity activity2) {
        this.cardList = list;
        this.store = store2;
        this.appConfigProvider = provider;
        this.bus = dVar;
        this.gson = oVar;
        this.metricTracker = metricTracker2;
        this.timeFormatter = timeFormatter2;
        this.requestManager = nVar;
        this.userIdentity = userIdentity2;
        this.clickListener = homeClickListener;
        this.activity = activity2;
    }

    public int getItemCount() {
        return this.cardList.size();
    }

    public int getItemViewType(int i2) {
        Object obj = this.cardList.get(i2);
        if (!(obj instanceof ConversationCard)) {
            return obj instanceof HomeErrorRow ? 4 : 2;
        }
        ConversationCard conversationCard = (ConversationCard) this.cardList.get(i2);
        if (conversationCard.isLoading()) {
            return 3;
        }
        return conversationCard.recentConversations().isEmpty() ^ true ? 1 : 0;
    }

    public void onBindViewHolder(x xVar, int i2) {
        TeamPresence teamPresence = (TeamPresence) this.store.select(Selectors.TEAM_PRESENCE);
        Object obj = this.cardList.get(i2);
        if (obj instanceof ConversationCard) {
            ConversationCard conversationCard = (ConversationCard) obj;
            if (xVar instanceof NewConversationCardViewHolder) {
                ((NewConversationCardViewHolder) xVar).bindTeamPresence(teamPresence, this.requestManager, conversationCard);
            } else if (xVar instanceof RecentConversationCardViewHolder) {
                ((RecentConversationCardViewHolder) xVar).bindConversationCard(conversationCard, this.userIdentity, (AppConfig) this.appConfigProvider.get(), teamPresence);
            }
        } else if (obj instanceof HomeCard) {
            ((MessengerAppCardViewHolder) xVar).bindCard(((HomeCard) obj).fallbackUrl());
        }
    }

    public x onCreateViewHolder(ViewGroup viewGroup, int i2) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i2 == 0) {
            return new NewConversationCardViewHolder(from.inflate(R.layout.intercom_new_conversation_card, viewGroup, false), this.appConfigProvider, this.clickListener);
        }
        if (i2 == 1) {
            RecentConversationCardViewHolder recentConversationCardViewHolder = new RecentConversationCardViewHolder(from.inflate(R.layout.intercom_recent_conversation_card, viewGroup, false), this.timeFormatter, this.appConfigProvider, this.requestManager, this.clickListener);
            return recentConversationCardViewHolder;
        } else if (i2 == 2) {
            MessengerAppCardViewHolder messengerAppCardViewHolder = new MessengerAppCardViewHolder(from.inflate(R.layout.intercom_messenger_app_card, viewGroup, false), this.bus, this.appConfigProvider, this.gson, this.metricTracker, this.activity);
            return messengerAppCardViewHolder;
        } else if (i2 == 4) {
            return new ErrorViewHolder(from.inflate(R.layout.intercom_home_error_row, viewGroup, false), this.appConfigProvider, this.clickListener);
        } else {
            return new ConversationCardLoadingViewHolder(from.inflate(R.layout.intercom_row_card_loading, viewGroup, false), this.appConfigProvider);
        }
    }
}
