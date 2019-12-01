package com.intercom.composer.input.iconbar;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView.x;
import com.intercom.composer.R;
import com.intercom.composer.input.Input;

class InputIconViewHolder extends x implements OnClickListener {
    final ImageView imageView;
    final InputClickedListener listener;

    InputIconViewHolder(View view, InputClickedListener inputClickedListener) {
        super(view);
        this.listener = inputClickedListener;
        this.imageView = (ImageView) view.findViewById(R.id.input_icon_image_view);
        this.imageView.setOnClickListener(this);
        view.setOnClickListener(this);
    }

    /* access modifiers changed from: 0000 */
    public void bind(Input input, boolean z) {
        ImageView imageView2 = this.imageView;
        imageView2.setImageDrawable(input.getIconDrawable(imageView2.getContext()));
        this.imageView.setSelected(z);
    }

    public void onClick(View view) {
        this.listener.onInputClicked(this);
    }
}
