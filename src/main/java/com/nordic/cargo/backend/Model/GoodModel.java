package com.nordic.cargo.backend.Model;

import com.nordic.cargo.backend.Common.Utils.GoodState;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class GoodModel {

    /**
     * Note all measurement follow metric style of measure gram, meter and second (g, m, s)
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private Double width;

    @NotNull
    private  Double height;

    @NotNull
    private Double length;

    @NotNull
    private  Double wight;

    @NotNull
    private String nature;

    @NotNull
    private GoodState state;

    @NotNull
    private Integer pieces;


}
