package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class SafeParcelReader {

    public static class ParseException extends RuntimeException {
        public ParseException(String str, Parcel parcel) {
            int dataPosition = parcel.dataPosition();
            int dataSize = parcel.dataSize();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 41);
            sb.append(str);
            sb.append(" Parcel: pos=");
            sb.append(dataPosition);
            sb.append(" size=");
            sb.append(dataSize);
            super(sb.toString());
        }
    }

    public static int a(int i2) {
        return i2 & 65535;
    }

    public static int a(Parcel parcel) {
        return parcel.readInt();
    }

    public static int b(Parcel parcel) {
        int a2 = a(parcel);
        int m = m(parcel, a2);
        int dataPosition = parcel.dataPosition();
        if (a(a2) != 20293) {
            String str = "Expected object header. Got 0x";
            String valueOf = String.valueOf(Integer.toHexString(a2));
            throw new ParseException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), parcel);
        }
        int i2 = m + dataPosition;
        if (i2 >= dataPosition && i2 <= parcel.dataSize()) {
            return i2;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("Size read is invalid start=");
        sb.append(dataPosition);
        sb.append(" end=");
        sb.append(i2);
        throw new ParseException(sb.toString(), parcel);
    }

    public static ArrayList<String> c(Parcel parcel, int i2) {
        int m = m(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (m == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + m);
        return createStringArrayList;
    }

    public static void d(Parcel parcel, int i2) {
        if (parcel.dataPosition() != i2) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Overread allowed size end=");
            sb.append(i2);
            throw new ParseException(sb.toString(), parcel);
        }
    }

    public static boolean e(Parcel parcel, int i2) {
        a(parcel, i2, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean f(Parcel parcel, int i2) {
        int m = m(parcel, i2);
        if (m == 0) {
            return null;
        }
        a(parcel, i2, m, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static Double g(Parcel parcel, int i2) {
        int m = m(parcel, i2);
        if (m == 0) {
            return null;
        }
        a(parcel, i2, m, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static Float h(Parcel parcel, int i2) {
        int m = m(parcel, i2);
        if (m == 0) {
            return null;
        }
        a(parcel, i2, m, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static IBinder i(Parcel parcel, int i2) {
        int m = m(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (m == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + m);
        return readStrongBinder;
    }

    public static int j(Parcel parcel, int i2) {
        a(parcel, i2, 4);
        return parcel.readInt();
    }

    public static long k(Parcel parcel, int i2) {
        a(parcel, i2, 8);
        return parcel.readLong();
    }

    public static Long l(Parcel parcel, int i2) {
        int m = m(parcel, i2);
        if (m == 0) {
            return null;
        }
        a(parcel, i2, m, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static int m(Parcel parcel, int i2) {
        return (i2 & -65536) != -65536 ? (i2 >> 16) & 65535 : parcel.readInt();
    }

    public static void n(Parcel parcel, int i2) {
        parcel.setDataPosition(parcel.dataPosition() + m(parcel, i2));
    }

    private static void a(Parcel parcel, int i2, int i3) {
        int m = m(parcel, i2);
        if (m != i3) {
            String hexString = Integer.toHexString(m);
            StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
            sb.append("Expected size ");
            sb.append(i3);
            sb.append(" got ");
            sb.append(m);
            sb.append(" (0x");
            sb.append(hexString);
            sb.append(")");
            throw new ParseException(sb.toString(), parcel);
        }
    }

    private static void a(Parcel parcel, int i2, int i3, int i4) {
        if (i3 != i4) {
            String hexString = Integer.toHexString(i3);
            StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
            sb.append("Expected size ");
            sb.append(i4);
            sb.append(" got ");
            sb.append(i3);
            sb.append(" (0x");
            sb.append(hexString);
            sb.append(")");
            throw new ParseException(sb.toString(), parcel);
        }
    }

    public static <T> ArrayList<T> c(Parcel parcel, int i2, Creator<T> creator) {
        int m = m(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (m == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + m);
        return createTypedArrayList;
    }

    public static <T extends Parcelable> T a(Parcel parcel, int i2, Creator<T> creator) {
        int m = m(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (m == 0) {
            return null;
        }
        T t = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + m);
        return t;
    }

    public static String b(Parcel parcel, int i2) {
        int m = m(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (m == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + m);
        return readString;
    }

    public static Bundle a(Parcel parcel, int i2) {
        int m = m(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (m == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + m);
        return readBundle;
    }

    public static <T> T[] b(Parcel parcel, int i2, Creator<T> creator) {
        int m = m(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (m == 0) {
            return null;
        }
        T[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + m);
        return createTypedArray;
    }
}
