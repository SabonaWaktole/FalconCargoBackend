package com.nordic.cargo.backend.Service;

import com.nordic.cargo.backend.Common.Constants.Constants;
import com.nordic.cargo.backend.Common.Responses.ApiResponse;
import com.nordic.cargo.backend.Common.Utils.EmailSender;
import com.nordic.cargo.backend.Model.InfoModel;
import com.nordic.cargo.backend.Repositories.InfoRepository;
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
    private final EmailSender emailSender;
    private final PersonService personService;
    private final GoodService goodService;
    private final InfoRepository infoRepository;



    public ResponseEntity<?> sendEmail(ApiResponse response) {

        try {
            String shipperTable = personModelToTableRows(response.getShipper());
            String consigneeTable = personModelToTableRows(response.getConsignee());
            String goodTable = goodModelToTableRows(response.getGood());



            emailSender.sendHtmlEmailTOColleague(
                    Constants.username,
                    "Shipment Details",
                    shipperTable,
                    consigneeTable,
                    goodTable
            );

            emailSender.sendHtmlEmailTOCostumer(
                    response.getShipper().getEmail(),
                    "Shipment Details",
                    shipperTable,
                    consigneeTable,
                    goodTable
            );

            emailSender.sendHtmlEmailTOCostumer(
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

    public ResponseEntity<?> contactUs(InfoModel infoModel){
        try{
            String senderEmail = infoModel.getSenderEmail();
            String subject = infoModel.getSubject();
            String senderMessage = infoModel.getMessage();
            String senderName = infoModel.getSenderName();

            System.out.println(Constants.username);
            emailSender.sendMessageToColleague(senderEmail, Constants.username,senderName, subject,senderMessage);
            Map<String, String> success = new HashMap<>();
            success.put("message", "Email sent successfully");
            infoRepository.save(infoModel); // Save information to repository
            return ResponseEntity.ok(success);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
