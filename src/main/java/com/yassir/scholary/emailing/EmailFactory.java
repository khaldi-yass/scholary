package com.yassir.scholary.emailing;

import com.yassir.scholary.utils.MailUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class EmailFactory {

    @Value("${" + MailUtils.Constants.MAIL_HOST + "}")
    private String host;
    @Value("${" + MailUtils.Constants.MAIL_PORT + "}")
    private int port;
    @Value("${" + MailUtils.Constants.MAIL_USER + "}")
    private String username;
    @Value("${" + MailUtils.Constants.MAIL_PASS + "}")
    private String password;
    @Value("${" + MailUtils.Constants.PROPERTIES + MailUtils.Constants.MAIL_AUTH + "}")
    private boolean smtpAuth;
    @Value("${" + MailUtils.Constants.PROPERTIES + MailUtils.Constants.MAIL_TLS + "}")
    private boolean smtpStarttls;
    @Value("${" + MailUtils.Constants.MAIL_PROTOCOL + "}")
    private String protocol;

    private JavaMailSenderImpl mailSender;

    JavaMailSender getJavaMailSender() {
        if (mailSender != null) {
            return this.mailSender;
        }

        mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);
        mailSender.setProtocol(protocol);

        Properties props = mailSender.getJavaMailProperties();
        props.put(MailUtils.Constants.MAIL_AUTH, smtpAuth);
        props.put(MailUtils.Constants.MAIL_TLS, smtpStarttls);
        mailSender.setJavaMailProperties(props);
        return mailSender;
    }
}
