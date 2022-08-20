package com.CarConstructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int carsCount = Integer.parseInt(scanner.nextLine());
        carConstructor car;
        while (carsCount-->0){
            String[] tokens = scanner.nextLine().split(" ");

            String brand = tokens[0];
            if(tokens.length == 1){
                car = new carConstructor(brand);
            }
            else{
                String model = tokens[1];
                int horsePower = Integer.parseInt(tokens[2]);
                car = new carConstructor(brand, model, horsePower);
            }
            System.out.println(car.carInfo());
        }


    }
}
