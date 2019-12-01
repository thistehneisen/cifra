package io.intercom.android.sdk.utilities;

import io.intercom.android.sdk.views.holder.AttributeType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.regex.Pattern;

public class AttributeValidatorUtils {
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])", 2);
    private static final Pattern VALID_FLOAT_REGEX = Pattern.compile("^[-+]?\\d*\\.?\\d*$");
    private static final Pattern VALID_NUMBER_REGEX = Pattern.compile("^[-+]?\\d+$");
    private static final Pattern VALID_WEBSITE_REGEX = Pattern.compile("^(https?://)?(www\\.)?([\\w]+\\.)+[‌​\\w]{2,63}/?$");

    @Retention(RetentionPolicy.SOURCE)
    public @interface AttributeResponseCode {
        public static final int INVALID_COUNTRY_CODE = 6;
        public static final int INVALID_EMAIL = 2;
        public static final int INVALID_NUMBER = 3;
        public static final int INVALID_NUMBER_HAS_TOO_MANY_DIGITS = 5;
        public static final int INVALID_NUMBER_NEEDS_PREFIX = 4;
        public static final int INVALID_NUMBER_NOT_ENOUGH_DIGITS = 7;
        public static final int INVALID_STRING = 1;
        public static final int OK = 0;
    }

    public static int validateAttribute(String str, String str2) {
        char c2;
        int i2 = 2;
        int i3 = 3;
        switch (str2.hashCode()) {
            case -1034364087:
                if (str2.equals(AttributeType.NUMBER)) {
                    c2 = 2;
                    break;
                }
            case 75849770:
                if (str2.equals(AttributeType.WEBSITE)) {
                    c2 = 1;
                    break;
                }
            case 96619420:
                if (str2.equals("email")) {
                    c2 = 0;
                    break;
                }
            case 97526364:
                if (str2.equals(AttributeType.FLOAT)) {
                    c2 = 3;
                    break;
                }
            case 106642798:
                if (str2.equals(AttributeType.PHONE)) {
                    c2 = 4;
                    break;
                }
            default:
                c2 = 65535;
                break;
        }
        if (c2 == 0) {
            if (VALID_EMAIL_ADDRESS_REGEX.matcher(str).matches()) {
                i2 = 0;
            }
            return i2;
        } else if (c2 == 1) {
            return VALID_WEBSITE_REGEX.matcher(str).matches() ^ true ? 1 : 0;
        } else {
            if (c2 == 2) {
                if (VALID_NUMBER_REGEX.matcher(str).matches()) {
                    i3 = 0;
                }
                return i3;
            } else if (c2 == 3) {
                if (VALID_FLOAT_REGEX.matcher(str).matches()) {
                    i3 = 0;
                }
                return i3;
            } else if (c2 != 4) {
                return 0;
            } else {
                return PhoneNumberValidator.validatePhoneNumber(str);
            }
        }
    }
}
