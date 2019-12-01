package io.intercom.android.sdk.metrics.ops;

public class OpsMetricObject {
    private final String id;
    private final String name;
    private final String type;
    private final long value;

    public OpsMetricObject(String str, String str2, long j2, String str3) {
        this.type = str;
        this.name = str2;
        this.value = j2;
        this.id = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || OpsMetricObject.class != obj.getClass()) {
            return false;
        }
        OpsMetricObject opsMetricObject = (OpsMetricObject) obj;
        if (this.value == opsMetricObject.value && this.type.equals(opsMetricObject.type) && this.name.equals(opsMetricObject.name)) {
            return this.id.equals(opsMetricObject.id);
        }
        return false;
    }

    public String getId() {
        return this.id;
    }

    public int hashCode() {
        int hashCode = ((this.type.hashCode() * 31) + this.name.hashCode()) * 31;
        long j2 = this.value;
        return ((hashCode + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.id.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OpsMetricObject{type='");
        sb.append(this.type);
        sb.append('\'');
        sb.append(", name='");
        sb.append(this.name);
        sb.append('\'');
        sb.append(", value=");
        sb.append(this.value);
        sb.append(", id='");
        sb.append(this.id);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
