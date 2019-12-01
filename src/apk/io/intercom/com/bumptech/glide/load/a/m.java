package io.intercom.com.bumptech.glide.load.a;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamLocalUriFetcher */
public class m extends k<InputStream> {

    /* renamed from: d reason: collision with root package name */
    private static final UriMatcher f9467d = new UriMatcher(-1);

    static {
        String str = "com.android.contacts";
        f9467d.addURI(str, "contacts/lookup/*/#", 1);
        f9467d.addURI(str, "contacts/lookup/*", 1);
        f9467d.addURI(str, "contacts/#/photo", 2);
        f9467d.addURI(str, "contacts/#", 3);
        f9467d.addURI(str, "contacts/#/display_photo", 4);
        f9467d.addURI(str, "phone_lookup/*", 5);
    }

    public m(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    private InputStream b(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        int match = f9467d.match(uri);
        if (match != 1) {
            if (match == 3) {
                return a(contentResolver, uri);
            }
            if (match != 5) {
                return contentResolver.openInputStream(uri);
            }
        }
        Uri lookupContact = Contacts.lookupContact(contentResolver, uri);
        if (lookupContact != null) {
            return a(contentResolver, lookupContact);
        }
        throw new FileNotFoundException("Contact cannot be found");
    }

    /* access modifiers changed from: protected */
    public InputStream a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        InputStream b2 = b(uri, contentResolver);
        if (b2 != null) {
            return b2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("InputStream is null for ");
        sb.append(uri);
        throw new FileNotFoundException(sb.toString());
    }

    @TargetApi(14)
    private InputStream a(ContentResolver contentResolver, Uri uri) {
        return Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    /* access modifiers changed from: protected */
    public void a(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }
}
