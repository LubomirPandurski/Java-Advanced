package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();

        ArrayDeque<Integer> openIndexes = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char CurrentSymbol = expression.charAt(i);
            if(CurrentSymbol == '('){
                openIndexes.push(i);
            } else if(CurrentSymbol == ')') {
                int lastOpenIndex = openIndexes.pop();
                String matching = expression.substring(lastOpenIndex, i+ 1);
                System.out.println(matching);
            }
        }
    }
}
