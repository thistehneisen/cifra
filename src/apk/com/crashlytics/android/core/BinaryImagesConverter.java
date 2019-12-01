package com.crashlytics.android.core;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import io.fabric.sdk.android.f;
import io.fabric.sdk.android.o;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class BinaryImagesConverter {
    private static final String DATA_DIR = "/data";
    private final Context context;
    private final FileIdStrategy fileIdStrategy;

    interface FileIdStrategy {
        String createId(File file) throws IOException;
    }

    BinaryImagesConverter(Context context2, FileIdStrategy fileIdStrategy2) {
        this.context = context2;
        this.fileIdStrategy = fileIdStrategy2;
    }

    private File correctDataPath(File file) {
        if (VERSION.SDK_INT < 9) {
            return file;
        }
        if (file.getAbsolutePath().startsWith(DATA_DIR)) {
            try {
                file = new File(this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 0).nativeLibraryDir, file.getName());
            } catch (NameNotFoundException e2) {
                f.e().b(CrashlyticsCore.TAG, "Error getting ApplicationInfo", e2);
            }
        }
        return file;
    }

    private static JSONObject createBinaryImageJson(String str, ProcMapEntry procMapEntry) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("base_address", procMapEntry.address);
        jSONObject.put("size", procMapEntry.size);
        jSONObject.put("name", procMapEntry.path);
        jSONObject.put("uuid", str);
        return jSONObject;
    }

    private static byte[] generateBinaryImagesJsonString(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("binary_images", jSONArray);
            return jSONObject.toString().getBytes();
        } catch (JSONException e2) {
            f.e().a(CrashlyticsCore.TAG, "Binary images string is null", (Throwable) e2);
            return new byte[0];
        }
    }

    private File getLibraryFile(String str) {
        File file = new File(str);
        return !file.exists() ? correctDataPath(file) : file;
    }

    private static boolean isRelevant(ProcMapEntry procMapEntry) {
        return (procMapEntry.perms.indexOf(120) == -1 || procMapEntry.path.indexOf(47) == -1) ? false : true;
    }

    private static String joinMapsEntries(JSONArray jSONArray) throws JSONException {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            sb.append(jSONArray.getString(i2));
        }
        return sb.toString();
    }

    private JSONObject jsonFromMapEntryString(String str) {
        String str2 = CrashlyticsCore.TAG;
        ProcMapEntry parse = ProcMapEntryParser.parse(str);
        if (parse != null && isRelevant(parse)) {
            try {
                try {
                    return createBinaryImageJson(this.fileIdStrategy.createId(getLibraryFile(parse.path)), parse);
                } catch (JSONException e2) {
                    f.e().c(str2, "Could not create a binary image json string", e2);
                    return null;
                }
            } catch (IOException e3) {
                o e4 = f.e();
                StringBuilder sb = new StringBuilder();
                sb.append("Could not generate ID for file ");
                sb.append(parse.path);
                e4.c(str2, sb.toString(), e3);
            }
        }
        return null;
    }

    private JSONArray parseProcMapsJsonFromStream(BufferedReader bufferedReader) throws IOException {
        JSONArray jSONArray = new JSONArray();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return jSONArray;
            }
            JSONObject jsonFromMapEntryString = jsonFromMapEntryString(readLine);
            if (jsonFromMapEntryString != null) {
                jSONArray.put(jsonFromMapEntryString);
            }
        }
    }

    private JSONArray parseProcMapsJsonFromString(String str) {
        JSONArray jSONArray = new JSONArray();
        try {
            String[] split = joinMapsEntries(new JSONObject(str).getJSONArray("maps")).split("\\|");
            for (String jsonFromMapEntryString : split) {
                JSONObject jsonFromMapEntryString2 = jsonFromMapEntryString(jsonFromMapEntryString);
                if (jsonFromMapEntryString2 != null) {
                    jSONArray.put(jsonFromMapEntryString2);
                }
            }
            return jSONArray;
        } catch (JSONException e2) {
            f.e().a(CrashlyticsCore.TAG, "Unable to parse proc maps string", (Throwable) e2);
            return jSONArray;
        }
    }

    /* access modifiers changed from: 0000 */
    public byte[] convert(String str) throws IOException {
        return generateBinaryImagesJsonString(parseProcMapsJsonFromString(str));
    }

    /* access modifiers changed from: 0000 */
    public byte[] convert(BufferedReader bufferedReader) throws IOException {
        return generateBinaryImagesJsonString(parseProcMapsJsonFromStream(bufferedReader));
    }
}
