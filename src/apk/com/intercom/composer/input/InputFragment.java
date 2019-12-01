package com.intercom.composer.input;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;

public abstract class InputFragment extends Fragment {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public abstract void onInputDeselected();

    public abstract void onInputReselected();

    public abstract void onInputSelected();

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        passDataOnViewCreated(getArguments());
    }

    public void passData(Bundle bundle) {
        if (getView() != null) {
            passDataOnViewCreated(bundle);
        } else {
            setArguments(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void passDataOnViewCreated(Bundle bundle);

    public void setArguments(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        if (bundle != null) {
            arguments.putAll(bundle);
        }
        super.setArguments(arguments);
    }
}
