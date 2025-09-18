package com.nordic.cargo.backend.Service;

import com.nordic.cargo.backend.Common.Utils.GoodState;
import com.nordic.cargo.backend.Repositories.GoodRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GoodService {
    private final GoodRepository goodRepository;

    public  GoodService(GoodRepository goodRepository) {
        this.goodRepository = goodRepository;
    }

    public ResponseEntity<?> findGoodById(Integer id) {
        return goodRepository.findById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Good with ID " + id + " not found"));
    }

    public  ResponseEntity<?> findAllGoods() {
        return ResponseEntity.ok(goodRepository.findAll());
    }

    public ResponseEntity<?> findGoodByNature(String nature) {
        return ResponseEntity.ok(goodRepository.findByNature(nature));
    }

    public ResponseEntity<?> findGoodByState(GoodState state) {
        return ResponseEntity.ok(goodRepository.findByState(state));
    }

    public  ResponseEntity<?> findGoodByNatureAndState(String nature, GoodState state) {
        return ResponseEntity.ok(goodRepository.findByNatureAndState(nature, state));
    }

    public ResponseEntity<?> findGoodBySenderEmail(String senderEmail) {
        return  ResponseEntity.ok(goodRepository.findBySenderEmail(senderEmail));
    }

    public  ResponseEntity<?> findGoodByReceiverEmail(String receiverEmail) {
        return  ResponseEntity.ok(goodRepository.findByReceiverEmail(receiverEmail));
    }

}
