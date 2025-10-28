package com.nordic.cargo.backend.Common.Utils;

import com.nordic.cargo.backend.Common.Constants.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmailSender {

    @Value("${BREVO_API_KEY}")
    private String brevoApiKey;

    private final RestTemplate restTemplate;

    public EmailSender() {
        this.restTemplate = new RestTemplate();
    }

    /**
     * Send HTML email to colleague via Brevo API
     */
    public boolean sendHtmlEmailToColleague(String to, String subject, String shipper, String consignee, String good) {
        String htmlBody = buildHtmlEmail("Colleague", shipper, consignee, good);
        return sendEmail(to, subject, htmlBody);
    }

    /**
     * Send HTML email to customer via Brevo API
     */
    public boolean sendHtmlEmailToCustomer(String to, String subject, String shipper, String consignee, String good) {
        String htmlBody = buildHtmlEmail("Customer", shipper, consignee, good);
        return sendEmail(to, subject, htmlBody);
    }

    /**
     * Send simple contact message to colleague
     */
    public boolean sendMessageToColleague(String from, String to, String name, String subject, String messageBody) {
        String htmlBody = "<div style='font-family: Arial, sans-serif; background-color:#f9f9f9; padding:20px;'>"
                + "<div style='max-width:700px; margin:auto; background:#ffffff; border-radius:8px; "
                + "box-shadow:0 4px 10px rgba(0,0,0,0.1); overflow:hidden;'>"
                + "<div style='background:linear-gradient(90deg, navy, orange); padding:20px; text-align:center;'>"
                + "<h1 style='color:white; margin:0;'>Nordic Cargo</h1>"
                + "<p style='color:gold; font-size:14px; margin:0;'>Your trusted logistics partner</p>"
                + "</div>"
                + "<div style='padding:25px; color:#333;'>"
                + "<p style='font-size:16px;'>Dear Nordic Cargo Team,</p>"
                + "<p style='font-size:14px; line-height:1.6;'>A customer has sent the following message:</p>"
                + "<div style='background-color:#f8f9fa; border-left:4px solid orange; padding:15px; margin:15px 0;'>"
                + "<p style='margin:0; font-style:italic;'>" + messageBody + "</p>"
                + "</div>"
                + "<p style='font-size:14px; line-height:1.6;'>Please reply to this message directly at: " + from + "</p>"
                + "<p style='font-size:14px; line-height:1.6;'>Thank you!</p>"
                + "<p style='font-size:14px; line-height:1.6;'>Best regards,<br>" + from + "</p>"
                + "</div>"
                + "<div style='background:#333; color:white; text-align:center; padding:15px; font-size:12px;'>"
                + "<p style='margin:0;'>This is an automated message. Please do not reply to this email.</p>"
                + "<p style='margin:5px 0 0 0;'>© 2025 Nordic Cargo. All Rights Reserved.</p>"
                + "</div>"
                + "</div></div>";

        return sendEmail(to, subject, htmlBody);
    }

    /**
     * Core method to send email via Brevo API
     */
    private boolean sendEmail(String to, String subject, String htmlBody) {
        try {
            String url = "https://api.brevo.com/v3/smtp/email";

            Map<String, Object> body = new HashMap<>();
            body.put("sender", Map.of("name", "Nordic Cargo", "email", Constants.username));
            body.put("to", List.of(Map.of("email", to)));
            body.put("subject", subject);
            body.put("htmlContent", htmlBody);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("api-key", brevoApiKey);

            HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

            ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
            return response.getStatusCode().is2xxSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Helper to build standard HTML email for shipment details
     */
    private String buildHtmlEmail(String recipientType, String shipper, String consignee, String good) {
        return "<div style='font-family: Arial, sans-serif; background-color:#f9f9f9; padding:20px;'>"
                + "<div style='max-width:700px; margin:auto; background:#ffffff; border-radius:8px; "
                + "box-shadow:0 4px 10px rgba(0,0,0,0.1); overflow:hidden;'>"
                + "<div style='background:linear-gradient(90deg, navy, orange); padding:20px; text-align:center;'>"
                + "<h1 style='color:white; margin:0;'>Nordic Cargo</h1>"
                + "<p style='color:gold; font-size:14px; margin:0;'>Your trusted logistics partner</p>"
                + "</div>"
                + "<div style='padding:20px; color:#333;'>"
                + "<p style='font-size:16px;'>Dear " + recipientType + ",</p>"
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
                + "<p style='font-size:14px;'>Thank you for working with <b style='color:navy;'>Nordic Cargo</b>!</p>"
                + "</div>"
                + "<div style='background:#333; color:white; text-align:center; padding:10px;'>"
                + "<p style='margin:0; font-size:12px;'>© 2025 Nordic Cargo. All Rights Reserved.</p>"
                + "</div>"
                + "</div></div>";
    }
}
