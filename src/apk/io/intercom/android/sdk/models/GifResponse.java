package io.intercom.android.sdk.models;

import io.intercom.android.sdk.blocks.models.Block;
import java.util.List;

public class GifResponse {
    private final List<Block> results;

    public static final class Builder {
        List<Block> results;

        public GifResponse build() {
            return new GifResponse(this.results);
        }
    }

    GifResponse(List<Block> list) {
        this.results = list;
    }

    public List<Block> results() {
        return this.results;
    }
}
