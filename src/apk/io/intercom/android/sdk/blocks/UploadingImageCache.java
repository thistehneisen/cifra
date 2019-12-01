package io.intercom.android.sdk.blocks;

import android.net.Uri;
import com.intercom.input.gallery.GalleryImage;
import io.intercom.android.sdk.models.Upload;
import java.util.HashMap;
import java.util.Map;

public class UploadingImageCache {
    private final Map<String, String> localImagePaths;

    public UploadingImageCache() {
        this(new HashMap());
    }

    public String getLocalImagePathForRemoteUrl(String str) {
        return (String) this.localImagePaths.get(str);
    }

    public void put(Upload upload, GalleryImage galleryImage) {
        this.localImagePaths.put(Uri.parse(upload.getUploadDestination()).buildUpon().path(upload.getKey()).build().toString(), galleryImage.getPath());
    }

    UploadingImageCache(Map<String, String> map) {
        this.localImagePaths = map;
    }
}
