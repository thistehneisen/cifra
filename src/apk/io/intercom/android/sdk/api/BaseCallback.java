package io.intercom.android.sdk.api;

import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.retrofit2.Call;
import io.intercom.retrofit2.Callback;
import io.intercom.retrofit2.Response;

public abstract class BaseCallback<T> implements Callback<T> {
    private final Twig twig = LumberMill.getLogger();

    static String getDetails(ErrorObject errorObject) {
        String str;
        if (errorObject.hasErrorBody()) {
            str = errorObject.getErrorBody();
        } else {
            str = errorObject.getThrowable().getMessage();
        }
        return str == null ? "unknown error" : str;
    }

    private void handleError(ErrorObject errorObject) {
        logFailure("Api call failed", errorObject);
        onError(errorObject);
    }

    /* access modifiers changed from: 0000 */
    public void logFailure(String str, ErrorObject errorObject) {
        Twig twig2 = this.twig;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(": ");
        sb.append(getDetails(errorObject));
        twig2.e(sb.toString(), new Object[0]);
    }

    /* access modifiers changed from: protected */
    public void onError(ErrorObject errorObject) {
    }

    public final void onFailure(Call<T> call, Throwable th) {
        handleError(new ErrorObject(th, null));
    }

    public final void onResponse(Call<T> call, Response<T> response) {
        String str = "No body returned from the server";
        if (response == null) {
            handleError(new ErrorObject(new IllegalStateException(str), null));
        } else if (response.body() == null) {
            handleError(new ErrorObject(new IllegalStateException(str), response));
        } else if (!response.isSuccessful()) {
            handleError(new ErrorObject(new Exception("Status code outside the 200-300 range"), response));
        } else {
            onSuccess(response.body());
        }
    }

    /* access modifiers changed from: protected */
    public abstract void onSuccess(T t);
}
