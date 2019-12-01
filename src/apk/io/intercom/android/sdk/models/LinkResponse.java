package io.intercom.android.sdk.models;

public class LinkResponse extends BaseResponse {
    private final Link link;

    public static final class Builder extends Builder {
        io.intercom.android.sdk.models.Link.Builder article;

        public LinkResponse build() {
            return new LinkResponse(this);
        }
    }

    LinkResponse(Builder builder) {
        Link link2;
        super(builder);
        io.intercom.android.sdk.models.Link.Builder builder2 = builder.article;
        if (builder2 == null) {
            link2 = new io.intercom.android.sdk.models.Link.Builder().build();
        } else {
            link2 = builder2.build();
        }
        this.link = link2;
    }

    public Link getLink() {
        return this.link;
    }
}
