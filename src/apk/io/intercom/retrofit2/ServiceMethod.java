package io.intercom.retrofit2;

import io.intercom.okhttp3.Call.Factory;
import io.intercom.okhttp3.Headers;
import io.intercom.okhttp3.HttpUrl;
import io.intercom.okhttp3.MediaType;
import io.intercom.okhttp3.MultipartBody;
import io.intercom.okhttp3.Request;
import io.intercom.okhttp3.Response;
import io.intercom.okhttp3.ResponseBody;
import io.intercom.retrofit2.http.Body;
import io.intercom.retrofit2.http.DELETE;
import io.intercom.retrofit2.http.Field;
import io.intercom.retrofit2.http.FieldMap;
import io.intercom.retrofit2.http.FormUrlEncoded;
import io.intercom.retrofit2.http.GET;
import io.intercom.retrofit2.http.HEAD;
import io.intercom.retrofit2.http.HTTP;
import io.intercom.retrofit2.http.Header;
import io.intercom.retrofit2.http.HeaderMap;
import io.intercom.retrofit2.http.Multipart;
import io.intercom.retrofit2.http.OPTIONS;
import io.intercom.retrofit2.http.PATCH;
import io.intercom.retrofit2.http.POST;
import io.intercom.retrofit2.http.PUT;
import io.intercom.retrofit2.http.Part;
import io.intercom.retrofit2.http.PartMap;
import io.intercom.retrofit2.http.Path;
import io.intercom.retrofit2.http.Query;
import io.intercom.retrofit2.http.QueryMap;
import io.intercom.retrofit2.http.QueryName;
import io.intercom.retrofit2.http.Url;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class ServiceMethod<R, T> {
    static final String PARAM = "[a-zA-Z][a-zA-Z0-9_-]*";
    static final Pattern PARAM_NAME_REGEX = Pattern.compile(PARAM);
    static final Pattern PARAM_URL_REGEX = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
    private final HttpUrl baseUrl;
    final CallAdapter<R, T> callAdapter;
    final Factory callFactory;
    private final MediaType contentType;
    private final boolean hasBody;
    private final Headers headers;
    private final String httpMethod;
    private final boolean isFormEncoded;
    private final boolean isMultipart;
    private final ParameterHandler<?>[] parameterHandlers;
    private final String relativeUrl;
    private final Converter<ResponseBody, R> responseConverter;

    static final class Builder<T, R> {
        CallAdapter<T, R> callAdapter;
        MediaType contentType;
        boolean gotBody;
        boolean gotField;
        boolean gotPart;
        boolean gotPath;
        boolean gotQuery;
        boolean gotUrl;
        boolean hasBody;
        Headers headers;
        String httpMethod;
        boolean isFormEncoded;
        boolean isMultipart;
        final Method method;
        final Annotation[] methodAnnotations;
        final Annotation[][] parameterAnnotationsArray;
        ParameterHandler<?>[] parameterHandlers;
        final Type[] parameterTypes;
        String relativeUrl;
        Set<String> relativeUrlParamNames;
        Converter<ResponseBody, T> responseConverter;
        Type responseType;
        final Retrofit retrofit;

        Builder(Retrofit retrofit3, Method method2) {
            this.retrofit = retrofit3;
            this.method = method2;
            this.methodAnnotations = method2.getAnnotations();
            this.parameterTypes = method2.getGenericParameterTypes();
            this.parameterAnnotationsArray = method2.getParameterAnnotations();
        }

        private CallAdapter<T, R> createCallAdapter() {
            Type genericReturnType = this.method.getGenericReturnType();
            if (Utils.hasUnresolvableType(genericReturnType)) {
                throw methodError("Method return type must not include a type variable or wildcard: %s", genericReturnType);
            } else if (genericReturnType != Void.TYPE) {
                try {
                    return this.retrofit.callAdapter(genericReturnType, this.method.getAnnotations());
                } catch (RuntimeException e2) {
                    throw methodError(e2, "Unable to create call adapter for %s", genericReturnType);
                }
            } else {
                throw methodError("Service methods cannot return void.", new Object[0]);
            }
        }

        private Converter<ResponseBody, T> createResponseConverter() {
            try {
                return this.retrofit.responseBodyConverter(this.responseType, this.method.getAnnotations());
            } catch (RuntimeException e2) {
                throw methodError(e2, "Unable to create converter for %s", this.responseType);
            }
        }

        private RuntimeException methodError(String str, Object... objArr) {
            return methodError(null, str, objArr);
        }

        private RuntimeException parameterError(Throwable th, int i2, String str, Object... objArr) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" (parameter #");
            sb.append(i2 + 1);
            sb.append(")");
            return methodError(th, sb.toString(), objArr);
        }

        private Headers parseHeaders(String[] strArr) {
            io.intercom.okhttp3.Headers.Builder builder = new io.intercom.okhttp3.Headers.Builder();
            for (String str : strArr) {
                int indexOf = str.indexOf(58);
                if (indexOf == -1 || indexOf == 0 || indexOf == str.length() - 1) {
                    throw methodError("@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String substring = str.substring(0, indexOf);
                String trim = str.substring(indexOf + 1).trim();
                if ("Content-Type".equalsIgnoreCase(substring)) {
                    MediaType parse = MediaType.parse(trim);
                    if (parse != null) {
                        this.contentType = parse;
                    } else {
                        throw methodError("Malformed content type: %s", trim);
                    }
                } else {
                    builder.add(substring, trim);
                }
            }
            return builder.build();
        }

        private void parseHttpMethodAndPath(String str, String str2, boolean z) {
            String str3 = this.httpMethod;
            if (str3 == null) {
                this.httpMethod = str;
                this.hasBody = z;
                if (!str2.isEmpty()) {
                    int indexOf = str2.indexOf(63);
                    if (indexOf != -1 && indexOf < str2.length() - 1) {
                        String substring = str2.substring(indexOf + 1);
                        if (ServiceMethod.PARAM_URL_REGEX.matcher(substring).find()) {
                            throw methodError("URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                        }
                    }
                    this.relativeUrl = str2;
                    this.relativeUrlParamNames = ServiceMethod.parsePathParameters(str2);
                    return;
                }
                return;
            }
            throw methodError("Only one HTTP method is allowed. Found: %s and %s.", str3, str);
        }

        private void parseMethodAnnotation(Annotation annotation) {
            if (annotation instanceof DELETE) {
                parseHttpMethodAndPath("DELETE", ((DELETE) annotation).value(), false);
            } else if (annotation instanceof GET) {
                parseHttpMethodAndPath("GET", ((GET) annotation).value(), false);
            } else if (annotation instanceof HEAD) {
                parseHttpMethodAndPath("HEAD", ((HEAD) annotation).value(), false);
                if (!Void.class.equals(this.responseType)) {
                    throw methodError("HEAD method must use Void as response type.", new Object[0]);
                }
            } else if (annotation instanceof PATCH) {
                parseHttpMethodAndPath("PATCH", ((PATCH) annotation).value(), true);
            } else if (annotation instanceof POST) {
                parseHttpMethodAndPath("POST", ((POST) annotation).value(), true);
            } else if (annotation instanceof PUT) {
                parseHttpMethodAndPath("PUT", ((PUT) annotation).value(), true);
            } else if (annotation instanceof OPTIONS) {
                parseHttpMethodAndPath("OPTIONS", ((OPTIONS) annotation).value(), false);
            } else if (annotation instanceof HTTP) {
                HTTP http = (HTTP) annotation;
                parseHttpMethodAndPath(http.method(), http.path(), http.hasBody());
            } else if (annotation instanceof io.intercom.retrofit2.http.Headers) {
                String[] value = ((io.intercom.retrofit2.http.Headers) annotation).value();
                if (value.length != 0) {
                    this.headers = parseHeaders(value);
                } else {
                    throw methodError("@Headers annotation is empty.", new Object[0]);
                }
            } else {
                String str = "Only one encoding annotation is allowed.";
                if (annotation instanceof Multipart) {
                    if (!this.isFormEncoded) {
                        this.isMultipart = true;
                        return;
                    }
                    throw methodError(str, new Object[0]);
                } else if (!(annotation instanceof FormUrlEncoded)) {
                } else {
                    if (!this.isMultipart) {
                        this.isFormEncoded = true;
                        return;
                    }
                    throw methodError(str, new Object[0]);
                }
            }
        }

        private ParameterHandler<?> parseParameter(int i2, Type type, Annotation[] annotationArr) {
            ParameterHandler<?> parameterHandler = null;
            for (Annotation parseParameterAnnotation : annotationArr) {
                ParameterHandler<?> parseParameterAnnotation2 = parseParameterAnnotation(i2, type, annotationArr, parseParameterAnnotation);
                if (parseParameterAnnotation2 != null) {
                    if (parameterHandler == null) {
                        parameterHandler = parseParameterAnnotation2;
                    } else {
                        throw parameterError(i2, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                    }
                }
            }
            if (parameterHandler != null) {
                return parameterHandler;
            }
            throw parameterError(i2, "No Retrofit annotation found.", new Object[0]);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
            if ("android.net.Uri".equals(((java.lang.Class) r11).getName()) != false) goto L_0x0042;
         */
        private ParameterHandler<?> parseParameterAnnotation(int i2, Type type, Annotation[] annotationArr, Annotation annotation) {
            String str = "@Path parameters may not be used with @Url.";
            if (annotation instanceof Url) {
                if (this.gotUrl) {
                    throw parameterError(i2, "Multiple @Url method annotations found.", new Object[0]);
                } else if (this.gotPath) {
                    throw parameterError(i2, str, new Object[0]);
                } else if (this.gotQuery) {
                    throw parameterError(i2, "A @Url parameter must not come after a @Query", new Object[0]);
                } else if (this.relativeUrl == null) {
                    this.gotUrl = true;
                    if (!(type == HttpUrl.class || type == String.class || type == URI.class)) {
                        if (type instanceof Class) {
                        }
                        throw parameterError(i2, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
                    }
                    return new RelativeUrl();
                } else {
                    throw parameterError(i2, "@Url cannot be used with @%s URL", this.httpMethod);
                }
            } else if (!(annotation instanceof Path)) {
                String str2 = "<String>)";
                String str3 = " must include generic type (e.g., ";
                if (annotation instanceof Query) {
                    Query query = (Query) annotation;
                    String value = query.value();
                    boolean encoded = query.encoded();
                    Class rawType = Utils.getRawType(type);
                    this.gotQuery = true;
                    if (Iterable.class.isAssignableFrom(rawType)) {
                        if (type instanceof ParameterizedType) {
                            return new Query(value, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) type), annotationArr), encoded).iterable();
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(rawType.getSimpleName());
                        sb.append(str3);
                        sb.append(rawType.getSimpleName());
                        sb.append(str2);
                        throw parameterError(i2, sb.toString(), new Object[0]);
                    } else if (!rawType.isArray()) {
                        return new Query(value, this.retrofit.stringConverter(type, annotationArr), encoded);
                    } else {
                        return new Query(value, this.retrofit.stringConverter(ServiceMethod.boxIfPrimitive(rawType.getComponentType()), annotationArr), encoded).array();
                    }
                } else if (annotation instanceof QueryName) {
                    boolean encoded2 = ((QueryName) annotation).encoded();
                    Class rawType2 = Utils.getRawType(type);
                    this.gotQuery = true;
                    if (Iterable.class.isAssignableFrom(rawType2)) {
                        if (type instanceof ParameterizedType) {
                            return new QueryName(this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) type), annotationArr), encoded2).iterable();
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(rawType2.getSimpleName());
                        sb2.append(str3);
                        sb2.append(rawType2.getSimpleName());
                        sb2.append(str2);
                        throw parameterError(i2, sb2.toString(), new Object[0]);
                    } else if (!rawType2.isArray()) {
                        return new QueryName(this.retrofit.stringConverter(type, annotationArr), encoded2);
                    } else {
                        return new QueryName(this.retrofit.stringConverter(ServiceMethod.boxIfPrimitive(rawType2.getComponentType()), annotationArr), encoded2).array();
                    }
                } else {
                    String str4 = "Map must include generic types (e.g., Map<String, String>)";
                    if (annotation instanceof QueryMap) {
                        Class rawType3 = Utils.getRawType(type);
                        if (Map.class.isAssignableFrom(rawType3)) {
                            Type supertype = Utils.getSupertype(type, rawType3, Map.class);
                            if (supertype instanceof ParameterizedType) {
                                ParameterizedType parameterizedType = (ParameterizedType) supertype;
                                Type parameterUpperBound = Utils.getParameterUpperBound(0, parameterizedType);
                                if (String.class == parameterUpperBound) {
                                    return new QueryMap(this.retrofit.stringConverter(Utils.getParameterUpperBound(1, parameterizedType), annotationArr), ((QueryMap) annotation).encoded());
                                }
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("@QueryMap keys must be of type String: ");
                                sb3.append(parameterUpperBound);
                                throw parameterError(i2, sb3.toString(), new Object[0]);
                            }
                            throw parameterError(i2, str4, new Object[0]);
                        }
                        throw parameterError(i2, "@QueryMap parameter type must be Map.", new Object[0]);
                    } else if (annotation instanceof Header) {
                        String value2 = ((Header) annotation).value();
                        Class rawType4 = Utils.getRawType(type);
                        if (Iterable.class.isAssignableFrom(rawType4)) {
                            if (type instanceof ParameterizedType) {
                                return new Header(value2, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) type), annotationArr)).iterable();
                            }
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(rawType4.getSimpleName());
                            sb4.append(str3);
                            sb4.append(rawType4.getSimpleName());
                            sb4.append(str2);
                            throw parameterError(i2, sb4.toString(), new Object[0]);
                        } else if (!rawType4.isArray()) {
                            return new Header(value2, this.retrofit.stringConverter(type, annotationArr));
                        } else {
                            return new Header(value2, this.retrofit.stringConverter(ServiceMethod.boxIfPrimitive(rawType4.getComponentType()), annotationArr)).array();
                        }
                    } else if (annotation instanceof HeaderMap) {
                        Class rawType5 = Utils.getRawType(type);
                        if (Map.class.isAssignableFrom(rawType5)) {
                            Type supertype2 = Utils.getSupertype(type, rawType5, Map.class);
                            if (supertype2 instanceof ParameterizedType) {
                                ParameterizedType parameterizedType2 = (ParameterizedType) supertype2;
                                Type parameterUpperBound2 = Utils.getParameterUpperBound(0, parameterizedType2);
                                if (String.class == parameterUpperBound2) {
                                    return new HeaderMap(this.retrofit.stringConverter(Utils.getParameterUpperBound(1, parameterizedType2), annotationArr));
                                }
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("@HeaderMap keys must be of type String: ");
                                sb5.append(parameterUpperBound2);
                                throw parameterError(i2, sb5.toString(), new Object[0]);
                            }
                            throw parameterError(i2, str4, new Object[0]);
                        }
                        throw parameterError(i2, "@HeaderMap parameter type must be Map.", new Object[0]);
                    } else if (annotation instanceof Field) {
                        if (this.isFormEncoded) {
                            Field field = (Field) annotation;
                            String value3 = field.value();
                            boolean encoded3 = field.encoded();
                            this.gotField = true;
                            Class rawType6 = Utils.getRawType(type);
                            if (Iterable.class.isAssignableFrom(rawType6)) {
                                if (type instanceof ParameterizedType) {
                                    return new Field(value3, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) type), annotationArr), encoded3).iterable();
                                }
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append(rawType6.getSimpleName());
                                sb6.append(str3);
                                sb6.append(rawType6.getSimpleName());
                                sb6.append(str2);
                                throw parameterError(i2, sb6.toString(), new Object[0]);
                            } else if (!rawType6.isArray()) {
                                return new Field(value3, this.retrofit.stringConverter(type, annotationArr), encoded3);
                            } else {
                                return new Field(value3, this.retrofit.stringConverter(ServiceMethod.boxIfPrimitive(rawType6.getComponentType()), annotationArr), encoded3).array();
                            }
                        } else {
                            throw parameterError(i2, "@Field parameters can only be used with form encoding.", new Object[0]);
                        }
                    } else if (annotation instanceof FieldMap) {
                        if (this.isFormEncoded) {
                            Class rawType7 = Utils.getRawType(type);
                            if (Map.class.isAssignableFrom(rawType7)) {
                                Type supertype3 = Utils.getSupertype(type, rawType7, Map.class);
                                if (supertype3 instanceof ParameterizedType) {
                                    ParameterizedType parameterizedType3 = (ParameterizedType) supertype3;
                                    Type parameterUpperBound3 = Utils.getParameterUpperBound(0, parameterizedType3);
                                    if (String.class == parameterUpperBound3) {
                                        Converter stringConverter = this.retrofit.stringConverter(Utils.getParameterUpperBound(1, parameterizedType3), annotationArr);
                                        this.gotField = true;
                                        return new FieldMap(stringConverter, ((FieldMap) annotation).encoded());
                                    }
                                    StringBuilder sb7 = new StringBuilder();
                                    sb7.append("@FieldMap keys must be of type String: ");
                                    sb7.append(parameterUpperBound3);
                                    throw parameterError(i2, sb7.toString(), new Object[0]);
                                }
                                throw parameterError(i2, str4, new Object[0]);
                            }
                            throw parameterError(i2, "@FieldMap parameter type must be Map.", new Object[0]);
                        }
                        throw parameterError(i2, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                    } else if (annotation instanceof Part) {
                        if (this.isMultipart) {
                            Part part = (Part) annotation;
                            this.gotPart = true;
                            String value4 = part.value();
                            Class rawType8 = Utils.getRawType(type);
                            if (value4.isEmpty()) {
                                String str5 = "@Part annotation must supply a name or use MultipartBody.Part parameter type.";
                                if (Iterable.class.isAssignableFrom(rawType8)) {
                                    if (!(type instanceof ParameterizedType)) {
                                        StringBuilder sb8 = new StringBuilder();
                                        sb8.append(rawType8.getSimpleName());
                                        sb8.append(str3);
                                        sb8.append(rawType8.getSimpleName());
                                        sb8.append(str2);
                                        throw parameterError(i2, sb8.toString(), new Object[0]);
                                    } else if (MultipartBody.Part.class.isAssignableFrom(Utils.getRawType(Utils.getParameterUpperBound(0, (ParameterizedType) type)))) {
                                        return RawPart.INSTANCE.iterable();
                                    } else {
                                        throw parameterError(i2, str5, new Object[0]);
                                    }
                                } else if (rawType8.isArray()) {
                                    if (MultipartBody.Part.class.isAssignableFrom(rawType8.getComponentType())) {
                                        return RawPart.INSTANCE.array();
                                    }
                                    throw parameterError(i2, str5, new Object[0]);
                                } else if (MultipartBody.Part.class.isAssignableFrom(rawType8)) {
                                    return RawPart.INSTANCE;
                                } else {
                                    throw parameterError(i2, str5, new Object[0]);
                                }
                            } else {
                                StringBuilder sb9 = new StringBuilder();
                                sb9.append("form-data; name=\"");
                                sb9.append(value4);
                                sb9.append("\"");
                                Headers of = Headers.of("Content-Disposition", sb9.toString(), "Content-Transfer-Encoding", part.encoding());
                                String str6 = "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.";
                                if (Iterable.class.isAssignableFrom(rawType8)) {
                                    if (type instanceof ParameterizedType) {
                                        Type parameterUpperBound4 = Utils.getParameterUpperBound(0, (ParameterizedType) type);
                                        if (!MultipartBody.Part.class.isAssignableFrom(Utils.getRawType(parameterUpperBound4))) {
                                            return new Part(of, this.retrofit.requestBodyConverter(parameterUpperBound4, annotationArr, this.methodAnnotations)).iterable();
                                        }
                                        throw parameterError(i2, str6, new Object[0]);
                                    }
                                    StringBuilder sb10 = new StringBuilder();
                                    sb10.append(rawType8.getSimpleName());
                                    sb10.append(str3);
                                    sb10.append(rawType8.getSimpleName());
                                    sb10.append(str2);
                                    throw parameterError(i2, sb10.toString(), new Object[0]);
                                } else if (rawType8.isArray()) {
                                    Class boxIfPrimitive = ServiceMethod.boxIfPrimitive(rawType8.getComponentType());
                                    if (!MultipartBody.Part.class.isAssignableFrom(boxIfPrimitive)) {
                                        return new Part(of, this.retrofit.requestBodyConverter(boxIfPrimitive, annotationArr, this.methodAnnotations)).array();
                                    }
                                    throw parameterError(i2, str6, new Object[0]);
                                } else if (!MultipartBody.Part.class.isAssignableFrom(rawType8)) {
                                    return new Part(of, this.retrofit.requestBodyConverter(type, annotationArr, this.methodAnnotations));
                                } else {
                                    throw parameterError(i2, str6, new Object[0]);
                                }
                            }
                        } else {
                            throw parameterError(i2, "@Part parameters can only be used with multipart encoding.", new Object[0]);
                        }
                    } else if (annotation instanceof PartMap) {
                        if (this.isMultipart) {
                            this.gotPart = true;
                            Class rawType9 = Utils.getRawType(type);
                            if (Map.class.isAssignableFrom(rawType9)) {
                                Type supertype4 = Utils.getSupertype(type, rawType9, Map.class);
                                if (supertype4 instanceof ParameterizedType) {
                                    ParameterizedType parameterizedType4 = (ParameterizedType) supertype4;
                                    Type parameterUpperBound5 = Utils.getParameterUpperBound(0, parameterizedType4);
                                    if (String.class == parameterUpperBound5) {
                                        Type parameterUpperBound6 = Utils.getParameterUpperBound(1, parameterizedType4);
                                        if (!MultipartBody.Part.class.isAssignableFrom(Utils.getRawType(parameterUpperBound6))) {
                                            return new PartMap(this.retrofit.requestBodyConverter(parameterUpperBound6, annotationArr, this.methodAnnotations), ((PartMap) annotation).encoding());
                                        }
                                        throw parameterError(i2, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                                    }
                                    StringBuilder sb11 = new StringBuilder();
                                    sb11.append("@PartMap keys must be of type String: ");
                                    sb11.append(parameterUpperBound5);
                                    throw parameterError(i2, sb11.toString(), new Object[0]);
                                }
                                throw parameterError(i2, str4, new Object[0]);
                            }
                            throw parameterError(i2, "@PartMap parameter type must be Map.", new Object[0]);
                        }
                        throw parameterError(i2, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                    } else if (!(annotation instanceof Body)) {
                        return null;
                    } else {
                        if (this.isFormEncoded || this.isMultipart) {
                            throw parameterError(i2, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                        } else if (!this.gotBody) {
                            try {
                                Converter requestBodyConverter = this.retrofit.requestBodyConverter(type, annotationArr, this.methodAnnotations);
                                this.gotBody = true;
                                return new Body(requestBodyConverter);
                            } catch (RuntimeException e2) {
                                throw parameterError(e2, i2, "Unable to create @Body converter for %s", type);
                            }
                        } else {
                            throw parameterError(i2, "Multiple @Body method annotations found.", new Object[0]);
                        }
                    }
                }
            } else if (this.gotQuery) {
                throw parameterError(i2, "A @Path parameter must not come after a @Query.", new Object[0]);
            } else if (this.gotUrl) {
                throw parameterError(i2, str, new Object[0]);
            } else if (this.relativeUrl != null) {
                this.gotPath = true;
                Path path = (Path) annotation;
                String value5 = path.value();
                validatePathName(i2, value5);
                return new Path(value5, this.retrofit.stringConverter(type, annotationArr), path.encoded());
            } else {
                throw parameterError(i2, "@Path can only be used with relative url on @%s", this.httpMethod);
            }
        }

        private void validatePathName(int i2, String str) {
            if (!ServiceMethod.PARAM_NAME_REGEX.matcher(str).matches()) {
                throw parameterError(i2, "@Path parameter name must match %s. Found: %s", ServiceMethod.PARAM_URL_REGEX.pattern(), str);
            } else if (!this.relativeUrlParamNames.contains(str)) {
                throw parameterError(i2, "URL \"%s\" does not contain \"{%s}\".", this.relativeUrl, str);
            }
        }

        public ServiceMethod build() {
            this.callAdapter = createCallAdapter();
            this.responseType = this.callAdapter.responseType();
            Type type = this.responseType;
            if (type == Response.class || type == Response.class) {
                StringBuilder sb = new StringBuilder();
                sb.append("'");
                sb.append(Utils.getRawType(this.responseType).getName());
                sb.append("' is not a valid response body type. Did you mean ResponseBody?");
                throw methodError(sb.toString(), new Object[0]);
            }
            this.responseConverter = createResponseConverter();
            for (Annotation parseMethodAnnotation : this.methodAnnotations) {
                parseMethodAnnotation(parseMethodAnnotation);
            }
            if (this.httpMethod != null) {
                if (!this.hasBody) {
                    if (this.isMultipart) {
                        throw methodError("Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    } else if (this.isFormEncoded) {
                        throw methodError("FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    }
                }
                int length = this.parameterAnnotationsArray.length;
                this.parameterHandlers = new ParameterHandler[length];
                int i2 = 0;
                while (i2 < length) {
                    Type type2 = this.parameterTypes[i2];
                    if (!Utils.hasUnresolvableType(type2)) {
                        Annotation[] annotationArr = this.parameterAnnotationsArray[i2];
                        if (annotationArr != null) {
                            this.parameterHandlers[i2] = parseParameter(i2, type2, annotationArr);
                            i2++;
                        } else {
                            throw parameterError(i2, "No Retrofit annotation found.", new Object[0]);
                        }
                    } else {
                        throw parameterError(i2, "Parameter type must not include a type variable or wildcard: %s", type2);
                    }
                }
                if (this.relativeUrl == null && !this.gotUrl) {
                    throw methodError("Missing either @%s URL or @Url parameter.", this.httpMethod);
                } else if (!this.isFormEncoded && !this.isMultipart && !this.hasBody && this.gotBody) {
                    throw methodError("Non-body HTTP method cannot contain @Body.", new Object[0]);
                } else if (this.isFormEncoded && !this.gotField) {
                    throw methodError("Form-encoded method must contain at least one @Field.", new Object[0]);
                } else if (!this.isMultipart || this.gotPart) {
                    return new ServiceMethod(this);
                } else {
                    throw methodError("Multipart method must contain at least one @Part.", new Object[0]);
                }
            } else {
                throw methodError("HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
        }

        private RuntimeException methodError(Throwable th, String str, Object... objArr) {
            String format = String.format(str, objArr);
            StringBuilder sb = new StringBuilder();
            sb.append(format);
            sb.append("\n    for method ");
            sb.append(this.method.getDeclaringClass().getSimpleName());
            sb.append(".");
            sb.append(this.method.getName());
            return new IllegalArgumentException(sb.toString(), th);
        }

        private RuntimeException parameterError(int i2, String str, Object... objArr) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" (parameter #");
            sb.append(i2 + 1);
            sb.append(")");
            return methodError(sb.toString(), objArr);
        }
    }

    ServiceMethod(Builder<R, T> builder) {
        this.callFactory = builder.retrofit.callFactory();
        this.callAdapter = builder.callAdapter;
        this.baseUrl = builder.retrofit.baseUrl();
        this.responseConverter = builder.responseConverter;
        this.httpMethod = builder.httpMethod;
        this.relativeUrl = builder.relativeUrl;
        this.headers = builder.headers;
        this.contentType = builder.contentType;
        this.hasBody = builder.hasBody;
        this.isFormEncoded = builder.isFormEncoded;
        this.isMultipart = builder.isMultipart;
        this.parameterHandlers = builder.parameterHandlers;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r1v0, types: [java.lang.Class<?>, java.lang.Class] */
    static Class<?> boxIfPrimitive(Class cls) {
        if (Boolean.TYPE == cls) {
            return Boolean.class;
        }
        if (Byte.TYPE == cls) {
            return Byte.class;
        }
        if (Character.TYPE == cls) {
            return Character.class;
        }
        if (Double.TYPE == cls) {
            return Double.class;
        }
        if (Float.TYPE == cls) {
            return Float.class;
        }
        if (Integer.TYPE == cls) {
            return Integer.class;
        }
        if (Long.TYPE == cls) {
            return Long.class;
        }
        if (Short.TYPE == cls) {
            cls = Short.class;
        }
        return cls;
    }

    static Set<String> parsePathParameters(String str) {
        Matcher matcher = PARAM_URL_REGEX.matcher(str);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (matcher.find()) {
            linkedHashSet.add(matcher.group(1));
        }
        return linkedHashSet;
    }

    /* access modifiers changed from: 0000 */
    public Request toRequest(Object... objArr) throws IOException {
        RequestBuilder requestBuilder = new RequestBuilder(this.httpMethod, this.baseUrl, this.relativeUrl, this.headers, this.contentType, this.hasBody, this.isFormEncoded, this.isMultipart);
        ParameterHandler<?>[] parameterHandlerArr = this.parameterHandlers;
        int length = objArr != null ? objArr.length : 0;
        if (length == parameterHandlerArr.length) {
            for (int i2 = 0; i2 < length; i2++) {
                parameterHandlerArr[i2].apply(requestBuilder, objArr[i2]);
            }
            return requestBuilder.build();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Argument count (");
        sb.append(length);
        sb.append(") doesn't match expected count (");
        sb.append(parameterHandlerArr.length);
        sb.append(")");
        throw new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    public R toResponse(ResponseBody responseBody) throws IOException {
        return this.responseConverter.convert(responseBody);
    }
}
