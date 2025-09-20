package com.nordic.cargo.backend.Controller;


import com.nordic.cargo.backend.Common.Responses.ApiResponse;
import com.nordic.cargo.backend.Service.InfoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("api/v1/info")
@RestController
public class InfoController {
    private final InfoService infoService;

    @PostMapping("/send-email")
    public ResponseEntity<String> sendEmail(@RequestBody ApiResponse response) {
        String to = "sabona.waktole@astu.edu.et"; // or however you store recipient email
        String subject = "Shipment Details"; // or from request if dynamic

        infoService.sendEmail(to, subject, response);

        return ResponseEntity.ok("Email sent successfully");
    }

}
