package io.intercom.android.sdk.models;

import java.util.List;

final class AutoValue_TeamPresence extends TeamPresence {
    private final List<Participant> activeAdmins;
    private final String expectedResponseDelay;
    private final String officeHours;

    AutoValue_TeamPresence(List<Participant> list, String str, String str2) {
        if (list != null) {
            this.activeAdmins = list;
            if (str != null) {
                this.expectedResponseDelay = str;
                if (str2 != null) {
                    this.officeHours = str2;
                    return;
                }
                throw new NullPointerException("Null officeHours");
            }
            throw new NullPointerException("Null expectedResponseDelay");
        }
        throw new NullPointerException("Null activeAdmins");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TeamPresence)) {
            return false;
        }
        TeamPresence teamPresence = (TeamPresence) obj;
        if (!this.activeAdmins.equals(teamPresence.getActiveAdmins()) || !this.expectedResponseDelay.equals(teamPresence.getExpectedResponseDelay()) || !this.officeHours.equals(teamPresence.getOfficeHours())) {
            z = false;
        }
        return z;
    }

    public List<Participant> getActiveAdmins() {
        return this.activeAdmins;
    }

    public String getExpectedResponseDelay() {
        return this.expectedResponseDelay;
    }

    public String getOfficeHours() {
        return this.officeHours;
    }

    public int hashCode() {
        return ((((this.activeAdmins.hashCode() ^ 1000003) * 1000003) ^ this.expectedResponseDelay.hashCode()) * 1000003) ^ this.officeHours.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TeamPresence{activeAdmins=");
        sb.append(this.activeAdmins);
        sb.append(", expectedResponseDelay=");
        sb.append(this.expectedResponseDelay);
        sb.append(", officeHours=");
        sb.append(this.officeHours);
        sb.append("}");
        return sb.toString();
    }
}
