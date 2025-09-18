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

            String htmlBody = "<div style='font-family: Arial, sans-serif; color: #333;'>"
                    + "<p style='font-size: 16px;'>Dear Colleague,</p>"
                    + "<p style='font-size: 14px;'>Here are the shipment details:</p>"

                    + "<h3 style='color: #2E86C1;'>Shipper Information</h3>"
                    + "<table style='border-collapse: collapse; width: 100%; margin-bottom: 15px;'>"
                    + shipper
                    + "</table>"

                    + "<h3 style='color: #28B463;'>Consignee Information</h3>"
                    + "<table style='border-collapse: collapse; width: 100%; margin-bottom: 15px;'>"
                    + consignee
                    + "</table>"

                    + "<h3 style='color: #D68910;'>Good Information</h3>"
                    + "<table style='border-collapse: collapse; width: 100%; margin-bottom: 15px;'>"
                    + good
                    + "</table>"

                    + "<p style='font-size: 14px;'>Thank you for using <b>Nordic Cargo</b>!</p>"
                    + "</div>";

            helper.setText(htmlBody, true); // true = HTML

            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }



}
