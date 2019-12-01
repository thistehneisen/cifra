package com.intercom.composer.pager;

import android.view.ViewGroup;
import androidx.fragment.app.B;
import androidx.fragment.app.C0200o;
import androidx.fragment.app.Fragment;
import com.intercom.composer.input.Input;
import java.util.List;

public class ComposerPagerAdapter extends B {
    private final List<? extends Input> inputs;

    public ComposerPagerAdapter(C0200o oVar, List<? extends Input> list) {
        super(oVar);
        this.inputs = list;
    }

    public int getCount() {
        return this.inputs.size();
    }

    public Fragment getItem(int i2) {
        return ((Input) this.inputs.get(i2)).createFragment();
    }

    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        Fragment fragment = (Fragment) super.instantiateItem(viewGroup, i2);
        ((Input) this.inputs.get(i2)).setFragmentTag(fragment.getTag());
        return fragment;
    }
}
