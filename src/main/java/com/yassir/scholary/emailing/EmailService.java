package com.yassir.scholary.emailing;

import com.yassir.scholary.reporting.ReportingService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;
import java.io.IOException;

@Service
public class EmailService {

    private ReportingService reportingService;
    private EmailFactory emailFactory;

    public EmailService(ReportingService reportingService, EmailFactory emailFactory) {
        this.reportingService = reportingService;
        this.emailFactory = emailFactory;
    }

    public boolean sendEmailFromTemplate() {
        return true;
    }

    void sendSimpleEmail() {
        String to = "khaldi.yass@gmail.com";
        String subject = "Simple Email testing from spring boot app";
        String text = "this a simple body Hello world.";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        JavaMailSender emailSender = emailFactory.getJavaMailSender();
        emailSender.send(message);
    }

    void sendMessageWithAttachment() throws MessagingException, IOException, JRException {
        String to = "khaldi.yass@gmail.com";
        String subject = "Email testing from spring boot app";
        String text = "this a simple body Hello world.";
        JavaMailSender emailSender = emailFactory.getJavaMailSender();
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text);

        byte[] pdfData = reportingService.generatePDF();
        ByteArrayDataSource attachment = new ByteArrayDataSource(pdfData, "application/octet-stream");
        helper.addAttachment("PDFData.pdf", attachment);
        emailSender.send(message);
    }

}
