package com.nordic.cargo.backend.Common.Services;

import com.nordic.cargo.backend.Common.Constants.Constants;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class EmailService {



    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendHtmlEmailTOColleague(String to, String subject, String shipper, String consignee, String good) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setFrom(Constants.username);

            // Build fancy HTML email
            String htmlBody = "<div style='font-family: Arial, sans-serif; background-color:#f9f9f9; padding:20px;'>"
                    + "<div style='max-width:700px; margin:auto; background:#ffffff; border-radius:8px; "
                    + "box-shadow:0 4px 10px rgba(0,0,0,0.1); overflow:hidden;'>"

                    // Header
                    + "<div style='background:linear-gradient(90deg, navy, orange); padding:20px; text-align:center;'>"
                    + "<h1 style='color:white; margin:0;'>Nordic Cargo</h1>"
                    + "<p style='color:gold; font-size:14px; margin:0;'>Your trusted logistics partner</p>"
                    + "</div>"

                    // Body content
                    + "<div style='padding:20px; color:#333;'>"
                    + "<p style='font-size:16px;'>Dear Colleague,</p>"
                    + "<p style='font-size:14px;'>Here are the shipment details:</p>"

                    + "<h3 style='color:navy; border-bottom:2px solid orange; padding-bottom:5px;'>Shipper Information</h3>"
                    + "<table style='border-collapse:collapse; width:100%; margin-bottom:15px; border:1px solid #ddd;'>"
                    + shipper
                    + "</table>"

                    + "<h3 style='color:orange; border-bottom:2px solid navy; padding-bottom:5px;'>Consignee Information</h3>"
                    + "<table style='border-collapse:collapse; width:100%; margin-bottom:15px; border:1px solid #ddd;'>"
                    + consignee
                    + "</table>"

                    + "<h3 style='color:#D4AF37; border-bottom:2px solid black; padding-bottom:5px;'>Good Information</h3>"
                    + "<table style='border-collapse:collapse; width:100%; margin-bottom:15px; border:1px solid #ddd;'>"
                    + good
                    + "</table>"

                    + "<p style='font-size:14px;'>Thank you for working with <b style='color:navy;'>Nordic Cargo</b>! "
                    + "We appreciate your loyalty to us.</p>"
                    + "</div>"

                    // Footer
                    + "<div style='background:#333; color:white; text-align:center; padding:10px;'>"
                    + "<p style='margin:0; font-size:12px;'>© 2025 Nordic Cargo. All Rights Reserved.</p>"
                    + "</div>"

                    + "</div></div>";

            helper.setText(htmlBody, true); // true = HTML

            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void sendHtmlEmailTOCostumer(String to, String subject, String shipper, String consignee, String good) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setFrom(Constants.username);

            // Build fancy HTML email
            String htmlBody = "<div style='font-family: Arial, sans-serif; background-color:#f9f9f9; padding:20px;'>"
                    + "<div style='max-width:700px; margin:auto; background:#ffffff; border-radius:8px; "
                    + "box-shadow:0 4px 10px rgba(0,0,0,0.1); overflow:hidden;'>"

                    // Header
                    + "<div style='background:linear-gradient(90deg, navy, orange); padding:20px; text-align:center;'>"
                    + "<h1 style='color:white; margin:0;'>Nordic Cargo</h1>"
                    + "<p style='color:gold; font-size:14px; margin:0;'>Your trusted logistics partner</p>"
                    + "</div>"

                    // Body content
                    + "<div style='padding:20px; color:#333;'>"
                    + "<p style='font-size:16px;'>Dear Costumer,</p>"
                    + "<p style='font-size:14px;'>Here are the shipment order details:</p>"

                    + "<h3 style='color:navy; border-bottom:2px solid orange; padding-bottom:5px;'>Shipper Information</h3>"
                    + "<table style='border-collapse:collapse; width:100%; margin-bottom:15px; border:1px solid #ddd;'>"
                    + shipper
                    + "</table>"

                    + "<h3 style='color:orange; border-bottom:2px solid navy; padding-bottom:5px;'>Consignee Information</h3>"
                    + "<table style='border-collapse:collapse; width:100%; margin-bottom:15px; border:1px solid #ddd;'>"
                    + consignee
                    + "</table>"

                    + "<h3 style='color:#D4AF37; border-bottom:2px solid black; padding-bottom:5px;'>Good Information</h3>"
                    + "<table style='border-collapse:collapse; width:100%; margin-bottom:15px; border:1px solid #ddd;'>"
                    + good
                    + "</table>"

                    + "<p style='font-size:14px;'>Thank you for choosing <b style='color:navy;'>Nordic Cargo</b>! "
                    + "We appreciate your trust in us.</p>"
                    + "</div>"

                    // Footer
                    + "<div style='background:#333; color:white; text-align:center; padding:10px;'>"
                    + "<p style='margin:0; font-size:12px;'>© 2025 Nordic Cargo. All Rights Reserved.</p>"
                    + "</div>"

                    + "</div></div>";

            helper.setText(htmlBody, true); // true = HTML

            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageToColleague(String from, String to, String subject, String messageBody) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setFrom(from);

            String htmlBody = "<div style='font-family: Arial, sans-serif; background-color:#f9f9f9; padding:20px;'>"
                    + "<div style='max-width:700px; margin:auto; background:#ffffff; border-radius:8px; "
                    + "box-shadow:0 4px 10px rgba(0,0,0,0.1); overflow:hidden;'>"

                    // Header
                    + "<div style='background:linear-gradient(90deg, navy, orange); padding:20px; text-align:center;'>"
                    + "<h1 style='color:white; margin:0;'>Nordic Cargo</h1>"
                    + "<p style='color:gold; font-size:14px; margin:0;'>Your trusted logistics partner</p>"
                    + "</div>"

                    // Body content
                    + "<div style='padding:25px; color:#333;'>"
                    + "<p style='font-size:16px;'>Dear Nordic Cargo Team,</p>"
                    + "<p style='font-size:14px; line-height:1.6;'>I hope this message finds you well. I am reaching out regarding the following matter:</p>"

                    + "<div style='background-color:#f8f9fa; border-left:4px solid orange; padding:15px; margin:15px 0;'>"
                    + "<p style='margin:0; font-style:italic;'>[Customer's message will appear here]</p>"
                    + "</div>"

                    + "<p style='font-size:14px; line-height:1.6;'>Please find the details of my inquiry below:</p>"

                    + "<div style='margin:20px 0;'>"
                    + "<h3 style='color:navy; border-bottom:2px solid orange; padding-bottom:5px;'>Contact Information</h3>"
                    + "<table style='width:100%; border-collapse:collapse;'>"
                    + "<tr><td style='padding:8px 0; width:120px; font-weight:bold;'>Full Name:</td><td>[Customer's Full Name]</td></tr>"
                    + "<tr><td style='padding:8px 0; font-weight:bold;'>Email:</td><td>[Customer's Email]</td></tr>"
                    + "<tr><td style='padding:8px 0; font-weight:bold;'>Phone:</td><td>[Customer's Phone]</td></tr>"
                    + "<tr><td style='padding:8px 0; font-weight:bold;'>Reference #:</td><td>[If applicable]</td></tr>"
                    + "</table>"
                    + "</div>"

                    + "<p style='font-size:14px; line-height:1.6;'>I would appreciate your prompt attention to this matter. Please let me know if you require any additional information.</p>"
                    + "<p style='font-size:14px; line-height:1.6;'>Thank you for your assistance.</p>"
                    + "<p style='font-size:14px; line-height:1.6;'>Best regards,<br>[Customer's Name]</p>"
                    + "</div>"

                    // Footer
                    + "<div style='background:#333; color:white; text-align:center; padding:15px; font-size:12px;'>"
                    + "<p style='margin:0;'>This is an automated message. Please do not reply to this email.</p>"
                    + "<p style='margin:5px 0 0 0;'>© 2025 Nordic Cargo. All Rights Reserved.</p>"
                    + "</div>"

                    + "</div></div>";

            helper.setText(htmlBody, true); // true = HTML

            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}
