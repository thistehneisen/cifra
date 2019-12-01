package io.intercom.com.google.gson.b;

import io.intercom.com.google.gson.JsonParseException;
import io.intercom.com.google.gson.b.a.ja;
import io.intercom.com.google.gson.stream.MalformedJsonException;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.d;
import io.intercom.com.google.gson.t;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

/* compiled from: Streams */
public final class B {

    /* compiled from: Streams */
    private static final class a extends Writer {

        /* renamed from: a reason: collision with root package name */
        private final Appendable f10018a;

        /* renamed from: b reason: collision with root package name */
        private final C0114a f10019b = new C0114a();

        /* renamed from: io.intercom.com.google.gson.b.B$a$a reason: collision with other inner class name */
        /* compiled from: Streams */
        static class C0114a implements CharSequence {

            /* renamed from: a reason: collision with root package name */
            char[] f10020a;

            C0114a() {
            }

            public char charAt(int i2) {
                return this.f10020a[i2];
            }

            public int length() {
                return this.f10020a.length;
            }

            public CharSequence subSequence(int i2, int i3) {
                return new String(this.f10020a, i2, i3 - i2);
            }
        }

        a(Appendable appendable) {
            this.f10018a = appendable;
        }

        public void close() {
        }

        public void flush() {
        }

        public void write(char[] cArr, int i2, int i3) throws IOException {
            C0114a aVar = this.f10019b;
            aVar.f10020a = cArr;
            this.f10018a.append(aVar, i2, i3 + i2);
        }

        public void write(int i2) throws IOException {
            this.f10018a.append((char) i2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        throw new io.intercom.com.google.gson.JsonIOException((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        throw new io.intercom.com.google.gson.JsonSyntaxException((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002a, code lost:
        return io.intercom.com.google.gson.u.f10224a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0030, code lost:
        throw new io.intercom.com.google.gson.JsonSyntaxException((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        throw new io.intercom.com.google.gson.JsonSyntaxException((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0016 A[ExcHandler: IOException (r2v5 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001d A[ExcHandler: MalformedJsonException (r2v4 'e' io.intercom.com.google.gson.stream.MalformedJsonException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x000f A[ExcHandler: NumberFormatException (r2v6 'e' java.lang.NumberFormatException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    public static t a(b bVar) throws JsonParseException {
        boolean z;
        try {
            bVar.G();
            z = false;
            return (t) ja.X.a(bVar);
        } catch (EOFException e2) {
            e = e2;
            z = true;
            if (!z) {
            }
        } catch (MalformedJsonException e3) {
        } catch (IOException e4) {
        } catch (NumberFormatException e5) {
        }
    }

    public static void a(t tVar, d dVar) throws IOException {
        ja.X.a(dVar, tVar);
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }
}
