package com.nordic.cargo.backend.Controller;


import com.nordic.cargo.backend.Common.Responses.ApiResponse;
import com.nordic.cargo.backend.Model.InfoModel;
import com.nordic.cargo.backend.Service.InfoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("api/v1/info")
@RestController
@CrossOrigin(origins = "http://localhost:5173") // allow your frontend origin
public class InfoController {
    private final InfoService infoService;

    @PostMapping("/send-email")
    public ResponseEntity<?> sendEmail(@RequestBody ApiResponse response) {
        return infoService.sendEmail(response);
    }

    @PostMapping("contact-us")
    public ResponseEntity<?> contactUs(@RequestBody InfoModel infoModel){
        return infoService.contactUs(infoModel);
    }
}
