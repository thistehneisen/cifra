package io.intercom.android.sdk.models;

import java.util.ArrayList;
import java.util.List;

public class CountryAreaCode {
    public static final CountryAreaCode UNKNOWN = new Builder().build();
    private List<String> areaCodes;
    private String code;
    private String dialCode;
    private String emoji;
    private int priority;

    public static final class Builder {
        List<String> areaCodes;
        String code;
        String dialCode;
        String emoji;
        Integer priority;

        public CountryAreaCode build() {
            return new CountryAreaCode(this);
        }
    }

    CountryAreaCode(Builder builder) {
        String str = builder.code;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        this.code = str;
        String str3 = builder.dialCode;
        if (str3 == null) {
            str3 = str2;
        }
        this.dialCode = str3;
        String str4 = builder.emoji;
        if (str4 == null) {
            str4 = "🌎";
        }
        this.emoji = str4;
        Integer num = builder.priority;
        this.priority = num == null ? 0 : num.intValue();
        this.areaCodes = new ArrayList();
        List<String> list = builder.areaCodes;
        if (list != null) {
            for (String str5 : list) {
                if (str5 != null) {
                    this.areaCodes.add(str5);
                }
            }
        }
    }

    public List<String> getAreaCodes() {
        return this.areaCodes;
    }

    public String getCode() {
        return this.code;
    }

    public String getDialCode() {
        return this.dialCode;
    }

    public String getEmoji() {
        return this.emoji;
    }

    public int getPriority() {
        return this.priority;
    }
}
