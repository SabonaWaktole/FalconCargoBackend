package com.nordic.cargo.backend.Controller;


import com.nordic.cargo.backend.Common.Utils.GoodState;
import com.nordic.cargo.backend.Model.GoodModel;
import com.nordic.cargo.backend.Service.GoodService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/goods")
public class GoodController {
    private final GoodService goodService;

    @PostMapping("/add")
    public ResponseEntity<?> addGood(@RequestBody GoodModel goodModel) {
        return goodService.addGood(goodModel);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllGoods() {
        return goodService.findAllGoods();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findGoodById(@PathVariable Integer id) {
        return goodService.findGoodById(id);
    }

    @GetMapping("/nature/{nature}")
    public ResponseEntity<?> findGoodByNature(@PathVariable String nature) {
        return goodService.findGoodByNature(nature);
    }

    @GetMapping("/state/{state}")
    public ResponseEntity<?> findGoodByState(@PathVariable GoodState state) {
        return goodService.findGoodByState(state);
    }

    @GetMapping("/nature/{nature}/state/{state}")
    public ResponseEntity<?> findGoodByNatureAndState(@PathVariable String nature, @PathVariable GoodState state) {
        return goodService.findGoodByNatureAndState(nature, state);
    }

    @GetMapping("/sender-email/{senderEmail}")
    public ResponseEntity<?> findGoodBySenderEmail(@PathVariable String senderEmail) {
        return goodService.findGoodBySenderEmail(senderEmail);
    }

    @GetMapping("/receiver-email/{receiverEmail}")
    public ResponseEntity<?> findGoodByReceiverEmail(@PathVariable String receiverEmail) {
        return goodService.findGoodByReceiverEmail(receiverEmail);
    }
}
