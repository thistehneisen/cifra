package retrofit2;

public class HttpException extends RuntimeException {

    /* renamed from: a reason: collision with root package name */
    private final transient u<?> f10961a;
    private final int code;
    private final String message;

    public HttpException(u<?> uVar) {
        super(a(uVar));
        this.code = uVar.b();
        this.message = uVar.d();
        this.f10961a = uVar;
    }

    private static String a(u<?> uVar) {
        y.a(uVar, "response == null");
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP ");
        sb.append(uVar.b());
        sb.append(" ");
        sb.append(uVar.d());
        return sb.toString();
    }
}
