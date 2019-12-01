package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class b {
    public static int a(Parcel parcel) {
        return b(parcel, 20293);
    }

    private static void b(Parcel parcel, int i2, int i3) {
        if (i3 >= 65535) {
            parcel.writeInt(i2 | -65536);
            parcel.writeInt(i3);
            return;
        }
        parcel.writeInt(i2 | (i3 << 16));
    }

    private static void c(Parcel parcel, int i2) {
        int dataPosition = parcel.dataPosition();
        int i3 = dataPosition - i2;
        parcel.setDataPosition(i2 - 4);
        parcel.writeInt(i3);
        parcel.setDataPosition(dataPosition);
    }

    public static void a(Parcel parcel, int i2) {
        c(parcel, i2);
    }

    public static void a(Parcel parcel, int i2, boolean z) {
        b(parcel, i2, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    private static int b(Parcel parcel, int i2) {
        parcel.writeInt(i2 | -65536);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void a(Parcel parcel, int i2, Boolean bool, boolean z) {
        if (bool == null) {
            if (z) {
                b(parcel, i2, 0);
            }
            return;
        }
        b(parcel, i2, 4);
        parcel.writeInt(bool.booleanValue() ? 1 : 0);
    }

    public static <T extends Parcelable> void b(Parcel parcel, int i2, List<T> list, boolean z) {
        if (list == null) {
            if (z) {
                b(parcel, i2, 0);
            }
            return;
        }
        int b2 = b(parcel, i2);
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            Parcelable parcelable = (Parcelable) list.get(i3);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                a(parcel, (T) parcelable, 0);
            }
        }
        c(parcel, b2);
    }

    public static void a(Parcel parcel, int i2, int i3) {
        b(parcel, i2, 4);
        parcel.writeInt(i3);
    }

    public static void a(Parcel parcel, int i2, long j2) {
        b(parcel, i2, 8);
        parcel.writeLong(j2);
    }

    public static void a(Parcel parcel, int i2, Long l2, boolean z) {
        if (l2 == null) {
            if (z) {
                b(parcel, i2, 0);
            }
            return;
        }
        b(parcel, i2, 8);
        parcel.writeLong(l2.longValue());
    }

    public static void a(Parcel parcel, int i2, Float f2, boolean z) {
        if (f2 == null) {
            if (z) {
                b(parcel, i2, 0);
            }
            return;
        }
        b(parcel, i2, 4);
        parcel.writeFloat(f2.floatValue());
    }

    public static void a(Parcel parcel, int i2, Double d2, boolean z) {
        if (d2 == null) {
            if (z) {
                b(parcel, i2, 0);
            }
            return;
        }
        b(parcel, i2, 8);
        parcel.writeDouble(d2.doubleValue());
    }

    public static void a(Parcel parcel, int i2, String str, boolean z) {
        if (str == null) {
            if (z) {
                b(parcel, i2, 0);
            }
            return;
        }
        int b2 = b(parcel, i2);
        parcel.writeString(str);
        c(parcel, b2);
    }

    public static void a(Parcel parcel, int i2, IBinder iBinder, boolean z) {
        if (iBinder == null) {
            if (z) {
                b(parcel, i2, 0);
            }
            return;
        }
        int b2 = b(parcel, i2);
        parcel.writeStrongBinder(iBinder);
        c(parcel, b2);
    }

    public static void a(Parcel parcel, int i2, Parcelable parcelable, int i3, boolean z) {
        if (parcelable == null) {
            if (z) {
                b(parcel, i2, 0);
            }
            return;
        }
        int b2 = b(parcel, i2);
        parcelable.writeToParcel(parcel, i3);
        c(parcel, b2);
    }

    public static void a(Parcel parcel, int i2, Bundle bundle, boolean z) {
        if (bundle == null) {
            if (z) {
                b(parcel, i2, 0);
            }
            return;
        }
        int b2 = b(parcel, i2);
        parcel.writeBundle(bundle);
        c(parcel, b2);
    }

    public static void a(Parcel parcel, int i2, List<String> list, boolean z) {
        if (list == null) {
            if (z) {
                b(parcel, i2, 0);
            }
            return;
        }
        int b2 = b(parcel, i2);
        parcel.writeStringList(list);
        c(parcel, b2);
    }

    public static <T extends Parcelable> void a(Parcel parcel, int i2, T[] tArr, int i3, boolean z) {
        if (tArr == null) {
            if (z) {
                b(parcel, i2, 0);
            }
            return;
        }
        int b2 = b(parcel, i2);
        parcel.writeInt(r7);
        for (T t : tArr) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                a(parcel, t, i3);
            }
        }
        c(parcel, b2);
    }

    private static <T extends Parcelable> void a(Parcel parcel, T t, int i2) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i2);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }
}
