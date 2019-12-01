package io.intercom.android.sdk.models;

import io.intercom.android.sdk.utilities.NullSafety;

public abstract class HomeCard {

    public static final class Builder {
        String fallback_url;

        public HomeCard build() {
            return HomeCard.create(NullSafety.valueOrEmpty(this.fallback_url));
        }
    }

    public static HomeCard create(String str) {
        return new AutoValue_HomeCard(str);
    }

    public abstract String fallbackUrl();
}
