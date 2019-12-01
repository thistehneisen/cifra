package io.intercom.android.sdk.state;

import io.intercom.android.sdk.state.UiState.Screen;

final class AutoValue_UiState extends UiState {
    private final String conversationId;
    private final Screen screen;

    AutoValue_UiState(Screen screen2, String str) {
        if (screen2 != null) {
            this.screen = screen2;
            this.conversationId = str;
            return;
        }
        throw new NullPointerException("Null screen");
    }

    public String conversationId() {
        return this.conversationId;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UiState)) {
            return false;
        }
        UiState uiState = (UiState) obj;
        if (this.screen.equals(uiState.screen())) {
            String str = this.conversationId;
            if (str != null) {
            }
        }
        z = false;
        return z;
    }

    public int hashCode() {
        int hashCode = (this.screen.hashCode() ^ 1000003) * 1000003;
        String str = this.conversationId;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    public Screen screen() {
        return this.screen;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UiState{screen=");
        sb.append(this.screen);
        sb.append(", conversationId=");
        sb.append(this.conversationId);
        sb.append("}");
        return sb.toString();
    }
}
