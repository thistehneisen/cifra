package com.crashlytics.android.core;

import io.fabric.sdk.android.a.b.l;
import io.fabric.sdk.android.f;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class MetaDataStore {
    private static final String KEYDATA_SUFFIX = "keys";
    private static final String KEY_USER_EMAIL = "userEmail";
    private static final String KEY_USER_ID = "userId";
    private static final String KEY_USER_NAME = "userName";
    private static final String METADATA_EXT = ".meta";
    private static final String USERDATA_SUFFIX = "user";
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final File filesDir;

    public MetaDataStore(File file) {
        this.filesDir = file;
    }

    private static Map<String, String> jsonToKeysData(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        HashMap hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            hashMap.put(str2, valueOrNull(jSONObject, str2));
        }
        return hashMap;
    }

    private static UserMetaData jsonToUserData(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        return new UserMetaData(valueOrNull(jSONObject, KEY_USER_ID), valueOrNull(jSONObject, KEY_USER_NAME), valueOrNull(jSONObject, "userEmail"));
    }

    private static String keysDataToJson(Map<String, String> map) throws JSONException {
        return new JSONObject(map).toString();
    }

    private static String userDataToJson(final UserMetaData userMetaData) throws JSONException {
        return new JSONObject() {
            {
                put(MetaDataStore.KEY_USER_ID, userMetaData.id);
                put(MetaDataStore.KEY_USER_NAME, userMetaData.name);
                put("userEmail", userMetaData.email);
            }
        }.toString();
    }

    private static String valueOrNull(JSONObject jSONObject, String str) {
        if (!jSONObject.isNull(str)) {
            return jSONObject.optString(str, null);
        }
        return null;
    }

    public File getKeysFileForSession(String str) {
        File file = this.filesDir;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(KEYDATA_SUFFIX);
        sb.append(METADATA_EXT);
        return new File(file, sb.toString());
    }

    public File getUserDataFileForSession(String str) {
        File file = this.filesDir;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(USERDATA_SUFFIX);
        sb.append(METADATA_EXT);
        return new File(file, sb.toString());
    }

    public Map<String, String> readKeyData(String str) {
        String str2 = "Failed to close user metadata file.";
        File keysFileForSession = getKeysFileForSession(str);
        if (!keysFileForSession.exists()) {
            return Collections.emptyMap();
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(keysFileForSession);
            try {
                Map<String, String> jsonToKeysData = jsonToKeysData(l.b((InputStream) fileInputStream2));
                l.a((Closeable) fileInputStream2, str2);
                return jsonToKeysData;
            } catch (Exception e2) {
                e = e2;
                fileInputStream = fileInputStream2;
                try {
                    f.e().b(CrashlyticsCore.TAG, "Error deserializing user metadata.", e);
                    l.a((Closeable) fileInputStream, str2);
                    return Collections.emptyMap();
                } catch (Throwable th) {
                    th = th;
                    l.a((Closeable) fileInputStream, str2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                l.a((Closeable) fileInputStream, str2);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            f.e().b(CrashlyticsCore.TAG, "Error deserializing user metadata.", e);
            l.a((Closeable) fileInputStream, str2);
            return Collections.emptyMap();
        }
    }

    public UserMetaData readUserData(String str) {
        String str2 = "Failed to close user metadata file.";
        File userDataFileForSession = getUserDataFileForSession(str);
        if (!userDataFileForSession.exists()) {
            return UserMetaData.EMPTY;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(userDataFileForSession);
            try {
                UserMetaData jsonToUserData = jsonToUserData(l.b((InputStream) fileInputStream2));
                l.a((Closeable) fileInputStream2, str2);
                return jsonToUserData;
            } catch (Exception e2) {
                e = e2;
                fileInputStream = fileInputStream2;
                try {
                    f.e().b(CrashlyticsCore.TAG, "Error deserializing user metadata.", e);
                    l.a((Closeable) fileInputStream, str2);
                    return UserMetaData.EMPTY;
                } catch (Throwable th) {
                    th = th;
                    l.a((Closeable) fileInputStream, str2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                l.a((Closeable) fileInputStream, str2);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            f.e().b(CrashlyticsCore.TAG, "Error deserializing user metadata.", e);
            l.a((Closeable) fileInputStream, str2);
            return UserMetaData.EMPTY;
        }
    }

    public void writeKeyData(String str, Map<String, String> map) {
        String str2 = "Failed to close key/value metadata file.";
        File keysFileForSession = getKeysFileForSession(str);
        BufferedWriter bufferedWriter = null;
        try {
            String keysDataToJson = keysDataToJson(map);
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(keysFileForSession), UTF_8));
            try {
                bufferedWriter2.write(keysDataToJson);
                bufferedWriter2.flush();
                l.a((Closeable) bufferedWriter2, str2);
            } catch (Exception e2) {
                e = e2;
                bufferedWriter = bufferedWriter2;
                try {
                    f.e().b(CrashlyticsCore.TAG, "Error serializing key/value metadata.", e);
                    l.a((Closeable) bufferedWriter, str2);
                } catch (Throwable th) {
                    th = th;
                    l.a((Closeable) bufferedWriter, str2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = bufferedWriter2;
                l.a((Closeable) bufferedWriter, str2);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            f.e().b(CrashlyticsCore.TAG, "Error serializing key/value metadata.", e);
            l.a((Closeable) bufferedWriter, str2);
        }
    }

    public void writeUserData(String str, UserMetaData userMetaData) {
        String str2 = "Failed to close user metadata file.";
        File userDataFileForSession = getUserDataFileForSession(str);
        BufferedWriter bufferedWriter = null;
        try {
            String userDataToJson = userDataToJson(userMetaData);
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(userDataFileForSession), UTF_8));
            try {
                bufferedWriter2.write(userDataToJson);
                bufferedWriter2.flush();
                l.a((Closeable) bufferedWriter2, str2);
            } catch (Exception e2) {
                e = e2;
                bufferedWriter = bufferedWriter2;
                try {
                    f.e().b(CrashlyticsCore.TAG, "Error serializing user metadata.", e);
                    l.a((Closeable) bufferedWriter, str2);
                } catch (Throwable th) {
                    th = th;
                    l.a((Closeable) bufferedWriter, str2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = bufferedWriter2;
                l.a((Closeable) bufferedWriter, str2);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            f.e().b(CrashlyticsCore.TAG, "Error serializing user metadata.", e);
            l.a((Closeable) bufferedWriter, str2);
        }
    }
}
