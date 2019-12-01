package io.intercom.android.sdk.nexus;

import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public enum NexusEventType {
    NewComment {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            jsonObject.put("nx.ToUser", nexusEvent.getUserId());
            return jsonObject;
        }
    },
    ConversationSeen {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            jsonObject.put("nx.FromUser", nexusEvent.getUserId());
            return jsonObject;
        }
    },
    UserIsTyping {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            jsonObject.put("nx.FromUser", nexusEvent.getUserId());
            return jsonObject;
        }
    },
    AdminIsTyping {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            JSONObject optJSONObject = jsonObject.optJSONObject("eventData");
            String str = "adminName";
            optJSONObject.put(str, nexusEvent.getEventData().optString(str));
            String str2 = "adminId";
            optJSONObject.put(str2, nexusEvent.getEventData().optString(str2));
            String str3 = "adminAvatar";
            optJSONObject.put(str3, nexusEvent.getEventData().optString(str3));
            jsonObject.put("nx.ToUser", nexusEvent.getUserId());
            return jsonObject;
        }
    },
    AdminIsTypingANote {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            JSONObject optJSONObject = jsonObject.optJSONObject("eventData");
            String str = "adminName";
            optJSONObject.put(str, nexusEvent.getEventData().optString(str));
            String str2 = "adminId";
            optJSONObject.put(str2, nexusEvent.getEventData().optString(str2));
            String str3 = "adminAvatar";
            optJSONObject.put(str3, nexusEvent.getEventData().optString(str3));
            jsonObject.put("nx.ToUser", nexusEvent.getUserId());
            return jsonObject;
        }
    },
    NewNote {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            String str = "adminId";
            jsonObject.optJSONObject("eventData").put(str, nexusEvent.getEventData().optString(str));
            return jsonObject;
        }
    },
    ConversationAssigned {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            JSONObject optJSONObject = jsonObject.optJSONObject("eventData");
            String str = "adminId";
            optJSONObject.put(str, nexusEvent.getEventData().optString(str));
            String str2 = "assigneeId";
            optJSONObject.put(str2, nexusEvent.getEventData().optString(str2));
            return jsonObject;
        }
    },
    ConversationClosed {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            String str = "adminId";
            jsonObject.optJSONObject("eventData").put(str, nexusEvent.getEventData().optString(str));
            return jsonObject;
        }
    },
    ConversationReopened {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            String str = "adminId";
            jsonObject.getJSONObject("eventData").put(str, nexusEvent.getEventData().optString(str));
            return jsonObject;
        }
    },
    UserPresence {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("eventGuid", UUID.randomUUID().toString());
            StringBuilder sb = new StringBuilder();
            sb.append("nx.");
            sb.append(name());
            jSONObject.put("eventName", sb.toString());
            jSONObject.put("eventData", jSONObject2);
            return jSONObject;
        }
    },
    UserContentSeenByAdmin {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            jsonObject.put("nx.ToUser", nexusEvent.getUserId());
            return jsonObject;
        }
    },
    Subscribe {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            StringBuilder sb = new StringBuilder();
            sb.append("nx.");
            sb.append(name());
            jsonObject.put("eventName", sb.toString());
            return jsonObject;
        }
    },
    Unsubscribe {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            StringBuilder sb = new StringBuilder();
            sb.append("nx.");
            sb.append(name());
            jsonObject.put("eventName", sb.toString());
            return jsonObject;
        }
    },
    ThreadAssigned {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            JSONObject optJSONObject = jsonObject.optJSONObject("eventData");
            String str = "adminId";
            optJSONObject.put(str, nexusEvent.getEventData().optString(str));
            String str2 = "assigneeId";
            optJSONObject.put(str2, nexusEvent.getEventData().optString(str2));
            return jsonObject;
        }
    },
    ThreadClosed {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            String str = "adminId";
            jsonObject.optJSONObject("eventData").put(str, nexusEvent.getEventData().optString(str));
            return jsonObject;
        }
    },
    ThreadReopened {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            String str = "adminId";
            jsonObject.getJSONObject("eventData").put(str, nexusEvent.getEventData().optString(str));
            return jsonObject;
        }
    },
    ThreadUpdated {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            String str = "adminId";
            jsonObject.getJSONObject("eventData").put(str, nexusEvent.getEventData().optString(str));
            return jsonObject;
        }
    },
    ThreadCreated {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            jsonObject.put("nx.ToUser", nexusEvent.getUserId());
            return jsonObject;
        }
    },
    UNKNOWN {
        /* access modifiers changed from: protected */
        public String toStringEncodedJsonObject(NexusEvent nexusEvent) {
            return "";
        }
    };

    public static NexusEventType safeValueOf(String str) {
        try {
            return valueOf(str);
        } catch (Exception unused) {
            return UNKNOWN;
        }
    }

    /* access modifiers changed from: protected */
    public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        String str = "conversationId";
        jSONObject2.put(str, nexusEvent.getEventData().optString(str));
        jSONObject.put("eventGuid", nexusEvent.getGuid());
        jSONObject.put("eventName", name());
        jSONObject.put("eventData", jSONObject2);
        List topics = nexusEvent.getTopics();
        if (!topics.isEmpty()) {
            jSONObject.put("nx.Topics", new JSONArray(topics));
        }
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    public String toStringEncodedJsonObject(NexusEvent nexusEvent) {
        try {
            return toJsonObject(nexusEvent).toString();
        } catch (JSONException unused) {
            return "";
        }
    }
}
