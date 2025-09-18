package com.nordic.cargo.backend.Common.Responses;

import com.nordic.cargo.backend.Common.Utils.GoodState;
import com.nordic.cargo.backend.Model.GoodModel;
import com.nordic.cargo.backend.Model.PersonModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Setter
@Getter
public class ApiResponse {
   private GoodModel good;
   private PersonModel shipper;
   private PersonModel consignee;
}
