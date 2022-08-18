package com.company;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String guestList = scanner.nextLine();
        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();
        while(true){
            if(guestList.equals("PARTY")){
                break;
            }
            else{
                if(Character.isDigit(guestList.charAt(0))){
                    vip.add(guestList);
                }
                else{
                    regular.add(guestList);
                }
            }
            guestList = scanner.nextLine();
        }

        guestList = scanner.nextLine();
        while (true){
            if(guestList.equals("END")){
                break;
            }
            else{
                if(vip.contains(guestList)){
                    vip.remove(guestList);
                }
                else if(regular.contains(guestList)){
                    regular.remove(guestList);
                }
            }
            guestList = scanner.nextLine();
        }
        int notComingCount = vip.size() + regular.size();
        System.out.println(notComingCount);
        for(String guest : vip){
            System.out.println(guest);
        }
        for(String guest : regular){
            System.out.println(guest);
        }
    }
}
