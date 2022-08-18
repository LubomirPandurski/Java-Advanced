package com.company;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Double>> data = new TreeMap<>();

        String input = scanner.nextLine();



        while(!input.equals("Revision")){
            String[] arr = input.split(", ");

            String shop = arr[0];
            String product = arr[1];
            Double price = Double.valueOf(arr[2]);
            if(!data.containsKey(shop)){
                data.put(shop, new LinkedHashMap<>(){{put(product,price);}});
            }
            else{
                data.get(shop).put(product,price);
            }
            input = scanner.nextLine();
        }
        data.forEach((k, v) -> {
            if(v.size() !=0) {
                System.out.printf("%s->%n", k);
                v.forEach((k1,v1) -> System.out.printf("Product: %s, Price: %.1f%n",k1, v1));
            }
        });
    }
}
