package com.company;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> parking = new LinkedHashSet<>();
        while(true){
            String input = scanner.nextLine();
            if(input.equals("END")){
                break;
            }
            else{
                String [] data = input.split(", ");
                if(data[0].equals("IN")){
                    parking.add(data[1]);
                }
                else if(data[0].equals("OUT")){
                    parking.remove(data[1]);
                }
            }
        }
        if(parking.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }
        else{
            for (String lot:parking) {
                System.out.println(lot);
            }
        }
    }
}
