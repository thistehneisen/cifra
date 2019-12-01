package com.appsflyer;

final class q implements c {

    /* renamed from: ˏ reason: contains not printable characters */
    private c f203 = this;

    enum a {
        UNITY("android_unity", "com.unity3d.player.UnityPlayer"),
        REACT_NATIVE("android_reactNative", "com.facebook.react.ReactApplication"),
        CORDOVA("android_cordova", "org.apache.cordova.CordovaActivity"),
        SEGMENT("android_segment", "com.segment.analytics.integrations.Integration"),
        COCOS2DX("android_cocos2dx", "org.cocos2dx.lib.Cocos2dxActivity"),
        DEFAULT(r6, r6),
        ADOBE_EX("android_adobe_ex", "com.appsflyer.adobeextension"),
        FLUTTER("android_flutter", "io.flutter.plugin.common.MethodChannel.MethodCallHandler");
        
        /* access modifiers changed from: private */

        /* renamed from: ʽ reason: contains not printable characters */
        public String f213;
        /* access modifiers changed from: private */

        /* renamed from: ॱॱ reason: contains not printable characters */
        public String f214;

        private a(String str, String str2) {
            this.f214 = str;
            this.f213 = str2;
        }
    }

    interface c {
        /* renamed from: ˏ reason: contains not printable characters */
        Class<?> m184(String str) throws ClassNotFoundException;
    }

    q() {
    }

    /* renamed from: ॱ reason: contains not printable characters */
    private boolean m179(String str) {
        try {
            this.f203.m184(str);
            StringBuilder sb = new StringBuilder("Class: ");
            sb.append(str);
            sb.append(" is found.");
            AFLogger.afRDLog(sb.toString());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˎ reason: contains not printable characters */
    public final String m180() {
        a[] values;
        for (a aVar : a.values()) {
            if (m179(aVar.f213)) {
                return aVar.f214;
            }
        }
        return a.DEFAULT.f214;
    }

    /* renamed from: ˏ reason: contains not printable characters */
    public final Class<?> m181(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }
}
