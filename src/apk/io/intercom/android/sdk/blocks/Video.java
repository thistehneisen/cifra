package io.intercom.android.sdk.blocks;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.blocks.blockInterfaces.VideoBlock;
import io.intercom.android.sdk.blocks.views.VideoPreviewView;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.android.sdk.utilities.BlockUtils;
import io.intercom.android.sdk.utilities.IntentUtils;
import io.intercom.com.bumptech.glide.n;
import io.intercom.okhttp3.Call;
import io.intercom.okhttp3.Callback;
import io.intercom.okhttp3.Response;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class Video implements VideoBlock {
    private final Api api;
    private final Provider<AppConfig> appConfigProvider;
    private final n requestManager;
    private final StyleType style;
    /* access modifiers changed from: private */
    public final Twig twig = LumberMill.getLogger();

    /* renamed from: io.intercom.android.sdk.blocks.Video$5 reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$blocks$VideoProvider = new int[VideoProvider.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            $SwitchMap$io$intercom$android$blocks$VideoProvider[VideoProvider.WISTIA.ordinal()] = 1;
            $SwitchMap$io$intercom$android$blocks$VideoProvider[VideoProvider.YOUTUBE.ordinal()] = 2;
            $SwitchMap$io$intercom$android$blocks$VideoProvider[VideoProvider.VIMEO.ordinal()] = 3;
            try {
                $SwitchMap$io$intercom$android$blocks$VideoProvider[VideoProvider.LOOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    Video(StyleType styleType, Api api2, Provider<AppConfig> provider, n nVar) {
        this.style = styleType;
        this.api = api2;
        this.appConfigProvider = provider;
        this.requestManager = nVar;
    }

    private void addClickListenerOnThumbnailView(final ImageView imageView, final String str) {
        if (this.style != StyleType.CHAT_FULL) {
            imageView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    intent.setFlags(268435456);
                    IntentUtils.safelyOpenIntent(imageView.getContext(), intent);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    public String getThumbnailUrlFromOembedResponse(Response response) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject(response.body().string());
            response.body().close();
            jSONObject = jSONObject2;
        } catch (JSONException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            StringBuilder sb = new StringBuilder();
            sb.append("Couldn't read response body: ");
            sb.append(e3.getMessage());
            this.twig.internal("ErrorObject", sb.toString());
        } catch (Throwable th) {
            response.body().close();
            throw th;
        }
        String optString = jSONObject.optString("thumbnail_url");
        int indexOf = optString.indexOf("?image_crop_resized");
        return indexOf <= 0 ? optString.substring(0, indexOf) : optString;
        response.body().close();
        String optString2 = jSONObject.optString("thumbnail_url");
        int indexOf2 = optString2.indexOf("?image_crop_resized");
        if (indexOf2 <= 0) {
        }
    }

    public View addVideo(String str, VideoProvider videoProvider, String str2, boolean z, boolean z2, ViewGroup viewGroup) {
        VideoPreviewView videoPreviewView = new VideoPreviewView(viewGroup.getContext(), this.appConfigProvider, this.style);
        fetchThumbnail(videoProvider, str2, videoPreviewView);
        BlockUtils.setLayoutMarginsAndGravity(videoPreviewView, 3, z2);
        return videoPreviewView;
    }

    /* access modifiers changed from: 0000 */
    public void createThumbnail(VideoPreviewView videoPreviewView, String str, String str2) {
        videoPreviewView.displayThumbnail(str2, this.requestManager);
        addClickListenerOnThumbnailView(videoPreviewView.getThumbnailImageView(), str);
    }

    /* access modifiers changed from: 0000 */
    public void fetchThumbnail(VideoProvider videoProvider, final String str, final VideoPreviewView videoPreviewView) {
        final ImageView thumbnailImageView = videoPreviewView.getThumbnailImageView();
        int i2 = AnonymousClass5.$SwitchMap$io$intercom$android$blocks$VideoProvider[videoProvider.ordinal()];
        if (i2 == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("https://fast.wistia.com/oembed?url=https://home.wistia.com/medias/");
            sb.append(str);
            this.api.getVideo(sb.toString(), new Callback() {
                public void onFailure(Call call, IOException iOException) {
                    videoPreviewView.showFailedImage();
                }

                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("https://fast.wistia.net/embed/iframe/");
                        sb.append(str);
                        final String sb2 = sb.toString();
                        final String access$000 = Video.this.getThumbnailUrlFromOembedResponse(response);
                        thumbnailImageView.post(new Runnable() {
                            public void run() {
                                AnonymousClass1 r0 = AnonymousClass1.this;
                                Video.this.createThumbnail(videoPreviewView, sb2, access$000);
                            }
                        });
                        return;
                    }
                    videoPreviewView.showFailedImage();
                }
            });
        } else if (i2 == 2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("https://www.youtube.com/watch?v=");
            sb2.append(str);
            String sb3 = sb2.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append("https://img.youtube.com/vi/");
            sb4.append(str);
            sb4.append("/default.jpg");
            createThumbnail(videoPreviewView, sb3, sb4.toString());
        } else if (i2 == 3) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("https://vimeo.com/api/v2/video/");
            sb5.append(str);
            sb5.append(".json");
            this.api.getVideo(sb5.toString(), new Callback() {
                public void onFailure(Call call, IOException iOException) {
                    videoPreviewView.showFailedImage();
                }

                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful() && response.body() != null) {
                        try {
                            final String string = new JSONArray(response.body().string()).getJSONObject(0).getString("thumbnail_large");
                            thumbnailImageView.post(new Runnable() {
                                public void run() {
                                    AnonymousClass2 r0 = AnonymousClass2.this;
                                    Video video = Video.this;
                                    VideoPreviewView videoPreviewView = videoPreviewView;
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("https://player.vimeo.com/video/");
                                    sb.append(str);
                                    video.createThumbnail(videoPreviewView, sb.toString(), string);
                                }
                            });
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        } catch (IOException e3) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Couldn't read response body: ");
                            sb.append(e3.getMessage());
                            Video.this.twig.internal("ErrorObject", sb.toString());
                        } catch (Throwable th) {
                            response.body().close();
                            throw th;
                        }
                        response.body().close();
                    }
                }
            });
        } else if (i2 == 4) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("https://www.useloom.com/v1/oembed?url=https://www.useloom.com/embed/");
            sb6.append(str);
            this.api.getVideo(sb6.toString(), new Callback() {
                public void onFailure(Call call, IOException iOException) {
                    videoPreviewView.showFailedImage();
                }

                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("https://www.useloom.com/embed/");
                        sb.append(str);
                        final String sb2 = sb.toString();
                        final String access$000 = Video.this.getThumbnailUrlFromOembedResponse(response);
                        thumbnailImageView.post(new Runnable() {
                            public void run() {
                                AnonymousClass3 r0 = AnonymousClass3.this;
                                Video.this.createThumbnail(videoPreviewView, sb2, access$000);
                            }
                        });
                        return;
                    }
                    videoPreviewView.showFailedImage();
                }
            });
        }
    }
}
