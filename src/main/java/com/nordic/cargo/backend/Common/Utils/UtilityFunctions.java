package com.nordic.cargo.backend.Common.Utils;

public class UtilityFunctions {
    public static double volumeCalculator(double length, double width, double height){
        return length * width * height;
    }
    public static double densityCalculator(double volume, double weight){
        return  volume / weight;
    }


}
