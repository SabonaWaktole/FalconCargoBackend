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

    @NotNull
    private  String firstName;

    private String middleName;

    @NotNull
    private String lastName;

    @NotNull
    private String primaryAddress;

    @NotNull
    private String city;

    @NotNull
    private String state;

    @NotNull
    private String country;



    @NotNull
    private String phoneNumber;



    private  String faxNumber;
    private String zipCode;
    private String secondaryAddress;
    private List<String> languages;
    private String vat;
    private Integer serviceCount = 0;
}
