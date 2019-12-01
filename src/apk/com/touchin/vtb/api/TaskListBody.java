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
public class TaskListBody extends SessionIdBody {
    @JsonField(name = {"limit"})
    private int limit;
    @JsonField(name = {"offset"})
    private int offset;
    @JsonField(name = {"taskFilter"})
    private TaskFilter taskFilter;

    public TaskListBody() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.taskFilter = (TaskFilter) objectInputStream.readObject();
        this.limit = objectInputStream.readInt();
        this.offset = objectInputStream.readInt();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.taskFilter);
        objectOutputStream.writeInt(this.limit);
        objectOutputStream.writeInt(this.offset);
    }

    public void a(TaskFilter taskFilter2) {
        this.taskFilter = taskFilter2;
    }

    public void b(int i2) {
        this.offset = i2;
    }

    public int c() {
        return this.limit;
    }

    public int d() {
        return this.offset;
    }

    public TaskFilter e() {
        return this.taskFilter;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || TaskListBody.class != obj.getClass()) {
            return false;
        }
        TaskListBody taskListBody = (TaskListBody) obj;
        if (!super.equals(taskListBody) || !c.a(this.taskFilter, taskListBody.taskFilter) || !c.a(Integer.valueOf(this.limit), Integer.valueOf(taskListBody.limit)) || !c.a(Integer.valueOf(this.offset), Integer.valueOf(taskListBody.offset))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(Integer.valueOf(super.hashCode()), this.taskFilter, Integer.valueOf(this.limit), Integer.valueOf(this.offset));
    }

    public TaskListBody(TaskFilter taskFilter2, int i2, int i3, String str) {
        super(str);
        this.taskFilter = taskFilter2;
        this.limit = i2;
        this.offset = i3;
    }

    public void a(int i2) {
        this.limit = i2;
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.taskFilter);
    }
}
