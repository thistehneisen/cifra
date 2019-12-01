package com.intercom.composer.input.iconbar;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.fragment.app.C0200o;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.x;
import com.intercom.composer.R;
import com.intercom.composer.input.Input;
import com.intercom.composer.input.InputFragment;
import com.intercom.composer.input.empty.EmptyInput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class InputIconsRecyclerAdapter extends a<x> {
    static final int VIEW_TYPE_EMPTY_SPACE = 2;
    static final int VIEW_TYPE_INPUT = 1;
    private final C0200o fragmentManager;
    private final HashSet<String> hiddenInputIdentifiers = new HashSet<>();
    private final InputClickedListener inputClickedListener;
    private List<Input> inputs = new ArrayList();
    private final LayoutInflater layoutInflater;
    private final InputSelectedListener onInputIconSelectedListener;
    private Input selectedInput;

    public InputIconsRecyclerAdapter(LayoutInflater layoutInflater2, List<Input> list, InputSelectedListener inputSelectedListener, InputClickedListener inputClickedListener2, C0200o oVar) {
        this.inputs = list;
        this.onInputIconSelectedListener = inputSelectedListener;
        this.layoutInflater = layoutInflater2;
        this.inputClickedListener = inputClickedListener2;
        this.fragmentManager = oVar;
    }

    private void fireInputSelectionCallbacks(Input input) {
        Input input2 = this.selectedInput;
        if (input == input2) {
            InputFragment findFragment = input.findFragment(this.fragmentManager);
            if (findFragment != null) {
                findFragment.onInputReselected();
                return;
            }
            return;
        }
        if (input2 != null) {
            InputFragment findFragment2 = input2.findFragment(this.fragmentManager);
            if (findFragment2 != null) {
                findFragment2.onInputDeselected();
            }
        }
        InputFragment findFragment3 = input.findFragment(this.fragmentManager);
        if (findFragment3 != null) {
            findFragment3.onInputSelected();
        }
    }

    public void deselectAllInputs() {
        this.selectedInput = null;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.inputs.size();
    }

    public int getItemViewType(int i2) {
        Input input = (Input) this.inputs.get(i2);
        return ((input instanceof EmptyInput) || this.hiddenInputIdentifiers.contains(input.getUniqueIdentifier())) ? 2 : 1;
    }

    public Input getSelectedInput() {
        return this.selectedInput;
    }

    public void hideAllInputsExcept(List<String> list) {
        this.hiddenInputIdentifiers.clear();
        for (Input uniqueIdentifier : this.inputs) {
            String uniqueIdentifier2 = uniqueIdentifier.getUniqueIdentifier();
            if (!list.contains(uniqueIdentifier2)) {
                this.hiddenInputIdentifiers.add(uniqueIdentifier2);
            }
        }
        notifyDataSetChanged();
    }

    public void onBindViewHolder(x xVar, int i2) {
        Input input = (Input) this.inputs.get(i2);
        if (xVar instanceof InputIconViewHolder) {
            ((InputIconViewHolder) xVar).bind(input, this.selectedInput != null && input.getUniqueIdentifier().equals(this.selectedInput.getUniqueIdentifier()));
        }
    }

    public x onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 2) {
            return new EmptyIconViewHolder(this.layoutInflater.inflate(R.layout.intercom_composer_empty_view_layout, viewGroup, false));
        }
        return new InputIconViewHolder(this.layoutInflater.inflate(R.layout.intercom_composer_input_icon_view_layout, viewGroup, false), this.inputClickedListener);
    }

    public boolean selectInput(Input input, boolean z, boolean z2) {
        if (this.inputs.indexOf(input) == -1) {
            return false;
        }
        fireInputSelectionCallbacks(input);
        if (input == this.selectedInput) {
            return false;
        }
        this.selectedInput = input;
        notifyDataSetChanged();
        this.onInputIconSelectedListener.onInputSelected(input, this.inputs.indexOf(input), z, z2);
        return true;
    }

    public void showAllInputs() {
        this.hiddenInputIdentifiers.clear();
        notifyDataSetChanged();
    }
}
