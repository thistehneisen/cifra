package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.Na;
import com.google.android.gms.internal.measurement.Pa;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Na<MessageType extends Na<MessageType, BuilderType>, BuilderType extends Pa<MessageType, BuilderType>> implements C0400mc {
    private static boolean zzacu = false;
    protected int zzact = 0;

    /* access modifiers changed from: 0000 */
    public void a(int i2) {
        throw new UnsupportedOperationException();
    }

    public final Xa d() {
        try {
            C0351eb g2 = Xa.g(c());
            a(g2.b());
            return g2.a();
        } catch (IOException e2) {
            String str = "ByteString";
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + str.length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append(str);
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    public final byte[] g() {
        try {
            byte[] bArr = new byte[c()];
            zzee a2 = zzee.a(bArr);
            a(a2);
            a2.c();
            return bArr;
        } catch (IOException e2) {
            String str = "byte array";
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + str.length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append(str);
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    /* access modifiers changed from: 0000 */
    public int h() {
        throw new UnsupportedOperationException();
    }

    protected static <T> void a(Iterable<T> iterable, List<? super T> list) {
        Fb.a(iterable);
        String str = " is null.";
        String str2 = "Element at index ";
        if (iterable instanceof Ub) {
            List d2 = ((Ub) iterable).d();
            Ub ub = (Ub) list;
            int size = list.size();
            for (Object next : d2) {
                if (next == null) {
                    int size2 = ub.size() - size;
                    StringBuilder sb = new StringBuilder(37);
                    sb.append(str2);
                    sb.append(size2);
                    sb.append(str);
                    String sb2 = sb.toString();
                    for (int size3 = ub.size() - 1; size3 >= size; size3--) {
                        ub.remove(size3);
                    }
                    throw new NullPointerException(sb2);
                } else if (next instanceof Xa) {
                    ub.a((Xa) next);
                } else {
                    ub.add((String) next);
                }
            }
        } else if (iterable instanceof C0465xc) {
            list.addAll((Collection) iterable);
        } else {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size4 = list.size();
            for (Object next2 : iterable) {
                if (next2 == null) {
                    int size5 = list.size() - size4;
                    StringBuilder sb3 = new StringBuilder(37);
                    sb3.append(str2);
                    sb3.append(size5);
                    sb3.append(str);
                    String sb4 = sb3.toString();
                    for (int size6 = list.size() - 1; size6 >= size4; size6--) {
                        list.remove(size6);
                    }
                    throw new NullPointerException(sb4);
                }
                list.add(next2);
            }
        }
    }
}
