package com.nordic.cargo.backend.Repositories;

import com.nordic.cargo.backend.Model.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository  extends JpaRepository<PersonModel, Integer> {
    Optional<PersonModel> findByEmail(String email);
}