package io.intercom.android.sdk.api;

import android.content.SharedPreferences;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.commons.utilities.TimeProvider;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.com.google.gson.JsonSyntaxException;
import io.intercom.com.google.gson.o;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DeDuper {
    private static final String CUSTOM_ATTRIBUTES = "custom_attributes";
    private static final String EMPTY_JSON = "{}";
    private static final String PREFS_CACHED_ATTRIBUTES = "CachedAttributes";
    private static final String PREFS_EARLIEST_UPDATE_AT = "EarliestUpdateAt";
    private final Provider<AppConfig> appConfigProvider;
    private final Map<String, Object> cachedAttributes = new HashMap();
    private long earliestUpdateAt = 0;
    private final o gson = new o();
    private final SharedPreferences prefs;

    public DeDuper(Provider<AppConfig> provider, SharedPreferences sharedPreferences) {
        this.appConfigProvider = provider;
        this.prefs = sharedPreferences;
    }

    private static boolean containsOnlyEmptyCustomAttributes(Map<String, Object> map) {
        return map.size() == 1 && Collections.EMPTY_MAP.equals(map.get(CUSTOM_ATTRIBUTES));
    }

    private static Map<String, Object> getCustomAttributes(Map<String, ?> map) {
        Object obj = map.get(CUSTOM_ATTRIBUTES);
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    private boolean hasExpiredCache() {
        boolean z = false;
        if (this.earliestUpdateAt == 0) {
            return false;
        }
        if (TimeProvider.SYSTEM.currentTimeMillis() - this.earliestUpdateAt > ((AppConfig) this.appConfigProvider.get()).getUserUpdateCacheMaxAgeMs()) {
            z = true;
        }
        return z;
    }

    private boolean hasNewAttributeValues(Map<String, Object> map) {
        Map customAttributes = getCustomAttributes(this.cachedAttributes);
        Map customAttributes2 = getCustomAttributes(map);
        if (customAttributes2 != null) {
            if (customAttributes == null) {
                return true;
            }
            for (Entry entry : customAttributes2.entrySet()) {
                Object value = entry.getValue();
                if (value != null && !value.equals(customAttributes.get(entry.getKey()))) {
                    return true;
                }
            }
        }
        for (Entry entry2 : map.entrySet()) {
            if (!CUSTOM_ATTRIBUTES.equals(entry2.getKey())) {
                Object value2 = entry2.getValue();
                if (value2 != null && !value2.equals(this.cachedAttributes.get(entry2.getKey()))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isEmpty() {
        return this.cachedAttributes.isEmpty();
    }

    private static Map<String, Object> mergeMaps(Map<String, ?> map, Map<String, ?> map2) {
        HashMap hashMap = new HashMap(map);
        hashMap.putAll(map2);
        return hashMap;
    }

    private void persistCachedAttributes() {
        HashMap hashMap = new HashMap(this.cachedAttributes);
        this.prefs.edit().putString(PREFS_CACHED_ATTRIBUTES, this.gson.a((Object) hashMap)).putLong(PREFS_EARLIEST_UPDATE_AT, this.earliestUpdateAt).apply();
    }

    /* access modifiers changed from: 0000 */
    public long getEarliestUpdateAt() {
        return this.earliestUpdateAt;
    }

    /* access modifiers changed from: 0000 */
    public Map<String, Object> getMap() {
        return this.cachedAttributes;
    }

    public void readPersistedCachedAttributes() {
        SharedPreferences sharedPreferences = this.prefs;
        String str = PREFS_CACHED_ATTRIBUTES;
        if (sharedPreferences.contains(str)) {
            SharedPreferences sharedPreferences2 = this.prefs;
            String str2 = PREFS_EARLIEST_UPDATE_AT;
            if (sharedPreferences2.contains(str2)) {
                try {
                    this.cachedAttributes.putAll((Map) this.gson.a(this.prefs.getString(str, EMPTY_JSON), Map.class));
                    this.earliestUpdateAt = this.prefs.getLong(str2, 0);
                } catch (JsonSyntaxException unused) {
                }
            }
        }
    }

    public void reset() {
        this.cachedAttributes.clear();
        this.earliestUpdateAt = 0;
        persistCachedAttributes();
    }

    /* access modifiers changed from: 0000 */
    public void setEarliestUpdateAt(long j2) {
        this.earliestUpdateAt = j2;
    }

    public boolean shouldUpdateUser(Map<String, Object> map) {
        if (map.isEmpty() || containsOnlyEmptyCustomAttributes(map)) {
            return false;
        }
        if (hasNewAttributeValues(map) || isEmpty() || hasExpiredCache()) {
            return true;
        }
        return false;
    }

    public void update(Map<String, ?> map) {
        if (hasExpiredCache()) {
            this.cachedAttributes.clear();
            setEarliestUpdateAt(TimeProvider.SYSTEM.currentTimeMillis());
        }
        if (this.earliestUpdateAt == 0) {
            setEarliestUpdateAt(TimeProvider.SYSTEM.currentTimeMillis());
        }
        Map customAttributes = getCustomAttributes(this.cachedAttributes);
        Map customAttributes2 = getCustomAttributes(map);
        this.cachedAttributes.putAll(map);
        if (!(customAttributes == null || customAttributes2 == null)) {
            this.cachedAttributes.put(CUSTOM_ATTRIBUTES, mergeMaps(customAttributes, customAttributes2));
        }
        persistCachedAttributes();
    }
}
