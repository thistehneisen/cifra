package ru.touchin.roboswag.components.navigation.viewcontrollers;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.e.b.h;

/* compiled from: EmptyState.kt */
public final class b implements Parcelable {
    public static final Creator<b> CREATOR = new a();

    /* renamed from: a reason: collision with root package name */
    public static final b f11113a = new b();

    private b() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        h.b(parcel, "parcel");
    }
}
