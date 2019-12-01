package io.intercom.com.google.gson.b;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

/* renamed from: io.intercom.com.google.gson.b.b reason: case insensitive filesystem */
/* compiled from: $Gson$Types */
public final class C0779b {

    /* renamed from: a reason: collision with root package name */
    static final Type[] f10107a = new Type[0];

    /* renamed from: io.intercom.com.google.gson.b.b$a */
    /* compiled from: $Gson$Types */
    private static final class a implements GenericArrayType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type componentType;

        public a(Type type) {
            this.componentType = C0779b.b(type);
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && C0779b.a((Type) this, (Type) (GenericArrayType) obj);
        }

        public Type getGenericComponentType() {
            return this.componentType;
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(C0779b.h(this.componentType));
            sb.append("[]");
            return sb.toString();
        }
    }

    /* renamed from: io.intercom.com.google.gson.b.b$b reason: collision with other inner class name */
    /* compiled from: $Gson$Types */
    private static final class C0115b implements ParameterizedType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type ownerType;
        private final Type rawType;
        private final Type[] typeArguments;

        public C0115b(Type type, Type type2, Type... typeArr) {
            Type type3;
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                boolean z = true;
                boolean z2 = Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null;
                if (type == null && !z2) {
                    z = false;
                }
                C0753a.a(z);
            }
            if (type == null) {
                type3 = null;
            } else {
                type3 = C0779b.b(type);
            }
            this.ownerType = type3;
            this.rawType = C0779b.b(type2);
            this.typeArguments = (Type[]) typeArr.clone();
            int length = this.typeArguments.length;
            for (int i2 = 0; i2 < length; i2++) {
                C0753a.a(this.typeArguments[i2]);
                C0779b.c(this.typeArguments[i2]);
                Type[] typeArr2 = this.typeArguments;
                typeArr2[i2] = C0779b.b(typeArr2[i2]);
            }
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && C0779b.a((Type) this, (Type) (ParameterizedType) obj);
        }

        public Type[] getActualTypeArguments() {
            return (Type[]) this.typeArguments.clone();
        }

        public Type getOwnerType() {
            return this.ownerType;
        }

        public Type getRawType() {
            return this.rawType;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode()) ^ C0779b.a((Object) this.ownerType);
        }

        public String toString() {
            int length = this.typeArguments.length;
            if (length == 0) {
                return C0779b.h(this.rawType);
            }
            StringBuilder sb = new StringBuilder((length + 1) * 30);
            sb.append(C0779b.h(this.rawType));
            sb.append("<");
            sb.append(C0779b.h(this.typeArguments[0]));
            for (int i2 = 1; i2 < length; i2++) {
                sb.append(", ");
                sb.append(C0779b.h(this.typeArguments[i2]));
            }
            sb.append(">");
            return sb.toString();
        }
    }

    /* renamed from: io.intercom.com.google.gson.b.b$c */
    /* compiled from: $Gson$Types */
    private static final class c implements WildcardType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type lowerBound;
        private final Type upperBound;

        public c(Type[] typeArr, Type[] typeArr2) {
            boolean z = true;
            C0753a.a(typeArr2.length <= 1);
            C0753a.a(typeArr.length == 1);
            if (typeArr2.length == 1) {
                C0753a.a(typeArr2[0]);
                C0779b.c(typeArr2[0]);
                if (typeArr[0] != Object.class) {
                    z = false;
                }
                C0753a.a(z);
                this.lowerBound = C0779b.b(typeArr2[0]);
                this.upperBound = Object.class;
                return;
            }
            C0753a.a(typeArr[0]);
            C0779b.c(typeArr[0]);
            this.lowerBound = null;
            this.upperBound = C0779b.b(typeArr[0]);
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && C0779b.a((Type) this, (Type) (WildcardType) obj);
        }

        public Type[] getLowerBounds() {
            Type type = this.lowerBound;
            if (type == null) {
                return C0779b.f10107a;
            }
            return new Type[]{type};
        }

        public Type[] getUpperBounds() {
            return new Type[]{this.upperBound};
        }

        public int hashCode() {
            Type type = this.lowerBound;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.upperBound.hashCode() + 31);
        }

        public String toString() {
            if (this.lowerBound != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("? super ");
                sb.append(C0779b.h(this.lowerBound));
                return sb.toString();
            } else if (this.upperBound == Object.class) {
                return "?";
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("? extends ");
                sb2.append(C0779b.h(this.upperBound));
                return sb2.toString();
            }
        }
    }

    public static ParameterizedType a(Type type, Type type2, Type... typeArr) {
        return new C0115b(type, type2, typeArr);
    }

    /* JADX WARNING: type inference failed for: r0v8, types: [io.intercom.com.google.gson.b.b$a] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static Type b(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                cls = new a(b(cls.getComponentType()));
            }
            return cls;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new C0115b(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        } else if (type instanceof GenericArrayType) {
            return new a(((GenericArrayType) type).getGenericComponentType());
        } else {
            if (!(type instanceof WildcardType)) {
                return type;
            }
            WildcardType wildcardType = (WildcardType) type;
            return new c(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
        }
    }

    static void c(Type type) {
        C0753a.a(!(type instanceof Class) || !((Class) type).isPrimitive());
    }

    public static Type d(Type type) {
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        }
        return ((Class) type).getComponentType();
    }

    public static Class<?> e(Type type) {
        String str;
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            C0753a.a(rawType instanceof Class);
            return (Class) rawType;
        } else if (type instanceof GenericArrayType) {
            return Array.newInstance(e(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        } else {
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (type instanceof WildcardType) {
                return e(((WildcardType) type).getUpperBounds()[0]);
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

    public static WildcardType f(Type type) {
        Type[] typeArr;
        if (type instanceof WildcardType) {
            typeArr = ((WildcardType) type).getUpperBounds();
        } else {
            typeArr = new Type[]{type};
        }
        return new c(typeArr, f10107a);
    }

    public static WildcardType g(Type type) {
        Type[] typeArr;
        if (type instanceof WildcardType) {
            typeArr = ((WildcardType) type).getLowerBounds();
        } else {
            typeArr = new Type[]{type};
        }
        return new c(new Type[]{Object.class}, typeArr);
    }

    public static String h(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    public static GenericArrayType a(Type type) {
        return new a(type);
    }

    static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean a(Type type, Type type2) {
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
            if (!a((Object) parameterizedType.getOwnerType(), (Object) parameterizedType2.getOwnerType()) || !parameterizedType.getRawType().equals(parameterizedType2.getRawType()) || !Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments())) {
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
        C0753a.a(cls2.isAssignableFrom(cls));
        return a(type, cls, a(type, cls, cls2));
    }

    public static Type[] b(Type type, Class<?> cls) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        Type b2 = b(type, cls, Map.class);
        if (b2 instanceof ParameterizedType) {
            return ((ParameterizedType) b2).getActualTypeArguments();
        }
        return new Type[]{Object.class, Object.class};
    }

    static int a(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
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

    public static Type a(Type type, Class<?> cls) {
        Type b2 = b(type, cls, Collection.class);
        if (b2 instanceof WildcardType) {
            b2 = ((WildcardType) b2).getUpperBounds()[0];
        }
        if (b2 instanceof ParameterizedType) {
            return ((ParameterizedType) b2).getActualTypeArguments()[0];
        }
        return Object.class;
    }

    public static Type a(Type type, Class<?> cls, Type type2) {
        return a(type, cls, type2, new HashSet());
    }

    /* JADX WARNING: type inference failed for: r10v0, types: [java.lang.reflect.Type] */
    /* JADX WARNING: type inference failed for: r10v1, types: [java.lang.reflect.Type] */
    /* JADX WARNING: type inference failed for: r10v2, types: [java.lang.reflect.Type] */
    /* JADX WARNING: type inference failed for: r10v3, types: [java.lang.reflect.WildcardType] */
    /* JADX WARNING: type inference failed for: r0v18 */
    /* JADX WARNING: type inference failed for: r0v19, types: [java.lang.Class] */
    /* JADX WARNING: type inference failed for: r0v20, types: [java.lang.reflect.Type] */
    /* JADX WARNING: type inference failed for: r0v21, types: [java.lang.reflect.GenericArrayType] */
    /* JADX WARNING: type inference failed for: r0v22 */
    /* JADX WARNING: type inference failed for: r10v11, types: [java.lang.reflect.Type] */
    /* JADX WARNING: type inference failed for: r10v12 */
    /* JADX WARNING: type inference failed for: r0v24 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.reflect.Type, code=null, for r10v0, types: [java.lang.reflect.Type] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r10v11, types: [java.lang.reflect.Type]
      assigns: [java.lang.reflect.Type, java.lang.reflect.WildcardType]
      uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], java.lang.reflect.Type, ?[OBJECT, ARRAY], java.lang.reflect.WildcardType]
      mth insns count: 84
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 6 */
    private static Type a(Type type, Class<?> cls, Type r10, Collection<TypeVariable> collection) {
        TypeVariable typeVariable;
        do {
            boolean z = r10 instanceof TypeVariable;
            r10 = r10;
            if (z) {
                typeVariable = (TypeVariable) r10;
                if (collection.contains(typeVariable)) {
                    return r10;
                }
                collection.add(typeVariable);
                r10 = a(type, cls, typeVariable);
            } else {
                if (r10 instanceof Class) {
                    ? r0 = (Class) r10;
                    if (r0.isArray()) {
                        Class componentType = r0.getComponentType();
                        Type a2 = a(type, cls, componentType, collection);
                        if (componentType != a2) {
                            r0 = a(a2);
                        }
                        return r0;
                    }
                }
                if (r10 instanceof GenericArrayType) {
                    GenericArrayType genericArrayType = (GenericArrayType) r10;
                    Type genericComponentType = genericArrayType.getGenericComponentType();
                    Type a3 = a(type, cls, genericComponentType, collection);
                    if (genericComponentType != a3) {
                        genericArrayType = a(a3);
                    }
                    return genericArrayType;
                }
                if (r10 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) r10;
                    Type ownerType = parameterizedType.getOwnerType();
                    Type a4 = a(type, cls, ownerType, collection);
                    boolean z2 = a4 != ownerType;
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    int length = actualTypeArguments.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        Type a5 = a(type, cls, actualTypeArguments[i2], collection);
                        if (a5 != actualTypeArguments[i2]) {
                            if (!z2) {
                                actualTypeArguments = (Type[]) actualTypeArguments.clone();
                                z2 = true;
                            }
                            actualTypeArguments[i2] = a5;
                        }
                    }
                    if (z2) {
                        parameterizedType = a(a4, parameterizedType.getRawType(), actualTypeArguments);
                    }
                    return parameterizedType;
                }
                if (r10 instanceof WildcardType) {
                    r10 = (WildcardType) r10;
                    Type[] lowerBounds = r10.getLowerBounds();
                    Type[] upperBounds = r10.getUpperBounds();
                    if (lowerBounds.length == 1) {
                        Type a6 = a(type, cls, lowerBounds[0], collection);
                        if (a6 != lowerBounds[0]) {
                            return g(a6);
                        }
                    } else if (upperBounds.length == 1) {
                        Type a7 = a(type, cls, upperBounds[0], collection);
                        if (a7 != upperBounds[0]) {
                            return f(a7);
                        }
                    }
                }
                return r10;
            }
        } while (r10 != typeVariable);
        return r10;
    }

    static Type a(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
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

    private static int a(Object[] objArr, Object obj) {
        int length = objArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (obj.equals(objArr[i2])) {
                return i2;
            }
        }
        throw new NoSuchElementException();
    }

    private static Class<?> a(TypeVariable<?> typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }
}
