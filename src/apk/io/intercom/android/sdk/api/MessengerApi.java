package io.intercom.android.sdk.api;

import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.ConversationsResponse;
import io.intercom.android.sdk.models.GifResponse;
import io.intercom.android.sdk.models.HomeCardsResponse;
import io.intercom.android.sdk.models.LinkResponse;
import io.intercom.android.sdk.models.Part.Builder;
import io.intercom.android.sdk.models.Sheet;
import io.intercom.android.sdk.models.UpdateUserResponse;
import io.intercom.android.sdk.models.Upload;
import io.intercom.android.sdk.models.UsersResponse;
import io.intercom.retrofit2.Call;
import io.intercom.retrofit2.http.Body;
import io.intercom.retrofit2.http.POST;
import io.intercom.retrofit2.http.PUT;
import io.intercom.retrofit2.http.Path;
import java.util.Map;

interface MessengerApi {
    @POST("conversations/{conversationId}/quick_reply")
    Call<Builder> addConversationQuickReply(@Path("conversationId") String str, @Body Map<String, Object> map);

    @POST("conversations/{conversationId}/remark")
    Call<Void> addConversationRatingRemark(@Path("conversationId") String str, @Body Map<String, Object> map);

    @PUT("device_tokens")
    Call<Void> deleteDeviceToken(@Body Map<String, Object> map);

    @POST("conversations/{conversationId}")
    Call<Conversation.Builder> getConversation(@Path("conversationId") String str, @Body Map<String, Object> map);

    @POST("conversations/inbox")
    Call<ConversationsResponse.Builder> getConversations(@Body Map<String, Object> map);

    @POST("gifs")
    Call<GifResponse> getGifs(@Body Map<String, Object> map);

    @POST("home_cards")
    Call<HomeCardsResponse.Builder> getHomeCards(@Body Map<String, Object> map);

    @POST("articles/{articleId}")
    Call<LinkResponse.Builder> getLink(@Path("articleId") String str, @Body Map<String, Object> map);

    @POST("sheets/open")
    Call<Sheet.Builder> getSheet(@Body Map<String, Object> map);

    @POST("conversations/unread")
    Call<UsersResponse.Builder> getUnreadConversations(@Body Map<String, Object> map);

    @POST("events")
    Call<UsersResponse.Builder> logEvent(@Body Map<String, Object> map);

    @POST("conversations/dismiss")
    Call<Void> markAsDismissed(@Body Map<String, Object> map);

    @POST("conversations/{conversationId}/read")
    Call<Void> markAsRead(@Path("conversationId") String str, @Body Map<String, Object> map);

    @POST("conversations/{conversationId}/rate")
    Call<Void> rateConversation(@Path("conversationId") String str, @Body Map<String, Object> map);

    @POST("conversations/{conversationId}/react")
    Call<Void> reactToConversation(@Path("conversationId") String str, @Body Map<String, Object> map);

    @POST("articles/{articleId}/react")
    Call<Void> reactToLink(@Path("articleId") String str, @Body Map<String, Object> map);

    @POST("conversations/{conversationId}/reply")
    Call<Builder> replyToConversation(@Path("conversationId") String str, @Body Map<String, Object> map);

    @POST("error_reports")
    Call<Void> reportError(@Body Map<String, Object> map);

    @POST("conversations/{conversationId}/conditions_satisfied")
    Call<Void> satisfyCondition(@Path("conversationId") String str, @Body Map<String, Object> map);

    @POST("metrics")
    Call<Void> sendMetrics(@Body Map<String, Object> map);

    @POST("device_tokens")
    Call<Void> setDeviceToken(@Body Map<String, Object> map);

    @POST("conversations")
    Call<Conversation.Builder> startNewConversation(@Body Map<String, Object> map);

    @POST("conversations/{conversationId}/form")
    Call<Conversation.Builder> submitForm(@Path("conversationId") String str, @Body Map<String, Object> map);

    @POST("sheets/submit")
    Call<Void> submitSheet(@Body Map<String, Object> map);

    @POST("users")
    Call<UpdateUserResponse.Builder> updateUser(@Body Map<String, Object> map);

    @POST("uploads")
    Call<Upload.Builder> uploadFile(@Body Map<String, Object> map);
}
