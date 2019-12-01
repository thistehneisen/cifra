package io.intercom.android.sdk.conversation.composer.galleryinput;

import android.text.TextUtils;
import com.intercom.input.gallery.GalleryImage;
import com.intercom.input.gallery.GalleryImage.Builder;
import com.intercom.input.gallery.GalleryInputDataSource;
import com.intercom.input.gallery.GalleryInputDataSource.Listener;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.blocks.models.Block;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.GifResponse;
import io.intercom.retrofit2.Call;
import io.intercom.retrofit2.Callback;
import io.intercom.retrofit2.Response;
import java.util.ArrayList;
import java.util.List;

class GifInputDataSource implements GalleryInputDataSource {
    private static final long DEBOUNCE_DELAY_MS = 300;
    /* access modifiers changed from: private */
    public final Api api;
    private int currentCount = 0;
    private final Debouncer debouncer = new Debouncer();
    /* access modifiers changed from: private */
    public String lastQuery;
    /* access modifiers changed from: private */
    public Listener listener;
    /* access modifiers changed from: private */
    public boolean loading;
    private final MetricTracker metricTracker;

    GifInputDataSource(Api api2, MetricTracker metricTracker2) {
        this.api = api2;
        this.metricTracker = metricTracker2;
    }

    private List<GalleryImage> getImagesFromResponse(List<Block> list) {
        this.currentCount = list.size();
        ArrayList arrayList = new ArrayList(this.currentCount);
        for (Block block : list) {
            arrayList.add(new Builder().withPath(block.getUrl()).withPreviewPath(block.getPreviewUrl()).withAttribution(block.getAttribution()).withImageHeight(block.getHeight()).withImageWidth(block.getWidth()).build());
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void handleGifResponse(Response<GifResponse> response) {
        GifResponse gifResponse = (GifResponse) response.body();
        if (gifResponse != null) {
            this.listener.onSuccess(getImagesFromResponse(gifResponse.results()));
            return;
        }
        this.listener.onError();
    }

    private void loadDefaultGifs() {
        this.api.fetchDefaultGifs(new Callback<GifResponse>() {
            public void onFailure(Call<GifResponse> call, Throwable th) {
                GifInputDataSource.this.loading = false;
                GifInputDataSource.this.listener.onError();
            }

            public void onResponse(Call<GifResponse> call, Response<GifResponse> response) {
                GifInputDataSource.this.loading = false;
                GifInputDataSource.this.handleGifResponse(response);
            }
        });
    }

    private void searchGifs(final String str) {
        this.metricTracker.searchedGifInput(str);
        this.debouncer.call(new Runnable() {
            public void run() {
                GifInputDataSource.this.api.fetchGifs(str, new Callback<GifResponse>() {
                    public void onFailure(Call<GifResponse> call, Throwable th) {
                        GifInputDataSource.this.loading = false;
                        GifInputDataSource.this.listener.onError();
                    }

                    public void onResponse(Call<GifResponse> call, Response<GifResponse> response) {
                        GifInputDataSource.this.loading = false;
                        AnonymousClass2 r2 = AnonymousClass2.this;
                        if (str.equals(GifInputDataSource.this.lastQuery)) {
                            GifInputDataSource.this.handleGifResponse(response);
                        }
                    }
                });
            }
        }, DEBOUNCE_DELAY_MS);
    }

    public int getCount() {
        return this.currentCount;
    }

    public void getImages(int i2, String str) {
        this.loading = true;
        this.lastQuery = str;
        if (TextUtils.isEmpty(str)) {
            loadDefaultGifs();
        } else {
            searchGifs(str);
        }
    }

    public int getPermissionStatus() {
        return 0;
    }

    public boolean isLoading() {
        return this.loading;
    }

    public void requestPermission() {
    }

    public void setListener(Listener listener2) {
        this.listener = listener2;
    }
}
