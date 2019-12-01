package io.intercom.android.sdk.commons.utilities;

import java.util.Collection;

public class CollectionUtils {
    public static int capacityFor(Collection<?> collection) {
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }
}
