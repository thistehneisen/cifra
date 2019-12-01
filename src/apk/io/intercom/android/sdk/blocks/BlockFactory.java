package io.intercom.android.sdk.blocks;

import io.intercom.android.sdk.blocks.logic.TextSplittingStrategy;
import io.intercom.android.sdk.blocks.models.Block.Builder;
import java.util.ArrayList;
import java.util.List;

public class BlockFactory {
    private final TextSplittingStrategy textSplittingStrategy;

    public BlockFactory(TextSplittingStrategy textSplittingStrategy2) {
        this.textSplittingStrategy = textSplittingStrategy2;
    }

    public List<Builder> getBlocksForText(String str) {
        List apply = this.textSplittingStrategy.apply(str);
        int size = apply.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new Builder().withType(BlockType.PARAGRAPH.name().toLowerCase()).withText((String) apply.get(i2)));
        }
        return arrayList;
    }
}
