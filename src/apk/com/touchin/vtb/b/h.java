package com.touchin.vtb.b;

/* compiled from: VTBAnalytics.kt */
public enum h {
    ENTER_PHONE_NUMBER("enter_phone_number"),
    ENTER_PHONE_CONFIRM_SMS("enter_phone_number_sms"),
    SELECT_COMPANY("select_company"),
    SELECT_COMPANY_CONFIRM("select_company_confirm"),
    SUCCESS_CONNECT_BANK("success_connect_bank"),
    FIRST_LOGIN("first_login"),
    PHONE_CALL("phone_call"),
    CALL("call"),
    TELEGRAM("telegram"),
    FACEBOOK("facebook"),
    SETTINGS_ADD_BANK("settings_add_bank"),
    MOVE_TASK_TO_ARCHIVE("move_task_to_archive"),
    RESTORE_TASK("restore_task"),
    BANK_SESSION_EXPIRED_AUTHORIZATION("bank_session_expired_authorization"),
    BANK_SESSION_EXPIRED_SMS_REQUIRED("bank_session_expired_sms_required"),
    ACTIVE_TASKS("active_tasks");
    
    private final String screenName;

    private h(String str) {
        this.screenName = str;
    }

    public final String a() {
        return this.screenName;
    }
}
