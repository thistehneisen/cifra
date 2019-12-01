package com.intercom.composer.input.empty;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.intercom.composer.R;
import com.intercom.composer.input.InputFragment;

public class EmptyFragment extends InputFragment {
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.intercom_composer_fragment_empty, viewGroup, false);
    }

    public void onInputDeselected() {
    }

    public void onInputReselected() {
    }

    public void onInputSelected() {
    }

    /* access modifiers changed from: protected */
    public void passDataOnViewCreated(Bundle bundle) {
    }
}
