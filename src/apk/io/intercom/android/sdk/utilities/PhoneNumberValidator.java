package io.intercom.android.sdk.utilities;

import android.content.Context;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.models.CountryAreaCode;
import io.intercom.android.sdk.models.CountryAreaCode.Builder;
import io.intercom.com.google.gson.o;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {
    private static final int MAX_LENGTH_WITHOUT_PREFIX = 15;
    private static final int MIN_LENGTH_WITHOUT_PREFIX = 6;
    private static final String NON_NUMBER_PATTERN = "\\D";
    private static final String PREFIX_PATTERN = "^(\\+)|(00)";
    private static final int PRIORITY_CONFLICTS_WITH_NO_SUB_CODES = 1;
    private static final int PRIORITY_CONFLICTS_WITH_SUB_CODES = 2;
    private static final int PRIORITY_NO_CONFLICTING_CODES = 0;
    private static final String SPECIAL_CHARACTERS = "^(\\()|(\\))|(-)";
    private static final String WHITESPACE_PATTERN = "\\s+";
    private static final List<CountryAreaCode> countryAreaCodes = new ArrayList();

    static boolean containsPrefix(String str) {
        Matcher matcher = Pattern.compile(PREFIX_PATTERN).matcher(str);
        boolean z = false;
        if (!matcher.find()) {
            return false;
        }
        if (matcher.start() == 0) {
            z = true;
        }
        return z;
    }

    public static CountryAreaCode getCountryAreaCodeFromLocale(String str) {
        for (CountryAreaCode countryAreaCode : countryAreaCodes) {
            if (str.equalsIgnoreCase(countryAreaCode.getCode())) {
                return countryAreaCode;
            }
        }
        return CountryAreaCode.UNKNOWN;
    }

    public static CountryAreaCode getCountryAreaCodeFromNumber(String str) {
        CountryAreaCode countryAreaCode = CountryAreaCode.UNKNOWN;
        for (CountryAreaCode countryAreaCode2 : countryAreaCodes) {
            if (str.startsWith(countryAreaCode2.getDialCode())) {
                int priority = countryAreaCode2.getPriority();
                if (priority == 0) {
                    return countryAreaCode2;
                }
                if (priority == 1) {
                    countryAreaCode = countryAreaCode2;
                } else if (priority == 2) {
                    String substring = str.substring(countryAreaCode2.getDialCode().length());
                    for (String startsWith : countryAreaCode2.getAreaCodes()) {
                        if (substring.startsWith(startsWith)) {
                            return countryAreaCode2;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            }
        }
        return countryAreaCode;
    }

    public static void loadCountryAreaCodes(Context context) {
        if (countryAreaCodes.isEmpty()) {
            for (Builder build : parseCodes(context)) {
                countryAreaCodes.add(build.build());
            }
        }
    }

    private static String loadJsonFromAsset(Context context) {
        try {
            InputStream openRawResource = context.getResources().openRawResource(R.raw.intercom_area_codes);
            byte[] bArr = new byte[openRawResource.available()];
            openRawResource.read(bArr);
            openRawResource.close();
            return new String(bArr, "UTF-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String normalizeNumber(String str) {
        String str2 = "";
        return str.replaceAll(WHITESPACE_PATTERN, str2).replaceAll(SPECIAL_CHARACTERS, str2);
    }

    static List<Builder> parseCodes(Context context) {
        Builder[] builderArr = (Builder[]) new o().a(loadJsonFromAsset(context), Builder[].class);
        return builderArr != null ? Arrays.asList(builderArr) : new ArrayList();
    }

    public static String stripPrefix(String str) {
        return str.replaceFirst(PREFIX_PATTERN, "");
    }

    static int validatePhoneNumber(String str) {
        String normalizeNumber = normalizeNumber(str);
        if (!containsPrefix(normalizeNumber)) {
            return 4;
        }
        String stripPrefix = stripPrefix(normalizeNumber);
        String str2 = NON_NUMBER_PATTERN;
        if (Pattern.compile(str2).matcher(stripPrefix).find()) {
            return 3;
        }
        String replaceAll = stripPrefix.replaceAll(str2, "");
        if (replaceAll.length() > 15) {
            return 5;
        }
        CountryAreaCode countryAreaCodeFromNumber = getCountryAreaCodeFromNumber(replaceAll);
        int length = countryAreaCodeFromNumber.getDialCode().length();
        if (countryAreaCodeFromNumber.equals(CountryAreaCode.UNKNOWN)) {
            return 6;
        }
        return replaceAll.substring(length).length() < 6 ? 7 : 0;
    }
}
