package com.intercom.input.gallery;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.appcompat.app.C0134a;
import androidx.appcompat.app.C0146m.a;
import androidx.appcompat.app.C0147n;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.d;
import androidx.fragment.app.C0195j;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.x;
import com.intercom.composer.ImageLoader;
import com.intercom.composer.input.InputFragment;
import com.intercom.input.gallery.GalleryInputDataSource.Listener;
import com.intercom.input.gallery.adapter.EndlessRecyclerScrollListener;
import com.intercom.input.gallery.adapter.EndlessScrollListener;
import com.intercom.input.gallery.adapter.GalleryRecyclerViewAdapter;
import com.intercom.input.gallery.adapter.OnImageClickListener;
import java.util.ArrayList;
import java.util.List;

public abstract class GalleryInputFragment extends InputFragment implements GalleryInputScreen, OnImageClickListener, EndlessScrollListener {
    private static final String ARG_EXPANDED = "expanded";
    public static final int GALLERY_FULL_SCREEN_REQUEST_CODE = 14;
    FrameLayout contentLayout;
    final Listener dataListener = new Listener() {
        public void onError() {
            if (GalleryInputFragment.this.isAdded()) {
                GalleryInputFragment.this.showErrorScreen();
            }
        }

        public void onSuccess(List<GalleryImage> list) {
            GalleryInputFragment.this.galleryImages.clear();
            GalleryInputFragment.this.galleryImages.addAll(list);
            GalleryInputFragment galleryInputFragment = GalleryInputFragment.this;
            galleryInputFragment.endlessRecyclerScrollListener.setMaxCount(galleryInputFragment.dataSource.getCount());
            GalleryInputFragment.this.recyclerAdapter.notifyDataSetChanged();
            if (GalleryInputFragment.this.isAdded()) {
                GalleryInputFragment.this.showEmptyOrPermissionScreen(0);
            }
        }
    };
    GalleryInputDataSource dataSource;
    EmptyView emptyLayout;
    EndlessRecyclerScrollListener endlessRecyclerScrollListener;
    boolean expanded;
    private final OnClickListener expanderClickListener = new OnClickListener() {
        public void onClick(View view) {
            GalleryInputExpandedListener galleryInputExpandedListener = GalleryInputFragment.this.galleryInputExpandedListener;
            if (galleryInputExpandedListener != null) {
                galleryInputExpandedListener.onInputExpanded();
            }
            GalleryInputFragment.this.startActivityForResult(GalleryInputFullScreenActivity.createIntent(GalleryInputFragment.this.getActivity(), GalleryInputFragment.this.getClass(), GalleryInputFragment.this.getArguments()), 14, d.a((Context) GalleryInputFragment.this.getActivity(), R.anim.intercom_composer_slide_up, R.anim.intercom_composer_stay).a());
        }
    };
    final List<GalleryImage> galleryImages = new ArrayList();
    GalleryInputExpandedListener galleryInputExpandedListener;
    GalleryOutputListener galleryOutputListener;
    private ImageLoader imageLoader;
    Injector injector;
    LinearLayoutManager layoutManager;
    GalleryRecyclerViewAdapter recyclerAdapter;
    RecyclerView recyclerView;

    public interface Injector {
        GalleryInputDataSource getDataSource(GalleryInputFragment galleryInputFragment);

        String getEmptyViewSubtitle(Resources resources);

        String getEmptyViewTitle(Resources resources);

        String getErrorViewSubtitle(Resources resources);

        String getErrorViewTitle(Resources resources);

        View getExpanderButton(ViewGroup viewGroup);

        ImageLoader getImageLoader(GalleryInputFragment galleryInputFragment);

        Class<? extends GalleryLightBoxFragment> getLightBoxFragmentClass(GalleryInputFragment galleryInputFragment);

        View getSearchView(ViewGroup viewGroup);

        int getThemeColor(Context context);

        Toolbar getToolbar(ViewGroup viewGroup);
    }

    public static Bundle createArguments(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(ARG_EXPANDED, z);
        return bundle;
    }

    private void setUpAppBar(Injector injector2, ViewGroup viewGroup) {
        Toolbar toolbar = injector2.getToolbar(viewGroup);
        viewGroup.addView(toolbar);
        ((C0147n) getActivity()).setSupportActionBar(toolbar);
        C0134a supportActionBar = ((C0147n) getActivity()).getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.d(true);
            supportActionBar.e(true);
            supportActionBar.f(false);
        }
    }

    private void setUpPreviewViews(Injector injector2, ViewGroup viewGroup) {
        ImageButton imageButton = (ImageButton) injector2.getExpanderButton(this.contentLayout);
        if (imageButton != null) {
            this.contentLayout.addView(imageButton);
            imageButton.setOnClickListener(this.expanderClickListener);
        }
        View searchView = injector2.getSearchView(this.contentLayout);
        if (searchView != null) {
            searchView.setOnClickListener(this.expanderClickListener);
            viewGroup.addView(searchView, 0);
        }
    }

    /* access modifiers changed from: private */
    public void showPermissionPermanentlyDeniedDialog() {
        new a(getActivity()).setTitle(R.string.intercom_photo_access_denied).setMessage(R.string.intercom_go_to_device_settings).setPositiveButton(R.string.intercom_app_settings, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                GalleryInputFragment.this.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", GalleryInputFragment.this.getActivity().getPackageName(), null)));
            }
        }).setNegativeButton(R.string.intercom_not_now, (DialogInterface.OnClickListener) null).show();
    }

    /* access modifiers changed from: 0000 */
    public void checkPermissionAndFetchImages(boolean z) {
        int permissionStatus = this.dataSource.getPermissionStatus();
        if (permissionStatus != 1) {
            if (permissionStatus == 2) {
                showEmptyOrPermissionScreen(permissionStatus);
                if (z) {
                    showPermissionPermanentlyDeniedDialog();
                    return;
                }
                return;
            } else if (permissionStatus != 3) {
                fetchImagesIfNotFetched();
                return;
            }
        }
        showEmptyOrPermissionScreen(permissionStatus);
        if (z) {
            this.dataSource.requestPermission();
        }
    }

    /* access modifiers changed from: 0000 */
    public void fetchImagesIfNotFetched() {
        if (this.galleryImages.isEmpty()) {
            this.dataSource.getImages(0, null);
        }
    }

    /* access modifiers changed from: protected */
    public abstract Injector getInjector(GalleryInputFragment galleryInputFragment);

    /* access modifiers changed from: 0000 */
    public int getLayoutRes() {
        return this.expanded ? R.layout.intercom_composer_fragment_composer_gallery_expanded : R.layout.intercom_composer_fragment_composer_gallery;
    }

    /* access modifiers changed from: 0000 */
    public void launchLightBoxActivity(GalleryImage galleryImage) {
        C0195j activity = getActivity();
        startActivityForResult(GalleryLightBoxActivity.createIntent(activity, galleryImage, getInjector(this).getLightBoxFragmentClass(this)), 14, d.a((Context) activity, R.anim.intercom_composer_slide_up, R.anim.intercom_composer_stay).a());
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 != 14 || i3 != -1) {
            super.onActivityResult(i2, i3, intent);
        } else if (this.galleryOutputListener != null) {
            this.galleryOutputListener.onGalleryOutputReceived((GalleryImage) intent.getParcelableExtra(GalleryInputFullScreenActivity.GALLERY_IMAGE));
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof GalleryOutputListener) {
            this.galleryOutputListener = (GalleryOutputListener) context;
        }
        if (context instanceof GalleryInputExpandedListener) {
            this.galleryInputExpandedListener = (GalleryInputExpandedListener) context;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.expanded = arguments.getBoolean(ARG_EXPANDED, false);
        }
        if (this.expanded) {
            this.layoutManager = new GridLayoutManager(getContext(), getResources().getInteger(R.integer.intercom_composer_expanded_column_count));
        } else {
            this.layoutManager = new LinearLayoutManager(getContext(), 0, false);
        }
        this.injector = getInjector(this);
        this.dataSource = this.injector.getDataSource(this);
        this.dataSource.setListener(this.dataListener);
        this.imageLoader = this.injector.getImageLoader(this);
        this.endlessRecyclerScrollListener = new EndlessRecyclerScrollListener(this.layoutManager, this);
        GalleryRecyclerViewAdapter galleryRecyclerViewAdapter = new GalleryRecyclerViewAdapter(LayoutInflater.from(getContext()), this.galleryImages, this.expanded, this, this.imageLoader);
        this.recyclerAdapter = galleryRecyclerViewAdapter;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(getLayoutRes(), viewGroup, false);
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(R.id.gallery_root_view);
        this.recyclerView = (RecyclerView) inflate.findViewById(R.id.gallery_recycler_view);
        this.emptyLayout = (EmptyView) inflate.findViewById(R.id.gallery_empty_view);
        this.contentLayout = (FrameLayout) inflate.findViewById(R.id.gallery_content_layout);
        if (this.expanded) {
            setUpAppBar(this.injector, viewGroup2);
            this.recyclerView.a((h) new HeadingMarginDecoration(R.dimen.intercom_composer_toolbar_height));
        } else {
            setUpPreviewViews(this.injector, viewGroup2);
        }
        this.emptyLayout.setActionButtonClickListener(new OnClickListener() {
            public void onClick(View view) {
                int permissionStatus = GalleryInputFragment.this.dataSource.getPermissionStatus();
                if (permissionStatus != 1) {
                    if (permissionStatus == 2) {
                        GalleryInputFragment.this.showPermissionPermanentlyDeniedDialog();
                        return;
                    } else if (permissionStatus != 3) {
                        return;
                    }
                }
                GalleryInputFragment.this.dataSource.requestPermission();
            }
        });
        this.emptyLayout.setThemeColor(this.injector.getThemeColor(getContext()));
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.recyclerView.b((n) this.endlessRecyclerScrollListener);
        this.recyclerView.setLayoutManager(null);
    }

    public void onImageClicked(x xVar) {
        int adapterPosition = xVar.getAdapterPosition();
        if (adapterPosition > -1 && adapterPosition < this.recyclerAdapter.getItemCount()) {
            launchLightBoxActivity(this.recyclerAdapter.getItem(adapterPosition));
        }
    }

    public void onInputDeselected() {
    }

    public void onInputReselected() {
    }

    public void onInputSelected() {
        checkPermissionAndFetchImages(true);
    }

    public void onLoadMore() {
        if (!this.galleryImages.isEmpty() && !this.dataSource.isLoading()) {
            this.dataSource.getImages(this.galleryImages.size(), null);
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        checkPermissionAndFetchImages(false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.recyclerView.setLayoutManager(this.layoutManager);
        this.recyclerView.setAdapter(this.recyclerAdapter);
        this.recyclerView.a((n) this.endlessRecyclerScrollListener);
        if (this.expanded) {
            onInputSelected();
        }
        this.endlessRecyclerScrollListener.setMaxCount(this.dataSource.getCount());
    }

    /* access modifiers changed from: protected */
    public void passDataOnViewCreated(Bundle bundle) {
    }

    public void setGalleryExpandedListener(GalleryInputExpandedListener galleryInputExpandedListener2) {
        this.galleryInputExpandedListener = galleryInputExpandedListener2;
    }

    public void setGalleryListener(GalleryOutputListener galleryOutputListener2) {
        this.galleryOutputListener = galleryOutputListener2;
    }

    /* access modifiers changed from: 0000 */
    public void showEmptyOrPermissionScreen(int i2) {
        if (i2 != 0) {
            if (i2 == 1 || i2 == 2) {
                this.emptyLayout.setVisibility(0);
                this.emptyLayout.setTitle(R.string.intercom_photo_access_denied);
                this.emptyLayout.setSubtitle(R.string.intercom_allow_storage_access);
                this.emptyLayout.setActionButtonVisibility(0);
                this.contentLayout.setVisibility(8);
            } else if (i2 == 3) {
                this.emptyLayout.setVisibility(0);
                this.emptyLayout.setTitle(R.string.intercom_access_photos);
                this.emptyLayout.setSubtitle(R.string.intercom_storage_access_request);
                this.emptyLayout.setActionButtonVisibility(8);
                this.contentLayout.setVisibility(8);
            }
        } else if (this.galleryImages.isEmpty()) {
            this.emptyLayout.setVisibility(0);
            this.emptyLayout.setActionButtonVisibility(8);
            this.emptyLayout.setTitle((CharSequence) this.injector.getEmptyViewTitle(getResources()));
            this.emptyLayout.setSubtitle((CharSequence) this.injector.getEmptyViewSubtitle(getResources()));
            this.contentLayout.setVisibility(8);
        } else {
            this.emptyLayout.setVisibility(8);
            this.contentLayout.setVisibility(0);
        }
    }

    /* access modifiers changed from: 0000 */
    public void showErrorScreen() {
        this.emptyLayout.setVisibility(0);
        this.emptyLayout.setActionButtonVisibility(8);
        this.emptyLayout.setTitle((CharSequence) this.injector.getErrorViewTitle(getResources()));
        this.emptyLayout.setSubtitle((CharSequence) this.injector.getErrorViewSubtitle(getResources()));
        this.contentLayout.setVisibility(8);
    }
}
