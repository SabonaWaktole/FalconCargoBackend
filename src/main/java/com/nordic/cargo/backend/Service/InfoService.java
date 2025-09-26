package com.nordic.cargo.backend.Service;

import com.nordic.cargo.backend.Common.Responses.ApiResponse;
import com.nordic.cargo.backend.Common.Services.EmailService;
import com.nordic.cargo.backend.Model.GoodModel;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.nordic.cargo.backend.Common.Utils.UtilityFunctions.goodModelToTableRows;
import static com.nordic.cargo.backend.Common.Utils.UtilityFunctions.personModelToTableRows;

@AllArgsConstructor
@Service
public class InfoService {
    private final EmailService emailService;
    private final PersonService personService;
    private final GoodService goodService;


    public ResponseEntity<?> sendEmail(String to, String subject, ApiResponse response) {

        try {
            String shipperTable = personModelToTableRows(response.getShipper());
            String consigneeTable = personModelToTableRows(response.getConsignee());
            String goodTable = goodModelToTableRows(response.getGood());


            //TODO MAKE THE EMAIL TO BE SENT TO THE SHIPPER AND CONSIGNEE ALSO

            emailService.sendHtmlEmailTOColleague(
                    to,
                    "Shipment Details",
                    shipperTable,
                    consigneeTable,
                    goodTable
            );

            emailService.sendHtmlEmailTOCostumer(
                    response.getShipper().getEmail(),
                    "Shipment Details",
                    shipperTable,
                    consigneeTable,
                    goodTable
            );

            emailService.sendHtmlEmailTOCostumer(
                    response.getConsignee().getEmail(),
                    "Shipment Details",
                    shipperTable,
                    consigneeTable,
                    goodTable
            );


            personService.addNewCustomer(response.getShipper());
            personService.addNewCustomer(response.getConsignee());
            goodService.addGood(response.getGood());
            personService.increaseServiceCount(response.getShipper().getEmail());
            personService.increaseServiceCount(response.getConsignee().getEmail());


            Map<String, String> success = new HashMap<>();
            success.put("message", "Email sent successfully");
            return ResponseEntity.ok(success);


        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }


    }

}
