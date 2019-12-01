package io.intercom.okhttp3;

import e.a.b.g;
import e.a.b.h;
import io.intercom.okhttp3.internal.Util;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public final class FormBody extends RequestBody {
    private static final MediaType CONTENT_TYPE = MediaType.get("application/x-www-form-urlencoded");
    private final List<String> encodedNames;
    private final List<String> encodedValues;

    public static final class Builder {
        private final Charset charset;
        private final List<String> names;
        private final List<String> values;

        public Builder() {
            this(null);
        }

        public Builder add(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str2 != null) {
                String str3 = str;
                this.names.add(HttpUrl.canonicalize(str3, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
                String str4 = str2;
                this.values.add(HttpUrl.canonicalize(str4, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
                return this;
            } else {
                throw new NullPointerException("value == null");
            }
        }

        public Builder addEncoded(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str2 != null) {
                String str3 = str;
                this.names.add(HttpUrl.canonicalize(str3, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
                String str4 = str2;
                this.values.add(HttpUrl.canonicalize(str4, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
                return this;
            } else {
                throw new NullPointerException("value == null");
            }
        }

        public FormBody build() {
            return new FormBody(this.names, this.values);
        }

        public Builder(Charset charset2) {
            this.names = new ArrayList();
            this.values = new ArrayList();
            this.charset = charset2;
        }
    }

    FormBody(List<String> list, List<String> list2) {
        this.encodedNames = Util.immutableList(list);
        this.encodedValues = Util.immutableList(list2);
    }

    private long writeOrCountBytes(h hVar, boolean z) {
        g gVar;
        if (z) {
            gVar = new g();
        } else {
            gVar = hVar.n();
        }
        int size = this.encodedNames.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                gVar.writeByte(38);
            }
            gVar.a((String) this.encodedNames.get(i2));
            gVar.writeByte(61);
            gVar.a((String) this.encodedValues.get(i2));
        }
        if (!z) {
            return 0;
        }
        long size2 = gVar.size();
        gVar.a();
        return size2;
    }

    public long contentLength() {
        return writeOrCountBytes(null, true);
    }

    public MediaType contentType() {
        return CONTENT_TYPE;
    }

    public String encodedName(int i2) {
        return (String) this.encodedNames.get(i2);
    }

    public String encodedValue(int i2) {
        return (String) this.encodedValues.get(i2);
    }

    public String name(int i2) {
        return HttpUrl.percentDecode(encodedName(i2), true);
    }

    public int size() {
        return this.encodedNames.size();
    }

    public String value(int i2) {
        return HttpUrl.percentDecode(encodedValue(i2), true);
    }

    public void writeTo(h hVar) throws IOException {
        writeOrCountBytes(hVar, false);
    }
}
