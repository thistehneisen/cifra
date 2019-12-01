package ru.touchin.roboswag.core.utils;

public class ShouldNotHappenException extends RuntimeException {
    private static final long serialVersionUID = 0;

    public ShouldNotHappenException() {
    }

    public ShouldNotHappenException(String str) {
        super(str);
    }

    public ShouldNotHappenException(String str, Throwable th) {
        super(str, th);
    }

    public ShouldNotHappenException(Throwable th) {
        super(th);
    }
}
