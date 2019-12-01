package io.intercom.android.sdk.conversation.composer;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.intercom.composer.input.Input;
import java.util.ArrayList;
import java.util.List;

public class InputProvider extends Fragment {
    private final List<Input> inputs = new ArrayList();

    public void addInputs(List<Input> list) {
        this.inputs.addAll(list);
    }

    public List<Input> getInputs() {
        return this.inputs;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }
}
