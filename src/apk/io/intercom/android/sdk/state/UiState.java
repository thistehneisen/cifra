package io.intercom.android.sdk.state;

public abstract class UiState {

    public enum Screen {
        NONE,
        INBOX,
        HOME,
        COMPOSER,
        CONVERSATION
    }

    public static UiState create(Screen screen, String str) {
        return new AutoValue_UiState(screen, str);
    }

    public abstract String conversationId();

    public abstract Screen screen();
}
