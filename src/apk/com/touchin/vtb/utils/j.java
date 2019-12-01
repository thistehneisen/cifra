package com.touchin.vtb.utils;

import android.content.Context;
import android.content.res.Resources;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import kotlin.e.b.h;
import ru.touchin.roboswag.core.utils.ShouldNotHappenException;

/* compiled from: FileUtils.kt */
public final class j {

    /* renamed from: a reason: collision with root package name */
    public static final j f7620a = new j();

    private j() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0078 A[Catch:{ all -> 0x006d }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0079 A[Catch:{ all -> 0x006d }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0081 A[SYNTHETIC, Splitter:B:33:0x0081] */
    public final String a(Context context, String str) {
        String message;
        String readLine;
        String str2 = "Something wrong with closing file reader";
        h.b(context, "context");
        h.b(str, "filename");
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            Resources resources = context.getResources();
            h.a((Object) resources, "context.resources");
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(resources.getAssets().open(str)));
            do {
                try {
                    readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(readLine);
                        sb2.append("\n");
                        sb.append(sb2.toString());
                        continue;
                    } else {
                        readLine = null;
                        continue;
                    }
                } catch (IOException e2) {
                    e = e2;
                    bufferedReader = bufferedReader2;
                    try {
                        message = e.getMessage();
                        if (message != null) {
                        }
                        throw new ShouldNotHappenException(message);
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                String message2 = e3.getMessage();
                                if (message2 == null) {
                                    message2 = str2;
                                }
                                throw new ShouldNotHappenException(message2);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            } while (readLine != null);
            try {
                bufferedReader2.close();
                String sb3 = sb.toString();
                h.a((Object) sb3, "builder.toString()");
                return sb3;
            } catch (IOException e4) {
                String message3 = e4.getMessage();
                if (message3 == null) {
                    message3 = str2;
                }
                throw new ShouldNotHappenException(message3);
            }
        } catch (IOException e5) {
            e = e5;
            message = e.getMessage();
            if (message != null) {
                message = "Something wrong with reading file";
            }
            throw new ShouldNotHappenException(message);
        }
    }
}
