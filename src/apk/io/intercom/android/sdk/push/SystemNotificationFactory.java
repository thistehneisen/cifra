package io.intercom.android.sdk.push;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import androidx.core.app.j;
import androidx.core.app.j.d;
import androidx.core.app.j.e;
import androidx.core.app.j.f;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.IntercomPushManager;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.commons.utilities.DeviceUtils;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.transforms.RoundTransform;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.android.sdk.utilities.Phrase;
import io.intercom.com.bumptech.glide.c;
import io.intercom.com.bumptech.glide.f.g;
import io.intercom.com.bumptech.glide.k;
import io.intercom.com.bumptech.glide.load.m;
import java.util.List;

class SystemNotificationFactory {
    private static final String CONVERSATION_URI = "conversation_id=%s";
    private static final String INTERCOM_SDK_PUSH = "intercom_sdk_push";
    private static final int LARGE_ICON_SIZE_DP = 48;
    private static final Twig twig = LumberMill.getLogger();

    SystemNotificationFactory() {
    }

    private d createBuilder(Context context, Uri uri, String str, int i2, String str2) {
        ComponentName componentName = new ComponentName(context, IntercomPushBroadcastReceiver.class);
        Intent component = new Intent("io.intercom.android.sdk.INTERCOM_PUSH_OPENED").setComponent(componentName);
        Intent component2 = new Intent("io.intercom.android.sdk.INTERCOM_PUSH_DISMISSED").setComponent(componentName);
        String packageName = context.getPackageName();
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(packageName);
        if (launchIntentForPackage == null) {
            launchIntentForPackage = new Intent();
            Twig twig2 = twig;
            StringBuilder sb = new StringBuilder();
            sb.append("Couldn't get launch Intent for package '");
            sb.append(packageName);
            sb.append("' - tapping on notification will do nothing");
            twig2.e(sb.toString(), new Object[0]);
        } else {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
            launchIntentForPackage.setData(uri);
            launchIntentForPackage.putExtra(IntercomPushManager.INTERCOM_PUSH_KEY, INTERCOM_SDK_PUSH);
            if (str != null) {
                launchIntentForPackage.putExtra(IntercomPushManager.PUSH_ONLY_ID, str);
            }
        }
        String str3 = IntercomPushManager.HOST_APP_INTENT;
        component.putExtra(str3, launchIntentForPackage);
        component2.putExtra(str3, launchIntentForPackage);
        return baseNotificationBuilder(context, str2, (AppConfig) Injector.get().getAppConfigProvider().get(), PendingIntent.getBroadcast(context, i2, component, 134217728), PendingIntent.getBroadcast(context, i2, component2, 134217728));
    }

    private Bitmap generateAvatar(PushPayload pushPayload, Context context, AppConfig appConfig) {
        if (TextUtils.isEmpty(pushPayload.getImageUrl()) && !TextUtils.isEmpty(pushPayload.getAuthorName())) {
            return PushAvatarUtils.getNotificationInitialsBitmap(context, pushPayload.getAuthorName(), appConfig);
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), PushAvatarUtils.getNotificationDefaultBitmap(context, appConfig));
        try {
            int dpToPx = ScreenUtils.dpToPx(48.0f, context);
            k a2 = c.b(context.getApplicationContext()).a();
            a2.a(new g().a((Drawable) bitmapDrawable).a((m<Bitmap>) new RoundTransform<Bitmap>()));
            a2.a(pushPayload.getImageUrl());
            return (Bitmap) a2.a(dpToPx, dpToPx).get();
        } catch (Exception unused) {
            twig.d("Failed to retrieve the notification image", new Object[0]);
            return bitmapDrawable.getBitmap();
        }
    }

    private String getConversationChannelId(PushPayload pushPayload) {
        return pushPayload.isFirstPart() ? "intercom_new_chats_channel" : "intercom_chat_replies_channel";
    }

    private CharSequence groupMessageBody(PushPayload pushPayload) {
        String message = pushPayload.getMessage();
        if (!TextUtils.isEmpty(message)) {
            return message;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(pushPayload.getAuthorName());
        sb.append(": ");
        sb.append(pushPayload.getBody());
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    public d baseNotificationBuilder(Context context, String str, AppConfig appConfig, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        int i2 = DeviceUtils.hasPermission(context, "android.permission.VIBRATE") ? 2 : 0;
        int primaryColor = appConfig.getPrimaryColor();
        d dVar = new d(context, str);
        dVar.d(R.drawable.intercom_push_icon);
        dVar.a("msg");
        dVar.a(true);
        dVar.a(primaryColor);
        dVar.a(primaryColor, 500, 2000);
        dVar.a(pendingIntent);
        dVar.b(pendingIntent2);
        dVar.b(1 | i2);
        return dVar;
    }

    /* access modifiers changed from: 0000 */
    public Notification createGroupedNotification(List<PushPayload> list, Context context) {
        CharSequence charSequence;
        Uri parse = Uri.parse("intercom_sdk/multiple_notifications");
        if (list.size() == 1) {
            charSequence = context.getString(R.string.intercom_one_new_message);
        } else {
            charSequence = Phrase.from(context, R.string.intercom_new_messages).put("n", list.size()).format();
        }
        e eVar = new e();
        eVar.b(context.getString(R.string.intercom_new_notifications));
        for (PushPayload pushPayload : list) {
            SpannableString spannableString = new SpannableString(groupMessageBody(pushPayload));
            spannableString.setSpan(new StyleSpan(1), 0, pushPayload.getAuthorName().length(), 33);
            eVar.a((CharSequence) spannableString);
        }
        d createBuilder = createBuilder(context, parse, null, -1, getConversationChannelId((PushPayload) list.get(list.size() - 1)));
        createBuilder.c((CharSequence) context.getString(R.string.intercom_new_notifications));
        createBuilder.b(charSequence);
        createBuilder.c(((PushPayload) list.get(list.size() - 1)).getPriority());
        createBuilder.a((f) eVar);
        return createBuilder.a();
    }

    /* access modifiers changed from: 0000 */
    public Notification createPushOnlyNotification(PushPayload pushPayload, Context context) {
        String pushOnlyConversationId = pushPayload.getPushOnlyConversationId();
        d createBuilder = createBuilder(context, Uri.parse(pushPayload.getUri()), pushOnlyConversationId, pushOnlyConversationId.hashCode(), "intercom_actions_channel");
        createBuilder.c(getTitle(context, pushPayload));
        createBuilder.b((CharSequence) pushPayload.messageOrBody());
        createBuilder.c(pushPayload.getPriority());
        j.c cVar = new j.c();
        cVar.a((CharSequence) pushPayload.messageOrBody());
        createBuilder.a((f) cVar);
        return createBuilder.a();
    }

    /* access modifiers changed from: 0000 */
    public Notification createSingleNotification(PushPayload pushPayload, Context context, AppConfig appConfig) {
        Context context2 = context;
        d createBuilder = createBuilder(context2, Uri.parse(String.format("intercom_sdk/conversation_id=%s", new Object[]{pushPayload.getConversationId()})), null, -1, getConversationChannelId(pushPayload));
        createBuilder.c(getTitle(context, pushPayload));
        createBuilder.b((CharSequence) pushPayload.getBody());
        createBuilder.c(pushPayload.getPriority());
        createBuilder.a(generateAvatar(pushPayload, context, appConfig));
        j.c cVar = new j.c();
        cVar.a((CharSequence) pushPayload.getBody());
        createBuilder.a((f) cVar);
        return createBuilder.a();
    }

    /* access modifiers changed from: 0000 */
    @SuppressLint({"PrivateResource"})
    public CharSequence getTitle(Context context, PushPayload pushPayload) {
        String title = pushPayload.getTitle();
        if (!title.isEmpty()) {
            return title;
        }
        String authorName = pushPayload.getAuthorName();
        String appName = pushPayload.getAppName();
        if (!authorName.isEmpty() && !appName.isEmpty()) {
            return Phrase.from(context, R.string.intercom_teammate_from_company).put("name", (CharSequence) authorName).put("company", (CharSequence) appName).format();
        }
        if (!authorName.isEmpty()) {
            appName = authorName;
        }
        return appName;
    }
}
