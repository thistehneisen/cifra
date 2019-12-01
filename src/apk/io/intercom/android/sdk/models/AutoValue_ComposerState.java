package io.intercom.android.sdk.models;

final class AutoValue_ComposerState extends ComposerState {
    private final boolean visible;

    AutoValue_ComposerState(boolean z) {
        this.visible = z;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ComposerState)) {
            return false;
        }
        if (this.visible != ((ComposerState) obj).isVisible()) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (this.visible ? 1231 : 1237) ^ 1000003;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ComposerState{visible=");
        sb.append(this.visible);
        sb.append("}");
        return sb.toString();
    }
}
