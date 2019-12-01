package io.intercom.android.sdk.api;

import android.os.Handler;
import android.os.Looper;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.actions.Actions;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Store;
import java.util.UUID;

public class UserUpdateBatcher {
    private final Provider<Api> apiProvider;
    private final Provider<AppConfig> appConfigProvider;
    private final Handler handler;
    private UserUpdateRequest pendingUpdate;
    private String pendingUpdateIdentifier;
    private final Store<State> store;

    UserUpdateBatcher(Handler handler2, Provider<Api> provider, Provider<AppConfig> provider2, Store<State> store2) {
        this.apiProvider = provider;
        this.handler = handler2;
        this.appConfigProvider = provider2;
        this.store = store2;
        resetPendingUpdate();
    }

    public static UserUpdateBatcher create(Provider<Api> provider, Provider<AppConfig> provider2, Store<State> store2) {
        return new UserUpdateBatcher(new Handler(Looper.getMainLooper()), provider, provider2, store2);
    }

    private long maxDelay(UserUpdateRequest userUpdateRequest) {
        AppConfig appConfig = (AppConfig) this.appConfigProvider.get();
        return userUpdateRequest.isInternalUpdate() ? appConfig.getPingDelayMs() : appConfig.getBatchUserUpdatePeriodMs();
    }

    private void resetPendingUpdate() {
        this.pendingUpdate = new UserUpdateRequest();
        this.pendingUpdateIdentifier = UUID.randomUUID().toString();
    }

    private void submitPendingUpdateWithDelay(long j2) {
        if (j2 > 0) {
            final String str = this.pendingUpdateIdentifier;
            this.handler.postDelayed(new Runnable() {
                public void run() {
                    UserUpdateBatcher.this.submitPendingUpdate(str);
                }
            }, j2);
            return;
        }
        submitPendingUpdate();
    }

    public synchronized void submitPendingUpdate() {
        submitPendingUpdate(this.pendingUpdate);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0030  */
    public synchronized void updateUser(UserUpdateRequest userUpdateRequest) {
        boolean z;
        if (!this.pendingUpdate.canMergeUpdate(userUpdateRequest)) {
            submitPendingUpdate();
        }
        if (this.pendingUpdate.isValidUpdate()) {
            if (maxDelay(userUpdateRequest) >= maxDelay(this.pendingUpdate)) {
                z = false;
                this.pendingUpdate = this.pendingUpdate.merge(userUpdateRequest);
                if (z) {
                    submitPendingUpdateWithDelay(maxDelay(this.pendingUpdate));
                }
            }
        }
        z = true;
        this.pendingUpdate = this.pendingUpdate.merge(userUpdateRequest);
        if (z) {
        }
    }

    /* access modifiers changed from: private */
    public synchronized void submitPendingUpdate(String str) {
        if (this.pendingUpdateIdentifier.equals(str)) {
            submitPendingUpdate(this.pendingUpdate);
        }
    }

    private void submitPendingUpdate(UserUpdateRequest userUpdateRequest) {
        if (userUpdateRequest.isValidUpdate()) {
            if (userUpdateRequest.isNewSession()) {
                this.store.dispatch(Actions.sessionStarted());
            }
            ((Api) this.apiProvider.get()).updateUser(userUpdateRequest);
            resetPendingUpdate();
        }
    }
}
