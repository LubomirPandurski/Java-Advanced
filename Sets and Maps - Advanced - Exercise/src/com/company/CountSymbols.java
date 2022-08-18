package com.company;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Map<Character, Integer> data = new TreeMap<>();

        int count = 1;
        ;
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            data.putIfAbsent(symbol, count);
            if(data.containsKey())
            System.out.printf();
        }
    }
}
