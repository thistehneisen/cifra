package io.intercom.android.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.intercom.input.gallery.GalleryImage;
import e.a.a.a.a.d;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.actions.Actions;
import io.intercom.android.sdk.blocks.UploadingImageCache;
import io.intercom.android.sdk.blocks.models.Block;
import io.intercom.android.sdk.conversation.UploadProgressListener;
import io.intercom.android.sdk.errorreporting.ErrorReport;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.AppIdentity;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.metrics.MetricObject;
import io.intercom.android.sdk.metrics.ops.OpsMetricObject;
import io.intercom.android.sdk.models.GifResponse;
import io.intercom.android.sdk.models.HomeCardsResponse.Builder;
import io.intercom.android.sdk.models.LinkResponse;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.Sheet;
import io.intercom.android.sdk.models.UpdateUserResponse;
import io.intercom.android.sdk.models.Upload;
import io.intercom.android.sdk.models.events.UploadEvent;
import io.intercom.android.sdk.models.events.failure.UploadFailedEvent;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Selectors;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.android.sdk.user.DeviceData;
import io.intercom.okhttp3.Dispatcher;
import io.intercom.okhttp3.MediaType;
import io.intercom.okhttp3.MultipartBody;
import io.intercom.okhttp3.OkHttpClient;
import io.intercom.okhttp3.Request;
import io.intercom.retrofit2.Call;
import io.intercom.retrofit2.Callback;
import io.intercom.retrofit2.Response;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class Api {
    private static final String BATCH_SIZE = "batch_size";
    private static final String DATA = "data";
    private static final String DEVICE_DATA = "device_data";
    private static final String DEVICE_TOKEN = "device_token";
    private static final String HMAC = "hmac";
    private static final String NEW_SESSION = "new_session";
    private static final String SENT_FROM_BACKGROUND = "sent_from_background";
    /* access modifiers changed from: private */
    public static final Twig TWIG = LumberMill.getLogger();
    private static final String UPLOAD = "upload";
    private static final String USER = "user";
    private static final String USER_ATTRIBUTES = "user_attributes";
    private final OkHttpClient apiHttpClient;
    private final Provider<AppConfig> appConfigProvider;
    private final AppIdentity appIdentity;
    final d bus;
    final CallbackHolder callbacks;
    private final Context context;
    private final int defaultOkHttpMaxRequests;
    private final Callback<Void> emptyCallback = new Callback<Void>() {
        public void onFailure(Call<Void> call, Throwable th) {
        }

        public void onResponse(Call<Void> call, Response<Void> response) {
        }
    };
    final OkHttpClient httpClient = new OkHttpClient();
    private final MessengerApi messengerApi;
    private final RateLimiter rateLimiter;
    /* access modifiers changed from: private */
    public final Store<State> store;
    final UserIdentity userIdentity;

    public Api(Context context2, AppIdentity appIdentity2, UserIdentity userIdentity2, d dVar, OkHttpClient okHttpClient, MessengerApi messengerApi2, CallbackHolder callbackHolder, RateLimiter rateLimiter2, Store<State> store2, Provider<AppConfig> provider) {
        this.context = context2;
        this.appIdentity = appIdentity2;
        this.userIdentity = userIdentity2;
        this.bus = dVar;
        this.messengerApi = messengerApi2;
        this.callbacks = callbackHolder;
        this.rateLimiter = rateLimiter2;
        this.store = store2;
        this.appConfigProvider = provider;
        this.apiHttpClient = okHttpClient;
        this.defaultOkHttpMaxRequests = okHttpClient.dispatcher().getMaxRequests();
        updateMaxRequests();
    }

    private void addSecureHash(Map<String, Object> map) {
        String data = this.userIdentity.getData();
        String hmac = this.userIdentity.getHmac();
        if (!TextUtils.isEmpty(data)) {
            map.put(DATA, data);
        }
        if (!TextUtils.isEmpty(hmac)) {
            map.put(HMAC, hmac);
        }
    }

    private Map<String, Object> baseNewConversationParams() {
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", this.appIdentity.appId());
        hashMap.put(USER, this.userIdentity.toMap());
        addSecureHash(hashMap);
        return hashMap;
    }

    private Map<String, Object> createBaseReplyParams() {
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", this.appIdentity.appId());
        String str = USER;
        hashMap.put("type", str);
        hashMap.put("message_type", "comment");
        hashMap.put(str, this.userIdentity.toMap());
        addSecureHash(hashMap);
        return hashMap;
    }

    private Map<String, Object> generateUpdateUserParams(UserUpdateRequest userUpdateRequest) {
        HashMap hashMap = new HashMap();
        hashMap.put(USER, this.userIdentity.toMap());
        hashMap.put(DEVICE_DATA, DeviceData.generateDeviceData(this.context));
        hashMap.put(NEW_SESSION, Boolean.valueOf(userUpdateRequest.isNewSession()));
        hashMap.put(SENT_FROM_BACKGROUND, Boolean.valueOf(userUpdateRequest.isSentFromBackground()));
        hashMap.put(BATCH_SIZE, Integer.valueOf(userUpdateRequest.getBatchSize()));
        hashMap.put(USER_ATTRIBUTES, userUpdateRequest.getAttributes());
        addSecureHash(hashMap);
        return hashMap;
    }

    protected static boolean isUserNotFound(ErrorObject errorObject, Map map) {
        if (errorObject.hasErrorBody() && errorObject.getStatusCode() == 404 && map != null && map.get(UserIdentity.INTERCOM_ID) != null && map.size() > 1) {
            try {
                if (new JSONObject(errorObject.getErrorBody()).getJSONArray("errors").getJSONObject(0).getString("code").equals("not_found")) {
                    return true;
                }
            } catch (Exception unused) {
                TWIG.internal("Could not parse error response");
            }
        }
        return false;
    }

    private void logBackgroundDisabledError() {
        TWIG.e("Your request was not sent because the app is in the background. Please contact Intercom to enable background requests.", new Object[0]);
    }

    private boolean shouldStopBackgroundRequest(boolean z) {
        return z && ((AppConfig) this.appConfigProvider.get()).backgroundRequestsDisabled();
    }

    public void addConversationQuickReply(String str, Part part, String str2, int i2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put(USER, this.userIdentity.toMap());
        String id = part.getId();
        if (!part.isInitialMessage()) {
            hashMap.put("quick_reply_part_id", id);
        }
        hashMap.put("reply_option_uuid", str2);
        addSecureHash(hashMap);
        this.messengerApi.addConversationQuickReply(str, hashMap).enqueue(this.callbacks.replyCallback(i2, false, str3, str));
    }

    public void addConversationRatingRemark(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(USER, this.userIdentity.toMap());
        hashMap.put("remark", str2);
        addSecureHash(hashMap);
        this.messengerApi.addConversationRatingRemark(str, hashMap).enqueue(this.callbacks.loggingCallback("adding remark to conversation"));
    }

    public void fetchDefaultGifs(Callback<GifResponse> callback) {
        this.messengerApi.getGifs(Collections.emptyMap()).enqueue(callback);
    }

    public void fetchGifs(String str, Callback<GifResponse> callback) {
        this.messengerApi.getGifs(Collections.singletonMap("query", str)).enqueue(callback);
    }

    public void fetchHomeCards(Callback<Builder> callback) {
        Map map = this.userIdentity.toMap();
        addSecureHash(map);
        this.messengerApi.getHomeCards(map).enqueue(callback);
    }

    public void fetchSheet(HashMap<String, Object> hashMap, Callback<Sheet.Builder> callback) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put(USER, this.userIdentity.toMap());
        addSecureHash(hashMap2);
        hashMap2.putAll(hashMap);
        this.messengerApi.getSheet(hashMap2).enqueue(callback);
    }

    public void getConversation(String str) {
        Map map = this.userIdentity.toMap();
        addSecureHash(map);
        this.messengerApi.getConversation(str, map).enqueue(this.callbacks.conversationCallback());
    }

    public void getInbox() {
        Map map = this.userIdentity.toMap();
        map.put("per_page", "20");
        addSecureHash(map);
        this.messengerApi.getConversations(map).enqueue(this.callbacks.inboxCallback());
    }

    public void getInboxBefore(long j2) {
        Map map = this.userIdentity.toMap();
        map.put("before", String.valueOf(j2));
        map.put("per_page", "20");
        addSecureHash(map);
        this.messengerApi.getConversations(map).enqueue(this.callbacks.inboxCallback());
    }

    public void getLink(String str, Callback<LinkResponse.Builder> callback) {
        Map map = this.userIdentity.toMap();
        addSecureHash(map);
        this.messengerApi.getLink(str, map).enqueue(callback);
    }

    public void getUnreadConversations() {
        Map map = this.userIdentity.toMap();
        map.put("per_page", "20");
        addSecureHash(map);
        this.messengerApi.getUnreadConversations(map).enqueue(this.callbacks.unreadCallback());
    }

    public void getVideo(String str, io.intercom.okhttp3.Callback callback) {
        this.httpClient.newCall(new Request.Builder().url(str).build()).enqueue(callback);
    }

    public void hitTrackingUrl(String str) {
        this.httpClient.newCall(new Request.Builder().url(str).build()).enqueue(new io.intercom.okhttp3.Callback() {
            public void onFailure(io.intercom.okhttp3.Call call, IOException iOException) {
                Api.TWIG.internal("Tracking Url", "Failed tracking url request");
            }

            public void onResponse(io.intercom.okhttp3.Call call, io.intercom.okhttp3.Response response) throws IOException {
                Api.TWIG.internal("Tracking Url", "success");
                response.body().close();
            }
        });
    }

    public boolean isIdle() {
        return this.apiHttpClient.dispatcher().runningCallsCount() == 0;
    }

    /* access modifiers changed from: 0000 */
    public boolean isSynchronous() {
        return this.apiHttpClient.dispatcher().getMaxRequests() == 1;
    }

    public void logEvent(String str, Map<String, ?> map) {
        if (this.rateLimiter.isLimited()) {
            this.rateLimiter.logError();
            return;
        }
        boolean booleanValue = ((Boolean) this.store.select(Selectors.APP_IS_BACKGROUNDED)).booleanValue();
        if (shouldStopBackgroundRequest(booleanValue)) {
            logBackgroundDisabledError();
            return;
        }
        this.rateLimiter.recordRequest();
        HashMap hashMap = new HashMap();
        hashMap.put("event_name", str);
        if (!map.isEmpty()) {
            hashMap.put("metadata", map);
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("event", hashMap);
        hashMap2.put(SENT_FROM_BACKGROUND, Boolean.valueOf(booleanValue));
        hashMap2.put(USER, this.userIdentity.toMap());
        addSecureHash(hashMap2);
        this.messengerApi.logEvent(hashMap2).enqueue(this.callbacks.unreadCallback());
    }

    public void markConversationAsDismissed(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(USER, this.userIdentity.toMap());
        hashMap.put("conversation_ids", new String[]{str});
        addSecureHash(hashMap);
        this.messengerApi.markAsDismissed(hashMap).enqueue(this.emptyCallback);
    }

    public void markConversationAsRead(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", this.appIdentity.appId());
        hashMap.put(USER, this.userIdentity.toMap());
        addSecureHash(hashMap);
        this.messengerApi.markAsRead(str, hashMap).enqueue(this.emptyCallback);
    }

    public void rateConversation(String str, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put(USER, this.userIdentity.toMap());
        hashMap.put("rating_index", Integer.valueOf(i2));
        addSecureHash(hashMap);
        this.messengerApi.rateConversation(str, hashMap).enqueue(this.callbacks.loggingCallback("conversation rating"));
    }

    public void reactToConversation(String str, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put(USER, this.userIdentity.toMap());
        hashMap.put("reaction_index", Integer.valueOf(i2));
        addSecureHash(hashMap);
        this.messengerApi.reactToConversation(str, hashMap).enqueue(this.callbacks.loggingCallback("add reaction to conversation"));
    }

    public void reactToLink(String str, int i2, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(USER, this.userIdentity.toMap());
        hashMap.put("reaction_index", Integer.valueOf(i2));
        hashMap.put("allow_auto_responses", Boolean.valueOf(z));
        addSecureHash(hashMap);
        this.messengerApi.reactToLink(str, hashMap).enqueue(this.callbacks.loggingCallback("add reaction to link"));
    }

    public void removeDeviceToken(String str, UserIdentity userIdentity2) {
        HashMap hashMap = new HashMap();
        hashMap.put(USER, userIdentity2.toMap());
        hashMap.put(DEVICE_TOKEN, str);
        addSecureHash(hashMap);
        this.messengerApi.deleteDeviceToken(hashMap).enqueue(this.emptyCallback);
    }

    public void replyToConversation(String str, List<Block.Builder> list, int i2, String str2, boolean z) {
        Map createBaseReplyParams = createBaseReplyParams();
        createBaseReplyParams.put("blocks", list);
        this.messengerApi.replyToConversation(str, createBaseReplyParams).enqueue(this.callbacks.replyCallback(i2, z, str2, str));
    }

    /* access modifiers changed from: 0000 */
    public void retriableUpdateUser(Map<String, Object> map) {
        retriableUpdateUser(map, this.userIdentity.getFingerprint());
    }

    public void satisfyOperatorCondition(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(USER, this.userIdentity.toMap());
        hashMap.put("transition_id", str2);
        addSecureHash(hashMap);
        this.messengerApi.satisfyCondition(str, hashMap).enqueue(this.emptyCallback);
    }

    public void sendErrorReport(ErrorReport errorReport) {
        HashMap hashMap = new HashMap();
        hashMap.put(USER, this.userIdentity.toMap());
        hashMap.put("error_report", errorReport);
        addSecureHash(hashMap);
        this.messengerApi.reportError(hashMap).enqueue(this.callbacks.loggingCallback("report error"));
    }

    public void sendMetrics(List<MetricObject> list, List<OpsMetricObject> list2, Callback<Void> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put("metrics", list);
        hashMap.put("op_metrics", list2);
        this.messengerApi.sendMetrics(hashMap).enqueue(callback);
    }

    public void setDeviceToken(String str) {
        Map generateDeviceData = DeviceData.generateDeviceData(this.context);
        generateDeviceData.put(DEVICE_TOKEN, str);
        HashMap hashMap = new HashMap();
        hashMap.put(USER, this.userIdentity.toMap());
        hashMap.put(DEVICE_DATA, generateDeviceData);
        addSecureHash(hashMap);
        this.messengerApi.setDeviceToken(hashMap).enqueue(this.emptyCallback);
    }

    public void setIdleCallback(Runnable runnable) {
        this.apiHttpClient.dispatcher().setIdleCallback(runnable);
    }

    public void startNewConversation(List<Block.Builder> list, int i2, String str) {
        Map baseNewConversationParams = baseNewConversationParams();
        baseNewConversationParams.put("blocks", list);
        this.messengerApi.startNewConversation(baseNewConversationParams).enqueue(this.callbacks.newConversationCallback(i2, str));
    }

    public void submitForm(String str, String str2, String str3, Object obj, String str4) {
        Map map = this.userIdentity.toMap();
        addSecureHash(map);
        HashMap hashMap = new HashMap();
        hashMap.put("conversation_part_id", str2);
        hashMap.put("identifier", str3);
        hashMap.put("value", obj);
        hashMap.put("type", str4);
        map.put("form_params", hashMap);
        this.messengerApi.submitForm(str, map).enqueue(this.callbacks.submitFormCallback(str2, str3));
    }

    public void submitSheet(String str, Map<String, Object> map, Callback<Void> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put(USER, this.userIdentity.toMap());
        addSecureHash(hashMap);
        hashMap.put("uri", str);
        hashMap.put("sheet_values", map);
        this.messengerApi.submitSheet(hashMap).enqueue(callback);
    }

    public void updateMaxRequests() {
        int i2 = this.userIdentity.hasIntercomId() ? this.defaultOkHttpMaxRequests : 1;
        Dispatcher dispatcher = this.apiHttpClient.dispatcher();
        if (dispatcher.getMaxRequests() != i2) {
            dispatcher.setMaxRequests(i2);
        }
    }

    public void updateUser(UserUpdateRequest userUpdateRequest) {
        if (!userUpdateRequest.isInternalUpdate()) {
            if (this.rateLimiter.isLimited()) {
                this.rateLimiter.logError();
                return;
            } else if (shouldStopBackgroundRequest(userUpdateRequest.isSentFromBackground())) {
                logBackgroundDisabledError();
                return;
            } else {
                this.rateLimiter.recordRequest();
            }
        }
        retriableUpdateUser(generateUpdateUserParams(userUpdateRequest));
    }

    public void uploadFile(GalleryImage galleryImage, int i2, String str, UploadingImageCache uploadingImageCache, UploadProgressListener uploadProgressListener) {
        final String fileName = galleryImage.getFileName();
        final String mimeType = galleryImage.getMimeType();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("original_filename", fileName);
        hashMap2.put("size_in_bytes", Integer.valueOf(galleryImage.getFileSize()));
        hashMap2.put("content_type", mimeType);
        hashMap2.put("width", Integer.valueOf(galleryImage.getImageWidth()));
        hashMap2.put("height", Integer.valueOf(galleryImage.getImageHeight()));
        hashMap.put(UPLOAD, hashMap2);
        hashMap.put(USER, this.userIdentity.toMap());
        addSecureHash(hashMap);
        Call uploadFile = this.messengerApi.uploadFile(hashMap);
        final UploadingImageCache uploadingImageCache2 = uploadingImageCache;
        final GalleryImage galleryImage2 = galleryImage;
        final UploadProgressListener uploadProgressListener2 = uploadProgressListener;
        final int i3 = i2;
        final String str2 = str;
        AnonymousClass2 r0 = new BaseCallback<Upload.Builder>() {
            /* access modifiers changed from: 0000 */
            public void logFailure(String str, ErrorObject errorObject) {
                super.logFailure("Upload failed", errorObject);
            }

            public void onError(ErrorObject errorObject) {
                Api.this.bus.post(new UploadFailedEvent(i3, str2));
            }

            public void onSuccess(Upload.Builder builder) {
                final Upload build = builder.build();
                uploadingImageCache2.put(build, galleryImage2);
                String str = "acl";
                String str2 = "Content-Type";
                String str3 = "AWSAccessKeyId";
                String str4 = "policy";
                String str5 = "signature";
                String str6 = "success_action_status";
                Api.this.httpClient.newCall(new Request.Builder().url(build.getUploadDestination()).post(new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("key", build.getKey()).addFormDataPart(str, build.getAcl()).addFormDataPart(str2, build.getContentType()).addFormDataPart(str3, build.getAwsAccessKey()).addFormDataPart(str4, build.getPolicy()).addFormDataPart(str5, build.getSignature()).addFormDataPart(str6, build.getSuccessActionStatus()).addFormDataPart("file", fileName, new ProgressRequestBody(MediaType.parse(mimeType), galleryImage2.buildFile(), uploadProgressListener2)).build()).build()).enqueue(new io.intercom.okhttp3.Callback() {
                    public void onFailure(io.intercom.okhttp3.Call call, IOException iOException) {
                        Twig access$000 = Api.TWIG;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Upload failed: ");
                        sb.append(iOException.getMessage());
                        access$000.e(sb.toString(), new Object[0]);
                        AnonymousClass2 r3 = AnonymousClass2.this;
                        Api.this.bus.post(new UploadFailedEvent(i3, str2));
                    }

                    public void onResponse(io.intercom.okhttp3.Call call, io.intercom.okhttp3.Response response) throws IOException {
                        Api.TWIG.internal("API Success", "Successfully uploaded");
                        if (response.isSuccessful()) {
                            AnonymousClass2 r9 = AnonymousClass2.this;
                            d dVar = Api.this.bus;
                            Upload upload = build;
                            long fileSize = (long) galleryImage2.getFileSize();
                            AnonymousClass2 r92 = AnonymousClass2.this;
                            UploadEvent uploadEvent = new UploadEvent(upload, fileSize, i3, str2);
                            dVar.post(uploadEvent);
                        } else {
                            Twig access$000 = Api.TWIG;
                            StringBuilder sb = new StringBuilder();
                            sb.append("Upload failed: request body ");
                            sb.append(response.body());
                            access$000.e(sb.toString(), new Object[0]);
                            AnonymousClass2 r93 = AnonymousClass2.this;
                            Api.this.bus.post(new UploadFailedEvent(i3, str2));
                        }
                        response.body().close();
                    }
                });
                Api.TWIG.internal("API Success", "Successfully uploaded");
            }
        };
        uploadFile.enqueue(r0);
    }

    /* access modifiers changed from: private */
    public void retriableUpdateUser(final Map<String, Object> map, final String str) {
        this.messengerApi.updateUser(map).enqueue(new BaseCallback<UpdateUserResponse.Builder>() {
            /* access modifiers changed from: 0000 */
            public void logFailure(String str, ErrorObject errorObject) {
                super.logFailure("Failed to register or update user", errorObject);
            }

            public void onError(ErrorObject errorObject) {
                Map map = map;
                String str = Api.USER;
                Map map2 = (Map) map.get(str);
                if (Api.isUserNotFound(errorObject, map2)) {
                    map2.remove(UserIdentity.INTERCOM_ID);
                    map.put(str, map2);
                    Api.this.retriableUpdateUser(map, str);
                }
            }

            public void onSuccess(UpdateUserResponse.Builder builder) {
                if (str.equals(Api.this.userIdentity.getFingerprint())) {
                    Api.TWIG.i("Successfully registered or updated user", new Object[0]);
                    Api.this.callbacks.unreadCallback().onSuccess(builder);
                    Api.this.store.dispatch(Actions.teamPresenceUpdated(builder.build().getTeamPresence()));
                }
            }
        });
    }
}
