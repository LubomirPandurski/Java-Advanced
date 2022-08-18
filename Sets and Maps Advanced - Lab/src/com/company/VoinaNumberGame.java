package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> firstPlayerCards = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondPlayerCards = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        int firstNumber = 0;
        int secondNumber = 0;
        for (int i = 0; i < 50; i++) {
            Iterator<Integer> firstIterator = firstPlayerCards.iterator();
            firstNumber = firstIterator.next();
            firstIterator.remove();

            Iterator<Integer> secondIterator = secondPlayerCards.iterator();
            secondNumber = secondIterator.next();
            secondIterator.remove();

            if(secondNumber>firstNumber){
                secondPlayerCards.add(firstNumber);
                secondPlayerCards.add(secondNumber);
            }
            else if(firstNumber>secondNumber){
                firstPlayerCards.add(firstNumber);
                firstPlayerCards.add(secondNumber);
            }
        }
        if(firstPlayerCards.size()==secondPlayerCards.size()){
            System.out.println("Draw!");
        }
        else if(firstPlayerCards.size()>secondPlayerCards.size()){
            System.out.println("First player win!");
        }
        else if(secondPlayerCards.size()>firstPlayerCards.size()){
            System.out.println("Second player win!");
        }
    }

    private static Set<Integer> getPlayerNumbers() {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> cards = new LinkedHashSet<>();
        int [] data;
        for (int i = 0; i < 20; i++) {
            data = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            cards.add(data[i]);
        }
        return cards;
    }
}
