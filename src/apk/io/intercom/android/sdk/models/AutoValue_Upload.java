package io.intercom.android.sdk.models;

final class AutoValue_Upload extends Upload {
    private final String acl;
    private final String awsAccessKey;
    private final String contentType;
    private final int id;
    private final String key;
    private final String policy;
    private final String publicUrl;
    private final String signature;
    private final String successActionStatus;
    private final String uploadDestination;

    AutoValue_Upload(int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.id = i2;
        if (str != null) {
            this.acl = str;
            if (str2 != null) {
                this.awsAccessKey = str2;
                if (str3 != null) {
                    this.contentType = str3;
                    if (str4 != null) {
                        this.key = str4;
                        if (str5 != null) {
                            this.policy = str5;
                            if (str6 != null) {
                                this.publicUrl = str6;
                                if (str7 != null) {
                                    this.signature = str7;
                                    if (str8 != null) {
                                        this.successActionStatus = str8;
                                        if (str9 != null) {
                                            this.uploadDestination = str9;
                                            return;
                                        }
                                        throw new NullPointerException("Null uploadDestination");
                                    }
                                    throw new NullPointerException("Null successActionStatus");
                                }
                                throw new NullPointerException("Null signature");
                            }
                            throw new NullPointerException("Null publicUrl");
                        }
                        throw new NullPointerException("Null policy");
                    }
                    throw new NullPointerException("Null key");
                }
                throw new NullPointerException("Null contentType");
            }
            throw new NullPointerException("Null awsAccessKey");
        }
        throw new NullPointerException("Null acl");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Upload)) {
            return false;
        }
        Upload upload = (Upload) obj;
        if (this.id != upload.getId() || !this.acl.equals(upload.getAcl()) || !this.awsAccessKey.equals(upload.getAwsAccessKey()) || !this.contentType.equals(upload.getContentType()) || !this.key.equals(upload.getKey()) || !this.policy.equals(upload.getPolicy()) || !this.publicUrl.equals(upload.getPublicUrl()) || !this.signature.equals(upload.getSignature()) || !this.successActionStatus.equals(upload.getSuccessActionStatus()) || !this.uploadDestination.equals(upload.getUploadDestination())) {
            z = false;
        }
        return z;
    }

    public String getAcl() {
        return this.acl;
    }

    public String getAwsAccessKey() {
        return this.awsAccessKey;
    }

    public String getContentType() {
        return this.contentType;
    }

    public int getId() {
        return this.id;
    }

    public String getKey() {
        return this.key;
    }

    public String getPolicy() {
        return this.policy;
    }

    public String getPublicUrl() {
        return this.publicUrl;
    }

    public String getSignature() {
        return this.signature;
    }

    public String getSuccessActionStatus() {
        return this.successActionStatus;
    }

    public String getUploadDestination() {
        return this.uploadDestination;
    }

    public int hashCode() {
        return ((((((((((((((((((this.id ^ 1000003) * 1000003) ^ this.acl.hashCode()) * 1000003) ^ this.awsAccessKey.hashCode()) * 1000003) ^ this.contentType.hashCode()) * 1000003) ^ this.key.hashCode()) * 1000003) ^ this.policy.hashCode()) * 1000003) ^ this.publicUrl.hashCode()) * 1000003) ^ this.signature.hashCode()) * 1000003) ^ this.successActionStatus.hashCode()) * 1000003) ^ this.uploadDestination.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Upload{id=");
        sb.append(this.id);
        sb.append(", acl=");
        sb.append(this.acl);
        sb.append(", awsAccessKey=");
        sb.append(this.awsAccessKey);
        sb.append(", contentType=");
        sb.append(this.contentType);
        sb.append(", key=");
        sb.append(this.key);
        sb.append(", policy=");
        sb.append(this.policy);
        sb.append(", publicUrl=");
        sb.append(this.publicUrl);
        sb.append(", signature=");
        sb.append(this.signature);
        sb.append(", successActionStatus=");
        sb.append(this.successActionStatus);
        sb.append(", uploadDestination=");
        sb.append(this.uploadDestination);
        sb.append("}");
        return sb.toString();
    }
}
