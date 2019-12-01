package com.appsflyer.cache;

import java.util.Scanner;

public class RequestCacheData {

    /* renamed from: ˋ reason: contains not printable characters */
    private String f127;

    /* renamed from: ˎ reason: contains not printable characters */
    private String f128;

    /* renamed from: ˏ reason: contains not printable characters */
    private String f129;

    /* renamed from: ॱ reason: contains not printable characters */
    private String f130;

    public RequestCacheData(String str, String str2, String str3) {
        this.f130 = str;
        this.f127 = str2;
        this.f128 = str3;
    }

    public String getCacheKey() {
        return this.f129;
    }

    public String getPostData() {
        return this.f127;
    }

    public String getRequestURL() {
        return this.f130;
    }

    public String getVersion() {
        return this.f128;
    }

    public void setCacheKey(String str) {
        this.f129 = str;
    }

    public void setPostData(String str) {
        this.f127 = str;
    }

    public void setRequestURL(String str) {
        this.f130 = str;
    }

    public void setVersion(String str) {
        this.f128 = str;
    }

    public RequestCacheData(char[] cArr) {
        Scanner scanner = new Scanner(new String(cArr));
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            if (nextLine.startsWith("url=")) {
                this.f130 = nextLine.substring(4).trim();
            } else if (nextLine.startsWith("version=")) {
                this.f128 = nextLine.substring(8).trim();
            } else if (nextLine.startsWith("data=")) {
                this.f127 = nextLine.substring(5).trim();
            }
        }
        scanner.close();
    }
}
