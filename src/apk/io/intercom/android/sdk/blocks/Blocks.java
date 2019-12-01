package io.intercom.android.sdk.blocks;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import io.intercom.android.sdk.blocks.models.Block;
import io.intercom.android.sdk.twig.Twig;
import java.util.List;

public class Blocks {
    private final LayoutInflater inflater;
    private final Twig twig;

    public Blocks(Context context, Twig twig2) {
        this.inflater = LayoutInflater.from(context);
        this.twig = twig2;
    }

    public LinearLayout createBlocks(List<Block> list, BlocksViewHolder blocksViewHolder) {
        LinearLayout linearLayout = (LinearLayout) this.inflater.inflate(blocksViewHolder.getLayout(), null);
        if (list != null) {
            int i2 = 0;
            while (i2 < list.size()) {
                Block block = (Block) list.get(i2);
                try {
                    linearLayout.addView(block.getType().getView(blocksViewHolder, block, linearLayout, i2 == 0, i2 == list.size() - 1));
                } catch (BlockTypeNotImplementedException e2) {
                    this.twig.e(e2, "Error creating view for block with type %s ", block.getType());
                }
                i2++;
            }
        }
        return linearLayout;
    }
}
