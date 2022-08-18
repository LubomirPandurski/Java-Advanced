package com.company;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> chemicals = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String [] data = scanner.nextLine().split(" ");
            for (String datum : data) {
                if (!chemicals.contains(datum)) {
                    chemicals.add(datum);
                }
            }
        }
        for(String print : chemicals){
            System.out.print(print + " ");
        }
    }
}
