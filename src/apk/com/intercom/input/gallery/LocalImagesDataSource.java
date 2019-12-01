package com.intercom.input.gallery;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.MediaStore.Images.Media;
import androidx.fragment.app.C0195j;
import com.intercom.input.gallery.GalleryImage.Builder;
import com.intercom.input.gallery.GalleryInputDataSource.Listener;
import java.util.ArrayList;
import java.util.List;

public class LocalImagesDataSource implements GalleryInputDataSource {
    private static final int ITEM_COUNT_LIMIT = 50;
    private static final int READ_EXTERNAL_STORAGE_REQUEST = 1;
    private Context context;
    private GalleryInputScreen galleryInputScreen;
    private Listener listener;
    private boolean loading;
    private PermissionHelper permissionHelper;

    LocalImagesDataSource(Context context2, PermissionHelper permissionHelper2, GalleryInputScreen galleryInputScreen2) {
        this.context = context2;
        this.galleryInputScreen = galleryInputScreen2;
        this.permissionHelper = permissionHelper2;
    }

    public static GalleryInputDataSource create(GalleryInputFragment galleryInputFragment) {
        C0195j activity = galleryInputFragment.getActivity();
        return new LocalImagesDataSource(activity, PermissionHelper.create(activity), galleryInputFragment);
    }

    private Point getImageHeightAndWidth(Cursor cursor, String str) {
        int i2;
        int i3;
        if (VERSION.SDK_INT >= 16) {
            i2 = cursor.getInt(cursor.getColumnIndexOrThrow("height"));
            i3 = cursor.getInt(cursor.getColumnIndexOrThrow("width"));
        } else {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i4 = options.outWidth;
            i2 = options.outHeight;
            i3 = i4;
        }
        return new Point(i3, i2);
    }

    /* access modifiers changed from: 0000 */
    public List<GalleryImage> galleryImagesFromCursor(Cursor cursor) {
        ArrayList arrayList = new ArrayList(cursor.getCount());
        if (cursor.moveToFirst()) {
            do {
                String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                String string2 = cursor.getString(cursor.getColumnIndexOrThrow("mime_type"));
                String string3 = cursor.getString(cursor.getColumnIndexOrThrow("title"));
                int i2 = cursor.getInt(cursor.getColumnIndexOrThrow("_size"));
                if (!(string == null || string3 == null || string2 == null)) {
                    Point imageHeightAndWidth = getImageHeightAndWidth(cursor, string);
                    arrayList.add(new Builder().withFileName(string3).withPath(string).withMimeType(string2).withImageWidth(imageHeightAndWidth.x).withImageHeight(imageHeightAndWidth.y).withFileSize(i2).build());
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        return arrayList;
    }

    public int getCount() {
        int i2 = 0;
        if (getPermissionStatus() != 0) {
            return 0;
        }
        Cursor query = this.context.getContentResolver().query(Media.EXTERNAL_CONTENT_URI, null, null, null, null);
        if (query != null) {
            i2 = query.getCount();
            query.close();
        }
        return i2;
    }

    public void getImages(int i2, String str) {
        this.loading = true;
        String[] strArr = VERSION.SDK_INT >= 16 ? new String[]{"_data", "date_added", "mime_type", "title", "height", "width", "_size"} : new String[]{"_data", "date_added", "mime_type", "title", "_size"};
        ContentResolver contentResolver = this.context.getContentResolver();
        Uri uri = Media.EXTERNAL_CONTENT_URI;
        StringBuilder sb = new StringBuilder();
        sb.append("date_added DESC LIMIT 50 OFFSET ");
        sb.append(i2);
        Cursor query = contentResolver.query(uri, strArr, null, null, sb.toString());
        this.loading = false;
        if (query == null) {
            this.listener.onError();
        } else {
            this.listener.onSuccess(galleryImagesFromCursor(query));
        }
    }

    public int getPermissionStatus() {
        if (VERSION.SDK_INT >= 23) {
            return this.permissionHelper.getPermissionStatus("android.permission.READ_EXTERNAL_STORAGE");
        }
        return 0;
    }

    public boolean isLoading() {
        return this.loading;
    }

    public void requestPermission() {
        this.permissionHelper.setAskedForPermissionPref(true);
        if (VERSION.SDK_INT >= 23) {
            this.galleryInputScreen.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 1);
        }
    }

    public void setListener(Listener listener2) {
        this.listener = listener2;
    }
}
