package com.nordic.cargo.backend.Common.Services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${email.user}")
    private String username;

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendHtmlEmail(String to, String subject, String shipper, String consignee, String good) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setFrom(username);

            // Build HTML body
            String htmlBody = "<p>Dear Colleague,</p>"
                    + "<p>Here are the shipment details:</p>"

                    + "<h3>Shipper Information</h3>"
                    + "<table border='1' cellpadding='5' cellspacing='0'>"
                    + shipper
                    + "</table>"

                    + "<h3>Consignee Information</h3>"
                    + "<table border='1' cellpadding='5' cellspacing='0'>"
                    + consignee
                    + "</table>"

                    + "<h3>Good Information</h3>"
                    + "<table border='1' cellpadding='5' cellspacing='0'>"
                    + good
                    + "</table>"

                    + "<p>Thank you for using <b>Nordic Cargo</b>!</p>";

            helper.setText(htmlBody, true); // true = HTML

            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
