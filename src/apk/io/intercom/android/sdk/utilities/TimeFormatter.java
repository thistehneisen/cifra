package io.intercom.android.sdk.utilities;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.format.DateFormat;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.commons.utilities.TimeProvider;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.LastParticipatingAdmin;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class TimeFormatter {
    private SimpleDateFormat absoluteDateFormatter;
    private SimpleDateFormat absoluteTimeFormatter;
    private final Context context;
    private final TimeProvider timeProvider;

    public TimeFormatter(Context context2, TimeProvider timeProvider2) {
        this.context = context2;
        this.timeProvider = timeProvider2;
    }

    private static SimpleDateFormat createDateFormatter(Locale locale, String str) {
        if (VERSION.SDK_INT >= 18) {
            return new SimpleDateFormat(DateFormat.getBestDateTimePattern(locale, str), locale);
        }
        return new SimpleDateFormat(str, locale);
    }

    public static String formatTimeInMillisAsDate(long j2) {
        return new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date(j2));
    }

    private Date getDateFromTimeStamp(long j2) {
        return new Date(j2 * 1000);
    }

    private long getDifferenceInDays(Date date) {
        return TimeUnit.MILLISECONDS.toDays(this.timeProvider.currentTimeMillis() - date.getTime());
    }

    private long getDifferenceInHours(Date date) {
        return TimeUnit.MILLISECONDS.toHours(this.timeProvider.currentTimeMillis() - date.getTime());
    }

    private long getDifferenceInMinutes(Date date) {
        return TimeUnit.MILLISECONDS.toMinutes(this.timeProvider.currentTimeMillis() - date.getTime());
    }

    public String getAbsoluteDate(long j2) {
        return getAbsoluteDate(j2 * 1000, this.context.getResources().getConfiguration().locale);
    }

    public String getAbsoluteTime(long j2) {
        return getAbsoluteTime(j2 * 1000, this.context.getResources().getConfiguration().locale);
    }

    public CharSequence getAdminActiveStatus(LastParticipatingAdmin lastParticipatingAdmin, Provider<AppConfig> provider) {
        String str;
        if (shouldShowActiveOrAwayState(((AppConfig) provider.get()).getLocale())) {
            if (lastParticipatingAdmin.isActive()) {
                str = this.context.getString(R.string.intercom_active_state);
            } else {
                str = this.context.getString(R.string.intercom_away_state);
            }
            return str;
        } else if (lastParticipatingAdmin.getLastActiveAt() <= 0) {
            return "";
        } else {
            return getAdminActiveStatus(getDateFromTimeStamp(lastParticipatingAdmin.getLastActiveAt()));
        }
    }

    public CharSequence getFormattedTime(long j2) {
        if (j2 <= 0) {
            return "";
        }
        return getFormattedTime(new Date(j2 * 1000));
    }

    public String getLastActiveMinutes(long j2) {
        Date date = new Date(j2 * 1000);
        StringBuilder sb = new StringBuilder();
        sb.append(getDifferenceInMinutes(date));
        sb.append(" minutes");
        return sb.toString();
    }

    public CharSequence getUpdated(long j2) {
        Date dateFromTimeStamp = getDateFromTimeStamp(j2);
        long differenceInMinutes = getDifferenceInMinutes(dateFromTimeStamp);
        long differenceInHours = getDifferenceInHours(dateFromTimeStamp);
        long differenceInDays = getDifferenceInDays(dateFromTimeStamp);
        long j3 = differenceInDays / 7;
        String str = "Updated ";
        if (j3 > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(j3);
            sb.append(" weeks ago");
            return sb.toString();
        } else if (differenceInDays > 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(differenceInDays);
            sb2.append(" days ago");
            return sb2.toString();
        } else if (differenceInHours > 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(differenceInHours);
            sb3.append(" hours ago");
            return sb3.toString();
        } else if (differenceInMinutes < 1) {
            return this.context.getText(R.string.intercom_time_just_now);
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append(differenceInMinutes);
            sb4.append(" minutes ago");
            return sb4.toString();
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean shouldShowActiveOrAwayState(String str) {
        return str.equals("en");
    }

    /* access modifiers changed from: 0000 */
    public String getAbsoluteDate(long j2, Locale locale) {
        if (this.absoluteDateFormatter == null) {
            this.absoluteDateFormatter = createDateFormatter(locale, "MMMM d");
        }
        return this.absoluteDateFormatter.format(new Date(j2));
    }

    /* access modifiers changed from: 0000 */
    public String getAbsoluteTime(long j2, Locale locale) {
        if (this.absoluteTimeFormatter == null) {
            this.absoluteTimeFormatter = createDateFormatter(locale, "hh:mm");
        }
        return this.absoluteTimeFormatter.format(new Date(j2));
    }

    private CharSequence getFormattedTime(Date date) {
        Phrase phrase;
        long differenceInMinutes = getDifferenceInMinutes(date);
        long differenceInHours = getDifferenceInHours(date);
        long differenceInDays = getDifferenceInDays(date);
        long j2 = differenceInDays / 7;
        String str = "delta";
        if (j2 > 0) {
            phrase = Phrase.from(this.context, R.string.intercom_time_week_ago).put(str, (CharSequence) Long.toString(j2));
        } else if (differenceInDays > 0) {
            phrase = Phrase.from(this.context, R.string.intercom_time_day_ago).put(str, (CharSequence) Long.toString(differenceInDays));
        } else if (differenceInHours > 0) {
            phrase = Phrase.from(this.context, R.string.intercom_time_hour_ago).put(str, (CharSequence) Long.toString(differenceInHours));
        } else if (differenceInMinutes < 1) {
            return this.context.getText(R.string.intercom_time_just_now);
        } else {
            phrase = Phrase.from(this.context, R.string.intercom_time_minute_ago).put(str, (CharSequence) Long.toString(differenceInMinutes));
        }
        return phrase.format();
    }

    private CharSequence getAdminActiveStatus(Date date) {
        Phrase phrase;
        long differenceInMinutes = getDifferenceInMinutes(date);
        if (differenceInMinutes > TimeUnit.DAYS.toMinutes(6)) {
            return this.context.getText(R.string.intercom_active_week_ago);
        }
        if (differenceInMinutes >= TimeUnit.HOURS.toMinutes(23) + 31) {
            phrase = Phrase.from(this.context, R.string.intercom_active_day_ago).put("days", (CharSequence) Long.toString((((differenceInMinutes / 60) - 13) / 24) + 1));
        } else if (differenceInMinutes >= 53) {
            phrase = Phrase.from(this.context, R.string.intercom_active_hour_ago).put("hours", (CharSequence) Long.toString(((differenceInMinutes - 31) / 60) + 1));
        } else {
            String str = "minutes";
            if (differenceInMinutes >= 38) {
                phrase = Phrase.from(this.context, R.string.intercom_active_minute_ago).put(str, (CharSequence) Long.toString(45));
            } else if (differenceInMinutes >= 16) {
                phrase = Phrase.from(this.context, R.string.intercom_active_minute_ago).put(str, (CharSequence) Long.toString(30));
            } else {
                phrase = Phrase.from(this.context, R.string.intercom_active_15m_ago).put(str, (CharSequence) Long.toString(15));
            }
        }
        return phrase.format();
    }
}
