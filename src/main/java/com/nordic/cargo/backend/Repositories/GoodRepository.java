package com.nordic.cargo.backend.Repositories;

import com.nordic.cargo.backend.Common.Utils.GoodState;
import com.nordic.cargo.backend.Model.GoodModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GoodRepository extends JpaRepository<GoodModel, Integer> {
    Optional<List<GoodModel>> findByNature(String nature);
    Optional<List<GoodModel>> findByState(GoodState state);
    Optional<List<GoodModel>> findByNatureAndState(String nature, GoodState state);
    Optional<List<GoodModel>> findBySenderEmail(String senderEmail);
    Optional<List<GoodModel>> findByReceiverEmail(String receiverEmail);
}
