package io.intercom.android.sdk.utilities;

import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.twig.Twig;
import java.util.Map;

public class AttributeSanitiser {
    private static final String EMAIL = "email";
    private static final String USER_ID = "user_id";
    private static final Twig twig = LumberMill.getLogger();

    public static void anonymousSanitisation(Map<String, ?> map) {
        String str = "email";
        if (map.containsKey(str)) {
            Object remove = map.remove(str);
            twig.e(String.format("You cannot update the email of an anonymous user. Please call registerIdentified user instead. The email: %s was NOT applied", new Object[]{remove}), new Object[0]);
        }
        String str2 = USER_ID;
        if (map.containsKey(str2)) {
            Object remove2 = map.remove(str2);
            twig.e(String.format("You cannot update the user_id of an anonymous user. Please call registerIdentified user instead. The user_id: %s was NOT applied", new Object[]{remove2}), new Object[0]);
        }
    }
}
