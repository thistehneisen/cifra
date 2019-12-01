package io.intercom.retrofit2;

import io.intercom.okhttp3.Request;
import io.intercom.retrofit2.CallAdapter.Factory;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;

final class ExecutorCallAdapterFactory extends Factory {
    final Executor callbackExecutor;

    static final class ExecutorCallbackCall<T> implements Call<T> {
        final Executor callbackExecutor;
        final Call<T> delegate;

        ExecutorCallbackCall(Executor executor, Call<T> call) {
            this.callbackExecutor = executor;
            this.delegate = call;
        }

        public void cancel() {
            this.delegate.cancel();
        }

        public void enqueue(final Callback<T> callback) {
            Utils.checkNotNull(callback, "callback == null");
            this.delegate.enqueue(new Callback<T>() {
                public void onFailure(Call<T> call, final Throwable th) {
                    ExecutorCallbackCall.this.callbackExecutor.execute(new Runnable() {
                        public void run() {
                            AnonymousClass1 r0 = AnonymousClass1.this;
                            callback.onFailure(ExecutorCallbackCall.this, th);
                        }
                    });
                }

                public void onResponse(Call<T> call, final Response<T> response) {
                    ExecutorCallbackCall.this.callbackExecutor.execute(new Runnable() {
                        public void run() {
                            if (ExecutorCallbackCall.this.delegate.isCanceled()) {
                                AnonymousClass1 r0 = AnonymousClass1.this;
                                callback.onFailure(ExecutorCallbackCall.this, new IOException("Canceled"));
                                return;
                            }
                            AnonymousClass1 r02 = AnonymousClass1.this;
                            callback.onResponse(ExecutorCallbackCall.this, response);
                        }
                    });
                }
            });
        }

        public Response<T> execute() throws IOException {
            return this.delegate.execute();
        }

        public boolean isCanceled() {
            return this.delegate.isCanceled();
        }

        public boolean isExecuted() {
            return this.delegate.isExecuted();
        }

        public Request request() {
            return this.delegate.request();
        }

        public Call<T> clone() {
            return new ExecutorCallbackCall(this.callbackExecutor, this.delegate.clone());
        }
    }

    ExecutorCallAdapterFactory(Executor executor) {
        this.callbackExecutor = executor;
    }

    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (Factory.getRawType(type) != Call.class) {
            return null;
        }
        final Type callResponseType = Utils.getCallResponseType(type);
        return new CallAdapter<Object, Call<?>>() {
            public Type responseType() {
                return callResponseType;
            }

            public Call<Object> adapt(Call<Object> call) {
                return new ExecutorCallbackCall(ExecutorCallAdapterFactory.this.callbackExecutor, call);
            }
        };
    }
}
