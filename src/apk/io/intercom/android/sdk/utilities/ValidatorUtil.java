package io.intercom.android.sdk.utilities;

import android.app.Application;
import io.intercom.android.sdk.api.ApiFactory;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.twig.Twig;

public class ValidatorUtil {
    private static final String API_PREFIX = "android_sdk-";
    private static final Twig twig = LumberMill.getLogger();

    static boolean apiKeyIsMissingPrefix(String str) {
        return str == null || !str.startsWith(API_PREFIX);
    }

    static boolean apiKeyIsTooShort(String str) {
        return str == null || str.length() < 52;
    }

    private static boolean appIdIsInvalid(String str) {
        return str == null || ApiFactory.removeInvalidCharacters(str).isEmpty();
    }

    public static boolean isValidConstructorParams(Application application, String str, String str2) {
        boolean z;
        if (application == null) {
            twig.e("The Application passed in was null.We need an Application to enable Intercom in your app", new Object[0]);
            z = false;
        } else {
            z = true;
        }
        if (appIdIsInvalid(str2)) {
            Twig twig2 = twig;
            StringBuilder sb = new StringBuilder();
            sb.append("The app ID (");
            sb.append(str2);
            sb.append(") you provided is either null or empty. We need a valid app ID to enable Intercom in your app");
            twig2.e(sb.toString(), new Object[0]);
            z = false;
        }
        String str3 = "The API key provided (";
        if (apiKeyIsTooShort(str)) {
            Twig twig3 = twig;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(str);
            sb2.append(") is too short.\nPlease check that you are using an Intercom Android SDK key and have not passed the appId into the apiKey field\n");
            twig3.e(sb2.toString(), new Object[0]);
            z = false;
        }
        if (!apiKeyIsMissingPrefix(str)) {
            return z;
        }
        Twig twig4 = twig;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str3);
        sb3.append(str);
        sb3.append(") does not begin with 'android_sdk-'.\nPlease check that you are using an Intercom Android SDK key and have not passed the appId into the apiKey field\n");
        twig4.e(sb3.toString(), new Object[0]);
        return false;
    }
}
