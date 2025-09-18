package com.nordic.cargo.backend.Service;

import com.nordic.cargo.backend.Common.Responses.ApiResponse;
import com.nordic.cargo.backend.Common.Services.EmailService;

import static com.nordic.cargo.backend.Common.Utils.UtilityFunctions.goodModelToTableRows;
import static com.nordic.cargo.backend.Common.Utils.UtilityFunctions.personModelToTableRows;

public class InfoService {
    private final EmailService emailService;

    public InfoService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendEmail(String to, String subject, ApiResponse response) {

        String shipperTable = personModelToTableRows(response.getShipper());
        String consigneeTable = personModelToTableRows(response.getConsignee());
        String goodTable = goodModelToTableRows(response.getGood());

        emailService.sendHtmlEmail(
                to,
                "Shipment Details",
                shipperTable,
                consigneeTable,
                goodTable
        );

    }

}
