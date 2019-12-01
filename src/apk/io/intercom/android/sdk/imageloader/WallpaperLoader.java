package io.intercom.android.sdk.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.imageloader.LongTermImageLoader.OnImageReadyListener;
import io.intercom.android.sdk.utilities.BackgroundUtils;
import io.intercom.com.bumptech.glide.n;
import java.io.IOException;

public class WallpaperLoader {
    private final Provider<AppConfig> appConfigProvider;
    private final LongTermImageLoader imageLoader;
    private final n requestManager;

    WallpaperLoader(LongTermImageLoader longTermImageLoader, Provider<AppConfig> provider, n nVar) {
        this.imageLoader = longTermImageLoader;
        this.appConfigProvider = provider;
        this.requestManager = nVar;
    }

    public static WallpaperLoader create(Context context, Provider<AppConfig> provider, n nVar) {
        return new WallpaperLoader(LongTermImageLoader.newInstance(context), provider, nVar);
    }

    public void close() throws IOException {
        this.imageLoader.close();
    }

    public void loadWallpaperInto(final ImageView imageView) {
        String wallpaper = ((AppConfig) this.appConfigProvider.get()).getWallpaper();
        if (!TextUtils.isEmpty(wallpaper)) {
            this.imageLoader.loadImage(wallpaper, new OnImageReadyListener() {
                public void onImageReady(Bitmap bitmap) {
                    Context context = imageView.getContext();
                    if (context != null) {
                        bitmap.setDensity(160);
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
                        TileMode tileMode = TileMode.REPEAT;
                        bitmapDrawable.setTileModeXY(tileMode, tileMode);
                        BackgroundUtils.setBackground(imageView, bitmapDrawable);
                    }
                }
            }, this.requestManager);
        }
    }
}
