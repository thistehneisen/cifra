package io.intercom.android.sdk.models;

public abstract class HomeErrorRow {

    public static final class Builder {
        public HomeErrorRow build() {
            return HomeErrorRow.create();
        }
    }

    public static HomeErrorRow create() {
        return new AutoValue_HomeErrorRow();
    }
}
