package com.touchin.vtb.api;

import b.g.h.c;
import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import ru.touchin.templates.ApiModel.ValidationException;
import ru.touchin.templates.a.d;

@JsonObject(serializeNullObjects = false)
public class TaskIdBody extends SessionIdBody {
    @JsonField(name = {"taskId"})
    private String taskId;

    public TaskIdBody() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.taskId = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.taskId);
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.taskId);
    }

    public void b(String str) {
        this.taskId = str;
    }

    public String c() {
        return this.taskId;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || TaskIdBody.class != obj.getClass()) {
            return false;
        }
        TaskIdBody taskIdBody = (TaskIdBody) obj;
        if (!super.equals(taskIdBody) || !c.a(this.taskId, taskIdBody.taskId)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(Integer.valueOf(super.hashCode()), this.taskId);
    }

    public TaskIdBody(String str, String str2) {
        super(str2);
        this.taskId = str;
    }
}
