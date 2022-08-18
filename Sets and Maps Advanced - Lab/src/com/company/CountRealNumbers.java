package com.company;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] data = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        Map<Double, Integer> valueList = new LinkedHashMap<>();
        for(double value:data){
            if(!valueList.containsKey(value)){
                valueList.put(value, 1);
            }
            else{
                valueList.put(value,valueList.get(value) + 1);
            }
        }
        for (Double key: valueList.keySet()){
            System.out.println(String.format("%.1f -> %d", key, valueList.get(key)));
        }
    }
}
