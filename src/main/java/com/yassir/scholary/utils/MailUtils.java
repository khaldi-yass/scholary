package com.yassir.scholary.utils;

public final class MailUtils {

    private MailUtils() {
    }

    public static final class Constants {

        public static final String MAIL_HOST = "spring.mail.host";
        public static final String MAIL_PORT = "spring.mail.port";
        public static final String MAIL_USER = "spring.mail.username";
        public static final String MAIL_PASS = "spring.mail.password";
        public static final String MAIL_AUTH = "mail.smtp.auth";
        public static final String MAIL_TLS = "mail.smtp.starttls.enable";
        public static final String MAIL_PROTOCOL = "spring.mail.protocol";
        public static final String PROPERTIES = "spring.mail.properties.";
    }
}
