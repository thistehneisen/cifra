package com.touchin.vtb.api;

import b.g.h.c;
import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.List;
import ru.touchin.templates.ApiModel;
import ru.touchin.templates.ApiModel.ValidationException;
import ru.touchin.templates.ApiModel.a;
import ru.touchin.templates.a.d;

@JsonObject(serializeNullObjects = false)
public class DaDataSuggestionListing extends d {
    @JsonField(name = {"suggestions"})
    private List<DaDataSuggestion> suggestions;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.suggestions = (List) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.suggestions);
    }

    public void a(List<DaDataSuggestion> list) {
        this.suggestions = list;
    }

    public List<DaDataSuggestion> b() {
        return Collections.unmodifiableList(this.suggestions);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DaDataSuggestionListing.class != obj.getClass()) {
            return false;
        }
        return c.a(this.suggestions, ((DaDataSuggestionListing) obj).suggestions);
    }

    public int hashCode() {
        return c.a(this.suggestions);
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.suggestions);
        ApiModel.a(this.suggestions, a.EXCEPTION_IF_ANY_INVALID);
    }
}
