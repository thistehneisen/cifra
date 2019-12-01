package com.franmontiel.persistentcookiejar.persistence;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import i.C0728q;
import java.util.Collection;

@SuppressLint({"CommitPrefEdits"})
public class SharedPrefsCookiePersistor implements CookiePersistor {

    /* renamed from: a reason: collision with root package name */
    private final SharedPreferences f4413a;

    public void a(Collection<C0728q> collection) {
        Editor edit = this.f4413a.edit();
        for (C0728q qVar : collection) {
            edit.putString(a(qVar), new SerializableCookie().a(qVar));
        }
        edit.commit();
    }

    public void removeAll(Collection<C0728q> collection) {
        Editor edit = this.f4413a.edit();
        for (C0728q a2 : collection) {
            edit.remove(a(a2));
        }
        edit.commit();
    }

    private static String a(C0728q qVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(qVar.h() ? "https" : "http");
        sb.append("://");
        sb.append(qVar.a());
        sb.append(qVar.f());
        sb.append("|");
        sb.append(qVar.e());
        return sb.toString();
    }
}
