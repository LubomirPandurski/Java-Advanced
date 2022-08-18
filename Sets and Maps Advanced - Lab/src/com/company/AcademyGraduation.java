package com.company;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Double> graduationList = new TreeMap<>();

        double average = 0;
        while(n-->0){
            String name = scanner.nextLine();
            double [] scores = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            for (double score : scores) {
                average += score;
            }
            average /= scores.length;

            graduationList.put(name, average);
            average = 0;
        }
        graduationList.forEach((k,v) -> {
            System.out.println(k + " is graduated with " + v);
        });
    }
}
