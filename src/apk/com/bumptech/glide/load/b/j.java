package com.bumptech.glide.load.b;

import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.b.i.d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: FileLoader */
class j implements d<ParcelFileDescriptor> {
    j() {
    }

    public ParcelFileDescriptor a(File file) throws FileNotFoundException {
        return ParcelFileDescriptor.open(file, 268435456);
    }

    public void a(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }

    public Class<ParcelFileDescriptor> a() {
        return ParcelFileDescriptor.class;
    }
}
