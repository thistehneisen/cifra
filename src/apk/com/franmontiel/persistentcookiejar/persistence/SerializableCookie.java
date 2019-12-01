package com.franmontiel.persistentcookiejar.persistence;

import android.util.Log;
import i.C0728q;
import i.C0728q.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableCookie implements Serializable {

    /* renamed from: a reason: collision with root package name */
    private static final String f4410a = "SerializableCookie";

    /* renamed from: b reason: collision with root package name */
    private static long f4411b = -1;
    private static final long serialVersionUID = -8594045714036645534L;

    /* renamed from: c reason: collision with root package name */
    private transient C0728q f4412c;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        a aVar = new a();
        aVar.c((String) objectInputStream.readObject());
        aVar.e((String) objectInputStream.readObject());
        long readLong = objectInputStream.readLong();
        if (readLong != f4411b) {
            aVar.a(readLong);
        }
        String str = (String) objectInputStream.readObject();
        aVar.a(str);
        aVar.d((String) objectInputStream.readObject());
        if (objectInputStream.readBoolean()) {
            aVar.c();
        }
        if (objectInputStream.readBoolean()) {
            aVar.b();
        }
        if (objectInputStream.readBoolean()) {
            aVar.b(str);
        }
        this.f4412c = aVar.a();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.f4412c.e());
        objectOutputStream.writeObject(this.f4412c.i());
        objectOutputStream.writeLong(this.f4412c.g() ? this.f4412c.b() : f4411b);
        objectOutputStream.writeObject(this.f4412c.a());
        objectOutputStream.writeObject(this.f4412c.f());
        objectOutputStream.writeBoolean(this.f4412c.h());
        objectOutputStream.writeBoolean(this.f4412c.d());
        objectOutputStream.writeBoolean(this.f4412c.c());
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0035 A[SYNTHETIC, Splitter:B:19:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0043 A[SYNTHETIC, Splitter:B:26:0x0043] */
    public String a(C0728q qVar) {
        ObjectOutputStream objectOutputStream;
        String str = "Stream not closed in encodeCookie";
        this.f4412c = qVar;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(this);
                try {
                    objectOutputStream.close();
                } catch (IOException e2) {
                    Log.d(f4410a, str, e2);
                }
                return a(byteArrayOutputStream.toByteArray());
            } catch (IOException e3) {
                e = e3;
                try {
                    Log.d(f4410a, "IOException in encodeCookie", e);
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e4) {
                            Log.d(f4410a, str, e4);
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e5) {
                            Log.d(f4410a, str, e5);
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e6) {
            e = e6;
            objectOutputStream = null;
            Log.d(f4410a, "IOException in encodeCookie", e);
            if (objectOutputStream != null) {
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream = null;
            if (objectOutputStream != null) {
            }
            throw th;
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            byte b3 = b2 & 255;
            if (b3 < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(b3));
        }
        return sb.toString();
    }
}
