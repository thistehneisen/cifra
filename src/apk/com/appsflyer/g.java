package com.appsflyer;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class g implements SensorEventListener {

    /* renamed from: ʼ reason: contains not printable characters */
    private final int f138;

    /* renamed from: ʽ reason: contains not printable characters */
    private double f139;

    /* renamed from: ˊ reason: contains not printable characters */
    private final String f140;

    /* renamed from: ˋ reason: contains not printable characters */
    private final float[][] f141 = new float[2][];

    /* renamed from: ˎ reason: contains not printable characters */
    private final long[] f142 = new long[2];

    /* renamed from: ˏ reason: contains not printable characters */
    private final String f143;

    /* renamed from: ॱ reason: contains not printable characters */
    private final int f144;

    /* renamed from: ᐝ reason: contains not printable characters */
    private long f145;

    private g(int i2, String str, String str2) {
        this.f144 = i2;
        String str3 = "";
        if (str == null) {
            str = str3;
        }
        this.f140 = str;
        if (str2 == null) {
            str2 = str3;
        }
        this.f143 = str2;
        this.f138 = ((((i2 + 31) * 31) + this.f140.hashCode()) * 31) + this.f143.hashCode();
    }

    /* renamed from: ˋ reason: contains not printable characters */
    static g m131(Sensor sensor) {
        return new g(sensor.getType(), sensor.getName(), sensor.getVendor());
    }

    /* renamed from: ˎ reason: contains not printable characters */
    private static double m132(float[] fArr, float[] fArr2) {
        double d2 = 0.0d;
        for (int i2 = 0; i2 < Math.min(fArr.length, fArr2.length); i2++) {
            d2 += StrictMath.pow((double) (fArr[i2] - fArr2[i2]), 2.0d);
        }
        return Math.sqrt(d2);
    }

    /* renamed from: ॱ reason: contains not printable characters */
    private Map<String, Object> m136() {
        HashMap hashMap = new HashMap(7);
        hashMap.put("sT", Integer.valueOf(this.f144));
        hashMap.put("sN", this.f140);
        hashMap.put("sV", this.f143);
        float[] fArr = this.f141[0];
        if (fArr != null) {
            hashMap.put("sVS", m133(fArr));
        }
        float[] fArr2 = this.f141[1];
        if (fArr2 != null) {
            hashMap.put("sVE", m133(fArr2));
        }
        return hashMap;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return m134(gVar.f144, gVar.f140, gVar.f143);
    }

    public final int hashCode() {
        return this.f138;
    }

    public final void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (!(sensorEvent == null || sensorEvent.values == null)) {
            Sensor sensor = sensorEvent.sensor;
            if ((sensor == null || sensor.getName() == null || sensor.getVendor() == null) ? false : true) {
                int type = sensorEvent.sensor.getType();
                String name = sensorEvent.sensor.getName();
                String vendor = sensorEvent.sensor.getVendor();
                long j2 = sensorEvent.timestamp;
                float[] fArr = sensorEvent.values;
                if (m134(type, name, vendor)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    float[][] fArr2 = this.f141;
                    float[] fArr3 = fArr2[0];
                    if (fArr3 == null) {
                        fArr2[0] = Arrays.copyOf(fArr, fArr.length);
                        this.f142[0] = currentTimeMillis;
                        return;
                    }
                    float[] fArr4 = fArr2[1];
                    if (fArr4 == null) {
                        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
                        this.f141[1] = copyOf;
                        this.f142[1] = currentTimeMillis;
                        this.f139 = m132(fArr3, copyOf);
                    } else if (50000000 <= j2 - this.f145) {
                        this.f145 = j2;
                        if (Arrays.equals(fArr4, fArr)) {
                            this.f142[1] = currentTimeMillis;
                            return;
                        }
                        double r0 = m132(fArr3, fArr);
                        if (r0 > this.f139) {
                            this.f141[1] = Arrays.copyOf(fArr, fArr.length);
                            this.f142[1] = currentTimeMillis;
                            this.f139 = r0;
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˊ reason: contains not printable characters */
    public final void m138(Map<g, Map<String, Object>> map) {
        m137(map, true);
    }

    /* renamed from: ˏ reason: contains not printable characters */
    public final void m139(Map<g, Map<String, Object>> map) {
        m137(map, false);
    }

    /* renamed from: ˏ reason: contains not printable characters */
    private void m135() {
        for (int i2 = 0; i2 < 2; i2++) {
            this.f141[i2] = null;
        }
        for (int i3 = 0; i3 < 2; i3++) {
            this.f142[i3] = 0;
        }
        this.f139 = 0.0d;
        this.f145 = 0;
    }

    /* renamed from: ˎ reason: contains not printable characters */
    private static List<Float> m133(float[] fArr) {
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float valueOf : fArr) {
            arrayList.add(Float.valueOf(valueOf));
        }
        return arrayList;
    }

    /* renamed from: ˎ reason: contains not printable characters */
    private boolean m134(int i2, String str, String str2) {
        return this.f144 == i2 && this.f140.equals(str) && this.f143.equals(str2);
    }

    /* renamed from: ॱ reason: contains not printable characters */
    private void m137(Map<g, Map<String, Object>> map, boolean z) {
        boolean z2 = false;
        if (this.f141[0] != null) {
            z2 = true;
        }
        if (z2) {
            map.put(this, m136());
            if (z) {
                m135();
            }
        } else if (!map.containsKey(this)) {
            map.put(this, m136());
        }
    }
}
