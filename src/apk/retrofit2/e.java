package retrofit2;

import i.L;
import i.O;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* compiled from: Converter */
public interface e<F, T> {

    /* compiled from: Converter */
    public static abstract class a {
        public e<O, ?> a(Type type, Annotation[] annotationArr, w wVar) {
            return null;
        }

        public e<?, L> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, w wVar) {
            return null;
        }

        public e<?, String> b(Type type, Annotation[] annotationArr, w wVar) {
            return null;
        }
    }

    T convert(F f2) throws IOException;
}
