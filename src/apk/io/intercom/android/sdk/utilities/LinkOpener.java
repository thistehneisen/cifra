package io.intercom.android.sdk.utilities;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.twig.Twig;
import java.util.Locale;

public class LinkOpener {
    private static final Twig twig = LumberMill.getLogger();

    static Uri getTargetUriFromTrackingUrl(String str) {
        Uri parse = Uri.parse(str);
        String queryParameter = parse.isHierarchical() ? parse.getQueryParameter("url") : str;
        if (queryParameter != null) {
            str = queryParameter;
        }
        return parseUrl(str);
    }

    public static void handleUrl(String str, Context context, Api api) {
        Uri uri;
        if (!TextUtils.isEmpty(str)) {
            if (isTrackingUrl(str)) {
                api.hitTrackingUrl(str);
                uri = getTargetUriFromTrackingUrl(str);
            } else {
                uri = parseUrl(str);
            }
            openUrl(uri, context);
        }
    }

    private static boolean isTrackingUrl(String str) {
        return str.contains("via.intercom.io");
    }

    private static Uri normalizeScheme(Uri uri) {
        String scheme = uri.getScheme();
        if (scheme == null) {
            return uri;
        }
        String lowerCase = scheme.toLowerCase(Locale.ROOT);
        if (scheme.equals(lowerCase)) {
            return uri;
        }
        return uri.buildUpon().scheme(lowerCase).build();
    }

    private static void openUrl(Uri uri, Context context) {
        Intent intent = new Intent("mailto".equals(uri.getScheme()) ? "android.intent.action.SENDTO" : "android.intent.action.VIEW", uri);
        intent.addFlags(268435456);
        try {
            IntentUtils.safelyOpenIntent(context, intent);
        } catch (ActivityNotFoundException unused) {
            Twig twig2 = twig;
            StringBuilder sb = new StringBuilder();
            sb.append("No Activity found to handle the URL '");
            sb.append(uri.toString());
            sb.append("'");
            twig2.e(sb.toString(), new Object[0]);
        } catch (SecurityException e2) {
            Twig twig3 = twig;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Couldn't open link because of error: ");
            sb2.append(e2.getMessage());
            twig3.e(sb2.toString(), new Object[0]);
        }
    }

    private static Uri parseUrl(String str) {
        Uri parse = Uri.parse(str);
        if (parse.getScheme() == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("http://");
            sb.append(str);
            parse = Uri.parse(sb.toString());
        }
        return (parse.getScheme().equalsIgnoreCase("http") || parse.getScheme().equalsIgnoreCase("https")) ? normalizeScheme(parse) : parse;
    }
}
