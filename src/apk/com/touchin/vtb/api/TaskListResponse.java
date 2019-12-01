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
public class TaskListResponse extends d {
    @JsonField(name = {"taskList"})
    private List<TaskInfo> taskList;
    @JsonField(name = {"urgentTaskList"})
    private List<TaskInfo> urgentTaskList;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.taskList = (List) objectInputStream.readObject();
        this.urgentTaskList = (List) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.taskList);
        objectOutputStream.writeObject(this.urgentTaskList);
    }

    public void a(List<TaskInfo> list) {
        this.taskList = list;
    }

    public List<TaskInfo> b() {
        return Collections.unmodifiableList(this.taskList);
    }

    public List<TaskInfo> c() {
        List<TaskInfo> list = this.urgentTaskList;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || TaskListResponse.class != obj.getClass()) {
            return false;
        }
        TaskListResponse taskListResponse = (TaskListResponse) obj;
        if (!c.a(this.taskList, taskListResponse.taskList) || !c.a(this.urgentTaskList, taskListResponse.urgentTaskList)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return c.a(this.taskList, this.urgentTaskList);
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.taskList);
        ApiModel.a(this.taskList, a.EXCEPTION_IF_ANY_INVALID);
        List<TaskInfo> list = this.urgentTaskList;
        if (list != null) {
            ApiModel.a(list, a.EXCEPTION_IF_ANY_INVALID);
        }
    }

    public void b(List<TaskInfo> list) {
        this.urgentTaskList = list;
    }
}
