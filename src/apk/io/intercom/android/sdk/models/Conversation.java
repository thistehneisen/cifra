package io.intercom.android.sdk.models;

import io.intercom.android.sdk.utilities.NullSafety;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class Conversation {
    private final ComposerState composerState;
    private final List<Part> conversationParts;
    private final List<Participant> groupConversationParticipants;
    private final String id;
    private final String intercomLinkSolution;
    private final LastParticipatingAdmin lastParticipatingAdmin;
    private final List<OperatorClientCondition> operatorClientConditions;
    private final Map<String, Participant> participants;
    private final boolean read;
    private final boolean userParticipated;

    public static final class Builder {
        io.intercom.android.sdk.models.ComposerState.Builder composer_state;
        List<io.intercom.android.sdk.models.Part.Builder> conversation_parts;
        List<String> group_conversation_participant_ids;
        String id;
        String intercom_link_solution;
        io.intercom.android.sdk.models.LastParticipatingAdmin.Builder last_participating_admin;
        List<io.intercom.android.sdk.models.OperatorClientCondition.Builder> operator_client_conditions;
        List<io.intercom.android.sdk.models.Participant.Builder> participants;
        boolean read;
        boolean user_participated;

        public Conversation build() {
            return new Conversation(this);
        }

        public Builder withId(String str) {
            this.id = str;
            return this;
        }

        public Builder withParticipants(List<io.intercom.android.sdk.models.Participant.Builder> list) {
            this.participants = list;
            return this;
        }

        public Builder withParts(List<io.intercom.android.sdk.models.Part.Builder> list) {
            this.conversation_parts = list;
            return this;
        }
    }

    public Conversation() {
        this(new Builder());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Conversation.class != obj.getClass()) {
            return false;
        }
        Conversation conversation = (Conversation) obj;
        if (this.userParticipated == conversation.userParticipated && this.read == conversation.read && this.participants.equals(conversation.participants) && this.conversationParts.equals(conversation.conversationParts) && this.groupConversationParticipants.equals(conversation.groupConversationParticipants) && this.operatorClientConditions.equals(conversation.operatorClientConditions) && this.lastParticipatingAdmin.equals(conversation.lastParticipatingAdmin) && this.composerState.equals(conversation.composerState) && this.intercomLinkSolution.equals(conversation.intercomLinkSolution)) {
            return this.id.equals(conversation.id);
        }
        return false;
    }

    public ComposerState getComposerState() {
        return this.composerState;
    }

    public List<Participant> getGroupConversationParticipants() {
        return this.groupConversationParticipants;
    }

    public String getId() {
        return this.id;
    }

    public String getIntercomLinkSolution() {
        return this.intercomLinkSolution;
    }

    public Participant getLastAdmin() {
        ListIterator listIterator = new ArrayList(this.participants.values()).listIterator(this.participants.values().size());
        while (listIterator.hasPrevious()) {
            Participant participant = (Participant) listIterator.previous();
            if (participant.isAdmin()) {
                return participant;
            }
        }
        return Participant.NULL;
    }

    public Part getLastAdminPart() {
        for (int size = this.conversationParts.size() - 1; size >= 0; size--) {
            Part part = (Part) this.conversationParts.get(size);
            if (part.isAdmin()) {
                return part;
            }
        }
        return Part.NULL;
    }

    public Part getLastNonEventPart() {
        for (int size = this.conversationParts.size() - 1; size >= 0; size--) {
            Part part = (Part) this.conversationParts.get(size);
            if (!part.isEvent().booleanValue()) {
                return part;
            }
        }
        return Part.NULL;
    }

    public Part getLastPart() {
        if (this.conversationParts.isEmpty()) {
            return Part.NULL;
        }
        List<Part> list = this.conversationParts;
        return (Part) list.get(list.size() - 1);
    }

    public LastParticipatingAdmin getLastParticipatingAdmin() {
        return this.lastParticipatingAdmin;
    }

    public List<OperatorClientCondition> getOperatorClientConditions() {
        return this.operatorClientConditions;
    }

    public Participant getParticipant(String str) {
        Participant participant = (Participant) this.participants.get(str);
        return participant == null ? Participant.NULL : participant;
    }

    public Map<String, Participant> getParticipants() {
        return this.participants;
    }

    public List<Part> getParts() {
        return this.conversationParts;
    }

    public int hashCode() {
        return (((((((((((((((((this.participants.hashCode() * 31) + this.conversationParts.hashCode()) * 31) + this.groupConversationParticipants.hashCode()) * 31) + this.operatorClientConditions.hashCode()) * 31) + this.lastParticipatingAdmin.hashCode()) * 31) + this.composerState.hashCode()) * 31) + this.id.hashCode()) * 31) + (this.userParticipated ? 1 : 0)) * 31) + (this.read ? 1 : 0)) * 31) + this.intercomLinkSolution.hashCode();
    }

    public boolean isAdminReply() {
        return this.participants.size() > 1;
    }

    public boolean isRead() {
        return this.read;
    }

    public boolean isUserParticipated() {
        return this.userParticipated;
    }

    public Conversation withRead(boolean z) {
        Conversation conversation = new Conversation(this.participants, this.conversationParts, this.groupConversationParticipants, this.operatorClientConditions, this.lastParticipatingAdmin, this.composerState, this.id, this.userParticipated, z, this.intercomLinkSolution);
        return conversation;
    }

    Conversation(Builder builder) {
        this.id = NullSafety.valueOrEmpty(builder.id);
        this.read = builder.read;
        this.userParticipated = builder.user_participated;
        this.participants = new LinkedHashMap();
        this.intercomLinkSolution = NullSafety.valueOrEmpty(builder.intercom_link_solution);
        List<io.intercom.android.sdk.models.Participant.Builder> list = builder.participants;
        if (list != null) {
            for (io.intercom.android.sdk.models.Participant.Builder build : list) {
                Participant build2 = build.build();
                this.participants.put(build2.getId(), build2);
            }
        }
        this.conversationParts = new ArrayList();
        List<io.intercom.android.sdk.models.Part.Builder> list2 = builder.conversation_parts;
        if (list2 != null) {
            for (io.intercom.android.sdk.models.Part.Builder build3 : list2) {
                Part build4 = build3.build();
                build4.setParticipant(getParticipant(build4.getParticipantId()));
                this.conversationParts.add(build4);
            }
        }
        this.groupConversationParticipants = new ArrayList();
        List<String> list3 = builder.group_conversation_participant_ids;
        if (list3 != null) {
            for (String str : list3) {
                if (str != null) {
                    this.groupConversationParticipants.add(getParticipant(str));
                }
            }
        }
        this.operatorClientConditions = new ArrayList();
        List<io.intercom.android.sdk.models.OperatorClientCondition.Builder> list4 = builder.operator_client_conditions;
        if (list4 != null) {
            for (io.intercom.android.sdk.models.OperatorClientCondition.Builder builder2 : list4) {
                if (builder2 != null) {
                    this.operatorClientConditions.add(builder2.build());
                }
            }
        }
        io.intercom.android.sdk.models.LastParticipatingAdmin.Builder builder3 = builder.last_participating_admin;
        this.lastParticipatingAdmin = builder3 != null ? builder3.build() : LastParticipatingAdmin.NULL;
        io.intercom.android.sdk.models.ComposerState.Builder builder4 = builder.composer_state;
        this.composerState = builder4 != null ? builder4.build() : ComposerState.NULL;
    }

    private Conversation(Map<String, Participant> map, List<Part> list, List<Participant> list2, List<OperatorClientCondition> list3, LastParticipatingAdmin lastParticipatingAdmin2, ComposerState composerState2, String str, boolean z, boolean z2, String str2) {
        this.participants = map;
        this.conversationParts = list;
        this.groupConversationParticipants = list2;
        this.operatorClientConditions = list3;
        this.lastParticipatingAdmin = lastParticipatingAdmin2;
        this.composerState = composerState2;
        this.id = str;
        this.userParticipated = z;
        this.read = z2;
        this.intercomLinkSolution = str2;
    }
}
