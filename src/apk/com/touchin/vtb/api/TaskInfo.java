package com.touchin.vtb.api;

import b.g.h.c;
import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.joda.time.b;
import ru.touchin.templates.ApiModel;
import ru.touchin.templates.ApiModel.ValidationException;
import ru.touchin.templates.a.d;

@JsonObject(serializeNullObjects = false)
public class TaskInfo extends d {
    @JsonField(name = {"amount"})
    private Amount amount;
    @JsonField(name = {"completionDate"})
    private b completionDate;
    @JsonField(name = {"creationDate"})
    private b creationDate;
    @JsonField(name = {"description"})
    private String description;
    @JsonField(name = {"dueDate"})
    private b dueDate;
    @JsonField(name = {"id"})
    private String id;
    @JsonField(name = {"priority"})
    private TaskPriority priority;
    @JsonField(name = {"shortDescription"})
    private String shortDescription;
    @JsonField(name = {"taskStatus"})
    private TaskStatus taskStatus;
    @JsonField(name = {"title"})
    private String title;
    @JsonField(name = {"type"})
    private TaskType type;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.id = objectInputStream.readUTF();
        this.priority = (TaskPriority) objectInputStream.readObject();
        this.title = objectInputStream.readUTF();
        this.shortDescription = objectInputStream.readUTF();
        this.description = (String) objectInputStream.readObject();
        this.taskStatus = (TaskStatus) objectInputStream.readObject();
        this.creationDate = (b) objectInputStream.readObject();
        this.type = (TaskType) objectInputStream.readObject();
        this.dueDate = (b) objectInputStream.readObject();
        this.amount = (Amount) objectInputStream.readObject();
        this.completionDate = (b) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.id);
        objectOutputStream.writeObject(this.priority);
        objectOutputStream.writeUTF(this.title);
        objectOutputStream.writeUTF(this.shortDescription);
        objectOutputStream.writeObject(this.description);
        objectOutputStream.writeObject(this.taskStatus);
        objectOutputStream.writeObject(this.creationDate);
        objectOutputStream.writeObject(this.type);
        objectOutputStream.writeObject(this.dueDate);
        objectOutputStream.writeObject(this.amount);
        objectOutputStream.writeObject(this.completionDate);
    }

    public void a(TaskPriority taskPriority) {
        this.priority = taskPriority;
    }

    public void b(String str) {
        this.id = str;
    }

    public void c(String str) {
        this.shortDescription = str;
    }

    public void d(String str) {
        this.title = str;
    }

    public String e() {
        String str = this.description;
        if (str == null) {
            return null;
        }
        return str;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || TaskInfo.class != obj.getClass()) {
            return false;
        }
        TaskInfo taskInfo = (TaskInfo) obj;
        if (!c.a(this.id, taskInfo.id) || !c.a(this.priority, taskInfo.priority) || !c.a(this.title, taskInfo.title) || !c.a(this.shortDescription, taskInfo.shortDescription) || !c.a(this.description, taskInfo.description) || !c.a(this.taskStatus, taskInfo.taskStatus) || !c.a(this.creationDate, taskInfo.creationDate) || !c.a(this.type, taskInfo.type) || !c.a(this.dueDate, taskInfo.dueDate) || !c.a(this.amount, taskInfo.amount) || !c.a(this.completionDate, taskInfo.completionDate)) {
            z = false;
        }
        return z;
    }

    public b f() {
        b bVar = this.dueDate;
        if (bVar == null) {
            return null;
        }
        return bVar;
    }

    public String g() {
        return this.id;
    }

    public TaskPriority h() {
        return this.priority;
    }

    public int hashCode() {
        return c.a(this.id, this.priority, this.title, this.shortDescription, this.description, this.taskStatus, this.creationDate, this.type, this.dueDate, this.amount, this.completionDate);
    }

    public String i() {
        return this.shortDescription;
    }

    public TaskStatus j() {
        return this.taskStatus;
    }

    public String k() {
        return this.title;
    }

    public TaskType l() {
        return this.type;
    }

    public void a(String str) {
        this.description = str;
    }

    public void b(b bVar) {
        this.creationDate = bVar;
    }

    public void c(b bVar) {
        this.dueDate = bVar;
    }

    public b d() {
        return this.creationDate;
    }

    public void a(TaskStatus taskStatus2) {
        this.taskStatus = taskStatus2;
    }

    public Amount b() {
        Amount amount2 = this.amount;
        if (amount2 == null) {
            return null;
        }
        return amount2;
    }

    public b c() {
        b bVar = this.completionDate;
        if (bVar == null) {
            return null;
        }
        return bVar;
    }

    public void a(TaskType taskType) {
        this.type = taskType;
    }

    public void a(Amount amount2) {
        this.amount = amount2;
    }

    public void a(b bVar) {
        this.completionDate = bVar;
    }

    public void a() throws ValidationException {
        super.a();
        d.a(this.id);
        d.a(this.priority);
        d.a(this.title);
        d.a(this.shortDescription);
        d.a(this.taskStatus);
        d.a(this.creationDate);
        d.a(this.type);
        Amount amount2 = this.amount;
        if ((amount2 instanceof ApiModel) && amount2 != null) {
            amount2.a();
        }
    }
}
