package com.crashlytics.android.answers;

import android.os.Bundle;
import io.fabric.sdk.android.a.c.c;
import io.fabric.sdk.android.f;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FirebaseAnalyticsEventMapper {
    private static final Set<String> EVENT_NAMES = new HashSet(Arrays.asList(new String[]{"app_clear_data", "app_exception", "app_remove", "app_upgrade", "app_install", "app_update", "firebase_campaign", "error", "first_open", "first_visit", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "user_engagement", "ad_exposure", "adunit_exposure", "ad_query", "ad_activeview", "ad_impression", "ad_click", "screen_view", "firebase_extra_parameter"}));
    private static final String FIREBASE_LEVEL_NAME = "level_name";
    private static final String FIREBASE_METHOD = "method";
    private static final String FIREBASE_RATING = "rating";
    private static final String FIREBASE_SUCCESS = "success";

    private String mapAttribute(String str) {
        if (str == null || str.length() == 0) {
            return "fabric_unnamed_parameter";
        }
        String replaceAll = str.replaceAll("[^\\p{Alnum}_]+", c.ROLL_OVER_FILE_NAME_SEPARATOR);
        if (replaceAll.startsWith("ga_") || replaceAll.startsWith("google_") || replaceAll.startsWith("firebase_") || !Character.isLetter(replaceAll.charAt(0))) {
            StringBuilder sb = new StringBuilder();
            sb.append("fabric_");
            sb.append(replaceAll);
            replaceAll = sb.toString();
        }
        if (replaceAll.length() > 40) {
            replaceAll = replaceAll.substring(0, 40);
        }
        return replaceAll;
    }

    private Integer mapBooleanValue(String str) {
        if (str == null) {
            return null;
        }
        return Integer.valueOf(str.equals("true") ? 1 : 0);
    }

    private void mapCustomEventAttributes(Bundle bundle, Map<String, Object> map) {
        for (Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            String mapAttribute = mapAttribute((String) entry.getKey());
            if (value instanceof String) {
                bundle.putString(mapAttribute, entry.getValue().toString());
            } else if (value instanceof Double) {
                bundle.putDouble(mapAttribute, ((Double) entry.getValue()).doubleValue());
            } else if (value instanceof Long) {
                bundle.putLong(mapAttribute, ((Long) entry.getValue()).longValue());
            } else if (value instanceof Integer) {
                bundle.putInt(mapAttribute, ((Integer) entry.getValue()).intValue());
            }
        }
    }

    private String mapCustomEventName(String str) {
        if (str == null || str.length() == 0) {
            return "fabric_unnamed_event";
        }
        String str2 = "fabric_";
        if (EVENT_NAMES.contains(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(str);
            return sb.toString();
        }
        String replaceAll = str.replaceAll("[^\\p{Alnum}_]+", c.ROLL_OVER_FILE_NAME_SEPARATOR);
        if (replaceAll.startsWith("ga_") || replaceAll.startsWith("google_") || replaceAll.startsWith("firebase_") || !Character.isLetter(replaceAll.charAt(0))) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(replaceAll);
            replaceAll = sb2.toString();
        }
        if (replaceAll.length() > 40) {
            replaceAll = replaceAll.substring(0, 40);
        }
        return replaceAll;
    }

    private Double mapDouble(Object obj) {
        String valueOf = String.valueOf(obj);
        if (valueOf == null) {
            return null;
        }
        return Double.valueOf(valueOf);
    }

    private Bundle mapPredefinedEvent(SessionEvent sessionEvent) {
        Bundle bundle = new Bundle();
        String str = "itemType";
        String str2 = "item_category";
        String str3 = "itemName";
        String str4 = "itemId";
        String str5 = "itemPrice";
        String str6 = "value";
        String str7 = "item_name";
        String str8 = "item_id";
        String str9 = "currency";
        if ("purchase".equals(sessionEvent.predefinedType)) {
            putString(bundle, str8, (String) sessionEvent.predefinedAttributes.get(str4));
            putString(bundle, str7, (String) sessionEvent.predefinedAttributes.get(str3));
            putString(bundle, str2, (String) sessionEvent.predefinedAttributes.get(str));
            putDouble(bundle, str6, mapPriceValue(sessionEvent.predefinedAttributes.get(str5)));
            putString(bundle, str9, (String) sessionEvent.predefinedAttributes.get(str9));
        } else {
            if ("addToCart".equals(sessionEvent.predefinedType)) {
                putString(bundle, str8, (String) sessionEvent.predefinedAttributes.get(str4));
                putString(bundle, str7, (String) sessionEvent.predefinedAttributes.get(str3));
                putString(bundle, str2, (String) sessionEvent.predefinedAttributes.get(str));
                putDouble(bundle, "price", mapPriceValue(sessionEvent.predefinedAttributes.get(str5)));
                putDouble(bundle, str6, mapPriceValue(sessionEvent.predefinedAttributes.get(str5)));
                putString(bundle, str9, (String) sessionEvent.predefinedAttributes.get(str9));
                bundle.putLong("quantity", 1);
            } else {
                if ("startCheckout".equals(sessionEvent.predefinedType)) {
                    putLong(bundle, "quantity", Long.valueOf((long) ((Integer) sessionEvent.predefinedAttributes.get("itemCount")).intValue()));
                    putDouble(bundle, str6, mapPriceValue(sessionEvent.predefinedAttributes.get("totalPrice")));
                    putString(bundle, str9, (String) sessionEvent.predefinedAttributes.get(str9));
                } else {
                    String str10 = "contentName";
                    String str11 = "contentId";
                    String str12 = "contentType";
                    String str13 = "content_type";
                    if ("contentView".equals(sessionEvent.predefinedType)) {
                        putString(bundle, str13, (String) sessionEvent.predefinedAttributes.get(str12));
                        putString(bundle, str8, (String) sessionEvent.predefinedAttributes.get(str11));
                        putString(bundle, str7, (String) sessionEvent.predefinedAttributes.get(str10));
                    } else {
                        if ("search".equals(sessionEvent.predefinedType)) {
                            putString(bundle, "search_term", (String) sessionEvent.predefinedAttributes.get("query"));
                        } else {
                            boolean equals = "share".equals(sessionEvent.predefinedType);
                            String str14 = FIREBASE_METHOD;
                            if (equals) {
                                putString(bundle, str14, (String) sessionEvent.predefinedAttributes.get(str14));
                                putString(bundle, str13, (String) sessionEvent.predefinedAttributes.get(str12));
                                putString(bundle, str8, (String) sessionEvent.predefinedAttributes.get(str11));
                                putString(bundle, str7, (String) sessionEvent.predefinedAttributes.get(str10));
                            } else {
                                String str15 = sessionEvent.predefinedType;
                                String str16 = FIREBASE_RATING;
                                if (str16.equals(str15)) {
                                    putString(bundle, str16, String.valueOf(sessionEvent.predefinedAttributes.get(str16)));
                                    putString(bundle, str13, (String) sessionEvent.predefinedAttributes.get(str12));
                                    putString(bundle, str8, (String) sessionEvent.predefinedAttributes.get(str11));
                                    putString(bundle, str7, (String) sessionEvent.predefinedAttributes.get(str10));
                                } else {
                                    if ("signUp".equals(sessionEvent.predefinedType)) {
                                        putString(bundle, str14, (String) sessionEvent.predefinedAttributes.get(str14));
                                    } else {
                                        if ("login".equals(sessionEvent.predefinedType)) {
                                            putString(bundle, str14, (String) sessionEvent.predefinedAttributes.get(str14));
                                        } else {
                                            if ("invite".equals(sessionEvent.predefinedType)) {
                                                putString(bundle, str14, (String) sessionEvent.predefinedAttributes.get(str14));
                                            } else {
                                                if ("levelStart".equals(sessionEvent.predefinedType)) {
                                                    putString(bundle, FIREBASE_LEVEL_NAME, (String) sessionEvent.predefinedAttributes.get("levelName"));
                                                } else {
                                                    if ("levelEnd".equals(sessionEvent.predefinedType)) {
                                                        putDouble(bundle, "score", mapDouble(sessionEvent.predefinedAttributes.get("score")));
                                                        putString(bundle, FIREBASE_LEVEL_NAME, (String) sessionEvent.predefinedAttributes.get("levelName"));
                                                        putInt(bundle, FIREBASE_SUCCESS, mapBooleanValue((String) sessionEvent.predefinedAttributes.get(FIREBASE_SUCCESS)));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        mapCustomEventAttributes(bundle, sessionEvent.customAttributes);
        return bundle;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005c, code lost:
        if (r11.equals(r1) != false) goto L_0x00ca;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0046  */
    private String mapPredefinedEventName(String str, boolean z) {
        char c2;
        char c3 = 0;
        String str2 = "purchase";
        String str3 = "signUp";
        String str4 = "login";
        if (z) {
            int hashCode = str.hashCode();
            if (hashCode != -902468296) {
                if (hashCode != 103149417) {
                    if (hashCode == 1743324417 && str.equals(str2)) {
                        c2 = 0;
                        if (c2 != 0) {
                            return "failed_ecommerce_purchase";
                        }
                        if (c2 == 1) {
                            return "failed_sign_up";
                        }
                        if (c2 == 2) {
                            return "failed_login";
                        }
                    }
                } else if (str.equals(str4)) {
                    c2 = 2;
                    if (c2 != 0) {
                    }
                }
            } else if (str.equals(str3)) {
                c2 = 1;
                if (c2 != 0) {
                }
            }
            c2 = 65535;
            if (c2 != 0) {
            }
        }
        String str5 = "share";
        String str6 = "search";
        String str7 = "invite";
        switch (str.hashCode()) {
            case -2131650889:
                if (str.equals("levelEnd")) {
                    c3 = 11;
                    break;
                }
            case -1183699191:
                if (str.equals(str7)) {
                    c3 = 9;
                    break;
                }
            case -938102371:
                if (str.equals(FIREBASE_RATING)) {
                    c3 = 6;
                    break;
                }
            case -906336856:
                if (str.equals(str6)) {
                    c3 = 4;
                    break;
                }
            case -902468296:
                if (str.equals(str3)) {
                    c3 = 7;
                    break;
                }
            case -389087554:
                if (str.equals("contentView")) {
                    c3 = 3;
                    break;
                }
            case 23457852:
                if (str.equals("addToCart")) {
                    c3 = 1;
                    break;
                }
            case 103149417:
                if (str.equals(str4)) {
                    c3 = 8;
                    break;
                }
            case 109400031:
                if (str.equals(str5)) {
                    c3 = 5;
                    break;
                }
            case 196004670:
                if (str.equals("levelStart")) {
                    c3 = 10;
                    break;
                }
            case 1664021448:
                if (str.equals("startCheckout")) {
                    c3 = 2;
                    break;
                }
            case 1743324417:
                break;
            default:
                c3 = 65535;
                break;
        }
        switch (c3) {
            case 0:
                return "ecommerce_purchase";
            case 1:
                return "add_to_cart";
            case 2:
                return "begin_checkout";
            case 3:
                return "select_content";
            case 4:
                return str6;
            case 5:
                return str5;
            case 6:
                return "rate_content";
            case 7:
                return "sign_up";
            case 8:
                return str4;
            case 9:
                return str7;
            case 10:
                return "level_start";
            case 11:
                return "level_end";
            default:
                return mapCustomEventName(str);
        }
    }

    private Double mapPriceValue(Object obj) {
        Long l2 = (Long) obj;
        if (l2 == null) {
            return null;
        }
        return Double.valueOf(new BigDecimal(l2.longValue()).divide(AddToCartEvent.MICRO_CONSTANT).doubleValue());
    }

    private void putDouble(Bundle bundle, String str, Double d2) {
        Double mapDouble = mapDouble(d2);
        if (mapDouble != null) {
            bundle.putDouble(str, mapDouble.doubleValue());
        }
    }

    private void putInt(Bundle bundle, String str, Integer num) {
        if (num != null) {
            bundle.putInt(str, num.intValue());
        }
    }

    private void putLong(Bundle bundle, String str, Long l2) {
        if (l2 != null) {
            bundle.putLong(str, l2.longValue());
        }
    }

    private void putString(Bundle bundle, String str, String str2) {
        if (str2 != null) {
            bundle.putString(str, str2);
        }
    }

    public FirebaseAnalyticsEvent mapEvent(SessionEvent sessionEvent) {
        Bundle bundle;
        String str;
        boolean z = true;
        boolean z2 = Type.CUSTOM.equals(sessionEvent.type) && sessionEvent.customType != null;
        boolean z3 = Type.PREDEFINED.equals(sessionEvent.type) && sessionEvent.predefinedType != null;
        if (!z2 && !z3) {
            return null;
        }
        if (z3) {
            bundle = mapPredefinedEvent(sessionEvent);
        } else {
            bundle = new Bundle();
            Map<String, Object> map = sessionEvent.customAttributes;
            if (map != null) {
                mapCustomEventAttributes(bundle, map);
            }
        }
        if (z3) {
            String str2 = (String) sessionEvent.predefinedAttributes.get(FIREBASE_SUCCESS);
            if (str2 == null || Boolean.parseBoolean(str2)) {
                z = false;
            }
            str = mapPredefinedEventName(sessionEvent.predefinedType, z);
        } else {
            str = mapCustomEventName(sessionEvent.customType);
        }
        f.e().d(Answers.TAG, "Logging event into firebase...");
        return new FirebaseAnalyticsEvent(str, bundle);
    }
}
