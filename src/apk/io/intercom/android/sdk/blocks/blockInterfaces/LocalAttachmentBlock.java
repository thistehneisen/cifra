package io.intercom.android.sdk.blocks.blockInterfaces;

import android.view.View;
import android.view.ViewGroup;
import io.intercom.android.sdk.blocks.models.BlockAttachment;

public interface LocalAttachmentBlock {
    View addAttachment(BlockAttachment blockAttachment, boolean z, boolean z2, ViewGroup viewGroup);
}
