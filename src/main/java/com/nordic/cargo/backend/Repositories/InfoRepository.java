package com.nordic.cargo.backend.Repositories;

import com.nordic.cargo.backend.Model.InfoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoRepository extends JpaRepository <InfoModel, Integer> {
}
