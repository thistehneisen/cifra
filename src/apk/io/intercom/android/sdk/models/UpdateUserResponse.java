package io.intercom.android.sdk.models;

public class UpdateUserResponse extends UsersResponse {
    private final TeamPresence teamPresence;

    public static final class Builder extends io.intercom.android.sdk.models.UsersResponse.Builder {
        io.intercom.android.sdk.models.TeamPresence.Builder team_presence;

        public UpdateUserResponse build() {
            return new UpdateUserResponse(this);
        }
    }

    UpdateUserResponse(Builder builder) {
        TeamPresence teamPresence2;
        super(builder);
        io.intercom.android.sdk.models.TeamPresence.Builder builder2 = builder.team_presence;
        if (builder2 == null) {
            teamPresence2 = new io.intercom.android.sdk.models.TeamPresence.Builder().build();
        } else {
            teamPresence2 = builder2.build();
        }
        this.teamPresence = teamPresence2;
    }

    public TeamPresence getTeamPresence() {
        return this.teamPresence;
    }
}
