package io.intercom.android.sdk.conversation.composer;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.fragment.app.C0200o;
import androidx.fragment.app.F;
import androidx.fragment.app.Fragment;
import b.g.a.a;
import com.intercom.composer.ComposerFragment;
import com.intercom.composer.ComposerHost;
import com.intercom.composer.OnInputSelectedListener;
import com.intercom.composer.input.Input;
import com.intercom.input.gallery.GalleryImage;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.actions.Actions;
import io.intercom.android.sdk.conversation.composer.galleryinput.GalleryInputManager;
import io.intercom.android.sdk.conversation.composer.textinput.TextInputManager;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.nexus.NexusClient;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Store;
import java.util.ArrayList;
import java.util.List;

public class ComposerPresenter implements OnInputSelectedListener {
    private static final int SELECT_INPUT_DELAY_MS = 100;
    /* access modifiers changed from: private */
    public final ComposerFragment composerFragment;
    private final FrameLayout composerLayout;
    private String conversationId;
    private final Runnable defaultInputRunnable = new Runnable() {
        public void run() {
            ComposerPresenter.this.composerFragment.selectInput(ComposerInputIndentifier.TEXT, true);
        }
    };
    private final GalleryInputManager galleryInputManager;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final InputDrawableManager inputDrawableManager;
    InputProvider inputProvider;
    private final MetricTracker metricTracker;
    private final Store<State> store;
    private final TextInputManager textInputManager;

    public interface Listener {
        void onRemoteImageSelected(GalleryImage galleryImage);

        void onSendButtonPressed(CharSequence charSequence);

        void onUploadImageSelected(GalleryImage galleryImage);
    }

    public ComposerPresenter(Listener listener, FrameLayout frameLayout, C0200o oVar, LayoutInflater layoutInflater, NexusClient nexusClient, UserIdentity userIdentity, Provider<AppConfig> provider, MetricTracker metricTracker2, String str, String str2, Store<State> store2, Context context, int i2) {
        C0200o oVar2 = oVar;
        Context context2 = context;
        this.store = store2;
        this.composerLayout = frameLayout;
        this.metricTracker = metricTracker2;
        this.conversationId = str;
        int a2 = ((AppConfig) provider.get()).primaryColorRenderDarkText() ? a.a(context2, R.color.intercom_black) : i2;
        this.inputDrawableManager = new InputDrawableManager(context2, a2);
        Fragment a3 = oVar2.a(ComposerFragment.class.getName());
        if (a3 instanceof ComposerFragment) {
            this.composerFragment = (ComposerFragment) a3;
        } else {
            this.composerFragment = ComposerFragment.newInstance(null, false, a2);
            F a4 = oVar.a();
            a4.b(R.id.composer_container, this.composerFragment, ComposerFragment.class.getName());
            a4.a();
        }
        this.composerFragment.setComposerHost(new ComposerHost() {
            public List<Input> getInputs() {
                return ComposerPresenter.this.inputProvider.getInputs();
            }
        });
        this.composerFragment.setOnInputSelectedListener(this);
        Context context3 = context;
        TextInputManager textInputManager2 = r2;
        TextInputManager textInputManager3 = new TextInputManager(context3, layoutInflater, userIdentity, nexusClient, metricTracker2, str, str2, this.inputDrawableManager, store2, listener);
        this.textInputManager = textInputManager2;
        GalleryInputManager galleryInputManager2 = new GalleryInputManager(context3, this.inputDrawableManager, listener, metricTracker2, str);
        this.galleryInputManager = galleryInputManager2;
        int i3 = VERSION.SDK_INT;
        boolean z = true;
        if (i3 >= 16 && i3 < 23 && a.a(context2, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            z = false;
        }
        setUpInputs(oVar2, z, (AppConfig) provider.get());
    }

    private void addInputsToProvider(List list) {
        this.inputProvider.addInputs(list);
    }

    private void setUpInputs(C0200o oVar, boolean z, AppConfig appConfig) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.textInputManager.createInput());
        if (appConfig.isGifsEnabled()) {
            arrayList.add(this.galleryInputManager.createGifInput());
        }
        if (z && appConfig.isAttachmentsEnabled()) {
            arrayList.add(this.galleryInputManager.createGalleryInput());
        }
        Fragment a2 = oVar.a(InputProvider.class.getName());
        if (a2 == null) {
            this.inputProvider = new InputProvider();
            addInputsToProvider(arrayList);
            F a3 = oVar.a();
            a3.a((Fragment) this.inputProvider, InputProvider.class.getName());
            a3.a();
            return;
        }
        this.inputProvider = (InputProvider) a2;
        if (this.inputProvider.getInputs().isEmpty()) {
            addInputsToProvider(arrayList);
        }
    }

    public void cleanup() {
        this.textInputManager.cleanup();
    }

    public void hideComposer() {
        this.composerLayout.setVisibility(8);
    }

    public boolean isOpen() {
        return this.composerFragment.isOpen();
    }

    public void onBackPressed() {
        this.composerFragment.onBackPressed();
    }

    public void onInputSelected(Input input) {
        this.store.dispatch(Actions.composerInputChanged());
        this.metricTracker.clickedInput(this.conversationId, input.getUniqueIdentifier());
    }

    public void requestFocus() {
        this.textInputManager.requestFocus();
    }

    public void returnToDefaultInput() {
        this.handler.postDelayed(this.defaultInputRunnable, 100);
    }

    public void setConversationId(String str) {
        this.conversationId = str;
        this.textInputManager.setConversationId(str);
        this.galleryInputManager.setConversationId(str);
    }

    public void setHint(int i2) {
        this.textInputManager.setHint(i2);
    }

    public void showComposer() {
        this.composerLayout.setVisibility(0);
    }

    public void updateMaxLines() {
        this.textInputManager.updateMaxLines();
    }
}
