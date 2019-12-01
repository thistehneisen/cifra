package io.intercom.android.sdk.state;

import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.state.InboxState.Status;
import java.util.List;

final class AutoValue_InboxState extends InboxState {
    private final List<Conversation> conversations;
    private final boolean hasMorePages;
    private final Status status;

    AutoValue_InboxState(List<Conversation> list, Status status2, boolean z) {
        if (list != null) {
            this.conversations = list;
            if (status2 != null) {
                this.status = status2;
                this.hasMorePages = z;
                return;
            }
            throw new NullPointerException("Null status");
        }
        throw new NullPointerException("Null conversations");
    }

    public List<Conversation> conversations() {
        return this.conversations;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InboxState)) {
            return false;
        }
        InboxState inboxState = (InboxState) obj;
        if (!this.conversations.equals(inboxState.conversations()) || !this.status.equals(inboxState.status()) || this.hasMorePages != inboxState.hasMorePages()) {
            z = false;
        }
        return z;
    }

    public boolean hasMorePages() {
        return this.hasMorePages;
    }

    public int hashCode() {
        return ((((this.conversations.hashCode() ^ 1000003) * 1000003) ^ this.status.hashCode()) * 1000003) ^ (this.hasMorePages ? 1231 : 1237);
    }

    public Status status() {
        return this.status;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InboxState{conversations=");
        sb.append(this.conversations);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", hasMorePages=");
        sb.append(this.hasMorePages);
        sb.append("}");
        return sb.toString();
    }
}
