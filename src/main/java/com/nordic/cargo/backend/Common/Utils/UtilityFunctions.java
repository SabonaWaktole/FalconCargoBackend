package com.nordic.cargo.backend.Common.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nordic.cargo.backend.Model.GoodModel;
import com.nordic.cargo.backend.Model.PersonModel;


public class UtilityFunctions {

    public static double volumeCalculator(double length, double width, double height){
        return length * width * height;
    }

    public static double densityCalculator(double volume, double weight){
        return  volume / weight;
    }

    public static String personModelToJson(PersonModel personModel) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(personModel);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static PersonModel jsonToPersonModel(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, PersonModel.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String goodModelToJson(GoodModel good) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(good);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static GoodModel jsonToGoodModel(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, GoodModel.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String personModelToTableRows(PersonModel p) {
        return "<tr style='background-color:#f2f2f2;'><td style='padding:8px; font-weight:bold; color:navy;'>Email</td><td style='padding:8px;'>" + p.getEmail() + "</td></tr>"
                + "<tr><td style='padding:8px; font-weight:bold; color:orange;'>First Name</td><td style='padding:8px;'>" + p.getFirstName() + "</td></tr>"
                + "<tr style='background-color:#f2f2f2;'><td style='padding:8px; font-weight:bold; color:gold;'>Last Name</td><td style='padding:8px;'>" + p.getLastName() + "</td></tr>"
                + "<tr><td style='padding:8px; font-weight:bold; color:black;'>Address</td><td style='padding:8px;'>" + p.getPrimaryAddress() + "</td></tr>"
                + "<tr style='background-color:#f2f2f2;'><td style='padding:8px; font-weight:bold; color:navy;'>City</td><td style='padding:8px;'>" + p.getCity() + "</td></tr>"
                + "<tr><td style='padding:8px; font-weight:bold; color:orange;'>Country</td><td style='padding:8px;'>" + p.getCountry() + "</td></tr>"
                + "<tr style='background-color:#f2f2f2;'><td style='padding:8px; font-weight:bold; color:gold;'>Service Count</td><td style='padding:8px;'>" + p.getServiceCount() + "</td></tr>";
    }

    public static String goodModelToTableRows(GoodModel g) {
        return "<tr style='background-color:#fafafa;'><td style='padding:8px; font-weight:bold; color:navy;'>Name</td><td style='padding:8px;'>" + g.getName() + "</td></tr>"
                + "<tr><td style='padding:8px; font-weight:bold; color:orange;'>Weight</td><td style='padding:8px;'>" + g.getWeight() + "</td></tr>"
                + "<tr style='background-color:#fafafa;'><td style='padding:8px; font-weight:bold; color:gold;'>Volume</td><td style='padding:8px;'>" + g.getVolume() + "</td></tr>"
                + "<tr><td style='padding:8px; font-weight:bold; color:black;'>Pieces</td><td style='padding:8px;'>" + g.getPieces() + "</td></tr>"
                + "<tr style='background-color:#fafafa;'><td style='padding:8px; font-weight:bold; color:navy;'>Nature</td><td style='padding:8px;'>" + g.getNature() + "</td></tr>"
                + "<tr><td style='padding:8px; font-weight:bold; color:orange;'>State</td><td style='padding:8px;'>" + g.getState() + "</td></tr>";
    }
}
