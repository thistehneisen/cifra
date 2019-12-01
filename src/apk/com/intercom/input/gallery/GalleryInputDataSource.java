package com.intercom.input.gallery;

import java.util.List;

public interface GalleryInputDataSource {

    public interface Listener {
        void onError();

        void onSuccess(List<GalleryImage> list);
    }

    int getCount();

    void getImages(int i2, String str);

    int getPermissionStatus();

    boolean isLoading();

    void requestPermission();

    void setListener(Listener listener);
}
