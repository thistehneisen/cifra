package io.intercom.android.sdk.blocks.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import io.intercom.android.sdk.blocks.models.Link.Builder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LinkList implements Parcelable {
    public static final Creator<LinkList> CREATOR = new Creator<LinkList>() {
        public LinkList createFromParcel(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, Link.class.getClassLoader());
            return new LinkList(arrayList, (Link) parcel.readParcelable(Link.class.getClassLoader()));
        }

        public LinkList[] newArray(int i2) {
            return new LinkList[i2];
        }
    };
    private final Link footerLink;
    private final List<Link> links;

    public LinkList(List<Link> list, Link link) {
        this.links = list;
        this.footerLink = link;
    }

    public static LinkList fromBlock(Block block) {
        if (block == null) {
            return new LinkList(Collections.emptyList(), new Builder().build());
        }
        return new LinkList(block.getLinks(), block.getFooterLink());
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || LinkList.class != obj.getClass()) {
            return false;
        }
        LinkList linkList = (LinkList) obj;
        if (!this.links.equals(linkList.links)) {
            return false;
        }
        return this.footerLink.equals(linkList.footerLink);
    }

    public Link getFooterLink() {
        return this.footerLink;
    }

    public List<Link> getLinks() {
        return this.links;
    }

    public int hashCode() {
        return (this.links.hashCode() * 31) + this.footerLink.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeList(this.links);
        parcel.writeParcelable(this.footerLink, i2);
    }
}
