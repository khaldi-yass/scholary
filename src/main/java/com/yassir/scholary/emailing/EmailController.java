package com.yassir.scholary.emailing;

import net.sf.jasperreports.engine.JRException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
public class EmailController {

    private EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/sendemail")
    public String sendEmail() throws MessagingException, IOException, JRException {
        long start = System.currentTimeMillis();
        emailService.sendMessageWithAttachment();
        emailService.sendSimpleEmail();
        return "File generated in : " + (System.currentTimeMillis() - start) / 1000 + " s.";
    }
}
