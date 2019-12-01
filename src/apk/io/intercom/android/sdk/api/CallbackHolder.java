package io.intercom.android.sdk.api;

import e.a.a.a.a.d;
import io.intercom.android.sdk.actions.Actions;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.ConversationsResponse;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.UsersResponse;
import io.intercom.android.sdk.models.events.ConversationEvent.Builder;
import io.intercom.android.sdk.models.events.FormSubmitSuccessEvent;
import io.intercom.android.sdk.models.events.NewConversationEvent;
import io.intercom.android.sdk.models.events.ReplyEvent;
import io.intercom.android.sdk.models.events.failure.ConversationFailedEvent;
import io.intercom.android.sdk.models.events.failure.FormSubmitFailedEvent;
import io.intercom.android.sdk.models.events.failure.NewConversationFailedEvent;
import io.intercom.android.sdk.models.events.failure.ReplyFailedEvent;
import io.intercom.android.sdk.state.ReplyPart;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.retrofit2.Call;
import io.intercom.retrofit2.Callback;
import io.intercom.retrofit2.Response;

class CallbackHolder {
    /* access modifiers changed from: private */
    public static final Twig TWIG = LumberMill.getLogger();
    final d bus;
    final Store<State> store;

    CallbackHolder(d dVar, Store<State> store2) {
        this.bus = dVar;
        this.store = store2;
    }

    /* access modifiers changed from: private */
    public void conversationFetchSuccess(Conversation conversation) {
        this.store.dispatch(Actions.fetchConversationSuccess(conversation));
        this.bus.post(new Builder(conversation).build());
    }

    /* access modifiers changed from: 0000 */
    public Callback<Conversation.Builder> conversationCallback() {
        return new BaseCallback<Conversation.Builder>() {
            public void onError(ErrorObject errorObject) {
                CallbackHolder.this.bus.post(new ConversationFailedEvent());
            }

            public void onSuccess(Conversation.Builder builder) {
                CallbackHolder.this.conversationFetchSuccess(builder.build());
            }
        };
    }

    /* access modifiers changed from: 0000 */
    public Callback<ConversationsResponse.Builder> inboxCallback() {
        return new BaseCallback<ConversationsResponse.Builder>() {
            public void onError(ErrorObject errorObject) {
                CallbackHolder.this.store.dispatch(Actions.fetchInboxFailed());
            }

            public void onSuccess(ConversationsResponse.Builder builder) {
                ConversationsResponse build = builder.build();
                CallbackHolder.this.store.dispatch(Actions.baseResponseReceived(build));
                CallbackHolder.this.store.dispatch(Actions.fetchInboxSuccess(build));
            }
        };
    }

    /* access modifiers changed from: 0000 */
    public Callback<Void> loggingCallback(final String str) {
        return new Callback<Void>() {
            public void onFailure(Call<Void> call, Throwable th) {
                Twig access$100 = CallbackHolder.TWIG;
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(" failure");
                access$100.internal(sb.toString());
            }

            public void onResponse(Call<Void> call, Response<Void> response) {
                Twig access$100 = CallbackHolder.TWIG;
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(" success");
                access$100.internal(sb.toString());
            }
        };
    }

    /* access modifiers changed from: 0000 */
    public Callback<Conversation.Builder> newConversationCallback(final int i2, final String str) {
        return new BaseCallback<Conversation.Builder>() {
            /* access modifiers changed from: protected */
            public void onError(ErrorObject errorObject) {
                CallbackHolder.this.bus.post(new NewConversationFailedEvent(i2, str));
            }

            public void onSuccess(Conversation.Builder builder) {
                Conversation build = builder.build();
                CallbackHolder.this.store.dispatch(Actions.newConversationSuccess(build));
                CallbackHolder.this.bus.post(new NewConversationEvent(build, str));
            }
        };
    }

    /* access modifiers changed from: 0000 */
    public Callback<Part.Builder> replyCallback(int i2, boolean z, String str, String str2) {
        final String str3 = str2;
        final int i3 = i2;
        final String str4 = str;
        final boolean z2 = z;
        AnonymousClass3 r0 = new BaseCallback<Part.Builder>() {
            public void onError(ErrorObject errorObject) {
                CallbackHolder.this.bus.post(new ReplyFailedEvent(i3, z2, str4));
            }

            public void onSuccess(Part.Builder builder) {
                Part build = builder.build();
                CallbackHolder.this.store.dispatch(Actions.conversationReplySuccess(new ReplyPart(build, str3)));
                CallbackHolder.this.bus.post(new ReplyEvent(build, i3, str4, str3));
            }
        };
        return r0;
    }

    /* access modifiers changed from: 0000 */
    public Callback<Conversation.Builder> submitFormCallback(final String str, final String str2) {
        return new BaseCallback<Conversation.Builder>() {
            public void onError(ErrorObject errorObject) {
                CallbackHolder.this.bus.post(new FormSubmitFailedEvent(str, str2));
            }

            public void onSuccess(Conversation.Builder builder) {
                Conversation build = builder.build();
                CallbackHolder.this.store.dispatch(Actions.fetchConversationSuccess(build));
                CallbackHolder.this.bus.post(new FormSubmitSuccessEvent(build, str));
            }
        };
    }

    /* access modifiers changed from: 0000 */
    public BaseCallback<UsersResponse.Builder> unreadCallback() {
        return new BaseCallback<UsersResponse.Builder>() {
            public void onSuccess(UsersResponse.Builder builder) {
                UsersResponse build = builder.build();
                CallbackHolder.this.store.dispatch(Actions.baseResponseReceived(build));
                CallbackHolder.this.store.dispatch(Actions.unreadConversationsSuccess(build));
            }
        };
    }
}
