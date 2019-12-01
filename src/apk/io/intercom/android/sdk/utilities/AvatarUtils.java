package io.intercom.android.sdk.utilities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.transforms.RoundTransform;
import io.intercom.android.sdk.views.AvatarDefaultDrawable;
import io.intercom.android.sdk.views.AvatarInitialsDrawable;
import io.intercom.com.bumptech.glide.f.a.f;
import io.intercom.com.bumptech.glide.f.b.d;
import io.intercom.com.bumptech.glide.f.g;
import io.intercom.com.bumptech.glide.k;
import io.intercom.com.bumptech.glide.load.c.c.c;
import io.intercom.com.bumptech.glide.load.m;
import io.intercom.com.bumptech.glide.n;
import io.intercom.com.bumptech.glide.o;
import java.io.File;

public class AvatarUtils {
    public static void createAvatar(Avatar avatar, ImageView imageView, int i2, AppConfig appConfig, n nVar) {
        Drawable drawable;
        Context context = imageView.getContext();
        if (avatar.getInitials().isEmpty()) {
            drawable = getDefaultDrawable(context, appConfig);
        } else {
            drawable = getInitialsDrawable(avatar.getInitials(), appConfig);
        }
        g a2 = new g().b(drawable).a(drawable).a(ImageUtils.getDiskCacheStrategy(avatar.getImageUrl())).a((m<Bitmap>) new RoundTransform<Bitmap>());
        if (i2 > 0) {
            a2 = a2.a(i2, i2);
        }
        k a3 = nVar.a(avatar.getImageUrl());
        a3.a((o<?, ? super TranscodeType>) c.c());
        a3.a(a2);
        a3.a(imageView);
    }

    public static AvatarDefaultDrawable getDefaultDrawable(Context context, AppConfig appConfig) {
        return new AvatarDefaultDrawable(context, appConfig.getSecondaryColorDark());
    }

    public static AvatarInitialsDrawable getInitialsDrawable(String str, AppConfig appConfig) {
        return new AvatarInitialsDrawable(str.toUpperCase(), appConfig.getSecondaryColorDark());
    }

    public static void loadAvatarIntoView(Avatar avatar, ImageView imageView, AppConfig appConfig, n nVar) {
        createAvatar(avatar, imageView, 0, appConfig, nVar);
    }

    public static void preloadAvatar(Avatar avatar, final Runnable runnable, n nVar) {
        if (avatar.getImageUrl().isEmpty()) {
            runnable.run();
            return;
        }
        k c2 = nVar.c();
        c2.a(avatar.getImageUrl());
        c2.a(new f<File>() {
            public void onLoadFailed(Drawable drawable) {
                runnable.run();
            }

            public void onResourceReady(File file, d<? super File> dVar) {
                runnable.run();
            }
        });
    }
}
