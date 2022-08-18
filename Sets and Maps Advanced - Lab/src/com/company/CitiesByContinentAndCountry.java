package com.company;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        Map<String, LinkedHashMap<String, ArrayList<String>>> towns = new LinkedHashMap<>();

        while (count-->0){
            String [] data = scanner.nextLine().split(" ");

            String continent = data[0];
            String country = data[1];
            String city = data[2];

            if(!towns.containsKey(data[0])){
                towns.put(continent, new LinkedHashMap<>(){{put(country, new ArrayList<>(){{add(city);}});}});
            }
            else{
                if(towns.get(continent).containsKey(country)){
                    towns.get(continent).put(country, new ArrayList<>(){{add(city);}});
                }
                else{
                    towns.get(continent).get(country).add(city);
                }
            }
        }
        towns.forEach((k, v) -> {
                System.out.printf("%s:%n", k);
                v.forEach((k1,v1) -> System.out.printf("  %s -> %s",k1, v1));


                 //v.forEach(v1 -> System.out.printf("%s ", v1));
            });

    }
}
