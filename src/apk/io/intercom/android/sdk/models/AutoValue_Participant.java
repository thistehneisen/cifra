package io.intercom.android.sdk.models;

final class AutoValue_Participant extends Participant {
    private final Avatar getAvatar;
    private final String getEmail;
    private final String getId;
    private final String getName;
    private final String getType;
    private final Boolean isBot;

    AutoValue_Participant(String str, String str2, String str3, String str4, Avatar avatar, Boolean bool) {
        if (str != null) {
            this.getId = str;
            if (str2 != null) {
                this.getName = str2;
                if (str3 != null) {
                    this.getType = str3;
                    if (str4 != null) {
                        this.getEmail = str4;
                        if (avatar != null) {
                            this.getAvatar = avatar;
                            if (bool != null) {
                                this.isBot = bool;
                                return;
                            }
                            throw new NullPointerException("Null isBot");
                        }
                        throw new NullPointerException("Null getAvatar");
                    }
                    throw new NullPointerException("Null getEmail");
                }
                throw new NullPointerException("Null getType");
            }
            throw new NullPointerException("Null getName");
        }
        throw new NullPointerException("Null getId");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Participant)) {
            return false;
        }
        Participant participant = (Participant) obj;
        if (!this.getId.equals(participant.getId()) || !this.getName.equals(participant.getName()) || !this.getType.equals(participant.getType()) || !this.getEmail.equals(participant.getEmail()) || !this.getAvatar.equals(participant.getAvatar()) || !this.isBot.equals(participant.isBot())) {
            z = false;
        }
        return z;
    }

    public Avatar getAvatar() {
        return this.getAvatar;
    }

    public String getEmail() {
        return this.getEmail;
    }

    public String getId() {
        return this.getId;
    }

    public String getName() {
        return this.getName;
    }

    public String getType() {
        return this.getType;
    }

    public int hashCode() {
        return ((((((((((this.getId.hashCode() ^ 1000003) * 1000003) ^ this.getName.hashCode()) * 1000003) ^ this.getType.hashCode()) * 1000003) ^ this.getEmail.hashCode()) * 1000003) ^ this.getAvatar.hashCode()) * 1000003) ^ this.isBot.hashCode();
    }

    public Boolean isBot() {
        return this.isBot;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Participant{getId=");
        sb.append(this.getId);
        sb.append(", getName=");
        sb.append(this.getName);
        sb.append(", getType=");
        sb.append(this.getType);
        sb.append(", getEmail=");
        sb.append(this.getEmail);
        sb.append(", getAvatar=");
        sb.append(this.getAvatar);
        sb.append(", isBot=");
        sb.append(this.isBot);
        sb.append("}");
        return sb.toString();
    }
}
