package com.appsflyer;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class i {

    /* renamed from: ʽ reason: contains not printable characters */
    private static final BitSet f152 = new BitSet(6);

    /* renamed from: ॱॱ reason: contains not printable characters */
    private static volatile i f153;

    /* renamed from: ᐝ reason: contains not printable characters */
    private static final Handler f154 = new Handler(Looper.getMainLooper());

    /* renamed from: ʻ reason: contains not printable characters */
    final Runnable f155 = new Runnable() {
        public final void run() {
            synchronized (i.this.f159) {
                if (i.this.f161) {
                    i.this.f157.removeCallbacks(i.this.f160);
                    i.this.f157.removeCallbacks(i.this.f163);
                    i.this.m149();
                    i.this.f161 = false;
                }
            }
        }
    };

    /* renamed from: ʼ reason: contains not printable characters */
    private final Map<g, g> f156 = new HashMap(f152.size());

    /* renamed from: ˊ reason: contains not printable characters */
    final Handler f157;

    /* renamed from: ˊॱ reason: contains not printable characters */
    private final Map<g, Map<String, Object>> f158 = new HashMap(f152.size());

    /* renamed from: ˋ reason: contains not printable characters */
    final Object f159 = new Object();

    /* renamed from: ˎ reason: contains not printable characters */
    final Runnable f160 = new Runnable() {
        public final void run() {
            synchronized (i.this.f159) {
                i.this.m150();
                i.this.f157.postDelayed(i.this.f163, 500);
                i.this.f161 = true;
            }
        }
    };

    /* renamed from: ˏ reason: contains not printable characters */
    boolean f161;

    /* renamed from: ͺ reason: contains not printable characters */
    private boolean f162;

    /* renamed from: ॱ reason: contains not printable characters */
    final Runnable f163 = new Runnable() {
        public final void run() {
            synchronized (i.this.f159) {
                i.this.m149();
                i.this.f157.postDelayed(i.this.f160, 1800000);
            }
        }
    };

    /* renamed from: ॱˊ reason: contains not printable characters */
    private final SensorManager f164;

    static {
        f152.set(1);
        f152.set(2);
        f152.set(4);
    }

    private i(SensorManager sensorManager, Handler handler) {
        this.f164 = sensorManager;
        this.f157 = handler;
    }

    /* renamed from: ˋ reason: contains not printable characters */
    private static i m146(SensorManager sensorManager, Handler handler) {
        if (f153 == null) {
            synchronized (i.class) {
                if (f153 == null) {
                    f153 = new i(sensorManager, handler);
                }
            }
        }
        return f153;
    }

    /* renamed from: ˏ reason: contains not printable characters */
    static i m147(Context context) {
        return m146((SensorManager) context.getApplicationContext().getSystemService("sensor"), f154);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ॱ reason: contains not printable characters */
    public final void m150() {
        try {
            for (Sensor sensor : this.f164.getSensorList(-1)) {
                int type = sensor.getType();
                if (type >= 0 && f152.get(type)) {
                    g r3 = g.m131(sensor);
                    if (!this.f156.containsKey(r3)) {
                        this.f156.put(r3, r3);
                    }
                    this.f164.registerListener((SensorEventListener) this.f156.get(r3), sensor, 0);
                }
            }
        } catch (Throwable unused) {
        }
        this.f162 = true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˏ reason: contains not printable characters */
    public final void m149() {
        try {
            if (!this.f156.isEmpty()) {
                for (g gVar : this.f156.values()) {
                    this.f164.unregisterListener(gVar);
                    gVar.m138(this.f158);
                }
            }
        } catch (Throwable unused) {
        }
        this.f162 = false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˋ reason: contains not printable characters */
    public final List<Map<String, Object>> m148() {
        synchronized (this.f159) {
            if (!this.f156.isEmpty() && this.f162) {
                for (g r2 : this.f156.values()) {
                    r2.m139(this.f158);
                }
            }
            if (this.f158.isEmpty()) {
                List<Map<String, Object>> emptyList = Collections.emptyList();
                return emptyList;
            }
            ArrayList arrayList = new ArrayList(this.f158.values());
            return arrayList;
        }
    }
}
