package com.nordic.cargo.backend.Repositories;

import com.nordic.cargo.backend.Model.GoodModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodRepository extends JpaRepository<GoodModel, Integer> {
}
