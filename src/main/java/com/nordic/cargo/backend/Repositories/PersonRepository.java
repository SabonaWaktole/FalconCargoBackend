package com.nordic.cargo.backend.Repositories;

import com.nordic.cargo.backend.Model.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository  extends JpaRepository<PersonModel, Integer> {
}