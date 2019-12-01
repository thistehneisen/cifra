package io.intercom.android.sdk.homescreen;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.commons.utilities.TimeProvider;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.HomeCard;
import io.intercom.android.sdk.models.HomeErrorRow;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Store;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class HomePresenter {
    private static final int CONTENT_OFFSET_DP = 64;
    private static final int CONVERSATION_CARD_POSITION = 0;
    private static final long THREE_DAYS_MILLISECONDS = 259200000;
    private final Provider<AppConfig> appConfigProvider;
    private final List<Object> cardList;
    private boolean hasOlderConversations;
    private final Listener listener;
    private final Store<State> store;
    private final TimeProvider timeProvider;

    public interface Listener {
        void notifyItemChanged(int i2);
    }

    public HomePresenter(Store<State> store2, Provider<AppConfig> provider, List<Object> list, Listener listener2) {
        this(store2, provider, TimeProvider.SYSTEM, list, listener2);
    }

    private ConversationCard buildConversationCard(boolean z, boolean z2) {
        this.hasOlderConversations = z;
        List recentConversations = getRecentConversations();
        if ((!z2) && recentConversations.isEmpty()) {
            return null;
        }
        return ConversationCard.builder().recentConversations(recentConversations).hasOlderConversations(this.hasOlderConversations).hasOlderUnreadConversations(hasOlderUnreadConversations(recentConversations)).build();
    }

    private float clamp(float f2) {
        return Math.min(Math.max(f2, 0.0f), 100.0f);
    }

    private boolean hasConversationCard() {
        return !this.cardList.isEmpty() && (this.cardList.get(0) instanceof ConversationCard);
    }

    private boolean inboundMessagesEnabled() {
        return ((AppConfig) this.appConfigProvider.get()).isInboundMessages();
    }

    private float inverseDecimalPercentage(float f2) {
        return 1.0f - f2;
    }

    public void addErrorRow() {
        this.cardList.add(HomeErrorRow.create());
    }

    public void addLoadingCards() {
        if (inboundMessagesEnabled()) {
            this.cardList.add(ConversationCard.builder().isLoading(true).build());
        }
        int homeScreenCardCount = ((AppConfig) this.appConfigProvider.get()).getHomeScreenCardCount();
        for (int i2 = 1; i2 <= homeScreenCardCount; i2++) {
            this.cardList.add(HomeCard.create(""));
        }
    }

    public void clearCards() {
        this.cardList.clear();
    }

    /* access modifiers changed from: 0000 */
    public List<Conversation> getRecentConversations() {
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = this.timeProvider.currentTimeMillis() - THREE_DAYS_MILLISECONDS;
        Iterator it = ((State) this.store.state()).inboxState().conversations().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Conversation conversation = (Conversation) it.next();
            if (conversation.getLastPart().getCreatedAt() * 1000 < currentTimeMillis) {
                this.hasOlderConversations = true;
                break;
            }
            arrayList.add(conversation);
        }
        if (arrayList.size() > 3) {
            this.hasOlderConversations = true;
        }
        return arrayList;
    }

    /* access modifiers changed from: 0000 */
    public boolean hasOlderUnreadConversations(List<Conversation> list) {
        HashSet hashSet = new HashSet(((State) this.store.state()).unreadConversationIds());
        for (Conversation conversation : list) {
            String id = conversation.getId();
            if (hashSet.contains(conversation.getId())) {
                hashSet.remove(id);
            }
        }
        return !hashSet.isEmpty();
    }

    public void renderHeaderScrollChange(RecyclerView recyclerView, int i2, View view, View view2) {
        View childAt = recyclerView.getChildAt(0);
        if (childAt != null) {
            int[] iArr = new int[2];
            childAt.getLocationInWindow(iArr);
            float clamp = clamp((((float) iArr[1]) * 100.0f) / ((float) i2)) / 100.0f;
            view.setAlpha(inverseDecimalPercentage(clamp));
            view2.setAlpha(clamp);
            view2.setTranslationY(((float) ScreenUtils.dpToPx(64.0f, view2.getContext())) * (-inverseDecimalPercentage(clamp)));
        }
    }

    public void updateCards(List<HomeCard> list) {
        boolean hasConversationCard = hasConversationCard();
        int i2 = 0;
        while (i2 < list.size()) {
            int i3 = hasConversationCard ? i2 + 1 : i2;
            HomeCard homeCard = (HomeCard) list.get(i2);
            if (i3 < this.cardList.size()) {
                this.cardList.set(i3, homeCard);
            } else {
                this.cardList.add(i3, homeCard);
            }
            this.listener.notifyItemChanged(i3);
            i2++;
        }
    }

    public void updateConversationCard(boolean z) {
        ConversationCard buildConversationCard = buildConversationCard(z, inboundMessagesEnabled());
        if (buildConversationCard != null) {
            if (hasConversationCard()) {
                this.cardList.set(0, buildConversationCard);
            } else {
                this.cardList.add(0, buildConversationCard);
            }
            this.listener.notifyItemChanged(0);
        }
    }

    HomePresenter(Store<State> store2, Provider<AppConfig> provider, TimeProvider timeProvider2, List<Object> list, Listener listener2) {
        this.hasOlderConversations = false;
        this.store = store2;
        this.appConfigProvider = provider;
        this.timeProvider = timeProvider2;
        this.cardList = list;
        this.listener = listener2;
    }

    public void updateConversationCard() {
        updateConversationCard(this.hasOlderConversations);
    }
}
