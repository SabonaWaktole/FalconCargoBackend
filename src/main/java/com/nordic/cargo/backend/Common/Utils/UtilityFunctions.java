package com.nordic.cargo.backend.Common.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nordic.cargo.backend.Model.GoodModel;
import com.nordic.cargo.backend.Model.PersonModel;

import java.util.Arrays;

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
        return "<tr><td>Email</td><td>" + p.getEmail() + "</td></tr>"
                + "<tr><td>First Name</td><td>" + p.getFirstName() + "</td></tr>"
                + "<tr><td>Last Name</td><td>" + p.getLastName() + "</td></tr>"
                + "<tr><td>Address</td><td>" + p.getPrimaryAddress() + "</td></tr>"
                + "<tr><td>City</td><td>" + p.getCity() + "</td></tr>"
                + "<tr><td>Country</td><td>" + p.getCountry() + "</td></tr>"
                + "<tr><td>Service Count</td><td>" + p.getServiceCount() + "</td></tr>";
    }

    public static String goodModelToTableRows(GoodModel g) {
        return "<tr><td>Name</td><td>" + g.getName() + "</td></tr>"
                + "<tr><td>Weight</td><td>" + g.getWeight() + "</td></tr>"
                + "<tr><td>Volume</td><td>" + g.getVolume() + "</td></tr>"
                + "<tr><td>Pieces</td><td>" + g.getPieces() + "</td></tr>"
                + "<tr><td>Nature</td><td>" + g.getNature() + "</td></tr>"
                + "<tr><td>State</td><td>" + g.getState() + "</td></tr>";
    }
}
