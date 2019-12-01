package io.intercom.android.sdk.blocks.blockInterfaces;

import android.view.View;
import android.view.ViewGroup;
import io.intercom.android.sdk.blocks.models.BlockAttachment;
import java.util.List;

public interface AttachmentListBlock {
    View addAttachmentList(List<BlockAttachment> list, boolean z, boolean z2, ViewGroup viewGroup);
}
