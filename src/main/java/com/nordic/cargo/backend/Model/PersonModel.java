package com.nordic.cargo.backend.Model;


import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Data
public class PersonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String email;

    private  String firstName;
    private String middleName;
    private String lastName;

    @NotNull
    private String primaryAddress;

    @NotNull
    private String city;

    private String state;

    @NotNull
    private String country;

    @NotNull
    private String zipCode;

    @NotNull
    private String phoneNumber;



    private  String faxNumber;
    private String secondaryAddress;
    private List<String> languages;
    private String vat;
    private Integer serviceCount = 0;
}
