package io.intercom.android.sdk.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class UserUpdateRequest {
    private static final String CUSTOM_ATTRIBUTES = "custom_attributes";
    private final Map<String, Object> attributes;
    private final int batchSize;
    private final boolean internalUpdate;
    private final boolean newSession;
    private final boolean sentFromBackground;

    public UserUpdateRequest() {
        this(false, true, null, 0, false);
    }

    private boolean attributesWillOverwriteExistingAttributes(Map<String, Object> map) {
        Map customAttributes = getCustomAttributes(this.attributes);
        Map customAttributes2 = getCustomAttributes(map);
        if (!(customAttributes == null || customAttributes2 == null)) {
            for (Entry entry : customAttributes.entrySet()) {
                Object obj = customAttributes2.get(entry.getKey());
                if (obj != null && !obj.equals(entry.getValue())) {
                    return true;
                }
            }
        }
        for (Entry entry2 : this.attributes.entrySet()) {
            if (!CUSTOM_ATTRIBUTES.equals(entry2.getKey())) {
                Object obj2 = map.get(entry2.getKey());
                if (obj2 != null && !obj2.equals(entry2.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static Map<String, Object> getCustomAttributes(Map<String, Object> map) {
        Object obj = map.get(CUSTOM_ATTRIBUTES);
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    private static Map<String, Object> mergeAttributes(Map<String, Object> map, Map<String, Object> map2) {
        HashMap hashMap = new HashMap(map);
        Map customAttributes = getCustomAttributes(hashMap);
        Map customAttributes2 = getCustomAttributes(map2);
        hashMap.putAll(map2);
        String str = CUSTOM_ATTRIBUTES;
        if (customAttributes2 != null && !customAttributes2.isEmpty()) {
            if (customAttributes == null) {
                customAttributes = new HashMap();
            }
            customAttributes.putAll(customAttributes2);
            hashMap.put(str, customAttributes);
        } else if (customAttributes != null) {
            hashMap.put(str, customAttributes);
        } else {
            hashMap.remove(str);
        }
        return hashMap;
    }

    public boolean canMergeUpdate(UserUpdateRequest userUpdateRequest) {
        return !attributesWillOverwriteExistingAttributes(userUpdateRequest.attributes) && (!this.newSession || !userUpdateRequest.newSession);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || UserUpdateRequest.class != obj.getClass()) {
            return false;
        }
        UserUpdateRequest userUpdateRequest = (UserUpdateRequest) obj;
        if (this.newSession == userUpdateRequest.newSession && this.batchSize == userUpdateRequest.batchSize && this.sentFromBackground == userUpdateRequest.sentFromBackground && this.internalUpdate == userUpdateRequest.internalUpdate) {
            return this.attributes.equals(userUpdateRequest.attributes);
        }
        return false;
    }

    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

    public int getBatchSize() {
        return this.batchSize;
    }

    public int hashCode() {
        return (((((((this.attributes.hashCode() * 31) + (this.newSession ? 1 : 0)) * 31) + this.batchSize) * 31) + (this.sentFromBackground ? 1 : 0)) * 31) + (this.internalUpdate ? 1 : 0);
    }

    public boolean isInternalUpdate() {
        return this.internalUpdate;
    }

    public boolean isNewSession() {
        return this.newSession;
    }

    public boolean isSentFromBackground() {
        return this.sentFromBackground;
    }

    public boolean isValidUpdate() {
        return this.internalUpdate || !this.attributes.isEmpty();
    }

    public UserUpdateRequest merge(UserUpdateRequest userUpdateRequest) {
        boolean z = this.internalUpdate || userUpdateRequest.internalUpdate;
        UserUpdateRequest userUpdateRequest2 = new UserUpdateRequest(this.newSession || userUpdateRequest.newSession, this.sentFromBackground && userUpdateRequest.sentFromBackground, mergeAttributes(this.attributes, userUpdateRequest.attributes), this.batchSize + userUpdateRequest.batchSize, z);
        return userUpdateRequest2;
    }

    public UserUpdateRequest(boolean z, boolean z2, boolean z3) {
        this(z, z2, null, 1, z3);
    }

    public UserUpdateRequest(boolean z, boolean z2, Map<String, Object> map, boolean z3) {
        this(z, z2, map, 1, z3);
    }

    UserUpdateRequest(boolean z, boolean z2, Map<String, Object> map, int i2, boolean z3) {
        this.attributes = new HashMap();
        if (map != null) {
            this.attributes.putAll(map);
        }
        this.sentFromBackground = z2;
        this.newSession = z;
        this.batchSize = i2;
        this.internalUpdate = z3;
    }
}
