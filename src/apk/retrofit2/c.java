package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: CallAdapter */
public interface c<R, T> {

    /* compiled from: CallAdapter */
    public static abstract class a {
        protected static Type a(int i2, ParameterizedType parameterizedType) {
            return y.a(i2, parameterizedType);
        }

        public abstract c<?, ?> a(Type type, Annotation[] annotationArr, w wVar);

        protected static Class<?> a(Type type) {
            return y.c(type);
        }
    }

    T a(b<R> bVar);

    Type responseType();
}
