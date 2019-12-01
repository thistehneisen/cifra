package retrofit2;

import i.O;
import j.f;
import j.z;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;

/* compiled from: Utils */
final class y {

    /* renamed from: a reason: collision with root package name */
    static final Type[] f11104a = new Type[0];

    /* compiled from: Utils */
    private static final class a implements GenericArrayType {

        /* renamed from: a reason: collision with root package name */
        private final Type f11105a;

        a(Type type) {
            this.f11105a = type;
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && y.a((Type) this, (Type) (GenericArrayType) obj);
        }

        public Type getGenericComponentType() {
            return this.f11105a;
        }

        public int hashCode() {
            return this.f11105a.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(y.e(this.f11105a));
            sb.append("[]");
            return sb.toString();
        }
    }

    /* compiled from: Utils */
    private static final class b implements ParameterizedType {

        /* renamed from: a reason: collision with root package name */
        private final Type f11106a;

        /* renamed from: b reason: collision with root package name */
        private final Type f11107b;

        /* renamed from: c reason: collision with root package name */
        private final Type[] f11108c;

        b(Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                boolean z = true;
                boolean z2 = type == null;
                if (((Class) type2).getEnclosingClass() != null) {
                    z = false;
                }
                if (z2 != z) {
                    throw new IllegalArgumentException();
                }
            }
            for (Type type3 : typeArr) {
                y.a(type3, "typeArgument == null");
                y.a(type3);
            }
            this.f11106a = type;
            this.f11107b = type2;
            this.f11108c = (Type[]) typeArr.clone();
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && y.a((Type) this, (Type) (ParameterizedType) obj);
        }

        public Type[] getActualTypeArguments() {
            return (Type[]) this.f11108c.clone();
        }

        public Type getOwnerType() {
            return this.f11106a;
        }

        public Type getRawType() {
            return this.f11107b;
        }

        public int hashCode() {
            int hashCode = Arrays.hashCode(this.f11108c) ^ this.f11107b.hashCode();
            Type type = this.f11106a;
            return hashCode ^ (type != null ? type.hashCode() : 0);
        }

        public String toString() {
            Type[] typeArr = this.f11108c;
            if (typeArr.length == 0) {
                return y.e(this.f11107b);
            }
            StringBuilder sb = new StringBuilder((typeArr.length + 1) * 30);
            sb.append(y.e(this.f11107b));
            sb.append("<");
            sb.append(y.e(this.f11108c[0]));
            for (int i2 = 1; i2 < this.f11108c.length; i2++) {
                sb.append(", ");
                sb.append(y.e(this.f11108c[i2]));
            }
            sb.append(">");
            return sb.toString();
        }
    }

    /* compiled from: Utils */
    private static final class c implements WildcardType {

        /* renamed from: a reason: collision with root package name */
        private final Type f11109a;

        /* renamed from: b reason: collision with root package name */
        private final Type f11110b;

        c(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length > 1) {
                throw new IllegalArgumentException();
            } else if (typeArr.length != 1) {
                throw new IllegalArgumentException();
            } else if (typeArr2.length == 1) {
                if (typeArr2[0] != null) {
                    y.a(typeArr2[0]);
                    if (typeArr[0] == Object.class) {
                        this.f11110b = typeArr2[0];
                        this.f11109a = Object.class;
                        return;
                    }
                    throw new IllegalArgumentException();
                }
                throw new NullPointerException();
            } else if (typeArr[0] != null) {
                y.a(typeArr[0]);
                this.f11110b = null;
                this.f11109a = typeArr[0];
            } else {
                throw new NullPointerException();
            }
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && y.a((Type) this, (Type) (WildcardType) obj);
        }

        public Type[] getLowerBounds() {
            Type type = this.f11110b;
            if (type == null) {
                return y.f11104a;
            }
            return new Type[]{type};
        }

        public Type[] getUpperBounds() {
            return new Type[]{this.f11109a};
        }

        public int hashCode() {
            Type type = this.f11110b;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.f11109a.hashCode() + 31);
        }

        public String toString() {
            if (this.f11110b != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("? super ");
                sb.append(y.e(this.f11110b));
                return sb.toString();
            } else if (this.f11109a == Object.class) {
                return "?";
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("? extends ");
                sb2.append(y.e(this.f11109a));
                return sb2.toString();
            }
        }
    }

    static boolean a(Type type, Type type2) {
        boolean z = true;
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            Type ownerType = parameterizedType.getOwnerType();
            Type ownerType2 = parameterizedType2.getOwnerType();
            if ((ownerType != ownerType2 && (ownerType == null || !ownerType.equals(ownerType2))) || !parameterizedType.getRawType().equals(parameterizedType2.getRawType()) || !Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments())) {
                z = false;
            }
            return z;
        } else if (type instanceof GenericArrayType) {
            if (!(type2 instanceof GenericArrayType)) {
                return false;
            }
            return a(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
        } else if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            if (!Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) || !Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds())) {
                z = false;
            }
            return z;
        } else if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        } else {
            TypeVariable typeVariable = (TypeVariable) type;
            TypeVariable typeVariable2 = (TypeVariable) type2;
            if (typeVariable.getGenericDeclaration() != typeVariable2.getGenericDeclaration() || !typeVariable.getName().equals(typeVariable2.getName())) {
                z = false;
            }
            return z;
        }
    }

    static Type b(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return a(type, cls, a(type, cls, cls2));
        }
        throw new IllegalArgumentException();
    }

    static Class<?> c(Type type) {
        a((T) type, "type == null");
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return (Class) rawType;
            }
            throw new IllegalArgumentException();
        } else if (type instanceof GenericArrayType) {
            return Array.newInstance(c(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        } else {
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (type instanceof WildcardType) {
                return c(((WildcardType) type).getUpperBounds()[0]);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
            sb.append(type);
            sb.append("> is of type ");
            sb.append(type.getClass().getName());
            throw new IllegalArgumentException(sb.toString());
        }
    }

    static boolean d(Type type) {
        String str;
        if (type instanceof Class) {
            return false;
        }
        if (type instanceof ParameterizedType) {
            for (Type d2 : ((ParameterizedType) type).getActualTypeArguments()) {
                if (d(d2)) {
                    return true;
                }
            }
            return false;
        } else if (type instanceof GenericArrayType) {
            return d(((GenericArrayType) type).getGenericComponentType());
        } else {
            if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
                return true;
            }
            if (type == null) {
                str = "null";
            } else {
                str = type.getClass().getName();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
            sb.append(type);
            sb.append("> is of type ");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    static String e(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    static Type b(Type type) {
        if (type instanceof ParameterizedType) {
            return a(0, (ParameterizedType) type);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }

    static Type a(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (interfaces[i2] == cls2) {
                    return cls.getGenericInterfaces()[i2];
                }
                if (cls2.isAssignableFrom(interfaces[i2])) {
                    return a(cls.getGenericInterfaces()[i2], interfaces[i2], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<?> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return a(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    private static int a(Object[] objArr, Object obj) {
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (obj.equals(objArr[i2])) {
                return i2;
            }
        }
        throw new NoSuchElementException();
    }

    /* JADX WARNING: type inference failed for: r10v2, types: [java.lang.reflect.Type] */
    /* JADX WARNING: type inference failed for: r0v23, types: [retrofit2.y$a] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    static Type a(Type type, Class<?> cls, Type type2) {
        while (true) {
            boolean z = r10 instanceof TypeVariable;
            r10 = type2;
            if (z) {
                TypeVariable typeVariable = (TypeVariable) r10;
                Type a2 = a(type, cls, typeVariable);
                if (a2 == typeVariable) {
                    return a2;
                }
                r10 = a2;
            } else {
                if (r10 instanceof Class) {
                    Class cls2 = (Class) r10;
                    if (cls2.isArray()) {
                        Class componentType = cls2.getComponentType();
                        Type a3 = a(type, cls, (Type) componentType);
                        if (componentType != a3) {
                            cls2 = new a(a3);
                        }
                        return cls2;
                    }
                }
                if (r10 instanceof GenericArrayType) {
                    GenericArrayType genericArrayType = (GenericArrayType) r10;
                    Type genericComponentType = genericArrayType.getGenericComponentType();
                    Type a4 = a(type, cls, genericComponentType);
                    if (genericComponentType != a4) {
                        genericArrayType = new a(a4);
                    }
                    return genericArrayType;
                }
                if (r10 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) r10;
                    Type ownerType = parameterizedType.getOwnerType();
                    Type a5 = a(type, cls, ownerType);
                    boolean z2 = a5 != ownerType;
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    int length = actualTypeArguments.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        Type a6 = a(type, cls, actualTypeArguments[i2]);
                        if (a6 != actualTypeArguments[i2]) {
                            if (!z2) {
                                actualTypeArguments = (Type[]) actualTypeArguments.clone();
                                z2 = true;
                            }
                            actualTypeArguments[i2] = a6;
                        }
                    }
                    return z2 ? new b(a5, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
                }
                if (r10 instanceof WildcardType) {
                    r10 = r10;
                    Type[] lowerBounds = r10.getLowerBounds();
                    Type[] upperBounds = r10.getUpperBounds();
                    if (lowerBounds.length == 1) {
                        Type a7 = a(type, cls, lowerBounds[0]);
                        if (a7 != lowerBounds[0]) {
                            return new c(new Type[]{Object.class}, new Type[]{a7});
                        }
                    } else if (upperBounds.length == 1) {
                        Type a8 = a(type, cls, upperBounds[0]);
                        if (a8 != upperBounds[0]) {
                            return new c(new Type[]{a8}, f11104a);
                        }
                    }
                }
                return r10;
            }
        }
    }

    private static Type a(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class a2 = a(typeVariable);
        if (a2 == null) {
            return typeVariable;
        }
        Type a3 = a(type, cls, a2);
        if (!(a3 instanceof ParameterizedType)) {
            return typeVariable;
        }
        return ((ParameterizedType) a3).getActualTypeArguments()[a((Object[]) a2.getTypeParameters(), (Object) typeVariable)];
    }

    private static Class<?> a(TypeVariable<?> typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    static void a(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException();
        }
    }

    static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    static boolean a(Annotation[] annotationArr, Class<? extends Annotation> cls) {
        for (Annotation isInstance : annotationArr) {
            if (cls.isInstance(isInstance)) {
                return true;
            }
        }
        return false;
    }

    static O a(O o) throws IOException {
        f fVar = new f();
        o.d().a((z) fVar);
        return O.a(o.c(), o.b(), fVar);
    }

    static <T> void a(Class<T> cls) {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        } else if (cls.getInterfaces().length > 0) {
            throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
        }
    }

    static Type a(int i2, ParameterizedType parameterizedType) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (i2 < 0 || i2 >= actualTypeArguments.length) {
            StringBuilder sb = new StringBuilder();
            sb.append("Index ");
            sb.append(i2);
            sb.append(" not in range [0,");
            sb.append(actualTypeArguments.length);
            sb.append(") for ");
            sb.append(parameterizedType);
            throw new IllegalArgumentException(sb.toString());
        }
        Type type = actualTypeArguments[i2];
        return type instanceof WildcardType ? ((WildcardType) type).getUpperBounds()[0] : type;
    }

    static void a(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        } else if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        } else if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }
}
