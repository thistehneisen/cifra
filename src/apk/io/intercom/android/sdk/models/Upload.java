package io.intercom.android.sdk.models;

import io.intercom.android.sdk.utilities.NullSafety;

public abstract class Upload {

    public static final class Builder {
        String acl;
        String aws_access_key;
        String content_type;
        int id;
        String key;
        String policy;
        String public_url;
        String signature;
        String success_action_status;
        String upload_destination;

        public Upload build() {
            AutoValue_Upload autoValue_Upload = new AutoValue_Upload(this.id, NullSafety.valueOrEmpty(this.acl), NullSafety.valueOrEmpty(this.aws_access_key), NullSafety.valueOrEmpty(this.content_type), NullSafety.valueOrEmpty(this.key), NullSafety.valueOrEmpty(this.policy), NullSafety.valueOrEmpty(this.public_url), NullSafety.valueOrEmpty(this.signature), NullSafety.valueOrEmpty(this.success_action_status), NullSafety.valueOrEmpty(this.upload_destination));
            return autoValue_Upload;
        }
    }

    public abstract String getAcl();

    public abstract String getAwsAccessKey();

    public abstract String getContentType();

    public abstract int getId();

    public abstract String getKey();

    public abstract String getPolicy();

    public abstract String getPublicUrl();

    public abstract String getSignature();

    public abstract String getSuccessActionStatus();

    public abstract String getUploadDestination();
}
