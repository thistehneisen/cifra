package io.intercom.android.sdk.models;

import io.intercom.android.sdk.utilities.NullSafety;

public abstract class OperatorClientCondition {

    public static final class Builder {
        String condition_id;
        String id;

        public OperatorClientCondition build() {
            return OperatorClientCondition.create(NullSafety.valueOrEmpty(this.id), NullSafety.valueOrEmpty(this.condition_id));
        }
    }

    public static OperatorClientCondition create(String str, String str2) {
        return new AutoValue_OperatorClientCondition(str, str2);
    }

    public abstract String conditionId();

    public abstract String id();
}
