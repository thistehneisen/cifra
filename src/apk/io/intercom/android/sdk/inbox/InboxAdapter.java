package io.intercom.android.sdk.inbox;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.x;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.TeamPresence;
import io.intercom.android.sdk.state.InboxState;
import io.intercom.android.sdk.state.InboxState.Status;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Selectors;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.utilities.TimeFormatter;
import io.intercom.android.sdk.views.InboxRowLayout;
import io.intercom.com.bumptech.glide.n;
import java.util.Locale;

class InboxAdapter extends a<x> {
    static final int CONVERSATION = 0;
    static final int LOADING = 1;
    private final Provider<AppConfig> appConfigProvider;
    private final ConversationClickListener conversationClickListener;
    private InboxState inboxState;
    private final LayoutInflater inflater;
    private final n requestManager;
    private final Store<State> store;
    private final TimeFormatter timeFormatter;
    private UserIdentity userIdentity;

    InboxAdapter(LayoutInflater layoutInflater, ConversationClickListener conversationClickListener2, Store<State> store2, TimeFormatter timeFormatter2, Provider<AppConfig> provider, UserIdentity userIdentity2, n nVar) {
        this.inflater = layoutInflater;
        this.conversationClickListener = conversationClickListener2;
        this.store = store2;
        this.timeFormatter = timeFormatter2;
        this.appConfigProvider = provider;
        this.userIdentity = userIdentity2;
        this.requestManager = nVar;
        setHasStableIds(true);
    }

    private int conversationCount() {
        return this.inboxState.conversations().size();
    }

    public int getItemCount() {
        return conversationCount() + (this.inboxState.status() == Status.LOADING ? 1 : 0);
    }

    public long getItemId(int i2) {
        long j2;
        if (i2 == conversationCount()) {
            return -1;
        }
        String id = ((Conversation) this.inboxState.conversations().get(i2)).getId();
        if (TextUtils.isEmpty(id) || !TextUtils.isDigitsOnly(id)) {
            j2 = (long) id.hashCode();
        } else {
            j2 = Long.valueOf(id).longValue();
        }
        return j2;
    }

    public int getItemViewType(int i2) {
        return i2 == conversationCount() ? 1 : 0;
    }

    public void onBindViewHolder(x xVar, int i2) {
        if (xVar instanceof InboxRowViewHolder) {
            ((InboxRowViewHolder) xVar).bindData((Conversation) this.inboxState.conversations().get(i2), this.userIdentity, (AppConfig) this.appConfigProvider.get(), (TeamPresence) this.store.select(Selectors.TEAM_PRESENCE));
        }
    }

    public x onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            InboxRowLayout inboxRowLayout = new InboxRowLayout(viewGroup.getContext());
            inboxRowLayout.setLayoutParams(new LayoutParams(-1, -2));
            return new InboxRowViewHolder(inboxRowLayout, this.conversationClickListener, this.timeFormatter, this.requestManager);
        } else if (i2 == 1) {
            return new LoadingViewHolder(this.inflater.inflate(R.layout.intercom_row_loading, viewGroup, false));
        } else {
            throw new RuntimeException(String.format(Locale.getDefault(), "View type %d not supported", new Object[]{Integer.valueOf(i2)}));
        }
    }

    /* access modifiers changed from: 0000 */
    public void setInboxState(InboxState inboxState2) {
        this.inboxState = inboxState2;
    }
}
