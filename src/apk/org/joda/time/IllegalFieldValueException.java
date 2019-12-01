package org.joda.time;

public class IllegalFieldValueException extends IllegalArgumentException {
    private static final long serialVersionUID = 6305711765985447737L;
    private final d iDateTimeFieldType;
    private final i iDurationFieldType = null;
    private final String iFieldName;
    private final Number iLowerBound;
    private String iMessage;
    private final Number iNumberValue;
    private final String iStringValue;
    private final Number iUpperBound;

    public IllegalFieldValueException(d dVar, Number number, Number number2, Number number3) {
        super(a(dVar.F(), number, number2, number3, null));
        this.iDateTimeFieldType = dVar;
        this.iFieldName = dVar.F();
        this.iNumberValue = number;
        this.iStringValue = null;
        this.iLowerBound = number2;
        this.iUpperBound = number3;
        this.iMessage = super.getMessage();
    }

    private static String a(String str, Number number, Number number2, Number number3, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("Value ");
        sb.append(number);
        sb.append(" for ");
        sb.append(str);
        sb.append(' ');
        if (number2 == null) {
            if (number3 == null) {
                sb.append("is not supported");
            } else {
                sb.append("must not be larger than ");
                sb.append(number3);
            }
        } else if (number3 == null) {
            sb.append("must not be smaller than ");
            sb.append(number2);
        } else {
            sb.append("must be in the range [");
            sb.append(number2);
            sb.append(',');
            sb.append(number3);
            sb.append(']');
        }
        if (str2 != null) {
            sb.append(": ");
            sb.append(str2);
        }
        return sb.toString();
    }

    public String getMessage() {
        return this.iMessage;
    }

    public IllegalFieldValueException(d dVar, Number number, String str) {
        super(a(dVar.F(), number, null, null, str));
        this.iDateTimeFieldType = dVar;
        this.iFieldName = dVar.F();
        this.iNumberValue = number;
        this.iStringValue = null;
        this.iLowerBound = null;
        this.iUpperBound = null;
        this.iMessage = super.getMessage();
    }

    private static String a(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Value ");
        if (str2 == null) {
            stringBuffer.append("null");
        } else {
            stringBuffer.append('\"');
            stringBuffer.append(str2);
            stringBuffer.append('\"');
        }
        stringBuffer.append(" for ");
        stringBuffer.append(str);
        stringBuffer.append(' ');
        stringBuffer.append("is not supported");
        return stringBuffer.toString();
    }

    public IllegalFieldValueException(d dVar, String str) {
        super(a(dVar.F(), str));
        this.iDateTimeFieldType = dVar;
        this.iFieldName = dVar.F();
        this.iStringValue = str;
        this.iNumberValue = null;
        this.iLowerBound = null;
        this.iUpperBound = null;
        this.iMessage = super.getMessage();
    }

    public void a(String str) {
        if (this.iMessage == null) {
            this.iMessage = str;
        } else if (str != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(": ");
            sb.append(this.iMessage);
            this.iMessage = sb.toString();
        }
    }
}
