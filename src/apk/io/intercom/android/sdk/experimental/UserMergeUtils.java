package io.intercom.android.sdk.experimental;

import io.intercom.android.sdk.identity.Registration;
import java.util.Map;

class UserMergeUtils {
    private static final String EMAIL = "email";
    private static final String USER_ID = "user_id";

    UserMergeUtils() {
    }

    static void addIdentityDataToRegistration(Registration registration, Map<String, Object> map) {
        String str = "email";
        if (map.containsKey(str)) {
            registration.withEmail(map.get(str).toString());
        }
        String str2 = USER_ID;
        if (map.containsKey(str2)) {
            registration.withUserId(map.get(str2).toString());
        }
    }

    static boolean hasIdentificationData(Map<String, Object> map) {
        return map.containsKey("email") || map.containsKey(USER_ID);
    }
}
